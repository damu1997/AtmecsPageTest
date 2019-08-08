package com.atmecs.qa.helper;

import org.openqa.selenium.WebElement;

import com.atmecs.qa.constants.Constants;
import com.atmecs.qa.testbase.Base;
import com.atmecs.qa.utils.CommonUtils;
import com.atmecs.qa.utils.PropertyUtil;

public class ClientAchievementPageHelper extends Base {
	public static String allReadMoregetProperty() {
		String Xpath = PropertyUtil.readPropertyFile(PropertyUtil.loadProperty(Constants.CLIENT_ACHIEVE_LOC),
				"all_header_content_readmore_btn");
		return Xpath;
	}

	public static String oneByoneReadmoregetProperty() {
		String Xpath = PropertyUtil.readPropertyFile(PropertyUtil.loadProperty(Constants.CLIENT_ACHIEVE_LOC),
				"one_by_one_readmore_btn");
		return Xpath;
	}

	public static String HyperLoopTextGetProperty() {
		String Xpath = PropertyUtil.readPropertyFile(PropertyUtil.loadProperty(Constants.CLIENT_ACHIEVE_LOC),
				"HyperLoopText");
		return Xpath;
	}

	public static String commonHeaderImgGetProperty() {
		String Xpath = PropertyUtil.readPropertyFile(PropertyUtil.loadProperty(Constants.CLIENT_ACHIEVE_LOC),
				"common_header_img");
		return Xpath;
	}

	public static void navigateToclientAchievements() {
		CommonUtils commutils = new CommonUtils();
		// media
		WebElement media = commutils.findsWebelement(driver, MediaPageHelper.allNavigationUnderMediaMenu("Media"));
		commutils.mouseOverElement(driver, media);
		// client-ach
		commutils.waitForElement(driver, MediaPageHelper.allNavigationUnderMediaMenu("Client Achievements"));
		commutils.click(driver, MediaPageHelper.allNavigationUnderMediaMenu("Client Achievements"));
	}

}
