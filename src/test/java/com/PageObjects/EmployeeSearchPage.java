package com.PageObjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class EmployeeSearchPage {

	private static EmployeeSearchPage employeeSearchPageInstance;

	private EmployeeSearchPage() {

	}
	public static EmployeeSearchPage getInstance() {
		if(employeeSearchPageInstance==null) {
			employeeSearchPageInstance = new EmployeeSearchPage();
		}
		return employeeSearchPageInstance;
	}

	@FindBy(xpath = "//input[@placeholder='Employee Name']")
	private WebElement name;

	@FindBy(xpath = "//div/input[@id='MobileNo']")
	private WebElement number;

	@FindBy(xpath = "//div/button[@id='btnSearch']")
	private WebElement searchButton;

	@FindBy(xpath = "//div/button[@id='btnClear']")
	private WebElement clearButton;

	public void enterName(String searchName) {
		name.sendKeys(searchName);
	}

	public void enterNumber(String num) {
		number.sendKeys(num);
	}

	public void clickSearch() {
		searchButton.click();
	}

	public void clickClear() {
		clearButton.click();
	}


}


