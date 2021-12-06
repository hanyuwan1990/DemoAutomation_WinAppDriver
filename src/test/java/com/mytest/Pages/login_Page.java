package com.mytest.Pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import io.appium.java_client.windows.WindowsDriver;

public class login_Page {
	private WindowsDriver login_Driver = null;	
	
	public login_Page (WindowsDriver wd) {
		login_Driver = wd;
	}
	
	
//Define page variable & message=================
	public String missingEmail_msg = "Enter an email.";
	public String invalidEmail_msg = "Enter a valid email.";
	public String invalidAccountInfo_msg = "Sorry! Please enter existing emailid/password.";
	public String success_msg = "Wellcom: ";
	
	
//Define page methods=====================	
	public void enterAccount (String username, String password) {		
		email_textbox().clear();
		email_textbox().sendKeys(username);
		pw_textbox().clear();
		pw_textbox().sendKeys(password);		
	}
	
	public void login(String username, String password) {
		enterAccount(username, password);
		login_btn().click();
	}
	
	public void messageVerification(String expectedMessage) {
		var actualMessageContent = error_msg().getText();
		assertEquals(expectedMessage, actualMessageContent, "Message is wrong");				 
	}
	
	
//Define page elements================
	public WebElement email_textbox () {
		return login_Driver.findElementByName("Email");
	}
	
	public WebElement pw_textbox () {
		return login_Driver.findElementByName("Password");
	}
	
	public WebElement login_btn () {
		return login_Driver.findElementByAccessibilityId("button1");
	}
	
	public WebElement error_msg () {
		return login_Driver.findElementByAccessibilityId("errormessage");
	}
	
	public WebElement register_lnk () {
		return login_Driver.findElementByName("Register");
	}

}
