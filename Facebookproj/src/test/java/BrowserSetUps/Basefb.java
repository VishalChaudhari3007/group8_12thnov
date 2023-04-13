package BrowserSetUps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Basefb {
	
	public static WebDriver openChromeBrowser()
	{
		System.setProperty("webdriver.chrome.driver","src\\test\\resources\\Browserfiles\\chromedriver.exe");
		
		ChromeOptions ops =new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops);
	    return driver;
	}
	
	public static WebDriver openFirefoxBrowser()
	{
		System.setProperty("webdriver.gecko.driver","src\\test\\resources\\Browserfiles\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		return driver;
	}
	
	public static WebDriver openEdgeBrowser()
	{
		System.setProperty("webdriver.edge.driver","src\\test\\resources\\Browserfiles\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
	    return driver;
	}
	
	
	
	
	
	
	
	

}
