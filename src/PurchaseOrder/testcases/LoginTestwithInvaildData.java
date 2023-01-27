package PurchaseOrder.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import PurchaseOrder.library.LoginPage;
import utils.AppUtilis;
import utils.XLutils;

public class LoginTestwithInvaildData {
	
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
        for (int i= 1; i<=rowcount; i++){ 
        	adminuid = XLutils.getStringCellData(datafile, datasheet, 2, 0);
			adminpwd = XLutils.getStringCellData(datafile, datasheet, 2, 1);
			lp.login(adminuid, adminpwd);	
        	boolean res = lp.isErrorMsgDisplayed();
        	Assert.assertFalse(res);
        	
		if(res)
		{
			 XLutils.setCellData(datafile, datasheet, 2, 2, "Pass");
			 XLutils.fillGreenColor(datafile, datasheet, 2, 2);	
			 System.out.println("System displayed appropriate error message, Test Pass");
		}else
		{
			 XLutils.setCellData(datafile, datasheet, 2, 2, "Fail");
			 XLutils.fillRedColor(datafile, datasheet, 2, 2);
			 System.out.println("System not displayed appropriate error message, Test Fail");
		}
		//AppUtilis.closeApp();		

		
		
		
		
		
	}

}
}
