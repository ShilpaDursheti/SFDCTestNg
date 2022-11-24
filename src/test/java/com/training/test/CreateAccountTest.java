package com.training.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.pages.AccountsPage;
import com.training.pages.EditViewPage;
import com.training.pages.HomePage;
import com.training.pages.LoginPage;
import com.training.pages.MergeMyAccountsPage;
import com.training.pages.NewAccountEditPage;
import com.training.pages.NewViewPage;
import com.training.pages.UnsavedReportPage;
import com.training.utilities.CommonUtilities;

public class CreateAccountTest extends BaseTest{
	
	WebDriver driver;
	String url;
	String browser;
	String username;
	String password;
	String AccountName;
	String strViewName;
	String strVname;
	String strValue;
	String strAccN;
	String saveReportName;
	String saveReportUniqueName;
	CommonUtilities common = new CommonUtilities();
	LoginPage login;
	HomePage home;
	AccountsPage Accounts;
	String strUViewName;
	NewAccountEditPage NewAccountEdit;
	NewViewPage NewView;
	EditViewPage EditView;
	MergeMyAccountsPage MergeAccounts;
	UnsavedReportPage UnsavedReport;

	
	@BeforeMethod
	public void beforemethod() throws IOException {
		url = common.getProperty("url");
		browser = common.getProperty("browser");
		driver = getDriver(browser);
		driver.get(url);
		username = common.getProperty("username");
		password = common.getProperty("password");
		AccountName = common.getProperty("AccountName");
		strViewName = common.getProperty("strViewName");
		strUViewName = common.getProperty("strUViewName");
		strVname = common.getProperty("strVname");
		strValue = common.getProperty("strValue");
		strAccN = common.getProperty("strAccN");
		saveReportName = common.getProperty("saveReportName");
		saveReportUniqueName = common.getProperty("saveReportUniqueName");
		login = new LoginPage(driver);
		home = new HomePage(driver);
		Accounts = new AccountsPage(driver);
		NewAccountEdit = new NewAccountEditPage(driver);
		NewView = new NewViewPage(driver);
		EditView = new EditViewPage(driver);
		MergeAccounts = new MergeMyAccountsPage(driver);
		UnsavedReport = new UnsavedReportPage(driver);
	}
	
	@Test
	
	public void TC10createAnAccount() {
		login.enterIntousername(username);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickOnAccountsTab();
		Accounts.clickOnNew();
		NewAccountEdit.EnterIntoAccountName(AccountName);
		NewAccountEdit.selectType();
		NewAccountEdit.selectCustomerPriority();
		NewAccountEdit.clickOnSave();
		
	}
	
	@AfterMethod
	public void teardown() {
		takescreenshot(driver);
		System.out.println("Took screenshot");
		driver.close();
	}
	
	@Test
	public void TC11createNewView() {
		login.enterIntousername(username);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickOnAccountsTab();
		Accounts.clickOnCreateNewView();
		NewView.enterIntoViewName(strViewName);
		NewView.enterIntoViewUniqueName(strUViewName);
		
	}
	
	@Test
	public void TC12EditView() {
		login.enterIntousername(username);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickOnAccountsTab();
		Accounts.selectViewDropDown();
		Accounts.clickOnEdit();
		EditView.enterIntoVname(strVname);
		EditView.selectFieldDropdown();
		EditView.selectOPeratorDropdown();
		EditView.enterIntoValue(strValue);
		EditView.clickOnEVSave();
	}
	
	@Test
	public void Tc13MergeAccounts() {
		login.enterIntousername(username);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickOnAccountsTab();
		Accounts.clickOnMergeAccounts();
		MergeAccounts.enterIntoFindAccountText(strAccN);
		MergeAccounts.clickOnFindAccountButton();
		MergeAccounts.clickOnCheckBox1();
		MergeAccounts.clickOnCheckBox2();
		MergeAccounts.clickOnSubmit();
		MergeAccounts.clickOnMerge();
	}
	
	@Test
	public void TC14CreateAccountReport() throws InterruptedException {
		login.enterIntousername(username);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickOnAccountsTab();
		Accounts.clickOnAccountsActivity();
		UnsavedReport.clickOnDateField();
		UnsavedReport.clickOnCreatedDate();
		//UnsavedReport.clickOnFromDate();
		//UnsavedReport.getFromDate();
		UnsavedReport.clickOnToDate();
		UnsavedReport.clickOnMonth();
		UnsavedReport.clickOnNov();
		UnsavedReport.clickOnOk();
		UnsavedReport.getToDate();
		UnsavedReport.clickOnSave();
		UnsavedReport.enterIntosaveReportName(saveReportName);
		UnsavedReport.enterIntosaveReportUniqueName(saveReportUniqueName);
		UnsavedReport.clickOnsaveAndRun();
		
	}
	
}
