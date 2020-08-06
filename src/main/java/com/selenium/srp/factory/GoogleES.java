package com.selenium.srp.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

class GoogleES extends GoogleEnglish{

	public GoogleES(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "div#gws-output-pages-elements-homepage_additional_languages__als a")
	private WebElement language;

	@Override
	public void launchSite() {
		this.driver.get("https://www.google.es");
		this.language.click();
		
	}

	@Override
	public void search(String keyword) {
		super.search(keyword);
		
	}

}
