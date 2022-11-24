package com.training.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.pages.ConNewViewPage;
import com.training.pages.ContactsPage;
import com.training.pages.HomePage;
import com.training.pages.LoginPage;
import com.training.pages.NewContactPage;
import com.training.utilities.CommonUtilities;

public class ContactsTest extends BaseTest{
	
	WebDriver driver;
	String url;
	String browser;
	String username;
	String password;
	String AccTextBox;
	String ContactLName;
	String CViewName;
	String CUViewName;
	String AccName;
	String CtLName;
	CommonUtilities common = new CommonUtilities();
	LoginPage login;
	HomePage home;
	ContactsPage Contacts;
	NewContactPage NewContact;
	ConNewViewPage ConNewView;
	
	
	
	
	@BeforeMethod
	public void beforemethod() throws IOException {
		
		url = common.getProperty("url");
		browser = common.getProperty("browser");
		driver = getDriver(browser);
		driver.get(url);
		username = common.getProperty("username");
		password = common.getProperty("password");
		AccTextBox = common.getProperty("AccTextBox");
		ContactLName = common.getProperty("ContactLName");
		CViewName = common.getProperty("CViewName");
		CUViewName = common.getProperty("CUViewName");
		AccName = common.getProperty("AccName");
		CtLName = common.getProperty("CtLName");
		login = new LoginPage(driver);
		home = new HomePage(driver);
		Contacts = new ContactsPage(driver);
		NewContact = new NewContactPage(driver);
		ConNewView = new ConNewViewPage(driver);
	}
	
	@Test
	public void TC25CreateNewContact() {
		login.enterIntousername(username);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickOnContactsTab();
		Contacts.clickOnNew();
		NewContact.enterIntoLastname(ContactLName);
		NewContact.clickOnAccountlookUp();
		NewContact.enterIntoANameTextBox(AccTextBox);
		NewContact.clickOnGo();
		NewContact.switchToFrame2();
		NewContact.clickOnAccountNameResult();
		NewContact.clickOnSave();
		
	}
	
	@Test
	public void TC26CreateNewViewInContactPage() {
		login.enterIntousername(username);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickOnContactsTab();
		Contacts.clickOnNewView();
		ConNewView.enterIntoViewName(CViewName);
		ConNewView.enterIntoUViewName(CUViewName);
		ConNewView.clickOnSave();
		
	}
	
	@Test
	public void TC27CheckRecentlyCreatedContact() {
		login.enterIntousername(username);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickOnContactsTab();
		Contacts.selectRecentlyCreated();
	}
	
	@Test
	public void TC28CheckMyContactsView() {
		login.enterIntousername(username);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickOnContactsTab();
		Contacts.selectMyContacts();
	}
	
	@Test
	public void TC29ViewContactInContactPage() {
		login.enterIntousername(username);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickOnContactsTab();
		Contacts.clickOnContactName();
		Contacts.validateContactInfoPage();
	}
	
	@Test
	public void TC30CheckTheErrorMessage() {
		login.enterIntousername(username);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickOnContactsTab();
		Contacts.clickOnNewView();
		ConNewView.enterIntoUViewName(CUViewName);
		ConNewView.clickOnSave();
		ConNewView.getErrorMessage();
				
	}
	
	@Test
	public void TC31CheckCancelButtonInCreateNewView() {
		login.enterIntousername(username);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickOnContactsTab();
		Contacts.clickOnNewView();
		ConNewView.enterIntoViewName(CViewName);
		ConNewView.enterIntoUViewName(CUViewName);
		ConNewView.clickOnCancel();
		ConNewView.validateContactPage();
		
	}
	
	@Test
	
	public void TC32CheckSaveAndNewButtonWorks() {
		login.enterIntousername(username);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickOnContactsTab();
		Contacts.clickOnNew();
		NewContact.enterIntoLastname(CtLName);
		NewContact.enterIntoAccountName(AccName);
		NewContact.clickOnsaveAndNew();
	}
	
	
	
	@AfterMethod
	public void teardown() {
		takescreenshot(driver);
		System.out.println("Took screenshot");
		driver.close();
	}

}
