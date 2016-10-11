function [p, q] = Fitting(p, q, v_n, S0, S_vecs, I, A0, nchannels, SD, H_inv, Mesh, a_height, a_width, warp_table, n_iters, RMS_err, Range_shape_proj_param, bDraw, handles)
% Fitting - Fit the AAM in the target image I
% [p, q] = Fitting(p, q, S0, S_vecs, I, A0, nchannels, SD, H_inv, Mesh, a_height, a_width, n_iters, warp_table, RMS_err )
% 
% p is the shape parameters | a [ s_eig_n, 1 ] matrix
% q is the global shape transform parameters | a [ 4, 1 ] matrix
% v_n is the vertices number of the shape 
% S0 is the mean shape | a [v_n*2,1] matrix
% S_vecs is the shape vectors | a [v_nX2,s_eig_n] matrix
% I is the target image | a [i_height, i_width, nchannels_I] matrix
% A0 is the template image, the base appearance | a [ a_height, a_width, nchannels ] matrix
% nchannels is the color channels of the sample images | a double variable 1 or 3
% SD is the modified steepest descent images | a [a_height, a_width*(s_eig_n+4), nchannels] matrix
% H_inv is the inverse of Hessian matrix | a [s_eig_n+4, s_eig_n+4, nchannels] matrix
% Mesh is the triangular mesh of the face | a [tri_n,3] matrix
% a_height, a_width are the height and width of the base appearance A0
% n_iters is the maximal numbers to iterate
% warp_table is the warp table for warp to S0 | a [How_many_pixels_in_the_mean_shape, 6] matrix
% RMS_err is the accuracy of iteration
% Range_shape_proj_param is the shape parameters' range according to samples | a [s_eig_n, 2] matrix
% bDraw indicate whether we draw the shape in every iteration
% handles is the UI handle

% WANG Lei, CG&CV Lab, Hunan University, Changsha
% $Id: Fitting.m, v 1.0 2004-4-22 15:53 Lei$
% Reference : [1] I. Matthews, S. Baker. Active Appearance Models Revisited. International Journal of Computer Vision, 2005.
%                       [2] M. B. Stegmann, Active Appearance Models: Theory, Extensions and Cases, pp. 262, Informatics and Mathematical Modelling, Technical University of Denmark, DTU, 2000.

global ifDone;
global time;

% Check the validity of the fitting
if (size(I, 3)~= nchannels)
	error('the channels between the target image and the appearance model is not match');
end

s_eig_n = size( S_vecs, 2 );
S0_star = Get_S_x_star( v_n, S0 );

% transform A0 to normal
A0 = reshape(A0, a_height, a_width, nchannels);
                        
% begin to iterate
i_iters = 0;
f_RMS_err   = 10000;
f_RMS_old   = 10000;
tic;
while ((i_iters < n_iters)&&(f_RMS_err > RMS_err))
                           % Warp I with W(x;p) followed by N(x;q) to compute I(W(x;p))
                           S = S_vecs * p + S0; %note the center of S are on origin    
                           
                           S_star = Get_S_x_star( v_n, S );                           
                           S = S_star * q + S;               
                           
                           current_s = reshape( S, v_n, 2 );
                           I_warp = Piecewise_Warp(current_s, I, nchannels, warp_table, Mesh, a_height, a_width );
                           
                           % Compute the error image I_warp - A0
                           I_warp = reshape( I_warp, a_height, a_width, nchannels);
                           err_image = I_warp - A0;
                           
                           % Compute dot product of modified steepest descent images with error image
                           SD_err_image = zeros( s_eig_n+4, 1, nchannels );
                           for j=1:(s_eig_n+4)
                              h1 = SD(:, (j-1)*a_width+1:j*a_width, :);
                              SD_err_image(j, 1, :) = sum(sum(h1 .* err_image));
                           end
                           
                           % Compute delta q and delta p by multiplying by inverse Hessian
                           delta_qp = zeros( s_eig_n+4, 1, nchannels );
                           for k=1:nchannels
                              delta_qp(:,1,k) = H_inv(:,:,k) * SD_err_image(:,:,k);
                           end      
                           
                           % Update the warp (NoW)(x;q,p) <- (NoW)(x;q,p) o (NoW)(x;delta_q,delta_p)_-1
                           S_est = zeros(v_n*2, 1, nchannels);
                           for i=1:nchannels
                              S_delta_p = S_vecs * (-delta_qp(5:s_eig_n+4,1,i)) + S0;
                              
                              S_delta_p_star = Get_S_x_star( v_n, S_delta_p );
                              S_delta_qp = S_delta_p_star * (-delta_qp(1:4, 1, i)) + S_delta_p;      
                              
                              for j=1:v_n
                                 Tris_adjacent = Find_adjacent_triangles( Mesh, j );                                 
                                 Tris_adjacent = Find_alpha_beta( v_n, S0, S_delta_qp, Tris_adjacent, j );
                                 Verts_warped = Find_verts_in_shape( Tris_adjacent, S ); 
                                 Verts_mean    = mean( Verts_warped );
                                 S_est( j, 1, i ) = Verts_mean(1,1);
                                 S_est( v_n+j, 1, i) = Verts_mean(1,2);
                              end
                           end
                           S_est = mean( S_est, 3 ); % S_est degenerates to 1 channel                           
                           q = S0_star' * (S_est - S0);          
                           % in order to calculate N(S_est,q)_-1, we have to make clear the transform effect of q                        
                           trans_weight_x = 1 / S0_star( 1, 3 );
                           trans_weight_y = 1 / S0_star( v_n+1, 4 );
                           scale_weight = S0(1,1) / S0_star(1,1);
                           
                           q0 = q;
                           q0(1,1) = q(1,1) / scale_weight;
                           q0(2,1) = q(2,1) / scale_weight;
                           q0(3,1) = q(3,1) / trans_weight_x;
                           q0(4,1) = q(4,1) / trans_weight_y;
                           
                           % get the transform info of q
                           k = sqrt(((q0(1,1)+1)*(q0(1,1)+1) + q0(2,1)*q0(2,1)));
                           theta = asin(q0(2,1)/k); 
                           trans_x = q0(3,1) ;
                           trans_y = q0(4,1) ;
                           
                           % make a transform matrix to erase the effect caused by q
                           k = 1/k;
                           theta = -theta;
                           trans_x = -trans_x;
                           trans_y = -trans_y;
                           tm = [ k*cos(theta)                              k*sin(theta)                               0;
                                 -k*sin(theta)                              k*cos(theta)                               0;
                                 k*trans_x*cos(theta)-k*trans_y*sin(theta)  k*trans_x*sin(theta)+k*trans_y*cos(theta)  1];
                           
                            % get N(S_est,q)_-1 
                            S_est_q_inverse =   S_est;
                            S_est_q_inverse = reshape( S_est_q_inverse, v_n , 2);
                            S_est_q_inverse = [ S_est_q_inverse, ones( v_n, 1) ];
                            
                            S_est_q_inverse = S_est_q_inverse * tm;
                            
                            S_est_q_inverse = S_est_q_inverse( :,1:2 );                            
                            S_est_q_inverse = reshape( S_est_q_inverse, v_n*2, 1 );
                           
                           p = S_vecs' * (S_est_q_inverse - S0);
                           
                           % constrain the p
                           for i=1:s_eig_n
                               if p(i,1)<Range_shape_proj_param(i,1)
                                   p(i,1) = Range_shape_proj_param(i,1);
                               elseif p(i,1)>Range_shape_proj_param(i,2)
                                   p(i,1)=Range_shape_proj_param(i,2);
                               end
                           end      
                           
                           % update the iteration  parameters
                           f_RMS = sqrt(mean(err_image(:) .^2));
                           f_RMS_err = abs(f_RMS - f_RMS_old);
                           f_RMS_old = f_RMS;
                           
                           i_iters  = i_iters + 1;       
                           
                           if bDraw==1
                               DrawShape(handles, q, p);
                           end
                           set(handles.txNiters, 'String', num2str(i_iters));
                           set(handles.txRMS_err, 'String',num2str(f_RMS_err));
