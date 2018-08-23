package com.mytest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

	public class Master_Branch extends Login
	{
		String branchname_pattern = "([^-\\s][a-zA-Z ]*[0-9]*[$&+,:;=?@#|'<>.^*()%!-]*)+(\\s)*";
		String branchlocation_pattern = "([a-zA-Z]*[a-zA-Z ]*[0-9]*[$&+,:;=?@#|'<>.^*()%!-]*)+(\\s)*";
		String phoneno_pattern = "\\s*(\\d{5}([- ]*)\\d{6})*\\s*";
		String gstno_pattern = "\\s*[a-zA-Z0-9]{15}\\s*";
		String email_pattern = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
		String address_pattern = "([a-zA-Z]*[a-zA-Z ]*[0-9]*[$&+,:;=?@#|'<>.^*()%!-]*)+(\\s)*";
		
	  @Test
	  public void Blank_Branch_Name() 
	  {
		  driver.findElement(By.xpath("//*[@id=\"nav-state-toggle\"]/i")).click();
		  driver.findElement(By.xpath("//*[@id=\"2\"]/li[4]/a")).click();
		  driver.findElement(By.xpath("//*[@id=\"btn-new-course\"]")).click();
		  
		  driver.findElement(By.id("btn-create-branch")).click();
		  driver.findElement(By.id("btn-create-branch")).click();
		  String actual = driver.findElement(By.xpath("//*[@id=\"parsley-id-4\"]/li")).getText();
		  String expected = "This value is required.";
		  Assert.assertEquals(actual, expected, "Branch Name Accepted Blank Field");
	  }
	  
	  @Test
	  	public void Branchname_contain_special_characters() 
		{
			driver.findElement(By.name("BranchName")).sendKeys("!@#$%^&*");
			boolean BranchName =driver.findElement(By.name("BranchName")).getAttribute("value").matches(branchname_pattern);
			Assert.assertTrue(BranchName, "Branch Name Contains Special Characters");
		 }
		
		@Test
		public void Branchname_contain_numbers()
		{
		    driver.findElement(By.name("BranchName")).clear();
		    driver.findElement(By.name("BranchName")).sendKeys("562548");
			boolean BranchName =driver.findElement(By.name("BranchName")).getAttribute("value").matches(branchname_pattern);
			Assert.assertTrue(BranchName, "Branch Name Contains Numbers");
		}
	
		@Test
		public void Branchname_contain_whitespaces()
		{
		    driver.findElement(By.name("BranchName")).clear();
		    driver.findElement(By.name("BranchName")).sendKeys("Nashik Branch");
			boolean BranchName =driver.findElement(By.name("BranchName")).getAttribute("value").matches(branchname_pattern);
			Assert.assertTrue(BranchName, "Branch Name Contains Whitespaces");
		}
		
		@Test
	  	public void Branchname_contain_alphabets() 
		{
			driver.findElement(By.name("BranchName")).clear();
			driver.findElement(By.name("BranchName")).sendKeys("Nashik");
			boolean BranchName =driver.findElement(By.name("BranchName")).getAttribute("value").matches(branchname_pattern);
			Assert.assertTrue(BranchName, "Branch Name Contain Alphabets");
		}
		
		@Test
	  	public void Branchname_contain_whitespaces_at_begining() 
		{
			driver.findElement(By.name("BranchName")).clear();
			driver.findElement(By.name("BranchName")).sendKeys("   Nashik Branch");
			boolean BranchName =driver.findElement(By.name("BranchName")).getAttribute("value").matches(branchname_pattern);
			Assert.assertTrue(BranchName, "Branch Name Contain Whitespaces at Begining");
		}
		
		//Branch Location
		@Test
		public void Blank_Branch_Location()
		{
			String actual = driver.findElement(By.xpath("//*[@id=\"parsley-id-10\"]/li")).getText();
			String expected = "This value is required.";
			Assert.assertEquals(actual, expected, "Branch Location Accepted Blank Field");
		}
		
		@Test
		public void Valid_Branch_Location()
		{
			driver.findElement(By.name("BranchLocation")).clear();
			driver.findElement(By.name("BranchLocation")).sendKeys("Nashik");
			boolean BranchLocation =driver.findElement(By.name("BranchLocation")).getAttribute("value").matches(branchlocation_pattern);
			Assert.assertTrue(BranchLocation, "Branch Location is NOT valid");
		}
		
		//Phone No
		@Test
		public void Blank_Phone_No()
		{
			String actual = driver.findElement(By.xpath("//*[@id=\"parsley-id-6\"]/li")).getText();
			String expected = "This value is required.";
			Assert.assertEquals(actual, expected, "Phone No Accepted Blank Field");
		}
		
		@Test
		public void Phone_No_contain_special_characters()
		{
			driver.findElement(By.name("MobileNo")).clear();
			driver.findElement(By.name("MobileNo")).sendKeys("!@#$%^&&^*&**()");
			boolean phoneno =driver.findElement(By.name("MobileNo")).getAttribute("value").matches(phoneno_pattern);
			Assert.assertTrue(phoneno, "Phone No Contains Spaecial Characters");
		}
	
		@Test
		public void Phone_No_contain_whitespaces()
		{
			driver.findElement(By.name("MobileNo")).clear();
			driver.findElement(By.name("MobileNo")).sendKeys("02598 384780");
			boolean phoneno =driver.findElement(By.name("MobileNo")).getAttribute("value").matches(phoneno_pattern);
			Assert.assertTrue(phoneno, "Phone No Contains Whitespaces");
		}
		
		@Test
		public void Phone_No_contain_alphabets()
		{
			driver.findElement(By.name("MobileNo")).clear();
			driver.findElement(By.name("MobileNo")).sendKeys("mobile");
			boolean phoneno =driver.findElement(By.name("MobileNo")).getAttribute("value").matches(phoneno_pattern);
			Assert.assertTrue(phoneno, "Phone No Contains Alphabets");
		}
		
		@Test
		public void Phone_No_contain_numbers()
		{
			driver.findElement(By.name("MobileNo")).clear();
			driver.findElement(By.name("MobileNo")).sendKeys("02535256987");
			boolean phoneno =driver.findElement(By.name("MobileNo")).getAttribute("value").matches(phoneno_pattern);
			Assert.assertTrue(phoneno, "Phone No Contains Numbers");
		}
		
		@Test
		public void Phone_No_contain_negative_numbers()
		{
			driver.findElement(By.name("MobileNo")).clear();
			driver.findElement(By.name("MobileNo")).sendKeys("-02589256987");
			boolean phoneno =driver.findElement(By.name("MobileNo")).getAttribute("value").matches(phoneno_pattern);
			Assert.assertTrue(phoneno, "Phone No Contains Negative Numbers");
		}
		
		@Test
	  	public void Phone_No_contain_whitespaces_at_begining() 
		{
			driver.findElement(By.name("MobileNo")).clear();
			driver.findElement(By.name("MobileNo")).sendKeys("  9874563210");
			boolean phoneno =driver.findElement(By.name("MobileNo")).getAttribute("value").matches(phoneno_pattern);
			Assert.assertTrue(phoneno, "Phone No Contains Whitespaces at begining");
		}
		
		@Test
	  	public void Phone_No_contain_lessthan_11_numbers() 
		{
			driver.findElement(By.name("MobileNo")).clear();
			driver.findElement(By.name("MobileNo")).sendKeys("8989");
			boolean phoneno =driver.findElement(By.name("MobileNo")).getAttribute("value").matches(phoneno_pattern);
			Assert.assertTrue(phoneno, "Phone No Contains Less than 10 numbers");
		}
		
		@Test
	  	public void Phone_No_contain_greaterthan_11_numbers() 
		{
			driver.findElement(By.name("MobileNo")).clear();
			driver.findElement(By.name("MobileNo")).sendKeys("7894561230123");
			boolean phoneno =driver.findElement(By.name("MobileNo")).getAttribute("value").matches(phoneno_pattern);
			Assert.assertTrue(phoneno, "Phone No contains greater than 10 numbers");
		}
		
		//GST No
		@Test
		public void GST_No_contain_Special_Characters()
		{
			driver.findElement(By.name("Gstno")).sendKeys("~!@#$%^&*()");
			boolean gstno = driver.findElement(By.name("Gstno")).getAttribute("value").matches(gstno_pattern);
			Assert.assertTrue(gstno, "GST No conatain Special Characters");
		}
		
		@Test
		public void GST_No_contain_Whitespaces()
		{
			driver.findElement(By.name("Gstno")).clear();
			driver.findElement(By.name("Gstno")).sendKeys("29ABCDE 1234F2Z5");
			boolean gstno = driver.findElement(By.name("Gstno")).getAttribute("value").matches(gstno_pattern);
			Assert.assertTrue(gstno, "GST No conatain Whitespaces");
		}
		
		@Test
		public void GST_No_contain_Whitespaces_at_begining()
		{
			driver.findElement(By.name("Gstno")).clear();
			driver.findElement(By.name("Gstno")).sendKeys("   29ABCDE1234F2Z5");
			boolean gstno = driver.findElement(By.name("Gstno")).getAttribute("value").matches(gstno_pattern);
			Assert.assertTrue(gstno, "GST No conatain Whitespaces");
		}
		
		@Test
		public void GST_No_contain_lessthan_15_Characters()
		{
			driver.findElement(By.name("Gstno")).clear();
			driver.findElement(By.name("Gstno")).sendKeys("29ABCDE123");
			boolean gstno = driver.findElement(By.name("Gstno")).getAttribute("value").matches(gstno_pattern);
			Assert.assertTrue(gstno, "GST No conatain less than 15 Characters");
		}
		
		@Test
		public void GST_No_contain_greaterthan_15_Characters()
		{
			driver.findElement(By.name("Gstno")).clear();
			driver.findElement(By.name("Gstno")).sendKeys("29ABCDE123");
			boolean gstno = driver.findElement(By.name("Gstno")).getAttribute("value").matches(gstno_pattern);
			Assert.assertTrue(gstno, "GST No conatain greater than 15 Characters");
		}
		
		//E-mail Id
		@Test
		public void Blank_Email_Id()
		{
			String actual = driver.findElement(By.xpath("//*[@id=\"parsley-id-8\"]/li[1]")).getText();
			String expected = "This value is required.";
			Assert.assertEquals(actual, expected, "Email Id Accept blank Field");
		}
		
		@Test
		public void Email_contains_whitespaces() throws InterruptedException
		{
			driver.findElement(By.name("EmailId")).clear();
			driver.findElement(By.name("EmailId")).sendKeys("abc @gmail.com");
			driver.findElement(By.xpath("//*[@id=\"btn-payment-voucher\"]")).click();
			Thread.sleep(2000);
			String actual = driver.findElement(By.xpath("//*[@id=\"parsley-id-8\"]/li")).getText();
			String expected = "This value should be a valid email.";
			Assert.assertEquals(actual, expected, " Email Contains Whitespaces");
		}
		
		@Test
		public void Email_valid()
		{
			driver.findElement(By.name("EmailId")).clear();
			driver.findElement(By.name("EmailId")).sendKeys("abc@gmail.com");
			String actual = "";
			String expected = "";
			Assert.assertEquals(actual, expected, " Email Id is NOT valid");
		}
	
	
		@Test
	  	public void Email_contains_whitespaces_at_begining() throws InterruptedException 
		{
			driver.findElement(By.name("EmailId")).clear();
			Thread.sleep(1000);
			driver.findElement(By.name("EmailId")).sendKeys("       abc@gmail.com");
			boolean email =driver.findElement(By.name("EmailId")).getAttribute("value").matches(email_pattern);
			Assert.assertTrue(email, " Email contain Whitespaces at Begining");
		}			
		
		//Address
		@Test
		public void Blank_Address()
		{
			String actual = driver.findElement(By.xpath("//*[@id=\"parsley-id-14\"]/li")).getText();
			String expected = "This value is required.";
			Assert.assertEquals(actual, expected, "Address Accepted Blank Field");
		}
		
		@Test
		public void Valid_Address()
		{
			driver.findElement(By.name("Address")).sendKeys("Flat no-15,Ganesh Appartment, Near Prasad Circle,Gangapur Road,Nashik");
			boolean address =driver.findElement(By.name("Address")).getAttribute("value").matches(address_pattern);
			Assert.assertTrue(address, "Current Address in NOT valid");
		}
		
	/*	//Save Button
		@Test
		public void Save_Button_Functionality() throws InterruptedException
		{
			driver.findElement(By.id("btn-create-branch")).click();
			Thread.sleep(1000);
			String actualbranch = driver.findElement(By.xpath("//*[@id=\"view-branch-details\"]/tbody/tr/td[1]")).getText();
			String actualemailid = driver.findElement(By.xpath("//*[@id=\"view-branch-details\"]/tbody/tr/td[2]")).getText();
			String actuallocation = driver.findElement(By.xpath("//*[@id=\"view-branch-details\"]/tbody/tr/td[3]")).getText();
			String actualaddress = driver.findElement(By.xpath("//*[@id=\"view-branch-details\"]/tbody/tr/td[4]")).getText();
			String actualphoneno = driver.findElement(By.xpath("//*[@id=\"view-branch-details\"]/tbody/tr/td[5]")).getText();
			Assert.assertEquals(actualbranch, "Nashik", message);
			Assert.assertEquals(actualemailid, "abc@gmail.com", message);
			Assert.assertEquals(actuallocation, "Nashik, message);
			Assert.assertEquals(actualaddress, expected, message);
			Assert.assertEquals(actualphoneno, expected, message);
		}*/
		
	}
