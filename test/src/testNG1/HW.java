package testNG1;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HW {
	 public String baseUrl = "https://devwcs.ballarddesigns.com/";
	    String driverPath = "C:\\Users\\Hp\\Downloads\\chromedriver_win32\\chromedriver.exe";
	    public ChromeDriver driver ; 
  @Test
public void HomeWork() {
	  System.out.println("launching chrome browser"); 
      System.setProperty("webdriver.chrome.driver", driverPath);
      driver = new ChromeDriver();
   
       driver.get(baseUrl);
      driver.findElement(By.xpath("//*[@id=\"details-button\"]")).click();   
      driver.findElement(By.xpath("//*[@id=\"proceed-link\"]")).click();  
    boolean Result = driver.findElement(By.xpath("//*[@id=\"logo1\"]/a")).isDisplayed();
    
      if (!Result)
      {
           System.out.println("Image not displayed.");
      }
      else
      {
          System.out.println("Image displayed.");
      }
      
  
//go to login page

 driver.findElement(By.xpath("//*[@id=\"loginMyAccount\"]/span")).click();    
  
 String expectedText = "Welcome back! To access your account, please enter your email address and password and click Sign In.";
 
String actualText = driver.findElement(By.cssSelector("#BDLoginMessageNormal p")).getText();


  Assert.assertEquals(actualText, expectedText,"Actual:"  +actualText );
      
  // login to valid account
    
       String Email="mmohammad@itgsoftware.com";
  String Pass="marah421994";
  driver.findElement(By.cssSelector("#logonId")).sendKeys(Email);
  driver.findElement(By.cssSelector("#logonPassword")).sendKeys(Pass);
  
  
  driver.findElement(By.xpath("//*[@id=\"logonButton\"]")).click(); 
//  driver.findElement(By.cssSelector(".upper-hint-label logonPassword-class-label password")).sendKeys(Email);
     
  // Check account label
 String MyAccount = driver.findElement(By.xpath("//*[@id=\"myAccount\"]/a/span")).getText();
 String expectedLink = "My Account";
 Assert.assertEquals(MyAccount, expectedLink,"Actual:"  +MyAccount );
 System.out.println("My Account Link");
      
  // Check First name
 

String Welcome =   driver.findElement(By.cssSelector("#welcome")).getText();
Welcome =Welcome.split(",")[1];
Welcome= Welcome.replace("!", "");
Welcome= Welcome.replace(" ", "");
String AccountName= "tesr";

Assert.assertEquals(Welcome, AccountName,"Actual:"  +Welcome );
System.out.println("correct User name");


  }
}
