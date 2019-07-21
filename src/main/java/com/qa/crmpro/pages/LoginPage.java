package com.qa.crmpro.pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
	@FindBy(xpath = "//input[@name='username']")
	WebElement emailId;

	@FindBy(xpath = "//input[@name='password")
	WebElement password;

	@FindBy(xpath = "//input[@class='btn btn-small']")
	WebElement loginButton;
	
	@FindBy(tagName = "//a")
	String linksList;
	
	// Create a constructor of this page class
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Define page actions/methods:
	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public void doLogin(String username,String pwd) {
		emailId.sendKeys(username);
		password.sendKeys(pwd);
		loginButton.click();
	}
																																																													
	
}
