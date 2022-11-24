package com.training.pages;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.training.base.BasePage;

public class OpportunityPage extends BasePage {

	public OpportunityPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "fcf")
	WebElement OptyDropdown;
	
	
	@FindBy(name ="new")
	WebElement New;
	
	@FindBy(xpath = "//a[contains(text(), 'Opportunity Pipeline')]")
	WebElement OptyPipeline;
	
	@FindBy(xpath = "//a[contains(text(), 'Stuck Opportunities')]")
	WebElement StuckOpty;
	
	@FindBy(id="quarter_q")
	WebElement QSInterval;
	
	@FindBy(id="open")
	WebElement QSInclude;
	
	
	
	public List<String> verifyOptyDropdown() {
		
		WaitForElement(OptyDropdown, 20);

		Select Opty = new Select(OptyDropdown);
		List<WebElement> OL = Opty.getOptions();
		List<String>OLS = new ArrayList<String>();
		for(WebElement a : OL) {
			OLS.add(a.getText());	
		}
		for(Object e: OLS) {
			System.out.println(e);
		}
		//System.out.print(OLS);
		
		return OLS;
		
	}
	
	public void clickOnNew() {
		WaitForElement(New, 20);
		clickOnElement(New, "New");
	}
	public void clickOnOptyPipeline() {
		WaitForElement(OptyPipeline, 20);
		clickOnElement(OptyPipeline, "OptyPipeline");
		
	}
	public void clickOnStuckOpty() {
		WaitForElement(StuckOpty, 20);
		clickOnElement(StuckOpty, "StuckOpty");
		
	}
	public void selectQSInterval() {
		WaitForElement(QSInterval, 20);
		Select QSI = new Select (QSInterval);
		QSI.selectByVisibleText("Next FQ");
	}
	public void selectQSInclude() {
		Select QInc = new Select (QSInclude);
		QInc.selectByVisibleText("Open Opportunities");
	}
	
	
	
	
}
