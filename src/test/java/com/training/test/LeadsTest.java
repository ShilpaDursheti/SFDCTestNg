package com.training.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.pages.HomePage;
import com.training.pages.LeadsPage;
import com.training.pages.LoginPage;
import com.training.utilities.CommonUtilities;

public class LeadsTest extends BaseTest{

	WebDriver driver;
	String url;
	String browser;
	String username;
	String password;
	String lname;
	String CName;
	CommonUtilities common = new CommonUtilities();
	LoginPage login;
	HomePage home;
	LeadsPage Leads;
	
	@BeforeMethod
	public void beforemethod() throws IOException {
		
		url = common.getProperty("url");
		browser = common.getProperty("browser");
		driver = getDriver(browser);
		driver.get(url);
		username = common.getProperty("username");
		password = common.getProperty("password");
		lname = common.getProperty("lname");
		CName = common.getProperty("CName");
		login = new LoginPage(driver);
		home = new HomePage(driver);
		Leads = new LeadsPage(driver);
}
	
	@Test
	public void TC20CheckLeadsTabLink () {
		login.enterIntousername(username);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickOnLeadsTab();
	}
	
	@AfterMethod
	public void teardown() {
		takescreenshot(driver);
		System.out.println("Took screenshot");
		driver.close();
	}

	
	@Test
	public void TC21LeadsSelectView(){
		login.enterIntousername(username);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickOnLeadsTab();
		Leads.validateViewDropDown();	
	}
	
	@Test
	public void TC22DefaultView() {
		login.enterIntousername(username);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickOnLeadsTab();
		Leads.SelectMyUnReadLeads();
		home.clickOnUNameDropdown();
		home.clickOnLogout();
		login.enterIntousername(username);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickOnLeadsTab();
		Leads.clickOnGo();
	}
	
	@Test
	public void TC23TodaysLeads() {
		login.enterIntousername(username);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickOnLeadsTab();
		Leads.SelectTodaysLeads();
	}
	
	@Test
	public void TC24NewLeadsButton() {
		login.enterIntousername(username);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickOnLeadsTab();
		Leads.clickOnNew();
		Leads.enterIntoLastName(lname);
		Leads.enterIntoCompanyName(CName);
		Leads.clickOnSave();
	
	}
	
	
	
	
	
	
	
	
	
	
}