package com.abc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.abc.Utility.BrowserUtility;
import com.aventstack.extentreports.model.Log;
//hompage extends loginpage mlub login hone ke bad hum homepage per ayenge 

public class HomePage extends LoginPage {
// login pagetest per defualt constrcutor ko call kiya hai so hompage per error aya so call by parameterizeed cosnstrucotr
	public HomePage(String username, String password) {
		super(username, password);
		// TODO Auto-generated constructor stub
	}


	//locator
	//logic method for your functionality 
	private WebElement pimlink;// // we use to private WebElement // declare to global varible 

	public WebElement getPimlink() {
		pimlink=BrowserUtility.driver.findElement(By.xpath("//a[@href='/web/index.php/pim/viewPimModule']"));
		
		//pimlink.findElement(By.xpath("//a[@class ='oxd-main-menu-item active']"));
		return pimlink;
	}
	
	
	
}
