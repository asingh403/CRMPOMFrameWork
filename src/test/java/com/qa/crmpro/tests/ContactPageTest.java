package com.qa.crmpro.tests;

import java.util.List;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.crmpro.pages.BasePage;
import com.qa.crmpro.pages.ContactPage;
import com.qa.crmpro.pages.HomePage;
import com.qa.crmpro.pages.LoginPage;
import com.qa.crmpro.util.TimeUtil;

public class ContactPageTest {
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	LoginPage loginPage;
	HomePage homePage;
	ContactPage contactPage;

	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop);
		driver.get(prop.getProperty("url"));
		loginPage = new LoginPage(driver);
		TimeUtil.shortWait();
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		contactPage = homePage.goToNewContactsPage();
	}

	@Test
	public void verifyContactPageHeaderTest() {
		contactPage.verifyContactPageHeader();
		TimeUtil.mediumWait();
	}

	@Test
	// **********Need to write the dropdown test case for title in New Contact Page.
	public void verifyNewContactTitleTest() {
		WebElement dropDownLists = contactPage.verifyContactPageTitle();
		Select select = new Select(dropDownLists);
		List<WebElement> list = select.getOptions();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getText());
		}

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}
