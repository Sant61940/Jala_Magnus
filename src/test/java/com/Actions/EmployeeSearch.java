package com.Actions;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.CommonUtils.CommonUtils;
import com.CommonUtils.ExtentReportManager;
import com.PageObjects.EmployeeCreationPage;
import com.PageObjects.EmployeeSearchPage;
import com.PageObjects.LoginPage;
import com.WebDriverManager.DriverManager;

public class EmployeeSearch {

	private ExtentReports extent;
	private ExtentTest test;

	@Before
	public void setup() {
		String reportPath = "report/";
		extent = ExtentReportManager.getInstance(reportPath + "EmployeeSearchReport.html");
		test = ExtentReportManager.startTest("Employee Search Test");

		DriverManager driverManager = new DriverManager();
		driverManager.openBrowser();

		CommonUtils.getInstance().loadProperties();
		CommonUtils.getInstance().inItElements();
	}

	@Test
	public void testEmployeeSearch() throws IOException {

		try {

			LoginPage loginPage = LoginPage.getInstance();
			loginPage.enterName();
			loginPage.enterPassword();
			loginPage.clickLogin();

			EmployeeCreationPage creationPage = EmployeeCreationPage.getInstance();
			creationPage.clickEmployee();
			creationPage.clickSearch();

			EmployeeSearchPage employeeSearchPage = EmployeeSearchPage.getInstance();
			employeeSearchPage.enterName("Santhosh");
			employeeSearchPage.enterNumber("9000090000");
			employeeSearchPage.clickSearch();

			test.pass("Login successful");
			test.pass("Employee search successful");
			test.pass("Test Passed");
		} 
		catch (Exception e) {
			test.fail("Test Failed: " + e.getMessage());
			String screenshotPath = CommonUtils.getInstance().captureScreenshot();
			test.addScreenCaptureFromPath(screenshotPath);

		}
	}

	@After
	public void tearDown() {
		ExtentReportManager.endTest();

	}
}
