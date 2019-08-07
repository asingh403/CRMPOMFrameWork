package com.qa.crmpro.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.qa.crmpro.util.Constants;

public class ContactPage extends BasePage {

	WebDriver driver;

	@FindBy(xpath = "//*[text()='Contact Information']")
	WebElement contactPageHeader;

	@FindBy(xpath = "//*[@id='contactForm']/table/tbody/tr[2]/td[1]/table/tbody/tr[1]/td[2]/select")
	WebElement title;


	public ContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public boolean verifyContactPageHeader() {
		WebDriverWait wait = new WebDriverWait(driver, Constants.DEFAULT_WAIT_TIMEOUT);
		wait.until(ExpectedConditions.visibilityOf(contactPageHeader));
		return contactPageHeader.isDisplayed();

	}

	public WebElement verifyContactPageTitle() {
		return title;

	}

}
