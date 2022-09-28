package com.qa.pushpa.pageLayer;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.pushpa.testBaseLayer.TestBase;

public class PushpaIMDB extends TestBase {
	
	public PushpaIMDB() {
		PageFactory.initElements(driver, this);
	}
	
	public void imdb() {
		driver.get("https://www.imdb.com/");
	}
	
	@FindBy(xpath="//input[@placeholder='Search IMDb']")
	private WebElement search_box;
	public void enterMovName(String imdbName) {
		search_box.sendKeys(imdbName+Keys.ENTER);
	}
	
	@FindBy(xpath="//a[text()='Pushpa: The Rise - Part 1']")
	private WebElement search_rslt1;
	public void ClickResult1() throws InterruptedException {
		search_rslt1.click();
		Thread.sleep(1500);
	}
	
	@FindBy(xpath="//a[text()='December 17, 2021 (United States)']")
	private WebElement scroll_down;
	public void scrollDown() throws InterruptedException {
		Point pc = scroll_down.getLocation();
		System.out.println(pc);
		int y = pc.getY();
		Thread.sleep(1500);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 6146)");
		Thread.sleep(1500);
		
	}
	
	
	@FindBy(xpath="//a[text()='December 17, 2021 (United States)']")
	private WebElement relDate_click;
	public void clickOnDate() throws InterruptedException {		
		relDate_click.click();	
		Thread.sleep(1500);
	}
	
	@FindBy(xpath="//td[text()='17 December 2021']")
	private WebElement statusRelease_imdb;
	public String statusRelease() {
		String releaseIMDB = statusRelease_imdb.getText();
		return releaseIMDB;		
	}
	
	public void navigateBack() {
		driver.navigate().back();
	}
	
	@FindBy(xpath="//a[text()='India']")
	private WebElement statusCountry_imdb;
	public String statusCountryIMDB() {
		String countryIMDB=statusCountry_imdb.getText();
		return countryIMDB;
	}

}
