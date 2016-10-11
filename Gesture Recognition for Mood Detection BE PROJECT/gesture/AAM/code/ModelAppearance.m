function [a_height, a_width, nchannels, A0, a_eig_n, A, Range_appearance_proj_param, warp_table, Mesh] = ModelAppearance(samples_dir, S0, downscale, zip_ratio)
% ModelAppearance - Model Appearance
% [a_height, a_width, nchannels, A0, a_eig_n, A, Range_appearance_proj_param, warp_table, Mesh] = ModelAppearance(samples_dir, S0, downscale, zip_ratio)
%
% samples_dir is the directory of samples where bmp files and their corresponding ASF files are existed | char array
% S0 is the mean shape after applying PCA to shapes | a [v_n*2, 1] matrix
% downscale is how many times to downsample | a double variable
% zip_ratio is the accuracy of shape PCA | a double variable range in (0,1)
% a_height, a_width are the height and width of the base appearance A0
% nchannels is the color channels of the sample images | a double variable 1 or 3
% A0 is the base appearance of the appearance model | a [a_height*a_width, 1, nchannels] matrix
% a_eig_n is the number of the appearance's principal components
% A is the appearance vectors | a [a_height*a_width, a_eig_n, nchannels] matrix
% Range_appearance_proj_param is the appearance parameters' range according to samples | a [a_eig_n, 2] matrix
% warp_table is the warp table for warp to S0 | a [How_many_pixels_in_the_mean_shape, 6] matrix
% Mesh is the shape mesh for S0 | a [How_many_triangles_in_the_mean_shape_mesh, 3] matrix

% WANG Lei, CG&CV Lab, Hunan University, Changsha
% $Id: ModelAppearance.m, v 1.0 2004-4-22 15:54 Lei$

