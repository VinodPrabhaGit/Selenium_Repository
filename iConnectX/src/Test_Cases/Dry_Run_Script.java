package Test_Cases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Dry_Run_Script{

	public static void main(String args[]) { 
		
		WebDriver dr = new FirefoxDriver();
		dr.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		dr.get("https://www.practo.com/");
		

		WebElement location = dr.findElement(By.xpath("//*[@id='c-omni-container']/div/div[1]/div/input"));
		WebElement doctor = dr.findElement(By.xpath("//*[@id='c-omni-container']/div/div[2]/div[1]/input"));
		
		
		
		
		location.sendKeys("Bangalore");
		doctor.sendKeys("Dental Surgeon");
		
		WebElement doctorlist = dr.findElement(By.xpath("//*[@id='c-omni-container']/div/div[2]/div[2]/div[2]/div[2]/span[1]/div"));
		doctorlist.click();
		
		Actions act = new Actions(dr);		
		act.moveToElement(doctorlist);

		Select drsel = new Select(doctorlist);
		drsel.selectByIndex(0);
		
		
	
	}
}






//#######################################################
//
//
//public static void main(String args[]) throws SQLException, NullPointerException {
//	Connection con = null;
//	
//	Properties properties = new Properties();
//	properties.setProperty("user", "root");
//	properties.setProperty("password", "mysql");
//	properties.setProperty("useSSL", "false");
//	properties.setProperty("autoReconnect", "true");
//	
//try{
//	
//	Class.forName ("com.mysql.cj.jdbc.Driver");
//	con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/my_schema", properties);
//	
//	PreparedStatement  smt = con.prepareStatement("insert into my_table values(?,?,?)");
//
//	smt.setInt(1, 7);
//	smt.setString(2, "vinod sevent");
//	smt.setInt(3, 48);
//	
//	int i = smt.executeUpdate();
//	System.out.println(i);
//	
//	
//	
//}catch(Exception e){
//	e.printStackTrace();
//}finally{
//	con.close();
//	System.out.println("Connection closed");
//}
//	
//	//Endof Main method		
//	} 


//#######################################################
	


			
//public static void main(String[] args) {  
//String host="mail.javatpoint.com";  
//final String user="sonoojaiswal@javatpoint.com";//change accordingly  
//final String password="xxxxx";//change accordingly   
//String to="sonoojaiswal1987@gmail.com";//change accordingly  
//
////Get the session object  
//Properties props = new Properties();  
//props.put("mail.smtp.host",host);  
//props.put("mail.smtp.auth", "true");  
//
//Session session = Session.getDefaultInstance (props);
//	new javax.mail.Authenticator() {  
//	protected PasswordAuthentication getPasswordAuthentication() {  
//		return new PasswordAuthentication(user,password);  
//	}  
//});  
//
////Compose the message  
//try {  
//	MimeMessage message = new MimeMessage(session);  
//	message.setFrom(new InternetAddress(user));  
//	message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
//	message.setSubject("javatpoint");  
//	message.setText("This is simple program of sending email using JavaMail API");  
//
//	//send the message  
//	Transport.send(message);  
//
//	System.out.println("message sent successfully...");  
//
//} catch (MessagingException e) {e.printStackTrace();}  
//}  
