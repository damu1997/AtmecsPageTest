package com.atmecs.qa.testscript;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.atmecs.qa.helper.NewsPageHelper;
import com.atmecs.qa.testbase.Base;
import com.atmecs.qa.utils.CommonUtils;
import com.atmecs.qa.utils.LogReporter;

/**
 * This class will performs the validation of watchMore button and all the
 * ReadMore button Assertion done with respect to the header content
 * 
 * @author Damodaran.Krishnan
 *
 */
public class NewsPageTest extends Base {
	CommonUtils commutils = new CommonUtils();
	LogReporter logreport = new LogReporter();
	String Text;

	@Test(priority = 0)
	public void validatingWatchMoreBtn() {
	
		
		NewsPageHelper.assertingWatchMoreBtn();
		
		
		

	}

	@Test(priority = 1)
	public void validatingAllReadMore() throws InterruptedException {
		//NewsPageHelper.navigateToNews();
//Getting the web element into list
		List<WebElement> readMoreLink = commutils.getListOfWebElement(driver,
				NewsPageHelper.allReadMoreBtngetProperty());

		logreport.info(String.valueOf(readMoreLink.size()));
		String oghandle = driver.getWindowHandle();
		System.out.println("og"+oghandle);
		for (int i = 2; i <= readMoreLink.size(); i++) {

			if (commutils.waitForElement(driver, NewsPageHelper.SingleReadMoreBtngetProperty(i))) {

				commutils.click(driver, NewsPageHelper.SingleReadMoreBtngetProperty(i));
				 
				driver.switchTo().window(oghandle);
				 

			}
		}
	}

}
