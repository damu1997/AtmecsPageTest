package com.atmecs.qa.testscript;

import org.testng.annotations.Test;

import org.openqa.selenium.WebElement;
import com.atmecs.qa.helper.MediaPageHelper;
import com.atmecs.qa.testbase.Base;
import com.atmecs.qa.utils.CommonUtils;

/**
 * This class will performs the validation of all the Navigation of Media's sub
 * content
 * 
 * @author Damodaran.Krishnan
 *
 */
public class MediaPageTest extends Base {

	CommonUtils commutils = new CommonUtils();
	WebElement Media;

	@Test
	public void AllNavigationUnderMedia() {

		MediaPageHelper.assertingNavigatedPageHeader(
				MediaPageHelper.allNavigationUnderMediaMenu("News"),
				MediaPageHelper.allHeadergetProperty());

		MediaPageHelper.assertingNavigatedPageHeader(
				MediaPageHelper.allNavigationUnderMediaMenu("Our Joy of Giving – CSR"),
				MediaPageHelper.allHeadergetProperty());

		MediaPageHelper.assertingNavigatedPageHeader(
				MediaPageHelper.allNavigationUnderMediaMenu("Events"),
				MediaPageHelper.allHeadergetProperty());

		MediaPageHelper.assertingNavigatedPageHeader(
				MediaPageHelper.allNavigationUnderMediaMenu("Client Achievements"),
				MediaPageHelper.allHeadergetProperty());

	}

}
