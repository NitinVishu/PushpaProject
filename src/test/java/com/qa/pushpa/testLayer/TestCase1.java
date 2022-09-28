package com.qa.pushpa.testLayer;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.pushpa.pageLayer.PushpaWiki;
import com.qa.pushpa.testBaseLayer.TestBase;

public class TestCase1 extends TestBase {
	
	@Test(priority=1)
	public void detailsValidation() throws InterruptedException {		
		pushpaImdb.imdb();
		pushpaImdb.enterMovName("Pushpa: The Rise - Part 1");
		pushpaImdb.ClickResult1();
		pushpaImdb.scrollDown();
		pushpaImdb.clickOnDate();
		Thread.sleep(2000);
		
		System.out.println(pushpaImdb.statusRelease());
		pushpaImdb.navigateBack();
		Thread.sleep(1500);
		System.out.println(pushpaImdb.statusCountryIMDB());
		Thread.sleep(1500);
	}
	
	@Test(priority=2)
	public void detailsFromWiki() throws InterruptedException {
		pushpaWik.wiki();
		pushpaWik.searchMovie("Pushpa: The Rise - Part 1");
		pushpaWik.scrollDown();	
		
		
		pushpaWik.statusRelWik();
		pushpaWik.statusCountryWiki();
		
		System.out.println(pushpaWik.statusRelWik());
		System.out.println(pushpaWik.statusCountryWiki());
	}
	
	@Test(priority=3)
	public void ValidationOfCountry() throws InterruptedException {
		//Details from IMDB
		pushpaImdb.imdb();
		pushpaImdb.enterMovName("Pushpa: The Rise - Part 1");
		pushpaImdb.ClickResult1();
		Thread.sleep(700);
		pushpaImdb.scrollDown();
		Thread.sleep(700);

		Thread.sleep(1500);
		pushpaImdb.statusCountryIMDB();
		System.out.println("Country from IMDB: "+pushpaImdb.statusCountryIMDB());
		Thread.sleep(2000);
		
		
		//details from Wikipedia
		pushpaWik.wiki();
		Thread.sleep(1500);
		pushpaWik.searchMovie("Pushpa: The Rise - Part 1");
		Thread.sleep(1500);
		pushpaWik.statusRelWik();
		Thread.sleep(1500);
		pushpaWik.statusCountryWiki();
		System.out.println("Country from Wikipedia: "+pushpaWik.statusCountryWiki());
		Thread.sleep(1500);
		
		//Assertion for Country validation
		Assert.assertEquals(pushpaImdb.statusCountryIMDB(), pushpaWik.statusCountryWiki());
		System.out.println("WOW....Country Validation is passed..!!");
		
	}
	
	@Test(priority=4)
	public void validationOfReleaseDate() throws InterruptedException {
		
						//Details from IMDB
		
		pushpaImdb.imdb();
		pushpaImdb.enterMovName("Pushpa: The Rise - Part 1");
		pushpaImdb.ClickResult1();
		Thread.sleep(700);
		pushpaImdb.scrollDown();
		Thread.sleep(700);
		pushpaImdb.clickOnDate();
		Thread.sleep(2000);
		//pushpaImdb.scrollDown();
		pushpaImdb.statusRelease();
		System.out.println("Release date from IMDB: "+pushpaImdb.statusRelease());
		pushpaImdb.navigateBack();
		Thread.sleep(1500);
		pushpaImdb.statusCountryIMDB();
		System.out.println(pushpaImdb.statusCountryIMDB());
		Thread.sleep(2000);
				
				
						//details from Wikipedia
		
		pushpaWik.wiki();
		Thread.sleep(1500);
		pushpaWik.searchMovie("Pushpa: The Rise - Part 1");
		Thread.sleep(1500);
		pushpaWik.scrollDown();		
		Thread.sleep(700);
		pushpaWik.statusRelWik();
		Thread.sleep(700);
		pushpaWik.statusCountryWiki();
		
		
				
		
//		System.out.println(pushpaImdb.statusRelease());
		Thread.sleep(700);
		System.out.println("Release date from IMDB: "+pushpaWik.statusRelWik());
		Thread.sleep(700);
		
		
		//Assertion for release Date validation
		Assert.assertEquals(pushpaImdb.statusRelease(), pushpaWik.statusRelWik());
	}

}
