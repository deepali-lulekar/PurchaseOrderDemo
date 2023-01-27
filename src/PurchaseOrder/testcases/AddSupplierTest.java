package PurchaseOrder.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import PurchaseOrder.library.LoginConstant;
import PurchaseOrder.library.POProject;
import PurchaseOrder.library.POSupplier;
import utils.XLutils;

@Test
public class AddSupplierTest
{
	 String datafile = "C:\\selenium 2\\PurchaseOrder_DDT\\FilesStore\\SupplierList.xlsx";
     String datasheet = "EmpData";
     POSupplier myProject = new POSupplier();
     @Test
     public void addSupplierTest() throws IOException, InterruptedException
     {
     int rowcount;
     rowcount = XLutils.getRowCount(datafile, datasheet);
     String fname, lname, mail, phone, gst, payt, add, pfname, plname, pphone;
     
     fname = XLutils.getStringCellData(datafile, datasheet, 1, 0);
	 lname = XLutils.getStringCellData(datafile, datasheet, 1, 1); 
	 mail  = XLutils.getStringCellData(datafile, datasheet, 1, 2);
	 phone = XLutils.getStringCellData(datafile, datasheet, 1, 3);
	 gst   = XLutils.getStringCellData(datafile, datasheet, 1, 4);
	 payt  = XLutils.getStringCellData(datafile, datasheet, 1, 5);
	 add   = XLutils.getStringCellData(datafile, datasheet, 1, 6);
	 pfname= XLutils.getStringCellData(datafile, datasheet, 1, 7);
	 plname= XLutils.getStringCellData(datafile, datasheet, 1, 8);
	 pphone= XLutils.getStringCellData(datafile, datasheet, 1, 9);
	 myProject.addProject(fname, lname, mail, phone, gst, payt, add, pfname, plname, pphone);
	 boolean text = myProject.isSuccessMsgDisplyed();
	 Assert.assertTrue(text);
	 System.out.println(text);
	 
     
	
	
	
	
}
}