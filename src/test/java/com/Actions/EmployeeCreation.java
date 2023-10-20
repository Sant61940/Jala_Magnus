package com.Actions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.CommonUtils.CommonUtils;
import com.CommonUtils.ExtentReportManager;
import com.PageObjects.EmployeeCreationPage;
import com.PageObjects.FormFillPage;
import com.PageObjects.LoginPage;
import com.WebDriverManager.DriverManager;

public class EmployeeCreation {

	private ExtentReports extent;
	private ExtentTest test;

	@Before
	public void setup() {

		String reportPath = "report/";
		extent = ExtentReportManager.getInstance(reportPath + "EmployeeCreationReport.html");
		test = ExtentReportManager.startTest("Employee Creation Test");
		DriverManager driverManager = new DriverManager();
		driverManager.openBrowser();
		CommonUtils.getInstance().loadProperties();
		CommonUtils.getInstance().inItElements(); // Initialize page elements
	}

	@Test
	public void testEmployeeCreation() throws IOException {

		try {

			LoginPage loginPage = LoginPage.getInstance();
			loginPage.enterName();
			loginPage.enterPassword();
			loginPage.clickLogin();

			EmployeeCreationPage creationPage = EmployeeCreationPage.getInstance();
			creationPage.clickEmployee();
			creationPage.clickCreate();

			FormFillPage fillPage = FormFillPage.getInstance();
			fillPage.enterFirstName("Santhosh");
			fillPage.enterLastName("Raj B");
			fillPage.enterEmail("abcd@gmail.com");
			fillPage.enterNumber("9000090001");
			fillPage.enterDOB("18/06/1999");
			fillPage.selectGender("male");
			fillPage.enterAddress("Anna Nagar West");
			fillPage.selectCountry("India");
			fillPage.selectCity("Chennai");
			fillPage.selectSkill("QA Automation");
			fillPage.clickSave();

			test.pass("Login successful");
			test.pass("Employee creation successful");
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
