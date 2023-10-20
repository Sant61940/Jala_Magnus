package com.CommonUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.PageObjects.EmployeeCreationPage;
import com.PageObjects.EmployeeSearchPage;
import com.PageObjects.FormFillPage;
import com.PageObjects.LoginPage;
import com.WebDriverManager.DriverManager;
import com.constants.Constants;


public class CommonUtils {

	private static CommonUtils commonUtilsInstance;

	private CommonUtils() {}

	public static CommonUtils getInstance() {
		if(commonUtilsInstance==null) {
			commonUtilsInstance = new CommonUtils();
		}
		return commonUtilsInstance;

	}

	public void loadProperties() {
		Properties properties = new Properties();

		try {
			FileInputStream file = new FileInputStream("C:/Users/sant6/eclipse-workspace/Magnus/src/test/resources/config.properties");
			properties.load(file);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Constants.BROWSER = properties.getProperty("browser");
		Constants.APP_URL = properties.getProperty("app_url");
		Constants.USERNAME = properties.getProperty("username");
		Constants.PASSWORD = properties.getProperty("password");

	}

	 public void inItElements() {

		PageFactory.initElements(DriverManager.getDriver(),LoginPage.getInstance() );
		PageFactory.initElements(DriverManager.getDriver(), EmployeeCreationPage.getInstance());
		PageFactory.initElements(DriverManager.getDriver(), FormFillPage.getInstance());
		PageFactory.initElements(DriverManager.getDriver(), EmployeeSearchPage.getInstance());
	}


	public void waitForElementToBeVisible(WebElement element, Duration duration) {
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), duration);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public String captureScreenshot() {
	    TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
	    File screenshotFile = ts.getScreenshotAs(OutputType.FILE);
	    String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	    String screenshotName = "screenshot_" + timestamp + ".png";

	    try {
	        FileUtils.copyFile(screenshotFile, new File("screenshots/" + screenshotName));
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    return "screenshots/" + screenshotName;
	}


}


