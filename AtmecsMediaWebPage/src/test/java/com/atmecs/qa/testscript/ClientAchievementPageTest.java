package com.atmecs.qa.testscript;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.atmecs.qa.helper.ClientAchievementPageHelper;
import com.atmecs.qa.testbase.Base;
import com.atmecs.qa.utils.CommonUtils;
import com.atmecs.qa.utils.LogReporter;

/**
 * This class will performs the validation of all the link Header content count
 * and asserting readMore Button one by one
 * 
 * @author Damodaran.Krishnan
 *
 */
public class ClientAchievementPageTest extends Base {
	static CommonUtils commutils = new CommonUtils();
	LogReporter logreport = new LogReporter();
	String Msg = "passed";

	@Test(priority = 0)
	public void validatingAllHeaderContentCount() {
		ClientAchievementPageHelper.navigateToclientAchievements();
		List<WebElement> headerContent = commutils.getListOfWebElement(driver,
				ClientAchievementPageHelper.allReadMoregetProperty());
		List<String> listofheaderContent = commutils.convertListFromWebElement(driver, headerContent);
		commutils.verifyTrue(listofheaderContent.size() == headerContent.size(), "passed");
		logreport.info(listofheaderContent.toString());

	}

	@Test(priority = 1)
	public void validatingAllReadmore() {

		List<WebElement> readMoreLink = commutils.getListOfWebElement(driver,
				ClientAchievementPageHelper.allReadMoregetProperty());

		for (int i = 1; i <= readMoreLink.size(); i++) {

			if (commutils.waitForElement(driver,
					ClientAchievementPageHelper.oneByoneReadmoregetProperty().replace("l", String.valueOf(i)))) {
				commutils.click(driver,
						ClientAchievementPageHelper.oneByoneReadmoregetProperty().replace("l", String.valueOf(i)));

				switch (i) {
				case 1:
					commutils.verifyTrue(
							CommonUtils.isDisplayed(driver, ClientAchievementPageHelper.commonHeaderImgGetProperty()),
							Msg);
					break;
				case 2:
					commutils.verifyTrue(
							CommonUtils.isDisplayed(driver, ClientAchievementPageHelper.commonHeaderImgGetProperty()),
							Msg);
					break;
				case 3:
					commutils.verifyTrue(
							CommonUtils.isDisplayed(driver, ClientAchievementPageHelper.commonHeaderImgGetProperty()),
							Msg);
					break;
				case 4:
					commutils.verifyTrue(
							CommonUtils.isDisplayed(driver, ClientAchievementPageHelper.commonHeaderImgGetProperty()),
							Msg);
					break;
				case 5:
					commutils.verifyTrue(
							CommonUtils.isDisplayed(driver, ClientAchievementPageHelper.commonHeaderImgGetProperty()),
							Msg);
					break;
				case 6:
					commutils.verifyTrue(
							CommonUtils.isDisplayed(driver, ClientAchievementPageHelper.HyperLoopTextGetProperty()),
							Msg);
					break;
				case 7:
					commutils.verifyTrue(
							CommonUtils.isDisplayed(driver, ClientAchievementPageHelper.commonHeaderImgGetProperty()),
							Msg);
					break;

				default:
					break;
				}

			}

			driver.navigate().back();
		}

	}

}
