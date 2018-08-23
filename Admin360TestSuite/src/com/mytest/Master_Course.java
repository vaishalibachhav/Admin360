package com.mytest;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


	public class Master_Course extends Login
	{
		String coursename_pattern = "([^-\\s][a-zA-Z ]*[0-9]*[$&+,:;=?@#|'<>.^*()%!-]*)+(\\s)*";
		String coursefees_pattern = "\\s*\\d*";
		
		//Course Name
		
		@Test
	  	public void Coursename_contain_special_characters() 
		{
			driver.findElement(By.xpath("//*[@id=\"nav-state-toggle\"]/i")).click();
			driver.findElement(By.xpath("//*[@id=\"2\"]/li[1]/a")).click();
			driver.findElement(By.xpath("//*[@id=\"btn-new-course\"]")).click();
			driver.findElement(By.name("CourseName")).sendKeys("!@#$%^&*");
			boolean CourseName =driver.findElement(By.name("CourseName")).getAttribute("value").matches(coursename_pattern);
			Assert.assertTrue(CourseName, "Course Name Contains Special Characters");
		 }
		
		@Test
		public void Coursename_contain_numbers()
		{
		    driver.findElement(By.name("CourseName")).clear();
		    driver.findElement(By.name("CourseName")).sendKeys("025547");
			boolean CourseName =driver.findElement(By.name("CourseName")).getAttribute("value").matches(coursename_pattern);
			Assert.assertTrue(CourseName, "Course Name Contains Numbers");
		}
	
		@Test
		public void Coursename_contain_whitespaces()
		{
		    driver.findElement(By.name("CourseName")).clear();
		    driver.findElement(By.name("CourseName")).sendKeys("ASP NET");
			boolean CourseName =driver.findElement(By.name("CourseName")).getAttribute("value").matches(coursename_pattern);
			Assert.assertTrue(CourseName, "Course Name Contains Whitespaces");
		}
		
		@Test
	  	public void Coursename_contain_alphabets() 
		{
			driver.findElement(By.name("CourseName")).clear();
			driver.findElement(By.name("CourseName")).sendKeys("JAVA");
			boolean CourseName =driver.findElement(By.name("CourseName")).getAttribute("value").matches(coursename_pattern);
			Assert.assertTrue(CourseName, "Course Name Contain Alphabets");
		}
		
		@Test
	  	public void Coursename_contain_whitespaces_at_begining() 
		{
			driver.findElement(By.name("CourseName")).clear();
			driver.findElement(By.name("CourseName")).sendKeys("   JAVA");
			boolean CourseName =driver.findElement(By.name("CourseName")).getAttribute("value").matches(coursename_pattern);
			Assert.assertTrue(CourseName, "Course Name Contain Whitespaces at Begining");
		}
		
		@Test
	  	public void Coursename_field_is_Blank() 
		{
			driver.findElement(By.name("CourseName")).clear();
			driver.findElement(By.xpath("//*[@id=\"btn-save-course\"]")).click();
			driver.findElement(By.xpath("//*[@id=\"btn-save-course\"]")).click();
			String actual = driver.findElement(By.xpath("//*[@id=\"parsley-id-4\"]/li")).getText();
			String expected = "This value is required.";
			Assert.assertEquals(actual, expected, "Course NAme acceoted Blank Field");
		}

		//Course Fees
		@Test
	  	public void Coursefees_field_is_Blank() 
		{
			String actual = driver.findElement(By.xpath("//*[@id=\"parsley-id-6\"]/li")).getText();
			String expected =  "This value is required.";
			System.out.println();
			Assert.assertEquals(actual, expected , "Course fees field is Blank");
		}
		
		@Test
		public void Coursefees_contain_special_characters()
		{
			driver.findElement(By.name("CourseAmount")).sendKeys("!@#$%^&*()");
			boolean CourseFees =driver.findElement(By.name("CourseAmount")).getAttribute("value").matches(coursefees_pattern);
			Assert.assertTrue(CourseFees, "Course fees Contains Spaecial Characters");
		}
	
		@Test
		public void Coursefees_contain_whitespaces()
		{
			driver.findElement(By.name("CourseAmount")).clear();
			driver.findElement(By.name("CourseAmount")).sendKeys("2000 3000");
			boolean CourseFees =driver.findElement(By.name("CourseAmount")).getAttribute("value").matches(coursefees_pattern);
			Assert.assertTrue(CourseFees, "Course fees Contains Whitespaces");
		}
		
		@Test
		public void Coursefees_contain_alphabets()
		{
			driver.findElement(By.name("CourseAmount")).clear();
			driver.findElement(By.name("CourseAmount")).sendKeys("fees");
			boolean CourseFees =driver.findElement(By.name("CourseAmount")).getAttribute("value").matches(coursefees_pattern);
			Assert.assertTrue(CourseFees, "Course fees Contains Alphabets");
		}
		
		@Test
		public void Coursefees_contain_numbers()
		{
			driver.findElement(By.name("CourseAmount")).clear();
			driver.findElement(By.name("CourseAmount")).sendKeys("25000");
			boolean CourseFees =driver.findElement(By.name("CourseAmount")).getAttribute("value").matches(coursefees_pattern);
			Assert.assertTrue(CourseFees, "Course fees Contains Numbers");
		}
		
		@Test
		public void Coursefees_contain_negative_numbers()
		{
			driver.findElement(By.name("CourseAmount")).clear();
			driver.findElement(By.name("CourseAmount")).sendKeys("-557855");
			boolean CourseFees =driver.findElement(By.name("CourseAmount")).getAttribute("value").matches(coursefees_pattern);
			Assert.assertTrue(CourseFees, "Course fees Contains Negative Numbers");
		}
		
		@Test
	  	public void Coursefees_contain_whitespaces_at_begining() 
		{
			driver.findElement(By.name("CourseAmount")).clear();
			driver.findElement(By.name("CourseAmount")).sendKeys("  20000");
			boolean CourseFees =driver.findElement(By.name("CourseAmount")).getAttribute("value").matches(coursefees_pattern);
			Assert.assertTrue(CourseFees, "Course fees Contains Whitespaces at begining");
		}
		
	
	
		@Test
		public void Cancel_button_functionality()
		{
			driver.findElement(By.xpath("//*[@id=\"btn-cancel\"]")).click();
			//driver.findElement(By.xpath("//*[@id=\"2\"]/li[1]/a")).click();
			String expected = "https://app.admin360.in/06-02-view-course.html";
			//driver.findElement(By.id("btn-cancel")).click();
			String actual  = driver.getCurrentUrl();
			Assert.assertEquals(actual, expected, "Cancel Button NOT Working");
		}
		
		
		//Course View
		
		@Test
		public void Save_button_functionality() throws InterruptedException 
		{
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[@id=\"btn-new-course\"]")).click();
			driver.findElement(By.name("CourseName")).sendKeys("DOT NET");
			driver.findElement(By.name("CourseAmount")).sendKeys("20000");
			driver.findElement(By.name("save-course")).click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			Thread.sleep(3000);
			String actualcourse = driver.findElement(By.xpath("//*[@id=\"view-courses\"]/tbody/tr/td[1]")).getText();
			String actualfees = driver.findElement(By.xpath("//*[@id=\"view-courses\"]/tbody/tr/td[2]")).getText();			
			Assert.assertEquals(actualcourse, "DOT NET", "Course name not getting saved");
			Assert.assertEquals(actualfees, "20000", "Course fees not getting saved");
		}
		
		@Test
		public void Update_button_functionality()
		{
			driver.findElement(By.xpath("//*[@id=\"view-courses\"]/tbody/tr/td[3]/button[1]/i")).click();
			String actualviewcourse = driver.getCurrentUrl();
			String expectedviewcourse = "https://app.admin360.in/06-07-update-course.html";
			Assert.assertEquals(actualviewcourse, expectedviewcourse,"Update button not working");
		}
		
		@Test
		public void Update_cancel_button_functionality() throws InterruptedException
		{
			Thread.sleep(1000);
			String expected = "https://app.admin360.in/06-02-view-course.html";
			driver.findElement(By.xpath("//*[@id=\"fm-update-course\"]/div/div[3]/button[2]")).click();
			Thread.sleep(1000);
			String actual  = driver.getCurrentUrl();
			Assert.assertEquals(actual, expected, "Cancel Button NOT Working");
		}
		
		@Test
		public void Update_functionality() throws InterruptedException
		{
			driver.findElement(By.xpath("//*[@id=\"view-courses\"]/tbody/tr/td[3]/button[1]/i")).click();
			driver.findElement(By.id("txtcoursename")).clear();
			driver.findElement(By.id("txtcoursename")).sendKeys("JAVA COURSE");
			driver.findElement(By.id("txtcourseamount")).clear();
			driver.findElement(By.id("txtcourseamount")).sendKeys("27000");
			driver.findElement(By.id("btn-update-course")).click();
			Thread.sleep(3000);
			String actualcourse = driver.findElement(By.xpath("//*[@id=\"view-courses\"]/tbody/tr/td[1]")).getText();
			String actualfees = driver.findElement(By.xpath("//*[@id=\"view-courses\"]/tbody/tr/td[2]")).getText();			
			Assert.assertEquals(actualcourse, "JAVA COURSE", "Course name not getting saved");
			Assert.assertEquals(actualfees, "27000", "Course fees not getting saved");
		}
		
		@Test
		public void Delete_button_functionality() throws InterruptedException
		{
			driver.findElement(By.xpath("//*[@id=\"view-courses\"]/tbody/tr/td[3]/button[2]/i")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("remove-course")).click();
			Thread.sleep(3000);
			String actualcourseinfo = driver.findElement(By.xpath("//*[@id=\"view-courses\"]/tbody/tr/td")).getText();
			Assert.assertEquals(actualcourseinfo, "No data available in table", "Course name not getting saved");

		}

	}
