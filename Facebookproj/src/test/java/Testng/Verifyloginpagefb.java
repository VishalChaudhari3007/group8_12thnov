package Testng;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BrowserSetUps.Basefb;
import Page.Loginpage;
//import Popup.Signuppop;
import Utils.UtilityFb;


public class Verifyloginpagefb {
	

	WebDriver driver;
	Loginpage loginpage;
	String testID ;

	@BeforeSuite
	public void beforSuite()
	{
		System.out.println("Before Suite testng1");
	}
	
	@Parameters("browser")
	@BeforeTest
	public void openBrowser(String browserName)
	{
		System.out.println("Before Test testng1");
		
		if(browserName.equals("Chrome"))
		{
			driver = Basefb.openChromeBrowser();
		}
		

		if(browserName.equals("Firefox"))
		{
			driver = Basefb.openFirefoxBrowser();
		}
		

		if(browserName.equals("Edge"))
		{
			driver = Basefb.openEdgeBrowser();
		}
	}

	
	@BeforeClass
	public void openwebpage()
	{
		System.out.println("openwebpage");
		loginpage = new Loginpage(driver);
			
	}
	
	@BeforeMethod
	public void goToCreateAccPage() 
	{
		System.out.println("Before Method");
		driver.get("https://www.facebook.com");
		
	}
	
	@Test (priority = 1)
	public void verifyLoginPageFunction() throws EncryptedDocumentException, InterruptedException, IOException
	{
		testID = "T1";
		System.out.println("Test1");
		String data = UtilityFb.getExcelData("Sheet1", 1, 0);
		System.out.println(data);
		loginpage.sendusername();
		loginpage.sendpass();
		loginpage.clickonloginbutton();		
		String Actualtitle = driver.getTitle();
		System.out.println(Actualtitle);
		String ActualURL = driver.getCurrentUrl();
		System.out.println(ActualURL);
		String Expectedtitle = "Facebook – log in or sign up";
		String ExpectedURL = "https://www.facebook.com/";
		
		if(Expectedtitle.equals(Actualtitle) && ExpectedURL.equals(ActualURL))
		{
			System.out.println("PASSED");
		}
		else
		{
			System.out.println("FAILED");
		}
		UtilityFb.captureScreen(driver, testID);
		
	}
	
	@Test (priority = 2)
	public void verifyLoginPage()
	{
		testID = "T2";
		System.out.println("Test2");
	
    }
	
	
	@AfterMethod
	public void aftermethod(ITestResult result) throws IOException, InterruptedException
	{
		if(ITestResult.FAILURE == result.getStatus())
		{
			UtilityFb.captureScreen(driver, testID);
		}
		System.out.println("After Method");
		
	}
	
	@AfterClass
	public void afterclass()
	{
		System.out.println("After Class");
		
	}
	
	@AfterTest
	public void closeBrowser()
	{
		System.out.println("After Test Testng1");
		driver.close();
	}
	
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("After Suite testng1");
	}
	
	
	
	
	

}
