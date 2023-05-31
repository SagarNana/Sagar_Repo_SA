package com.abc.testcase;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.abc.Utility.BrowserUtility;
import com.abc.Utility.WaitUtility;
import com.abc.pages.EmployeePage;
import com.abc.pages.HomePage;
import com.abc.report.Report;

public class EmployeePageTestCase {
 // it can use to precondition 
	@BeforeSuite(alwaysRun=true)
	public void Precondition() throws InterruptedException {
		Report report=new Report();
		report.generateReport();
		BrowserUtility browserUtility=new BrowserUtility();
		browserUtility.LaunchApplication();
		 
		
	}
	
	
	@Test(description="Verify that user able to add to employee page", groups= {"smoke","regression"} )
	public void TC3() throws InterruptedException {
/*	//	HomePage hompage=new HomePage("Admin","admin123");
		//hompage.LoginFuctionality("Admin","admin123");
		//WaitUtility.WaitForPageLoad(hompage.getPimlink());// locator is passs to homepage and then dot got to the pim link 		
		//Thread.sleep(3000);
		//hompage.getPimlink().click();// this locator is crated to hompage and then go to the employee page 
		//Thread.sleep(3000);
*/		
		EmployeePage employee=new EmployeePage("Admin","admin123"); // employepage is will call to constructor employeepage 
		//username and password ki helps se EmployeePage ayenge   
		//WaitUtility.WaitForPageLoad(employee.getAddbutton());
		Thread.sleep(3000);
		employee.getAddbutton().click();
		Thread.sleep(3000);
		//WaitUtility.WaitForPageLoad(employee.getFirstNameTxt());
		employee.AddEmployee("Sagar", "Nana", "Mhaisdhune");
		 
		
		
	}
	

}
 

// steps -> launch the browser andd then go to url then login page and then go to the hompage and then  fine pim link click and then 
//username,password then click add then add to empolyee details and then save 


// there is 3 way to run testcase --1 - is enabled=true and disabled=false 
				//2 -- testing xml se run kr shkte hai method inside krke smoke ke liye and onther xml file create alltest case 
				//3 groups se find kr shkte like that groups={"smoke"} is trh se bhi kr shkte hai -- jis jis ke age smoke write kiya un sabhi test case ko oh run krega 


