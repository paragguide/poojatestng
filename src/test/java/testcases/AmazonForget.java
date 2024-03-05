package testcases;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import core.Hook;

public class AmazonForget extends Hook
{
  @Test
  public void forget() throws Exception 
  {
	  signin.click();
	  help.click();
	  forgetlink.click();
	  test.log(LogStatus.PASS, "forhget page called");
	  forgettxtbox.sendKeys("paragguide@yahoo.co.in");
	  
	  utility.ScreenShot.takeScreenShot("AmazonForget");
	  forgetbtn.click();
  }
}
