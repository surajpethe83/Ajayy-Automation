package utility;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationAPI {

	 static Properties prop;

	    static { //A static block executes only once when the class is loaded (before any method calls).
	        try {
	        	//open file to read values
	            FileInputStream fis = new FileInputStream("src/main/resources/configurationAPI.properties");
	            //hold key-value pairs from the properties file.
	            prop = new Properties();
	            //This loads all values from the file into memory.
	            prop.load(fis);
	        } catch (Exception e) { e.printStackTrace(); }
	    }

	    public static String getProperty(String key){
	        return prop.getProperty(key);
	        //Accepts a key (like "url", "browser", "username").
	        //Returns the value from config.properties.
	    }
	
}