% get some initial information
files = dir([samples_dir , '\*.bmp']);
f_bmp = [samples_dir '\' files(1).name];
%%%%%%%
%% we only support gray image for debug purpose
imsample = imread(f_bmp);
if size(imsample,3)==3
    imsample = rgb2gray(imsample);
end
%%%%%%%
Fnum = size( files, 1 );
i_height = round(size(imsample, 1) / downscale);
i_width  = round(size(imsample, 2) / downscale);
nchannels = size( imsample, 3 );

% get the warp table for warping into S0 
[ warp_table, Mesh, a_height, a_width ] = GetWarpTable(S0, i_height, i_width);   
         
% warps the samples into S0
	% create the warped image matrix
	Warp_images = zeros(a_height*a_width, Fnum, nchannels);
	fprintf(1, '将要根据mean_shape对%d个样本进行采样,请耐心等待...\n', Fnum);
	% warp the samples
	for i = 1:Fnum
	             f_bmp = [samples_dir '\' files(i).name];
                 f_asf = strrep(f_bmp, 'bmp', 'asf');
                 %%%%%%%%% we only support gray image for debug purpose
                 imtemp = imread(f_bmp);
                 if size(imtemp,3)==3
                     imtemp = rgb2gray(imtemp);
                 end
                 current_image = double(imresize(imtemp,1/downscale, 'bicubic'));      % downscale using bicubic spline interp
	             current_shape = readasf(f_asf) / downscale;
	             
                 % transform current_shape to current_image frame
                 v_n = size( current_shape, 1 ) / 2;
                 current_shape = reshape( current_shape, v_n, 2 );
                                  
	             Warp_images(:,i,:) = Piecewise_Warp(current_shape, current_image, nchannels, warp_table, Mesh, a_height, a_width );
	             fprintf(1, '    完成对样本%d的采样\n', i);
	end    
	
% Normalize the warped images
% fprintf(1, '完成采样,将要对采样得到的图像进行归一化处理,请耐心等待...\n');
% Warp_images = NormalizeWarpImages( Warp_images, nchannels );
% fprintf(1, '完成图像归一化处理...\n');

% Apply PCA to the warped images
	% transform the warped images matrix to single channel(sc) in order to do PCA
	Warp_images_sc = zeros( a_height*a_width*nchannels, Fnum );
	for i=1:nchannels
	            Warp_images_sc((i-1)*a_height*a_width+1:i*a_height*a_width, :) = Warp_images(:,:,i);
	end
	% do PCA
	[A_sc, Vals, A0_sc] = PCA( Warp_images_sc, zip_ratio );
	a_eig_n = size( A_sc, 2 );
	% transform the warped images back to multi-channels
	A = zeros( a_height*a_width, a_eig_n, nchannels );
	A0 = zeros( a_height*a_width, 1, nchannels );
	for i=1:nchannels
             A(:,:,i) = A_sc((i-1)*a_height*a_width+1:i*a_height*a_width, :);
             A0(:,:,i) = A0_sc((i-1)*a_height*a_width+1:i*a_height*a_width, :);
    end
% Get the appearance parameters' range according to samples
	proj_paras = zeros(a_eig_n, Fnum);  
	for i=1:Fnum
    	    ca = Warp_images_sc(:,i);
    	    % - project the sample appearances to the Vecs
            proj_paras(:,i) = A_sc'*(ca - A0_sc);
	end
	Range_appearance_proj_param = zeros(a_eig_n, 2);
	Range_appearance_proj_param(:,1) = min(proj_paras, [], 2);
	Range_appearance_proj_param(:,2) = max(proj_paras, [], 2);

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

function [ warp_table, Mesh, a_height, a_width ] = GetWarpTable(S0, i_height, i_width)

mean_shape = S0;
image_height = i_height;
image_width  = i_width;

%-reshape the mean shape to a matrix
numberOfpoints = size( mean_shape, 1) / 2;
mean_shape = reshape(mean_shape, numberOfpoints, 2);

%-将mean_shape覆盖区域的左上端点作为新坐标原点
top_left = min(mean_shape);
mean_shape(:,1) = mean_shape(:,1) - top_left(:,1);
mean_shape(:,2) = mean_shape(:,2) - top_left(:,2);
mean_shape = double(int32(mean_shape)) + 1;

%-根据mean_shape覆盖区域的width和height制作同尺寸的bounding_image
dim = double(max(mean_shape)) - double(min(mean_shape)) + 1 ;
bounding_image = zeros(dim(:,2), dim(:,1));

%-对mean_shape进行delaunay trianglation
mean_shape_mesh = delaunay(mean_shape(:,1), mean_shape(:,2));

%-初始化一个heighth*width行6列的warp_talbe
warp_talbe = zeros(dim(:,1)*dim(:,2), 6);

%-对每对(i, j)调用函数LocateInMesh(mean_shape, mean_shape_mesh, px, py)
fprintf(1, '\n开始构建warp_table,可能要几分钟时间,请耐心等待...\n');
counter = 0;
pixel_total = dim(:,2)*dim(:,1);
for i = 1:dim(:,2)
    for j = 1:dim(:,1)
       [is alpha beta gamma triangle] = LocateInMesh(mean_shape, mean_shape_mesh, j, i);
       if is==1
           counter = counter + 1;
           warp_table(counter, :) = [i j triangle alpha beta gamma];
       end
    end
     fprintf(1, '已命中%d/最多%d\n', counter,pixel_total); % for debug show
end

% 最后根据计数器数值, 收缩warp_table
warp_table = warp_table(1:counter, :);

Mesh = mean_shape_mesh;
a_height = size(bounding_image, 1);
a_width  = size(bounding_image, 2);


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

function [is,alpha,beta,gamma,triangle] = LocateInMesh(mean_shape, mean_shape_mesh, px, py)
numOftriangle = size(mean_shape_mesh, 1);
is = 0;
for i = 1:numOftriangle
    v1 = mean_shape(mean_shape_mesh(i, 1), :);
    v2 = mean_shape(mean_shape_mesh(i, 2), :);
    v3 = mean_shape(mean_shape_mesh(i, 3), :);
    [is,alpha,beta,gamma] = LocateInTriangle(v1, v2, v3, px, py);
    if is==1
        break;
    end
end
triangle = i;

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

function [is,alpha,beta,gamma] = LocateInTriangle(v1, v2, v3, px, py)   
x1 = v1(:,1); x2 = v2(:,1); x3 = v3(:,1);
y1 = v1(:,2); y2 = v2(:,2); y3 = v3(:,2);
vx = [x1 x2 x3]';
vy = [y1 y2 y3]';
x = px; y = py;

alpha = 0; beta = 0; gamma = 0;is = 0;
if ( (px < min(vx)) || (px > max(vx)) || (py < min(vy)) || (py > max(vy)) )    
    return;
end
denominator = -x2*y3+x2*y1+x1*y3+x3*y2-x3*y1-x1*y2;
alpha = (-y*x3+y3*x-x*y2+x2*y-x2*y3+x3*y2)/denominator;
beta  = (y*x3-x1*y-x3*y1-y3*x+x1*y3+x*y1)/denominator;
gamma = (x*y2-x*y1-x1*y2-x2*y+x2*y1+x1*y)/denominator;
if ((alpha>=0) && (alpha <=1) && (beta >=0) && (beta <=1) && (gamma>=0) && (gamma<=1))
    is = 1;
end

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

function normalized_warp_images = NormalizeWarpImages( warp_images, nchannels )
mean_image = warp_images(:,1,:);
mean_iamge = ZeroMeanUnitLength(nchannels, mean_image, true);
iter = 0; diff = 1e306;
while (diff > 1e-5 && iter < 10)
    last_mean_estimate = mean_image;
    for i = 1:size(warp_images,2)
        warp_images(:,i,:) = NormalizeOneWarpImage(nchannels, warp_images(:,i,:), mean_image);
    end
    % recalculate the mean image
    mean_image = sum(warp_images, 2) / size(warp_images,2);
    mean_image = ZeroMeanUnitLength(nchannels, mean_image, true);
    % test if the mean estimate has converged
    diff = max(sqrt(sum( (mean_image - last_mean_estimate).^2 )));
    iter = iter + 1;
    fprintf(1, '    完成第%d次迭代%f...\n', iter, diff);
end

% individually map the normalized image vector back to 0~255
for i = 1:size(warp_images,2)
    imv = warp_images(:,i,:);
    mini = min(min(min(imv)));
    maxi = max(max(max(imv))); 
    imv = imv - mini;
    imv = imv / (maxi - mini) * 255;
     warp_images(:,i,:) = imv;
end
normalized_warp_images = warp_images ;

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

function normalized_warp_image = NormalizeOneWarpImage( nchannels, warp_image, mean_image )
warp_image = ZeroMeanUnitLength(nchannels, warp_image, false);
dp = sum(warp_image .* mean_image);
if dp ~= 0
    for i=1:nchannels
        normalized_warp_image(:,:,i) = warp_image(:,:,i) / dp(:,:,i);
    end
else
    normalized_warp_image = 0;
    fprintf(1, '\nError! tried to normalize a zero texture vector\n');
end

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

function v = ZeroMeanUnitLength( nchannels, VectorFromWarpImages, ifToUnitLength )
m = mean(VectorFromWarpImages);
for i=1:nchannels
    VectorFromWarpImages(:,:,i) = VectorFromWarpImages(:,:,i) - m(:,:,i);
end
if ifToUnitLength == true
    s = sum(VectorFromWarpImages.*VectorFromWarpImages);
    a = 1/sqrt(s);
    for i=1:nchannels
        VectorFromWarpImages(:,:,i) = VectorFromWarpImages(:,:,i) * a(:,:,i);
    end
end
v = VectorFromWarpImages;