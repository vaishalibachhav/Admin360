package com.mytest;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

	public class Master_Batch extends Login
	{
		String batchname_pattern = "[^(\\s)*]+([a-zA-Z ]*[0-9 ]*[$&+,:;=?@#|'<>.^*()%!-_ ]*)+(\\s)*";
		String course_pattern = "\\d*";
		String batchsize_pattern = "\\d*";
		
	   //Add Course
	  @Test
	  public void Add_Course()
	  {
		  driver.findElement(By.xpath("//*[@id=\"nav-state-toggle\"]/i")).click();
		  driver.findElement(By.xpath("//*[@id=\"2\"]/li[1]/a")).click();
		  driver.findElement(By.xpath("//*[@id=\"btn-new-course\"]")).click();
		  driver.findElement(By.name("CourseName")).sendKeys("DOT NET");
		  driver.findElement(By.id("txtcourseamount")).sendKeys("27000");
		  driver.findElement(By.xpath("//*[@id=\"btn-save-course\"]")).click();
		  driver.findElement(By.xpath("//*[@id=\"btn-new-course\"]")).click();
		  driver.findElement(By.name("CourseName")).sendKeys("HTML");
		  driver.findElement(By.id("txtcourseamount")).sendKeys("25000");
		  driver.findElement(By.xpath("//*[@id=\"btn-save-course\"]")).click();
	  }
		
	  //Batch Name	
	  @Test
	  public void Blank_Batch_Name() throws InterruptedException 
	  {
		  Thread.sleep(1500);
		  driver.findElement(By.xpath("//*[@id=\"2\"]/li[3]/a")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//*[@id=\"btn-new-course\"]")).click();
		  driver.findElement(By.name("save-batch")).click();
		  driver.findElement(By.name("save-batch")).click();
		  String actual = driver.findElement(By.xpath("//*[@id=\"parsley-id-4\"]/li")).getText();
		  String expected = "This value is required.";
		  Assert.assertEquals(actual, expected, "Batch Name Accepted Blank Field");
	  }
	  @Test
	  public void Batch_Name_contain_Spacial_Characters() 
	  {
		  driver.findElement(By.name("BatchName")).clear();
		  driver.findElement(By.name("BatchName")).sendKeys("#$#^%&^&*(");
		  boolean studentname =driver.findElement(By.name("BatchName")).getAttribute("value").matches(batchname_pattern);
		  Assert.assertTrue(studentname, "Batch Name Contains Special Characters");
	  }
	  
	  @Test
	  public void Batch_Name_contain_Numbers() 
	  {
		  driver.findElement(By.name("BatchName")).clear();
		  driver.findElement(By.name("BatchName")).sendKeys("8");
		  boolean studentname =driver.findElement(By.name("BatchName")).getAttribute("value").matches(batchname_pattern);
		  Assert.assertTrue(studentname, "Batch Name Contains Numbers");
	  }
	  
	  @Test
	  public void Batch_Name_contain_Whitespaces() 
	  {
		  driver.findElement(By.name("BatchName")).clear();
		  driver.findElement(By.name("BatchName")).sendKeys("8 9");
		  boolean studentname =driver.findElement(By.name("BatchName")).getAttribute("value").matches(batchname_pattern);
		  Assert.assertTrue(studentname, "Batch Name Contains Special Characters");
	  }
	  
	  @Test
	  public void Batch_Name_contain_Whitespaces_at_begining() 
	  {
		  driver.findElement(By.name("BatchName")).clear();
		  driver.findElement(By.name("BatchName")).sendKeys("     Morning Batch");
		  boolean studentname =driver.findElement(By.name("BatchName")).getAttribute("value").matches(batchname_pattern);
		  Assert.assertTrue(studentname, "Batch Name Contains Special Characters");
	  }
	  
	  @Test
	  public void Batch_Name_contain_alphabets() 
	  {
		  driver.findElement(By.name("BatchName")).clear();
		  driver.findElement(By.name("BatchName")).sendKeys("12 to 1");
		  boolean studentname =driver.findElement(By.name("BatchName")).getAttribute("value").matches(batchname_pattern);
		  Assert.assertTrue(studentname, "Batch Name Contains Special Characters");
	  }
	  
	  
	  //Course
	  @Test
	  public void Blank_Course()
	  {
		 String actual = driver.findElement(By.xpath("//*[@id=\"parsley-id-6\"]/li")).getText();
		 String expected = "This value is required.";
		 Assert.assertEquals(actual, expected, "Course Accepted Blank Field");
	  }
	  
	  @Test
	  public void Course()
	  {
		 Select drpcourse = new Select(driver.findElement(By.name("CourseId")));
		 drpcourse.selectByVisibleText("DOT NET");
		 boolean course =driver.findElement(By.name("CourseId")).getAttribute("value").matches(course_pattern);
		 Assert.assertTrue(course, "Course field NOT Working");
	  }
	  
	  //Batch Size
	  @Test
	  public void Blank_Batch_Size()
	  {
		 String actual = driver.findElement(By.xpath("//*[@id=\"parsley-id-8\"]/li[1]")).getText();
		 String expected = "This value is required.";
		 Assert.assertEquals(actual, expected, "Batch Size Accepted Blank Field");
	  }
	  
	  @Test
	  public void Batch_Size_contain_Special_Character()
	  {
		 driver.findElement(By.name("BatchSize")).sendKeys("#$#^%&^&*(");
		 boolean batchsize =driver.findElement(By.name("BatchSize")).getAttribute("value").matches(batchsize_pattern);
		 Assert.assertTrue(batchsize, "Batch Size Contains Special Characters");
	  }
	  
	  @Test
	  public void Batch_Size_contain_Whitespaces()
	  {
		 driver.findElement(By.name("BatchSize")).sendKeys("#$#^%&^&*(");
		 boolean batchsize =driver.findElement(By.name("BatchSize")).getAttribute("value").matches(batchsize_pattern);
		 Assert.assertTrue(batchsize, "Batch Size Contains Special Characters");
	  }
	  
	  @Test
	  public void Batch_Size_contain_Alphabets()
	  {
		 driver.findElement(By.name("BatchSize")).sendKeys("#$#^%&^&*(");
		 boolean batchsize =driver.findElement(By.name("BatchSize")).getAttribute("value").matches(batchsize_pattern);
		 Assert.assertTrue(batchsize, "Batch Size Contains Special Characters");
	  }
	  
	  @Test
	  public void Batch_Size_contain_Whitespaces_at_Begining()
	  {
		 driver.findElement(By.name("BatchSize")).sendKeys("#$#^%&^&*(");
		 boolean batchsize =driver.findElement(By.name("BatchSize")).getAttribute("value").matches(batchsize_pattern);
		 Assert.assertTrue(batchsize, "Batch Size Contains Special Characters");
	  }
	  
	  @Test
	  public void Batch_Size_contain_Negative_Numbers()
	  {
		 driver.findElement(By.name("BatchSize")).sendKeys("-50");
		 boolean batchsize =driver.findElement(By.name("BatchSize")).getAttribute("value").matches(batchsize_pattern);
		 Assert.assertTrue(batchsize, "Batch Size Contains Special Characters");
	  }
	  
	  @Test
	  public void Batch_Size_contain_Numbers()
	  {
		 driver.findElement(By.name("BatchSize")).sendKeys("#$#^%&^&*(");
		 boolean batchsize =driver.findElement(By.name("BatchSize")).getAttribute("value").matches(batchsize_pattern);
		 Assert.assertTrue(batchsize, "Batch Size Contains Special Characters");
	  }
	  
	  //Save Changes Button
	  @Test
	  public void Save_Changes_Button_Functionality()
	  {
		  driver.findElement(By.id("btn-save-batch")).click();
		  String actualbatchtitle = driver.findElement(By.xpath("//*[@id=\"view-batch-status\"]/tbody/tr[1]/td[2]")).getText();
		  String actualbatchsize = driver.findElement(By.xpath("//*[@id=\"view-batch-status\"]/tbody/tr[1]/td[3]")).getText();
		  String actualcourse = driver.findElement(By.xpath("//*[@id=\"view-batch-status\"]/tbody/tr[1]/td[4]")).getText();
		  String actualcreateddate = driver.findElement(By.xpath("//*[@id=\"view-batch-status\"]/tbody/tr[1]/td[5]")).getText();
		  SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		  String date = dateFormat.format(new Date());
		  Assert.assertEquals(actualbatchtitle, "12 to 1", "Batch Title NOT Getting Saved");
		  Assert.assertEquals(actualbatchsize, "50", "Batch Size NOT Getting Saved");
		  Assert.assertEquals(actualcourse, "DOT NET", "Course NOT Getting Saved");
		  Assert.assertEquals(actualcreateddate, date, "Created Date NOT Getting Saved");
	  }
	  
	  @Test
	  public void Cancel_Button_Functionality()
	  {
		  driver.findElement(By.xpath("//*[@id=\"btn-new-course\"]")).click();
		  driver.findElement(By.xpath("//*[@id=\"btn-cancel\"]")).click();
		  String actual = driver.getCurrentUrl();
		  String expected = "https://app.admin360.in/13-02-view-batch.html";
		  Assert.assertEquals(actual, expected, "Cancel Button NOT Working");
	  }
	  
	  @Test
	  public void Update_Functionality()
	  {
		  driver.findElement(By.xpath("//*[@id=\"view-batch-status\"]/tbody/tr[1]/td[6]/button[1]/i")).click();
		  driver.findElement(By.name("BatchName")).clear();
		  driver.findElement(By.name("BatchName")).sendKeys("1 to 2");
		  Select drpcourse = new Select(driver.findElement(By.name("CourseId")));
		  drpcourse.selectByVisibleText("HTML");
		  driver.findElement(By.name("BatchSize")).clear();
		  driver.findElement(By.name("BatchSize")).sendKeys("25");
		  driver.findElement(By.id("btn-update-batch")).click();
		  SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		  String date = dateFormat.format(new Date());
		  String actualbatchtitle = driver.findElement(By.xpath("//*[@id=\"view-batch-status\"]/tbody/tr[1]/td[2]")).getText();
		  String actualbatchsize = driver.findElement(By.xpath("//*[@id=\"view-batch-status\"]/tbody/tr[1]/td[3]")).getText();
		  String actualcourse = driver.findElement(By.xpath("//*[@id=\"view-batch-status\"]/tbody/tr[1]/td[4]")).getText();
		  String actualcreateddate = driver.findElement(By.xpath("//*[@id=\"view-batch-status\"]/tbody/tr[1]/td[5]")).getText();
		  Assert.assertEquals(actualbatchtitle, "1 to 2", "Batch Title NOT Getting Saved");
		  Assert.assertEquals(actualbatchsize, "25", "Batch Size NOT Getting Saved");
		  Assert.assertEquals(actualcourse, "HTML", "Course NOT Getting Saved");
		  Assert.assertEquals(actualcreateddate, date, "Created Date NOT Getting Saved");
	  }
	  
	  @Test
	  public void Delete_Functionality() throws InterruptedException
	  {
		  driver.findElement(By.xpath("//*[@id=\"view-batch-status\"]/tbody/tr[1]/td[6]/button[2]/i")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.id("remove-admission")).click();
		  Thread.sleep(1000);
		  String actual = driver.findElement(By.xpath("//*[@id=\"view-batch-status\"]/tbody/tr/td")).getText();
		  String expected = "No data available in table";
		  Assert.assertEquals(actual, expected, "Batch NOT Geting Deleted");
	  }
	  
	}
