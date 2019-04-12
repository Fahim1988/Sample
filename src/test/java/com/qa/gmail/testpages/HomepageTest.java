package com.qa.gmail.testpages;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.gmail.Basepage;
import com.qa.gmail.Homepage;

public class HomepageTest extends Basepage{
	Logger logger=LogManager.getLogger(HomepageTest.class);
	
	Homepage homepage;

	public HomepageTest() {
		super();
	}

	@BeforeMethod
	public void setUP() {
		initialization();
		logger.info("Launching Homepage");
		homepage=new Homepage();
	}

	@Test
	public void testSearch() {
		logger.info("Verifying Homepage Title");
		Assert.assertEquals("Google", homepage.verifyHomepageTitleIsPresent());
		logger.info("Clicking on GMail");
		homepage.clickOnGmailLink();
	}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


}
