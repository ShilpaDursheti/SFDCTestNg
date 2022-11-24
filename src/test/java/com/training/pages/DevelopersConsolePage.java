package com.training.pages;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.training.base.BasePage;

public class DevelopersConsolePage extends BasePage{
	
	public DevelopersConsolePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//a[contains(text(),'Developer Console')]")
	WebElement DeveloperConsole;
	
	public void clickOnDeveloperConsoleButton() {
		clickOnElement(DeveloperConsole, "DeveloperConsoleButton");
		
		String parenttitle = driver.getTitle();
		System.out.println(parenttitle);
	
		String parentWindow = driver.getWindowHandle();
		
		for(String handle:driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
		
		String title = driver.getTitle();
		System.out.println(title);
		if(title.equalsIgnoreCase("Developer Console") ) {
			driver.close();
		}
		driver.switchTo().window(parentWindow);
		System.out.println("PassTest: Developer console closed");
		String Currenttitle = driver.getTitle();
		System.out.println("HomePage title is displayed "+ Currenttitle);

	}
	
}
