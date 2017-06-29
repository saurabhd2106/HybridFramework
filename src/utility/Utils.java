package utility;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Utils {
	
	public static Properties getProperty(String filename) throws Exception{
		
		InputStream inputStream;
		
		Properties property = new Properties();
		
		inputStream = new FileInputStream(filename);
		
		property.load(inputStream);
		
		return property;
	}

}
