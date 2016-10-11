function [v_n, s_eig_n, S0, S_vecs, Range_shape_proj_param] = ModelShape( samples_dir, zip_ratio, downscale )
% ModelShape - Model Shape
% [v_n, s_eig_n, S0, S_vecs, Range_shape_proj_param] = ModelShape( samples_dir, zip_ratio )
%
% samples_dir is  the directory of samples where ASF files are existed | char array
% zip_ratio is the accuracy of shape PCA | a double variable range in (0,1)
% downscale is the shrink ratio from the original shape
% v_n is the vertices number of the shape
% s_eig_n is the number of the shape's principal components | a double variable
% S0 is the mean shape after applying PCA to shapes | a [v_n*2, 1] matrix
% S_vecs is the shape vectors | a [v_n*2,s_eig_n] matrix
% Range_shape_proj_param is the shape parameters' range according to samples | a [s_eig_n, 2] matrix

% WANG Lei, CG&CV Lab, Hunan University, Changsha
% $Id: ModelShape.m, v 1.0 2004-4-22 15:54 Lei$

% Load the shapes to a matrix
files = dir([samples_dir , '\*.asf']);
Fnum = size(files, 1);

% - Load the first shape and determine the numbers of points per shape
shape1 = readasf([samples_dir '\' files(1).name]);  
v_n = size(shape1, 1) / 2;

% - Pre-relocate a memery block to contain the data
Sample_shapes0 = zeros( v_n*2, Fnum );
Sample_shapes0(:, 1) = shape1;

% - Load the other shapes
for i = 2 : Fnum
	Sample_shapes0(:, i) = readasf([samples_dir '\' files(i).name]);	            
end        
                  
% Do shape alignment
Sample_shapes = DoShapeAlign( Sample_shapes0,downscale, true );

% Apply PCA to shapes
[S_vecs, Vals, S0] = PCA( Sample_shapes, zip_ratio );
s_eig_n = size( S_vecs, 2 );

% Get the shape parameters' range according to samples
proj_paras = zeros(s_eig_n, Fnum);
for i=1:Fnum
    cs = Sample_shapes(:,i);
	% - project the sample shape to the Vecs
	proj_paras(:,i) = S_vecs'*(cs - S0);
end

Range_shape_proj_param = zeros(s_eig_n, 2);
Range_shape_proj_param(:,1) = min(proj_paras, [], 2);
Range_shape_proj_param(:,2) = max(proj_paras, [], 2);

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

function Sample_shapes = DoShapeAlign( Sample_shapes0,downscale, bTangentProject )
%
% Align the Shapes
%

S0 = Sample_shapes0;

% - calculate the average shape size according to the 2-norm
AvgSize = 0;
[np, ns] = size( S0 );
np = np / 2;
for i = 1 : ns
    [S0(:,i), vSize] = Normalize( S0(:,i) );
    AvgSize = AvgSize + vSize;
end
AvgSize = AvgSize / ns ;
% - the initial estimate of the mean shape is set to the first shape
mean_est = S0(:,1);
% - setup
% verbose = false;
forceMeanOrientation = true;
% - do a number number of alignment iterations until the mean shape estimate is stable
diff = 10000;
diff_max = 0.001; % diff must be less than 0.1%
max_iter = 30;
iter = 1;
rot = zeros(ns, 1);
while ( (abs(diff)/Norm2(mean_est) > diff_max) && ( iter < max_iter ) )
    % - normalize and align all other shapes to the mean shape estimate
    for i = 1:ns
        [S0(:,i), rot(i, 1), no_use ] = AlignTo( mean_est, S0(:,i) );
        % -  re-scale to unit size to avoid the so-called 'shrinking effect'
        S0(:,i) = Scale( S0(:,i), 1/Norm2(S0(:,i)));
    end
    mean_est_old = mean_est;
    
    % - estimate the new mean shape
    mean_est = (sum(S0') / ns)';
    % - if this is the first iteration make the meanshape have a mean orientation
    if forceMeanOrientation && iter == 1
        mean_est  = Rotate( mean_est, -( sum(rot)/ns ) );
    end
    
    diff = Norm2( mean_est_old - mean_est );
    
    iter = iter + 1;
end

% - save the mean shape before tangent space projection
MeanShapeBeforeTS = mean_est;
% - project into tangent space to avoid non-linearity in point movements
if bTangentProject == true
    for i = 1:ns
        ts = MeanShapeBeforeTS' * S0(:,i);
        scale = 1 / ts;
        S0(:,i) = Scale( S0(:,i), scale );
    end
end

S = S0;

Sample_shapes = S * AvgSize / downscale;

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

function r = Norm2( v )
% r = sqrt( x_1^2 + x_2^2  .. + x_n^2 )
r = sqrt(sum(v.^2'));

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

function [x, y] = COG( v )
% the center of geometry of the shape vector (x1, x2,...,y1, y2,... )'
n = size(v, 1) / 2;
x = sum(v(1:n, 1)) / n;
y = sum(v(n+1:2*n, 1)) / n;

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

function r = Translate( v, x, y)
% translate the shape vector v = (x1, x2,...,y1, y2,... )' a (x, y) offset
[h, w] = size(v);
n = h / 2;
r = zeros(h, w);
r(1:n, 1) = v(1:n, 1) - x;
r(n+1:2*n, 1) = v(n+1:2*n, 1) - y;

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

function r = Rotate( v, theta )
% Rotates the shape 'theta' radians according the origo

% - get the rotation matrix
rm = [ cos( theta ) sin( theta ); -sin( theta ) cos( theta ) ];
% - rotate the shape
n = size( v, 1) / 2;
s = reshape( v, n, 2 );
for i = 1 : n
    s(i,:) = s(i,:) * rm;
end
r = reshape( s, n*2, 1 );

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

function r = Scale( v, scale )
% Scale the vector according origo with factor scale
r = v.* scale;

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

function [r, vSize] = Normalize( v )
% Normalize to unit scale and translates COG to origo
[x, y] = COG( v );
r = Translate( v, x, y );
vSize = Norm2( r );
r = Scale( r, 1 / vSize );

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

function r = GetRotation( refv, v )
% Returns the rotation between ref and this (in radians)
% Note that both shapes must be normalized with respect to scale and position
%       beforehand. This could be done by using Normalize(). 

% - reshape the two shape vectors
n = size( refv, 1 ) / 2;
refs = reshape( refv, n, 2 );
s = reshape( v, n, 2 );
% - calculate the rotation by minimizing the sum of squared point distances
res = refs' * s;
[U,S,V] = svd( res );
res = V * U';
% - res holds now a normal 2x2 rotation matrix
cos_theta = res(1,1);
sin_theta = res(2,1);
epsilon = 1e-12;
if 1 - cos_theta < epsilon
    r = 0;
elseif abs(cos_theta) < epsilon
    r = pi / 2;
elseif 1 + cos_theta < epsilon
    r = pi;
else
    a_cos = acos( cos_theta );
    a_sin = asin( sin_theta );
    if a_sin < 0
        r = -a_cos;
    else
        r = a_cos;
    end
end

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

function [r, rot, vSize] = AlignTo( refv, v )
% Aligns this to 'ref' with respect to pose

% - move this and refv to origo
[x, y] = COG( v );
v = Translate( v, x, y);
[x, y] = COG( refv );
refv = Translate( refv, x, y);
% - normalize scale, using the 2-norm
vSize = Norm2( v );
refvSize = Norm2( refv );
v = Scale( v, refvSize / vSize );
% - align rotation between v and refv
theta = GetRotation( refv, v );
v = Rotate( v, -theta );
rot = -theta;
% - translate v to refv's origo
v = Translate( v, x, y );

r = v;
