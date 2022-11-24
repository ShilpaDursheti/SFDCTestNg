package com.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.training.base.BasePage;

public class EditViewPage extends BasePage{

	public EditViewPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//input[@id=\"fname\"]")
	WebElement VName;
	
	@FindBy (xpath = "//select[@id=\"fcol1\"]")
	WebElement FieldDropDown;
	
	@FindBy(xpath = "//select[@title=\"Operator 1\"]")
	WebElement OperatorDropDown;
	
	@FindBy(xpath = "//input[@name=\"fval1\"]")
	WebElement value;
	
	@FindBy(xpath = "//input[@data-uidsfdc=\"3\"]")
	WebElement EVsave;
	
	public void enterIntoVname(String strVname) {
		WaitForElement(VName, 20);
		VName.clear();
		enterText(VName, strVname, "VName");
	}
	
	public void selectFieldDropdown() {
		WaitForElement(FieldDropDown, 20);
		Select field = new Select(FieldDropDown);
		field.selectByVisibleText("Account Name");
	}
	public void selectOPeratorDropdown() {
		Select Operator = new Select(OperatorDropDown);
		Operator.selectByVisibleText("contains");
	}
	public void enterIntoValue(String strValue) {
		value.clear();
		enterText(value, strValue, "value");
	}
	public void clickOnEVSave() {
		clickOnElement(EVsave, "EVsave");
	}
	
	
	
}


