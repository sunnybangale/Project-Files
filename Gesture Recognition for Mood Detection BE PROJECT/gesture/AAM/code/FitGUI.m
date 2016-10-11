function varargout = FitGUI(varargin)
% FITGUI M-file for FitGUI.fig
%      FITGUI, by itself, creates a new FITGUI or raises the existing
%      singleton*.
%
%      H = FITGUI returns the handle to a new FITGUI or the handle to
%      the existing singleton*.
%
%      FITGUI('CALLBACK',hObject,eventData,handles,...) calls the local
%      function named CALLBACK in FITGUI.M with the given input arguments.
%
%      FITGUI('Property','Value',...) creates a new FITGUI or raises the
%      existing singleton*.  Starting from the left, property value pairs are
%      applied to the GUI before FitGUI_OpeningFunction gets called.  An
%      unrecognized property name or invalid value makes property application
%      stop.  All inputs are passed to FitGUI_OpeningFcn via varargin.
%
%      *See GUI Options on GUIDE's Tools menu.  Choose "GUI allows only one
%      instance to run (singleton)".
%
% See also: GUIDE, GUIDATA, GUIHANDLES

% Edit the above text to modify the response to help FitGUI

% Last Modified by GUIDE v2.5 23-Apr-2004 19:53:45

% Begin initialization code - DO NOT EDIT
gui_Singleton = 1;
gui_State = struct('gui_Name',       mfilename, ...
                   'gui_Singleton',  gui_Singleton, ...
                   'gui_OpeningFcn', @FitGUI_OpeningFcn, ...
                   'gui_OutputFcn',  @FitGUI_OutputFcn, ...
                   'gui_LayoutFcn',  [] , ...
                   'gui_Callback',   []);
if nargin & isstr(varargin{1})
    gui_State.gui_Callback = str2func(varargin{1});
end

if nargout
    [varargout{1:nargout}] = gui_mainfcn(gui_State, varargin{:});
else
    gui_mainfcn(gui_State, varargin{:});
end
% End initialization code - DO NOT EDIT


% --- Executes just before FitGUI is made visible.
function FitGUI_OpeningFcn(hObject, eventdata, handles, varargin)
% This function has no output args, see OutputFcn.
% hObject    handle to figure
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
% varargin   command line arguments to FitGUI (see VARARGIN)

% Choose default command line output for FitGUI
handles.output = hObject;

% Update handles structure
guidata(hObject, handles);

% DO INITIALIZATION
global im;

global v_n;
global v_n;
global s_eig_n;
global S0;
global S_vecs;
global Range_shape_proj_param;
global a_height;
global a_width;
global nchannels;
global A0;
global a_eig_n;
global A;
global Range_appearance_proj_param;
global warp_table;
global Mesh;
global H_inv;
global SD;
global  n_iters;
global  RMS_err;

global p;
global q;

global max_scale;
global max_transX;
global max_transY;
global trans_weight_x;
global trans_weight_y;

global movfile;
global fn;
global path;
global ifDone; % indicate if the current fitting procedure has finished
global time;

ifDone = 0;
n_iters = 20;
RMS_err = 0.05;
movfile = 0;

load('mat_model.mat');

% UIWAIT makes FitGUI wait for user response (see UIRESUME)
 % uiwait(handles.figure1);

% at first, we hide the controls
set(handles.btFit, 'Visible', 'off');
set(handles.slScale, 'Visible', 'off');
set(handles.slTransX, 'Visible', 'off');
set(handles.slTransY, 'Visible', 'off');
set(handles.slVideo, 'Visible', 'off');
set(handles.txVideoFrameNum, 'Visible', 'off');
set(handles.txCurrentFrame, 'Visible', 'off');

set(handles.edNiters, 'String', num2str(n_iters));
set(handles.edRMS_err, 'String', num2str(RMS_err));


% --- Outputs from this function are returned to the command line.
function varargout = FitGUI_OutputFcn(hObject, eventdata, handles)
% varargout  cell array for returning output args (see VARARGOUT);
% hObject    handle to figure
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Get default command line output from handles structure
varargout{1} = handles.output;

clear;

