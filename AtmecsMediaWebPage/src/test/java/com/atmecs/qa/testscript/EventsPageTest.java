package com.atmecs.qa.testscript;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.atmecs.qa.helper.EventsPageHelper;
import com.atmecs.qa.testbase.Base;
import com.atmecs.qa.utils.CommonUtils;

/**
 * This class will performs the validation of slides in forward and Backward
 * direction Assertion done with respect to the header content
 * 
 * @author Damodaran.Krishnan
 *
 */
public class EventsPageTest extends Base {
	CommonUtils commutils = new CommonUtils();


	@Test
	public void ForwardandBackwardvalidateSlides() {
		// navigating to news
		EventsPageHelper.navigateToEvents();

		// get the list of slides
		List<WebElement> list = commutils.getListOfWebElement(driver, EventsPageHelper.allheader());

		// Navigating the Slides Forward direction
		for (int i = 0; i <= list.size(); i++) {
			EventsPageHelper.navigatingForwardSides();
		}
		commutils.verifyTrue(CommonUtils.isDisplayed(driver, EventsPageHelper.allheader()), "passed");

		// Navigating the Slides Backward direction
		for (int i = 0; i <= list.size(); i++) {
			EventsPageHelper.navigatingBackwardSides();
		}
		commutils.verifyTrue(CommonUtils.isDisplayed(driver, EventsPageHelper.allheader()), "passed");
	}

}
