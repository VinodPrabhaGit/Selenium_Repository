package Libraries;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class commonMethods {
	public static WebDriver driver = null;
	public String runMode;
	public String propFileName = ".\\src\\propertyFiles\\Properties.properties";
	
	public commonMethods(String browser) throws MalformedURLException, IOException{
		BufferedReader prFile = new BufferedReader(new FileReader(propFileName));
		Properties properties = new Properties();
		properties.load(prFile);		
		runMode = properties.getProperty("testrunmode").toLowerCase();		
		prFile.close();
		if(runMode.equalsIgnoreCase("remote")){
			DesiredCapabilities dc = null;
			if(browser.equalsIgnoreCase("firefox")){
				dc = DesiredCapabilities.firefox();
				dc.setBrowserName("firefox");
				dc.setPlatform(Platform.WIN10);
			}else if(browser.equalsIgnoreCase("chrome")){
				System.setProperty("webdriver.chrome.driver", ".\\src\\WebDrivers\\chromedriver.exe");
				dc = DesiredCapabilities.chrome();
				dc.setBrowserName("chrome");
				dc.setPlatform(Platform.WIN10);				
			}else if(browser.equalsIgnoreCase("IE")){
				System.setProperty("webdriver.iexplore.driver", ".\\src\\WebDrivers\\IEDriverServer.exe");
				dc = DesiredCapabilities.internetExplorer();
				dc.setBrowserName("iexplore");
				dc.setPlatform(Platform.WIN10);
			}
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dc);
		}else if(runMode.equalsIgnoreCase("local")){
			if(browser.equalsIgnoreCase("firefox")){
				driver = new FirefoxDriver();
			}else if(browser.equalsIgnoreCase("chrome")){
				System.setProperty("webdriver.chrome.driver", ".\\src\\WebDrivers\\chromedriver.exe");
				driver = new ChromeDriver();
			}else if(browser.equalsIgnoreCase("IE")){
				System.setProperty("webdriver.iexplore.driver", ".\\src\\WebDrivers\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}			
			
		}else{
//			driver = new FirefoxDriver();
		}
	}
	
	public void openTestApplication() throws IOException{
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20000, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		BufferedReader prFile = new BufferedReader(new FileReader(propFileName));
		Properties properties = new Properties();
		properties.load(prFile);		
		String sUrl = properties.getProperty("appURL");
		prFile.close();
		
		driver.navigate().to(sUrl);
		
	}
}
