package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	//1. By Locators : OR
	private By emailId = By.id("email");
	private By password = By.id("passwd");
	private By submitBtn = By.id("SubmitLogin");
	private By forgotPassLnk = By.linkText("Forgot your password?");
	
	//2. Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//3. Page Actions
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean isForgotPwdLinkExist() {
		return driver.findElement(forgotPassLnk).isDisplayed();
	}

	public void enterUserName(String username) {
		driver.findElement(emailId).sendKeys(username);
	}
	
	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void clickOnLogin() {
		driver.findElement(submitBtn).click();
	}
	
	public AccountsPage doLogin(String un,String pwd) {
		System.out.println("login in with : "+un+" and "+pwd);
	driver.findElement(emailId).sendKeys(un);
	driver.findElement(password).sendKeys(pwd);
	driver.findElement(submitBtn).click();
	return new AccountsPage(driver);
	}
}
