function [H_inv, SD] = FittingPreCalcu(A0, S0, Mesh, S_vecs, v_n, s_eig_n, a_eig_n, A, nchannels, a_height, a_width, warp_table)
% FittingPreCalcu - Do pre-calculation for inverse compositional algorithm
% [H_inv, SD] = FittingPreCalcu(A0, S0, Mesh, S_vecs, v_n, s_eig_n, A, nchannels, a_height, a_width)
%
% A0 is the base appearance of the appearance model | a [a_height*a_width,1 ,nchannels] matrix
% S0 is the mean shape | a [v_n*2,1] matrix
% Mesh is the triangular mesh of the face | a [How_many_triangles_in_the_mean_shape_mesh, 3] matrix
% S_vecs is the shape vectors | a [v_n*2, s_eig_n] matrix
% v_n is the vertices number of the shape
% s_eig_n is the number of the shape's principal components | a double variable
% a_eig_n is the number of the appearance's principal components
% A is the appearance vectors | a [a_height*a_width*a_eig_n,1 , nchannels] matrix
% nchannels is the color channels of the sample images | a double variable 1 or 3 
% a_height, a_width are the height and width of the base appearance A0
% warp_table is the warp table for warp to S0 | a [How_many_pixels_in_the_mean_shape, 6] matrix
% H_inv is the inverse of the Hessian Matrix | a [s_eig_n+4, s_eig_n+4, nchannels] matrix
% SD is the modified steepest descent images | a [a_height, a_width*(s_eig_n+4), nchannels] matrix

% WANG Lei, CG&CV Lab, Hunan University, Changsha
% $Id: FittingPreCalcu.m, v 1.0 2004-4-22 15:53 Lei$
% Reference : [1] I. Matthews, S. Baker. Active Appearance Models Revisited. International Journal of Computer Vision, 2005.
%                       [2] M. B. Stegmann, Active Appearance Models: Theory, Extensions and Cases, pp. 262, Informatics and Mathematical Modelling, Technical University of Denmark, DTU, 2000.

fprintf(1, '\nBegin to do fitting pre-calculate, be patient...\n');

% transform the A and A0 to normal
A0 = reshape(A0, a_height, a_width, nchannels);
temp = zeros(a_height, a_width*a_eig_n, nchannels);
for i=1:a_eig_n
             temp(:, (i-1)*a_width+1:i*a_width, : ) = reshape(A(:,i,:), a_height, a_width, nchannels);
end
A = temp;

% Evaluate the gradient of the template A0
[Gradient_A0x Gradient_A0y] = gradient( A0 );
Gradient_A0 = [ Gradient_A0x ; Gradient_A0y ];  
                             
% Evaluate the Jacobians dN_dq and dW_dp at (x;0)
% ===============================================
dW_dp = zeros(a_height * 2, a_width * s_eig_n);

% first we calculate dW_dx and dW_dy
fprintf(1, '    Calculate dW_dx, this step may be slow, please be patient...\n');  
dW_dx = zeros(a_height*2, a_width*v_n);
dW_dy = zeros(a_height*2, a_width*v_n);
for i=1:v_n
	[ dW_dx(:, (i-1)*a_width+1:i*a_width)  dW_dy(:, (i-1)*a_width+1:i*a_width) ] = Calc_dW_dXi( S0, warp_table, Mesh, i, a_height, a_width );
	fprintf(1, '       %d/%d\n', i, v_n);  
end

for j=1:s_eig_n
	dW_dpj = zeros( a_height * 2, a_width );
	for i=1:v_n	            
	                            dxi_dpj = S_vecs(i, j);
                                dyi_dpj = S_vecs(v_n+i, j);
                                dW_dpj = dW_dpj + dW_dx(:, (i-1)*a_width+1:i*a_width ) * dxi_dpj + dW_dy(:, (i-1)*a_width+1:i*a_width) * dyi_dpj;
	end
	dW_dp( :, (j-1)*a_width+1 : j*a_width) = dW_dpj;
 end                     
    
