package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {

	private WebDriver driver;
	
	By accountSections = By.xpath("//div[@id='center_column']//span");
	
	public AccountsPage(WebDriver driver){
		this.driver=driver;
	}
	
	public int getAccountSectionCount() {
		
		return driver.findElements(accountSections).size();
	}
	
	public List<String> getAccountSectionList() {
		List<String> accountsList = new ArrayList<String>();
		List<WebElement> accountHeaderList=driver.findElements(accountSections);
		
		for(WebElement ele : accountHeaderList) {
			String text=ele.getText();
			System.out.println(text);
			accountsList.add(text);
		}
		return accountsList;
	}
	
	public String getAccontsPageTitle() {
		return driver.getTitle();
	}
}
