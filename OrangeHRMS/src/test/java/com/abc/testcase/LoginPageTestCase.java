package com.abc.testcase;
import java.sql.Driver;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.abc.Utility.BrowserUtility;
import com.abc.pages.LoginPage;
import com.abc.report.Report;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class LoginPageTestCase {
	
	// muze ek browser chiye to maine beforeclass se code move kiya before suit me kuyki ager is me mulitiple class ke liye mulitple browser create honge 
	//so do not launch multiple browser so remove code BrowserUtility 
	@BeforeClass
	// only call to particular class
	public void precondition() throws InterruptedException {
		Report report=new Report(); // create object and then call generatemethod
		report.generateReport();
	/*	BrowserUtility browserutility=new BrowserUtility(); // we have to launch the applicaion browserutility kyuki golabal driver hai islye nhi to Nullpointerexception show krega
		browserutility.LaunchApplication();
		*/
		
	}
//testcase 1	
	@Test(description="Verify that user is able login with valid credential",priority=1,groups= {"smoke"})
	public void TC1() {
		// createtest case // we create extenttest object
		ExtentTest extenTestObj=Report.createTestCase("Verify that user is able login with valid credential");
		//report ka return type hai Extentreport
		
		LoginPage loginpage=new LoginPage("Admin","admin123"); // we create object Loginpage  //default cconstructor ko call hone ke bad username and passwors input in this line 
	//	loginpage.LoginFuctionality("Admin","admin123");
		
		//To check the status pass or fail so use if elsse statement 
		if(BrowserUtility.driver.getCurrentUrl().contains("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index")) { //contains("dashboard")) ki jgh hum getcurrentURl me link se bhi kr shkte hai 
			extenTestObj.log(Status.PASS,"user is able to login " ); // we use to extenTestObj step method log and check the status pass or fail and then attach to screenshot in report method 
	}
	else {
			extenTestObj.log(Status.FAIL, "user is unable to login");	
	}
		Report.report.flush();
}
	  
	  
	//validation
//Testcase 2
	
	@Test(description="Verify that user is unable login with invalid credential",priority=0,groups= {"regression"})
	public void TC2 ()throws InterruptedException {
		// createtest case -- there is one class is report class 
		ExtentTest extenTestObj=com.abc.report.Report.createTestCase("Verify that user is unable login with invalid credential");
		LoginPage loginpage=new LoginPage("Admin","admin1"); //default cconstructor ko call hone ke bad username and passwors input in this line 
	 	//loginpage.LoginFuctionality("Admin1", "admin1");
	 	
	 	if(!BrowserUtility.driver.getCurrentUrl().contains("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index")) { //contains("dashboard")) ki jgh hum getcurrentURl me link se bhi kr shkte hai 		
	 		extenTestObj.log(Status.PASS,"user is unable to login " );
	 	}
		else {
			extenTestObj.log(Status.FAIL, "user is able to login");	
		}		
		Report.report.flush();
		Thread.sleep(5000);
	 	//validation
		
	}	

}
// humne test case ko 3 part me devided kiya hai 
//mtlub 1->launchapplication us humne utility pakage me likha hai aur usme browserlaunch ka code lika 
	// 2-> each and every located we have crated one get method and this page ki funcinaltiy method lika 
	//3--> validation - it means only test case part and validation done test case only 
		
//validation ke bad =what will do --> compare to expected result and acutul result and 	// then create report ,test case pass or fail 

		//launch the apllication
		//enter the username
		//enter the password
		//click on login 
		//validation
		
