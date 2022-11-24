package com.training.test;

import org.testng.annotations.Test;

import java.io.IOException;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.training.base.BaseTest;
import com.training.log.Log;
import com.training.pages.HomePage;
import com.training.pages.LoginPage;
import com.training.utilities.CommonUtilities;
import com.training.utilities.ExcelUtils;

public class SfdcLoginTest extends BaseTest{
	WebDriver driver;
	String url;
	String browser;
	String username;
	String password;
	String Invalidpassword;
	String Invalidusername;
	CommonUtilities common = new CommonUtilities();
	LoginPage login;
	HomePage home;
	
	@BeforeMethod
	public void beforeMethod() throws IOException {
		DOMConfigurator.configure("log4j.xml");
		url = common.getProperty("url");
		browser = common.getProperty("browser");
		driver = getDriver(browser);
		driver.get(url);
		username = common.getProperty("username");
		password = common.getProperty("password");
		Invalidpassword= common.getProperty("Invalidpassword");
		Invalidusername = common.getProperty("Invalidusername");
		login = new LoginPage(driver);
		home = new HomePage(driver);
		Log.startTestCase("Test started");
	}
	
	@Test
	public void TC01loginInvalidPassword() {
		
		login.enterIntousername(username);
		login.enterIntoPassword(Invalidpassword);
		login.clickOnLogin();
		login.printErrorMessage();
	}
	
	@AfterMethod
	public void teardown() {
		Log.endTestCase("Ended");
		takescreenshot(driver);
		driver.close();
	}
	
	
	
	@Test(dataProvider = "Login")
	public void TC02loginValidUsernamePassword(String username, String password){
		
		login.enterIntousername(username);
		Log.info("Username entered" +username);
		login.enterIntoPassword(password);
		Log.info("Password entered" +password);
		login.clickOnLogin();
		home.clickHome();
	}
	
	@DataProvider
	public Object[][] Login() throws IOException{
		Object[][]loginTestArray = ExcelUtils.getTableArray1("/Users/Shilpa/Documents/ExcelData.xlsx", "login", 1);
		return loginTestArray;
	}
	
	
	@Test
	public void TC03testUserNameRememberMeCheck(){
		
		login.enterIntousername(username);
		login.enterIntoPassword(password);
		login.clickOnCheckbox();
		login.clickOnLogin();
		home.clickOnUNameDropdown();
		home.clickOnLogout();
		login.validateUsernameText();
	}
	
	@Test
	public void TC4AtestForgotPassword(String username) {
		
		login.clickForgotPassword();
		login.enterIntoFUserName(username);
		login.clickOnContinue();
		login.emailSentTextConfirmation();
	}
	
	
	@Test
	public void TC4BvalidateLoginError() {
		
		login.enterIntousername(Invalidusername);
		login.enterIntoPassword(Invalidpassword);
		login.clickOnLogin();
		login.printInvalidUsernamePasswordErrormsg();
	}
	
	
	
	
	
	
	
	
	

}
