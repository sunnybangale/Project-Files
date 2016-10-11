function [Vecs, Vals, M] = PCA( SampleVecs, zip_ratio )
% PCA - Do Principal Component Analysis
% [Vecs, Vals, M] = PCA( SampleVecs, zip_ratio )
%
% Vecs is the principal eigenvectors of the Covarian Matrix of SampleVecs. Laid as column vectos. | a [How_many_data_in_each_sample,How_many_principal_components] matrix
% Vals  is the principal eigenvalues   of the Covarian Matrix of SampleVecs. | a [How_many_principal_components, 1] matrix
% M      is the mean  of SampleVecs. | a [How_many_data_in_each_sample, 1] matrix
% SampleVecs is a matrix made from sample vectors laid as column vectors. | a [How_many_data_in_each_sample, How_many_samples] matrix
% zip_ratio is the accuracy of  PCA | a double variable range in (0,1)

% WANG Lei, CG&CV Lab, Hunan University, Changsha
% $Id: PCA.m, v 1.0 2004-4-14 17:20 Lei$

% The code here is borrowed from Matthew Dailey's tutorials on PCA ( mdailey@cs.ucsd.edu | http://ai.ucsd.edu/Tutorial/matlab.html ).

A = SampleVecs;

nexamp = size(A,2);

% Now compute the eigenvectors of the covariance matrix, using
% a little trick from Turk and Pentland 1991

% Compute the "average" vector
% mean(A) gives you a row vector containing the mean of each column of A
Psi = mean(A')';

% Compute difference with average for each vector
for i = 1:nexamp
   A(:,i) = A(:,i) - Psi;
end;

% Get the patternwise (nexamp x nexamp) covariance matrix
% using Turk and Pentland's trick for numrows >> numcols
L = A'*A;

% Get the eigenvectors (columns of Vectors) and eigenvalues (diag of Values)
[Vectors,Values] = eig(L);

% Sort the vectors/values according to size of eigenvalue
[Vectors,Values] = sortem(Vectors,Values);

% Convert the eigenvectors of A'*A into eigenvectors of A*A'
Vectors = A*Vectors;

% Get the eigenvalues out of the diagonal matrix and
% normalize them so the evalues are specifically for cov(A'), not A*A'.
Values = diag(Values);
Values = Values / (nexamp-1);

% Normalize Vectors to unit length & kill vectors corr. too tiny evalues
num_good = 0;
for i = 1:nexamp
    Vectors(:,i) = Vectors(:,i)/norm(Vectors(:,i));
    if Values(i) < 0.00001
      % Set the vector to the 0 vector; set the value to 0.
      Values(i) = 0;
      Vectors(:,i) = zeros(size(Vectors,1),1);
    else
      num_good = num_good + 1;
    end;
end;

% clip the minor eigens off
vsum = sum( Values );
for i=1:nexamp-1
    perc_v = sum(Values( 1:nexamp-i,1 )) / vsum;
    if perc_v < zip_ratio
       break;
    end
end
n_eig = nexamp - i + 1;

Vectors = Vectors(:,1:n_eig);
Values  = Values(1:n_eig, 1 );

M = Psi;
Vecs = Vectors;
Vals = Values;

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

function [NV,ND] = sortem(V,D)
%[V,D] = SORTEM(V,D)
%    Assumes the columns of V are vectors to be sorted along with the
%    diagonal elements of D.
%
% Matthew Dailey, 1998

% Check arguments

if nargin ~= 2
 error('Must specify vector matrix and diag value matrix')
end;

dvec = diag(D);
NV = zeros(size(V));
[dvec,index_dv] = sort(dvec);
index_dv = flipud(index_dv);
for i = 1:size(D,1)
  ND(i,i) = D(index_dv(i),index_dv(i));
  NV(:,i) = V(:,index_dv(i));
end;