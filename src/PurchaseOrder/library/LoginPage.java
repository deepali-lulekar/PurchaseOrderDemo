package PurchaseOrder.library;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.AppUtilis;
import utils.XLutils;

public class LoginPage extends AppUtilis
{

	public void login(String adminuid,String adminpwd) throws IOException 
	{
		
	    driver.findElement(By.id("login-form_email")).sendKeys(adminuid);
	    driver.findElement(By.id("login-form_password")).sendKeys(adminpwd);
        driver.findElement(By.xpath("//*[@type = 'submit']")).click();
		}
	
	
	
	
	 public boolean isUserLoginDisplayed() 
       {
    	  driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Home'])[1]/preceding::*[name()='svg'][3]")).click();
 		 String res = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Jetatech'])[1]/following::div[12]")).getText();
    	    
    	  if(res.toLowerCase().contains("header"))
    	{
    		return true;
    	}else
    	{
    		return false;
    	}
    }
      public boolean isErrorMsgDisplayed()
    	{
			
			  String res = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Email not found.'])[1]/following::*[name()='svg'][1]")).getText();
			  
			  if(res.toLowerCase().contains("wrong"))
    	     {
    		    return true;
    	     }else
    	     {
    		    return false;
    	     }
    	

}

}
	

