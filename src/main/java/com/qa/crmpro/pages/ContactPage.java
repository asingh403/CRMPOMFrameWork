package com.qa.crmpro.pages;

import java.time.LocalDate;
import java.util.List;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.qa.crmpro.util.Constants;
import com.qa.crmpro.util.TimeUtil;

public class ContactPage extends BasePage {

	WebDriver driver;

	@FindBy(xpath = "//*[text()='Contact Information']")
	WebElement contactPageHeader;
	@FindBy(xpath = "//div[@class='calendar']/table/thead/tr[2]/td[5]")
	WebElement nextYear;

	@FindBy(xpath = "//div[@class='calendar']/table/thead/tr[2]/td")
	WebElement prevYear;

	@FindBy(xpath = "//div[@class='calendar']/table/thead/tr[2]/td[4]")
	WebElement nextMonth;

	@FindBy(xpath = "//div[@class='calendar']/table/thead/tr[2]/td[2]")
	WebElement prevMonth;

	@FindBy(xpath = "//*[@id='contactForm']/table/tbody/tr[2]/td[1]/table/tbody/tr[1]/td[2]/select")
	WebElement title;

	@FindBy(xpath = "//input[@id = 'first_name']")
	WebElement firstName;

	@FindBy(xpath = "//input[@id = 'middle_initial']")
	WebElement middleName;

	@FindBy(xpath = "//*[@id = 'surname']")
	WebElement lastName;

	@FindBy(xpath = "//input[@type='text' and @name='nickname']")
	WebElement nickName;

	@FindBy(xpath = "//input[@name='client_lookup']")
	WebElement company;

	@FindBy(xpath = "//input[@id='company_position']")
	WebElement position;

	@FindBy(xpath = "//input[@id='department']")
	WebElement department;

	@FindBy(xpath = "//input[@name='contact_lookup_sup']")
	WebElement supervisor;

	@FindBy(xpath = "//input[@type='text' and @name='contact_lookup_ref']")
	WebElement referredBy;

	@FindBy(xpath = "//input[@id='mobile']")
	WebElement mobile;

	@FindBy(xpath = "//input[@id='email']")
	WebElement email;

	@FindBy(xpath = "//input[@id='im_id']")
	WebElement messengerId;

	@FindBy(xpath = "//input[@id='skype_id']")
	WebElement skypeId;

	@FindBy(xpath = "//input[@type='text' and @name='identifier']")
	WebElement identifier;

	@FindBy(xpath = "//input[@type='text' and @name='address_title']")
	WebElement addressTitle;

	@FindBy(xpath = "//input[@id= 'tags']")
	WebElement tags;

	@FindBy(xpath = "//*[@id='description']")
	WebElement description;

	@FindBy(xpath = "//*[@id='contactForm']/table/tbody/tr[1]/td/input[2]")
	WebElement save;

	@FindBy(xpath = "/html/body/div[9]/table/thead/tr[1]/td[2]")
	WebElement dateOfMonthAndYear;

	@FindBy(xpath = "//*[@id='f_trigger_c_birthday']")
	WebElement dateOfBirthCal;

	@FindBy(xpath = "//*[@id='image_file']")
	WebElement profileImage;

	@FindBy(xpath = "/html/body/div[6]/table/thead/tr[1]/td[2]")
	WebElement calendarMonthYear;

	@FindAll({ @FindBy(xpath = "//div[@class='calendar']/table/tbody/tr") })
	List<WebElement> totalRowInCalendar;

	@FindBy(xpath = "//div[@class='calendar']/table/tbody/tr[1]/td")
	List<WebElement> totalColInCalendar;

	String xpath1 = "//div[@class='calendar']/table/tbody/tr[";
	String xpath2 = "]/td[";
	String xpath3 = "]";

	public ContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public boolean verifyContactPageHeader() {
		WebDriverWait wait = new WebDriverWait(driver, Constants.DEFAULT_WAIT_TIMEOUT);
		wait.until(ExpectedConditions.visibilityOf(contactPageHeader));
		return contactPageHeader.isDisplayed();

	}

	public WebElement verifyTitle() {
		return title;
	}

	public WebElement verifyFirstName() {
		return firstName;
	}

	public WebElement verifyMiddleName() {
		return middleName;
	}

	public WebElement verifyLastName() {
		return lastName;
	}

	public WebElement verifyNickName() {
		return nickName;
	}

	public WebElement verifyCompany() {
		return company;
	}

	public WebElement verifyPosition() {
		return position;
	}

	public WebElement verifyDepartment() {
		return department;
	}

	public WebElement verifySupervisor() {
		return supervisor;
	}

	public WebElement verifyReferredBy() {
		return referredBy;
	}

	public WebElement verifyMobile() {
		return mobile;
	}

