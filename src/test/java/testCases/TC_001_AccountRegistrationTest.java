package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass{
	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration()
	{
		logger.info("****TC_001_AccountRegistrationTest****");
		try
		{
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			logger.info("****Clicked on My account link****");
			hp.clickRegister();
			logger.info("****Clicked on Register Link****");
			
			AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
			
			logger.info("****Providing Customer details****");
			regpage.setFirstName(randomeString().toUpperCase());
			regpage.setLastName(randomeString().toUpperCase());
			regpage.setEmail(randomeString()+"@gmail.com");// randomly generated the email
			regpage.setTelephone(randomeNumber());
			
			String password=randomAlphaNumeric();
			
			regpage.setPassword(password);
			regpage.setConfirmPassword(password);
			
			regpage.setPrivacyPolicy();
			regpage.clickContinue();
			
			logger.info("****Verifying Confirmation message****");
			String confmsg=regpage.getConfirmationMsg();
			Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		}
		catch(Exception e)
		{
			logger.error("Test Case Failed....");
			logger.debug("Debug Logs...");
			Assert.fail();
			
		}
		
		
		logger.info("****Finished TC_001_AccountRegistrationTest****");
	}
	
	
	
	
}








