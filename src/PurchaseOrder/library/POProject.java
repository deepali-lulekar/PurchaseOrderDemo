package PurchaseOrder.library;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import PurchaseOrder.testcases.AddProjectTest;
import utils.AppUtilis;

public class POProject extends AppUtilis 
{
   
	
	public void addProject(String Pname,String Cname,String Pono)
	{
		driver.get("http://65.1.124.191:49183/app/project");
		driver.findElement(By.xpath("//*[@type = 'button']")).click();
		driver.findElement(By.id("projectName")).sendKeys(Pname);
		driver.findElement(By.id("customerCompanyName")).sendKeys(Cname);
	  	driver.findElement(By.id("projectId")).sendKeys(Pono);
	  	driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div/div[2]/form/div[3]/button[2]/span")).click();
	}
	public boolean isSuccessMsgDisplyed() throws InterruptedException 
	{ 
	  Thread.sleep(5000);
	  String succ = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div/div/p")).getText();
	   
	  if(succ.toLowerCase().contains("project"))
	{
		return true;
	}else
	{
		return false;
	}
	
}
}