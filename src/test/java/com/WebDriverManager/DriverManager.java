package com.WebDriverManager;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.constants.Constants;
import com.CommonUtils.CommonUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public  class  DriverManager {
	public static  WebDriver driver = null;



	public void openBrowser() {
		// Load properties before using Constants.BROWSER
		CommonUtils.getInstance().loadProperties();

		switch (Constants.BROWSER) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(Constants.APP_URL);
			driver.manage().window().maximize();
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			break;

		default:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;
		}
	}

	public static WebDriver getDriver() {
		return driver;
	}
}
