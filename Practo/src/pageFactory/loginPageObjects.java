package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPageObjects{
	
	public WebDriver dr;
	
	public loginPageObjects(WebDriver driver){		
		dr = driver;

	}
	
	public WebElement btn_signIn = dr.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/div[3]/span/a"));
	public WebElement txt_userid = dr.findElement(By.id("username"));
	public WebElement txt_password = dr.findElement(By.id("password"));
	public WebElement btn_login = dr.findElement(By.id("Login"));
	
	
	public void signIn_Click(){		
		btn_signIn.click();
	}
	
	public void enter_userId(String usr_id){		
		txt_userid.sendKeys(usr_id);
	}

	public void enter_password(String pwd){		
		txt_password.sendKeys(pwd);
	}
	
	public void Login_Click(){		
		btn_login.click();
	}
	
	
}
