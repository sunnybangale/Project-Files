function varargout = AnnotateGUI(varargin)
% AnnotateGUI M-file for AnnotateGUI.fig
%      AnnotateGUI, by itself, creates a new AnnotateGUI or raises the existing
%      singleton*.
%
%      H = AnnotateGUI returns the handle to a new AnnotateGUI or the handle to
%      the existing singleton*.
%
%      AnnotateGUI('CALLBACK',hObject,eventData,handles,...) calls the local
%      function named CALLBACK in AnnotateGUI.M with the given input arguments.
%
%      AnnotateGUI('Property','Value',...) creates a new AnnotateGUI or raises the
%      existing singleton*.  Starting from the left, property value pairs are
%      applied to the GUI before AnnotateGUI_OpeningFunction gets called.  An
%      unrecognized property name or invalid value makes property application
%      stop.  All inputs are passed to AnnotateGUI_OpeningFcn via varargin.
%
%      *See GUI Options on GUIDE's Tools menu.  Choose "GUI allows only one
%      instance to run (singleton)".
%
% See also: GUIDE, GUIDATA, GUIHANDLES

% Edit the above text to modify the response to help AnnotateGUI

% Last Modified by GUIDE v2.5 23-Apr-2004 22:40:59

% Begin initialization code - DO NOT EDIT
gui_Singleton = 1;
gui_State = struct('gui_Name',       mfilename, ...
                   'gui_Singleton',  gui_Singleton, ...
                   'gui_OpeningFcn', @AnnotateGUI_OpeningFcn, ...
                   'gui_OutputFcn',  @AnnotateGUI_OutputFcn, ...
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


% --- Executes just before AnnotateGUI is made visible.
function AnnotateGUI_OpeningFcn(hObject, eventdata, handles, varargin)
% This function has no output args, see OutputFcn.
% hObject    handle to figure
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
% varargin   command line arguments to AnnotateGUI (see VARARGIN)

% Choose default command line output for AnnotateGUI
handles.output = hObject;

% Update handles structure
guidata(hObject, handles);

% DO INITIALIZATION
global im;
global movfile;

global dest_dir;

dest_dir = 'f:';

set(handles.edDestDir, 'String', dest_dir);
set(handles.btAnnotate, 'visible', 'off');
set(handles.slVideo,   'visible', 'off');
set(handles.txNotice, 'visible', 'off');
% UIWAIT makes AnnotateGUI wait for user response (see UIRESUME)
 % uiwait(handles.figure1);

% at first, we hide the controls
set(handles.slVideo, 'Visible', 'off');
set(handles.txVideoFrameNum, 'Visible', 'off');
set(handles.txCurrentFrame, 'Visible', 'off');

% --- Outputs from this function are returned to the command line.
function varargout = AnnotateGUI_OutputFcn(hObject, eventdata, handles)
% varargout  cell array for returning output args (see VARARGOUT);
% hObject    handle to figure
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Get default command line output from handles structure
varargout{1} = handles.output;

clear;


% --------------------------------------------------------------------
function mOpenVideo_Callback(hObject, eventdata, handles)
% hObject    handle to mOpenVideo (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

global movfile;
global im;

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
    im = mov(1,1).cdata; 
           
    axes(handles.axes1);
    imshow(im);
    
    % show the controls
    set(handles.slVideo, 'Visible', 'on');
    set(handles.txVideoFrameNum, 'Visible', 'on');
    set(handles.txCurrentFrame, 'Visible', 'on');   
    
    set(handles.btAnnotate, 'visible', 'on');
    set(handles.txNotice, 'visible', 'on');
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
global im;

n = round(get(hObject, 'Value'));
set(handles.txCurrentFrame, 'String', ['当前为第:' num2str(n) '帧']);
% read and show the frame 
mov = aviread(movfile, n);
im = mov(1, 1).cdata;

axes(handles.axes1);
imshow(im);


% --- Executes on button press in btAnnotate.
function btAnnotate_Callback(hObject, eventdata, handles)
% hObject    handle to btAnnotate (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

global im;
global dest_dir;

dest_dir = get(handles.edDestDir, 'String');

file_name = num2str(round(get(handles.slVideo, 'Value')));

axes(handles.axes1);
set(handles.btAnnotate, 'Enable', 'off');
annotate(dest_dir, im, file_name, handles);
set(handles.btAnnotate, 'Enable', 'on');

imshow(im);

% --- Executes during object creation, after setting all properties.
function edDestDir_CreateFcn(hObject, eventdata, handles)
% hObject    handle to edDestDir (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc
    set(hObject,'BackgroundColor','white');
else
    set(hObject,'BackgroundColor',get(0,'defaultUicontrolBackgroundColor'));
end



function edDestDir_Callback(hObject, eventdata, handles)
% hObject    handle to edDestDir (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'String') returns contents of edDestDir as text
%        str2double(get(hObject,'String')) returns contents of edDestDir as a double


