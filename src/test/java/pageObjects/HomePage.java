package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
 
	// Constructor
	public HomePage(WebDriver d) {
	super(d);
	}	
	
	//WebElements
		
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement lnkMyAccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement lnkRegister;
	
	//@FindBy(xpath="//a[@class='btn btn-link navbar-btn']")
	//WebElement lnkLogin;
	
	@FindBy(css=".btn.btn-link.navbar-btn")	 
	WebElement lnkLogin;

	//Action Methods
	
	public void clickMyAccount()
	{
		lnkMyAccount.click();
	}
	
	public void clickRegister()
	{
		lnkRegister.click();
	}
	
	public void clickLogin()
	{
		lnkLogin.click();
	}
	
		
	}


