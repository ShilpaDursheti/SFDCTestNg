package com.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.training.base.BasePage;

public class NewViewPage extends BasePage{

	public NewViewPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//input[@id=\"fname\"]")
	WebElement ViewName;
	
	@FindBy(xpath = "//input[@id=\"devname\"]")
	WebElement ViewUniqueName;
	
	@FindBy(xpath = "//input[@ data-uidsfdc=\"3\"]")
	WebElement Vsave;	
	
	
	public void enterIntoViewName(String strViewName) {
		WaitForElement(ViewName, 20);
		enterText(ViewName, strViewName, "ViewName");
	}
	
	public void enterIntoViewUniqueName(String strUViewName) {
		WaitForElement(ViewUniqueName, 20);
		enterText(ViewUniqueName, strUViewName, "ViewUniqueName");
	}
	
	public void clickOnSave() {
		clickOnElement(Vsave,"Vsave");
	}

	

	

}
