package com.atmecs.qa.helper;

import org.openqa.selenium.WebElement;

import com.atmecs.qa.constants.Constants;
import com.atmecs.qa.testbase.Base;
import com.atmecs.qa.utils.CommonUtils;
import com.atmecs.qa.utils.PropertyUtil;

public class CsrPageHelper extends Base {

	public static String allHyperLinkgetProperty() {
		String Xpath = PropertyUtil.readPropertyFile(PropertyUtil.loadProperty(Constants.CSR_LOC), "hyper_links");
		return Xpath;
	}
	public static String commonHeadergetProperty() {
		String Xpath = PropertyUtil.readPropertyFile(PropertyUtil.loadProperty(Constants.CSR_LOC), "dav_and_scf_hyperlink_header");
		return Xpath;
	}


	public static String sjudeHeadergetProperty() {
		String Xpath = PropertyUtil.readPropertyFile(PropertyUtil.loadProperty(Constants.CSR_LOC), "HeaderSjude");
		return Xpath;
	}

	public static String ncfHeadergetProperty() {
		String Xpath = PropertyUtil.readPropertyFile(PropertyUtil.loadProperty(Constants.CSR_LOC), "NCFHeader");
		return Xpath;
	}

	public static String hfhHeadergetProperty() {
		String Xpath = PropertyUtil.readPropertyFile(PropertyUtil.loadProperty(Constants.CSR_LOC), "HFHHeaderImg");
		return Xpath;
	}

	public static String allHyperlinkgetProperty(String num) {
		String Xpath = PropertyUtil.readPropertyFile(PropertyUtil.loadProperty(Constants.CSR_LOC), "all_hyperlink")
				.replace("*", num);
		return Xpath;
	}

	public static void navigationToCsrPage() {
		CommonUtils commutils = new CommonUtils();
		// media
		WebElement media = commutils.findsWebelement(driver, MediaPageHelper.allNavigationUnderMediaMenu("Media"));
		commutils.mouseOverElement(driver, media);
		// our CSR
		commutils.waitForElement(driver, MediaPageHelper.allNavigationUnderMediaMenu("Our Joy of Giving – CSR"));
		commutils.click(driver, MediaPageHelper.allNavigationUnderMediaMenu("Our Joy of Giving – CSR"));
	}

	public static void assertinglinkHeader(String Xpath, String Headerxpath) {
		// validating DAV link
		CommonUtils commutils = new CommonUtils();
		commutils.waitForElement(driver, Xpath);
		commutils.click(driver, Xpath);
		commutils.verifyTrue(CommonUtils.isDisplayed(driver, Headerxpath), "passed");
		Base.driver.navigate().back();

	}
}
