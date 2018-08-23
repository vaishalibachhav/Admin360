package com.pkg;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

	public class Course extends Login
	{

		@Test
	  	public void invalid_coursename() 
		
		{
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[@id=\"nav-state-toggle\"]/i")).click();
			driver.findElement(By.xpath("//*[@id=\"sidebar\"]/div/div[1]/ul[1]/li[5]/a/i")).click();
			driver.findElement(By.xpath("//*[@id=\"2\"]/li[1]/a")).click();
			
			driver.findElement(By.name("CourseName")).sendKeys("#^@#!@$%%");
			String CourseName =driver.findElement(By.name("CourseName")).getAttribute("value");
			Pattern pattern = Pattern.compile("[a-zA-Z]*[0-9]*");
		    Matcher matcher = pattern.matcher(CourseName);
		    Validate(matcher);
		   
		}
		
		@Test
		public void valid_coursename() 
		{
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[@id=\"2\"]/li[1]/a")).click();
			driver.findElement(By.xpath("//*[@id=\"sidebar\"]/div/div[1]/ul[1]/li[5]/a/i")).click();
			driver.findElement(By.xpath("//*[@id=\"2\"]/li[1]/a")).click();
			
		    driver.findElement(By.name("CourseName")).clear();
		    driver.findElement(By.name("CourseName")).sendKeys("JAVA");
		    String CourseName1 =driver.findElement(By.name("CourseName")).getAttribute("value");
			CourseName1 =driver.findElement(By.name("CourseName")).getAttribute("value");
			Pattern pattern = Pattern.compile("[a-zA-Z]*[0-9]*");
		    Matcher matcher = pattern.matcher(CourseName1);
		    Validate(matcher);
		
		}
		

		private void Validate(Matcher matcher ) 
		{
			
			 if (!matcher.matches()) 
		      {
		    	   Assert.fail("Course Name NOT Valid");
		    	  
		      } else 
		      {
		           System.out.println("string Course Name doesn't contains special character");
		      }
			 System.out.println("12");
		}

	
	}
