package PurchaseOrder.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import PurchaseOrder.library.LoginConstant;
import PurchaseOrder.library.POProject;
import utils.XLutils;

public class AddProjectTest
{

	 String datafile = "C:\\selenium 2\\PurchaseOrder_DDT\\FilesStore\\NewProjectNames.xlsx";
     String datasheet = "POProject";
     POProject myProject = new POProject();
     @Test
     public void addProjectTest() throws IOException, InterruptedException
     {
     int rowcount;
     rowcount = XLutils.getRowCount(datafile, datasheet);
     String Pname,Cname,Pono;
     
     //for (int i= 1; i<rowcount; i++)
     { 
    	 
             Pname = XLutils.getStringCellData(datafile, datasheet, 1, 0);
			 Cname = XLutils.getStringCellData(datafile, datasheet, 1, 1); 
			 Pono = XLutils.getStringCellData(datafile, datasheet, 1, 2);
			 myProject.addProject(Pname, Cname, Pono);
			 boolean succ = myProject.isSuccessMsgDisplyed();
			 Assert.assertTrue(succ);
     }
	
}
	
}
