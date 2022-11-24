package com.training.test;

import org.testng.annotations.Test;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.training.base.BaseTest;
import com.training.pages.DevelopersConsolePage;
import com.training.pages.HomePage;
import com.training.pages.LoginPage;
import com.training.pages.MyProfilePage;
import com.training.pages.MySettingsPage;
import com.training.utilities.CommonUtilities;

public class HomeUserMenudropDownTest extends BaseTest {

	WebDriver driver;
	String url;
	String browser;
	String username;
	String password;
	String emailname;
	String emailid;
	String lastname;
	String postText;
	String File;
	String photoPath;
	CommonUtilities common = new CommonUtilities();
	LoginPage login;
	HomePage home;
	MyProfilePage MyProfile;
	MySettingsPage MySettings;
	DevelopersConsolePage devConsole;
	
	@BeforeMethod
	public void beforemethod() throws IOException {
		url = common.getProperty("url");
		browser = common.getProperty("browser");
		driver = getDriver(browser);
		driver.get(url);
		username = common.getProperty("username");
		password = common.getProperty("password");
		emailname = common.getProperty("emailname");
		emailid = common.getProperty("emailid");
		lastname = common.getProperty("lastname");
		postText = common.getProperty("postText");
		File = common.getProperty("File");
		photoPath = common.getProperty("photoPath");
		login = new LoginPage(driver);
		home = new HomePage(driver);
		MyProfile= new MyProfilePage (driver);
		devConsole = new DevelopersConsolePage(driver);
		MySettings = new MySettingsPage(driver);
		
		
	}
	@Test
	public void validateHomeScreen() {
		
		login.enterIntousername(username);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickHome();
		
	}
	
	@AfterMethod
	public void teardown() {
		takescreenshot(driver);
		System.out.println("Took screenshot");
		driver.close();
	}
	@Test
	public void TC05selectUserMenuForUsernameDropDown() {
		login.enterIntousername(username);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickOnUNameDropdown();
		home.VerifyDropdownMenuItems();
	}
	
	@Test
	public void TC06selectMyProfileFromUserMenu() {
		login.enterIntousername(username);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickOnUNameDropdown();
		MyProfile.clickOnMyProfile();
		MyProfile.clickOnEditProfile();
		MyProfile.switchToFrame();
		MyProfile.clickOnAboutTab();
		MyProfile.enterIntoLastName(lastname);
		MyProfile.clickOnSaveAll();
		MyProfile.clickOnPost();
		MyProfile.SwitchToIFrame1();
		MyProfile.enterIntopostText(postText);
		MyProfile.clickOnShare();
		MyProfile.clickOnFile();
		MyProfile.clickOnUploadFileFromComputer();
		MyProfile.enterIntoChooseFile(File);
		MyProfile.clickOnShare1();
		MyProfile.selectAddPhoto();
		MyProfile.switchToIframe1();
		MyProfile.enterIntoChoosePhoto(photoPath);
		MyProfile.clickOnSavePhoto();
		MyProfile.cropPhoto();
		MyProfile.clickOnSaveButton();
		
	}
	

	
	@Test
	public void TC08clickOnDeveloperConsole() throws AWTException, InterruptedException {
		login.enterIntousername(username);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickOnUNameDropdown();
		devConsole.clickOnDeveloperConsoleButton();
		
	}
	
	@Test
	public void TC07selectMySettingsFromUserMenu() {
		login.enterIntousername(username);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickOnUNameDropdown();
		MySettings.clickOnMySettings();
		MySettings.clickOnPersonal();
		MySettings.clickOnloginHistory();
		MySettings.clickOnDownloadloginHistory();
		MySettings.clickOnPersonal();
		MySettings.clickOnDisplayandLayout();
		MySettings.clickOnCustomizeMyTabs();
		MySettings.selectSalesForceChatterFromCustApp();
		MySettings.selectReportsFromAvailableTab();
		MySettings.clickOnAdd();
		MySettings.clickOnPersonal();
		MySettings.clickOnEmail();
		MySettings.clickOnEmailSettings();
		MySettings.enterIntoEmailName(emailname);
		MySettings.enterIntoEmailId(emailid);
		MySettings.clickOnBccRadiButton();
		MySettings.clickOnSave1();
		MySettings.clickOnCalendersAndRemainders();
		MySettings.clickOnActivityRemainders();
		MySettings.clickOnOpenTestRem();
		//MySettings.valiadateRemainderPopUp();
		
		
	}
	@Test
	
	public void TC09selectLogOutFromUserMenu() {
		login.enterIntousername(username);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickOnUNameDropdown();
		home.clickOnLogout();
	}

	
	
}
