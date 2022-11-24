package com.training.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.pages.AllTabsPage;
import com.training.pages.CalenderPage;
import com.training.pages.ContactsPage;
import com.training.pages.HomePage;
import com.training.pages.LoginPage;
import com.training.pages.MyProfilePage;
import com.training.pages.MySettingsPage;
import com.training.pages.NewEventPage;
import com.training.utilities.CommonUtilities;

public class RandomScenariosTest extends BaseTest{
	
	WebDriver driver;
	String url;
	String browser;
	String username;
	String password;
	String Lastname;
	CommonUtilities common = new CommonUtilities();
	LoginPage login;
	HomePage home;
	MyProfilePage MyProfile;
	AllTabsPage AllTabs;
	MySettingsPage MySettings;
	NewEventPage NewEvent;
	CalenderPage Calender;
	
	@BeforeMethod
	public void beforemethod() throws IOException {
		
		url = common.getProperty("url");
		browser = common.getProperty("browser");
		driver = getDriver(browser);
		driver.get(url);
		username = common.getProperty("username");
		password = common.getProperty("password");
		Lastname = common.getProperty("Lastname");
		login = new LoginPage(driver);
		home = new HomePage(driver);
		MyProfile= new MyProfilePage (driver);
		AllTabs = new AllTabsPage(driver);
		MySettings = new MySettingsPage(driver);	
		NewEvent = new NewEventPage(driver);
		Calender = new CalenderPage(driver);
				
	}
	@Test
	public void Test33VerifyUsernameLinkOnHomePage(){
		login.enterIntousername(username);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickHome();
		home.getUsernameLinkText();
		home.clickOnUsernameLink();
		home.validateMyprofilePage();
	}
	@Test
	public void Test34VerifyTheUpdatedLastName() {
		login.enterIntousername(username);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickHome();
		home.clickOnUsernameLink();
		MyProfile.clickOnEditProfile();
		MyProfile.switchToFrame();
		MyProfile.clickOnAboutTab();
		MyProfile.enterIntoLastName(Lastname);
		MyProfile.clickOnSaveAll();
		MyProfile.getUserNameTitle();
		home.getUsernameDdText();
	}
	
	@Test
	public void Test35VerifyTabCustomization() {
		login.enterIntousername(username);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickOnAllTab();
		AllTabs.clickOncustomizeTabs();
		MySettings.selectReportsFromSelectedTab();
		MySettings.clickOnRemove();
		MySettings.clickOnSave();
		home.clickOnUNameDropdown();
		home.clickOnLogout();
		login.enterIntousername(username);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		
	}
	
	@Test
	public void Test36BlockingAnEventInCalender() {
		login.enterIntousername(username);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickHome();
		home.clickOnCurrentDateTab();
		Calender.clickOnTime();
		NewEvent.clickOnSubject();
		NewEvent.clickOnOther();
		NewEvent.clickOnEndDateTime();
		NewEvent.clickOnEndTime();
		NewEvent.clickOnSave();
	}
	
	@Test
	public void TC37BlockingAnEventWithWeeklyReOccurence() {
		login.enterIntousername(username);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickHome();
		home.clickOnCurrentDateTab();
		Calender.clickOntimeFour();
		NewEvent.clickOnSubject();
		NewEvent.clickOnOther();
		NewEvent.clickOnEndDateTime();
		NewEvent.clickOnEndTime2();
		NewEvent.clickOnRecurrence();
		NewEvent.clickOnWeeklyradioButton();
		NewEvent.EnterIntoRecurrenceEndDate();
		NewEvent.clickOnSave2();
		
		
		
	}
	
	
	@AfterMethod
	public void teardown() {
		takescreenshot(driver);
		System.out.println("Took screenshot");
		driver.close();
	}


}

