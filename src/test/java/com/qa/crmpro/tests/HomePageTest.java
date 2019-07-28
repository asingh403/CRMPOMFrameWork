package com.qa.crmpro.tests;

import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.crmpro.pages.BasePage;
import com.qa.crmpro.pages.HomePage;
import com.qa.crmpro.pages.LoginPage;
import com.qa.crmpro.util.Constants;
import com.qa.crmpro.util.TimeUtil;

public class HomePageTest {

	WebDriver driver;
	BasePage basePage;
	Properties prop;
	LoginPage loginPage;
	HomePage homePage;

	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop);
		driver.get(prop.getProperty("url"));
		loginPage = new LoginPage(driver);
		TimeUtil.shortWait();
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test(priority = 1)
	public void verifyHomePageTitle() {
		String title = homePage.getHomePageTitle();
		System.out.println("CRMPRO home page title is :" + title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);
	}

	@Test(priority = 2)
	public void verifyHomePageHeader() {
		String headerValue = homePage.getHomePageHeaderValue();
		System.out.println("Header Value is :" + headerValue);
		Assert.assertEquals((headerValue).trim(), Constants.HOME_PAGE_HEADER);
	}

	@Test(priority = 3)
	public void verifyLoggedInUserNameTest() {
		String accountName = homePage.getLoggedInAccountValue();
		System.out.println("Logged in user Account name is :" + accountName);
		Assert.assertEquals((accountName).trim(), prop.getProperty("accountName"));
	}

	@Test(priority = 4)
	public void verifyFrames() {
		ArrayList<String> Frames = homePage.getFramesName();
		for (int count = 0; count <= Frames.size(); count++) {
			System.out.println("List of Frames :" + count);
		}
	}

	@Test(priority = 5)
	public void homeTitleInHomePage() {
		String home = homePage.homeTitle();
		System.out.println("The home title name is :" + home);
		Assert.assertEquals(home, Constants.HOME_LINK_TITLE);
	}

	@Test(priority = 6)
	public void calendarTitleInHomePage() {

		boolean calendar = homePage.getcalendarTitle();
		Assert.assertTrue(calendar);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}
