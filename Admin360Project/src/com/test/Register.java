package com.test;


import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



public class Register {
	
	
	private WebDriver driver;
	  private String baseUrl;


	  @Before
	  public void setUp() throws Exception {
		  System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
	    driver = new ChromeDriver();
	    baseUrl = "http://admin360.in/";
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test
	  public void testA() throws Exception {
		  driver.get(baseUrl);
			
			driver.findElement(By.linkText("Register")).click();
			driver.findElement(By.name("SubscribrerName")).sendKeys("vaishali");
			driver.findElement(By.name("SubscriberMobileNo")).sendKeys("7894561230");
			driver.findElement(By.id("emailId")).sendKeys("TECH22@gmail.com");
			driver.findElement(By.id("pass")).sendKeys("1234");
			driver.findElement(By.id("confirmPass")).sendKeys("1234");
			driver.findElement(By.id("btn-Register")).click();
			
			
			driver.findElement(By.id("username")).sendKeys("TECH22@gmail.com");
			driver.findElement(By.id("btn-login")).click();
			//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			//Branch
			
			driver.findElement(By.name("BranchName")).sendKeys("Techbona");
			driver.findElement(By.name("MobileNo")).sendKeys("3698520147");
			driver.findElement(By.id("emailId")).sendKeys("A111@gmail.com");
			driver.findElement(By.name("Address")).sendKeys("Pune");
			driver.findElement(By.name("BranchLocation")).sendKeys("Pune");
			
		    driver.findElement(By.xpath("//*[@id=\"fm-register\"]/div[6]/div/span/input")).sendKeys("C:\\Users\\Public\\Pictures\\Sample Pictures\\Tulips.jpg");
		   
		    
			driver.findElement(By.xpath("//*[@id=\"fm-register\"]/div[7]/button")).click();
			driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("TECH22@gmail.com");
			driver.findElement(By.id("btn-login")).click();
			
			Select drpbranchlist = new Select(driver.findElement(By.id("branch-list")));
			drpbranchlist.selectByVisibleText("Techbona");
			driver.findElement(By.id("password")).sendKeys("1234");
			driver.findElement(By.id("btn-login")).click();
	  }

}



