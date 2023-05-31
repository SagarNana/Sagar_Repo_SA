package com.abc.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.abc.Utility.BrowserUtility;

public class LoginPage extends BrowserUtility{

	// we have to select 3 method and right click then source then getetr and setter
	// method click
//private WebElement usernameTxt;passwordTxt;loginButton; he encapsulation concept hai aur  LoginPage extend BrowserUtility krnege to inheritance concpt hoga
	private WebElement usernameTxt;
	private WebElement passwordTxt;
	private WebElement loginButton;
	
//call to default constructor then some error to login page per error hoga then this line error LoginPage loginpage=new LoginPage("Admin","admin123"); it can put username and password 
//then error to the hompage go to the hompage then home is child object by defualt oh constrcuotr ko call krega aur defualt construcotr subse phele parent cnstrucotr ko call krega but parent ke pass pramaeterized constrcutor hai so defualt is not able to this page  construcot 
	//so homage is calling to one constructor that is parameterized constructor , uske bad employee is also child from homage so again constrcuot call and then error to employee page angain go to the employeeage by defualt call constrcuor then go to the empolyeepagetest error go to this page and 
	//
	public LoginPage (String username, String password) { //call by default constructor
		LoginFuctionality(username, password);
		
	}

	public WebElement getUsernameTxt() {
		usernameTxt =driver.findElement(By.xpath("//input[@name='username']"));
		return usernameTxt;
		// otherwise we can use to extend BrowserUtility
	}

	public WebElement getPasswordTxt() {
		passwordTxt =driver.findElement(By.xpath("//input[@name='password']"));
		return passwordTxt;
	}

	public WebElement getLoginButton() {
		loginButton =driver.findElement(By.xpath("//button[@type='submit']"));
	//	loginButton.click();  
		return loginButton;
	}

	public void LoginFuctionality(String username, String password) {
//LoginFuctionality we have two parameter so this time use String username and String password	
		getUsernameTxt().sendKeys(username);
		getPasswordTxt().sendKeys(password);
		getLoginButton().click();
	}
}