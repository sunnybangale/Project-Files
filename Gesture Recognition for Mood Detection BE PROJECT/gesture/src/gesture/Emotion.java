package gesture;


import java.awt.Image;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.awt.image.RenderedImage;
import java.io.BufferedOutputStream;
import java.io.DataInputStream; 
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket; 
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.GrayFilter;

import matlabcontrol.MatlabConnectionException;
import matlabcontrol.MatlabInvocationException;
import matlabcontrol.MatlabProxy;
import matlabcontrol.MatlabProxyFactory;
import matlabcontrol.MatlabProxyFactoryOptions;

public class Emotion {
	

	private static MatlabProxy proxy;
	private static int FILE_FOUND=0;
	
	 
	public static void main (String[] args) throws InterruptedException{
		
		initMatlabControls();
		
		try {
				proxy.eval("addpath('C:\\Users\\Owner\\Documents\\NetBeansProjects\\gesture')");
				proxy.feval("DepthGui1");
			
		} catch (MatlabInvocationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
       
	
		
		
		while(true)
		{
								
		Scanner scanner;
	        int N = 0;
	       int D = 0;
	      int MatlabCount=0;
		                    
		
							File ABC=new File("MATLAB_RESULT.txt");
							if(ABC.exists()) 
							{	
								try {
										scanner = new Scanner(ABC);
										while(scanner.hasNextInt())
										{
											if(MatlabCount==0)
											{
												N = scanner.nextInt();
												System.out.println("I Got N="+ N);
												MatlabCount=MatlabCount+1;
											}
											else
											{
												D = scanner.nextInt();
												System.out.println("I Got D="+ D);
											}
											
											FILE_FOUND=1;
										}
										
										ABC.delete();
								    } 
									catch (FileNotFoundException e) 
									{
								    	// TODO Auto-generated catch block
								    	e.printStackTrace();
								    }
								
							}
						
							else
							{
								System.out.println("File Does Not Exist");
							}
							
		
		if(FILE_FOUND==1)
			
			break;			
					    
		}			
				
				
			 		 
			
 }// main ends

	private static void initMatlabControls() {
		// TODO Auto-generated method stub
		
	    	MatlabProxyFactoryOptions options =
	 	           new MatlabProxyFactoryOptions.Builder()
	 				   .setMatlabLocation("C:\\Program Files\\MATLAB\\R2011b\\bin\\matlab.exe")
	 	               .setUsePreviouslyControlledSession(true)
	 	               .build();
	 	       MatlabProxyFactory factory = new MatlabProxyFactory(options);
	 	      try
	 	      {
	 	    	  proxy = factory.getProxy();
	 	      }
	 	     catch(Exception e)
	 		{
	 		
		
	 		} finally {
				}
	    
	    
	}
		
		
	
}// class ends



	


