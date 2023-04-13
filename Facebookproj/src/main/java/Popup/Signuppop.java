package Popup;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Signuppop {
	
	@FindBy (xpath = "//a[text() = 'Create new account']")
	private WebElement createnwacc ;
	
	@FindBy (xpath = "(//input[@type='text'])[2]")
	private WebElement firstname ;
	
	@FindBy (xpath = "(//input[@type='text'])[3]")
	private WebElement lastname  ;
	
	@FindBy (xpath = "(//input[@type='text'])[4]")
	private WebElement username ;
	
	@FindBy (xpath = "//input[@type='password']")
	private WebElement pass ;
	
	@FindBy (xpath = "//select[@name='birthday_day']")
	private WebElement birthday ;
	
	@FindBy (xpath = "//select[@id='month']")
	private WebElement birthmonth ;

	@FindBy (xpath = "//select[@aria-label='Year']")
	private WebElement birthyear ;
	
	@FindBy (xpath = "(//input[@type='radio'])[1]")
	private WebElement femaleradiobutton ;
	
	@FindBy (xpath = "(//input[@type='radio'])[2]")
	private WebElement maleradiobutton ;
	
	@FindBy (xpath = "(//input[@type='radio'])[3]")
	private WebElement customradiobutton ;
	
	@FindBy (xpath = "(//button[text()='Sign Up'])[1]")
	private WebElement signupbutton ;
	
	public Signuppop(WebDriver driver)
	{
	   PageFactory.initElements(driver, this);
	}
	

	public void clickoncreatenwacc()
	{
		createnwacc.click();
	}
	
	public void  sendfirstname()
	{
		
		firstname.sendKeys("Vishal");
	}
	
	public void sendlastname()
	{
	
		lastname.sendKeys("chaudhari");
	}
	
	public void sendusername()
	{
	 
	   username.sendKeys("Vishalchaudhari133@gmail.com");
	}
	
	
	public void selectbirthday ()
	{
		Select c= new Select(birthday);
		c.selectByValue("27");
		birthday.click();
	}
	
	
	public void selectbirthmonth()
	{
		Select s = new Select(birthmonth);
		 s.selectByVisibleText("Jun");
		 birthmonth.click();
	}
	
	
	public void selectbirthyear()
	{
		Select v = new Select(birthyear);
		v.selectByValue("1999");
		birthyear.click();
	}
	
	public void clickonfemale()
	{
		femaleradiobutton.click();
	}
	
	public void clickonmale()
	{
		maleradiobutton.click();
	}
	
	public void clickoncustome()
	{
		customradiobutton.click();
	}
	
	public void clickonsignupbutton()
	{
		signupbutton.click();
	}
	
	

	
	
	
}
