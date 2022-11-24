package com.training.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.training.base.BasePage;

public class LeadsPage extends BasePage{

	public LeadsPage(WebDriver driver) {
		super(driver);
		
	}

	
	@FindBy(id="fcf")
	WebElement ViewDropDown;
	
	@FindBy(xpath = "//input[@value=\" Go! \"]")
	WebElement Go;	
	
	@FindBy(name="new")
	WebElement New;
	
	@FindBy(id="name_lastlea2")
	WebElement lastName;
	
	@FindBy(id="lea3")
	WebElement companyName;
	
	@FindBy(name="save")
	WebElement save;
	
	
	public List<String> validateViewDropDown() {
		WaitForElement(ViewDropDown, 20);
		Select VDd = new Select (ViewDropDown);
		List<WebElement> VD = VDd.getOptions();
		List<String>VDS = new ArrayList<String>();
		for(WebElement a: VD) {
			VDS.add(a.getText());
		}
		
		for(Object e: VDS) {
			System.out.println(e);
		}
		return VDS;
		
	}
	public void SelectMyUnReadLeads() {
		WaitForElement(ViewDropDown, 20);
		Select VDd = new Select(ViewDropDown);
		VDd.selectByVisibleText("My Unread Leads");
		
	}
	public void clickOnGo() {
		clickOnElement(Go, "Go");
	}
	
	public void SelectTodaysLeads() {
		WaitForElement(ViewDropDown, 20);
		Select VDd = new Select(ViewDropDown);
		VDd.selectByVisibleText("Today's Leads");
	}
	
	public void clickOnNew() {
		WaitForElement(New, 20);
		clickOnElement(New, "New");
	}
	public void enterIntoLastName(String lname) {
		WaitForElement(lastName, 20); 
		enterText(lastName, "lName", "lastName");
	}
	
	public void enterIntoCompanyName(String CName) {
		enterText(companyName, "CName", "companyName");
	}
	public void clickOnSave() {
		clickOnElement(save, "save");
	}
}
