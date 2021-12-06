package com.mytest;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.*;

import com.mytest.Pages.login_Page;
import com.mytest.Pages.registration_Page;

import io.appium.java_client.windows.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Example {
	
	private static WindowsDriver driver = null;
	private registration_Page reg_Pg = null;
	private login_Page login_Pg = null;
	
	
	@BeforeClass
	public void setUp() {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("app", "G:\\AutomationWinAppDriver\\TestExample\\Login_WPF\\Login_WPF\\bin\\Debug\\Login_WPF.exe");
		
		try {
			driver = new WindowsDriver (new URL("http://127.0.0.1:4723"), cap);
			Assert.assertNotNull(driver);
			reg_Pg = new registration_Page(driver);		
			login_Pg = new login_Page(driver);	
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
	
	
	
	@AfterMethod
	public void clearUp() {
		driver.quit();		
		setUp();
	}
	
	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
	
	@Test (description = "TC01: Check message when submiting form with invalid required value")
	public void TestCase01() {				
		System.out.print("\nStep 1: Leave all field blank");
		reg_Pg.enterRegisterForm("", "", "", "", "", "");
		
		System.out.print("\nStep 2: Click Submit button");
		reg_Pg.submit_btn().click();
		
		System.out.print("\nStep 3: Check the missing email message displays");
		reg_Pg.messageVerification(reg_Pg.missingEmail_msg);

		System.out.print("\nStep 4: Click Reset button");
		reg_Pg.reset_btn().click();
		
		System.out.print("\nStep 5: Register account with invalid email field");
		reg_Pg.registerAccount("", "", reg_Pg.invalidEmailID_Test, "", "", "");		
		
		System.out.print("\nStep 6: Check the invalid email message displays");
		reg_Pg.messageVerification(reg_Pg.invalidEmail_msg);
				
		System.out.print("\nStep 7: Register account with valid email but no password");
		reg_Pg.registerAccount("", "", reg_Pg.emailID_Test, "", "", "");		
		
		System.out.print("\nStep 8: Check the missing password message displays");
		reg_Pg.messageVerification(reg_Pg.missingPW_msg);
		
		System.out.print("\nStep 9: Register account with no confirm password");
		reg_Pg.reset_btn().click();
		reg_Pg.registerAccount("", "", reg_Pg.emailID_Test, reg_Pg.password_Test, "", "");		
		
		System.out.print("\nStep 10: Check the missing confirm password message displays");
		reg_Pg.messageVerification(reg_Pg.missingConfirmPW_msg);
		
		System.out.print("\nStep 11: Register account with password and confirm password different");
		reg_Pg.reset_btn().click();
		reg_Pg.registerAccount("", "", reg_Pg.emailID_Test, reg_Pg.password_Test, reg_Pg.password2_Test, "");		
		
		System.out.print("\nStep 12: Check the missing confirm password message displays");
		reg_Pg.messageVerification(reg_Pg.invalidConfirmPW_msg);			
		
	}
	
	
	@Test (description = "TC02: Register a account successful with valid information")
	public void TestCase02() {				
		System.out.print("\nStep 1: Enter valid information into required field");
		reg_Pg.registerAccount(reg_Pg.firstname_Test, reg_Pg.lastname_Test, reg_Pg.emailID_Test, reg_Pg.password_Test, reg_Pg.passwordConfirm_Test, reg_Pg.addressTest);
		
		System.out.print("\nStep 2: Check the success message displays");
		reg_Pg.messageVerification(reg_Pg.successMsg);
		
	}		

//	@Test (description = "TC03: Login account with invalid email format")
//	public void TestCase03() {				
//		System.out.print("\nStep 1: Enter valid information into required field");
//		reg_Pg.registerAccount(reg_Pg.firstname_Test, reg_Pg.lastname_Test, reg_Pg.emailID_Test, reg_Pg.password_Test, reg_Pg.passwordConfirm_Test, reg_Pg.addressTest);
//		
//		System.out.print("\nStep 2: Check the success message displays");
//		reg_Pg.messageVerification(reg_Pg.successMsg);		
//		
//		System.out.print("\nStep 3: Click Login button");
//		reg_Pg.switchToLoginPage();
//		
//		System.out.print("\nStep 4: Leave email and password blank");
//		login_Pg.enterAccount("", "");
//		
//		System.out.print("\nStep 5: Click Login button");
//		login_Pg.login_btn().click();
//		
//		System.out.print("\nStep 6: Check the missing email message displays");
//		login_Pg.messageVerification(login_Pg.missingEmail_msg);
//		
//		System.out.print("\nStep 7: Enter a invalid email and click Login button");
//		login_Pg.login("test","");
//		
//		System.out.print("\nStep 8: Check the invalid email message displays");
//		login_Pg.messageVerification(login_Pg.invalidEmail_msg);
//		
//		System.out.print("\nStep 9: Login with valid email but leave password blank");
//		login_Pg.login(reg_Pg.emailID_Test,"");
//		
//		System.out.print("\nStep 10: Check the invalid password message displays");
//		login_Pg.messageVerification(login_Pg.invalidAccountInfo_msg);		
//		
//		System.out.print("\nStep 11: Login with valid email & wrong password");
//		login_Pg.login(reg_Pg.emailID_Test,reg_Pg.password2_Test);
//		
//		System.out.print("\nStep 12: Check the invalid password message displays");
//		login_Pg.messageVerification(login_Pg.invalidAccountInfo_msg);
//		
//		
//	}
//	
//	@Test (description = "TC04: Login account successful with valid information")
//	public void TestCase04() {				
//		System.out.print("\nStep 1: Enter valid information into required field");
//		reg_Pg.registerAccount(reg_Pg.firstname_Test, reg_Pg.lastname_Test, reg_Pg.emailID_Test, reg_Pg.password_Test, reg_Pg.passwordConfirm_Test, reg_Pg.addressTest);
//		
//		System.out.print("\nStep 2: Check the success message displays");
//		reg_Pg.messageVerification(reg_Pg.successMsg);		
//		
//		System.out.print("\nStep 3: Click Login button");
//		reg_Pg.switchToLoginPage();
//		
//		System.out.print("\nStep 4: Login with valid info");
//		login_Pg.login(reg_Pg.emailID_Test, reg_Pg.password_Test);		
//		
//		System.out.print("\nStep 5: Check the success email message displays");
//		login_Pg.messageVerification(login_Pg.success_msg);		
//		
//	}	

}
