package testCases;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Libraries.commonMethods;

public class searchDoctor {

	public static WebDriver driver;
	
	@DataProvider(name = "searchcriteria")
	public static Object[][] searchlist(){
		
		return new Object[][] {{"Bangalore","Dentist"},{"Chennai","Ayurveda"},{"Delhi","Dermatologist"},{"Cochin","Homoeopath"}};
		
	}
	
	@BeforeClass()
	@Parameters({"browser"})
	public void startTest(String browser) throws IOException{
		commonMethods comMethod = new commonMethods(browser);
		driver = commonMethods.driver;
		
		comMethod.openTestApplication();
		System.out.println("SearchDoctor Test Started.......");
	}
	

	
	
	@Test(dataProvider = "searchcriteria")
	//@Parameters({"locName","catType"})
	public void listoutDoctors(String locName, String catType){
		System.out.println("SearchDoctor Test Running.......");
		try{
			String sep = System.lineSeparator();

			WebElement docLocation = driver.findElement(By.xpath("//*[@id='c-omni-container']/div/div[1]/div/input"));
			WebElement categoryList = driver.findElement(By.xpath("//*[@id='c-omni-container']/div/div[2]/div/input"));
		
			docLocation.clear();
			docLocation.sendKeys(locName);
			categoryList.clear();
			categoryList.sendKeys(catType);
			WebDriverWait wait = new WebDriverWait(driver,5);
			
			WebElement docList = driver.findElement(By.xpath("//*[@id='c-omni-container']/div/div[2]/div[2]/div[1]/div[1]/span[1]/div"));
			wait.until(ExpectedConditions.elementToBeSelected(docList));
			
			docList.click();
			Thread.sleep(5000);
			
			List<WebElement> clinicList = driver.findElements(By.xpath("//*[@id='container']/div[3]/div/div[2]/div[1]/div[2]/div[*]/div/div[1]/div[1]/div/div[2]/div[1]/a[1]/h2"));
			
			Iterator<WebElement> clinicItr = clinicList.iterator();
			


			 String clinicount = ("Total Number of "+ catType + " at " + locName + " = " + clinicList.size());
			
			 System.out.println(clinicount);
			 
			 FileWriter fw = new FileWriter(".\\src\\TestReports\\" + locName + "_" + catType + ".txt");
			 
			 BufferedWriter bf = new BufferedWriter(fw);
	
			while(clinicItr.hasNext()){
				WebElement cl = clinicItr.next();				
				 bf.write(cl.getText()+sep);				
			}
			 
			 bf.write(new String("-----------"+sep));
			 
			 bf.write(clinicount+sep);
			 bf.flush();
			 fw.close();
			 bf.close();
			 clinicList.clear();
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	@AfterClass()
	public void endTest(){
		driver.close();
		//Runtime rt = null;
		//rt.gc();
		System.out.println("SearchDoctor Test Ended.......");
	}
	
	
	
}
