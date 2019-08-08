package com.atmecs.qa.helper;

import org.openqa.selenium.WebElement;

import com.atmecs.qa.constants.Constants;
import com.atmecs.qa.testbase.Base;
import com.atmecs.qa.utils.CommonUtils;
import com.atmecs.qa.utils.PropertyUtil;

public class EventsPageHelper extends Base {

	public static String slideBtn(String SlideDirection) {
		String Xpath = PropertyUtil.readPropertyFile(PropertyUtil.loadProperty(Constants.EVENTS_LOC), "slide_for_forward_backward").replace("***",SlideDirection);
		return Xpath;
	}

	public static String allheader() {
		String Xpath = PropertyUtil.readPropertyFile(PropertyUtil.loadProperty(Constants.EVENTS_LOC), "all_header_slide");
		return Xpath;
	}

	public static void navigatingForwardSides() {
		CommonUtils commutils=new CommonUtils();
		commutils.findsWebelement(driver, EventsPageHelper.slideBtn("Next"));
		commutils.waitForElement(driver, EventsPageHelper.slideBtn("Next"));
		commutils.click(driver, EventsPageHelper.slideBtn("Next"));
	}
	public static void navigatingBackwardSides() {
		CommonUtils commutils=new CommonUtils();
		commutils.findsWebelement(driver, EventsPageHelper.slideBtn("Previous"));
		commutils.waitForElement(driver, EventsPageHelper.slideBtn("Previous"));
		commutils.click(driver, EventsPageHelper.slideBtn("Previous"));
	}

	

	public static void navigateToEvents( ) {
		CommonUtils commutils=new CommonUtils();
		// media
		WebElement media = commutils.findsWebelement(driver, MediaPageHelper.allNavigationUnderMediaMenu("Media"));
		commutils.mouseOverElement(driver, media);
		// events
		commutils.waitForElement(driver, MediaPageHelper.allNavigationUnderMediaMenu("Events"));
		commutils.click(driver, MediaPageHelper.allNavigationUnderMediaMenu("Events"));
	}
}