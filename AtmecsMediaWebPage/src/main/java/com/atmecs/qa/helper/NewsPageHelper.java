package com.atmecs.qa.helper;

import org.openqa.selenium.WebElement;

import com.atmecs.qa.constants.Constants;
import com.atmecs.qa.testbase.Base;
import com.atmecs.qa.utils.CommonUtils;
import com.atmecs.qa.utils.PropertyUtil;

public class NewsPageHelper extends Base {

	public static String pdfTitlegetProperty() {
		String Xpath = PropertyUtil.readPropertyFile(PropertyUtil.loadProperty(Constants.NEWS_LOC), "pdftitle");
		return Xpath;
	}

	public static String allBtngetProperty(String Btn) {
		String Xpath = PropertyUtil.readPropertyFile(PropertyUtil.loadProperty(Constants.NEWS_LOC), "all_btn")
				.replace("*", Btn);
		return Xpath;
	}

	public static String SingleReadMoreBtngetProperty(int i) {
		String Xpath = PropertyUtil.readPropertyFile(PropertyUtil.loadProperty(Constants.NEWS_LOC),
				"single_readmore_btn").replace("*",String.valueOf(i));
		return Xpath;
	}

	public static String allReadMoreBtngetProperty() {
		String Xpath = PropertyUtil.readPropertyFile(PropertyUtil.loadProperty(Constants.NEWS_LOC), "all_readmore_btn");
		return Xpath;
	}

	public static void navigateToNews() {
		CommonUtils commutils = new CommonUtils();
		// media
		WebElement media = commutils.findsWebelement(driver, MediaPageHelper.allNavigationUnderMediaMenu("Media"));
		commutils.mouseOverElement(driver, media);
		// news
		commutils.waitForElement(driver, MediaPageHelper.allNavigationUnderMediaMenu("News"));
		commutils.click(driver, MediaPageHelper.allNavigationUnderMediaMenu("News"));

	}

	public static void assertingWatchMoreBtn() {
		navigateToNews();
	
	
		
		CommonUtils commutils = new CommonUtils();
//asserting WatchNow button
		commutils.waitForElement(driver, NewsPageHelper.allBtngetProperty("1"));
		commutils.click(driver, NewsPageHelper.allBtngetProperty("1"));
		String oghandle = driver.getWindowHandle();
		System.out.println("after news"+oghandle);
		commutils.verifyTrue(CommonUtils.isDisplayed(driver, MediaPageHelper.allHeadergetProperty()), "passed");
		driver.switchTo().window(oghandle);
	}
}