dN_dq = zeros( a_height * 2, a_width * 4 );
S0_star = Get_S_x_star( v_n, S0 );                   

for j=1:4
	dN_dqj = zeros( a_height * 2, a_width );
	for i=1:v_n
                                 dxi_dqj = S0_star( i, j );
                                 dyi_dqj = S0_star( v_n+i, j); 
                                 dN_dqj = dN_dqj + dW_dx(:, (i-1)*a_width+1:i*a_width ) * dxi_dqj + dW_dy(:, (i-1)*a_width+1:i*a_width) * dyi_dqj;
	end
	dN_dq( :, (j-1)*a_width+1 : j*a_width) = dN_dqj;
end              
% =========================================                  
                         
% Compute the modified steepest descent images using Equation (41) in iii)
SD_W = zeros( a_height, a_width*s_eig_n, nchannels );
for j=1:s_eig_n
	VA0_dW_dpj = Calc_VA0_dW_dpj( Gradient_A0, dW_dp, j , a_height, a_width, nchannels);
	sigma_out = zeros( a_height, a_width, nchannels );
	for i=1:a_eig_n
                               mid = VA0_dW_dpj .* A(:, (i-1)*a_width+1:i*a_width, :);
                               sigma_inner = sum(sum(sum( mid )));
                               sigma_out = sigma_out + A(:, (i-1)*a_width+1:i*a_width, :) * sigma_inner;  
	end
	SDj_W = VA0_dW_dpj - sigma_out;
	SD_W(:, (j-1)*a_width+1:j*a_width, :) = SDj_W;
end                         

SD_N = zeros( a_height, a_width*4, nchannels );
for j=1:4
	VA0_dN_dqj = Calc_VA0_dN_dqj( Gradient_A0, dN_dq, j, a_height, a_width, nchannels);
	sigma_out = zeros( a_height, a_width, nchannels );
	for i=1:a_eig_n
                               mid = VA0_dN_dqj .* A(:, (i-1)*a_width+1:i*a_width, :);
                               sigma_inner = sum(sum(sum( mid )));
                               sigma_out = sigma_out + A(:, (i-1)*a_width+1:i*a_width, :) * sigma_inner; 
	end
	SDj_N = VA0_dN_dqj - sigma_out;
	SD_N(:, (j-1)*a_width+1:j*a_width, :) = SDj_N;
end
SD = [ SD_N SD_W ];
                          
% Compute the Hessian matrix using modified steepest descent images
H = zeros( s_eig_n+4, s_eig_n+4, nchannels );    
H_inv = zeros( s_eig_n+4, s_eig_n+4, nchannels );       
for i=1:s_eig_n+4
	h1 = SD(:, (i-1)*a_width+1:i*a_width,:);
	for j=1:s_eig_n+4
                                h2 = SD(:, (j-1)*a_width+1:j*a_width,:);    
                                H(j, i,:) = sum(sum(h1.*h2));  % ????? Should we consider H one channel or nchannels?
	end
end

for k=1:nchannels
	H_inv(:,:,k) = inv( H(:,:,k) );
end                          

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

function [dW_dxi, dW_dyi] = Calc_dW_dXi( S0, warp_table, Mesh, vi, a_height, a_width )

dW_dxi = zeros(a_height*2, a_width);
dW_dyi = zeros(a_height*2, a_width);

% find the triangles around vertex i
list = sum(Mesh==vi, 2) > 0;
n = size(list, 1);
tri = zeros(n, 1);
p = 0;
for i=1:n
	if list(i,1)==1
		p = p + 1;
		tris(p,1) = i;
	end
end	
tris = tris(1:p, 1 );
tri_n = size(tris, 1);

% get the coordinates of the vertices of S0 in the frame of A0
v_n = size( S0, 1 ) / 2;
S0 = reshape( S0, v_n, 2 );
top_left = min(S0);
S0(:,1) = S0(:,1) - top_left(:,1);
S0(:,2) = S0(:,2) - top_left(:,2);

