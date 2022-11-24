package com.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.training.base.BasePage;

public class CalenderPage extends BasePage{

	public CalenderPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//div[@id=\"p:f:j_id25:j_id61:28:j_id64\"]")
	WebElement time;
	
	@FindBy(id="p:f:j_id25:j_id61:20:j_id64")
	WebElement timeFour;
	
	public void clickOnTime() {
		RobotMouseScrolldown(20);
		WaitForElement(time, 20);
		clickOnElement(time, "time");
	}
	
	public void clickOntimeFour() {
		RobotMouseScrolldown(20);
		WaitForElement(timeFour, 20);
		clickOnElement(timeFour, "timeFour");
	}

}
