package com.training.base;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	protected WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void WaitForElement(WebElement Element, int time) {
		
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(Element));
		
	}
	
	public void clickOnElement(WebElement Element, String ElementName) {
		
	if(Element.isDisplayed()) {
		Element.click();
		System.out.println("TestPass: "+ ElementName + " button is clicked");
	}
}
	
	public void enterText(WebElement Element, String textValue, String ElementName) {
		if (Element.isDisplayed()) {
			Element.sendKeys(textValue);
			System.out.println("Test Pass: "+ textValue + " is entered in "+ ElementName);
		}
		else {
			System.out.println("Test Fail: "+ ElementName + " does not exists, please check the application");
		}
	}

	public void RobotMouseScrolldown(int i) {
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		robot.mouseWheel(20);
	}
	
	
	public void printMessage(WebElement Element, String Text) {
		if(Element.isDisplayed()) {
			Text = Element.getText();
			System.out.println("TestPass: "+ Text + " is Displayed");
		}
	}
	public void clickOnCheckBox(WebElement Element, String ElementName) {
		if(!Element.isSelected()) {
			Element.click();
			System.out.println("TestFail: "+ElementName+ " is clicked");
		}
	}
	


}
