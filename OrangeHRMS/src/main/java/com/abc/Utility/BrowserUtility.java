package com.abc.Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;

public class BrowserUtility {

	public static Properties prop; // we use to read to propety method =readProperty();
	public static WebDriver driver; // we use to Webdriver becuase commoan to all driver

	@BeforeSuite(alwaysRun=true) //beforesuit is run it but is not launch browser 
	public void LaunchApplication() throws InterruptedException {		
		readProperty();
			if(prop.getProperty("browsername").equalsIgnoreCase("chrome")) {
		//Step1= register the driver 
		//setProperty means to change the property
			System.setProperty("webdriver.chrome.driver", 
					".//src\\main\\resources\\chromedriver.exe");	//Step2= create object of chrome driver to launch chrome browser
			driver = new ChromeDriver(); // launch the browser
			}
	  else if (prop.getProperty("browsername").equalsIgnoreCase("edge")){
		//Step1= register the driver 
			System.setProperty("webdriver.edge.driver",
						".//src\\main\\resources\\msedgedriver.exe");
		//Step2= create object of EdgeDriver to launch browser
			 driver=new EdgeDriver(); // launch the browser
	}
	
//for entering url we use get(string url) method of webdriver interface
//	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	 driver.get(prop.getProperty("application.url")); 
		//prop.getProperty("apllication.url" is method application.propeties me se develop kiya hai 
		 driver.manage().window().maximize();
		 Thread.sleep(5000); // it can thorws exception =InterruptedException
	}

	public void readProperty() {

		prop = new Properties(); // we create object so that call only inside the method
		try {
			prop.load(new FileInputStream(".\\src\\main\\resources\\Application.properties"));
			//obj.load(new FileInputStream(""))-->it will thorows exception so,use to try &
			// catch block
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
