package com.atmecs.qa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtil {
/**
 * 
 * @param filePath
 * @return loads the property returns prop reference  
 * 
 */
	
	public static Properties loadProperty(String filePath) {
		Properties prop = new Properties();
		FileInputStream input;
		try {
			input = new FileInputStream(filePath);
			prop.load(input);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}
/**
 * 
 * @param props
 * @param key
 * @return reads the .properties file and return the value
 */
	
	public static String readPropertyFile(Properties props,String key) {
        String Xpath = props.getProperty(key);
        return Xpath;
    }
	
	
		
		
	
	
	
}
