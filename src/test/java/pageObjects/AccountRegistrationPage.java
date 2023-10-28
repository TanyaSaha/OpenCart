package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{

	//Constructor
	public AccountRegistrationPage(WebDriver d) {
	super(d);
	}
	//WebElements
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFirstname;
		
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtLastname;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement chkdPolicy;
	
	@FindBy(xpath="//button[normalize-space()='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath = "//img[@title='Your Store']")
	WebElement pageName;
	
	@FindBy(xpath="//span[normalize-space()='Checkout']")
	WebElement ChkOut;
	
	
	//Actions
	
	public void setFirstName(String fname)
	{
		txtFirstname.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		txtLastname.sendKeys(lname);
	}
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void setPassword(String password)
	{
		txtPassword.sendKeys(password);
	}
	
	public void setPrivatePolicy()
	{
	//	chkdPolicy.click();
	JavascriptExecutor jse = (JavascriptExecutor) d;
	jse.executeScript("arguments[0].click();", chkdPolicy);
	}
	
	public void clickContinue()
	{
//		//btnContinue.click();
		JavascriptExecutor jse = (JavascriptExecutor) d;
		jse.executeScript("arguments[0].click();", btnContinue);

	}
	
	public String getPageName()
	{
		return (pageName.getText());   
		
		}
	
	public WebElement IsChkOutDisplayed()
	{
		return ChkOut;   
		
		}
	
	
	}

