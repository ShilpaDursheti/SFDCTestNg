package com.training.pages;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.ImplicitlyWait;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.training.base.BasePage;

public class MySettingsPage extends BasePage {
	
	
	public MySettingsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//a[contains(text(), 'My Settings')]")
	WebElement MySettings;
	
	@FindBy(xpath = "//a[@href=\"javascript:HTMLTreeNode.prototype.toggleHTMLTree('PersonalInfo');\"]")
	WebElement Personal;
	
	@FindBy(xpath = "//span[contains(text(), 'Login History')]")
	WebElement loginHistory;
	
	@FindBy(xpath = "//a[@href=\"/servlet/servlet.LoginHistory?id=005Dn000001ROpM\"]")
	WebElement DownloadloginHistory;
	
	@FindBy(xpath = "//span[contains(text(), 'Display & Layout')]")
	WebElement DisplayAndLayout;
	
	@FindBy(xpath = "//span[contains(text(), 'Customize My Tabs')]")
	WebElement CustomizeMyTabs;
	
	@FindBy(xpath = "//select[@onchange=\"javascript:tabSetSelChange(this);\"]")
	WebElement CustomAppDropDown;
	
	@FindBy(id = "duel_select_0")
	WebElement AvailableTabs;
	
	
	
	@FindBy(id = "duel_select_0_right")
	WebElement Add;
	
	@FindBy(xpath = "//input[@class ='btn primary']")
	WebElement save;
	
	@FindBy(id = "EmailSetup_font")
	WebElement Email;
	
	@FindBy(id = "EmailSettings_font")
	WebElement EmailSettings;
	
	@FindBy(id = "sender_name")
	WebElement Emailname;
	
	@FindBy(id = "sender_email")
	WebElement Emailid;
	
	@FindBy (id = "auto_bcc1")
	WebElement BccRadiButton;
	
	@FindBy(xpath = "//input[@value=\" Save \"]")
	WebElement save1;
	
	@FindBy(xpath = "//span[contains(text(),'Calendar & Reminders')]")
	WebElement CalendersAndRemainders;
	
	@FindBy(xpath = "//span[contains(text(), 'Activity Reminders')]")
	WebElement ActivityRemainders;
	
	@FindBy(id = "testbtn")
	WebElement OpenTestRem;
	
	@FindBy(id ="summary0")
	WebElement OpenTestRemPopUp;
	
	@FindBy(xpath = "//input[@ value=\"Dismiss All\"]")
	WebElement DismissAll;
	
	
	@FindBy(xpath = "//select[@id=\"duel_select_1\"]")
	WebElement SelectedTabs;
	
	@FindBy(xpath = "//img[@title=\"Remove\"]")
	WebElement remove;
	
	
	
	public void clickOnMySettings() {
		clickOnElement(MySettings, "MySettings");
	}
	
	public void clickOnPersonal() {
		WaitForElement(Personal, 20);
		clickOnElement(Personal, "Personal");
	}
	public void clickOnloginHistory() {
		clickOnElement(loginHistory,"loginHistory");
		RobotMouseScrolldown(20);
	}
	public void clickOnDownloadloginHistory() {
		clickOnElement(DownloadloginHistory,"DownloadloginHistory");
	}
	
	public void clickOnDisplayandLayout() {
		WaitForElement(DisplayAndLayout,30);
		clickOnElement(DisplayAndLayout,"DisplayAndLayout");
	}
	
	public void clickOnCustomizeMyTabs() {
		WaitForElement(CustomizeMyTabs,30);
		clickOnElement(CustomizeMyTabs,"CustomizeMyTabs");
	}
	

	public void selectSalesForceChatterFromCustApp() {
		Select CustomApp = new Select(CustomAppDropDown);
		CustomApp.selectByIndex(9);
	}
	public void selectReportsFromAvailableTab() {
		Select ATabs = new Select(AvailableTabs);
		ATabs.selectByVisibleText("Reports");
	}
	public void clickOnAdd() {
		clickOnElement(Add,"Add");
	}
	
	public void clickOnSave() {
		clickOnElement(save,"save");
	}
	public void clickOnEmail() {
		clickOnElement(Email, "Email");
	}
	public void clickOnEmailSettings() {
		clickOnElement(EmailSettings,"EmailSettings");
		
	}
	public void enterIntoEmailName(String emailName) {
		Emailname.clear();
		WaitForElement(Emailname,20);
		enterText(Emailname, emailName, "Emailname");
	}
	public void enterIntoEmailId(String emailId) {
		Emailid.clear();
		enterText(Emailid, emailId, "EmailId");
	}
	public void clickOnBccRadiButton() {
		clickOnElement(BccRadiButton,"BccRadiButton");
	}
	public void clickOnSave1() {
		RobotMouseScrolldown(20);
		WaitForElement(save1, 30);
		clickOnElement(save1,"save1");
	}
	public void clickOnCalendersAndRemainders() {
		WaitForElement(CalendersAndRemainders, 20);
		clickOnElement(CalendersAndRemainders,"CalendersAndRemainders");
	}
	public void clickOnActivityRemainders() {
		clickOnElement(ActivityRemainders,"ActivityRemainders");
	}
	public void clickOnOpenTestRem() {
		WaitForElement(OpenTestRem, 20);
		clickOnElement(OpenTestRem,"OpenTestRem");
		driver.switchTo().alert().dismiss();
		
	}
	 public void valiadateRemainderPopUp() {
		 
		 String parentwindow = driver.getWindowHandle();
		 String ParentWindowTitle = driver.getTitle();
		 System.out.println(ParentWindowTitle);
		 
		 for(String handle:driver.getWindowHandles()) {
				driver.switchTo().window(handle);
				if(!parentwindow.equalsIgnoreCase(handle)) {
					 driver.switchTo().window(handle);	                                                                                                           
					 DismissAll.click();
				}
		 }
			
			System.out.println("Test Pass: Sample event Pop window is displayed and dismissed.");
			
		 
	}
	 
	 public void selectReportsFromSelectedTab() {
		 try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			Select SelTabs = new Select(SelectedTabs);
			SelTabs.selectByVisibleText("Subscriptions");
		}
	 
	 public void clickOnRemove() {
		 clickOnElement(remove, "remove");
	 }
	 
	 
	 
}


