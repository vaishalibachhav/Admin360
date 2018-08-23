package com.mytest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

	public class Assign_RFID extends Login
	{
	  @Test
	  public void Add_Admission() throws InterruptedException 
	  {
		  //Course
		  driver.findElement(By.xpath("//*[@id=\"nav-state-toggle\"]/i")).click();
		  driver.findElement(By.xpath("//*[@id=\"2\"]/li[1]/a")).click();
		  driver.findElement(By.xpath("//*[@id=\"btn-new-course\"]")).click();
		  driver.findElement(By.name("CourseName")).sendKeys("DOT NET");
		  driver.findElement(By.id("txtcourseamount")).sendKeys("27000");
		  driver.findElement(By.xpath("//*[@id=\"btn-save-course\"]")).click();
		  
		  //Admission
		  Thread.sleep(1500);
		  driver.findElement(By.xpath("//*[@id=\"sidebar\"]/div/div[1]/ul[1]/li[2]/a")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//*[@id=\"4\"]/li[1]/a")).click();
		  driver.findElement(By.xpath("//*[@id=\"btn-new-admission\"]")).click();
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
	  
	  //Assign RFID
	  @Test
	  public void Blank_RFID() throws InterruptedException
	  {
		 Thread.sleep(1700);
		 driver.findElement(By.xpath("//*[@id=\"nav-state-toggle\"]/i")).click();
		 Actions action = new Actions(driver);
		 WebElement we = driver.findElement(By.xpath("//*[@id=\"14\"]/li[2]/a"));
		 action.moveToElement(we).moveToElement(driver.findElement(By.xpath("//*[@id=\"14\"]/li[2]/a"))).click().build().perform();
		 Thread.sleep(1700);
		 driver.findElement(By.name("save-RfidNo")).click();
		 driver.findElement(By.name("save-RfidNo")).click();
		 String actual = driver.findElement(By.xpath("//*[@id=\"parsley-id-4\"]/li")).getText();
		 String expected = "This value is required.";
		 Assert.assertEquals(actual, expected, "RFID Accept Blank Field");
	  }
	  
	  @Test
	  public void Valid_Assign_RFID()
	  {
		  driver.findElement(By.name("RfidNo")).sendKeys("001");
		  
	  }
	  
	}
