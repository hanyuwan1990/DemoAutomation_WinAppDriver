package com.mytest.Pages;

import static org.testng.Assert.assertEquals;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import io.appium.java_client.windows.WindowsDriver;

public class registration_Page {
	
	private WindowsDriver registration_Driver = null;
	public registration_Page(WindowsDriver wd) {
		registration_Driver = wd;
	}
	
	
//Define page variable & message=================
	public String firstname_Test = "FPT";
	public String lastname_Test = "SOFTWARE";
	public String password_Test = "123";
	public String password2_Test = "456";
	public String passwordConfirm_Test = "123";
	public String addressTest = "Nam Ky Khoi Nghia";
	public String emailID_Test = "fdn@fosft.com.vn";
	public String invalidEmailID_Test = "123";
	public String successMsg = "You have Registered successfully.";
	public String missingEmail_msg = "Enter an email.";
	public String invalidEmail_msg = "Enter a valid email.";
	public String missingPW_msg = "Enter password.";
	public String missingConfirmPW_msg = "Enter Confirm password.";
	public String invalidConfirmPW_msg = "Confirm password must be same as password.";
	
	
	
//Define page methods=====================
	
	public void enterRegisterForm(String firstName, String lastName, String emailID, String password, String passwordConfirm, String address ) {
		firstName_textbox().sendKeys(firstName);
		lastName_textbox().sendKeys(lastName);
		emailID_textbox().sendKeys(emailID);
		pw_textbox().sendKeys(password);
		pwConfirm_textbox().sendKeys(passwordConfirm);
		address_textbox().sendKeys(address);
	}
	
	public void registerAccount (String firstName, String lastName, String emailID, String password, String passwordConfirm, String address ) {
		enterRegisterForm(firstName, lastName, emailID, password, passwordConfirm, address);
		submit_btn().click();
		
	}
	
	public void switchToLoginPage() {
		login_btn().click();
		registration_Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public void messageVerification(String expectedMessage) {
		var actualMessageContent = error_msg().getText();
		assertEquals(expectedMessage, actualMessageContent, "Message is wrong");				 
	}
	
//Define page elements================
	public WebElement firstName_textbox () {
		return registration_Driver.findElementByAccessibilityId("textBoxFirstName");
	}
	
	public WebElement lastName_textbox () {
		return registration_Driver.findElementByAccessibilityId("textBoxLastName");
	}
	
	public WebElement emailID_textbox () {
		return registration_Driver.findElementByAccessibilityId("textBoxEmail");
	}
	
	public WebElement pw_textbox () {
		return registration_Driver.findElementByAccessibilityId("passwordBox1");
	}
	
	public WebElement pwConfirm_textbox () {
		return registration_Driver.findElementByAccessibilityId("passwordBoxConfirm");
	}
	
	public WebElement address_textbox () {
		return registration_Driver.findElementByAccessibilityId("textBoxAddress");
	}
	
	public WebElement submit_btn () {
		return registration_Driver.findElementByAccessibilityId("Submit");
	}
	
	public WebElement reset_btn () {
		return registration_Driver.findElementByAccessibilityId("button2");
	}
	
	public WebElement cancel_btn () {
		return registration_Driver.findElementByAccessibilityId("button3");
	}
	
	public WebElement error_msg () {
		return registration_Driver.findElementByAccessibilityId("errormessage");
	}
	
	public WebElement login_btn () {
		return registration_Driver.findElementByName("Login");
	}

}
