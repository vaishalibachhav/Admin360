package com.mytest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

	public class Student_Batch extends Login
	{
		String course_pattern = "\\d*";
		String batch_pattern = "([a-zA-Z]*[0-9]*[-]*)*";
		
	  @Test
	  public void Add_Course() throws InterruptedException 
	  {
		  driver.findElement(By.xpath("//*[@id=\"nav-state-toggle\"]/i")).click();
		  driver.findElement(By.xpath("//*[@id=\"2\"]/li[1]/a")).click();
		  driver.findElement(By.xpath("//*[@id=\"btn-new-course\"]")).click();
		  driver.findElement(By.name("CourseName")).sendKeys("DOT NET");
		  driver.findElement(By.id("txtcourseamount")).sendKeys("27000");
		  driver.findElement(By.xpath("//*[@id=\"btn-save-course\"]")).click();
		  
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//*[@id=\"2\"]/li[3]/a")).click();
		  Thread.sleep(1500);
		  driver.findElement(By.xpath("//*[@id=\"btn-new-course\"]")).click();
		  driver.findElement(By.name("BatchName")).sendKeys("11 to 12");
		  Select drpcourse = new Select(driver.findElement(By.name("CourseId")));
		  drpcourse.selectByVisibleText("DOT NET");
		  driver.findElement(By.name("BatchSize")).sendKeys("25");
		  driver.findElement(By.id("btn-save-batch")).click();
		
		  Thread.sleep(1500);
		  driver.findElement(By.xpath("//*[@id=\"sidebar\"]/div/div[1]/ul[1]/li[2]/a")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//*[@id=\"4\"]/li[1]/a")).click();
		  driver.findElement(By.name("FirstName")).sendKeys("Akash");
		  driver.findElement(By.name("MiddleName")).sendKeys("Ashok");
		  driver.findElement(By.name("LastName")).sendKeys("Ahire");
		  driver.findElement(By.id("College")).sendKeys("KTHM");
		  driver.findElement(By.id("Qualification")).sendKeys("MCS");
		  driver.findElement(By.id("AddharNo")).sendKeys("8520147963012458");
		  driver.findElement(By.id("DateOfBirth")).sendKeys("01/11/1992");
		  Select drpgenderlistad = new Select(driver.findElement(By.name("Gender")));
		  drpgenderlistad.selectByVisibleText("Male");
		  driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/ul/li[2]/button")).click();
		  
		  driver.findElement(By.id("MobilePrimary")).sendKeys("8520147963");
		  driver.findElement(By.id("MobileSecondary")).sendKeys("9999999999");
		  driver.findElement(By.id("EmailPrimary")).sendKeys("akash@gmail.com");
		  driver.findElement(By.id("EmailSecondary")).sendKeys("akash11@gmail.com");
		  driver.findElement(By.name("CurrentAddress")).sendKeys("Flat no-03,Ganesh Appartment, Near Prasad Circle,Gangapur Road,Nashik");
		  driver.findElement(By.name("PermanentAddress")).sendKeys("Flat no-03,Ganesh Appartment, Near Prasad Circle,Gangapur Road,Nashik");
		  driver.findElement(By.id("PinCodeCurrentAddress")).sendKeys("422222");
		  driver.findElement(By.id("PinCodePermanentAddress")).sendKeys("422222");
		  Select documentnwadd = new Select(driver.findElement(By.id("Document-list")));
		  documentnwadd.selectByVisibleText("Addhar Card");
		  driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/ul/li[2]/button")).click();
		  
		  Select course = new Select(driver.findElement(By.name("course-list")));
		  course.selectByVisibleText("DOT NET");
		  driver.findElement(By.name("Discount")).sendKeys("10");
		 driver.findElement(By.xpath("//*[@id=\"nav-state-toggle\"]/i")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/ul/li[2]/button")).click();
		  driver.findElement(By.xpath("//*[@id=\"btn-save\"]")).click();
		  
	  }
	  
	  //Student Batch
	  //Course
	  @Test
	  public void Blank_Course() throws InterruptedException
	  {
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//*[@id=\"nav-state-toggle\"]/i")).click();
		  Thread.sleep(1500);
		  driver.findElement(By.xpath("//*[@id=\"sidebar\"]/div/div[1]/ul[1]/li[2]/a")).click();
		  Actions action = new Actions(driver);
		  WebElement we = driver.findElement(By.xpath("//*[@id=\"11\"]/li/a"));
		  action.moveToElement(we).moveToElement(driver.findElement(By.xpath("//*[@id=\"11\"]/li/a"))).click().build().perform();
		 
		  Thread.sleep(2000);
		  driver.findElement(By.id("btn-save-batch")).click();
		  
		  String actual = driver.findElement(By.xpath("/html/body/ul/li[1]/div/div")).getText();
		  String expected = "Select atleast one menu and try again.";
		  Assert.assertEquals(actual, expected, "Course accepted blank Field");
	  }
	 
	  @Test
	  public void Blank_Batch()
	  {
		  String actual = driver.findElement(By.xpath("/html/body/ul/li[1]/div/div")).getText();
		  String expected = "Select atleast one menu and try again.";
		  Assert.assertEquals(actual, expected, "Batch Accepted Blank Field");
	  }
	  
	  @Test
	  public void Course()
	  {
		  Select course = new Select(driver.findElement(By.id("course-list")));
		  course.selectByVisibleText("DOT NET");
		  boolean drpcourse =driver.findElement(By.id("course-list")).getAttribute("value").matches(course_pattern);
		  Assert.assertTrue(drpcourse, "Course Field NOT Working");
		  
	  }
	  
	  @Test
	  public void Batch() throws InterruptedException
	  {
		  Select drpbatch = new Select(driver.findElement(By.name("BatchId")));
		  drpbatch.selectByVisibleText("11 to 12");
		  boolean drpcourse =driver.findElement(By.name("BatchId")).getAttribute("value").matches(batch_pattern);
		  Assert.assertTrue(drpcourse, "Batch Field NOT Working");
		  Thread.sleep(500);
		  driver.findElement(By.id("checkbox2-0")).click();
	  }
	 
	  @Test
	  public void Save_Button_Functionality() throws InterruptedException
	  {
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("/html/body/ul/li/div/button")).click();
		  driver.findElement(By.id("btn-save-batch")).click();
		  
	  }
	  
	}
