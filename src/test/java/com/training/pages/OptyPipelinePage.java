package com.training.pages;

import org.openqa.selenium.WebDriver;

import com.training.base.BasePage;

public class OptyPipelinePage extends BasePage{

	public OptyPipelinePage(WebDriver driver) {
		super(driver);
	}

	public void validateOptyPage() {
		String ExpTitle = "Opportunity Pipeline ~ Salesforce - Developer Edition";
		String ActTitle = driver.getTitle();
		System.out.println(ActTitle);
		if(ActTitle.equalsIgnoreCase(ExpTitle)) {
			System.out.println("TestPass: Opportunity Pipeline Page Displayed");
		}
	}
}
	
	