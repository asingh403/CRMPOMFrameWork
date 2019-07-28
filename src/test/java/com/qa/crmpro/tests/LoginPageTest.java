package com.qa.crmpro.tests;

import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.crmpro.pages.BasePage;
import com.qa.crmpro.pages.LoginPage;
import com.qa.crmpro.util.Constants;
import com.qa.crmpro.util.TimeUtil;

public class LoginPageTest {

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

	@Test(priority = 1)
	public void verifyLoginPageTitleTest() {
		String title = loginPage.getLoginPageTitle();
		System.out.println("login Page Title is : " + title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);

	}

	@Test(priority = 2)
	public void totalLinks() {
		int PageLinks = loginPage.getLinks();
		System.out.println("Total number of Links present on the Webpage : " + PageLinks);
		Assert.assertEquals(PageLinks, 27);

	}

	@Test(priority = 3)
	public void linksName() {
		ArrayList<String> LinksText = loginPage.getLinksText();
		System.out.println("List of Links text : " + LinksText);
		int PageLinks = loginPage.getLinks();
		Assert.assertEquals(PageLinks, 27);

	}
	
	@Test(priority=4)
	public void CRMLoginTest() {
		loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
	}

	@Test(priority=5)
	public void verifySignUpLinkTest() {
		Assert.assertTrue(loginPage.verifySignUpLink());	
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}
