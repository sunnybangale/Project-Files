

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.Properties;

import javax.swing.JOptionPane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thingworx.communications.client.ClientConfigurator;
import com.thingworx.communications.client.ConnectedThingClient;
import com.thingworx.relationships.RelationshipTypes.ThingworxEntityTypes;

import com.thingworx.types.InfoTable;
import com.thingworx.types.collections.ValueCollection;
import com.thingworx.types.primitives.BooleanPrimitive;
import com.thingworx.types.primitives.DatetimePrimitive;
import com.thingworx.types.primitives.IntegerPrimitive;
import com.thingworx.types.primitives.LocationPrimitive;
import com.thingworx.types.primitives.NumberPrimitive;
import com.thingworx.types.primitives.StringPrimitive;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class SimpleClient extends ConnectedThingClient 
{

private static final Logger LOG = LoggerFactory.getLogger(SimpleClient.class);

private static String ThingName1 = "TaskiSwingo";

         
        
	

public SimpleClient(ClientConfigurator config) throws Exception {
	super(config);
}

public static void main(String[] args) throws InterruptedException{


final GpioController gpio = GpioFactory.getInstance();
       
// provision gpio pin #01 as an output pin and turn on
final GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "MyLED", PinState.LOW);
        
pin.setShutdownOptions(true, PinState.LOW);  

	
ClientConfigurator config = new ClientConfigurator();
	
	// Set the URI of the server that we are going to connect to.
	// You must include the port number in the URI.
	config.setUri("ws://10.155.98.177:8080/Thingworx//WS");
		
	// Set the ApplicationKey. This will allow the client to authenticate with the server.
	// It will also dictate what the client is authorized to do once connected.
	config.setAppKey("6af718fb-1c03-4ebf-bb67-3ad3dd99f2bc");
		
		
	// This will allow us to test against a server using a self-signed certificate.
	// This should be removed for production systems.
	config.ignoreSSLErrors(true); // All self signed certs
	
	try {
			
		// Create our client.
		SimpleClient client = new SimpleClient(config);
			
			// Start the client. The client will connect to the server and authenticate
			// using the ApplicationKey specified above.
			client.start();
			
			
			// Wait for the client to connect.
			if (client.waitForConnection(30000)) {
				
				BufferedReader br;
				br = new BufferedReader(new FileReader("Simulator.txt"));
				
				
				
				
				
			String sCurrentLine = br.readLine();
			
			//led light = new led();
				
			while(client.isConnected() && sCurrentLine != null)
			{	
				// We may now interact with the ThingWorx Server
				InfoTable result1;
				InfoTable result2;
				
				InfoTable result3;
				InfoTable result4;
				
				
				//
				// Reading a property of a Thing
				///////////////////////////////////////////////////////////////
				
				// Request a property from a Thing on the Platform. Here we access the 'name'
				// property of a Thing.
				result1 = client.readProperty(ThingworxEntityTypes.Things, ThingName1, "AlertStatus", 10000);
				
				
				result3 = client.readProperty(ThingworxEntityTypes.Things, ThingName1, "ManualAlert", 10000);
			
				
				
				
				// Result is returned as an InfoTable, so we must extract the value. An InfoTable
				// is a collection of one or more rows. A row can have multiple fields. Each 
				// field has a name and a base type. In this case, the field name is 'name' and
				// the base type is STRING, so we can use the getStringValue() helper.
				String AlertStatus1 = result1.getFirstRow().getStringValue("AlertStatus");
				
				
				String ManualAlert1= result3.getFirstRow().getStringValue("ManualAlert");
				
				
				
				System.out.println("Alert 1 "+AlertStatus1);
				if(AlertStatus1=="true" ||  ManualAlert1=="true" )
					pin.high();
				else
					pin.low();
				//JOptionPane.showMessageDialog(null, "Alert 1 "+AlertStatus1+ " Alert 2 "+ AlertStatus2 );
				
				System.out.println(" Manual Alert 1 "+ ManualAlert1 );
				/*if(ManualAlert1=="true" || ManualAlert2=="true"  )
					pin.high();
				else
					pin.low();
				*///JOptionPane.showMessageDialog(null, " Manual Alert 1 "+ ManualAlert1 + " Manual Alert 2 "+ ManualAlert2 );
				
				
				
				//
				// Writing a property
				///////////////////////////////////////////////////////////////
				
				/*
				IntegerPrimitive speedLimit = new IntegerPrimitive(sl);
				client.writeProperty(ThingworxEntityTypes.Things, ThingName1, "SpeedHighLimit", speedLimit, 5000);
				client.writeProperty(ThingworxEntityTypes.Things, ThingName2, "SpeedHighLimit", speedLimit, 5000);
				
				IntegerPrimitive temperatureLimit = new IntegerPrimitive(tl);
				client.writeProperty(ThingworxEntityTypes.Things, ThingName1, "TemperatureHighLimit", temperatureLimit, 5000);
				client.writeProperty(ThingworxEntityTypes.Things, ThingName2, "TemperatureHighLimit", temperatureLimit, 5000);
				*/
				
								
				DHT11 dht = new DHT11();
				double temp[]= new double[3];
				temp=dht.getTemperature();
				

				
		      
		            System.out.println(sCurrentLine);
		            String[] data = sCurrentLine.split(",");
		            //double newTemperature = Double.parseDouble(data[3]);
		          
		            
			    double newTemperature = temp[1];
			    double newHumidity=temp[0];
		            
		            
		            double newSpeed = Double.parseDouble(data[2]);
		            newSpeed = Double.parseDouble(new DecimalFormat("#.##").format(newSpeed));
		            double newLongitude = Double.parseDouble(data[1]);
		            double newLatitude = Double.parseDouble(data[0]);
					double batteryCapacity = Double.parseDouble(data[3]);
					String currentProcess = data[4];
					double brushSpeed = Double.parseDouble(data[5]);
		           
		            //Location newLocation = new Location(Double.valueOf(newLongitude), Double.valueOf(newLatitude), Double.valueOf(0.0));
		            
		            LocationPrimitive location1 = new LocationPrimitive( Double.valueOf(newLatitude),Double.valueOf(newLongitude), Double.valueOf(0.0));
					// This will set the CurrentLocation property of the Thing to the GPS 
					// coordinates of Boston, MA.
					client.writeProperty(ThingworxEntityTypes.Things, ThingName1, "Location", location1, 5000);
					

					
					
					
					NumberPrimitive temperature1 = new NumberPrimitive(newTemperature);
					if(temp[1]!=-1)
					client.writeProperty(ThingworxEntityTypes.Things, ThingName1, "BatteryTemprature", temperature1, 5000);
					


					
					NumberPrimitive humidity1 = new NumberPrimitive(newHumidity);
					if(temp[0]!=-1)
					client.writeProperty(ThingworxEntityTypes.Things, ThingName1, "AmbientHumidity", humidity1, 5000);
					


					
					NumberPrimitive speed1 = new NumberPrimitive(newSpeed);
					client.writeProperty(ThingworxEntityTypes.Things, ThingName1, "TransportationSpeed", speed1, 5000);
					
					
					NumberPrimitive capacity1 = new NumberPrimitive(batteryCapacity);
					client.writeProperty(ThingworxEntityTypes.Things, ThingName1, "BatteryCapacity", capacity1, 5000);
					
					
					StringPrimitive currentProcess1 = new StringPrimitive(currentProcess);
					client.writeProperty(ThingworxEntityTypes.Things, ThingName1, "CurrentProcess", currentProcess1, 5000);
					
					NumberPrimitive brushSpeed1 = new NumberPrimitive(brushSpeed);
					client.writeProperty(ThingworxEntityTypes.Things, ThingName1, "BrushSpeed", brushSpeed1, 5000);
				

		        
					
					sCurrentLine = br.readLine();
					Thread.sleep(1000);
		        }
				
			} else {
				// Log this as a warning. In production the application could continue
				// to execute, and the client would attempt to reconnect periodically.
				LOG.warn("Client did not connect within 30 seconds. Exiting");
			}
			
			client.shutdown();
		
		} catch (Exception e) {
			LOG.error("An exception occured while initializing the client", e);
		}
		
		LOG.info("SimpleClient is done. Exiting");
	}
}
