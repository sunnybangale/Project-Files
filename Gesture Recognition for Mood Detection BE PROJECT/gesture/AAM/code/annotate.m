function annotate( dest_dir, im, file_name, handles)
% annotate - annotate a image and out put the image and its shape file to dest_dir
% function annotate(imagetype, dest_dir, handles)

    end_botton = 0;
    point_count = 0;
    path_count = 0;

    iheight = size(im,1);
    iwidth  = size(im,2);
    while end_botton~='e' & end_botton~='b'
    
    	[points, end_botton]=markpath( point_count );
    	s=size(points);            	    
    	npathpoints = s(1);    	
    	if npathpoints==0    	    	
    		break;
		end    		

		%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	    % create a path point matrix
	    %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	    P_path 		= zeros( npathpoints, 7 );    
	    P_path(:,1) = path_count;								% path number
	    if end_botton=='o' 
	    	P_path(:,2) = 4;									% point type = open path
	    else
	    	P_path(:,2) = 0;									% point type = closed path
	    end
	    
	    P_path(:,3) = points(:,1)/iwidth;  						% relative x positions
	    P_path(:,4) = points(:,2)/iheight; 						% relative y positions
	    P_path(:,5) = [point_count:point_count+npathpoints-1]';	% point number
	    
%         set(handles.txResult, 'String', ['已经标记了' num2str(P_path(:,5)+1) '个点']);
        
	    if end_botton=='c'
	    
	    	% closed path
	    	P_path(:,6) = [point_count+npathpoints-1 point_count:point_count+npathpoints-2]';  	% connects_from
	    	P_path(:,7) = [point_count+1:point_count+npathpoints-1 point_count]';				% connects_to
		else
			
			% open path (default)
			P_path(:,6) = [point_count point_count:point_count+npathpoints-2]';  				% connects_from
	    	P_path(:,7) = [point_count+1:point_count+npathpoints-1 point_count+npathpoints-1]';	% connects_to			    	
	    end	
	    	    	
    	if point_count==0
    	
    		% create point matrix
    		P = P_path;
		else
			% add to point matrix    		
			P = [P; P_path];
    	end
    	
    	% update the total number of points and paths
    	point_count = point_count + npathpoints;
    	path_count  = path_count + 1;
    end

    f_asf = [dest_dir '\' file_name '.asf'];
    f_bmp = [dest_dir '\' file_name '.bmp'];
    writeasf( P, f_bmp, f_asf );
    imwrite(im, f_bmp, 'bmp');
    
    set(handles.txResult, 'String', [f_asf ' saved' ' || ' f_bmp ' saved']); 
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
function [points, end_botton]=markpath( point_count )
%
% function [points, end_botton]=markpath( point_count )
%
%
% Annotates one open or closed path and returns the point 
% coordinates and the keyboard press that ended the 
% annotation.
%
% 'point_count' is the current point count before invoking markpath()
%
% Output format: points = [ x y ; x y ; .... ]
%
% $Id: markpath.m,v 1.1.1.1 2003/01/03 19:18:51 aam Exp $ 
%

% setup
v=[];
left_mouse   = 1;
middle_mouse = 2;
right_mouse  = 3;

% get userinput
while 1,	   
    [x,y,input]=ginput(1);        	    
    if input==left_mouse 			% add point	   
       v=[v; x y];
       line( v(:,1), v(:,2), 'Marker', '+','Color','red', 'LineWidth', 2 );
    elseif input==right_mouse		% undo point
       line( v(:,1), v(:,2), 'Marker', '+','Color','green', 'LineWidth', 2 );
       v=v(1:end-1,:); 				% remove the last point
       line( v(:,1), v(:,2), 'Marker', '+','Color','red', 'LineWidth', 2 );
    elseif input=='c' 				% close path           
		line( [ v(:,1); v(1,1)], [v(:,2); v(1,2)], 'Marker', '+','Color','red', 'LineWidth', 2 );           
		break;
    elseif (input=='e' | input=='o') % stop annotating this shape        
       break;
    end    
    eval(sprintf('xlabel(''# points=%i'');', point_count+size(v,1)));    
end		
points=v;
end_botton = input;

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

function str=replaceext( filename, newext )
%
% function str=replaceext( filename, newext )
%
%
% Replaces the extension of 'filename' with 'newext'.
%
% $Id: replaceext.m,v 1.1.1.1 2003/01/03 19:18:51 aam Exp $ 
%
str=removeext( filename );
str=strcat(str,'.',newext);

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

function writeasf( P, hostimage, filename );
%
% function writeasf( P, hostimage, filename )
%
% Writes an asf file from a point matrix P and a host image - 
% i.e. the image that the shape belongs to.
%
% $Id: writeasf.m,v 1.1.1.1 2003/01/03 19:18:51 aam Exp $ 
%
[nbpoints d] = size(P);
eval(sprintf('fid=fopen(''%s'', ''w'');', filename));
fprintf(fid,'######################################################################\n');
fprintf(fid,'#\n');
fprintf(fid,'#    AAM Shape File  -  written: %s\n', datestr(now));
fprintf(fid,'#\n');
fprintf(fid,'######################################################################\n');
fprintf(fid,'\n');
fprintf(fid,'#\n');
fprintf(fid,'# number of model points\n');
fprintf(fid,'#\n');
fprintf(fid,'%i\n',nbpoints);    
fprintf(fid,'\n');
fprintf(fid,'#\n');
fprintf(fid,'# model points\n');
fprintf(fid,'#\n');
fprintf(fid,'# format: <path#> <type> <x rel.> <y rel.> <point#> <connects from> <connects to>\n');
fprintf(fid,'#\n');
for j=1:nbpoints
    fprintf(fid,'%i\t%i\t%.8f\t%.8f\t%i\t%i\t%i\n', P(j,1), P(j,2), P(j,3), P(j,4), P(j,5), P(j,6), P(j,7) );                  
end
fprintf(fid,'\n');
fprintf(fid,'#\n');
fprintf(fid,'# host image\n');
fprintf(fid,'#\n');
fprintf(fid,'%s\n',hostimage);  
fclose(fid);