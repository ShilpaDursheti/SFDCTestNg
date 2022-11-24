package com.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.training.base.BasePage;

public class ContactsPage extends BasePage{

	public ContactsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(name="new")
	WebElement New;
	
	@FindBy(xpath = "//a[contains(text(),'Create New View')]")
	WebElement NewView;
	
	@FindBy(id="hotlist_mode")
	WebElement RecCreatedDd;
	
	@FindBy(id="fcf")
	WebElement ContactView;
	
	@FindBy(xpath = "//a[contains(text(),'Chennoj, Swetha')]")
	WebElement ContactName;
	
	
	
	public void clickOnNew() {
		WaitForElement(New, 20);
		clickOnElement(New, "New");
	}
	
	public void clickOnNewView() {
		WaitForElement(NewView, 20);
		clickOnElement(NewView, "NewView");
	}
	
	public void selectRecentlyCreated() {
		WaitForElement(RecCreatedDd, 20);
		Select RecCreated = new Select(RecCreatedDd);
		RecCreated.selectByVisibleText("Recently Created");
	}
	
	public void selectMyContacts() {
		WaitForElement(ContactView, 20);
		Select CView = new Select(ContactView);
		CView.selectByVisibleText("My Contacts");
	}
	public void clickOnContactName() {
		WaitForElement(ContactName, 20);
		clickOnElement(ContactName, "ContactName");
		
	}
	public void validateContactInfoPage() {
		String Actualtitle = driver.getTitle();
		System.out.println(Actualtitle);
		
	}
	
}
