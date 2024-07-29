package com.saucedemo.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucedemo.TestBase.TestBase;

public class AccountLoginPage extends TestBase {

	public AccountLoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input[name='user-name']")
	WebElement username;

	@FindBy(css = "input[type='password']")
	WebElement password;

	@FindBy(xpath = "//div[@id='login_credentials']")
	WebElement standardUser;

	@FindBy(xpath = "//div[@class='login_password']")
	WebElement acceptedPassword;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement submitBtn;

	public void enterUsername() {
		String[] usernames = (standardUser.getText().trim()).split("\n");
		username.sendKeys(usernames[1]);
	}

	public void enterPassword() {
		String[] passwords = (acceptedPassword.getText().trim()).split("\n");
		password.sendKeys(passwords[1]);
	}

	public SwagLabsPage clickSubmitBtn() {
		submitBtn.click();
		return new SwagLabsPage();
	}
}
