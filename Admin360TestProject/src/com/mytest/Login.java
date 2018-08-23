package com.mytest;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
	
	public class Login 
	
	{
		public static WebDriver driver;
		public String baseUrl;
		public WebElement html;
		
		@Test
		public void login() throws InterruptedException 
		
		{
			 System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
			 driver = new ChromeDriver();
			 baseUrl = "http://admin360.in/";
			 driver.manage().window().maximize();
			
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			 driver.get(baseUrl);
			 driver.navigate().to("http://admin360.in/login.html");
			 driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("vaishali@1");
			 driver.findElement(By.xpath("//*[@id=\"btn-login\"]")).click();
			 /*Select drpbranchlist = new Select(driver.findElement(By.id("branch-list")));
			 drpbranchlist.selectByVisibleText("tech");*/
			 driver.findElement(By.id("password")).sendKeys("vaishali@1");
			 driver.findElement(By.id("btn-login")).click();
			 Thread.sleep(2000);
		}
	
	}
