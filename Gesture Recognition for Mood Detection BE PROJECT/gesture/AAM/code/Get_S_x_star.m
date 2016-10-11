function S_x_star = Get_S_x_star( v_n, S_x )
% Get_S_x_star - get S_x_star matrix for S_x to do global shape transform
% S_x_star = Get_S_x_star( v_n, S_x )
%
% v_n is the number of the vertices in the shape
% S_x is the target shape | a [v_n*2, 1] matrix
% S_x_star is the base matrix of S_x for doing global shape transform | a [v_n*2, 4] matrix
 
% WANG Lei, CG&CV Lab, Hunan University, Changsha
% $Id: S_x_star.m, v 1.0 2004-4-22 15:53 Lei$
 
    %S_x = S_x / norm(S_x);
    
	S_x_star = zeros(v_n*2, 4);
	S_x_star(:, 1) = S_x;
	S_x_star(1:v_n, 2)             = -S_x(v_n+1:v_n*2, 1);
	S_x_star(v_n+1:v_n*2, 2) =  S_x(1:v_n, 1);
	S_x_star(1:v_n, 3)             = ones(v_n, 1);
	S_x_star(v_n+1:v_n*2, 3) = zeros(v_n, 1);
	S_x_star(1:v_n, 4)             = zeros(v_n, 1);
	S_x_star(v_n+1:v_n*2, 4) = ones(v_n, 1);
    
	    [Q,R] = qr(S_x_star, 0);
	    S_x_star = Q;