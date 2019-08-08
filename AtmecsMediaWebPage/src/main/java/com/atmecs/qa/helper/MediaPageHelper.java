package com.atmecs.qa.helper;

import org.openqa.selenium.WebElement;

import com.atmecs.qa.constants.Constants;
import com.atmecs.qa.testbase.Base;
import com.atmecs.qa.utils.CommonUtils;
import com.atmecs.qa.utils.PropertyUtil;

public class MediaPageHelper extends Base {
//getting all header content from xpath
	public static String allHeadergetProperty() {
		String Xpath = PropertyUtil.readPropertyFile(PropertyUtil.loadProperty(Constants.ALL_NAVI_LOC), "all_page_title");
		return Xpath;
	}

//getting home xpath
	public static String navigateBackToHome() {
		String Xpath = PropertyUtil.readPropertyFile(PropertyUtil.loadProperty(Constants.ALL_NAVI_LOC),
				"navigate_back_home");
		return Xpath;
	}

//mousehovertomedia
	public static void mouseHoverToMedia() {

		CommonUtils commutils = new CommonUtils();
		WebElement Media = commutils.findsWebelement(driver, MediaPageHelper.allNavigationUnderMediaMenu("Media"));
		commutils.mouseOverElement(driver, Media);
	}

//back to home
	public static void navigateBackToHomeSetup() {
		CommonUtils commutils = new CommonUtils();
		commutils.waitForElement(driver, MediaPageHelper.navigateBackToHome());
		commutils.click(driver, MediaPageHelper.navigateBackToHome());
	}

//asserting the header content
	public static void assertingNavigatedPageHeader(String Xpath, String HeaderXpath) {
		CommonUtils commutils = new CommonUtils();
		mouseHoverToMedia();
		commutils.waitForElement(driver, Xpath);
		commutils.click(driver, Xpath);
		commutils.verifyTrue(CommonUtils.isDisplayed(driver, HeaderXpath), "passed");
		navigateBackToHomeSetup();
	}

//getting all the xpath of media submenu 
	public static String allNavigationUnderMediaMenu(String menuName) {
		String Xpath = PropertyUtil
				.readPropertyFile(PropertyUtil.loadProperty(Constants.ALL_NAVI_LOC), "all_sub_menu_of_media")
				.replace("****", menuName);
		return Xpath;

	}

}
