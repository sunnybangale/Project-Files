function Warped_image = Piecewise_Warp(current_shape, current_image, nchannels, warp_table, Mesh, a_height, a_width )
% Piecewise_Warp - Do piecewise warp from the I0(region of the current_image under current_shape ) to the I(region defined by Mesh and warp_table with the dimension a_height and a_width,)
% Warped_image = Piecewise_Warp(current_shape, current_image, nchannels, warp_table, Mesh, a_height, a_width )
%
% current_shape is the shape of the current image | a [How_many_vertices_in_shape*2, 1] matrix
% current_image is the target image | a [image_height, image_width, nchannels] matrix
% nchannels is the number of color channels in current_image  | 1 or 3
% warp_table is the warp table determined by the mean shape and the size of the sample image | a [How_many_pixels_in_the_mean_shape, 6] matrix, in each row there are px, py, triangle, alpha, beta, gamma
% Mesh represents the triangles in the shape mesh |  a [How_many_triangles_in_the_mean_shape_mesh, 3] matrix
% a_height, a_width is the height and width of the base appearance A0
% Warped_image is the warp result | a [a_height*a_width, 1, nchannels] matrix

% WANG Lei, CG&CV Lab, Hunan University, Changsha
% $Id: Piecewise_Warp.m, v 1.0 2004-4-22 15:54 Lei$

% allocate a matrix to contain the result data
sample_image = zeros(a_height, a_width, nchannels);

%-Do warping according to warp table
for i=1:size(warp_table,1)
    triangle = warp_table(i, 3);
    alpha = warp_table(i, 4);
    beta  = warp_table(i, 5);
    gamma = warp_table(i, 6);
    v1 = current_shape(Mesh(triangle,1) ,:);
    v2 = current_shape(Mesh(triangle,2) ,:);
    v3 = current_shape(Mesh(triangle,3) ,:);
    
    [x,y] = AlphaBetaGammaToXY(alpha, beta, gamma, v1, v2, v3);
    
    r = BilinearSample(x, y, current_image, nchannels);
    
    s_i = warp_table(i, 1);
    s_j = warp_table(i, 2);
    
    for i=1:nchannels
	    sample_image(s_i, s_j, i) = r(1, i);	    
    end
       
end

%- Transform the result to a column vector.
Warped_image = reshape(sample_image, a_height*a_width, 1, nchannels);

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

function [x,y] = AlphaBetaGammaToXY(alpha, beta, gamma, v1, v2, v3)
x1 = v1(:,1); x2 = v2(:,1); x3 = v3(:,1);
y1 = v1(:,2); y2 = v2(:,2); y3 = v3(:,2);

x = alpha*x1 + beta*x2 + gamma*x3;
y = alpha*y1 + beta*y2 + gamma*y3;

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

function r = BilinearSample(x, y, appearance, nchannels)
Y = round(x);
X = round(y);

c = x - Y;
d = y - X;

t = zeros(2, nchannels);
r = zeros(1, nchannels);

for i=1:nchannels
	t(1,i) = c * (appearance(X, Y+1, i) - appearance(X, Y, i)) + appearance(X, Y, i); 	
	
	t(2,i) = c * (appearance(X+1, Y+1, i) - appearance(X+1, Y, i)) + appearance(X+1, Y, i); 	
	
	r(1, i)  = d *(t(2,i) - t(1,i)) + t(1, i);	
end