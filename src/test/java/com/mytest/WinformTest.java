package com.mytest;
import org.testng.annotations.*;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;


public class WinformTest {
	
	private static WindowsDriver<WindowsElement> notepadSession = null;
	
	
	@BeforeClass
	 public static void setUp() {
	 try {
	 DesiredCapabilities capabilities = new DesiredCapabilities();
	 capabilities.setCapability("app", "C:\\Windows\\System32\\notepad.exe");
	 capabilities.setCapability("platformName","Windows");
	 capabilities.setCapability("deviceName", "WindowsPC");
	 notepadSession = new WindowsDriver<WindowsElement> (new URL("http://127.0.0.1:4723"), capabilities);
	 notepadSession.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	} catch (Exception e) {
	 e.printStackTrace();
	  }
	 }
	@AfterMethod
	 public void cleanApp(){
	 notepadSession.quit();
	 setUp();
	 }
	@AfterSuite
	 public void tearDown(){
	 notepadSession.quit();
	 }
	@Test
	public void testnote() {
//		notepadSession.findElementByAccessibilityId("15").sendKeys("abc");
	}
	
}
	
	
