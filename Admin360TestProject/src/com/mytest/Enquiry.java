package com.mytest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

	public class Enquiry extends Login
	{
		String studentname_pattern = "([a-zA-Z]*[a-zA-Z]*)+(\\s)*";
		String middlename_pattern = "([a-zA-Z]*[a-zA-Z]*)+(\\s)*";
		String lastname_pattern = "([a-zA-Z]*[a-zA-Z]*)+(\\s)*";
		String college_pattern = "([a-zA-Z]*[a-zA-Z ]*[.]*)+(\\s)*";
		String qualification_pattern = "([a-zA-Z]*[a-zA-Z ]*[.,]*)+(\\s)*";
		String aadharno_pattern = "^(\\s*)+(\\d{4}\\s*\\d{4}\\s*\\d{4})*$";
		String dateofbirth_pattern = "([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))";
		String gender_pattern = "[a-zA-Z]*";
		String primarymobileno_pattern = "\\s*(\\d{10})*\\s*";
		String secondarymobileno_pattern = "\\s*(\\d{10})*\\s*";
		String primary_email = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
		String secondary_email = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
		String currentaddress_pattern = "([a-zA-Z]*[a-zA-Z ]*[0-9]*[$&+,:;=?@#|'<>.^*()%!-]*)+(\\s)*";
		String permanentaddress_pattern = "([a-zA-Z]*[a-zA-Z ]*[0-9]*[$&+,:;=?@#|'<>.^*()%!-]*)+(\\s)*";
		String pincode_currentaddress_pattern = "\\s*(\\d{6})*\\s*";
		String pincode_permanentaddress_pattern = "\\s*(\\d{6})*\\s*";
		String demolecture_pattern = "\\b(true|false)\\b";
		String interestlevel_pattern = "[1-3]*";
		String nxtfollowup_pattern = "([0-9]*[$&+,:;=?@#|'<>.^*()%!-]*)+(\\s)*";
		String followupdetails_pattern = "([a-zA-Z]*[a-zA-Z ]*[0-9]*[$&+,:;=?@#|'<>.^*()%!-]*)+(\\s)*";
		String leadsource_pattern = "[1-5]*";
		String refname_pattern = "([a-zA-Z]*[a-zA-Z ]*)+(\\s)*";
		String followupmode_pattern = "\\d*";
		String notes_pattern = "([a-zA-Z]*[a-zA-Z ]*[0-9]*[$&+,:;=?@#|'<>.^*()%!-]*)+(\\s)*";
		String createddate_pattern = "([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))";
		
	  //Student Name	
	  @Test
	  public void Add_Course() throws InterruptedException
	  {
		 
		  
		  Thread.sleep(1500);
		  driver.findElement(By.xpath("//*[@id=\"nav-state-toggle\"]/i")).click();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.findElement(By.xpath("//*[@id=\"2\"]/li[1]/a")).click();
		  Thread.sleep(1700);
		  driver.findElement(By.xpath("//*[@id=\"btn-new-course\"]")).click();
		  driver.findElement(By.name("CourseName")).sendKeys("DOT NET");
		  driver.findElement(By.id("txtcourseamount")).sendKeys("27000");
		  driver.findElement(By.xpath("//*[@id=\"btn-save-course\"]")).click();
		  
		  driver.findElement(By.xpath("//*[@id=\"btn-new-course\"]")).click();
		  driver.findElement(By.name("CourseName")).sendKeys("JAVA");
		  driver.findElement(By.id("txtcourseamount")).sendKeys("20000");
		  driver.findElement(By.xpath("//*[@id=\"btn-save-course\"]")).click();
		  
		  
	  }
	  
	  @Test
	  public void Studentname_contain_Special_Characters() throws InterruptedException
	  {
			
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//*[@id=\"3\"]/li[1]")).click();
		  driver.findElement(By.id("btn-new-enquiry")).click();
		  driver.findElement(By.name("FirstName")).sendKeys("#$#^%&^&*(");
		  boolean studentname =driver.findElement(By.name("FirstName")).getAttribute("value").matches(studentname_pattern);
		  Assert.assertTrue(studentname, "Student Name Contains Special Characters");
	  }
	  
	  @Test
		public void Studentname_contain_numbers()
		{
		    driver.findElement(By.name("FirstName")).clear();
		    driver.findElement(By.name("FirstName")).sendKeys("025547");
			boolean studentname =driver.findElement(By.name("FirstName")).getAttribute("value").matches(studentname_pattern);
			Assert.assertTrue(studentname, "Student Name Contains Numbers");
		}
	
		@Test
		public void Studentname_contain_whitespaces()
		{
		    driver.findElement(By.name("FirstName")).clear();
		    driver.findElement(By.name("FirstName")).sendKeys("Ashwini Ahire");
			boolean studentname =driver.findElement(By.name("FirstName")).getAttribute("value").matches(studentname_pattern);
			Assert.assertTrue(studentname, "Student Name Contains Whitespaces");
		}
		
		@Test
	  	public void Studentname_contain_alphabets() 
		{
			driver.findElement(By.name("FirstName")).clear();
			driver.findElement(By.name("FirstName")).sendKeys("Ashwini");
			boolean studentname =driver.findElement(By.name("FirstName")).getAttribute("value").matches(studentname_pattern);
			Assert.assertTrue(studentname, "Student Name Contain Alphabets");
		}
		
		@Test
	  	public void Studentname_contain_whitespaces_at_begining() 
		{
			driver.findElement(By.name("FirstName")).clear();
			driver.findElement(By.name("FirstName")).sendKeys("   Ashwini");
			boolean studentname =driver.findElement(By.name("FirstName")).getAttribute("value").matches(studentname_pattern);
			Assert.assertTrue(studentname, "Student Name Contain Whitespaces at Begining");
		}
		
		@Test
	  	public  void Studentname_field_is_Blank() throws InterruptedException 
		{
			driver.findElement(By.name("FirstName")).clear();
			driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/ul/li[2]/button")).click();
			Thread.sleep(2000);
			String actual = driver.findElement(By.xpath("//*[@id=\"parsley-id-4\"]/li")).getText();
			String expected = "This value is required.";
			Assert.assertEquals(actual, expected, "Student Name Accepted Blank Field");
		}
		
		//Middle Name
		@Test
		  public void Middlename_contain_Special_Characters() throws InterruptedException
		  {
			  driver.findElement(By.name("MiddleName")).sendKeys("#$#^%&^&*(");
			  boolean middlename =driver.findElement(By.name("MiddleName")).getAttribute("value").matches(middlename_pattern);
			  Assert.assertTrue(middlename, "Middle Name Contains Special Characters");
		  }
		  
		  @Test
			public void Middlename_contain_numbers()
			{
			    driver.findElement(By.name("MiddleName")).clear();
			    driver.findElement(By.name("MiddleName")).sendKeys("025547");
				boolean middlename =driver.findElement(By.name("MiddleName")).getAttribute("value").matches(middlename_pattern);
				Assert.assertTrue(middlename, "Middle Name Contains Numbers");
			}
		
			@Test
			public void Middlename_contain_whitespaces()
			{
			    driver.findElement(By.name("MiddleName")).clear();
			    driver.findElement(By.name("MiddleName")).sendKeys("Ashwini Ashok");
				boolean middlename =driver.findElement(By.name("MiddleName")).getAttribute("value").matches(middlename_pattern);
				Assert.assertTrue(middlename, "Middle Name Contains Whitespaces");
			}
			
			@Test
		  	public void Middlename_contain_whitespaces_at_begining() 
			{
				driver.findElement(By.name("MiddleName")).clear();
				driver.findElement(By.name("MiddleName")).sendKeys("   Ashok");
				boolean middlename =driver.findElement(By.name("MiddleName")).getAttribute("value").matches(middlename_pattern);
				Assert.assertTrue(middlename, "Middle Name Contain Whitespaces at Begining");
			}
			
			
			@Test
		  	public void Middlename_contain_alphabets() 
			{
				driver.findElement(By.name("MiddleName")).clear();
				driver.findElement(By.name("MiddleName")).sendKeys("Ashok");
				boolean middlename =driver.findElement(By.name("MiddleName")).getAttribute("value").matches(middlename_pattern);
				Assert.assertTrue(middlename, "Middle Name Contain Alphabets");
			}
		
			//Last Name
			@Test
			public void Lastname_contain_Special_Characters() throws InterruptedException
			{
				  driver.findElement(By.name("LastName")).sendKeys("#$#^%&^&*(");
				  boolean lastname =driver.findElement(By.name("LastName")).getAttribute("value").matches(lastname_pattern);
				  Assert.assertTrue(lastname, "Last Name Contains Special Characters");
			}
			  
			@Test
			public void Lastname_contain_numbers()
			{
				    driver.findElement(By.name("LastName")).clear();
				    driver.findElement(By.name("LastName")).sendKeys("025547");
					boolean lastname =driver.findElement(By.name("LastName")).getAttribute("value").matches(lastname_pattern);
					Assert.assertTrue(lastname, "Last Name Contains Numbers");
			}
			
			@Test
			public void Lastname_contain_whitespaces()
			{
				    driver.findElement(By.name("LastName")).clear();
				    driver.findElement(By.name("LastName")).sendKeys("Ashwini Ahire");
					boolean lastname =driver.findElement(By.name("LastName")).getAttribute("value").matches(lastname_pattern);
					Assert.assertTrue(lastname, "Last Name Contains Whitespaces");
			}
				
			@Test
			public void Lastname_contain_alphabets() 
			{
					driver.findElement(By.name("LastName")).clear();
					driver.findElement(By.name("LastName")).sendKeys("Ahire");
					boolean lastname =driver.findElement(By.name("LastName")).getAttribute("value").matches(lastname_pattern);
					Assert.assertTrue(lastname, "Last Name Contain Alphabets");
			}
				
			@Test
			public void Lastname_contain_whitespaces_at_begining() 
			{
					driver.findElement(By.name("LastName")).clear();
					driver.findElement(By.name("LastName")).sendKeys("   Ahire");
					boolean lastname =driver.findElement(By.name("LastName")).getAttribute("value").matches(lastname_pattern);
					Assert.assertTrue(lastname, "Last Name Contain Whitespaces at Begining");
			}
				
			@Test
			public void Lastname_field_is_Blank() throws InterruptedException 
			{
					driver.findElement(By.name("LastName")).clear();
					driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/ul/li[2]/button")).click();
					Thread.sleep(2000);
					String actual = driver.findElement(By.xpath("//*[@id=\"parsley-id-8\"]/li")).getText();
					String expected = "This value is required.";
					Assert.assertEquals(actual, expected, "Last Name Accepted Blank Field");
			}
			
			//College/School
			@Test
			public void Collegename_contain_Special_Characters() throws InterruptedException
			{
				  driver.findElement(By.name("College")).sendKeys("#$#^%&^&*(");
				  boolean collegename =driver.findElement(By.name("College")).getAttribute("value").matches(college_pattern);
				  Assert.assertTrue(collegename, "College Name Contains Special Characters");
			}
			  
			@Test
			public void Collegename_contain_numbers()
			{
				    driver.findElement(By.name("College")).clear();
				    driver.findElement(By.name("College")).sendKeys("025547");
					boolean collegename =driver.findElement(By.name("College")).getAttribute("value").matches(college_pattern);
					Assert.assertTrue(collegename, "College Name Contains Numbers");
			}
			
			@Test
			public void Collegename_contain_whitespaces()
			{
				    driver.findElement(By.name("College")).clear();
				    driver.findElement(By.name("College")).sendKeys("K T H M");
					boolean collegename =driver.findElement(By.name("College")).getAttribute("value").matches(college_pattern);
					Assert.assertTrue(collegename, "College Name Contains Whitespaces");
			}
				
			@Test
			public void Collegename_contain_alphabets() 
			{
					driver.findElement(By.name("College")).clear();
					driver.findElement(By.name("College")).sendKeys("KTHM");
					boolean collegename =driver.findElement(By.name("College")).getAttribute("value").matches(college_pattern);
					Assert.assertTrue(collegename, "College Name Contain Alphabets");
			}
				
			@Test
			public void Collegename_contain_whitespaces_at_begining() 
			{
					driver.findElement(By.name("College")).clear();
					driver.findElement(By.name("College")).sendKeys("   KTHM");
					boolean collegename =driver.findElement(By.name("College")).getAttribute("value").matches(college_pattern);
					Assert.assertTrue(collegename, "College Name Contain Whitespaces at Begining");
			}
				
			@Test
			public void Collegename_field_is_Blank() throws InterruptedException 
			{
					driver.findElement(By.name("College")).clear();
					driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/ul/li[2]/button")).click();
					Thread.sleep(1500);
					String actual = driver.findElement(By.xpath("//*[@id=\"parsley-id-10\"]/li")).getText();
					String expected = "This value is required.";
					Assert.assertEquals(actual, expected, "College Name Accepted Blank Field");
			}
		
			//Qualification
			@Test
			public void Qualification_contain_Special_Characters() throws InterruptedException
			{
				  driver.findElement(By.name("Qualification")).sendKeys("#$#^%&^&*(");
				  boolean qualification =driver.findElement(By.name("Qualification")).getAttribute("value").matches(qualification_pattern);
				  Assert.assertTrue(qualification, "College Name Contains Special Characters");
			}
			  
			@Test
			public void Qualification_contain_numbers()
			{
				    driver.findElement(By.name("Qualification")).clear();
				    driver.findElement(By.name("Qualification")).sendKeys("025547");
					boolean qualification =driver.findElement(By.name("Qualification")).getAttribute("value").matches(qualification_pattern);
					Assert.assertTrue(qualification, "College Name Contains Numbers");
			}
			
			@Test
			public void Qualification_contain_whitespaces()
			{
				    driver.findElement(By.name("Qualification")).clear();
				    driver.findElement(By.name("Qualification")).sendKeys("B Tech");
					boolean qualification =driver.findElement(By.name("Qualification")).getAttribute("value").matches(qualification_pattern);
					Assert.assertTrue(qualification, "College Name Contains Whitespaces");
			}
				
			@Test
			public void Qualification_contain_alphabets() 
			{
					driver.findElement(By.name("Qualification")).clear();
					driver.findElement(By.name("Qualification")).sendKeys("BE");
					boolean qualification =driver.findElement(By.name("Qualification")).getAttribute("value").matches(qualification_pattern);
					Assert.assertTrue(qualification, "College Name Contain Alphabets");
			}
				
			@Test
			public void Qualification_contain_whitespaces_at_begining() 
			{
					driver.findElement(By.name("Qualification")).clear();
					driver.findElement(By.name("Qualification")).sendKeys("   BE");
					boolean qualification =driver.findElement(By.name("Qualification")).getAttribute("value").matches(qualification_pattern);
					Assert.assertTrue(qualification, "College Name Contain Whitespaces at Begining");
			}
				
			@Test
			public void Qualification_field_is_Blank() throws InterruptedException 
			{
					driver.findElement(By.name("Qualification")).clear();
					driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/ul/li[2]/button")).click();
					Thread.sleep(2000);
					String actual = driver.findElement(By.xpath("//*[@id=\"parsley-id-12\"]/li")).getText();
					String expected = "This value is required.";
					Assert.assertEquals(actual, expected, "Qualification Accepted Blank Field");
			}
			
			//Aadhar No
			@Test
			public void Aadharno_contain_special_characters()
			{
				driver.findElement(By.name("AddharNo")).sendKeys("!@#$%^&*()");
				boolean aadharno =driver.findElement(By.name("AddharNo")).getAttribute("value").matches(aadharno_pattern);
				Assert.assertTrue(aadharno, "Aadhar No Contains Spaecial Characters");
			}
		
			@Test
			public void Aadharno_contain_alphabets()
			{
				driver.findElement(By.name("AddharNo")).clear();
				driver.findElement(By.name("AddharNo")).sendKeys("aadhar");
				boolean aadharno =driver.findElement(By.name("AddharNo")).getAttribute("value").matches(aadharno_pattern);
				Assert.assertTrue(aadharno, "Aadhar No Contains Alphabets");
			}
			
			@Test
			public void Aadharno_contain_numbers()
			{
				driver.findElement(By.name("AddharNo")).clear();
				driver.findElement(By.name("AddharNo")).sendKeys("259625854984");
				boolean aadharno =driver.findElement(By.name("AddharNo")).getAttribute("value").matches(aadharno_pattern);
				Assert.assertTrue(aadharno, "Aadhar No Contains Numbers");
			}
			
			@Test
			public void Aadharno_contain_negative_numbers()
			{
				driver.findElement(By.name("AddharNo")).clear();
				driver.findElement(By.name("AddharNo")).sendKeys("-557855");
				boolean aadharno =driver.findElement(By.name("AddharNo")).getAttribute("value").matches(aadharno_pattern);
				Assert.assertTrue(aadharno, "Aadhar No Contains Negative Numbers");
			}
			
			@Test
		  	public void Aadharno_contain_whitespaces_at_begining() 
			{
				driver.findElement(By.name("AddharNo")).clear();
				driver.findElement(By.name("AddharNo")).sendKeys("  998825632563");
				boolean aadharno =driver.findElement(By.name("AddharNo")).getAttribute("value").matches(aadharno_pattern);
				Assert.assertTrue(aadharno, "Aadhar No Contains Whitespaces at begining");
			}
			
			@Test
		  	public void Aadharno_contain_lessthan_12_numbers() 
			{
				driver.findElement(By.name("AddharNo")).clear();
				driver.findElement(By.name("AddharNo")).sendKeys("1452");
				boolean aadharno =driver.findElement(By.name("AddharNo")).getAttribute("value").matches(aadharno_pattern);
				Assert.assertTrue(aadharno, "Aadhar No Contains Less than 12 numbers");
			}
			
			@Test
		  	public void Aadharno_contain_greaterthan_12_numbers() 
			{
				driver.findElement(By.name("AddharNo")).clear();
				driver.findElement(By.name("AddharNo")).sendKeys("123456789156324");
				boolean aadharno =driver.findElement(By.name("AddharNo")).getAttribute("value").matches(aadharno_pattern);
				Assert.assertTrue(aadharno, "Aadhar No Contains Whitespaces at begining");
			}
			
			//Date of Birth
			@Test
			public void Birthdate_Field_is_Blank() throws InterruptedException
			{
				driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/ul/li[2]/button")).click();
				Thread.sleep(1500);
				String actual = driver.findElement(By.xpath("//*[@id=\"parsley-id-16\"]/li")).getText();
				String expected = "This value is required.";
				Assert.assertEquals(actual, expected, "Birth Date Accepted Blank Field");
			}
			
			@Test
			public void Birthdate_functionality() throws InterruptedException
			{
				driver.findElement(By.name("DateOfBirth")).sendKeys("11/12/1995");
				Thread.sleep(1500);
				boolean dateofbirth =driver.findElement(By.name("DateOfBirth")).getAttribute("value").matches(dateofbirth_pattern);
				
				Assert.assertTrue(dateofbirth, "Date of Birth is NOT Getting Accepted");
			}
			
			
			//Gender
			@Test
			public void Blank_Gender_field() throws InterruptedException
			{
				boolean genderlist =driver.findElement(By.name("Gender")).getAttribute("value").matches(gender_pattern);
				Assert.assertTrue(genderlist, "Gender field is Blank");				
			}
			
			@Test
			public void Gender_functionality()
			{
				Select drpgenderlist = new Select(driver.findElement(By.name("Gender")));
				drpgenderlist.selectByVisibleText("Female");
				boolean genderlist =driver.findElement(By.name("Gender")).getAttribute("value").matches(gender_pattern);
				Assert.assertTrue(genderlist, "Gender field NOT Working");				
			}
			
			//Next Button
			@Test
			public void PersonalInfo_next_button_functionality()
			{
				driver.findElement(By.name("FirstName")).sendKeys("Ashwini");
				driver.findElement(By.name("LastName")).sendKeys("Patil");
				driver.findElement(By.id("College")).sendKeys("K.K.Wagh");
				driver.findElement(By.id("Qualification")).sendKeys("B.E");
				driver.findElement(By.id("AddharNo")).sendKeys("789654123012");
				driver.findElement(By.id("DateOfBirth")).sendKeys("12/11/1995");
				Select drpgenderlist = new Select(driver.findElement(By.name("Gender")));
				drpgenderlist.selectByVisibleText("Female");
				driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/ul/li[2]/button")).click();
				String actual = driver.findElement(By.xpath("//*[@id=\"wizard\"]/ul/li[2]/a")).getText();
				String expected = "2. Communication details";
				Assert.assertEquals(actual, expected, "Personal Info Next buttuon NOT Working");
			}	
			
		//Primary Mobile No

			@Test
		  	public void Primary_mobno_field_is_Blank() throws InterruptedException 
			{
				driver.findElement(By.name("MobilePrimary")).clear();
				driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/ul/li[2]/button")).click();
				Thread.sleep(1500);
				String actual = driver.findElement(By.xpath("//*[@id=\"parsley-id-22\"]/li")).getText();
				String expected = "This value is required.";
				Assert.assertEquals(actual, expected, "Primary Mobile No Accepted Blank Field");
			}
			@Test
			public void Primary_mobno_contain_special_characters()
			{
				driver.findElement(By.name("MobilePrimary")).sendKeys("!@#$%^&*()");
				boolean primarymob =driver.findElement(By.name("MobilePrimary")).getAttribute("value").matches(primarymobileno_pattern);
				Assert.assertTrue(primarymob, "Primary Mobile No Contains Spaecial Characters");
			}
		
			@Test
			public void Primary_mobno_contain_whitespaces()
			{
				driver.findElement(By.name("MobilePrimary")).clear();
				driver.findElement(By.name("MobilePrimary")).sendKeys("25985 38478");
				boolean primarymob =driver.findElement(By.name("MobilePrimary")).getAttribute("value").matches(primarymobileno_pattern);
				Assert.assertTrue(primarymob, "Primary Mobile No Contains Whitespaces");
			}
			
			@Test
			public void Primary_mobno_contain_alphabets()
			{
				driver.findElement(By.name("MobilePrimary")).clear();
				driver.findElement(By.name("MobilePrimary")).sendKeys("mobile");
				boolean primarymob =driver.findElement(By.name("MobilePrimary")).getAttribute("value").matches(primarymobileno_pattern);
				Assert.assertTrue(primarymob, "Primary Mobile No Contains Alphabets");
			}
			
			@Test
			public void Primary_mobno_contain_numbers()
			{
				driver.findElement(By.name("MobilePrimary")).clear();
				driver.findElement(By.name("MobilePrimary")).sendKeys("9630124587");
				boolean primarymob =driver.findElement(By.name("MobilePrimary")).getAttribute("value").matches(primarymobileno_pattern);
				Assert.assertTrue(primarymob, "Primary Mobile No Contains Numbers");
			}
			
			@Test
			public void Primary_mobno_contain_negative_numbers()
			{
				driver.findElement(By.name("MobilePrimary")).clear();
				driver.findElement(By.name("MobilePrimary")).sendKeys("-557855");
				boolean primarymob =driver.findElement(By.name("MobilePrimary")).getAttribute("value").matches(primarymobileno_pattern);
				Assert.assertTrue(primarymob, "Primary Mobile No Contains Negative Numbers");
			}
			
			@Test
		  	public void Primary_mobno_contain_whitespaces_at_begining() 
			{
				driver.findElement(By.name("MobilePrimary")).clear();
				driver.findElement(By.name("MobilePrimary")).sendKeys("  9874563210");
				boolean primarymob =driver.findElement(By.name("MobilePrimary")).getAttribute("value").matches(primarymobileno_pattern);
				Assert.assertTrue(primarymob, "Primary Mobile No Contains Whitespaces at begining");
			}
			
			
			@Test
		  	public void Primary_mobno_contain_lessthan_10_numbers() 
			{
				driver.findElement(By.name("MobilePrimary")).clear();
				driver.findElement(By.name("MobilePrimary")).sendKeys("8989");
				boolean primarymob =driver.findElement(By.name("MobilePrimary")).getAttribute("value").matches(primarymobileno_pattern);
				Assert.assertTrue(primarymob, "Primary Mobile No Contains Less than 10 numbers");
			}
			
			@Test
		  	public void Primary_mobno_contain_greaterthan_10_numbers() 
			{
				driver.findElement(By.name("MobilePrimary")).clear();
				driver.findElement(By.name("MobilePrimary")).sendKeys("7896541230123");
				boolean primarymob =driver.findElement(By.name("MobilePrimary")).getAttribute("value").matches(primarymobileno_pattern);
				Assert.assertTrue(primarymob, "Primary Mobile No contains greater than 10 numbers");
			}
			
			//Secondary Mobile No
			@Test
			public void Secondary_mobno_contain_special_characters()
			{
				driver.findElement(By.name("MobileSecondary")).sendKeys("!@#$%^&*()");
				boolean secondarymob =driver.findElement(By.name("MobileSecondary")).getAttribute("value").matches(secondarymobileno_pattern);
				Assert.assertTrue(secondarymob, "Secondary Mobile No Contains Spaecial Characters");
			}
		
			@Test
			public void Secondary_mobno_contain_whitespaces()
			{
				driver.findElement(By.name("MobileSecondary")).clear();
				driver.findElement(By.name("MobileSecondary")).sendKeys("25985 38478");
				boolean secondarymob =driver.findElement(By.name("MobileSecondary")).getAttribute("value").matches(secondarymobileno_pattern);
				Assert.assertTrue(secondarymob, "Secondary Mobile No Contains Whitespaces");
			}
			
			@Test
			public void Secondary_mobno_contain_alphabets()
			{
				driver.findElement(By.name("MobileSecondary")).clear();
				driver.findElement(By.name("MobileSecondary")).sendKeys("mobile");
				boolean secondarymob =driver.findElement(By.name("MobileSecondary")).getAttribute("value").matches(secondarymobileno_pattern);
				Assert.assertTrue(secondarymob, "Secondary Mobile No Contains Alphabets");
			}
			
			@Test
			public void Secondary_mobno_contain_numbers()
			{
				driver.findElement(By.name("MobileSecondary")).clear();
				driver.findElement(By.name("MobileSecondary")).sendKeys("9630124587");
				boolean secondarymob =driver.findElement(By.name("MobileSecondary")).getAttribute("value").matches(secondarymobileno_pattern);
				Assert.assertTrue(secondarymob, "Secondary Mobile No Contains Numbers");
			}
			
			@Test
			public void Secondary_mobno_contain_negative_numbers()
			{
				driver.findElement(By.name("MobileSecondary")).clear();
				driver.findElement(By.name("MobileSecondary")).sendKeys("-557855");
				boolean secondarymob =driver.findElement(By.name("MobileSecondary")).getAttribute("value").matches(secondarymobileno_pattern);
				Assert.assertTrue(secondarymob, "Secondary Mobile No Contains Negative Numbers");
			}
			
			@Test
		  	public void Secondary_mobno_contain_whitespaces_at_begining() 
			{
				driver.findElement(By.name("MobileSecondary")).clear();
				driver.findElement(By.name("MobileSecondary")).sendKeys("  7410258963");
				boolean secondarymob =driver.findElement(By.name("MobileSecondary")).getAttribute("value").matches(secondarymobileno_pattern);
				Assert.assertTrue(secondarymob, "Secondary Mobile No Contains Whitespaces at begining");
			}
			
			@Test
			public void Secondary_mobno_contain_lessthan_10_numbers() 
			{
				driver.findElement(By.name("MobileSecondary")).clear();
				driver.findElement(By.name("MobileSecondary")).sendKeys("8989");
				boolean secondarymob =driver.findElement(By.name("MobileSecondary")).getAttribute("value").matches(secondarymobileno_pattern);
				Assert.assertTrue(secondarymob, "Secondary Mobile No Contains Less than 10 numbers");
			}
			
			@Test
		  	public void Secondary_mobno_contain_greaterthan_10_numbers() 
			{
				driver.findElement(By.name("MobileSecondary")).clear();
				driver.findElement(By.name("MobileSecondary")).sendKeys("7896541230123");
				boolean secondarymob =driver.findElement(By.name("MobileSecondary")).getAttribute("value").matches(secondarymobileno_pattern);
				Assert.assertTrue(secondarymob, "Secondary Mobile No contains greater than 10 numbers");
			}
			
			//Primary Email
			@Test
			public void Primary_email_is_Blank()
			{
				String actual = driver.findElement(By.xpath("//*[@id=\"parsley-id-26\"]/li[1]")).getText();
				String expected = "This value is required.";
				Assert.assertEquals(actual, expected, "Primary Email Accepted Blank Field");
			}
			
			@Test
			public void Primary_email_contain_whitespaces() throws InterruptedException
			{
				driver.findElement(By.name("EmailPrimary")).clear();
				driver.findElement(By.name("EmailPrimary")).sendKeys("abc @gmail.com");
				driver.findElement(By.xpath("//*[@id=\"parsley-id-26\"]/li")).click();
				String actual = driver.findElement(By.xpath("//*[@id=\"parsley-id-26\"]/li")).getText();
				String expected = "This value should be a valid email.";
				Assert.assertEquals(actual, expected, "Primary Email Contains Whitespaces");
			}
			
			@Test
			public void Primary_email_valid()
			{
				driver.findElement(By.name("EmailPrimary")).clear();
				driver.findElement(By.name("EmailPrimary")).sendKeys("abc@gmail.com");
				String actual = "";
				String expected = "";
				Assert.assertEquals(actual, expected, "Primary Email Id is NOT valid");
			}
		
		
			@Test
		  	public void Primary_email_contain_whitespaces_at_begining() throws InterruptedException 
			{
				driver.findElement(By.name("EmailPrimary")).clear();
				Thread.sleep(1000);
				driver.findElement(By.name("EmailPrimary")).sendKeys("       abc@gmail.com");
				boolean primaryemail =driver.findElement(By.name("EmailSecondary")).getAttribute("value").matches(primary_email);
				Assert.assertTrue(primaryemail, "Primary Email contain Whitespaces at Begining");
			}
			
			@Test
		  	public void Primary_email_field_is_Blank() 
			{
				driver.findElement(By.name("EmailPrimary")).clear();
				driver.findElement(By.name("EmailPrimary")).sendKeys("  ");
				String actual = driver.findElement(By.xpath("//*[@id=\"parsley-id-26\"]/li[2]")).getText();
				String expected = "This value should be a valid email.";
				Assert.assertEquals(actual, expected, "Primary Email Contains Whitespaces at begining");
			}
			
			//Secondary Email
			@Test
			public void Secondary_email_contain_whitespaces() throws InterruptedException
			{
				driver.findElement(By.id("MobilePrimary")).sendKeys("9876543210");
				driver.findElement(By.id("MobileSecondary")).sendKeys("7894561230");
				driver.findElement(By.id("EmailPrimary")).sendKeys("ashwini@gmail.com");
				driver.findElement(By.name("CurrentAddress")).sendKeys("Flat no-15,Ganesh Appartment, Near Prasad Circle,Gangapur Road,Nashik");
				driver.findElement(By.name("PermanentAddress")).sendKeys("Flat no-15,Ganesh Appartment, Near Prasad Circle,Gangapur Road,Nashik");
				driver.findElement(By.id("PinCodeCurrentAddress")).sendKeys("422203");
				driver.findElement(By.id("PinCodePermanentAddress")).sendKeys("422203");
				driver.findElement(By.name("EmailSecondary")).sendKeys("abc  @gmail.com");
				Thread.sleep(1500);
				driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/ul/li[2]/button")).click();
				Thread.sleep(1500);
				String actual = driver.findElement(By.xpath("//*[@id=\"parsley-id-28\"]/li")).getText();
				String expected = "This value should be a valid email.";
				Assert.assertEquals(actual, expected, "Secondary Email Contains Whitespaces");
			}
			
			@Test
			public void Secondary_email_valid()
			{
				driver.findElement(By.name("EmailSecondary")).clear();
				driver.findElement(By.name("EmailSecondary")).sendKeys("abc@gmail.com");
				String actual = "";
				String expected = "";
				Assert.assertEquals(actual, expected, "Secondary Email Id is NOT valid");
			}
		
			
			@Test
		  	public void Secondary_email_contain_whitespaces_at_begining() throws InterruptedException 
			{
				driver.findElement(By.name("EmailSecondary")).clear();
				Thread.sleep(1000);
				driver.findElement(By.name("EmailSecondary")).sendKeys("       abc@gmail.com");
				boolean secondaryemail =driver.findElement(By.name("EmailSecondary")).getAttribute("value").matches(secondary_email);
				Assert.assertTrue(secondaryemail, "Secondary Email contain Whitespaces at Begining");
			}
			
			//Current Address
			@Test
			public void Valid_current_address()
			{
				driver.findElement(By.name("CurrentAddress")).clear();
				driver.findElement(By.name("CurrentAddress")).sendKeys("Flat no-15,Ganesh Appartment, Near Prasad Circle,Gangapur Road,Nashik");
				boolean currentaddress =driver.findElement(By.name("CurrentAddress")).getAttribute("value").matches(currentaddress_pattern);
				Assert.assertTrue(currentaddress, "Current Address in NOT valid");
			}
			
			@Test
			public void Blank_current_address() throws InterruptedException
			{
				driver.findElement(By.name("CurrentAddress")).clear();
				driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/ul/li[2]/button")).click();
				Thread.sleep(1000);
				String actual = driver.findElement(By.xpath("//*[@id=\"parsley-id-30\"]/li")).getText();
				String expected = "This value is required.";
				Assert.assertEquals(actual, expected, "Current Address is Blank");
			}
			
			//Permanent Address
			@Test
			public void Valid_permanent_address()
			{
				driver.findElement(By.name("CurrentAddress")).sendKeys("Flat no-15,Ganesh Appartment, Near Prasad Circle,Gangapur Road,Nashik");
				driver.findElement(By.name("PermanentAddress")).clear();
				driver.findElement(By.name("PermanentAddress")).sendKeys("Flat no-15,Ganesh Appartment, Near Prasad Circle,Gangapur Road,Nashik");
				boolean currentaddress =driver.findElement(By.name("PermanentAddress")).getAttribute("value").matches(permanentaddress_pattern);
				Assert.assertTrue(currentaddress, "Permanent Address in NOT valid");
			}
			
			//Pin code(Current Address)
			@Test
		  	public void Pincode_currentaddress_field_is_Blank() throws InterruptedException 
			{
				driver.findElement(By.name("PinCodeCurrentAddress")).clear();
				driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/ul/li[2]/button")).click();
				Thread.sleep(1000);
				String actual = driver.findElement(By.xpath("//*[@id=\"parsley-id-34\"]/li[1]")).getText();
				String expected = "This value is required.";
				Assert.assertEquals(actual, expected, "Pincode No Accepted Blank Field");
			}
			
			@Test
			public void Pincode_currentaddress_contain_special_characters()
			{
				driver.findElement(By.name("PinCodeCurrentAddress")).clear();
				driver.findElement(By.name("PinCodeCurrentAddress")).sendKeys("!@#$%^&*()");
				boolean pincode =driver.findElement(By.name("PinCodeCurrentAddress")).getAttribute("value").matches(pincode_currentaddress_pattern);
				Assert.assertTrue(pincode, "Pincode No Contains Spaecial Characters");
			}
		
			@Test
			public void Pincode_currentaddress_contain_whitespaces()
			{
				driver.findElement(By.name("PinCodeCurrentAddress")).clear();
				driver.findElement(By.name("PinCodeCurrentAddress")).sendKeys("25985 38478");
				boolean pincode =driver.findElement(By.name("PinCodeCurrentAddress")).getAttribute("value").matches(pincode_currentaddress_pattern);
				Assert.assertTrue(pincode, "Pincode No Contains Whitespaces");
			}
			
			@Test
			public void Pincode_currentaddress_contain_alphabets()
			{
				driver.findElement(By.name("PinCodeCurrentAddress")).clear();
				driver.findElement(By.name("PinCodeCurrentAddress")).sendKeys("pincode");
				boolean pincode =driver.findElement(By.name("PinCodeCurrentAddress")).getAttribute("value").matches(pincode_currentaddress_pattern);
				Assert.assertTrue(pincode, "Pincode No Contains Alphabets");
			}
			
			@Test
			public void Pincode_currentaddress_contain_numbers()
			{
				driver.findElement(By.name("PinCodeCurrentAddress")).clear();
				driver.findElement(By.name("PinCodeCurrentAddress")).sendKeys("259625");
				boolean pincode =driver.findElement(By.name("PinCodeCurrentAddress")).getAttribute("value").matches(pincode_currentaddress_pattern);
				Assert.assertTrue(pincode, "Pincode No Contains Numbers");
			}
			
			@Test
			public void Pincode_currentaddress_contain_negative_numbers()
			{
				driver.findElement(By.name("PinCodeCurrentAddress")).clear();
				driver.findElement(By.name("PinCodeCurrentAddress")).sendKeys("-557855");
				boolean pincode =driver.findElement(By.name("PinCodeCurrentAddress")).getAttribute("value").matches(pincode_currentaddress_pattern);
				Assert.assertTrue(pincode, "Pincode No Contains Negative Numbers");
			}
			
			@Test
		  	public void Pincode_currentaddress_contain_whitespaces_at_begining() 
			{
				driver.findElement(By.name("PinCodeCurrentAddress")).clear();
				driver.findElement(By.name("PinCodeCurrentAddress")).sendKeys("  998898");
				boolean pincode =driver.findElement(By.name("PinCodeCurrentAddress")).getAttribute("value").matches(pincode_currentaddress_pattern);
				Assert.assertTrue(pincode, "Pincode No Contains Whitespaces at begining");
			}
			
			
			@Test
			public void Pincode_currentaddress_contain_morethan_6_numbers()
			{
				driver.findElement(By.name("PinCodeCurrentAddress")).clear();
				driver.findElement(By.name("PinCodeCurrentAddress")).sendKeys("589632104");
				boolean pincode =driver.findElement(By.name("PinCodeCurrentAddress")).getAttribute("value").matches(pincode_currentaddress_pattern);
				Assert.assertTrue(pincode, "Pincode No is Blank");
			}
			
			@Test
			public void Pincode_currentaddress_contain_lessthan_6_numbers()
			{
				driver.findElement(By.name("PinCodeCurrentAddress")).clear();
				driver.findElement(By.name("PinCodeCurrentAddress")).sendKeys("58964");
				String actual = driver.findElement(By.xpath("//*[@id=\"parsley-id-34\"]/li")).getText();
				String expected = "This value length is invalid. It should be between 6 and 6 characters long.";
				Assert.assertEquals(actual, expected, "Pin code contain less than 6 numbers");
			}
			
			
			
			//Pin code(Permanent Address)
			@Test
			public void Pincode_permanentaddress_contain_special_characters()
			{
				driver.findElement(By.name("PinCodePermanentAddress")).clear();
				driver.findElement(By.name("PinCodePermanentAddress")).sendKeys("!@#$%^&*()");
				boolean pincode =driver.findElement(By.name("PinCodePermanentAddress")).getAttribute("value").matches(pincode_permanentaddress_pattern);
				Assert.assertTrue(pincode, "Pincode No Contains Spaecial Characters");
			}
		
			@Test
			public void Pincode_permanentaddress_contain_whitespaces()
			{
				driver.findElement(By.name("PinCodePermanentAddress")).clear();
				driver.findElement(By.name("PinCodePermanentAddress")).sendKeys("25985 38478");
				boolean pincode =driver.findElement(By.name("PinCodePermanentAddress")).getAttribute("value").matches(pincode_permanentaddress_pattern);
				Assert.assertTrue(pincode, "Pincode No Contains Whitespaces");
			}
			
			@Test
			public void Pincode_permanentaddress_contain_alphabets()
			{
				driver.findElement(By.name("PinCodePermanentAddress")).clear();
				driver.findElement(By.name("PinCodePermanentAddress")).sendKeys("aadhar");
				boolean pincode =driver.findElement(By.name("PinCodePermanentAddress")).getAttribute("value").matches(pincode_permanentaddress_pattern);
				Assert.assertTrue(pincode, "Pincode No Contains Alphabets");
			}
			
			@Test
			public void Pincode_permanentaddress_contain_numbers()
			{
				driver.findElement(By.name("PinCodePermanentAddress")).clear();
				driver.findElement(By.name("PinCodePermanentAddress")).sendKeys("259625");
				boolean pincode =driver.findElement(By.name("PinCodePermanentAddress")).getAttribute("value").matches(pincode_permanentaddress_pattern);
				Assert.assertTrue(pincode, "Pincode No Contains Numbers");
			}
			
			@Test
			public void Pincode_permanentaddress_contain_negative_numbers()
			{
				driver.findElement(By.name("PinCodePermanentAddress")).clear();
				driver.findElement(By.name("PinCodePermanentAddress")).sendKeys("-557855");
				boolean pincode =driver.findElement(By.name("PinCodePermanentAddress")).getAttribute("value").matches(pincode_permanentaddress_pattern);
				Assert.assertTrue(pincode, "Pincode No Contains Negative Numbers");
			}
			
			@Test
		  	public void Pincode_permanentaddress_contain_whitespaces_at_begining() 
			{
				driver.findElement(By.name("PinCodePermanentAddress")).clear();
				driver.findElement(By.name("PinCodePermanentAddress")).sendKeys("  998898");
				boolean pincode =driver.findElement(By.name("PinCodePermanentAddress")).getAttribute("value").matches(pincode_permanentaddress_pattern);
				Assert.assertTrue(pincode, "Pincode No Contains Whitespaces at begining");
			}
			
			@Test
			public void Pincode_permanentaddress_contain_morethan_6_numbers()
			{
				driver.findElement(By.name("PinCodePermanentAddress")).clear();
				driver.findElement(By.name("PinCodePermanentAddress")).sendKeys("589632104");
				boolean pincode =driver.findElement(By.name("PinCodePermanentAddress")).getAttribute("value").matches(pincode_permanentaddress_pattern);
				Assert.assertTrue(pincode, "Pincode No is Blank");
			}
			
			@Test
			public void Pincode_permanentaddress_contain_lessthan_6_numbers() throws InterruptedException
			{
				driver.findElement(By.name("PinCodeCurrentAddress")).sendKeys("8");
				driver.findElement(By.name("PinCodePermanentAddress")).clear();
				driver.findElement(By.name("PinCodePermanentAddress")).sendKeys("58964");
				driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/ul/li[2]/button")).click();
				Thread.sleep(1500);
				String actual = driver.findElement(By.xpath("//*[@id=\"parsley-id-36\"]/li")).getText();
				Thread.sleep(1500);
				String expected = "This value length is invalid. It should be between 6 and 6 characters long.";
				Assert.assertEquals(actual, expected, "Pin code contain less than 6 numbers");

			}
			
			//Next Button
			@Test
			public void Communicationdetails_next_button_functionality()
			{
				driver.findElement(By.name("PinCodePermanentAddress")).sendKeys("2");
				driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/ul/li[2]/button")).click();
				String actual = driver.findElement(By.xpath("//*[@id=\"wizard\"]/ul/li[3]/a")).getText();
				String expected = "3. Follow-up details";
				Assert.assertEquals(actual, expected, "Next button NOT Working");
			}	
			
			//Course Interested
			
			@Test
			public void Course_interested_is_Blank()
			{
				driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/ul/li[2]/button")).click();
				String actual = driver.findElement(By.xpath("//*[@id=\"parsley-id-multiple-course-list\"]/li")).getText();
				String expected = "This value is required.";
				Assert.assertEquals(actual, expected, "Course Interested is NOT Working");
			}
			
			@Test
			public void Course_interested_functionality()
			{
				driver.findElement(By.id("s2id_autogen1")).sendKeys(Keys.ARROW_DOWN , Keys.ENTER);
				String actual = driver.findElement(By.xpath("//*[@id=\"s2id_course-list\"]/ul/li[1]/div")).getText();
				String expected = "DOT NET";
				Assert.assertEquals(actual, expected, "Course Interested is NOT Working");
			}
			
			@Test
			public void Multiple_Course_Interested()
			{
				driver.findElement(By.id("s2id_autogen1")).sendKeys(Keys.ARROW_DOWN , Keys.ENTER);
				String actual = driver.findElement(By.xpath("//*[@id=\"s2id_course-list\"]/ul/li[2]/div")).getText();
				String expected = "JAVA";
				Assert.assertEquals(actual, expected, "Multiple Course Interested is NOT Working");
			}
			
			//Requires Demo Lecture
			@Test
			public void Blank_Demo_Lecture()
			{
				boolean	demolecture = driver.findElement(By.name("DemoLecture")).getAttribute("value").matches(demolecture_pattern);
				Assert.assertTrue(demolecture, "Demo Lecture Accepted Blank Field");
			}
			
			@Test
			public void Demo_lecture_functionality()
			{
				Select drpdemolecture = new Select(driver.findElement(By.name("DemoLecture")));
				drpdemolecture.selectByVisibleText("Yes");
				boolean demolecture =driver.findElement(By.name("DemoLecture")).getAttribute("value").matches(demolecture_pattern);
				Assert.assertTrue(demolecture, "Demo lecture field NOT Working");	
			}
			
			@Test
			public void Blank_Interest_level()
			{
				//driver.findElement(By.name("InterestLevelId")).clear();
				driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/ul/li[2]/button")).click();
				String actual = driver.findElement(By.xpath("//*[@id=\"parsley-id-46\"]/li")).getText();
				String expected = "This value is required.";
				Assert.assertEquals(actual, expected, "Interest Level accept blank field");
			}
			
			//Interest Level
			@Test
			public void Interest_level_functionality() 
			{
				Select drpinterestlevel = new Select(driver.findElement(By.name("InterestLevelId")));
				drpinterestlevel.selectByVisibleText("WARM");
				boolean interestlevel =driver.findElement(By.name("InterestLevelId")).getAttribute("value").matches(interestlevel_pattern);
				Assert.assertTrue(interestlevel, "Interest Level field NOT Working");	
			}
			
			
			//Next Follow Up
			
			@Test
			public void Blank_Next_Follow_Up_Date()
			{
				String actual = driver.findElement(By.xpath("//*[@id=\"parsley-id-48\"]/li")).getText();
				String expected = "This value is required.";
				Assert.assertEquals(actual, expected, "Next Follow Up accept Blank field");
			}
			
			@Test
			public void Next_Follow_Up_Date()
			{
				driver.findElement(By.name("NextFollowUp")).sendKeys("07/30/2018");
				boolean nxtfollowup =driver.findElement(By.name("NextFollowUp")).getAttribute("value").matches(nxtfollowup_pattern);
				Assert.assertTrue(nxtfollowup, "Next Follow Up date is NOT Getting Accepted");
			}
			
			//Follow Up Details
			@Test
			public void Blank_Follow_up_Details()
			{
				String actual = driver.findElement(By.xpath("//*[@id=\"parsley-id-50\"]/li")).getText();
				String expected = "This value is required.";
				Assert.assertEquals(actual, expected, "Follow Up Details Accept BLank Field");
			}
			
			@Test
			public void Follow_up_Details_functionality()
			{
				driver.findElement(By.name("FollowUpNote")).sendKeys("Intrested for DOT NET Course");
				boolean followupdetails =driver.findElement(By.name("NextFollowUp")).getAttribute("value").matches(followupdetails_pattern);
				Assert.assertTrue(followupdetails, "Follow Up Details is NOT Getting Accepted");
			}
			
			//Next Button
			@Test
			public void FollowUpDetails_next_button_functionality()
			{
				driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/ul/li[2]/button")).click();
				String actual = driver.findElement(By.xpath("//*[@id=\"wizard\"]/ul/li[4]/a")).getText();
				String expected = "4. How you know us?";
				Assert.assertEquals(actual, expected, "Next button NOT Working");
			}
			
			//Lead Source
			@Test
			public void Blank_Lead_Source()
			{
				driver.findElement(By.xpath("//*[@id=\"btn-save\"]")).click();
				String actual = driver.switchTo().alert().getText();
				String expected = "please select lead source";
				Assert.assertEquals(actual, expected, "Lead Source is Blank");
			}
			
			@Test
			public void Lead_Source_functionality()
			{
				driver.switchTo().alert().accept();
				Select drpleadsourse = new Select(driver.findElement(By.id("LeadSourceId")));
				drpleadsourse.selectByVisibleText("Phone Call");
				boolean leadsource =driver.findElement(By.id("LeadSourceId")).getAttribute("value").matches(leadsource_pattern);
				Assert.assertTrue(leadsource, "Lead Source field NOT Working");
			}
			
			//Assign to
			@Test
			public void Assign_to()
			{
				Select drpassignto = new Select(driver.findElement(By.id("EmployeeId")));
				drpassignto.selectByVisibleText("tECHBONA TEST");
				
			}
			
			//Reference Name
			@Test
			public void Reference_Name_functionality()
			{
				driver.findElement(By.id("ReferenceName")).sendKeys("Nilesh Ahire");
				boolean leadsource =driver.findElement(By.id("ReferenceName")).getAttribute("value").matches(refname_pattern);
				Assert.assertTrue(leadsource, "Lead Source field NOT Working");
			}
			
			//Created Date
			@Test
			public void Todays_Created_Date()
			{
				Date date = new Date();
				String date1= new SimpleDateFormat("yyyy-MM-dd").format(date);
				String actual = driver.findElement(By.name("CreatedDate")).getAttribute("value");
				Assert.assertEquals(actual, date1, "Created Date NOT having Today's Date");
			}
			
			@Test
			public void Created_Date()
			{
				driver.findElement(By.name("CreatedDate")).sendKeys("16-08-2018");
				boolean createddate =driver.findElement(By.name("CreatedDate")).getAttribute("value").matches(createddate_pattern);
				Assert.assertTrue(createddate, "Created Date field NOT Working");
				System.out.println(driver.findElement(By.xpath("//*[@id=\"txtCreatedDate\"]")).getText());
				
			}
			
			//Finish Button
			@Test
			public void Finish_Button_functionality() throws InterruptedException
			{
				driver.findElement(By.xpath("//*[@id=\"btn-save\"]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id=\"btn-cancel\"]")).click();
				Thread.sleep(1000);
				String actualname = driver.findElement(By.xpath("//*[@id=\"view-lead-status\"]/tbody/tr/td[2]")).getText();
				String actualmobileno = driver.findElement(By.xpath("//*[@id=\"view-lead-status\"]/tbody/tr/td[3]")).getText();
				String actualcourse = driver.findElement(By.xpath("//*[@id=\"view-lead-status\"]/tbody/tr[1]/td[4]")).getText();
				String actualleadsource = driver.findElement(By.xpath("//*[@id=\"view-lead-status\"]/tbody/tr/td[5]")).getText();
				String actualleaddate = driver.findElement(By.xpath("//*[@id=\"view-lead-status\"]/tbody/tr/td[6]")).getText();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				String date = dateFormat.format(new Date());
				String actualassignto = driver.findElement(By.xpath("//*[@id=\"view-lead-status\"]/tbody/tr/td[7]")).getText();
				Assert.assertEquals(actualname, "Ashwini Ashok Patil", "Student Name not getting saved");
				Assert.assertEquals(actualmobileno, "7896541230", "Mobile No not getting saved");
				Assert.assertEquals(actualcourse, "DOT NET JAVA", "Course not getting saved");
				Assert.assertEquals(actualleadsource, "Phone Call", "Lead Source not getting saved");
				Assert.assertEquals(actualleaddate, "16/08/2018", "Assign To NOT Getting Saved");
			}
		
			//Update Lead
			@Test
			public void Update_functionalty() throws InterruptedException
			{
				driver.findElement(By.xpath("//*[@id=\"nav-state-toggle\"]")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id=\"view-lead-status\"]/tbody/tr/td[8]/button[1]/i")).click();
				WebDriverWait wait=new WebDriverWait(driver, 20);
				wait.until(ExpectedConditions.elementToBeClickable(By.name("FirstName")));
				driver.findElement(By.name("FirstName")).clear();
				  driver.findElement(By.name("FirstName")).sendKeys("Aarti");
				  driver.findElement(By.id("MiddleName")).clear();
				  driver.findElement(By.id("MiddleName")).sendKeys("Suresh");
				  driver.findElement(By.name("LastName")).clear();
				  driver.findElement(By.name("LastName")).sendKeys("Pawar");
				  driver.findElement(By.id("College")).clear();
				  driver.findElement(By.id("College")).sendKeys("NDMVP College");
				  driver.findElement(By.id("Qualification")).clear();
				  driver.findElement(By.id("Qualification")).sendKeys("B.Tech");
				  driver.findElement(By.id("AddharNo")).clear();
				  driver.findElement(By.id("AddharNo")).sendKeys("8520147963014785");
				  driver.findElement(By.xpath("//*[@id=\"DateOfBirth\"]")).sendKeys("12/11/1996");
				  Select updrpgenderlist = new Select(driver.findElement(By.name("Gender")));
				  updrpgenderlist.selectByVisibleText("Other");
				  Thread.sleep(2000);
				  driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/ul/li[2]/button/i")).click();
				 
				  driver.findElement(By.id("MobilePrimary")).clear();
				  driver.findElement(By.id("MobilePrimary")).sendKeys("1236547890");
				  driver.findElement(By.id("MobileSecondary")).clear();
				  driver.findElement(By.id("MobileSecondary")).sendKeys("7894561230");
				  driver.findElement(By.id("EmailPrimary")).clear();
				  driver.findElement(By.id("EmailPrimary")).sendKeys("aarti@gmail.com");
				  driver.findElement(By.id("EmailSecondary")).clear();
				  driver.findElement(By.id("EmailSecondary")).sendKeys("aarti11@gmail.com");
				  driver.findElement(By.name("CurrentAddress")).clear();
				  driver.findElement(By.name("CurrentAddress")).sendKeys("Flat no-9,Ganesh Appartment, Near Jehan Circle,Gangapur Road,Nashik");
				  driver.findElement(By.name("PermanentAddress")).clear();
				  driver.findElement(By.name("PermanentAddress")).sendKeys("Flat no-9,Ganesh Appartment, Near Jehan Circle,Gangapur Road,Nashik");
				  driver.findElement(By.id("PinCodeCurrentAddress")).clear();
				  driver.findElement(By.id("PinCodeCurrentAddress")).sendKeys("422205");
				  driver.findElement(By.id("PinCodePermanentAddress")).clear();
				  driver.findElement(By.id("PinCodePermanentAddress")).sendKeys("422205");
				  driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/ul/li[2]/button")).click();
				  
				  Select updrpdemolect = new Select(driver.findElement(By.id("ddlDemoLecture")));
				  updrpdemolect.selectByVisibleText("No");
				  Select updrpintlevel = new Select(driver.findElement(By.id("ddlInterestLevel")));
				  updrpintlevel.selectByVisibleText("COLD");
				  driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/ul/li[2]/button")).click();
				  
				  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				  Select updrpleadsourse = new Select(driver.findElement(By.id("LeadSourceId")));
				  updrpleadsourse.selectByVisibleText("Website");
				  Select drpassignto = new Select(driver.findElement(By.id("EmployeeId")));
				  drpassignto.selectByVisibleText("vaishali");
				  driver.findElement(By.id("ReferenceName")).clear();
				  driver.findElement(By.id("ReferenceName")).sendKeys("Nikhil");
				  driver.findElement(By.id("btn-save")).click();
				  
				String actualname = driver.findElement(By.xpath("//*[@id=\"view-lead-status\"]/tbody/tr/td[2]")).getText();
				String actualmobileno = driver.findElement(By.xpath("//*[@id=\"view-lead-status\"]/tbody/tr/td[3]")).getText();
				String actualcourse = driver.findElement(By.xpath("//*[@id=\"view-lead-status\"]/tbody/tr[1]/td[4]")).getText();
				String actualleadsource = driver.findElement(By.xpath("//*[@id=\"view-lead-status\"]/tbody/tr/td[5]")).getText();
				String actualleaddate = driver.findElement(By.xpath("//*[@id=\"view-lead-status\"]/tbody/tr/td[6]")).getText();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				String date = dateFormat.format(new Date());
				String actualassignto = driver.findElement(By.xpath("//*[@id=\"view-lead-status\"]/tbody/tr/td[7]")).getText();

				Assert.assertEquals(actualname, "Aarti Suresh Pawar", "Student Name not getting saved");
				Assert.assertEquals(actualmobileno, "1236547890", "Mobile No not getting saved");
				Assert.assertEquals(actualcourse, "DOT NET JAVA", "Course not getting saved");
				Assert.assertEquals(actualleadsource, "Website", "Lead Source not getting saved");
				Assert.assertEquals(actualleaddate, "16/08/2018", "Lead Date not getting saved");		  
				Assert.assertEquals(actualassignto, "vaishali", "Assign To NOT Getting Saved");

			}
			
			@Test
			public void Follow_Up_Cancel_Button() throws InterruptedException
			{
				//driver.findElement(By.xpath("//*[@id=\"nav-state-toggle\"]/i")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"view-lead-status\"]/tbody/tr/td[8]/button[2]/i")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id=\"btn-cancel\"]")).click();
				Thread.sleep(2000);
				String actual = driver.getCurrentUrl();
				String expected = "https://app.admin360.in/03-04-view-enquiry.html";
				Assert.assertEquals(actual, expected, "Cancel Button NOT Working");

			}
			
			//Next follow up Date
			@Test
			public void Blank_Next_Follow_Update() throws InterruptedException
			{
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id=\"view-lead-status\"]/tbody/tr/td[8]/button[2]/i")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id=\"btn-save\"]")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id=\"btn-save\"]")).click();
				Thread.sleep(2000);
				String actual = driver.findElement(By.xpath("//*[@id=\"parsley-id-8\"]/li")).getText();
				String expected = "This value is required.";
				Assert.assertEquals(actual, expected, "Next Follow Up accept Blank field");
			}
			
			@Test
			public void Next_Follow_Update()
			{
				driver.findElement(By.name("NextFollowUp")).sendKeys("07/30/2018");
				boolean nxtfollowup =driver.findElement(By.name("NextFollowUp")).getAttribute("value").matches(nxtfollowup_pattern);
				Assert.assertTrue(nxtfollowup, "Next Follow Up date is NOT Getting Accepted");
			}
			
			//Follow Up Mode
			@Test
			public void Blank_Follow_Up_Mode()
			{
				String actual = driver.findElement(By.xpath("//*[@id=\"parsley-id-6\"]/li")).getText();
				String expected = "This value is required.";
				Assert.assertEquals(actual, expected, "Follow Up Mode Accepted Blank Field");
						
			}
			
			@Test
			public void Follow_Up_Mode()
			{
				 Select drpfollowupmode = new Select(driver.findElement(By.name("FollowUpModeId")));
				 drpfollowupmode.selectByVisibleText("SMS");	
				 boolean followupmode =driver.findElement(By.name("FollowUpModeId")).getAttribute("value").matches(followupmode_pattern);
				 Assert.assertTrue(followupmode, "Follow Up Mode Field NOT Working");
			}
			
			//Notes
			@Test
			public void Blank_Notes()
			{
				String actual = driver.findElement(By.xpath("//*[@id=\"parsley-id-10\"]/li")).getText();
				String expected = "This value is required.";
				Assert.assertEquals(actual, expected, "Notes Accepted Blank Field");
			}
			
			@Test
			public void Notes()
			{
				driver.findElement(By.id("elastic-textarea")).sendKeys("DOT NET Course");
				boolean notes =driver.findElement(By.id("elastic-textarea")).getAttribute("value").matches(notes_pattern);
				Assert.assertTrue(notes, "Notes Field NOT Working");
			}
			
			//Save Button (Enquiry Follow Up)
			@Test
			public void Followup_save_button_functionality() throws InterruptedException
			{
				driver.findElement(By.xpath("//*[@id=\"btn-save\"]")).click();
				Thread.sleep(3000);
				String actual = driver.getCurrentUrl();
				String expected = "https://app.admin360.in/03-04-view-enquiry.html";
				Assert.assertEquals(actual, expected, "Save Button NOT Working");
			}
			
			//Delete Enquiry
			@Test
			public void Delete_Enquiry_Cancel_Button() throws InterruptedException
			{
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"view-lead-status\"]/tbody/tr/td[8]/button[3]/i")).click();
				Thread.sleep(1500);
				driver.findElement(By.xpath("//*[@id=\"remove-modal\"]/div/div/div[2]/button[1]")).click();
				Thread.sleep(2000);
				String actual = driver.findElement(By.xpath("//*[@id=\"view-lead-status\"]/tbody/tr/td")).getText();
				String expected = "1";
				Assert.assertEquals(actual, expected, "Cancel Button NOT Working");
				
			}
			
			@Test
			public void Delete_Enquiry() throws InterruptedException
			{
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id=\"view-lead-status\"]/tbody/tr/td[8]/button[3]/i")).click();
				Thread.sleep(1500);
				driver.findElement(By.xpath("//*[@id=\"remove-receipt\"]")).click();
				Thread.sleep(2000);
				String actual = driver.findElement(By.xpath("//*[@id=\"view-lead-status\"]/tbody/tr/td")).getText();
				String expected = "No data available in table";
				Assert.assertEquals(actual, expected, "Enquiry NOT Getting Deleted");
			
			}
		
	}
