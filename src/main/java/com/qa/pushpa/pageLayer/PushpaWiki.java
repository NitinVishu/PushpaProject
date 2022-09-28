package com.qa.pushpa.pageLayer;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.pushpa.testBaseLayer.TestBase;

public class PushpaWiki extends TestBase{
	
	public PushpaWiki() {
		PageFactory.initElements(driver, this);
	}
	
	public void wiki() {
		driver.get("https://www.wikipedia.org/");
	}
	
	@FindBy(xpath="//input[@id='searchInput']")
	private WebElement searchBx_wiki;
	public void searchMovie(String wikiName) throws InterruptedException {
		searchBx_wiki.sendKeys(wikiName+Keys.ENTER);
		Thread.sleep(1000);
	}
	
	@FindBy(xpath="//li[contains(text(),'December')]")
	private WebElement scrollWiki_down;
	public void scrollDown() throws InterruptedException {
		Point pc = scrollWiki_down.getLocation();
		Thread.sleep(1500);
		System.out.println(pc);
		int y = pc.getY();
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 1081)");
	} 
	
	@FindBy(xpath="//body[1]/div[3]/div[3]/div[5]/div[1]/table[1]/tbody[1]/tr[12]/td[1]/div[1]/ul[1]/li[1]")
	private WebElement statusRelease_wiki;
	public String statusRelWik() {
		String relWiki = statusRelease_wiki.getText();
		return relWiki;
	}
	
	@FindBy(xpath="//td[text()='India']")
	private WebElement statusCountry_wiki;
	public String statusCountryWiki() {
		String StatusContryWiki = statusCountry_wiki.getText();
		return StatusContryWiki;
		
	}

}
