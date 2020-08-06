package com.selenium.srp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.selenium.srp.common.AbstractComponent;

public class NavigationBar extends AbstractComponent{

	@FindBy(id="hdtb")
	private WebElement bar;
	
	@FindBy(linkText="News")
	private WebElement news;
	
	@FindBy(linkText="Images")
	private WebElement images;
	
	public NavigationBar(WebDriver driver) {
		super(driver);
	}
	
	public void goToImages() {
		this.images.click();
	}
	
	public void goToNews() {
		this.news.click();
	}

	@Override
	public boolean isDisplayed() {
		return this.wait.until((d)->this.bar.isDisplayed());
	}
	
	

}
