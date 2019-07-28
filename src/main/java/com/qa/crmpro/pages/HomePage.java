package com.qa.crmpro.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

	@FindBy(xpath = "/html/body/table[1]/tbody/tr[2]/td[1]/div/table/tbody/tr/td[1]")
	WebElement homePageHeader;
	
	
	@FindBy(xpath = "/html/body/table[1]/tbody/tr[1]/td/table/tbody/tr/td[1]")
	WebElement accountName;

	/**
	 * The Actions methods are defines for HomePage class.
	 * @param driver
	 */
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	public String getHomePageTitle() {
		return driver.getTitle();
		
	}
	
	public String getHomePageHeader() {
		
		return homePageHeader.getText();
	}

	public String getLoggedInAccountValue() {
		
		return accountName.getText();
	}
	
}
