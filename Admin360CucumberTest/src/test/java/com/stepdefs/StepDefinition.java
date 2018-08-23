	package com.stepdefs;
	
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import cucumber.api.java.en.Given;
	import cucumber.api.java.en.Then;
	
	
	public class StepDefinition 
	{
	
	    public static WebDriver driver=null;
	
	   @Given("^url opened$")
	   public void url_opened() 
	    {
	    	System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
	    	driver = new ChromeDriver();
	    	driver.manage().window().maximize();
	    	driver.get("http://admin360.in/");
	    }
	
	   @Then("^click Login$")
	   public void click_Login() throws InterruptedException 
	   {
		   driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div[1]/ul/li[1]/a")).click();
	       Thread.sleep(2000);
	   }
	
	   @Then("^enter user id and click continue$")
	   public void enter_user_id_and_click_continue() throws InterruptedException 
	   {
		   driver.findElement(By.id("username")).sendKeys("vaishali");
		   driver.findElement(By.id("btn-login")).click();
	       Thread.sleep(4000);
	   }
	
	   
	   @Then("^enter password$")
	   public void enter_password() 
	   {
		   driver.findElement(By.id("password")).sendKeys("vaishali@1");
	   }
	
	   @Then("^click login$")
	   public void click_login() throws InterruptedException 
	   {
		   driver.findElement(By.id("btn-login")).click();
	       Thread.sleep(6000);
	   }
	
	   @Then("^Close browser$")
	   public void close_browser() 
	   {
	     // driver.quit();
	   }
	
	}