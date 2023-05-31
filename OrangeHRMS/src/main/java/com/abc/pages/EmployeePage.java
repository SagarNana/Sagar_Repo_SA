package com.abc.pages;
 // EmployeePage per jane ke liye Homgelagega so extends use and go to the hompage

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.abc.Utility.BrowserUtility;

// jub hum homepage per honge to uske bad hum employee page per ja skenge 
public class EmployeePage  extends HomePage {
	
	// declare the all locator are global and then all elements find xpath and then add employee detials 
// you can read this loagin page and we will understand and then call to default constructor then go to the empolyeepagetest 	
	public EmployeePage(String username, String password) throws InterruptedException {
		super(username, password);
		Thread.sleep(3000);
		// TODO Auto-generated constructor stub
		getPimlink().click(); //ager isko use krenge to employeetes page per hume call kren ki jrurat nhi hai 
		
	}

	private WebElement addbutton;  // declare to the global varible 
	private WebElement firstNameTxt ;
	private WebElement middleNameTxt ;
	private WebElement lastNameTxt ;
	private WebElement saveButton ;
	

	public WebElement getAddbutton() {
		addbutton=BrowserUtility.driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")); 
		return addbutton;
	}

	public WebElement getFirstNameTxt() {
		firstNameTxt=BrowserUtility.driver.findElement(By.xpath("//input[@name='firstName']"));
		return firstNameTxt;
	}

	public WebElement getMiddleNameTxt() {
		middleNameTxt=BrowserUtility.driver.findElement(By.xpath("//input[@name='middleName']"));
		return middleNameTxt;
	}

	public WebElement getLastNameTxt() {
		lastNameTxt=BrowserUtility.driver.findElement(By.xpath("//input[@name='lastName']"));
		return lastNameTxt;
	}

	public WebElement getSaveButton() {
		saveButton=BrowserUtility.driver.findElement(By.xpath("//button[@type='submit']"));
		return saveButton;
	}
	
	// we add to the addemployee deitail using string 
	public void AddEmployee (String FirstName,String MiddleName,String LastName) {
		getFirstNameTxt().sendKeys(FirstName);
		getMiddleNameTxt().sendKeys(MiddleName);
		getLastNameTxt().sendKeys(LastName);
		getSaveButton().click();
		
		
	}
	
	
	
}

