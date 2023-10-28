package testCases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {
	
	@Test
	public void test_account_Registration() throws InterruptedException
	{
		
		logger.info("***  Starting TC_001_AccountRegistrationTest ***");
		HomePage hp=new HomePage(d);
		hp.clickMyAccount();
		logger.info("Clicked on My account link");
		
		hp.clickRegister();
		logger.info("Clicked on register link");
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(d);
		
		logger.info("Providing customer data");
		regpage.setFirstName(randomeString().toUpperCase());
		
		regpage.setLastName(randomeString().toUpperCase());
		
		regpage.setEmail(randomeString()+"@gmail.com");// randomly generated the email
		
				
		String password=randomAlphaNumeric();
		regpage.setPassword(password);
		regpage.setPassword(password);
		
		regpage.setPrivatePolicy();
		
		regpage.clickContinue();
		
		String confmsg=regpage.getPageName();
		
		//Assert.assertEquals(confmsg, "Your Store");
		
		Assert.assertEquals(confmsg, "");
		
		//Assert.assertTrue(IsChkOutDisplayed);
		logger.info("***  Finished TC_001_AccountRegistrationTest ***");
	
	}


}
