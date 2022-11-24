package com.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.training.base.BasePage;

public class MyProfilePage extends BasePage{
	
	public MyProfilePage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//a[contains(text(),'My Profile')]")
	WebElement MyProfile;
	
	@FindBy(xpath = "//img[@src=\"/img/func_icons/util/pencil12.gif\"][1]")
	WebElement EditProfile;
	
	
	@FindBy(xpath = "//iframe[@src=\"/_ui/core/userprofile/ContactInfoEditPage?u=005Dn000001ROpM&focus=email\"]")
	WebElement imageFrame;
	
	@FindBy(xpath = "//a[@ aria-controls=\"TabPanel:0:Body:1\"]")
	WebElement about;
	
	@FindBy(id = "lastName")
	WebElement lastname;
	
	@FindBy(xpath = "//input[@value=\"Save All\"]")
	WebElement saveAll;
	
	@FindBy (xpath = "//span[text()=\"Post\"]")
	WebElement post;
	
	@FindBy (xpath = "//iframe[@title=\"Rich Text Editor, publisherRichTextEditor\"]")
	WebElement imageFrame1;
	
	@FindBy (xpath = "//body[contains(text(),'Share an update, @mention someone...')]")
	WebElement postText;
	
	@FindBy(xpath = "//input[@value='Share']")
	WebElement share;
	
	@FindBy(id = "publisherAttachContentPost")
	WebElement File;
	
	@FindBy (id = "chatterUploadFileAction")
	WebElement UploadFileFromComputer;
	
	@FindBy(id ="chatterFile")
	WebElement ChooseFile;
	
	@FindBy (id = "publishersharebutton")
	WebElement Share1;
	
	@FindBy(id = "uploadLink")
	WebElement AddPhoto;
	
	@FindBy(id = "uploadPhotoContentId")
	WebElement iframe1;
	
	@FindBy (id = "j_id0:uploadFileForm:uploadInputFile")
	WebElement ChoosePhoto;
	
	@FindBy (id = "j_id0:uploadFileForm:uploadBtn")
	WebElement SavePhoto;
	
	@FindBy (id = "photo")
	WebElement CropHandle;
	
	@FindBy (id = "j_id0:j_id7:save")
	WebElement SaveButton;
	
	@FindBy(id="tailBreadcrumbNode")
	WebElement UserNameTitle;
	
	
	
	public void clickOnMyProfile() {
		clickOnElement(MyProfile, "MyProfileButton");
	}
	
	public void clickOnEditProfile() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clickOnElement(EditProfile, "EditProfileButton");
	}
	
	
	public void switchToFrame() {
		
			driver.switchTo().frame(imageFrame);
		}
	
	public void clickOnAboutTab() {
		
		clickOnElement(about, "aboutTab");
	}
	
	public void enterIntoLastName(String strName) {
		 lastname.clear();
		 enterText(lastname, strName, "lastname");
	 }
	 
	public void clickOnSaveAll() {
		clickOnElement(saveAll, "saveAll");
	}
	
	public void clickOnPost() {
		clickOnElement(post,"post");
	}
	
	public void SwitchToIFrame1() {
		WaitForElement(imageFrame1, 20);
		driver.switchTo().frame(imageFrame1);
	}
	
	public void enterIntopostText(String strPost) {
		enterText(postText, strPost, "postText");
	}
	public void clickOnShare() {
		driver.switchTo().defaultContent();
		clickOnElement(share, "share ");
	}
	
	public void clickOnFile() {
		clickOnElement(File,"File");
	}
	public void clickOnUploadFileFromComputer() {
		clickOnElement(UploadFileFromComputer,"UploadFileFromComputer");
	}
	public void enterIntoChooseFile(String strFile) {
		enterText(UploadFileFromComputer, strFile, "UploadFileFromComputer");
	}
	public void clickOnShare1() {
		clickOnElement(Share1,"Share1");
	}
	public void selectAddPhoto() {
		WaitForElement(AddPhoto, 20);
		Actions action = new Actions(driver);
		action.moveToElement(AddPhoto).click().build().perform();
	}
	public void switchToIframe1() {
		WaitForElement(iframe1, 20);
		driver.switchTo().frame(iframe1);
	}
	public void enterIntoChoosePhoto(String photoPath) {
		WaitForElement(ChoosePhoto, 20);
		enterText(ChoosePhoto, photoPath, "ChoosePhoto");
	}
	public void clickOnSavePhoto() {
		clickOnElement(SavePhoto, "SavePhoto");
	}
	public void cropPhoto() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Actions crop = new Actions (driver);
		crop.clickAndHold(CropHandle).moveByOffset(20, 30).release().build().perform();
	}
	
	public void clickOnSaveButton() {
		clickOnElement(SaveButton, "SaveButton");
	}
	
	public void getUserNameTitle() {
		String Title = UserNameTitle.getText();
		System.out.println(Title +" is displayed on User: Shilpa Dursheti ~ Salesforce - Developer Edition Page");
	}
}