%                            saveas(handles.axes1, ['pic' num2str(i_iters) '.bmp']);
end

toc;
time = toc;
% calculate the fitting error for the paper 6-22
ifDone = 1;
DrawShape(handles, q, p);
ifDone = 0;

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

function Tris_adjacent = Find_adjacent_triangles( Mesh, vi )
list = sum(Mesh==vi, 2) > 0;
n = size(list, 1);
Tris_adjacent = zeros(n, 5);
p = 0;
for i=1:n
	if list(i,1)==1
		p = p + 1;
		Tris_adjacent(p,1:3) = Mesh(i, :);
	end
end	
Tris_adjacent = Tris_adjacent(1:p, : );

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

 function Tris_adjacent = Find_alpha_beta( v_n, S0, S_delta_p, Tris_adjacent, j )
 x = S_delta_p( j, 1 );
 y = S_delta_p( j + v_n, 1 );
 
 tri_n = size( Tris_adjacent, 1 );
 for i=1:tri_n
 	vi = Tris_adjacent( i, 1 );
 	xi = S0( vi, 1 );
 	yi = S0( vi+v_n, 1 );
 	vj = Tris_adjacent( i, 2 );
 	xj = S0( vj, 1 );
 	yj = S0( vj+v_n, 1 );
 	vk = Tris_adjacent( i, 3 );
 	xk = S0( vk, 1 );
 	yk = S0( vk+v_n, 1 );
 	
 	% alpha, beta are defined as equ. (25) and (26) in Ref[1].
 	denominator = (xj-xi)*(yk-yi) - (yj-yi)*(xk-xi);
 	alpha = ((x-xi)*(yk-yi) - (y-yi)*(xk-xi)) / denominator;
 	beta  = ((y-yi)*(xj-xi) - (x-xi)*(yj-yi)) / denominator;
 	
 	Tris_adjacent( i, 4 ) = alpha;
 	Tris_adjacent( i, 5 ) = beta;
 end
 	
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

function Verts_warped = Find_verts_in_shape( Tris_adjacent, S )
 tri_n = size( Tris_adjacent, 1 );
 Verts_warped = zeros( tri_n, 2 );
 v_n = size( S, 1 ) / 2;
 
 for i=1:tri_n
 	vi = Tris_adjacent( i, 1 );
 	xi = S( vi, 1 );
 	yi = S( vi+v_n, 1 );
 	vj = Tris_adjacent( i, 2 );
 	xj = S( vj, 1 );
 	yj = S( vj+v_n, 1 );
 	vk = Tris_adjacent( i, 3 );
 	xk = S( vk, 1 );
 	yk = S( vk+v_n, 1 );
 	
 	alpha = Tris_adjacent( i, 4 );
 	beta  = Tris_adjacent( i, 5 );
 	
 	x = xi + alpha * (xj - xi) + beta * (xk - xi);
 	y = yi + alpha * (yj - yi) + beta * (yk - yi);
 	
 	Verts_warped( i, 1 ) = x;
 	Verts_warped( i, 2 ) = y;
 end