package com.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.training.base.BasePage;

public class AccountsPage extends BasePage{

	public AccountsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@ name='new']")
	WebElement New;
	
	@FindBy(xpath = "//a[contains(text(), \"Create New View\")]")
	WebElement CreateNewView;
	
	@FindBy(xpath = "//select[@title=\"View:\"]")
	WebElement ViewDropDown;
	
	@FindBy(xpath = "//a[contains(@href, '/ui/list/FilterEditPage?id=00BDn0000032r1D&retURL')]")
	WebElement Edit;
	
	@FindBy(xpath = "//a[contains(text(), 'Merge Accounts')]")
	WebElement MergeAccounts;
	
	//@FindBy(xpath = "//table/tbody/tr/td[2]//ancestor::table[@class=\"toolsContent\"]")
	@FindBy(xpath = "//a[contains(text(),'Accounts with last activity > 30 days')]")
	WebElement AccountsActivity;
	
	public void clickOnNew() {
		WaitForElement(New, 20);
		clickOnElement(New, "New");
	}
	
	public void clickOnCreateNewView() {
		WaitForElement(CreateNewView, 30);
		clickOnElement(CreateNewView, "CreateNewView");
	}
	
	public void selectViewDropDown() {
		WaitForElement(ViewDropDown, 20);
		Select view = new Select(ViewDropDown);
		view.selectByVisibleText("ShilpaAccount");
	}
	
	public void clickOnEdit() {
		clickOnElement(Edit, "Edit");
	}
	
	public void clickOnMergeAccounts() {
		RobotMouseScrolldown(20);
		clickOnElement(MergeAccounts, "MergeAccounts");
	}
	public void clickOnAccountsActivity() {
		RobotMouseScrolldown(20);
		clickOnElement(AccountsActivity, "AccountsActivity");
	}
		
	}

	
	
	


