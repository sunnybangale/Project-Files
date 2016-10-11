function DepthGui1()


    global MESSAGE;
    global INDEX;
    global Result;
    global N;
    global D;
      

      
    DepthVid = videoinput('winvideo', 1,'YUY2_640x480');%make object for depth camera
    set(DepthVid,'FramesPerTrigger',1);%capture 1 frame every time DepthVid
                                       %is trigered
    set(DepthVid,'TriggerRepeat',Inf);%infinite amount of triggers
    triggerconfig(DepthVid, 'Manual');%trigger Depthvid manually
                                      %within program
    DepthVid.ReturnedColorspace = 'rgb';
    
       
    

    %create figure to contain buttons/axes
    window=figure('Color',[0.9255 0.9137 0.8471],'Name','Depth Camera',...
                  'DockControl','off','Units','Pixels',...
                  'toolbar','none',...
                  'Position',[100 100 600 300]);
    
             
    %create axis to contain video feed
    ax1=axes('Parent',window,'XTick',[],'YTick',[],...
             'XColor',[0.9255 0.9137 0.8471],...
             'YColor',[0.9255 0.9137 0.8471],...
             'Position',[0.05 0.15 0.9 0.7]);
         
    %create timer that calls the dispim fctn every 0.05 secs
    t = timer('TimerFcn',@dispim, 'Period', 0.3,...
              'executionMode','fixedRate');
          
     %create timer that calls the dispim fctn every 0.05 secs
    tc = timer('TimerFcn',@captureim, 'Period', 3,...
              'executionMode','fixedRate');      
          
    %create start button which calls the startbCallback fctn
    startb=uicontrol('Parent',window,'Style','pushbutton','String',...
                        'START',...
                        'FontSize',18,...
                        'Units','normalized',...
                        'Position',[0.1 0.02 0.16 0.08],...
                        'Callback',@startbCallback);
                    
     
    %create stop button which calls the stopbCallback fctn
    askb=uicontrol('Parent',window,'Style','pushbutton','String',...
                        'ASK',...
                        'FontSize',18,...
                        'Units','normalized',...
                        'Position',[0.3 0.02 0.16 0.08],...
                        'Callback',@askbCallback);
 
                    
    %create stop button which calls the stopbCallback fctn
    stopb=uicontrol('Parent',window,'Style','pushbutton','String',...
                        'STOP',...
                        'FontSize',18,...
                        'Units','normalized',...
                        'Position',[0.5 0.02 0.16 0.08],...
                        'Callback',@stopbCallback);
 
           
   %create stop button which calls the stopbCallback fctn by bhu
    anab=uicontrol('Parent',window,'Style','pushbutton','String',...
                        'ANALYSE',...
                        'FontSize',18,...
                        'Units','normalized',...
                        'Position',[0.75 0.02 0.16 0.08],...
                        'Callback',@anabCallback);
    
%     txt = uicontrol('Style','text',...
%         'Position',[400 550 600 40],...
%         'String','Vertical Exaggeration');                
                    
                    
    %dispim fuction does all image processing and displays the image
    function dispim(hobj,event)
           
            %text(200,-50, MESSAGE,'linewidth',10);
            txt.settext='achgc';
            trigger(DepthVid)%trigger DepthVid to capture image
            img=getdata(DepthVid,1,'double');%convert to double
            im= flipdim(img,2);
            imshow(im);
            hold on
            
            rectangle('Position',[100,128,300,300],'LineWidth',5,'LineStyle','-','EdgeColor','r');
            %rectangle('Position',[450,250,150,150],'LineWidth',5,'LineStyle','-','EdgeColor','b');
            
            hold off;
            drawnow;
            
            
            
                      
           
    end

     function captureim(hobj,event)
           

            %INDEX=INDEX+1;
            trigger(DepthVid)%trigger DepthVid to capture image
            img=getdata(DepthVid,1,'double');%convert to double
            im= flipdim(img,2);
            imshow(im);
            hold on
            
            rectangle('Position',[100,128,300,300],'LineWidth',5,'LineStyle','-','EdgeColor','g');
            %rectangle('Position',[450,250,150,150],'LineWidth',5,'LineStyle','-','EdgeColor','b');
            
            hold off;
            drawnow;
            
            Face=imcrop(im,[100,128,300,300]);
            Face=rgb2gray(Face);

            INDEX=INDEX+1;
            str=strcat('./Captured_Images/',int2str(INDEX),'.jpg');
            imwrite(Face,str);
                %[CharNo]=Recognition(Face);
                  

           
    end



    function startbCallback(hobj,event)
         start(DepthVid);%open object
         start(t)%open object
         %start(tc)%open object
    end

    function askbCallback(hobj,event)
         
         abc='This is my message';
         
         text(200,-50,abc,'linewidth',5);
         INDEX=0;
         %text(200,-50,'Allign your face in the Red box...','linewidth',5);
         %start(DepthVid);%open object
         %start(t)%open object
         start(tc)%open object
    end

    function stopbCallback(hobj,event)
         stop(t)%close object
         stop(DepthVid);%close object
         stop(tc)%close object
         
         [Result N D]= Emotion_Processing(INDEX);
         
               
    end
    
    function anabCallback(hobj,event)
         figure,
         x = [N D];
         pie(x);
         colormap jet;
         
         fid = fopen( 'MATLAB_RESULT.txt', 'wt' );
            
            fprintf( fid, '%d\n',N);
            fprintf( fid, '%d\n',D);
            
         fclose(fid);
         
    end

end