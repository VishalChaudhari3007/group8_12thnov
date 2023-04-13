package Testng;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
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
import Page.Forgotpass;
import Page.Loginpage;
import Popup.Signuppop;
import Utils.UtilityFb;

public class Verifyforgotpasspage {
	
	WebDriver driver;
	Loginpage loginpage;
	Forgotpass forgotpass;
	Signuppop signuppop;
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
	public void openBrowser() throws EncryptedDocumentException, InterruptedException, IOException
	{
		System.out.println("openBrowser");
		loginpage = new Loginpage(driver);
		loginpage.clickonforgetpass();
		forgotpass = new Forgotpass(driver);
	    signuppop = new Signuppop(driver);
		
	}
	
	@BeforeMethod
	public void goToForgotPasswordPage()
	{
		System.out.println("Before Method");
		driver.get("https://www.facebook.com");
		
	}
	
	
	@Test (priority = 0)
	public void verifyForgotPasswordPagetext () throws IOException, InterruptedException
	{
		testID = "T1";
		System.out.println("Test1");
		
		String actualtext = forgotpass.getusernametext();
		String Expectedtext = "Email address or mobile number";
		if(actualtext.equals(Expectedtext))
		{
			System.out.println("PASSED");
			
		}
		else
		{
			System.out.println("FAILED");
		}
		UtilityFb.captureScreen(driver, testID);
		
	}
	
	@Test (priority = 1 , invocationCount = 1) 
	public void verifysearchbuttonfunction () throws InterruptedException, EncryptedDocumentException, IOException
	{
		testID = "T2";
		System.out.println("Test2");
		String data = UtilityFb.getExcelData("Sheet1", 0, 1);
		System.out.println(data);
		forgotpass.sendemailandmob();
		forgotpass.clickonsearchbutton();
		
		String actualtext = forgotpass.getpagetext();
		String Expectedtext = "Please enter your email address or mobile number to search for your account.";
		if(actualtext.equals(Expectedtext))
		{
			System.out.println("PASSED");
			
		}
		else
		{
			System.out.println("FAILED");
		}
		
		UtilityFb.captureScreen(driver, testID);
		
	}
	
	@Test (priority = -1)
	public void verifycancelbuttonfunction () throws InterruptedException, EncryptedDocumentException, IOException
	{
		testID = "T3";
		System.out.println("Test3");
		String data = UtilityFb.getExcelData("Sheet1", 0, 1);
		System.out.println(data);
		forgotpass.sendemailandmob();
		forgotpass.clickoncancelbutton();
		
		String actualURL = driver.getCurrentUrl();
		System.out.println(actualURL);
		String actualtitle = driver.getTitle();
		System.out.println(actualtitle);
		String ExpectedURL = "https://www.facebook.com/login.php";
	    String Expectedtitle = "Log in to Facebook";
		

		if(ExpectedURL.equals(actualURL) && Expectedtitle.equals(actualtitle))
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
	public void verifyCreateAccpage() throws IOException, InterruptedException
	{
		testID = "T4";
		System.out.println("Test4");
		signuppop = new Signuppop(driver);
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
	
	
	
	@AfterMethod
	public void aftermethod(ITestResult result) throws IOException, InterruptedException
	{
		if(ITestResult.FAILURE == result.getStatus())
		{
			UtilityFb.captureScreen(driver, testID);
		}
		System.out.println("After Method");
		System.out.println("Logout");
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
