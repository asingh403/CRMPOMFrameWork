package com.qa.crmpro.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * 
 * @author ASHUTOSH SINGH
 *
 */

public class BasePage {
	public WebDriver driver;
	public Properties prop;

	/**
	 * 
	 * @param browser
	 * @return : This method will return the driver on basis of browser
	 */

	public WebDriver init_driver(Properties prop) {
		String browser = prop.getProperty("browser");
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:/chromedriver_win32/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:/chromedriver_win32/geckodriver.exe");
			driver = new FirefoxDriver();
		} else {
			System.out.println(browser + "---> no browser is defined");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(prop.getProperty("pageloadtimeout")), TimeUnit.SECONDS);

		return driver;
	}
	
	/**
	 * 
	 * @return: This method will load the config properties and will return prop object
	 */

	public Properties init_prop() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream(
					"C:\\Users\\ASHUTOSH SINGH\\eclipse-workspace\\CRMProPOMFramework\\src\\main"
					+ "\\java\\com\\qa\\crmpro\\config\\config.properties");
			try {
				prop.load(ip);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return prop;
	}
	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
		
	}

}
