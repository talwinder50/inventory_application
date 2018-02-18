package test.connector;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

public class ReadPropertyFileTest {
  public static void main(String[] args) {

	System.out.println(getProperty());
	
  }		
  public static Map<String,String> getProperty() 
  {
	  Properties prop = new Properties(); 
      Map<String,String>map = new HashMap<String,String>();
      try
      {   // File Input is a low level stream . Buffer reader is wrapper to it. 
          FileInputStream inputStream = new FileInputStream("/Users/harwinderkaur/Desktop/inventory/test_property_file/config.properties");
          BufferedInputStream br = new BufferedInputStream(inputStream);
          prop.load(br);
      }
      catch (Exception e) {
          e.printStackTrace();
          System.out.println("Some issue finding or loading file....!!! " + e.getMessage());

      }
      for (final Entry<Object, Object> entry : prop.entrySet()) {
          map.put((String) entry.getKey(), (String) entry.getValue());
      }
      return map;

}
}
