package com.PageObjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.CommonUtils.CommonUtils;

public class FormFillPage {

	private static FormFillPage formFillPageInstance;

	private FormFillPage() {

	}

	public static FormFillPage getInstance() {
		if(formFillPageInstance==null) {
			formFillPageInstance = new FormFillPage();
		}
		return formFillPageInstance;
	}

	@FindBy(name = "FirstName")
	private WebElement firstName;

	@FindBy(id = "LastName")
	private WebElement lastName;

	@FindBy(xpath = "//div/input[@placeholder='Email Id']")
	private WebElement eMailId;

	@FindBy(name="MobileNo")
	private WebElement mobileNo;

	@FindBy(xpath = "//input[@placeholder='dd/mm/yyyy']")
	private WebElement dob;

	@FindBy(xpath = "(//input[@type='radio'])[1]")
	private WebElement gender;

	@FindBy(id ="Address" )
	private WebElement addressBar;

	@FindBy(id = "CountryId")
	private WebElement countryDropdown;

	@FindBy(id="CityId")
	private WebElement cityDropdown;

	@FindBy(xpath = "//div[contains(text(), 'QA-Automation')]/input[@type='checkbox']")
	private WebElement qaCheckBox;

	@FindBy(xpath = "//button[text()='Save']")
	private WebElement saveButton;

	@FindBy(id = "rdbMale")
	private WebElement maleRadio;

	@FindBy(id = "rdbFemale")
	private WebElement femaleRadio;

	@FindBy(id = "chkSkill_1")
	private WebElement qaAutomationCheckbox;

	@FindBy(id = "chkSkill_2")
	private WebElement fullStackDeveloperCheckbox;

	@FindBy(id = "chkSkill_3")
	private WebElement devOpsCheckbox;

	@FindBy(id = "chkSkill_4")
	private WebElement middlewareCheckbox;

	@FindBy(id = "chkSkill_5")
	private WebElement awsCheckbox;

	@FindBy(id = "chkSkill_6")
	private WebElement webServicesCheckbox;


	public void enterFirstName(String fName) {
		firstName.sendKeys(fName);
	}

	public void enterLastName(String lName) {
		lastName.sendKeys(lName);	
	}

	public void enterEmail(String mail) {
		eMailId.sendKeys(mail);	
	}

	public void enterNumber(String num) {
		mobileNo.sendKeys(num);
	}

	public void enterDOB(String DOB) {
		dob.sendKeys(DOB);
	}

	public void selectGender(String gender) {
		if ("Male".equalsIgnoreCase(gender)) {
			maleRadio.click();
		} else if ("Female".equalsIgnoreCase(gender)) {
			femaleRadio.click();
		}
	}

	public void enterAddress(String addr) {
		addressBar.sendKeys(addr);
	}

	public void selectCountry(String country) {
		CommonUtils.getInstance().waitForElementToBeVisible(countryDropdown, Duration.ofSeconds(20));
		Select select = new Select(countryDropdown);
		select.selectByVisibleText(country);
	}

	public void selectCity(String city) {
		CommonUtils.getInstance().waitForElementToBeVisible(cityDropdown, Duration.ofSeconds(5));
		Select select = new Select(cityDropdown);
		select.selectByVisibleText(city);
	}

	public void clickSave() {
		saveButton.click();
	}

	public void selectSkill(String skill) {

		String lowercaseSkill = skill.toLowerCase();

		if (lowercaseSkill.contains("qa") || lowercaseSkill.contains("automation")) {
			qaAutomationCheckbox.click();
		}
		else if (lowercaseSkill.contains("full stack") || lowercaseSkill.contains("developer")) {
			fullStackDeveloperCheckbox.click();
		} 
		else if (lowercaseSkill.contains("devops")) {
			devOpsCheckbox.click();
		} 
		else if (lowercaseSkill.contains("middleware")) {
			middlewareCheckbox.click();
		} 
		else if (lowercaseSkill.contains("aws")) {
			awsCheckbox.click();
		} 
		else if (lowercaseSkill.contains("web") || lowercaseSkill.contains("services")) {
			webServicesCheckbox.click();
		} 
		else {
			throw new IllegalArgumentException("Invalid skill: " + skill);
		}
	}
}

