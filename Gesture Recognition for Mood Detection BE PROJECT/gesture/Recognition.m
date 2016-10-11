function [CharNo]=Recognition(IMAGE)

load Eigenface.mat;

imwrite(IMAGE,'testi.jpg');
InputImage=imread('testi.jpg');

[m n]=size(InputImage);
Imagevector=reshape(InputImage',m*n,1);%to get elements along rows as we take InputImage'
MeanInputImage=double(Imagevector)-m1;%subtract each image from the  mean of all 
ProjectInputImage=Eigenfaces'*MeanInputImage;% eigen faces calculations(w1+w2..wn)
% here we get the weights of the input image with respect to our eigenfaces ((w form))
    % next we need to euclidean distance of our input image and compare it
    % with our face space and check whether it matches the answer...we need
    % to take the threshold value by trial and error methods
Euclideandistance=[];
for i=1:T
    temp=ProjectedImages(:,i)-ProjectInputImage;% subtract weights of input and each image in the database
    Euclideandistance=[Euclideandistance temp];
end
    % the above statements will get you a matrix of Euclidean distance and you
    % need to normalize it and then find the minimum Euclidean distance
tem=[];
for i=1:size(Euclideandistance,2)
    k=Euclideandistance(:,i);
    tem(i)=sqrt(sum(k.^2));
end
    % We now set some threshold values to know whether the image is face or not
    % and if it is a face then if it is known face or not
    % The threshold values taken are done by trial and error methods
[MinEuclid, index]=min(tem);

if(index<=150)
    CharNo=1; %Normal
else
    CharNo=0;
end
   