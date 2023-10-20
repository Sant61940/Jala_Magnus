package com.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.constants.Constants;


public class LoginPage {

	private static LoginPage loginPageInstance; 

	public  LoginPage() {

	}

	public static LoginPage getInstance() {
		if (loginPageInstance == null) {
			loginPageInstance = new LoginPage();
		}
		return loginPageInstance;
	}

	@FindBy(name = "UserName")
	private WebElement userName;

	@FindBy(id = "Password")
	private WebElement passWord;

	@FindBy(id="btnLogin")
	private WebElement singIN;


	public void enterName() {
		userName.sendKeys(Constants.USERNAME);
	}

	public void enterPassword() {
		passWord.sendKeys(Constants.PASSWORD);
	}

	public void clickLogin() {
		singIN.click();
	}

}
