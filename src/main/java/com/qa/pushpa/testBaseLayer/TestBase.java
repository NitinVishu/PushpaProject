package com.qa.pushpa.testBaseLayer;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.qa.pushpa.pageLayer.PushpaIMDB;
import com.qa.pushpa.pageLayer.PushpaWiki;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
	public PushpaIMDB pushpaImdb;
	public PushpaWiki pushpaWik;
	
	
	@BeforeMethod
	public void setUp() {
		
		
		 WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
		 
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		 
		 // object implementation
		 
		  
		 pushpaImdb = new PushpaIMDB();
		 pushpaWik = new PushpaWiki();
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}

}
