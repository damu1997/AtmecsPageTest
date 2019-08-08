package com.atmecs.qa.utils;

import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import com.atmecs.qa.constants.Constants;



public class LogReporter {
Logger logger = null;
	
	public LogReporter() {
		
		getlogger();
		logger = Logger.getLogger(LogReporter.class.getName());
	}
	
	public void getlogger() {
		PropertyConfigurator.configure(Constants.LOG_4J);
	}

	public void info(String message){
		logger.info(message);
	}
	
	
	public void debug(String message){
		
	}
	public static void main(String[] args) {
		
	LogReporter rep=new LogReporter();
	rep.getlogger();
		rep.info("will");
		rep.getlogger();
	}
}
