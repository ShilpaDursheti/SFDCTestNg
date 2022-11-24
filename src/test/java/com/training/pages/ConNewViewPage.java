package com.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.training.base.BasePage;

public class ConNewViewPage extends BasePage{

	public ConNewViewPage(WebDriver driver) {
		super(driver);
		
	}
	
	
	@FindBy(id = "fname")
	WebElement ViewName;
	
	@FindBy(id="devname")
	WebElement 	UViewName;
	
	@FindBy(xpath = "//div[@class=\"pbHeader\"]//input[@name=\"save\"]")
	WebElement save;
	
	@FindBy(xpath = "(//div[@class=\"errorMsg\"])[1]")
	WebElement ErrorMessage;
	
	@FindBy(xpath = "//div[@ class=\"pbHeader\"]//input[@ name=\"cancel\"]")
	WebElement cancel;
	
	
	public void enterIntoViewName(String CViewName) {
		WaitForElement(ViewName, 20);
		enterText(ViewName, CViewName, "ViewName");
	}
	
	
	public void enterIntoUViewName(String CUViewName) {
		WaitForElement(UViewName, 20);
		UViewName.clear();
		enterText(UViewName, CUViewName, "UViewName");
	}
	
	public void clickOnSave() {
		clickOnElement(save, "save");
	}
	
	public void getErrorMessage() {
		WaitForElement(ErrorMessage, 20);
		String ErrorMsg = ErrorMessage.getText();
		System.out.println("TestPass " + ErrorMsg + " is displayed");
	}
	
	public void clickOnCancel() {
		clickOnElement(cancel, "cancel");
	
	}
	public void validateContactPage() {
		String ExpTitle = "Contacts: Home ~ Salesforce - Developer Edition";
		String ActualTitle = driver.getTitle();
		System.out.println(ActualTitle);
		Assert.assertEquals(ActualTitle, ExpTitle,"TestFail");
	}

}
