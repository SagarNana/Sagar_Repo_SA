package com.abc.report;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.abc.Utility.BrowserUtility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Report{
	
	 public static ExtentReports report; // create test ke liye ExtentReports ka object hoga so ,they are 2 way so first it can create object is loacal and use line number 13
	
	 //otherwise it can create method 
	public void generateReport() {
		
		report = new ExtentReports(); // we create a object to first time ExtentRporter // local object 
		ExtentSparkReporter spark = new ExtentSparkReporter("./Result/result.html");
		// this is double qutes he selected to the path
		// we create ExtentSparkReporter object and then we should have select the path
		// html to which location to store the piv
	
		spark.config().setTheme(Theme.DARK); // to change the html page theme colur whit to black
		spark.config().setDocumentTitle("OrangeHRMS\\Sagar"); // to change the title
		spark.config().setReportName("HDFC"); // we can use to add to the company name

		report.attachReporter(spark); // then we will add to the screenshot so attachedreporter use and objec is spark
										// mentioned
		// we use to attachReporter so get add to the screenshot automatically
}
	public static ExtentTest createTestCase(String testCase) {
		return report.createTest(testCase);
		//Note-->//jub bhi report genarate krna hai to first call to report -=report.createTest(testCase)
		// createtest jo hai humare createTest ko call kr rha hai 
		// jo humari report hogi usme hum isko hide krke rkenge 
	}
	
	public void generateScreenShoot() {
		
	//	BrowserUtility.driver// isme hume generateScreenShoot nhi milegi so java concpet type casting 
		// we ceate object to takescreenshot
		TakesScreenshot takescreenshot=(TakesScreenshot)BrowserUtility.driver; 
		File src=takescreenshot.getScreenshotAs(OutputType.FILE); // return type File is also File
	
		// we create object to fileutils and then u can use=try catch block
		File dest=new File("./Result/result.html");
		// next step we can us FileUtils and then show the method copyFile  
	//FileUtils.copyFile(src,dest );  so ager error aya to use try catch block otherwise thorws
		try {
			FileUtils.copyFile(src,dest ); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
