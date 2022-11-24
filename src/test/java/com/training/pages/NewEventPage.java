package com.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.training.base.BasePage;

public class NewEventPage extends BasePage{

	public NewEventPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//img[@ class=\"comboboxIcon\"]")
	WebElement subject;
	
	@FindBy(xpath = "//a[@ href=\"javascript:pickValue(4);\"]")
	WebElement other;
	
	@FindBy(id="EndDateTime_time")
	WebElement EndDateTime;
	
	@FindBy(xpath = "//div[@id=\"timePickerItem_42\"]")
	WebElement EndTime;
	
	@FindBy(xpath = "//td[@id=\"topButtonRow\"]//input[@ name=\"save\"]")
	WebElement save;
	
	@FindBy(xpath = "//a[@href=\"javascript:pickValue(4);\"]")
	WebElement other2;
	
	@FindBy(id="timePickerItem_38")
	WebElement EndTime2;
	
	@FindBy(id="IsRecurrence")
	WebElement Recurrence;
	
	@FindBy(id="rectypeftw")
	WebElement Weekly;
	
	@FindBy(id="RecurrenceEndDateOnly")
	WebElement RecurrenceEndDate;
	
	@FindBy(xpath ="//td[@ id=\"bottomButtonRow\"]//input[@name=\"save\"]")
	WebElement save2;
	
	
	public void clickOnSubject() {
		String Title = driver.getTitle();
		System.out.println(Title);
		WaitForElement(subject, 20);
		clickOnElement(subject, "subject");
		
		for(String handle: driver.getWindowHandles()) {
			if(!Title.equalsIgnoreCase(handle)) {
				driver.switchTo().window(handle);
			}
		}
		
	}
	
	public void clickOnOther() {
		String Title = driver.getTitle();
		System.out.println(Title);
		WaitForElement(other, 20);
		clickOnElement(other, "other");
		for(String handle: driver.getWindowHandles()) {
			if(!Title.equalsIgnoreCase(handle)) {
				driver.switchTo().window(handle);
			}
		}
		System.out.println(driver.getTitle());
	}
	
	
	
	public void clickOnEndDateTime() {
		WaitForElement(EndDateTime, 20);
		clickOnElement(EndDateTime, "EndDateTime");
		
		
	}
	public void clickOnEndTime() {
		WaitForElement(EndTime, 20);
		clickOnCheckBox(EndTime, "EndTime");
		driver.switchTo().defaultContent();
	}
	
	public void clickOnSave() {
		WaitForElement(save, 20);
		clickOnElement(save, "save");
	}
	
	public void clickOnOther2() {
		String Title = driver.getTitle();
		System.out.println(Title);
		WaitForElement(other2, 20);
		clickOnElement(other2, "other2");
		for(String handle: driver.getWindowHandles()) {
			if(!Title.equalsIgnoreCase(handle)) {
				driver.switchTo().window(handle);
			}
		}
		System.out.println(driver.getTitle());
	}
	public void clickOnEndTime2() {
		WaitForElement(EndTime2, 20);
		clickOnCheckBox(EndTime2, "EndTime2");
		driver.switchTo().defaultContent();
	}
	
	public void clickOnRecurrence() {
		WaitForElement(Recurrence, 20);
		clickOnElement(Recurrence, "Recurrence");
	}
	
	public void clickOnWeeklyradioButton() {
		WaitForElement(Weekly, 20);
		clickOnElement(Weekly, "Weekly");
	}
	
	public void EnterIntoRecurrenceEndDate() {
		RecurrenceEndDate.sendKeys("12/4/2022");
	}
	public void clickOnSave2() {
		clickOnElement(save2, "save2");
	}
	

}
