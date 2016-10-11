% ModelAAM - Just a collection of scripts. Do the Jobs of F2~F4. 
% 
% Write the outputs to a mat file named mat_model.mat

% WANG Lei, CG&CV Lab, Hunan University, Changsha
% $Id: ModelAAM.m, v 1.2 2004-4-16 15:17 Lei$

% Model Shape
samples_dir = 'E:\»À¡≥ø‚\face_data_AAM_Denmark\data';%'F:\Õı  ¿⁄\≥Ã–Ú\AAM\samples\Lei1';%
zip_ratio = 0.9;
downscale = 1.5;

[v_n, s_eig_n, S0, S_vecs, Range_shape_proj_param] = ModelShape( samples_dir, zip_ratio, downscale );

% Model Appearance
[a_height, a_width, nchannels, A0, a_eig_n, A, Range_appearance_proj_param, warp_table, Mesh] = ModelAppearance(samples_dir, S0, downscale, zip_ratio);

% Do pre-calculation for inverse compositional algorithm
[H_inv, SD] = FittingPreCalcu(A0, S0, Mesh,S_vecs, v_n, s_eig_n, a_eig_n, A, nchannels, a_height, a_width, warp_table);

% save the result to mat_model.mat
save('mat_model.mat', 'v_n', 's_eig_n', 'S0', 'S_vecs', 'Range_shape_proj_param', 'a_height', 'a_width', 'nchannels', 'A0', 'a_eig_n', 'A', 'Range_appearance_proj_param', 'warp_table', 'Mesh','H_inv', 'SD');

% the code below is debug purpose
figure;
title('mean shape');
hold on
axis ij
axis equal

m_s = reshape( S0, v_n, 2);
    x = m_s(:,1);
    y = m_s(:,2);
    plot(x,y,'.b');

hold off

figure;
title('a appeareance instance');
hold on
axis ij
axis equal

appearance_proj_param = sum(Range_appearance_proj_param, 2) / 2;
appearance(:,:,1) = A(:,:,1) * appearance_proj_param + A0(:,:,1);
% appearance(:,:,2) = A(:,:,2) * appearance_proj_param + A0(:,:,2);
% appearance(:,:,3) = A(:,:,3) * appearance_proj_param + A0(:,:,3);
appearance = reshape(appearance, a_height, a_width, nchannels);
im = uint8(appearance);
imshow(im);

hold off;