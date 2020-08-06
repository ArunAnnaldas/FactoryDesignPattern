package com.selenium.test.srp;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium.srp.pages.GoogleMainPage;
import com.selenium.srp.pages.GoogleResultPage;
import com.selenium.test.BaseTest;

public class GoogleTest extends BaseTest{

	private GoogleMainPage googleMainPage;
	private GoogleResultPage googleResultPage;
	
	@BeforeTest
	public void setupPages() {
		this.googleMainPage = new GoogleMainPage(driver);
		this.googleResultPage = new GoogleResultPage(driver);
	}
	
	@Test(dataProvider="getData")
	public void googleWorkFlow(String text, int index) {
//		String text = "selenium webdriver";
//		int index =3;
		
		googleMainPage.goTo();
		Assert.assertTrue(googleMainPage.getSearchWidget().isDisplayed());
		
		googleMainPage.getSearchWidget().enter(text);
		Assert.assertTrue(googleMainPage.getSearchSuggestion().isDisplayed());
		
		googleMainPage.getSearchSuggestion().clickSuggestionByIndex(index);
		Assert.assertTrue(googleResultPage.getNavigationBar().isDisplayed());
		
		googleResultPage.getSearchWidget().enter(text);
		Assert.assertTrue(googleResultPage.getSearchSuggestion().isDisplayed());
		
		googleResultPage.getSearchSuggestion().clickSuggestionByIndex(index);
		
		googleResultPage.getNavigationBar().goToNews();
		System.out.println(googleResultPage.getResultStat().getStat());
	}
	
	@DataProvider
	public Object[][] getData(){
		return new Object[][] {
			{"selenium",3},
			{"docker",2}
		};
	}
	
	@DataProvider
	public Object[][] getLanguage(){
		return new Object[][] {
			{"English"},
			{"French"},
			{"Arabic"}
		};
	}
}
