package com.selenium.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.google.common.util.concurrent.Uninterruptibles;

public class BaseTest {
	
	protected WebDriver driver;
	
	@BeforeTest
	public void setupDriver() {
		System.out.println(
				"***** Create WebDriver ******");
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/exe/chromedriver_84.exe");
		this.driver = new ChromeDriver();
	}
	
	@AfterTest
	public void quitDriver() {
		Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
		this.driver.quit();
	}
}
