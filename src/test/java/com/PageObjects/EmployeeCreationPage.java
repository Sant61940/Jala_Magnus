package com.PageObjects;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.CommonUtils.CommonUtils;



public class EmployeeCreationPage {

	private static EmployeeCreationPage employeeCreationPageInstance;

	private EmployeeCreationPage() {

	}

	public static EmployeeCreationPage getInstance() {
		if (employeeCreationPageInstance==null) {
			employeeCreationPageInstance = new EmployeeCreationPage();
		}
		return employeeCreationPageInstance;
	}

	@FindBy(xpath ="//ul[@id='MenusDashboard']/li[2]" )
	private WebElement employeeButton;

	@FindBy(xpath = "(//ul[@class='treeview-menu']//a)[1]")
	private WebElement createButton;

	@FindBy(xpath = "//li/a[contains(text(),'Search')]")
	private WebElement searchButton;

	public void clickEmployee() {
		CommonUtils.getInstance().waitForElementToBeVisible(employeeButton, Duration.ofSeconds(8));
		employeeButton.click();
	}

	public void clickCreate() {
		createButton.click();
	}

	public void clickSearch() {
		CommonUtils.getInstance().waitForElementToBeVisible(searchButton, Duration.ofSeconds(8));
		searchButton.click();
	}
}
