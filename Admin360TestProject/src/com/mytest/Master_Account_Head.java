package com.mytest;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

	public class Master_Account_Head extends Login
	{
	  
		String accounthead_pattern = "([^-\\s][a-zA-Z ]*[0-9]*[$&+,:;=?@#|'<>.^*()%!-]*)+(\\s)*";
		String accounttype_pattern = "\\b(true|false)\\b";
		
	  @Test
	  	public void Account_Head_contain_special_characters() 
		{
		  	driver.findElement(By.xpath("//*[@id=\"nav-state-toggle\"]/i")).click();
		  	driver.findElement(By.xpath("//*[@id=\"2\"]/li[2]/a")).click();
		  	driver.findElement(By.xpath("//*[@id=\"btn-new-course\"]")).click();
			driver.findElement(By.name("AccountTitle")).sendKeys("!@#$%^&*");
			boolean accounthead =driver.findElement(By.name("AccountTitle")).getAttribute("value").matches(accounthead_pattern);
			Assert.assertTrue(accounthead, "Account Head Contains Special Characters");
		 }
		
		@Test
		public void Account_Head_contain_numbers()
		{
		    driver.findElement(By.name("AccountTitle")).clear();
		    driver.findElement(By.name("AccountTitle")).sendKeys("025547");
			boolean accounthead =driver.findElement(By.name("AccountTitle")).getAttribute("value").matches(accounthead_pattern);
			Assert.assertTrue(accounthead, "Account Head Contains Numbers");
		}
	
		@Test
		public void Account_Head_contain_whitespaces()
		{
		    driver.findElement(By.name("AccountTitle")).clear();
		    driver.findElement(By.name("AccountTitle")).sendKeys("Office Rent");
			boolean accounthead =driver.findElement(By.name("AccountTitle")).getAttribute("value").matches(accounthead_pattern);
			Assert.assertTrue(accounthead, "Account Head Contains Whitespaces");
		}
		
		@Test
	  	public void Account_Head_contain_alphabets() 
		{
			driver.findElement(By.name("AccountTitle")).clear();
			driver.findElement(By.name("AccountTitle")).sendKeys("Rent");
			boolean accounthead =driver.findElement(By.name("AccountTitle")).getAttribute("value").matches(accounthead_pattern);
			Assert.assertTrue(accounthead, "Account Head Contain Alphabets");
		}
		
		@Test
	  	public void Account_Head_contain_whitespaces_at_begining() 
		{
			driver.findElement(By.name("AccountTitle")).clear();
			driver.findElement(By.name("AccountTitle")).sendKeys("   Rent");
			boolean accounthead =driver.findElement(By.name("AccountTitle")).getAttribute("value").matches(accounthead_pattern);
			Assert.assertTrue(accounthead, "Account Head Contain Whitespaces at Begining");
		}
		
		@Test
	  	public void Account_Head_field_is_Blank() 
		{
			driver.findElement(By.name("AccountTitle")).clear();
			driver.findElement(By.xpath("//*[@id=\"btn-save-account-type\"]")).click();
			driver.findElement(By.xpath("//*[@id=\"btn-save-account-type\"]")).click();
			String actual = driver.findElement(By.xpath("//*[@id=\"parsley-id-4\"]/li")).getText();
			String expected = "This value is required.";
			Assert.assertEquals(actual, expected, "Account Head acceoted Blank Field");
		}
		
		//Account Type
		@Test
		public void Blank_Account_Type()
		{
			String actual = driver.findElement(By.xpath("//*[@id=\"parsley-id-6\"]/li")).getText();
			String expected = "This value is required.";
			Assert.assertEquals(actual, expected, "Account Type Accepted Blank Field");
		}
		
		@Test
		public void Account_Type()
		{
			Select drpaccunttype = new Select(driver.findElement(By.id("ddlIsCredit")));
			drpaccunttype.selectByVisibleText("Debit");
			boolean accounttype =driver.findElement(By.id("ddlIsCredit")).getAttribute("value").matches(accounttype_pattern);
			Assert.assertTrue(accounttype, "Account Type Field NOT Working ");
		}
		
		//Save Changes Button
		@Test
		public void Save_Changes_Button_Functionalty() throws InterruptedException
		{
			driver.findElement(By.name("AccountTitle")).sendKeys("Rent");
			driver.findElement(By.id("btn-save-account-type")).click();
			Thread.sleep(1000);
			String actualaccounthead = driver.findElement(By.xpath("//*[@id=\"view-account-type\"]/tbody/tr[3]/td[1]")).getText();
			String actualaccounttype = driver.findElement(By.xpath("//*[@id=\"view-account-type\"]/tbody/tr[3]/td[2]")).getText();
			Assert.assertEquals(actualaccounthead, "Rent", "Account Head NOT Getting Saved");
			Assert.assertEquals(actualaccounttype, "Debit", "Account Type NOT Getting Saved");
		}
		
		@Test
		public void Account_Head_Cancel_Button_Functionality() throws InterruptedException
		{
		  	driver.findElement(By.xpath("//*[@id=\"btn-new-course\"]")).click();
		  	driver.findElement(By.id("btn-cancel")).click();
		  	Thread.sleep(1000);
		  	String actual = driver.getCurrentUrl();
		  	String expected = "https://app.admin360.in/06-10-view-account-type.html";
		  	Assert.assertEquals(actual, expected, "Cancel Button NOT Working");
		}
		
		//Update
		@Test
		public void Update_Account_Head() throws InterruptedException
		{
			driver.findElement(By.xpath("//*[@id=\"view-account-type\"]/tbody/tr[3]/td[3]/button[1]/i")).click();
			driver.findElement(By.name("AccountTitle")).clear();
			driver.findElement(By.name("AccountTitle")).sendKeys("Electricity Bill");
			Select drpaccunttype = new Select(driver.findElement(By.id("ddlIsCredit")));
			drpaccunttype.selectByVisibleText("Credit");
			driver.findElement(By.id("btn-update-account-type")).click();
			Thread.sleep(1000);
			String actualaccounthead = driver.findElement(By.xpath("//*[@id=\"view-account-type\"]/tbody/tr[5]/td[1]")).getText();
			String actualaccounttype = driver.findElement(By.xpath("//*[@id=\"view-account-type\"]/tbody/tr[5]/td[2]")).getText();
			Assert.assertEquals(actualaccounthead, "Electricity Bill", "Account Head NOT Getting Saved");
			Assert.assertEquals(actualaccounttype, "Credit", "Account Type NOT Getting Saved");
		}
		
		@Test
		public void Update_Cancel_Button_Functionality() throws InterruptedException
		{
			driver.findElement(By.xpath("//*[@id=\"view-account-type\"]/tbody/tr[3]/td[3]/button[1]/i")).click();
			driver.findElement(By.id("btn-cancel")).click();
			Thread.sleep(1000);
		  	String actual = driver.getCurrentUrl();
		  	String expected = "https://app.admin360.in/06-10-view-account-type.html";
		  	Assert.assertEquals(actual, expected, "Cancel Button NOT Working");
		}
		
		//Delete
		@Test
		public void Delete_Cancel_Button_Functionality() throws InterruptedException
		{
			driver.findElement(By.xpath("//*[@id=\"view-account-type\"]/tbody/tr[5]/td[3]/button[2]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"myModal18\"]/div/div/div[2]/button[1]")).click();
			Thread.sleep(1500);
			String actualaccounthead = driver.findElement(By.xpath("//*[@id=\"view-account-type\"]/tbody/tr[5]/td[1]")).getText();
			String actualaccounttype = driver.findElement(By.xpath("//*[@id=\"view-account-type\"]/tbody/tr[5]/td[2]")).getText();
			Assert.assertEquals(actualaccounthead, "Electricity Bill", "Account Head NOT Getting Deleted");
			Assert.assertEquals(actualaccounttype, "Credit", "Account Type NOT Getting Deleted");
		}
		
		@Test
		public void Delete_Account_Head() throws InterruptedException
		{
			driver.findElement(By.xpath("//*[@id=\"view-account-type\"]/tbody/tr[5]/td[3]/button[2]")).click();
			Thread.sleep(1500);
			driver.findElement(By.xpath("//*[@id=\"remove-accounttype\"]")).click();
			Thread.sleep(1500);
			String actualaccounthead = driver.findElement(By.xpath("//*[@id=\"view-account-type\"]/tbody/tr[5]/td[1]")).getText();
			String actualaccounttype = driver.findElement(By.xpath("//*[@id=\"view-account-type\"]/tbody/tr[5]/td[2]")).getText();
			Assert.assertEquals(actualaccounthead, "Bravages", "Account Head NOT Getting Deleted");
			Assert.assertEquals(actualaccounttype, "Debit", "Account Type NOT Getting Deleted");
		
		}
	}
