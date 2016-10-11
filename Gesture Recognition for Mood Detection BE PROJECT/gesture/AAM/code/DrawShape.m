function DrawShape(handles, q, p)
global v_n;
global S0;
global Mesh;
global S_vecs;
global im;

global fn;
global path;
global ifDone;
global time;

% first do shape transform
S_p = S_vecs * p + S0;

% then do global shape transform 
S_p_star = Get_S_x_star( v_n, S_p );

S_p_q = S_p_star * q + S_p;
S = round( S_p_q );

S_p_q = reshape( S_p_q, v_n, 2 );

% plot the shape on the current axes
axes(handles.axes1);
imshow(im);
hold on;
axis ij;
axis equal;

triplot( Mesh, S_p_q(:, 1), S_p_q(:, 2), 'r');
% plot(S_p_q(14,1), S_p_q(14,2), 'r+');
% plot(S_p_q(16,1), S_p_q(16,2), 'r+');
% plot(S_p_q(18,1), S_p_q(18,2), 'r+');
% plot(S_p_q(20,1), S_p_q(20,2), 'r+');
% plot(S_p_q(22,1), S_p_q(22,2), 'r+');
% plot(S_p_q(24,1), S_p_q(24,2), 'r+');
% plot(S_p_q(26,1), S_p_q(26,2), 'r+');
% plot(S_p_q(28,1), S_p_q(28,2), 'r+');
% plot(S_p_q(40,1), S_p_q(40,2), 'r+');
% plot(S_p_q(42,1), S_p_q(42,2), 'r+');
% plot(S_p_q(44,1), S_p_q(44,2), 'r+');
% plot(S_p_q(46,1), S_p_q(46,2), 'r+');

hold off;

if(ifDone==1)
    % save the features points we have just fitted
    x2(1,:) = S_p_q(22,:);
    x2(2,:) = S_p_q(24,:);
    x2(3,:) = S_p_q(26,:);
    x2(4,:) = S_p_q(28,:);
    x2(5,:) = S_p_q(18,:);
    x2(6,:) = S_p_q(16,:);
    x2(7,:) = S_p_q(14,:);
    x2(8,:) = S_p_q(20,:);
    x2(9,:) = S_p_q(40,:);
    x2(10,:) = S_p_q(42,:);
    x2(11,:) = S_p_q(44,:);
    x2(12,:) = S_p_q(46,:);
    
    % load the the mark file of the features points
%     sl = size(fn,2);
%     filename = fn(1, 1:sl-4);
%     load([path, filename, '.mat']);
%     x0 = [x y];
%     eye_l = sum((x0(1,:)-x0(3,:)).^2, 2)^0.5;
%     mouth_l = sum((x0(9,:)-x0(11,:)).^2, 2)^0.5;
%     % calculate the relative error
%     error = x2-x0;
%     error = error.^2;
%     error = sum(error,2);
%     error = error.^0.5;
%     error(1:8,:) = error(1:8,:)/eye_l;
%     error(9:12,:) = error(9:12,:)/mouth_l;
% 
%     % save the result
%     % first load the existing file and add a new record
%     load([path,'err_aam.mat']);
%     nRecords = size(err_aam,2);
%     err_aam(nRecords+1).data = error;
%     err_aam(nRecords+1).avg  = mean(error);
%     err_aam(nRecords+1).date = datestr(now);
%     err_aam(nRecords+1).file = fn;
%     err_aam(nRecords+1).time = time;
%     %err(nRecords+1).price = 1/(mean(error) * time);
%     % write back
%     save([path,'err_aam.mat'], 'err_aam');
end

drawnow;
