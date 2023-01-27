package PurchaseOrder.library;

import java.io.IOException;

import org.testng.annotations.BeforeTest;

import utils.AppUtilis;

public class LoginConstant extends AppUtilis 
{


	String adminuid = "rohit@jetatech.in";
	String adminpwd = "Rohit@123";
	
	public LoginPage lp;
	
	@BeforeTest
	public void adminLogin() throws IOException 
	{
		lp = new LoginPage();
		lp.login(adminuid,adminpwd);
	}
	
	
	
	
	
	
	
	
	
}
