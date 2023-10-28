package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Account extends BasePage {

	public Account(WebDriver d) {
	super(d);
	}
	
	@FindBy(xpath="//h1[normalize-space()='Account']")
	WebElement AcctHeading;

	public boolean isAccountPageExists()
	{
		try {
		return (AcctHeading.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}
}
