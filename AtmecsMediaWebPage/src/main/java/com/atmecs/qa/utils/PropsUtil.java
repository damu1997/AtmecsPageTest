package com.atmecs.qa.utils;


	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.util.Arrays;
	import java.util.List;
	import java.util.Properties;
	import com.atmecs.qa.constants.Constants;


	public class PropsUtil {
	private static PropsUtil propReader;
	private Properties prop;

	//loads all files
	private PropsUtil() {
	List<String> propsFiles = Arrays.asList(Constants.ALL_NAVI_LOC,Constants.CLIENT_ACHIEVE_LOC,Constants.CSR_LOC,Constants.EVENTS_LOC,Constants.NEWS_LOC);
	prop = new Properties();

	for (String filePath : propsFiles) {
	try {
	prop.load(new FileInputStream(new File(filePath)));
	} catch (FileNotFoundException e) {
	e.printStackTrace();
	} catch (IOException e) {
	e.printStackTrace();
	}
	}
	}



	 public static PropsUtil getInstance()
	 { 
	 if(propReader == null)
	propReader = new PropsUtil();
	 return propReader;
	 }


	public String getValue(String key) {
	return prop.getProperty(key);
	}

	
	}



	

