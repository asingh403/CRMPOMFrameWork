package com.qa.crmpro.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.crmpro.util.Constants;

public class HomePage extends BasePage {

	@FindBy(xpath = "/html/body/table[1]/tbody/tr[1]/td/table/tbody/tr/td[2]")
	WebElement homePageHeader;
	
	
	@FindBy(xpath = "//td[contains(text(), 'User: Naveen AutomationLabs')]")
	WebElement accountName;
	
	@FindAll({@FindBy(tagName = "frame")})
	List<WebElement> frames ;
	
	@FindBy(xpath = "//a[@title= 'Home']")
	WebElement homeTitle;
	
	@FindBy(xpath = "//a[@title= 'Calendar']")
	WebElement calendarTitle;
	
	/**
	 * The Actions methods are defines for HomePage class.
	 * @param driver
	 */
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	public String getHomePageTitle() {
		WebDriverWait wait = new WebDriverWait(driver,Constants.DEFAULT_WAIT_TIMEOUT);
		wait.until(ExpectedConditions.titleContains(Constants.HOME_PAGE_TITLE));
		return driver.getTitle();
		
	}
	
	public String getHomePageHeaderValue() {
		this.switchToFrame();
		return homePageHeader.getText();
	}

	public String getLoggedInAccountValue() {
		this.switchToFrame();
		return accountName.getText();
	}
	
	
	public ArrayList<String> getFramesName() {
		ArrayList<String> data = new ArrayList<String>(); 
		for (int i=0;i<frames.size();i++) {
			data.add(frames.get(i).getText());
			
		}
		return data;
	}
	
	public String homeTitle() {
		this.switchToFrame();
		return homeTitle.getText();
	}
	
	public boolean getcalendarTitle() {
		this.switchToFrame();
		return calendarTitle.isDisplayed();
		
	}
	
	
}
