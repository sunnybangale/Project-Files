function current_shape = readasf(f_asf)
% readasf - read the asf file to load the shape to a one-column matrix
% current_shape = readasf( f_asf )
%
% f_asf is char array indicating the path+filename of the asf file.
% current_shape is a [v_n*2,1] matrix

% WANG Lei, CG&CV Lab, Hunan University, Changsha
% $Id: readasf.m, v 1.0 2004-4-22 15:54 Lei$
 
tmp_lines = textread(f_asf,'%s','delimiter','\n','whitespace','','commentstyle','shell');
lc = 1;
dc = 1;
nbpoints =0;
for i=1:length(tmp_lines)
	linelen = length( tmp_lines{i} );
	if linelen  > 0 
		str = tmp_lines{i};
		
		% read number of points
		if (lc==1)
			nbpoints = str2num( str );
		end
		
		% read point data
		if (lc>1 & lc<=nbpoints+1)			
			P(dc,:) = sscanf( str, '%f', 7 )';
			dc = dc+1;
		end		
		
        % read the hostimage
		if (lc==nbpoints+2)
			hostimage = str;
		end
		lc = lc+1; 
	end
end

% The code above is borrowed from AAM-API

% filter out some luxurious data
current_shape = zeros( nbpoints*2, 1 );
current_shape( 1:nbpoints, 1 ) = P( :, 3 );
current_shape( nbpoints+1:nbpoints*2, 1 ) = P( :, 4 );

% turn the value of shape from relative to absolute
f_bmp = f_asf;
str_len = size(f_bmp, 2);
f_bmp(1, str_len-2:str_len) = 'bmp';
im = imread(f_bmp);
iwidth = size(im, 2);
iheight = size(im, 1);

current_shape( 1:nbpoints, 1 ) = round(current_shape( 1:nbpoints, 1 ) * iwidth);
current_shape( nbpoints+1:nbpoints*2, 1 ) = round(current_shape( nbpoints+1:nbpoints*2, 1 ) * iheight);
    

