close all;
clear all;
clc;

ReadPath='./SVM_Training/';
N=20;
i=1;

% image_name=strcat(ReadPath,int2str(i),'.jpg');
% I=imread(image_name);
% figure,
% imshow(I);


for i=1:N
    
    image_name=strcat(ReadPath,int2str(i),'.jpg');
    I=imread(image_name);
    [r c]=size(I);
    temp=reshape(I,1,r*c);
    temp=double(temp);
    trainData(i,:) =temp;
    
    
end

class = [1 1 1 1 1 1 1 1 1 1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1];
SVMStruct = svmtrain (trainData, class);

image_name=strcat(ReadPath,int2str(1),'.jpg');
I=imread(image_name);
[r c]=size(I);
temp=reshape(I,1,r*c);
temp=double(temp);
result = svmclassify(SVMStruct,temp)

