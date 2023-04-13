package Page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	
	
	@FindBy (xpath = "//input[@id='email']")
	private WebElement username ;
	
	@FindBy (xpath = "//input[@id='pass']")
	private WebElement  pass  ;
	
	@FindBy (xpath = "//button[text()='Log in']")
	private WebElement loginbutton ;
	
	@FindBy (xpath = "(//span[@class='x4k7w5x x1h91t0o x1h9r5lt xv2umb2 x1beo9mf xaigb6o x12ejxvf x3igimt xarpa2k xedcshv x1lytzrv x1t2pt76 x7ja8zs x1qrby5j x1jfb8zj'])[1]")
	private WebElement account ;
	
	@FindBy (xpath = "//span[text()='Log Out']")
	private WebElement logoutbutton ;
	
	@FindBy (xpath = "//a[text() = 'Create new account']")
	private WebElement createnwacc ;
	
	@FindBy (xpath = "//a[text()='Forgotten password?']")
	private WebElement forgetpass ;
	
	
	
	WebDriver driver ;
	
	public Loginpage(WebDriver driver)
	{
	   PageFactory.initElements(driver, this);
	   this.driver=driver;
	}
	
	public void sendusername()
	{
		username.sendKeys("Vishalchaudhari133@gmail.com");
	}
	
	public void sendpass()
	{
		pass.sendKeys("VISH133@");
	}
	
	public void clickonloginbutton()
	{
		loginbutton.click();
	}
	
	public void clickonaccount()
	{
		Actions act =new Actions(driver);
		
		act.moveToElement(account).click().build().perform();
		
	}
	public void clickonlogoutbutton()
	{
		Actions act =new Actions(driver);
		
		act.moveToElement(logoutbutton).click().build().perform();
		
	}
	
	
	public void clickoncreatenwacc()
	{
		createnwacc.click();
	}
	
	public void clickonforgetpass()
	{
		forgetpass.click();
	}

	
	
	
	
	
	
}
