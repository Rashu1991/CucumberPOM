package com.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	/**
	 * This browser is used to initialize the thread local driver on the basis of given browser
	 * @param browser
	 * @return
	 */
	public WebDriver init_driver(String browser) {
		
		System.out.println("browser value is "+browser);
		
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
		}
		else if(browser.equals("firefox")){
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		}
		else {
			System.out.println("Please pass the correct browser value: "+browser);
		}
		
		getWebDriver().manage().deleteAllCookies();
		getWebDriver().manage().window().maximize();
		
		return getWebDriver();
		}
	
	/**
	 * this is used to get the webriver with thread local
	 * @return
	 */
	public static synchronized WebDriver getWebDriver() {
		return tlDriver.get();
	}
	}
	


