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
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import Libraries.commonMethods;

public class safteyOfData {
	private static WebDriver driver;

	@BeforeClass()
	@Parameters({"browser"})
	public void startTest(String browser) throws IOException{
		commonMethods cm = new commonMethods(browser);
		cm.openTestApplication();
		driver = commonMethods.driver;	
		System.out.println("SafteyofData Test Started..............");
	}
	
	@Test()
	public void checkSafteyContent() throws InterruptedException, IOException{
		System.out.println("SafteyofData Test Running..........");
		String sep = System.lineSeparator();
		
		WebElement safeOfYourData = driver.findElement(By.linkText("Safety of your data"));
	
		
		Thread.sleep(5000);		
		safeOfYourData.click();
		
		List<WebElement> forConsumers = driver.findElements(By.xpath("/html/body/section[2]/div[2]/div/div[1]/div[1]/div/p[*]/span[2]"));	
		List<WebElement> helthProvider = driver.findElements(By.xpath("/html/body/section[2]/div[2]/div/div[1]/div[2]/div/p[*]/span[2]"));	

		
		int i = forConsumers.size();
		int j = helthProvider.size();
		
		FileWriter fw = new FileWriter(".\\src\\TestReports\\SafetyNote.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		
		if(i > 0 ){
			Iterator<WebElement> fcItr = forConsumers.iterator();
			while(fcItr.hasNext()){
				WebElement elm = fcItr.next();
				bw.write(elm.getText()+sep);
			}
		}		
		bw.flush();
		bw.close();
		fw.close();	
		
		FileWriter fw1 = new FileWriter(".\\src\\TestReports\\HealthProvider.txt");
		BufferedWriter bw1 = new BufferedWriter(fw1);
		
		if(j>0){
			Iterator<WebElement> hpItr = helthProvider.iterator();
			while(hpItr.hasNext()){
				WebElement el = hpItr.next();
				bw1.write(el.getText()+sep);		
			}
		}
		bw1.flush();
		bw1.close();
		fw1.close();
		

	}
	
	
	@AfterClass()
	public void endTest(){
		driver.close();
		System.out.println("SafteyofData Test Ended..........");
	}
	
	
}
