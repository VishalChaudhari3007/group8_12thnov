package Testclass;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Page.Forgotpass;

import Page.Loginpage;
import Popup.Signuppop;


public class Testfb {
	
	
public static void main(String[] args) throws InterruptedException{
		
		System.setProperty("webdriver.chrome.driver",
				"S:\\velocity notes\\Automation\\selenium setup\\chromedriver_win32\\chromedriver.exe");
		
		ChromeOptions ops =new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops);
		
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		Thread.sleep(3000);
		
		Loginpage loginpage = new Loginpage(driver);
		Thread.sleep(2000);
		loginpage.sendusername();
		Thread.sleep(2000);
		loginpage.sendpass();
		Thread.sleep(2000);
		loginpage.clickonloginbutton();
		Thread.sleep(2000);
		loginpage.clickonaccount();
		Thread.sleep(2000);
		
         loginpage.clickonlogoutbutton();
         Thread.sleep(2000);
         loginpage.clickoncreatenwacc();
		 Thread.sleep(2000);
		 loginpage.clickonforgetpass();
 	     Thread.sleep(2000);
		
		 Forgotpass forgotpass = new Forgotpass(driver); 
		 forgotpass.sendemailandmob(); 
		 Thread.sleep(2000);
		 forgotpass.clickonsearchbutton(); 
		 forgotpass.clickoncancelbutton(); 
		 forgotpass.getusernametext(); 
		 forgotpass.getpagetext();
		     
	    Signuppop signuppop = new Signuppop(driver);
	    signuppop.sendfirstname();
	    Thread.sleep(2000);
	    signuppop.sendlastname();
	    Thread.sleep(2000);
        signuppop.sendusername();
        Thread.sleep(2000);
        signuppop.selectbirthday();
        Thread.sleep(2000);
	    signuppop.selectbirthmonth();
	    Thread.sleep(2000);
	    signuppop.selectbirthyear();
	    Thread.sleep(2000);
	    signuppop.clickonmale();
		Thread.sleep(2000);
	  //  signuppop.clickonfemale();
	   // signuppop.clickoncustome();
	    //Thread.sleep(2000);
	    signuppop.clickonsignupbutton();	
	
	
	
}
}
