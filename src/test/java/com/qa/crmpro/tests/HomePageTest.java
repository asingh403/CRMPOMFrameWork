package com.qa.crmpro.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.qa.crmpro.pages.BasePage;
import com.qa.crmpro.pages.LoginPage;
import com.qa.crmpro.util.TimeUtil;

public class HomePageTest {

	WebDriver driver;
	BasePage basePage;
	Properties prop;
	LoginPage loginPage;

	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop);
		driver.get(prop.getProperty("url"));
		loginPage = new LoginPage(driver);
		TimeUtil.shortWait();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();

	}	
	
}
