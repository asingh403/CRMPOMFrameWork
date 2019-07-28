package com.qa.crmpro.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
	@FindBy(xpath = "//input[@name='username']")
	WebElement emailId;

	@FindBy(xpath = ".//input[@name = 'password']")
	WebElement password;

	@FindBy(xpath = "//input[@class='btn btn-small']")
	WebElement loginButton;
	
	@FindBy(tagName = "a")
	List<WebElement> list;
	
	@FindBy(xpath = "//a")
	List<WebElement> links;
	
	@FindBy(linkText= "Sign Up")
	WebElement SignUpLink;
	
	// Create a constructor of this page class
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Define page actions/methods:
	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	/**
	 * 
	 * @param username : naveenautomation
	 * @param pwd : test@123
	 * @return Home Page object 
	 */
	
	public HomePage doLogin(String username,String pwd) {
		emailId.sendKeys(username);
		password.sendKeys(pwd);
		loginButton.click();
		
		return new HomePage(driver);
	}
	public int getLinks() {
		int count=list.size();
		return count;
		
	}
	
	public ArrayList<String> getLinksText() {
		ArrayList<String> data = new ArrayList<String>(); 
		for (int i=0;i<links.size();i++) {
			data.add(links.get(i).getAttribute("href"));
			
		}
		return data;
	}
	
	public boolean verifySignUpLink() {
		return SignUpLink.isDisplayed();
		
	}
																																																													
	
}