	public WebElement verifyEmail() {
		return email;
	}

	public WebElement verifyMessengerId() {
		return messengerId;
	}

	public WebElement verifySkypeId() {
		return skypeId;
	}

	public WebElement verifyIdentifier() {
		return identifier;
	}

	public WebElement verifyAddressTitle() {
		return addressTitle;
	}

	public WebElement verifyTags() {
		return tags;
	}

	public WebElement verifyDescription() {
		return description;
	}

	public WebElement verifySave() {
		return save;
	}

	public WebElement verifyMonthYear() {
		return calendarMonthYear;
	}

	public String verifyContactPageTitle() {
		Select select = new Select(title);
		List<WebElement> list = select.getOptions();
		for (int i = 1; i < list.size(); i++) {
			String sValue = select.getOptions().get(i).getText();
			if (sValue.equals(Constants.CONTACT_TITLE)) {
				select.getOptions().get(i).click();
				String SelectedTitle = select.getOptions().get(i).getText();
				System.out.println(SelectedTitle);
				return SelectedTitle;
			}
		}

		return null;
	}

	// **************************DOB using CALENDER*********************
	public void verifyCalenderDateAndYearDateOfBirth(String DOB) {
		System.out.println(DOB); // ** Date of Birth is reading properly.
		dateOfBirthCal.click();
		String calendarTitleMonthYear = calendarMonthYear.getText();
		System.out.println(calendarTitleMonthYear);
		DateTimeFormatter dateAndTimeFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		
		System.out.println("-------EXCEL_DATE_PRINT_AFTER_READING  :"+ DOB);
		String[] varDate=DOB.split("-");
		String dataProviderDate=varDate[0].trim();
		String dataProviderMonth=varDate[1].trim();
		String dataProviderYear=varDate[2].trim();

		int excelDate = Integer.parseInt(dataProviderDate);
		System.out.println("---------->"+ excelDate);
		int excelMonth = Integer.parseInt(dataProviderMonth);
		System.out.println("---------->"+ excelMonth);
		int excelYear = Integer.parseInt(dataProviderYear);
		System.out.println("---------->"+ excelYear);
		/**
		 * Read the Title from the calendar after click then split the Title in Month
		 * and Year format based on the delimit (,).
		 */
		int currentMonthInt = 1;
		String monthYearSplit[] = calendarMonthYear.getText().split(",");
		String calenderMonth = monthYearSplit[0].trim();
		String calenderYear = monthYearSplit[1].trim();

		int currentYearInt = Integer.parseInt(calenderYear);

		switch (calenderMonth) {
		case "January":
			currentMonthInt = 1;
			break;
		case "February":
			currentMonthInt = 2;
			break;
		case "March":
			currentMonthInt = 3;
			break;
		case "April":
			currentMonthInt = 4;
			break;
		case "May":
			currentMonthInt = 5;
			break;
		case "June":
			currentMonthInt = 6;
			break;
		case "July":
			currentMonthInt = 7;
			break;
		case "August":
			currentMonthInt = 8;
			break;
		case "September":
			currentMonthInt = 9;
			break;
		case "October":
			currentMonthInt = 10;
			break;
		case "November":
			currentMonthInt = 11;
			break;
		case "December":
			currentMonthInt = 12;
			break;
		}

		while (excelYear > currentYearInt) {
			nextYear.click();
			currentYearInt++;
		}

		while (excelYear < currentYearInt) {
			prevYear.click();
			currentYearInt--;
		}

		while (excelMonth > currentMonthInt) // if input month is > than present month click next month
		{
			nextMonth.click();
			currentMonthInt++;
		}
		while (excelMonth < currentMonthInt) // if input month is > than present month click next month
		{
			prevMonth.click();
			currentMonthInt--;
		}

		int calenderRowCount = totalRowInCalendar.size();
		int calenderColCount = totalColInCalendar.size();

		String excelDateString = Integer.toString(excelDate);
		for (int i = 1; i <= calenderRowCount; i++) {
			for (int j = 2; j <= calenderColCount; j++) {
				String dateString = xpath1 + i + xpath2 + j + xpath3;
				String dateDataString = driver.findElement(By.xpath(dateString)).getText();
				// int dateCell = Integer.parseInt(dateDataString);
				// if(dateCell ==excelDate)

				if (excelDateString.equalsIgnoreCase(dateDataString)) {
					driver.findElement(By.xpath(dateString)).click();
				}
			}
		}
	}
	
	
	
	
	

	// ******************Image uploading**********
	public WebElement verifyImageUpload() {
		// type:File

		profileImage.sendKeys("C:\\Users\\ASHUTOSH SINGH\\Desktop\\CalendarHandling.png");
		return profileImage;

	}

}
