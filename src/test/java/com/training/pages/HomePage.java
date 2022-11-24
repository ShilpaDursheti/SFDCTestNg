package com.training.pages;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.training.base.BasePage;

public class HomePage extends BasePage{
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//a[text()='Home']")
	WebElement Home;
	
	@FindBy(id="name")
	WebElement Name;
	

	@FindBy (id = "userNav")
	WebElement UNameDropdown;
	
	@FindBy(xpath ="//a[contains(text(),'Logout')]")
	WebElement logout;
	
	@FindBy(id ="userNav-menuItems")
	WebElement DropdownMenuItems;
	
	@FindBy(xpath = "//a[@title = 'Accounts Tab']")
	WebElement AccountsTab;
	
	@FindBy(xpath = "//a[@title=\"Opportunities Tab\"]")
	WebElement OpportunityTab;
	
	@FindBy(xpath = "//a[@title=\"Leads Tab\"]")
	WebElement LeadsTab;
	
	@FindBy(xpath = "//a[@title='Contacts Tab']")
	WebElement ContactsTab;
	
	@FindBy(xpath = "//a[@ href=\"/_ui/core/userprofile/UserProfilePage\" and contains(text(),'Shilpa Dursheti')]")
	WebElement UsernameLink;
	
	@FindBy(xpath = "//span[@id=\"userNavLabel\"]")
	WebElement UserNameDdText;
	
	@FindBy(xpath = "//img[@class=\"allTabsArrow\"]")
	WebElement AllTab;
	
	@FindBy(xpath = "//a[@href=\"/00U/c?md3=326&md0=2022\"]")
	WebElement CurrentDateTab;
	
	@FindBy(xpath = "//span[contains(text(),'Post')]")
	WebElement post;

	
	public void clickHome() {
		WaitForElement(Home,10);
		clickOnElement(Home, "HomeButton");
	}
	
	public void clickOnUNameDropdown() {
		WaitForElement(UNameDropdown,10);
		clickOnElement(UNameDropdown, "UserNameDropDownButton");
	}
	public void clickOnLogout() {
		WaitForElement(logout, 10);
		logout.click();
	}
	public void VerifyDropdownMenuItems() {
		String menuItems = DropdownMenuItems.getText();
		System.out.println(menuItems);
		System.out.println("TestPass: DropdownMenuItems are displayed");
		
	}
	public void clickOnAccountsTab() {
		clickOnElement(AccountsTab,"AccountsTab");
	}
	public void clickOnOpportunityTab() {
		clickOnElement(OpportunityTab, "OpportunityTab");
	}
	public void clickOnLeadsTab() {
		clickOnElement(LeadsTab, "LeadsTab");
	}
	public void clickOnContactsTab() {
		clickOnElement(ContactsTab, "ContactsTab");
	}
	public void getUsernameLinkText() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//WaitForElement(UsernameLink, 20);
		String UsernameText = UsernameLink.getText();
		System.out.println(UsernameText+ " is displayed as link.");
	}
	public void clickOnUsernameLink() {
		WaitForElement(UsernameLink, 20);
		clickOnElement(UsernameLink, "UsernameLink");
	}
	public void validateMyprofilePage() {
		String ActualTitle = driver.getTitle();
		System.out.println(ActualTitle);
		String text = post.getText();
		System.out.println(text +" Button is present, MyProfile page is displayed");
		
	}
	public void getUsernameDdText() {
		WaitForElement(UserNameDdText, 20);
		String UserNameDdTxt = UserNameDdText.getText();
		System.out.println(UserNameDdTxt+ " is displayed as dropdown Name");
		System.out.println(driver.getTitle());
	}
	
	public void clickOnAllTab() {
		WaitForElement(AllTab, 20);
		clickOnElement(AllTab, "AllTab");
	}
	public void clickOnCurrentDateTab() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//WaitForElement(CurrentDateTab, 20);
		clickOnElement(CurrentDateTab, "CurrentDateTab");
	}
	
	
	
	
	
		
	}
	

