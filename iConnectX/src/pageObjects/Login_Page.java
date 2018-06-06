package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login_Page {

	private static WebElement element;
	
	public static WebElement Txtbx_LoginUserId(WebDriver driver) {
		
		element = driver.findElement(By.xpath("//form[@id='user_form_login']//following::div[3]//child::input[contains(@class,'custom[email]') and @maxlength='35']"));
		return element;
	}
	
	public static WebElement Txtbx_LoginPassword(WebDriver driver) {
		
		element = driver.findElement(By.id("password"));
		return element;
	}
	
	public static WebElement Btn_LoginSubmit(WebDriver driver) {
		
		element = driver.findElement(By.id("logsubmit"));
		return element;
		
	}
	
}

