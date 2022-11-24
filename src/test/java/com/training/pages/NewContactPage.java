package com.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.training.base.BasePage;

public class NewContactPage extends BasePage{

	public NewContactPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(id="name_lastcon2")
	WebElement lastName;
	
	@FindBy(xpath = "//img[@ title= 'Account Name Lookup (New Window)']")
	WebElement AccountlookUp;
	
	@FindBy(id="searchFrame")
	WebElement Frame;
	
	@FindBy(xpath = "//input[@ placeholder=\"Search...\"]")
	WebElement ANameTextBox;
	
	@FindBy(xpath = "//input[@type=\"submit\"]")
	WebElement Go;
	
	@FindBy(id="resultsFrame")
	WebElement Frame2;
	
	@FindBy(xpath = "//table[@ class='list']/tbody/tr[2]/th/a[@class=' dataCell ']")
	WebElement AccountNameResult;
	
	@FindBy(xpath = "//td[@id='topButtonRow']//input[@name='save']")
	WebElement save;
	
	@FindBy(id="con4")
	WebElement AccountName;
	
	@FindBy(xpath = "//div[@ class='pbHeader']//input[@name='save_new']")
	WebElement saveAndNew;
	
	
	public void enterIntoLastname(String ContactLName) {
		WaitForElement(lastName, 20);
		enterText(lastName,ContactLName, "lastName");
	}
	
	public void clickOnAccountlookUp() {
		String parentTitle = driver.getTitle();
		System.out.println(parentTitle);
		clickOnElement(AccountlookUp, "AccountlookUp");
		
		for(String handle: driver.getWindowHandles()) {
			if(!driver.getTitle().equals(parentTitle)) {
				driver.switchTo().window(handle);
			}
		}
	}
	
	public void switchToFrame() {
		driver.switchTo().frame(Frame);
	}
	public void enterIntoANameTextBox(String AccTextBox) {
		WaitForElement(ANameTextBox, 20);
		enterText(ANameTextBox, AccTextBox, "ANameTextBox");
		
	}
	
	public void clickOnGo() {
		WaitForElement(Go, 10);
		clickOnElement(Go, "Go");
		driver.switchTo().defaultContent();
	}
	public void switchToFrame2() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().frame(Frame2);
		System.out.println("Switched to frame2");
	}
	public void clickOnAccountNameResult() {
		String Title = driver.getTitle();
		WaitForElement(AccountNameResult, 20);
		clickOnElement(AccountNameResult, "AccountNameResult");
		for(String handle: driver.getWindowHandles()) {
			if(!driver.getTitle().equals(Title)) {
				driver.switchTo().window(handle);
			}
		}
		
	}
	
	public void clickOnSave() {
		clickOnElement(save, "save");
	}
	
	public void enterIntoAccountName(String AccName) {
		WaitForElement(AccountName, 20);
		enterText(AccountName, AccName, "AccountName");
	}
	public void clickOnsaveAndNew() {
		clickOnElement(saveAndNew, "saveAndNew");
	}

}
