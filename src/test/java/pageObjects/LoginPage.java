package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class LoginPage extends BasePage {

	public LoginPage(WebDriver d) {
	super(d);
	}	
		//WebElements
		
		@FindBy(how=How.XPATH, using ="//input[@id='input-email']")
		WebElement txtEmail;
		
		@FindBy(xpath="//input[@id='input-password']")
		WebElement txtPassword;
		
		@FindBy(xpath="//button[@class='btn btn-primary btn-lg hidden-xs']")
		WebElement lnkLogin;
		
		//Action
		
		public void setEmail(String email)
		{
			txtEmail.sendKeys(email);
		}
		
		public void setPassword(String password)
		{
			txtEmail.sendKeys(password);
		}
		
		public void clickLogin( )
		{
			lnkLogin.sendKeys();
		}
		

	

}
