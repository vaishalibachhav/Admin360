package com.mytest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

	public class Trainer_Batch extends Login
	{
		String trainer_pattern = "\\d*";
		String course_pattern = "\\d*";
		String incentive_pattern = "\\s*\\d*";
		
	  @Test
	  public void Add_Employee() throws InterruptedException 
	  {
		  //Course
		  Thread.sleep(1500);
		  driver.findElement(By.xpath("//*[@id=\"nav-state-toggle\"]/i")).click();
		  driver.findElement(By.xpath("//*[@id=\"2\"]/li[1]/a")).click();
		  driver.findElement(By.xpath("//*[@id=\"btn-new-course\"]")).click();
		  driver.findElement(By.name("CourseName")).sendKeys("DOT NET");
		  driver.findElement(By.id("txtcourseamount")).sendKeys("27000");
		  driver.findElement(By.xpath("//*[@id=\"btn-save-course\"]")).click();
		  
		  //Batch
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//*[@id=\"2\"]/li[3]/a")).click();
		  Thread.sleep(1500);
		  driver.findElement(By.xpath("//*[@id=\"btn-new-course\"]")).click();
		  driver.findElement(By.name("BatchName")).sendKeys("11 to 12");
		  Select drpcourse = new Select(driver.findElement(By.name("CourseId")));
		  drpcourse.selectByVisibleText("DOT NET");
		  driver.findElement(By.name("BatchSize")).sendKeys("25");
		  driver.findElement(By.id("btn-save-batch")).click();
		  
		  //Employee
		  Thread.sleep(1500);
		  driver.findElement(By.xpath("//*[@id=\"2\"]/li[5]/a")).click();
		  Thread.sleep(1500);
		  driver.findElement(By.xpath("//*[@id=\"btn-new-course\"]")).click();
		  Thread.sleep(1500);
		  driver.findElement(By.name("EmployeeName")).sendKeys("Rajashree");
		  driver.findElement(By.name("MoblileNumber")).sendKeys("9630124587");
		  driver.findElement(By.name("Designation")).sendKeys("Trainer");
		  driver.findElement(By.name("EmailId")).sendKeys("rajashree@gmail.com");
		  driver.findElement(By.name("Incentive")).sendKeys("25000");
		  Select drpgenderlist = new Select(driver.findElement(By.name("Gender")));
		  drpgenderlist.selectByVisibleText("Female");
		  driver.findElement(By.name("Address")).sendKeys("Flat no-15,Ganesh Appartment, Near Prasad Circle,Gangapur Road,Nashik");
		  driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/ul/li[2]/button")).click();
		
		  driver.findElement(By.name("UserName")).sendKeys("Rajashree");
		  Select drprole = new Select(driver.findElement(By.name("EmpRoleId")));
		  drprole.selectByVisibleText("Admin");
		  driver.findElement(By.name("Password")).sendKeys("123");
		  driver.findElement(By.name("ConfirmPassword")).sendKeys("123");
		  driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/ul/li[2]/button")).click();
		  driver.findElement(By.xpath("//*[@id=\"btn-save\"]")).click();
	  }
	  
	  //Trainer
	  @Test
	  public void Blank_Trainer() throws InterruptedException
	  {
		 Thread.sleep(1500);
		 Actions action = new Actions(driver);
		 WebElement we = driver.findElement(By.xpath("//*[@id=\"10\"]/li/a"));
		 action.moveToElement(we).moveToElement(driver.findElement(By.xpath("//*[@id=\"10\"]/li/a"))).click().build().perform();
		 Thread.sleep(2000);
		 driver.navigate().refresh();
		 driver.findElement(By.xpath("//*[@id=\"nav-state-toggle\"]/i")).click();
		 Thread.sleep(4000);
		 driver.findElement(By.xpath("//*[@id=\"btn-assign-trainer-batch\"]")).click();
		 String actual = driver.findElement(By.xpath("//*[@id=\"parsley-id-2\"]/li")).getText();
		 String expected = "Please Select Trainer";
		 Assert.assertEquals(actual, expected, "Trainer Accepted Blank Field");
	  }
	  
	  @Test
	  public void Trainer()
	  {
		  Select drptrainer = new Select(driver.findElement(By.name("TrainerId")));
		  drptrainer.selectByVisibleText("Rajashree");  
		  boolean trainer =driver.findElement(By.name("TrainerId")).getAttribute("value").matches(trainer_pattern);
		  Assert.assertTrue(trainer, "Trainer Not Valid");
	  }
	  
	  //Course
	  @Test
	  public void Blank_Course()
	  {
		  String actual = driver.findElement(By.xpath("//*[@id=\"parsley-id-4\"]/li")).getText();
		  String expected = "Please Select Course";
		  Assert.assertEquals(actual, expected, "Course Accepted Blank Field");
	  }
	  
	  @Test
	  public void Course()
	  {
		  Select drptrainer = new Select(driver.findElement(By.name("CourseId")));
		  drptrainer.selectByVisibleText("DOT NET");
		  boolean course =driver.findElement(By.name("CourseId")).getAttribute("value").matches(course_pattern);
		  Assert.assertTrue(course, "Course Not Valid");
	  }
	  
	  
	  //Incentive
		@Test
		public void Incentive_contain_special_characters()
		{
			driver.findElement(By.id("CourseIncentive0")).sendKeys("!@#$%^&*()");
			boolean incentive =driver.findElement(By.id("CourseIncentive0")).getAttribute("value").matches(incentive_pattern);
			Assert.assertTrue(incentive, "Incentive Contains Spaecial Characters");
		}
	
		@Test
		public void Incentive_contain_whitespaces()
		{
			driver.findElement(By.id("CourseIncentive0")).clear();
			driver.findElement(By.id("CourseIncentive0")).sendKeys("200 00");
			boolean incentive =driver.findElement(By.id("CourseIncentive0")).getAttribute("value").matches(incentive_pattern);
			Assert.assertTrue(incentive, "Incentive Contains Whitespaces");
		}
		
		@Test
		public void Incentive_contain_alphabets()
		{
			driver.findElement(By.id("CourseIncentive0")).clear();
			driver.findElement(By.id("CourseIncentive0")).sendKeys("Twenty Thousand");
			boolean incentive =driver.findElement(By.id("CourseIncentive0")).getAttribute("value").matches(incentive_pattern);
			Assert.assertTrue(incentive, "Incentive Contains Alphabets");
		}
		
		@Test
		public void Incentive_contain_numbers()
		{
			driver.findElement(By.id("CourseIncentive0")).clear();
			driver.findElement(By.id("CourseIncentive0")).sendKeys("25000");
			boolean incentive =driver.findElement(By.id("CourseIncentive0")).getAttribute("value").matches(incentive_pattern);
			Assert.assertTrue(incentive, "Incentive Contains Numbers");
		}
		
		@Test
		public void Incentive_contain_negative_numbers()
		{
			driver.findElement(By.id("CourseIncentive0")).clear();
			driver.findElement(By.id("CourseIncentive0")).sendKeys("-21000");
			boolean incentive =driver.findElement(By.id("CourseIncentive0")).getAttribute("value").matches(incentive_pattern);
			Assert.assertTrue(incentive, "Incentive Contains Negative Numbers");
		}
		
		@Test
	  	public void Incentive_contain_whitespaces_at_begining() 
		{
			driver.findElement(By.id("CourseIncentive0")).clear();
			driver.findElement(By.id("CourseIncentive0")).sendKeys("  20000");
			boolean incentive =driver.findElement(By.id("CourseIncentive0")).getAttribute("value").matches(incentive_pattern);
			Assert.assertTrue(incentive, "Incentive Contains Whitespaces at begining");
		}	
		
		//Batch Checkbox
		@Test
		public void Blank_Checkbox()
		{
			driver.findElement(By.xpath("//*[@id=\"btn-assign-trainer-batch\"]")).click();
			
		}
	  
		@Test
		public void Checkbox() throws InterruptedException
		{
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"checkbox2-0\"]")).click();
			driver.findElement(By.xpath("//*[@id=\"btn-assign-trainer-batch\"]")).click();
			Thread.sleep(2000);
			String actual = driver.findElement(By.xpath("//*[@id=\"success\"]/div/div/div[1]/p")).getText();
			String expected = "Trainer batch saved successfully.";
			Assert.assertEquals(actual, expected, "Trainer Batch NOT Getting Saved");
			driver.findElement(By.xpath("//*[@id=\"remove-accounttype\"]")).click();
		}
	}
