package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Libraries.commonMethods;
import pageFactory.loginPageObjects;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class loginToPracto{

	private static WebDriver driver;

	@BeforeTest()
	@Parameters({"browser"})
	private void startTest(String browser) throws IOException{
		commonMethods comMethod = new commonMethods(browser);		
		comMethod.openTestApplication();
		driver = commonMethods.driver;
		
	}
	
	
	
	@Test()
	public void loginToApp() throws IOException{
		try{	
//			loginPageObjects logPage = new loginPageObjects(driver);
//			Actions acts = new Actions(driver);
			
			System.out.println("login started.............");
			
			
			BufferedReader prFile = new BufferedReader(new FileReader(".\\src\\propertyFiles\\Properties.properties"));
			Properties properties = new Properties();
			properties.load(prFile);
			
/*			logPage.signIn_Click();
			Thread.sleep(5000);*/

			
/*			String usrid = properties.getProperty("userid");
			String pswrd = properties.getProperty("password");
			
			System.out.println(usrid);
			System.out.println(pswrd);*/
			
/*//			WebElement usrInput = driver.findElement(By.xpath("//*[@id='username']//preceding::div[contains(@class,'padding-bottom-8')]"));
			
			WebElement usrInput = driver.findElement(By.xpath("//*[@id='username']//ancestor::form[contains(@id,'login_form')]"));
			
			
			
			//WebElement pwdInput = driver.findElement(By.xpath("//*[@id='password' AND]"));
			
			*/
			
			System.out.println("login page found.............");
			
							
/*			logPage.enter_userId(usrid);
			logPage.enter_password(pswrd);			
			logPage.Login_Click();*/
			
			prFile.close();
			System.out.println("login success");
		}catch(Exception e){
			e.printStackTrace();
		}		
	}

	
	@AfterTest()
	public void closeDrivers(){
		driver.close();
		try{
			System.gc();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
}
