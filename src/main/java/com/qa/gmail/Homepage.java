package com.qa.gmail;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends Basepage {
	
	//@FindBy(xpath="")
	//WebElement title;
	@FindBy(xpath="//a[contains(text(),'Gmail')]")
	WebElement gmail;
	public Homepage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomepageTitleIsPresent() {
		String t=driver.getTitle();
		System.out.println(t);
		return t;
	}
	public void clickOnGmailLink() {
		gmail.click();
	}

}
