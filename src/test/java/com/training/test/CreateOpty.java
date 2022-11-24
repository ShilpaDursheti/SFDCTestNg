package com.training.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.pages.HomePage;
import com.training.pages.LoginPage;
import com.training.pages.NewOpportunityPage;
import com.training.pages.OpportunityPage;
import com.training.pages.OptyPipelinePage;
import com.training.utilities.CommonUtilities;

public class CreateOpty extends BaseTest{
	
	
	WebDriver driver;
	String url;
	String browser;
	String username;
	String password;
	CommonUtilities common = new CommonUtilities();
	LoginPage login;
	HomePage home;
	OpportunityPage Opportunity;
	NewOpportunityPage NewOpty;
	OptyPipelinePage OptyPipeline;
	
	@BeforeMethod
	public void beforemethod() throws IOException {
		
		url = common.getProperty("url");
		browser = common.getProperty("browser");
		driver = getDriver(browser);
		driver.get(url);
		username = common.getProperty("username");
		password = common.getProperty("password");
		login = new LoginPage(driver);
		home = new HomePage(driver);
		Opportunity = new OpportunityPage(driver);
		NewOpty = new NewOpportunityPage(driver);
		OptyPipeline = new OptyPipelinePage(driver);
		
	}
		@Test
		public void TC15OpportunitiesDropDown() {
			
			login.enterIntousername(username);
			login.enterIntoPassword(password);
			login.clickOnLogin();
			home.clickOnOpportunityTab();
			Opportunity.verifyOptyDropdown();
		}
		
		@Test
		public void TC16createANewOpty() {
			login.enterIntousername(username);
			login.enterIntoPassword(password);
			login.clickOnLogin();
			home.clickOnOpportunityTab();
			Opportunity.clickOnNew();
			NewOpty.EnterIntoOptyName();
			NewOpty.clickOnAccountLookUpIcon();
			NewOpty.SwitchToFrame();
			NewOpty.EnterIntoSearchTextBox();
			NewOpty.clickOnGo();
			NewOpty.SwitchToFrame1();
			NewOpty.clickOnAccountName();
			NewOpty.clickOnCloseDate();
			NewOpty.clickOnDate();
			NewOpty.SelectStageDropDown();
			NewOpty.EnterIntoPrabability();
			NewOpty.SelectleadSource();
			NewOpty.clickOnPrimaryCampaign();
			NewOpty.enterIntoPCSearchTBox();
			NewOpty.clickOnGo2();
			NewOpty.clickOnPCResult();
			NewOpty.clickOnsave();
			
		}
		
		@Test
		public void TC17TestOpportunityPipelineReport() {
			login.enterIntousername(username);
			login.enterIntoPassword(password);
			login.clickOnLogin();
			home.clickOnOpportunityTab();
			Opportunity.clickOnOptyPipeline();
			OptyPipeline.validateOptyPage();
			
		}
		
		@Test
		public void TC18TestStuckOpportunitiesReport() {
			login.enterIntousername(username);
			login.enterIntoPassword(password);
			login.clickOnLogin();
			home.clickOnOpportunityTab();
			Opportunity.clickOnStuckOpty();
		}
		
		@Test
		public void TC19TestQuarterlySummaryReport() {
			login.enterIntousername(username);
			login.enterIntoPassword(password);
			login.clickOnLogin();
			home.clickOnOpportunityTab();
			Opportunity.selectQSInterval();
			Opportunity.selectQSInclude();
		}
		
		@AfterMethod
		public void teardown() {
			takescreenshot(driver);
			System.out.println("Took screenshot");
			driver.close();
		}

}
