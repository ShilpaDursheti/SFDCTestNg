package com.training.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.training.base.BasePage;

public class MergeMyAccountsPage extends BasePage{

	public MergeMyAccountsPage(WebDriver driver) {
		super(driver);

	}
	
	@FindBy(xpath = "//input[@ name=\"srch\"]")
	WebElement FindAccountText;
	
	@FindBy(xpath = "//input[@ name=\"srchbutton\"]")
	WebElement FindAccountButton;
	
	@FindBy(xpath = "//input[@id=\"cid0\"]")
	WebElement CheckBox1;
	
	@FindBy(xpath = "//input[@id=\"cid1\"]")
	WebElement CheckBox2;
	
	@FindBy(xpath = "//input[@value=\" Next \"]//ancestor::div[@class=\"pbTopButtons\"]")
	WebElement Submit;
	
	@FindBy(xpath = "(//input[@name=\"save\"])[1]")
	WebElement Merge;
	
	
	public void enterIntoFindAccountText(String strAccN) {
		WaitForElement(FindAccountText, 20);
		enterText(FindAccountText, strAccN, "FindAccountText");
	}
	public void clickOnFindAccountButton() {
		clickOnElement(FindAccountButton, "FindAccountButton");
	}
	public void clickOnCheckBox1() {
		WaitForElement(CheckBox1, 0);
		//CheckBox1.clear();
		clickOnCheckBox(CheckBox1,"CheckBox1");
	}
	public void clickOnCheckBox2() {
		//CheckBox2.clear();
		clickOnCheckBox(CheckBox2,"CheckBox2");
	}
	public void clickOnSubmit() {
		clickOnElement(Submit, "Submit");
	}
	public void clickOnMerge() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clickOnElement(Merge, "Merge");
		
		driver.switchTo().alert().accept();
	}

}