bot_right = max( S0 );
row_scale = (a_height-1) / bot_right(1, 2);
col_scale = (a_width-1) / bot_right(1, 1);
S0(:,1) = S0(:,1) * col_scale;
S0(:,2) = S0(:,2) * row_scale;
S0 = round(S0) + 1;

% Calculate according to Equation (30) in Reference[1]
p_n = size( warp_table, 1 );
for i=1:p_n
	bIn = 0;
	% judge if this pixel is in the triangles list above
	for j=1:tri_n
		if warp_table(i, 3) == tris(j, 1)
			bIn = 1;
			break;
		end
	end
	
	if bIn==1
		p_y = warp_table(i, 1);
		p_x = warp_table(i, 2);
		% Get Alpha, Beta of the pixel (p_x, p_y) according to equation (25) and (26) in Reference [1]
		xi = S0(vi, 1);
		yi = S0(vi, 2);
		the_tri = Mesh(warp_table(i, 3), :);
		count = 0;
		for k=1:3
			if the_tri(1, k)~=vi
				count = count + 1;
				if count==1
					xj = S0( the_tri(1, k), 1 );
					yj = S0( the_tri(1, k), 2 );
				else
					xk = S0( the_tri(1, k), 1 );
					yk = S0( the_tri(1, k), 2 );
				end
			end
		end
		
		denominator = (xj - xi)*(yk - yi) - (yj - yi)*(xk - xi);
		alpha = ((p_x-xi)*(yk-yi)-(p_y-yi)*(xk-xi)) / denominator;
		beta  = ((p_y-yi)*(xj-xi)-(p_x-xi)*(yj-yi)) / denominator;
		v = 1 - alpha - beta;
		
		dW_dxi( p_y, p_x ) = v;
		dW_dyi( a_height+p_y, p_x ) = v;
	end
end

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

function VA0_dW_dpj = Calc_VA0_dW_dpj( Gradient_A0, dW_dp, j, a_height, a_width, nchannels )
% VA0_dW_dpj = Calc_VA0_dW_dpj( Gradient_A0, dW_dp, j )
%
% Gradient_A0 is a [a_height*2, a_width, nchannels] matrix
% dW_dp is a [a_height * 2, a_width * s_eig_n] matrix
% VA0_dW_dpj is a [a_height, a_width, nchannels] matrix

VA0_dW_dpj = zeros(a_height, a_width, nchannels);

for i=1: nchannels
	Tx = Gradient_A0(1:a_height, :, i) .* dW_dp(1:a_height, (j-1)*a_width+1:j*a_width);
	Ty = Gradient_A0(a_height+1:a_height*2, :, i) .* dW_dp(a_height+1:a_height*2, (j-1)*a_width+1:j*a_width);
	VA0_dW_dpj(:, :, i) = Tx + Ty;
end

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

function VA0_dN_dqj = Calc_VA0_dN_dqj(  Gradient_A0, dN_dq, j, a_height, a_width, nchannels )
% VA0_dN_dqj = Calc_VA0_dN_dqj(  Gradient_A0, dN_dq, j, a_height, a_width )
%
% Gradient_A0 is a [a_height*2, a_width, nchannels] matrix
% dN_dq is a [a_height * 2, a_width * 4] matrix
% VA0_dN_dqj is a [a_height, a_width, nchannels] matrix

VA0_dN_dqj = zeros(a_height, a_width, nchannels);

for i=1:nchannels
	Tx = Gradient_A0(1:a_height, :, i) .* dN_dq(1:a_height, (j-1)*a_width+1:j*a_width);
	Ty = Gradient_A0(a_height+1:a_height*2, :, i) .* dN_dq(a_height+1:a_height*2, (j-1)*a_width+1:j*a_width);
	VA0_dN_dqj(:, :, i) = Tx + Ty;
end