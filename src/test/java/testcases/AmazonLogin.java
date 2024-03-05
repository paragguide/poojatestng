package testcases;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import core.Hook;

import org.testng.annotations.DataProvider;

public class AmazonLogin extends Hook
{
	
 public static boolean login = false;
 
  @Test(dataProvider = "logindata")
  public void login(String user, String passwd) throws Exception 
  {
	  signin.click();
	  uid.clear();	
		uid.sendKeys(user);
		ctnbtn.click();
		   try {
	   
	   test.log(LogStatus.INFO, err1.getText() );
	driver.navigate().to("https://www.amazon.in");
	//signin.click();
	utility.ScreenShot.takeScreenShot("invaliduid");
		   }
		   catch(Exception e)
		   {
			   // uid is valid..
			   pwd.clear();
			   pwd.sendKeys(passwd);
			   submit.click();
			      try {
		    
		    test.log(LogStatus.INFO, err2.getText() );
	utility.ScreenShot.takeScreenShot("invalidpwd");
		driver.navigate().to("https://www.amazon.in");
		//signin.click();
			      }
			      catch(Exception ee)
			      {
			    	  // pwd is correct
			    	  
			    	  test.log(LogStatus.PASS, "loged in sucsess");
			    	  login = true;
			    	utility.ScreenShot.takeScreenShot("logedinsucsess");
			      }
	
  }  
		   }

  @DataProvider
  public Object[][] logindata() throws Exception 
  {
    return utility.WBConnection.readWBData("AmazonLogin.xlsx", "Sheet1");
  }
}
