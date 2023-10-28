package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Account;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {
	
	
	@Test
	public void testLogin()
	{
		try
		{
		logger.info("****   Starting TC_002 Login Test  ****");
		HomePage hp = new HomePage(d);
		hp.clickLogin();
		logger.info("*** Clicked on Login Link ****");
		
		LoginPage lp = new LoginPage(d);
		
		logger.info("*** Login Info ****");
		lp.setEmail(rb.getString("email"));  // Actual email, getting from config.properties
		lp.setPassword(rb.getString("password")); // Actual pwd, getting from config.properties
		lp.clickLogin();
		
		Account act = new Account(d);
		boolean targetPage = act.isAccountPageExists();
		Assert.assertEquals(targetPage, true, "Invalid Login Data");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("*****   Completed--TC_002_LoginTest  *****");
	}

}
