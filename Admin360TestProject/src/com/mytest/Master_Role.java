package com.mytest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

	public class Master_Role extends Login
	{
		String roletitle_pattern = "([^-\\s][a-zA-Z ]*[0-9]*)+(\\s)*";
		
	  @Test
	  public void Blank_Role_Title() throws InterruptedException 
	  {
		  driver.findElement(By.xpath("//*[@id=\"nav-state-toggle\"]/i")).click();
		  driver.findElement(By.xpath("//*[@id=\"2\"]/li[5]/a")).click();
		  driver.findElement(By.xpath("//*[@id=\"2\"]/li[6]/a")).click();
		  driver.navigate().refresh();
		  Thread.sleep(1000);
		  driver.findElement(By.id("btn-new-course")).click();
		  driver.findElement(By.id("btn-save-rolltitle")).click();
		  String actual = driver.findElement(By.xpath("/html/body/ul/li[1]/div/div")).getText();
		  String expected = "Select atleast one menu and try again.";
		  Assert.assertEquals(actual, expected, "Role Title Accepted Blank Field");
	  }
	  
	  @Test
	  	public void RoleTitle_contain_special_characters() 
		{
			driver.findElement(By.xpath("//*[@id=\"nav-state-toggle\"]/i")).click();
			driver.findElement(By.xpath("//*[@id=\"2\"]/li[1]/a")).click();
			driver.findElement(By.xpath("//*[@id=\"btn-new-course\"]")).click();
			driver.findElement(By.name("CourseName")).sendKeys("!@#$%^&*");
			boolean roletitle =driver.findElement(By.name("CourseName")).getAttribute("value").matches(roletitle_pattern);
			Assert.assertTrue(roletitle, "Course Name Contains Special Characters");
		 }
		
		@Test
		public void RoleTitle_contain_numbers()
		{
		    driver.findElement(By.name("RollTitle")).clear();
		    driver.findElement(By.name("RollTitle")).sendKeys("025547");
			boolean roletitle =driver.findElement(By.name("RollTitle")).getAttribute("value").matches(roletitle_pattern);
			Assert.assertTrue(roletitle, "Course Name Contains Numbers");
		}
	
		@Test
		public void RoleTitle_contain_whitespaces()
		{
		    driver.findElement(By.name("RollTitle")).clear();
		    driver.findElement(By.name("RollTitle")).sendKeys("Super Admin");
			boolean roletitle =driver.findElement(By.name("RollTitle")).getAttribute("value").matches(roletitle_pattern);
			Assert.assertTrue(roletitle, "Course Name Contains Whitespaces");
		}
		
		@Test
	  	public void RoleTitle_contain_alphabets() 
		{
			driver.findElement(By.name("RollTitle")).clear();
			driver.findElement(By.name("RollTitle")).sendKeys("Master");
			boolean roletitle =driver.findElement(By.name("RollTitle")).getAttribute("value").matches(roletitle_pattern);
			Assert.assertTrue(roletitle, "Course Name Contain Alphabets");
		}
		
		@Test
	  	public void RoleTitle_contain_whitespaces_at_begining() 
		{
			driver.findElement(By.name("RollTitle")).clear();
			driver.findElement(By.name("RollTitle")).sendKeys("   Master");
			boolean roletitle =driver.findElement(By.name("RollTitle")).getAttribute("value").matches(roletitle_pattern);
			Assert.assertTrue(roletitle, "Course Name Contain Whitespaces at Begining");
		}
	  
	  @Test
	  public void Blank_Menu()
	  {
		  driver.findElement(By.name("RollTitle")).clear();
		  driver.findElement(By.name("RollTitle")).sendKeys("Master");
		  driver.findElement(By.id("btn-save-rolltitle")).click();
		  String actual = driver.findElement(By.xpath("/html/body/ul/li[1]/div/div")).getText();
		  String expected = "Select atleast one menu and try again.";
		  Assert.assertEquals(actual, expected, "Role Getting Saved Without Menu");
	  }
	  
	  @Test
	  public void Menu()
	  {
		  Actions action = new Actions(driver);
		  WebElement we = driver.findElement(By.xpath("//*[@id=\"create-roll\"]/tbody/tr[33]/td[3]/div/label"));
		  action.moveToElement(we).moveToElement(driver.findElement(By.xpath("//*[@id=\"create-roll\"]/tbody/tr[33]/td[3]/div/label"))).click().build().perform();
		 
	  }
	  
	  //Save Button 
	  @Test
	  public void Save_Button_Functionality() throws InterruptedException
	  {
		  driver.findElement(By.id("btn-save-rolltitle")).click();
		  Thread.sleep(2500);
		  String actualrole = driver.findElement(By.xpath("//*[@id=\"view-Roles\"]/tbody/tr/td[1]")).getText();
		  Assert.assertEquals(actualrole, "Master", "Role NOT Getting Saved");
	  }
	  
	  //Update Button
	  @Test
	  public void Update_Button_Functionality()
	  {
		  driver.findElement(By.xpath("//*[@id=\"view-Roles\"]/tbody/tr[1]/td[2]/button[1]/i")).click();
		  Actions action = new Actions(driver);
		  WebElement we = driver.findElement(By.xpath("//*[@id=\"create-roll\"]/tbody/tr[34]/td[3]/div/label"));
		  action.moveToElement(we).moveToElement(driver.findElement(By.xpath("//*[@id=\"create-roll\"]/tbody/tr[34]/td[3]/div/label"))).click().build().perform();
		  driver.findElement(By.id("btn-save-rolltitle")).click();
	  }
	  
	  //Delete
	  @Test
	  public void Delete_Button_Functionality() throws InterruptedException
	  {
		  driver.findElement(By.xpath("//*[@id=\"view-Roles\"]/tbody/tr/td[2]/button[2]/i")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//*[@id=\"remove-role\"]")).click();
		  Thread.sleep(1000);
		  String actual = driver.findElement(By.xpath("//*[@id=\"view-Roles\"]/tbody/tr/td[1]")).getText();
		  Assert.assertEquals(actual, "Admin", "Record NOT Getting Deleted");
	  }
	  
	  
	}
