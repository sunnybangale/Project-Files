function [Result N D ]= Emotion_Processing(index)

N=0;
D=0;

disp('Emotion Processing started..'); 
Path='./Captured_Images/';

for i=1:index
    
    image_name=strcat(Path,int2str(i),'.jpg');
    IMAGE=imread(image_name);
    
    Char=Recognition(IMAGE);
    
    if(Char==1)
        
        N=N+1;
        Result(i,1)=i;
        Result(i,2)=1;
        
    else
        
        D=D+1;
        Result(i,1)=i;
        Result(i,2)=0;
        
    end
    
    
    
end

disp('Emotion Processing finished..'); 


