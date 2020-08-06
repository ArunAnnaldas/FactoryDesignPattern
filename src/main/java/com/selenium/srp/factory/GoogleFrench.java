package com.selenium.srp.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

class GoogleFrench extends GoogleEnglish {

	@FindBy(xpath="//div[@id='gws-output-pages-elements-homepage_additional_languages__als']//a[1]")
	private WebElement language;
	
	public GoogleFrench(final WebDriver driver) {
		super(driver);
	}

	@Override
	public void launchSite() {
		this.driver.get("https://www.google.fr");
		this.language.click();

	}


}
