package com.atmecs.qa.constants;

import java.io.File;
/**
 * This class contains path of all the files
 * @author Damodaran.Krishnan
 *
 */
public class Constants {

	public final static String PROJECT_BASE_PATH = System.getProperty("user.dir");
	public final static long PAGE_LODE_TIMEOUT = 40;
	public final static long IMPLICIT_WAIT = 4000;
	public final static String LOCATORS_PATH = PROJECT_BASE_PATH + File.separator + "resources" + File.separator
			+ "locators" + File.separator;
	public final static String ALL_NAVI_LOC = LOCATORS_PATH + "allnavigate.properties";
	public final static String NEWS_LOC = LOCATORS_PATH + "news.properties";
	public final static String EVENTS_LOC = LOCATORS_PATH + "events.properties";
	public final static String CSR_LOC = LOCATORS_PATH + "csr.properties";
	public final static String CLIENT_ACHIEVE_LOC = LOCATORS_PATH + "clientachievement.properties";
	public final static String LOG_4J = PROJECT_BASE_PATH + File.separator + "resources" + File.separator
			+ "log4j.properties";

	public static void main(String[] args) {
		System.out.println(LOG_4J);
	}

}
