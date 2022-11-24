package com.training.pages;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.training.base.BasePage;

public class NewOpportunityPage extends BasePage{

	public NewOpportunityPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id="opp3")
	WebElement OptyName;
	
	@FindBy(xpath = "//img[@title=\"Account Name Lookup (New Window)\"]")
	WebElement  AccountLookUpIcon;
	
	@FindBy(xpath = "//frame[@id=\"searchFrame\"]")
	WebElement Frame;
	
	@FindBy(xpath= "//input[@placeholder=\"Search...\"]")
	WebElement SearchTextBox;
	
	@FindBy (name="go")
	WebElement Go;
	
	@FindBy(xpath ="//frame[@id='resultsFrame']")
	WebElement Frame1;
	
	
	@FindBy(xpath = "//a[@class=\" dataCell \"]")
	WebElement AccountName;
	
	@FindBy(id = "opp9")
	WebElement closeDate;
	
	@FindBy(xpath= "//table[@ class='calDays' ]/tbody/tr[5]/td[4]")
	WebElement  Date;
	
	@FindBy (id = "opp11")
	WebElement StageDropDown;
	
	@FindBy(id = "opp12")
	WebElement Probability;
	
	@FindBy(id ="opp6")
	WebElement leadSource;
	
	@FindBy(xpath = "//img[@title=\"Primary Campaign Source Lookup (New Window)\"]")
	WebElement PrimaryCampaign;
	
	@FindBy(id="searchFrame")
	WebElement Frame2;
	
	@FindBy(xpath = "//input[@placeholder='Search...']")
	WebElement PCSearchTBox;
	
	@FindBy(xpath = "//input[@class=\"btn\"]")
	WebElement Go2;
	
	@FindBy(id="resultsFrame")
	WebElement Frame3;
	
	//@FindBy(xpath = "//table[@ class=\"list\"]/tbody/tr[2]/th/a[@class=\" dataCell \"]")
	@FindBy(xpath= "//tr[@ class=\"dataRow even first\"]/th/a]")
	WebElement PCResult;
	
	@FindBy(name ="save")
	WebElement save;
	
	
	public void EnterIntoOptyName() {
		WaitForElement(OptyName, 20);
		OptyName.sendKeys("NewOpty");
	}
	public void clickOnAccountLookUpIcon() {
		clickOnElement(AccountLookUpIcon, "AccountLookUpIcon");
		
		String ParentTitle = driver.getTitle();
		System.out.println(ParentTitle);
		
		Set<String> getAllWindows = driver.getWindowHandles();
		String[] getWindow = getAllWindows.toArray(new String[getAllWindows.size()]);
		driver.switchTo().window(getWindow[1]);
		System.out.println(driver.getTitle());
	}

		/*for(String handle: driver.getWindowHandles()) {
				driver.switchTo().window(handle);
			}
		System.out.println(driver.getTitle());
		
	}*/
	
	public void SwitchToFrame() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().frame(Frame);
	}
	public void EnterIntoSearchTextBox() {
		SearchTextBox.sendKeys("Gl");
	}
	public void clickOnGo() {
		clickOnElement(Go, "Go");
		driver.switchTo().defaultContent();
	}
	
	public void SwitchToFrame1() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().frame(Frame1);
		System.out.println("Switched to Frame1");
	}
	public void clickOnAccountName(){
		
		Set<String> getAllWindows = driver.getWindowHandles();
		String[] getWindow = getAllWindows.toArray(new String[getAllWindows.size()]);
		System.out.println(driver.getTitle());
		WaitForElement(AccountName, 20);
		clickOnElement(AccountName, "AccountName");
		
		
		driver.switchTo().window(getWindow[0]);
		System.out.println(driver.getTitle());
		
		
	}
	
	
	public void clickOnCloseDate() {
		
	clickOnElement(closeDate, "closeDate");	
	}
	public void clickOnDate() {
		clickOnElement(Date, "Date");
	}
	
	public void SelectStageDropDown() {
		WaitForElement(StageDropDown, 20);
		Select SDd = new Select(StageDropDown);
		SDd.selectByVisibleText("Prospecting");
	}
	public void EnterIntoPrabability() {
		Probability.clear();
		Probability.sendKeys("20");
	}
	public void SelectleadSource() {
		WaitForElement(leadSource, 20);
		Select lSDd = new Select (leadSource);
		lSDd.selectByVisibleText("Web");
	}
	public void clickOnPrimaryCampaign() {
		String parentTitle = driver.getTitle();
		System.out.println("Parent Title = "+parentTitle);
		
		clickOnElement(PrimaryCampaign, "PrimaryCampaign");
		
		
		for(String handle: driver.getWindowHandles()) {
			if(!driver.getTitle().equals(parentTitle)) {
				driver.switchTo().window(handle);
			}
		}
	}
	
	public void SwitchToFrame2() {
		driver.switchTo().frame(Frame2);
	
	}
	public void enterIntoPCSearchTBox() {
		WaitForElement(PCSearchTBox, 20);
		PCSearchTBox.sendKeys("*a");
	}
	
	public void clickOnGo2() {
		clickOnElement(Go2, "Go2");
		driver.switchTo().defaultContent();
		System.out.println("Driver switched to default content");
	}
	
	public void SwitchToFrame3() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().frame(Frame3);
		System.out.println("Entered into frame3");
	}
	
	public void clickOnPCResult() {
		WaitForElement(PCResult, 20);
		clickOnElement(PCResult, "PCResult");
	}
	public void clickOnsave() {
		WaitForElement(save, 20);
		clickOnElement(save, "save");
	}
	

}
