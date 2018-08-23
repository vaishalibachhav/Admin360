package com.mytest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

	public class ChequeManager extends Login
	{
	  @Test
	  public void Add_Fee_Status() throws InterruptedException 
	  {
		//Course
		  driver.findElement(By.xpath("//*[@id=\"nav-state-toggle\"]/i")).click();
		  driver.findElement(By.xpath("//*[@id=\"sidebar\"]/div/div[1]/ul[1]/li[2]/a")).click();
		  driver.findElement(By.xpath("//*[@id=\"2\"]/li[1]/a")).click();
		  driver.findElement(By.name("new-course")).click();
		  driver.findElement(By.name("CourseName")).sendKeys("DOT NET");
		  driver.findElement(By.id("txtcourseamount")).sendKeys("20000");
		  driver.findElement(By.xpath("//*[@id=\"btn-save-course\"]")).click();
		 
		 //Admission
		  Thread.sleep(1500);
		  driver.findElement(By.xpath("//*[@id=\"sidebar\"]/div/div[1]/ul[1]/li[2]/a")).click();
		  Thread.sleep(1500);
		  driver.findElement(By.xpath("//*[@id=\"4\"]/li[1]/a")).click();
	
		  driver.findElement(By.name("FirstName")).sendKeys("Akash");
		  driver.findElement(By.name("MiddleName")).sendKeys("Ashok");
		  driver.findElement(By.name("LastName")).sendKeys("Ahire");
		  driver.findElement(By.id("College")).sendKeys("KTHM");
		  driver.findElement(By.id("Qualification")).sendKeys("MCS");
		  driver.findElement(By.id("AddharNo")).sendKeys("8520147963012458");
		  driver.findElement(By.id("DateOfBirth")).sendKeys("01/09/1992");
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
		  driver.findElement(By.id("btn-save")).click();
		  
		  //Fee Status
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//*[@id=\"nav-state-toggle\"]/i")).click();
		  Actions action = new Actions(driver);
		  WebElement we = driver.findElement(By.xpath("//*[@id=\"5\"]/li/a"));
		  action.moveToElement(we).moveToElement(driver.findElement(By.xpath("//*[@id=\"5\"]/li/a"))).click().build().perform();
		  driver.findElement(By.xpath("//*[@id=\"view-fee-status\"]/tbody/tr/td[8]/button[1]/i")).click();
		  driver.findElement(By.id("txtNowPaying")).sendKeys("1000");
		  Select paymentmode = new Select(driver.findElement(By.name("PaymentModeId")));
		  paymentmode.selectByVisibleText("Cheque");
		  
		  Select bankname = new Select(driver.findElement(By.name("BankName")));
		  bankname.selectByVisibleText("HDFC BANK LTD");
		  driver.findElement(By.id("txtChequeNo")).sendKeys("965876");
		  driver.findElement(By.name("ChequeDate")).sendKeys("26/08/2018");
		  driver.findElement(By.id("txtIFSCcode")).sendKeys("HDFC0006561");
		  driver.findElement(By.name("NextDueDate")).sendKeys("10/12/2018");
		  driver.findElement(By.name("Note")).sendKeys("1000 Paid");
		  Select paymentclear = new Select(driver.findElement(By.name("PaymentClear")));
		  paymentclear.selectByVisibleText("Yes");
		  driver.findElement(By.name("save-receipt")).click();
		  
	  }
	  
	  @Test
	  public void Cheque_Manager() throws InterruptedException
	  {
		  Thread.sleep(2000);
		  Actions action = new Actions(driver);
		  WebElement w = driver.findElement(By.xpath("//*[@id=\"6\"]/li/a"));
		  action.moveToElement(w).moveToElement(driver.findElement(By.xpath("//*[@id=\"6\"]/li/a"))).click().build().perform();
		  
		  Thread.sleep(1500);
		  String actualchequeno = driver.findElement(By.xpath("//*[@id=\"view-cheque-status\"]/tbody/tr/td[1]")).getText();
		  String actualchequedate = driver.findElement(By.xpath("//*[@id=\"view-cheque-status\"]/tbody/tr/td[2]")).getText();
		  String actualamount = driver.findElement(By.xpath("//*[@id=\"view-cheque-status\"]/tbody/tr/td[3]")).getText();
		  String actualbank = driver.findElement(By.xpath("//*[@id=\"view-cheque-status\"]/tbody/tr/td[4]")).getText();
		  String actualtype = driver.findElement(By.xpath("//*[@id=\"view-cheque-status\"]/tbody/tr/td[5]")).getText();
		  String actualissuedfrom = driver.findElement(By.xpath("//*[@id=\"view-cheque-status\"]/tbody/tr/td[6]")).getText();
		  Assert.assertEquals(actualchequeno, "965876", "Cheque No NOT Getting Saved");
		  Assert.assertEquals(actualchequedate, "26/08/2018", "Cheque Date NOT Getting Saved");
		  Assert.assertEquals(actualamount, "1000", "Cheque Amount NOT Getting Saved");
		  Assert.assertEquals(actualbank, "HDFC BANK LTD", "Bank NOT Getting Saved");
		  Assert.assertEquals(actualtype, "Credit", "Cheque Type NOT Getting Saved");
		  Assert.assertEquals(actualissuedfrom, "Fee Module", "Issued From NOT Getting Saved");
	  }
	  
	  @Test
	  public void Change_Cheque_Status() throws InterruptedException
	  {
		  driver.findElement(By.xpath("//*[@id=\"view-cheque-status\"]/tbody/tr/td[7]/button/i")).click();
		  Select chequestatus = new Select(driver.findElement(By.name("ChequeStatus")));
		  chequestatus.selectByVisibleText("Clear");
		  
		  Actions action = new Actions(driver);
		  WebElement w = driver.findElement(By.xpath("//*[@id=\"remove-course\"]"));
		  action.moveToElement(w).moveToElement(driver.findElement(By.xpath("//*[@id=\"remove-course\"]"))).click().build().perform();
		  driver.findElement(By.xpath("//*[@id=\"remove-course\"]")).click();

		  
		 Thread.sleep(1500);
		 String actual = driver.findElement(By.xpath("//*[@id=\"view-cheque-status\"]/tbody/tr/td")).getText();
		 Assert.assertEquals(actual, "No data available in table", "Cheque Status NOT Change");
	  }
	}
