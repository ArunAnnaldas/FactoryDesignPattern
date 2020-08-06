package com.selenium.srp.common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.google.common.util.concurrent.Uninterruptibles;

public class SearchWidget extends AbstractComponent {

	@FindBy(name="q")
	private WebElement searchBox;
	
	public SearchWidget(final WebDriver driver) {
		super(driver);
	}

	@Override
	public boolean isDisplayed() {
		return this.wait.until((d)->this.searchBox.isDisplayed());
	}
	
	public void enter(String text) {
		this.searchBox.clear();
		for(char ch : text.toCharArray()) {
			Uninterruptibles.sleepUninterruptibly(20, TimeUnit.MILLISECONDS);
			this.searchBox.sendKeys(ch+"");
		}
	}
}
