/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gesture;

import java.util.Date;
import matlabcontrol.MatlabConnectionException;
import matlabcontrol.MatlabInvocationException;
import matlabcontrol.MatlabProxy;
import matlabcontrol.MatlabProxy.MatlabThreadProxy;
import matlabcontrol.MatlabProxyFactory;
import matlabcontrol.MatlabProxyFactoryOptions;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
 
/**
 *
 * @author Owner
 */
public class matlab {
 
    
    
     public static void main(String[] args)
        throws MatlabConnectionException, MatlabInvocationException
    {
        // create proxy
         MatlabProxyFactoryOptions options =
            new MatlabProxyFactoryOptions.Builder()
                .setUsePreviouslyControlledSession(true).build();
        MatlabProxyFactory factory = new MatlabProxyFactory(options);
        MatlabProxy proxy = factory.getProxy();

        // call function and get output cell array
        String in = "Stack Overflow";
      Object[] out = proxy.returningFeval("DepthGui1",1,"test");

      
  /*    
           out = (Object[]) out[0];
        String str = (String) out[0];
        double x = ((double[]) out[1])[0];

System.out.println("result is "+x);     
*/


     //   proxy.setVariable("Current Folder","");
        // proxy.returningFeval("DepthGui1", 1);
         
        
        
        //proxy.feval("DepthGui1");
         
         
      
/*                
           long start = new Date().getTime();
         while(new Date().getTime() - start < 30000L){}

          start = new Date().getTime();
         while(new Date().getTime() - start < 10000L){}
         
*/         
         
    
         
         
  /*     // extract stuff from cell array
        out = (Object[]) out[0];
        String str = (String) out[0];
        double x = ((double[]) out[1])[0];
        double[] arr = (double[]) out[2];

        // show result
        System.out.println("str =\n " + str);
        System.out.println("x = \n " + x);
        System.out.println("arr =");
        for(int i=0; i < arr.length; i++) {
            System.out.println(" " + arr[i]);
        }
*/
        // shutdown MATLAB
        //proxy.feval("quit");

        // close connection
        proxy.disconnect();
    }
    
}
