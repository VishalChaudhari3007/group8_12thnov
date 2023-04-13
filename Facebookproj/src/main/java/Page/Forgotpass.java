package Page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Forgotpass {
	

	@FindBy (xpath = "//div[@class='_6ltj']")
	private WebElement forgetpass ;
	
	@FindBy (xpath = "//input[@type='text']")
	private WebElement emailandmob;
	
	@FindBy (xpath = "//button[text()='Search']")
	private WebElement searchbutton  ;
	
	@FindBy (xpath = "//a[text()='Cancel']")
	private WebElement cancelbutton ;
	
	@FindBy (xpath = "//input[@aria-label='Email address or mobile number']")
	private WebElement usertext ;
	
	@FindBy (xpath = "//div[text()='Please enter your email address or mobile number to search for your account.']")
	private WebElement pagetext ;
	
	WebDriver driver ;
	
	
	public Forgotpass(WebDriver driver)
	{
	   PageFactory.initElements(driver, this);
	   this.driver = driver ;
	   
	}
	
	public void clickonforgetpass()
	{
		forgetpass.click();
	}
	
	public void sendemailandmob()
	{
		emailandmob.sendKeys("Vishalchaudhari133@gmail.com");
	}
	
	public void clickonsearchbutton()
	{
		searchbutton.click();
	}
	
	public void clickoncancelbutton()
	{
		cancelbutton.click();
	}
	
	public String getusernametext()
	{
		String text1 = usertext.getAttribute("aria-label");
		System.out.println(text1);
		return text1 ;
	}
	
	public String getpagetext()
	{
		String text2 = pagetext.getText();
		System.out.println(text2);
		return text2;
	}
	

	
	
	
	
	
	
	
	
	

}
