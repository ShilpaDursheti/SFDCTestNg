package com.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.training.base.BasePage;

public class NewAccountEditPage extends BasePage {

	
 public NewAccountEditPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
@FindBy(id = "acc2")
 WebElement AccountName;

 @FindBy (id = "acc6")
 WebElement Type;
 
 @FindBy (id = "00NDn000006w1Y0")
 WebElement CustomerPriority;
 
 @FindBy(xpath = "//input[@ tabindex=\"34\"]")
 WebElement Save;
 
 
 public void EnterIntoAccountName(String strAccName) {
	 WaitForElement(AccountName, 20);
	 enterText(AccountName, strAccName, "AccountName");
 }
 
 public void selectType() {
	 Select accountType = new Select(Type);
	 accountType.selectByVisibleText("Technology Partner");
 }
	
 public void selectCustomerPriority() {
	 Select CPriority = new Select (CustomerPriority);
	 CPriority.selectByValue("High");
 }
 public void clickOnSave() {
	 clickOnElement(Save, "Save");
 }




}
