%Recording sound:
%aro=audiorecorder(16000,8000,1);
%vector aro,16000 sample,rate 8kHz, (1) mono/(2) sterio
%record(aro);% Start record
%stop(aro);%End record
%pause();
%resume();
Fs = 11025;
% 5s,16 bits,sampled at 11025Hz
aro = wavrecord(2*Fs,Fs,'int16');
%%wavplay(aro,Fs);

%Convert into more usual vector
%speech=getaudiodata(aro, 'double');

%Play sound
%sound(speech, 8000);
%soundsc(speech, 8000);% scales both directions, vector can be amlified

%Plot
%plot(speech);
%plot( [ 1: size(aro) ] / Fs, aro);

%File write
wavwrite(aro,Fs,16,'P') 

%File read
fid=fopen('P.wav','r');
%Read into vector 'speech' entire file of 16bit, format IEEE little endian, or can be 'ieee-be'
%speech=fread(fid , inf ,'int16' , 0, 'ieee-le');% bad quality
speech = wavread('P.wav');
fclose(fid);
sound(speech,Fs);