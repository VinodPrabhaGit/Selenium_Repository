package App_Generic_Modules;

import org.openqa.selenium.WebDriver;
import org.apache.log4j.PropertyConfigurator;

import System_Utilities.Logs;
import pageObjects.Login_Page;
import System_Utilities.Constant_Values;

public class SingIn_Action {

	public static void Login_To_App(WebDriver driver, String UserId, String PassWrd) throws Exception {
		PropertyConfigurator.configure(Constant_Values.Project_CurDir + "\\bin\\System_Utilities\\Log4j.properties");
		try {
			Login_Page.Txtbx_LoginUserId(driver).sendKeys(UserId);
			Logs.Info("Login Page User Id Entered - "+UserId);
			Login_Page.Txtbx_LoginPassword(driver).sendKeys(PassWrd);
			Logs.Info("Login Page Password Entered - "+PassWrd);
			Login_Page.Btn_LoginSubmit(driver).click();	
			Logs.Info("Login Page Submit Button Clicked");
		}catch(Exception e) {
			throw(e);
		}
		
	}
	
}
