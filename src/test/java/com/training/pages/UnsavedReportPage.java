package com.training.pages;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.training.base.BasePage;

public class UnsavedReportPage extends BasePage{

	public UnsavedReportPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath = "//img[@id='ext-gen148']")
	WebElement DateField;
	
	@FindBy(xpath = "//div[contains(text(),'Created Date')]")
	WebElement CreatedDate;
	
	
	@FindBy(id = "id=\"ext-gen152\"")
	WebElement FromDate;
	
	@FindBy(xpath = "//table[@class=\"x-date-inner\"][1]")
	List<WebElement> SecondRow;
	
	@FindBy (xpath = "//span[contains(text(), '11')]")
	WebElement getFromDate;
	
	@FindBy(xpath = "//table/tbody/tr[2]/td[2]//img[@id=\"ext-gen154\"]")
	WebElement ToDate;
	
	//@FindBy(xpath = "//table[@id=\"ext-gen283\"]//table/tbody/tr[2]/td[2]/em[@ id=\"ext-gen289\"]")
	//@FindBy(xpath = "//table[@id=\"ext-comp-1112\"]/tr[2]/td[2]")
	@FindBy(id="ext-gen274")
	WebElement MonthButton;
	
	//@FindBy(xpath = "//table[@id=\"ext-gen295\"]//a[@id=\"ext-gen303\"]")
	@FindBy(xpath = "//a[@id=\"ext-gen302\"]")
	WebElement Nov;
	
	@FindBy(xpath = "//button[@class=\"x-date-mp-ok\"]")
	WebElement Ok;
	
	@FindBy(xpath = "((//span[contains(text(),'30')])[2]")
	WebElement getToDate;
	
	@FindBy(xpath = "//button[@ id=\"ext-gen49\"]")
	WebElement Save;
	
	@FindBy(xpath = "//input[@id=\"saveReportDlg_reportNameField\"]")
	WebElement saveReportName;
	
	@FindBy (xpath = "//input[@id=\"saveReportDlg_DeveloperName\"]")
	WebElement saveReportUniqueName;

	@FindBy(xpath = "id=\"ext-gen340\"")
	WebElement saveAndRun;
	  
	
	public void clickOnDateField() throws InterruptedException {
		Thread.sleep(3000);
		//WaitForElement(DateField,30);
		clickOnElement(DateField, "DateField");
	}
	
	public void clickOnCreatedDate() {
		WaitForElement(CreatedDate, 20);
		clickOnElement(CreatedDate, "CreatedDate");
	}
	public void clickOnFromDate() {
		WaitForElement(FromDate, 20);
		clickOnElement(FromDate, "FromDate");
	}
	
	public void getSecondRow() {
		for(WebElement rowValue: SecondRow) {
			if(rowValue.getText().equals("11")) {
				rowValue.findElement(By.linkText("11")).click();
				System.out.println("11 is clicked");
			      break;
			}
		}
		
	}
	public void getFromDate() {
		WaitForElement(getFromDate, 20);
		clickOnElement(getFromDate, "getFromDate");

	}
	
	public void clickOnToDate() {
		WaitForElement(ToDate, 20);
		clickOnElement(ToDate, "ToDate");
	}
	
	public void clickOnMonth() {
		WaitForElement(MonthButton, 20);
		clickOnElement(MonthButton, "MonthButton");
		
		/*List<WebElement> columns=MonthButton.findElements(By.tagName("td"));

		for (WebElement cell: columns){
		   //Select Nov
		   if (cell.getText().equals("Nov")){
		      cell.findElement(By.linkText("Nov")).click();
		      break;
		 }
		}*/
			
	}
	public void clickOnNov() {
		WaitForElement(Nov, 20);
		clickOnElement(Nov, "Nov");
	}
	public void clickOnOk() {
		clickOnElement(Ok, "Ok");
	}
	
	public void getToDate() {
		WaitForElement(getToDate,20);
		clickOnElement(getToDate, "getToDate");
	}
	
	
	public void clickOnSave() {
		clickOnElement(Save, "Save");
	}
	public void enterIntosaveReportName(String ReportName) {
		enterText(saveReportName, ReportName, "saveReportName");
	}
	public void enterIntosaveReportUniqueName(String UReportName) {
		saveReportUniqueName.clear();
		enterText(saveReportUniqueName,UReportName,"saveReportUniqueName");
		
	}
	public void clickOnsaveAndRun() {
		clickOnElement(saveAndRun, "saveAndRun");
	}
}
