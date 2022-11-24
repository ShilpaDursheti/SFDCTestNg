package com.training.pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.training.base.BasePage;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="username")
	WebElement username;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement password;
	
	@FindBy(id="Login")
	WebElement loginButton;
	
	@FindBy(id="error")
	WebElement errorMessage;
	
	@FindBy(id = "rememberUn")
	WebElement checkbox;
	
	
	@FindBy(xpath = "//span[@id=\"idcard-identity\"]")
	WebElement lastusername;
	
	@FindBy(id = "forgot_password_link")
	WebElement ForgotPassword;
	
	@FindBy(id = "un")
	WebElement FUserName;
	
	@FindBy(id = "continue")
	WebElement Continue;
	
	@FindBy(id = "header")
	WebElement CheckEmail;
	
	@FindBy(id = "error")
	WebElement InvalidUsernamePasswordErrormsg;
	
	
	
	public void enterIntousername(String stremail) {
		WaitForElement(username, 20);
		enterText(username, stremail, "usernameField");
	}
	
	public void enterIntoPassword(String strpassword) {
		enterText(password, strpassword, "passwordField");
	}
	public void clickOnLogin() {
		clickOnElement(loginButton,"LoginButton");
	}
	public void printErrorMessage() {
		printMessage(errorMessage, "ErrorText");
	}
	public void clickOnCheckbox() {
		clickOnElement(checkbox,"CheckBox");
	}
	public void validateUsernameText() {
		WaitForElement(lastusername,20);
		String Expected = "AdityaN@abc.com";
		String Actual = lastusername.getText();
		System.out.println(Actual);
		if(Actual.equalsIgnoreCase(Expected)) {
			System.out.println("TestPass: "+ Actual + " is displayed");
		}
	}
	
	public void clickForgotPassword() {
		clickOnElement(ForgotPassword, "ForgotPasswordButton");
	}
	public void enterIntoFUserName(String stremail) {
		enterText(FUserName, stremail, "FUserNameField");
	}
	public void clickOnContinue() {
		clickOnElement(Continue, "ContinueButton");
	}
	public void emailSentTextConfirmation() {
		printMessage(CheckEmail, "Text");
	}
	
	public void printInvalidUsernamePasswordErrormsg() {
		printMessage(InvalidUsernamePasswordErrormsg, "Text");
	}

}
