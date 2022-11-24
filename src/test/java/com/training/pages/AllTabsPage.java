package com.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.training.base.BasePage;

public class AllTabsPage extends BasePage {

	public AllTabsPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath = "//input[@value=\"Customize My Tabs\"]")
	WebElement customizeTabs;
	
	
	public void clickOncustomizeTabs() {
		WaitForElement(customizeTabs, 20);
		clickOnElement(customizeTabs, "customizeTabs");
	}

	

}