% --------------------------------------------------------------------
function mOpenImage_Callback(hObject, eventdata, handles)
% hObject    handle to mOpenImage (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

global im;
global q;
global p;
global movfile;
global fn;
global path;
global ifDone;


current_dir = pwd;
%cd('E:\研究\定向投影\faces\denmark');%E:\人脸库\face_data_AAM_Denmark\data');
[fn, path] = uigetfile('*.jpg;*.bmp;*.tif', 'Open Image File');
file_name = fn;
s = [path, fn];
if ~isequal(fn, 0)
    set(handles.figure1, 'Name', file_name);
    im = rgb2gray(imread(s));
    cd(current_dir);
       
    Generate_initial_p_q( handles );
    DrawShape( handles, q, p );
    
    % show the controls
    set(handles.btFit, 'Visible', 'on');
    set(handles.slScale, 'Visible', 'on');
    set(handles.slTransX, 'Visible', 'on');
    set(handles.slTransY, 'Visible', 'on');
    set(handles.txNiters, 'String', '0');
    set(handles.txRMS_err, 'String', '10000');
    
    set(handles.slVideo, 'Visible', 'off');
    set(handles.txVideoFrameNum, 'Visible', 'off');
    set(handles.txCurrentFrame, 'Visible', 'off');
    
    movfile = 0;
end
cd(current_dir);

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
function Generate_initial_p_q( handles )
global im;
global v_n;
global S0;
global q;
global p;
global s_eig_n;
global max_transX;
global max_transY;
global max_scale;
global trans_weight_x;
global trans_weight_y;
global scale_weight;

% get the center of the image
i_width = size( im, 2 );
i_height = size( im, 1 );
trans_x = i_width / 2;
trans_y = i_height / 2;

scale = 1;

% construct the initial global shape transform parameters q
q = [ scale - 1;
        0;
        trans_x;
        trans_y;
    ];

max_scale = 3;
max_transX = i_width;
max_transY = i_height;
set(handles.slScale, 'Value', 33);
set(handles.slTransX, 'Value', round(trans_x / max_transX * 100));
set(handles.slTransY, 'Value', round(trans_y / max_transY * 100));

S0_star = Get_S_x_star(v_n, S0);
scale_weight = S0(1,1) / S0_star(1,1);
trans_weight_x = 1 / S0_star( 1, 3 );
trans_weight_y = 1 / S0_star( v_n+1, 4 );
q(1,:)= q(1,:) * scale_weight;
q(3,:)= q(3,:) * trans_weight_x;
q(4,:)= q(4,:) * trans_weight_y;
% construct the initial shape parameters p
p = zeros( s_eig_n, 1 );

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% --- Executes on button press in btFit.
function btFit_Callback(hObject, eventdata, handles)
% hObject    handle to btFit (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
global  p;
global  q;
global  v_n;
global  S0;
global  S_vecs;
global  I;
global  A0;
global  nchannels;
global  SD;
global  H_inv;
global  Mesh;
global  a_height;
global  a_width;
global  warp_table;
global  n_iters;
global  RMS_err;
global Range_shape_proj_param;

global im;

I = double(im);

n_iters = str2num(get(handles.edNiters, 'String'));
RMS_err = str2num(get(handles.edRMS_err, 'String'));

bDraw = 1;

set(hObject,'Enable', 'off');

[p, q] = Fitting(p, q, v_n, S0, S_vecs, I, A0, nchannels, SD, H_inv, Mesh, a_height, a_width, warp_table, n_iters, RMS_err, Range_shape_proj_param, bDraw, handles);

set(hObject,'Enable', 'on');
% DrawShape( handles, q, p );

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% --- Executes during object creation, after setting all properties.
function slScale_CreateFcn(hObject, eventdata, handles)
% hObject    handle to slScale (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: slider controls usually have a light gray background, change
%       'usewhitebg' to 0 to use default.  See ISPC and COMPUTER.
usewhitebg = 1;
if usewhitebg
    set(hObject,'BackgroundColor',[.9 .9 .9]);
else
    set(hObject,'BackgroundColor',get(0,'defaultUicontrolBackgroundColor'));
end

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% --- Executes on slider movement.
function slScale_Callback(hObject, eventdata, handles)
% hObject    handle to slScale (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'Value') returns position of slider
%        get(hObject,'Min') and get(hObject,'Max') to determine range of slider
global q;
global p;
global max_scale;
global scale_weight;

currte_pos = get(handles.slScale, 'Value' );

scale = (currte_pos / 100) * max_scale;

q(1,1) = (scale - 1) * scale_weight;

DrawShape(handles, q, p);

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% --- Executes during object creation, after setting all properties.
function slTransX_CreateFcn(hObject, eventdata, handles)
% hObject    handle to slTransX (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: slider controls usually have a light gray background, change
%       'usewhitebg' to 0 to use default.  See ISPC and COMPUTER.
usewhitebg = 1;
if usewhitebg
    set(hObject,'BackgroundColor',[.9 .9 .9]);
else
    set(hObject,'BackgroundColor',get(0,'defaultUicontrolBackgroundColor'));
end

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% --- Executes on slider movement.
function slTransX_Callback(hObject, eventdata, handles)
% hObject    handle to slTransX (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'Value') returns position of slider
%        get(hObject,'Min') and get(hObject,'Max') to determine range of slider

global q;
global p;
global max_transX;
global trans_weight_x;
global trans_weight_y;

currte_pos = get(handles.slTransX, 'Value' );

trans_x = (currte_pos / 100) * max_transX * trans_weight_x;

q(3,1) = trans_x;

DrawShape(handles,q, p);

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% --- Executes during object creation, after setting all properties.
function slTransY_CreateFcn(hObject, eventdata, handles)
% hObject    handle to slTransY (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: slider controls usually have a light gray background, change
%       'usewhitebg' to 0 to use default.  See ISPC and COMPUTER.
usewhitebg = 1;
if usewhitebg
    set(hObject,'BackgroundColor',[.9 .9 .9]);
else
    set(hObject,'BackgroundColor',get(0,'defaultUicontrolBackgroundColor'));
end

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% --- Executes on slider movement.
function slTransY_Callback(hObject, eventdata, handles)
% hObject    handle to slTransY (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'Value') returns position of slider
%        get(hObject,'Min') and get(hObject,'Max') to determine range of slider

global q;
global p;
global max_transY;
global trans_weight_x;
global trans_weight_y;

currte_pos = get(handles.slTransY, 'Value' );

trans_y = (currte_pos /100) * max_transY * trans_weight_y;

q(4,1) = trans_y;

DrawShape(handles, q, p);


% --- Executes during object creation, after setting all properties.
function edNiters_CreateFcn(hObject, eventdata, handles)
% hObject    handle to edNiters (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc
    set(hObject,'BackgroundColor','white');
else
    set(hObject,'BackgroundColor',get(0,'defaultUicontrolBackgroundColor'));
end



function edNiters_Callback(hObject, eventdata, handles)
% hObject    handle to edNiters (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'String') returns contents of edNiters as text
%        str2double(get(hObject,'String')) returns contents of edNiters as a double


% --- Executes during object creation, after setting all properties.
function edRMS_err_CreateFcn(hObject, eventdata, handles)
% hObject    handle to edRMS_err (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc
    set(hObject,'BackgroundColor','white');
else
    set(hObject,'BackgroundColor',get(0,'defaultUicontrolBackgroundColor'));
end



% function edRMS_err_Callback(hObject, eventdata, handles)
% % hObject    handle to edRMS_err (see GCBO)
% % eventdata  reserved - to be defined in a future version of MATLAB
% % handles    structure with handles and user data (see GUIDATA)
% 
% % Hints: get(hObject,'String') returns contents of edRMS_err as text
% %        str2double(get(hObject,'String')) returns contents of edRMS_err as a double


% --------------------------------------------------------------------
function mOpenVideo_Callback(hObject, eventdata, handles)
% hObject    handle to mOpenVideo (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

global movfile;
global im;
global q;
global p;

[fn, path] = uigetfile('*.avi', 'Open AVI File');
movfile = [path, fn];
if ~isequal(fn, 0)
    % confirm it is a grayscale image
    info = aviinfo(movfile);
    % set the slider parameters
    set(handles.slVideo, 'Max', info.NumFrames);
    set(handles.slVideo, 'Min', 1);
    set(handles.slVideo, 'Value', 1);
    set(handles.txVideoFrameNum, 'String', ['共 ' num2str(info.NumFrames) '帧']);
    set(handles.txCurrentFrame, 'String', '当前为第1帧');
    % read and show the first frame
    mov = aviread(movfile, 1);
    im = rgb2gray(mov(1,1).cdata); 
         
    Generate_initial_p_q( handles );
    DrawShape( handles, q, p );
    
    % show the controls
    set(handles.btFit, 'Visible', 'on');
    set(handles.slScale, 'Visible', 'on');
    set(handles.slTransX, 'Visible', 'on');
    set(handles.slTransY, 'Visible', 'on');
    set(handles.slVideo, 'Visible', 'on');
    set(handles.txVideoFrameNum, 'Visible', 'on');
    set(handles.txCurrentFrame, 'Visible', 'on');
    set(handles.txNiters, 'String', '0');
    set(handles.txRMS_err, 'String', '10000');
end

% --- Executes during object creation, after setting all properties.
function slVideo_CreateFcn(hObject, eventdata, handles)
% hObject    handle to slVideo (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: slider controls usually have a light gray background, change
%       'usewhitebg' to 0 to use default.  See ISPC and COMPUTER.
usewhitebg = 1;
if usewhitebg
    set(hObject,'BackgroundColor',[.9 .9 .9]);
else
    set(hObject,'BackgroundColor',get(0,'defaultUicontrolBackgroundColor'));
end


% --- Executes on slider movement.
function slVideo_Callback(hObject, eventdata, handles)
% hObject    handle to slVideo (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'Value') returns position of slider
%        get(hObject,'Min') and get(hObject,'Max') to determine range of slider

global movfile;
global q;
global p;
global im;

n = round(get(hObject, 'Value'));
set(handles.txCurrentFrame, 'String', ['当前为第:' num2str(n) '帧']);
% read and show the frame 
mov = aviread(movfile, n);
im = rgb2gray(mov(1, 1).cdata);

DrawShape( handles, q, p );