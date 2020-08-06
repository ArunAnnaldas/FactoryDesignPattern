package com.selenium.test.factory;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium.srp.factory.GoogleFactory;
import com.selenium.srp.factory.GooglePage;
import com.selenium.test.BaseTest;

public class GoogleSearchTest extends BaseTest{

	private GooglePage googlePage;
	
	@Test(dataProvider = "getData")
	public void searchTest(String language, String keyword) {
		
		this.googlePage = GoogleFactory.get(language,this.driver);
		this.googlePage.launchSite();
		this.googlePage.search(keyword);
		int resultCount = this.googlePage.getResultsCount();
		
		System.out.println("Result Count : " + resultCount);
		
	}
	
	@DataProvider
	public Object[][] getData(){
		return new Object[][] {
//			{"ENG", "Selenium"},
//			{"FR", "Design Patterns"},
//			{"SA", "Docker"},
			{"ES","testing selenium"}
		};
	}
	
}
