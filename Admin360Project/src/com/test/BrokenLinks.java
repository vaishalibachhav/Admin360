package com.test;


import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrokenLinks 
{
	
	
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		 WebDriver driver;
		 
	    driver = new ChromeDriver();
		
		//driver.get("http://admin360.in/");
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    
	    driver.navigate().to("http://admin360.in/login.html");
	    System.out.println(driver.getCurrentUrl());
	    driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("techbona@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"btn-login\"]")).click();
		Select drpbranchlist = new Select(driver.findElement(By.id("branch-list")));
		drpbranchlist.selectByVisibleText("tech");
	    driver.findElement(By.id("password")).sendKeys("1234");
		driver.findElement(By.id("btn-login")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
	
		
		System.out.println(driver.getCurrentUrl());
		
		
		List<WebElement> links=driver.findElements(By.tagName("a"));

		System.out.println("Total links"+links.size());
		
		for(int i=0;i<links.size();i++)
		{
			
			WebElement ele= links.get(i);
			
			String url=ele.getAttribute("href");
			
			verifyLinkActive(url);
			
		}
	}

	public static void verifyLinkActive(String linkUrl)
	{
        try 
        {
           URL url = new URL(linkUrl);
           
           HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
           
           httpURLConnect.setConnectTimeout(3000);
           
           httpURLConnect.connect();
           
           if(httpURLConnect.getResponseCode()==200)
            {
               System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
               //System.out.println(httpURLConnect.getResponseMessage());
            }
           
          if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)  
            {
               System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage() + " - "+ HttpURLConnection.HTTP_NOT_FOUND);
            }
          
        } catch (Exception e) 
            {
           
            }
    }
}
