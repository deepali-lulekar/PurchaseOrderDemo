package PurchaseOrder.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import PurchaseOrder.library.LoginPage;
import utils.AppUtilis;
import utils.XLutils;

public class LoginTestWithVaildData
{
		@Test
		public void Login() throws IOException 
		{
	      AppUtilis.launchApp();
	        
	         String datafile = "C:\\selenium 2\\PurchaseOrder_DDT\\FilesStore\\UserLogin.xlsx";
	         String datasheet = "LoginData";
	         
	         int rowcount;
	         rowcount = XLutils.getRowCount(datafile, datasheet);
	         
	         String adminuid,adminpwd;
	         LoginPage lp = new LoginPage();
	         
			 //for (int i= 1; i<=rowcount; i++){ 
			 //System.out.println("--- value for ROW="+i+"  is => "+XLutils.getStringCellData(datafile,datasheet , i, 0));
				 //System.out.println("value of i--" + i);
			
				adminuid = XLutils.getStringCellData(datafile, datasheet, 1, 0);
				adminpwd = XLutils.getStringCellData(datafile, datasheet, 1, 1);
				lp.login(adminuid, adminpwd);
				boolean res = lp.isUserLoginDisplayed();
				Assert.assertTrue(res);
				
	            
			   if(res)
	           {
	        	    XLutils.setCellData(datafile, datasheet, 1, 2, "Pass");
					XLutils.fillGreenColor(datafile, datasheet, 1, 2);	
	        	    System.out.println("Login Test Pass");
	           }else
	           {
	        	    XLutils.setCellData(datafile, datasheet, 1, 2, "Fail");
					XLutils.fillRedColor(datafile, datasheet, 1, 2);
	        	    System.out.println("Login Test Fail");
	           }
			
	           //AppUtilis.closeApp();
			
			
		}

	}
	


	
	
	

