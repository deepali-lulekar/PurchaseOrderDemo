package PurchaseOrder.testcases;

import PurchaseOrder.library.LoginPage;
import utils.AppUtilis;

public class UserLoginTest {

	public static void main(String[] args) 
	{

        AppUtilis.launchApp("http://65.1.124.191:49183/auth/login-2");
        
        LoginPage lp = new LoginPage();
        lp.login("yash@jetatech.in", "yash646");
        boolean res = lp.isUserLoginDisplayed();
        if(res)
        {
        	System.out.println("Login Test Pass");
        }else
        {
        	System.out.println("Login Test Fail");
        }
		
        AppUtilis.closeApp();
		
		
	}

}
