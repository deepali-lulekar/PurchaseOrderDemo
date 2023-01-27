package PurchaseOrder.library;

import org.openqa.selenium.By;

import utils.AppUtilis;
import utils.XLutils;

public class POSupplier extends AppUtilis
{

	public void addProject(String fname,String lname,String mail,String phone,String gst,String payt,String add,String pfname,String plname,String pphone) 
	{
		driver.get("http://65.1.124.191:49183/app/supplier-list");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/section/section/div/main/div/div[1]/div/div/span/button/span[2]")).click();

	    driver.findElement(By.id("firstName")).sendKeys(fname);
        driver.findElement(By.id("lastName")).sendKeys(lname);
		driver.findElement(By.id("email")).sendKeys(mail);
		driver.findElement(By.id("phone")).sendKeys(phone);
		driver.findElement(By.id("gst")).sendKeys(gst);
		driver.findElement(By.id("paymentTerms")).sendKeys(payt);
		driver.findElement(By.id("address")).sendKeys(add);
		driver.findElement(By.id("pocFirstName")).sendKeys(pfname);
		driver.findElement(By.id("pocLastName")).sendKeys(plname);
		driver.findElement(By.id("pocPhoneNo")).sendKeys(pphone);
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div/div[2]/form/div[7]/button[2]/span")).click();
	}
	
	public boolean isSuccessMsgDisplyed() throws InterruptedException 
	{
		  Thread.sleep(5000);
		  String text = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div/div/p")).getText();
		   
		 if(text.toLowerCase().contains("suppliers"))
		{
			return true;
		}else
		{
			return false;
		}
	}	
	
	
}
