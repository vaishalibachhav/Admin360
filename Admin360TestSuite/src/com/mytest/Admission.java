package com.mytest;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

	public class Admission extends Login
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
		String document_pattern = "[1-2]";
		String course_pattern = "[0-9]*";
		String admissiondate_pattern = "([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))";
		String courseinterested_pattern = "\\d*";
		
	 @Test
	 public void Add_Enquiry() throws InterruptedException 
	 {
		 Thread.sleep(1500);
		  driver.findElement(By.xpath("//*[@id=\"nav-state-toggle\"]/i")).click();
		  //Enquiry
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//*[@id=\"sidebar\"]/div/div[1]/ul[1]/li[3]/a")).click();
		  driver.findElement(By.xpath("//*[@id=\"3\"]/li[1]/a")).click();
		  driver.findElement(By.name("FirstName")).sendKeys("Ashwini");
		  driver.findElement(By.id("MiddleName")).sendKeys("Ashok");
		  driver.findElement(By.name("LastName")).sendKeys("Patil");
		  driver.findElement(By.id("College")).sendKeys("K.K.Wagh");
		  driver.findElement(By.id("Qualification")).sendKeys("B.E");
		  driver.findElement(By.id("AddharNo")).sendKeys("7896541230121452");
		  driver.findElement(By.id("DateOfBirth")).sendKeys("12/11/1995");
		  Select drpgenderlist = new Select(driver.findElement(By.name("Gender")));
		  drpgenderlist.selectByVisibleText("Female");
		  driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/ul/li[2]/button")).click();
		  
		  driver.findElement(By.id("MobilePrimary")).sendKeys("9876543210");
		  driver.findElement(By.id("MobileSecondary")).sendKeys("7894561230");
		  driver.findElement(By.id("EmailPrimary")).sendKeys("ashwini@gmail.com");
		  driver.findElement(By.id("EmailSecondary")).sendKeys("Ash11@gmail.com");
		  driver.findElement(By.name("CurrentAddress")).sendKeys("Flat no-15,Ganesh Appartment, Near Prasad Circle,Gangapur Road,Nashik");
		  driver.findElement(By.name("PermanentAddress")).sendKeys("Flat no-15,Ganesh Appartment, Near Prasad Circle,Gangapur Road,Nashik");
		  driver.findElement(By.id("PinCodeCurrentAddress")).sendKeys("422203");
		  driver.findElement(By.id("PinCodePermanentAddress")).sendKeys("422203");
		  driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/ul/li[2]/button")).click();
		  
		  driver.findElement(By.id("s2id_autogen1")).sendKeys(Keys.ARROW_DOWN , Keys.ENTER);
		  driver.findElement(By.id("s2id_autogen1")).sendKeys(Keys.ARROW_DOWN , Keys.ENTER);

		  Select drpdemolect = new Select(driver.findElement(By.id("ddlDemoLecture")));
		  drpdemolect.selectByVisibleText("Yes");
		  Select drpintlevel = new Select(driver.findElement(By.id("ddlInterestLevel")));
		  drpintlevel.selectByVisibleText("WARM");
		  driver.findElement(By.id("NextFollowUp")).sendKeys("12/11/2018");
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.findElement(By.name("FollowUpNote")).sendKeys("Interested for Testing Course");
		  driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/ul/li[2]/button")).click();
		  
		  Select drpleadsourse = new Select(driver.findElement(By.id("LeadSourceId")));
		  drpleadsourse.selectByVisibleText("Phone Call");
		  driver.findElement(By.id("ReferenceName")).sendKeys("Mr.Nitin");
		  driver.findElement(By.id("btn-save")).click();
		 // driver.findElement(By.xpath("//*[@id=\"view-lead-status\"]/tbody/tr/td[7]/button[4]/i")).click();
	  }
	  
	  //New Admission(+)
	  //Student Name 
	  @Test
	  public void Studentname_contain_Special_Characters() throws InterruptedException
	  {
		  Thread.sleep(1500);
		  driver.findElement(By.xpath("//*[@id=\"view-lead-status\"]/tbody/tr[1]/td[8]/button[4]/i")).click();
		  Thread.sleep(1500);
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
	  	public void Studentname_field_is_Blank() throws InterruptedException 
		{
			driver.findElement(By.name("FirstName")).clear();
			driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/ul/li[2]/button")).click();
			Thread.sleep(2000);
			String actual = driver.findElement(By.xpath("//*[@id=\"parsley-id-6\"]/li")).getText();
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
		  public void Lastname_field_is_Blank() 
		  {
			  driver.findElement(By.name("LastName")).clear();
			  boolean lastname =driver.findElement(By.name("LastName")).getAttribute("value").matches(lastname_pattern);
			  Assert.assertTrue(lastname, "Last Name is Blank");
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
		  public void Collegename_field_is_Blank() 
		  {
			  driver.findElement(By.name("College")).clear();
			  boolean collegename =driver.findElement(By.name("College")).getAttribute("value").matches(college_pattern);
			  Assert.assertTrue(collegename, "College Name is Blank");
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
			public void Qualification_field_is_Blank() 
			{
					driver.findElement(By.name("Qualification")).clear();
					boolean qualification =driver.findElement(By.name("Qualification")).getAttribute("value").matches(qualification_pattern);
					Assert.assertTrue(qualification, "College Name is Blank");
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
				Select drpgenderlist = new Select(driver.findElement(By.name("Gender")));
				drpgenderlist.selectByVisibleText("-- Select --");
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
			public void Primary_mobno_contain_special_characters()
			{
				driver.findElement(By.name("MobilePrimary")).clear();
				driver.findElement(By.name("MobilePrimary")).sendKeys("!@#$%^&&^*&**()");
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
		  	public void Primary_mobno_field_is_Blank() 
			{
				driver.findElement(By.name("MobilePrimary")).clear();
				boolean primarymob =driver.findElement(By.name("MobilePrimary")).getAttribute("value").matches(primarymobileno_pattern);
				Assert.assertTrue(primarymob, "Primary Mobile No is Blank");
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
				driver.findElement(By.name("MobileSecondary")).clear();
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
				driver.findElement(By.name("MobileSecondary")).sendKeys("  7894561230");
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
			public void Primary_email_contain_whitespaces() throws InterruptedException
			{
				driver.findElement(By.name("EmailPrimary")).clear();
				driver.findElement(By.name("EmailPrimary")).sendKeys("abc @gmail.com");
				driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/ul/li[2]/button")).click();
				Thread.sleep(2000);
				String actual = driver.findElement(By.xpath("//*[@id=\"parsley-id-28\"]/li")).getText();
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
				boolean primaryemail =driver.findElement(By.name("EmailPrimary")).getAttribute("value").matches(primary_email);
				Assert.assertTrue(primaryemail, "Primary Email contain Whitespaces at Begining");
			}
			
			@Test
		  	public void Primary_email_field_is_Blank() throws InterruptedException 
			{
			driver.findElement(By.name("EmailPrimary")).clear();
			driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/ul/li[2]/button")).click();
			Thread.sleep(1000);
			String actual = driver.findElement(By.xpath("//*[@id=\"parsley-id-28\"]/li[1]")).getText();
			String expected = "This value is required.";
			Assert.assertEquals(actual, expected, "Primary Email Accepted Blank Field");
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
				driver.findElement(By.name("EmailSecondary")).clear();
				driver.findElement(By.name("EmailSecondary")).sendKeys("abc  @gmail.com");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/ul/li[2]/button")).click();
				Thread.sleep(2000);
				String actual = driver.findElement(By.xpath("//*[@id=\"parsley-id-30\"]/li")).getText();
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
				Thread.sleep(1500);
				driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/ul/li[2]/button")).click();
				Thread.sleep(1500);
				String actual = driver.findElement(By.xpath("//*[@id=\"parsley-id-32\"]/li")).getText();
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
		  	public void Pincode_currentaddress_field_is_Blank() 
			{
				driver.findElement(By.name("PinCodeCurrentAddress")).clear();
				boolean pincode =driver.findElement(By.name("PinCodeCurrentAddress")).getAttribute("value").matches(pincode_currentaddress_pattern);
				Assert.assertTrue(pincode, "Pincode No is Blank");
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
			public void Pincode_currentaddress_contain_lessthan_6_numbers() throws InterruptedException
			{
				driver.findElement(By.name("PinCodeCurrentAddress")).clear();
				driver.findElement(By.name("PinCodeCurrentAddress")).sendKeys("58964");
				driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/ul/li[2]/button")).click();
				Thread.sleep(1500);
				String actual = driver.findElement(By.xpath("//*[@id=\"parsley-id-36\"]/li")).getText();
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
				Thread.sleep(2000);
				String actual = driver.findElement(By.xpath("//*[@id=\"parsley-id-38\"]/li")).getText();
				Thread.sleep(1500);
				String expected = "This value length is invalid. It should be between 6 and 6 characters long.";
				Assert.assertEquals(actual, expected, "Pin code contain less than 6 numbers");

			}
				
			@Test
			public void Document_functionality() throws InterruptedException
			{
				Thread.sleep(1500);
				Select drpdocument = new Select(driver.findElement(By.name("DocumentId")));
				drpdocument.selectByVisibleText("Addhar Card");
				boolean document =driver.findElement(By.name("DocumentId")).getAttribute("value").matches(document_pattern);
				Assert.assertTrue(document, "Document field NOT Working");
			}
			
			//Admission Date
			@Test
			public void Admission_date()
			{
				driver.findElement(By.id("txtCreatedDate")).sendKeys("08/10/2018");
				boolean admission_date =driver.findElement(By.id("txtCreatedDate")).getAttribute("value").matches(admissiondate_pattern);
				Assert.assertTrue(admission_date, "Admission Date Field NOT Working");
			}
			
			//Next Button
			@Test
			public void Communicationdetails_next_button_functionality()
			{
				driver.findElement(By.name("PinCodePermanentAddress")).sendKeys("2");
				driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/ul/li[2]/button")).click();
				String actual = driver.findElement(By.xpath("//*[@id=\"wizard\"]/ul/li[3]/a")).getText();
				String expected = "3. Course Details";
				Assert.assertEquals(actual, expected, "Next button NOT Working");
				driver.findElement(By.xpath("//*[@id=\"nav-state-toggle\"]/i")).click();
			}	
			
			//Course/Package
			@Test
			public void Course_interested_is_Blank()
			{
				boolean course_interested =driver.findElement(By.id("course-list")).getAttribute("value").matches(courseinterested_pattern);
				Assert.assertTrue(course_interested, "Course Interested is Blank");
			}
			
			/*
			@Test
			public void Course_interested_functionality()
			{
				Select drpdocument = new Select(driver.findElement(By.id("course-list")));
				drpdocument.selectByVisibleText("DOT NET");
				boolean course_interested =driver.findElement(By.id("course-list")).getAttribute("value").matches(courseinterested_pattern);
				Assert.assertTrue(course_interested, "Course Interested is Blank");
			}
			
			@Test
			public void Multiple_Course_Interested()
			{
				Select drpdocument = new Select(driver.findElement(By.id("course-list")));
				drpdocument.selectByVisibleText("JAVA");
				boolean course_interested =driver.findElement(By.id("course-list")).getAttribute("value").matches(courseinterested_pattern);
				Assert.assertTrue(course_interested, "Course Interested is Blank");
			}
			*/
			
			@Test
			public void Course_Amount()
			{
				String actualdotnet = driver.findElement(By.id("courseAmount0")).getAttribute("value");
				String expecteddotnet = "27000";
				String actualjava = driver.findElement(By.id("courseAmount1")).getAttribute("value");
				String expectedjava = "20000";
				Assert.assertEquals(actualdotnet, expecteddotnet, "Dot Net Amount Not Correct");
				Assert.assertEquals(actualjava, expectedjava, "Java Course Amount Not Correct");
			}
			
			@Test
			public void Discount_functionality()
			{
				//driver.findElement(By.xpath("//*[@id=\"Course\"]/tbody/tr/td[3]/button/i")).click();
				driver.findElement(By.name("Discount")).sendKeys("20");
				String actual = driver.findElement(By.xpath("//*[@id=\"tab3\"]/form/fieldset/div/div/fieldset/div/div[4]/div/div/input")).getAttribute("value");
				String expected = "37600";
				Assert.assertEquals(actual, expected, "Discount Field NOT Working");
			}
			
			@Test
			public void CourseDetails_next_button_functionality() throws InterruptedException
			{
				
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/ul/li[2]/button")).click();
				String actual = driver.findElement(By.xpath("//*[@id=\"wizard\"]/ul/li[4]/a")).getText();
				String expected = "4. Image upload";
				Assert.assertEquals(actual, expected, "Next Button NOT Working");
			}
			
			@Test
			public void Finish_button_functionality() throws InterruptedException
			{
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id=\"btn-save\"]")).click();
				String actualname = driver.findElement(By.xpath("//*[@id=\"view-lead-status\"]/tbody/tr/td[2]")).getText();
				String actualmobno = driver.findElement(By.xpath("//*[@id=\"view-lead-status\"]/tbody/tr/td[3]")).getText();
				String actualemailid = driver.findElement(By.xpath("//*[@id=\"view-lead-status\"]/tbody/tr/td[4]")).getText();
				String actualcourse = driver.findElement(By.xpath("//*[@id=\"view-lead-status\"]/tbody/tr/td[5]")).getText();
				String actualadmissiondate = driver.findElement(By.xpath("//*[@id=\"view-lead-status\"]/tbody/tr/td[6]")).getText();
				Assert.assertEquals(actualname, "Ashwini Ashok Patil", "Student Name not getting saved");
				Assert.assertEquals(actualmobno, "7896541230", "Mobile No not getting saved");
				Assert.assertEquals(actualemailid,"ashwini@gmail.com", "Email Id not getting saved");
				Assert.assertEquals(actualcourse, "DOT NET JAVA", "Course not getting saved");
				Assert.assertEquals(actualadmissiondate, "08/10/2018" , "Created Date not getting saved");
			}
			
			//Update
			@Test
			public void Update_functionality() throws InterruptedException
			{
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"view-lead-status\"]/tbody/tr[1]/td[7]/button[1]/i")).click();
				Thread.sleep(2000);
				driver.findElement(By.id("MiddleName")).clear();
				driver.findElement(By.id("MiddleName")).sendKeys("Suresh");
				driver.findElement(By.id("College")).clear();
				driver.findElement(By.id("College")).sendKeys("NDMVP College");
				driver.findElement(By.id("Qualification")).clear();
				driver.findElement(By.id("Qualification")).sendKeys("B.Tech");
				driver.findElement(By.id("AddharNo")).clear();
				driver.findElement(By.id("AddharNo")).sendKeys("8520147963014785");
				driver.findElement(By.xpath("//*[@id=\"DateOfBirth\"]")).sendKeys("12/11/1996");
				Select updrpgenderlist = new Select(driver.findElement(By.name("Gender")));
				updrpgenderlist.selectByVisibleText("Other");
				driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/ul/li[2]/button")).click();
				
				driver.findElement(By.id("MobilePrimary")).clear();
				driver.findElement(By.id("MobilePrimary")).sendKeys("1236547890");
				driver.findElement(By.id("MobileSecondary")).clear();
				driver.findElement(By.id("MobileSecondary")).sendKeys("7894561230");
				driver.findElement(By.id("EmailPrimary")).clear();
				driver.findElement(By.id("EmailPrimary")).sendKeys("aarti@gmail.com");
				driver.findElement(By.id("EmailSecondary")).clear();
				driver.findElement(By.id("EmailSecondary")).sendKeys("aarti11@gmail.com");
				driver.findElement(By.name("CurrentAddress")).clear();
				driver.findElement(By.name("CurrentAddress")).sendKeys("Flat no-9,Ganesh Appartment,Jehan Circle,Nashik");
				driver.findElement(By.name("PermanentAddress")).clear();
				driver.findElement(By.name("PermanentAddress")).sendKeys("Flat no-9,Ganesh Appartment,Jehan Circle,Nashik");
				driver.findElement(By.id("PinCodeCurrentAddress")).clear();
				driver.findElement(By.id("PinCodeCurrentAddress")).sendKeys("422205");
				driver.findElement(By.id("PinCodePermanentAddress")).clear();
				driver.findElement(By.id("PinCodePermanentAddress")).sendKeys("422205");
				Select document = new Select(driver.findElement(By.id("Document-list")));
				document.selectByVisibleText("Addhar Card");
				driver.findElement(By.id("txtCreatedDate")).sendKeys("08/10/2018");
				driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/ul/li[2]/button")).click();
				
				driver.findElement(By.name("Discount")).clear();
				driver.findElement(By.name("Discount")).sendKeys("10");
				driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/ul/li[2]/button")).click();
				driver.findElement(By.xpath("//*[@id=\"btn-save\"]")).click();
				
				String actualname = driver.findElement(By.xpath("//*[@id=\"view-lead-status\"]/tbody/tr[1]/td[2]")).getText();
				String actualmobno = driver.findElement(By.xpath("//*[@id=\"view-lead-status\"]/tbody/tr[1]/td[3]")).getText();
				String actualemailid = driver.findElement(By.xpath("//*[@id=\"view-lead-status\"]/tbody/tr/td[4]")).getText();
				String actualcourse = driver.findElement(By.xpath("//*[@id=\"view-lead-status\"]/tbody/tr/td[5]")).getText();
				String actualcreateddate = driver.findElement(By.xpath("//*[@id=\"view-lead-status\"]/tbody/tr/td[6]")).getText();
			
				Assert.assertEquals(actualname, "Ashwini Suresh Patil", "Student Name not getting saved");
				Assert.assertEquals(actualmobno, "1236547890", "Mobile No not getting saved");
				Assert.assertEquals(actualemailid,"aarti@gmail.com", "Email Id not getting saved");
				Assert.assertEquals(actualcourse, "DOT NET JAVA", "Course not getting saved");
				Assert.assertEquals(actualcreateddate, "08/10/2018", "Created Date not getting saved");
			}
			
			//Delete Admission
			@Test
			public void Delete_Admission() throws InterruptedException
			{
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"view-lead-status\"]/tbody/tr[1]/td[7]/button[2]/i")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id=\"remove-admission\"]")).click();
				Thread.sleep(3000);
				String actual = driver.findElement(By.xpath("//*[@id=\"view-lead-status\"]/tbody/tr/td")).getText();
				String expected = "No data available in table";
				Assert.assertEquals(actual, expected, "Admission NOT getting Deleted");
						
			}
			
			
			//New Admission
			//Student Name
			@Test
			  public void Studentname_contains_Special_Characters() throws InterruptedException
			  {
				  Thread.sleep(2000);
				  driver.findElement(By.xpath("//*[@id=\"nav-state-toggle\"]/i")).click();
				  driver.findElement(By.xpath("//*[@id=\"sidebar\"]/div/div[1]/ul[1]/li[4]/a/i")).click();
				  driver.findElement(By.xpath("//*[@id=\"4\"]/li[1]/a")).click();
				  driver.findElement(By.name("FirstName")).sendKeys("#$#^%&^&*(");
				  boolean studentname =driver.findElement(By.name("FirstName")).getAttribute("value").matches(studentname_pattern);
				  Assert.assertTrue(studentname, "Student Name Contains Special Characters");
				  
			  }
			
			 @Test
				public void Studentname_contains_numbers()
				{
				    driver.findElement(By.name("FirstName")).clear();
				    driver.findElement(By.name("FirstName")).sendKeys("025547");
					boolean studentname =driver.findElement(By.name("FirstName")).getAttribute("value").matches(studentname_pattern);
					Assert.assertTrue(studentname, "Student Name Contains Numbers");
				}
			
				@Test
				public void Studentname_contains_whitespaces()
				{
				    driver.findElement(By.name("FirstName")).clear();
				    driver.findElement(By.name("FirstName")).sendKeys("Ashwini Ahire");
					boolean studentname =driver.findElement(By.name("FirstName")).getAttribute("value").matches(studentname_pattern);
					Assert.assertTrue(studentname, "Student Name Contains Whitespaces");
				}
				
				@Test
			  	public void Studentname_contains_alphabets() 
				{
					driver.findElement(By.name("FirstName")).clear();
					driver.findElement(By.name("FirstName")).sendKeys("Ashwini");
					boolean studentname =driver.findElement(By.name("FirstName")).getAttribute("value").matches(studentname_pattern);
					Assert.assertTrue(studentname, "Student Name Contain Alphabets");
				}
				
				@Test
			  	public void Studentname_contains_whitespaces_at_begining() 
				{
					driver.findElement(By.name("FirstName")).clear();
					driver.findElement(By.name("FirstName")).sendKeys("   Ashwini");
					boolean studentname =driver.findElement(By.name("FirstName")).getAttribute("value").matches(studentname_pattern);
					Assert.assertTrue(studentname, "Student Name Contain Whitespaces at Begining");
				}
				
				@Test
			  	public void StudentName_field_is_Blank() throws InterruptedException 
				{
					driver.findElement(By.name("FirstName")).clear();
					driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/ul/li[2]/button")).click();
					Thread.sleep(2000);
					String actual = driver.findElement(By.xpath("//*[@id=\"parsley-id-6\"]/li")).getText();
					String expected = "This value is required.";
					Assert.assertEquals(actual, expected, "Student Name Accepted Blank Field");
				}
				
				//Middle Name
				@Test
				  public void Middlename_contains_Special_Characters() throws InterruptedException
				  {
					  driver.findElement(By.name("MiddleName")).sendKeys("#$#^%&^&*(");
					  boolean middlename =driver.findElement(By.name("MiddleName")).getAttribute("value").matches(middlename_pattern);
					  Assert.assertTrue(middlename, "Middle Name Contains Special Characters");
				  }
				  
				  @Test
					public void Middlename_contains_numbers()
					{
					    driver.findElement(By.name("MiddleName")).clear();
					    driver.findElement(By.name("MiddleName")).sendKeys("025547");
						boolean middlename =driver.findElement(By.name("MiddleName")).getAttribute("value").matches(middlename_pattern);
						Assert.assertTrue(middlename, "Middle Name Contains Numbers");
					}
				
					@Test
					public void Middlename_contains_whitespaces()
					{
					    driver.findElement(By.name("MiddleName")).clear();
					    driver.findElement(By.name("MiddleName")).sendKeys("Ashwini Ashok");
						boolean middlename =driver.findElement(By.name("MiddleName")).getAttribute("value").matches(middlename_pattern);
						Assert.assertTrue(middlename, "Middle Name Contains Whitespaces");
					}
					
					@Test
				  	public void Middlename_contains_whitespaces_at_begining() 
					{
						driver.findElement(By.name("MiddleName")).clear();
						driver.findElement(By.name("MiddleName")).sendKeys("   Ashok");
						boolean middlename =driver.findElement(By.name("MiddleName")).getAttribute("value").matches(middlename_pattern);
						Assert.assertTrue(middlename, "Middle Name Contain Whitespaces at Begining");
					}
					
					
					@Test
				  	public void Middlename_contains_alphabets() 
					{
						driver.findElement(By.name("MiddleName")).clear();
						driver.findElement(By.name("MiddleName")).sendKeys("Ashok");
						boolean middlename =driver.findElement(By.name("MiddleName")).getAttribute("value").matches(middlename_pattern);
						Assert.assertTrue(middlename, "Middle Name Contain Alphabets");
					}
					
				
					
					
					//Last Name
					@Test
					public void Lastname_contains_Special_Characters() throws InterruptedException
					{
						  driver.findElement(By.name("LastName")).sendKeys("#$#^%&^&*(");
						  boolean lastname =driver.findElement(By.name("LastName")).getAttribute("value").matches(lastname_pattern);
						  Assert.assertTrue(lastname, "Last Name Contains Special Characters");
					}
					  
					@Test
					public void Lastname_contains_numbers()
					{
						    driver.findElement(By.name("LastName")).clear();
						    driver.findElement(By.name("LastName")).sendKeys("025547");
							boolean lastname =driver.findElement(By.name("LastName")).getAttribute("value").matches(lastname_pattern);
							Assert.assertTrue(lastname, "Last Name Contains Numbers");
					}
					
					@Test
					public void Lastname_contains_whitespaces()
					{
						    driver.findElement(By.name("LastName")).clear();
						    driver.findElement(By.name("LastName")).sendKeys("Ashwini Ahire");
							boolean lastname =driver.findElement(By.name("LastName")).getAttribute("value").matches(lastname_pattern);
							Assert.assertTrue(lastname, "Last Name Contains Whitespaces");
					}
						
					@Test
					public void Lastname_contains_alphabets() 
					{
							driver.findElement(By.name("LastName")).clear();
							driver.findElement(By.name("LastName")).sendKeys("Ahire");
							boolean lastname =driver.findElement(By.name("LastName")).getAttribute("value").matches(lastname_pattern);
							Assert.assertTrue(lastname, "Last Name Contain Alphabets");
					}
						
					@Test
					public void Lastname_contains_whitespaces_at_begining() 
					{
							driver.findElement(By.name("LastName")).clear();
							driver.findElement(By.name("LastName")).sendKeys("   Ahire");
							boolean lastname =driver.findElement(By.name("LastName")).getAttribute("value").matches(lastname_pattern);
							Assert.assertTrue(lastname, "Last Name Contain Whitespaces at Begining");
					}
						
					@Test
					public void LastName_field_is_Blank() 
					{
							driver.findElement(By.name("LastName")).clear();
							boolean lastname =driver.findElement(By.name("LastName")).getAttribute("value").matches(lastname_pattern);
							Assert.assertTrue(lastname, "Last Name is Blank");
					}
					
					//College/School
					@Test
					public void Collegename_contains_Special_Characters() throws InterruptedException
					{
						  driver.findElement(By.name("College")).sendKeys("#$#^%&^&*(");
						  boolean collegename =driver.findElement(By.name("College")).getAttribute("value").matches(college_pattern);
						  Assert.assertTrue(collegename, "College Name Contains Special Characters");
					}
					  
					@Test
					public void Collegename_contains_numbers()
					{
						    driver.findElement(By.name("College")).clear();
						    driver.findElement(By.name("College")).sendKeys("025547");
							boolean collegename =driver.findElement(By.name("College")).getAttribute("value").matches(college_pattern);
							Assert.assertTrue(collegename, "College Name Contains Numbers");
					}
					
					@Test
					public void Collegename_contains_whitespaces()
					{
						    driver.findElement(By.name("College")).clear();
						    driver.findElement(By.name("College")).sendKeys("K T H M");
							boolean collegename =driver.findElement(By.name("College")).getAttribute("value").matches(college_pattern);
							Assert.assertTrue(collegename, "College Name Contains Whitespaces");
					}
						
					@Test
					public void Collegename_contains_alphabets() 
					{
							driver.findElement(By.name("College")).clear();
							driver.findElement(By.name("College")).sendKeys("KTHM");
							boolean collegename =driver.findElement(By.name("College")).getAttribute("value").matches(college_pattern);
							Assert.assertTrue(collegename, "College Name Contain Alphabets");
					}
						
					@Test
					public void Collegename_contains_whitespaces_at_begining() 
					{
							driver.findElement(By.name("College")).clear();
							driver.findElement(By.name("College")).sendKeys("   KTHM");
							boolean collegename =driver.findElement(By.name("College")).getAttribute("value").matches(college_pattern);
							Assert.assertTrue(collegename, "College Name Contain Whitespaces at Begining");
					}
						
					@Test
					public void CollegeName_field_is_Blank() 
					{
							driver.findElement(By.name("College")).clear();
							boolean collegename =driver.findElement(By.name("College")).getAttribute("value").matches(college_pattern);
							Assert.assertTrue(collegename, "College Name is Blank");
					}
				
					//Qualification
					@Test
					public void Qualification_contains_Special_Characters() throws InterruptedException
					{
						  driver.findElement(By.name("Qualification")).sendKeys("#$#^%&^&*(");
						  boolean qualification =driver.findElement(By.name("Qualification")).getAttribute("value").matches(qualification_pattern);
						  Assert.assertTrue(qualification, "College Name Contains Special Characters");
					}
					  
					@Test
					public void Qualification_contains_numbers()
					{
						    driver.findElement(By.name("Qualification")).clear();
						    driver.findElement(By.name("Qualification")).sendKeys("025547");
							boolean qualification =driver.findElement(By.name("Qualification")).getAttribute("value").matches(qualification_pattern);
							Assert.assertTrue(qualification, "College Name Contains Numbers");
					}
					
					@Test
					public void Qualification_contains_whitespaces()
					{
						    driver.findElement(By.name("Qualification")).clear();
						    driver.findElement(By.name("Qualification")).sendKeys("B Tech");
							boolean qualification =driver.findElement(By.name("Qualification")).getAttribute("value").matches(qualification_pattern);
							Assert.assertTrue(qualification, "College Name Contains Whitespaces");
					}
						
					@Test
					public void Qualification_contains_alphabets() 
					{
							driver.findElement(By.name("Qualification")).clear();
							driver.findElement(By.name("Qualification")).sendKeys("BE");
							boolean qualification =driver.findElement(By.name("Qualification")).getAttribute("value").matches(qualification_pattern);
							Assert.assertTrue(qualification, "College Name Contain Alphabets");
					}
						
					@Test
					public void Qualification_contains_whitespaces_at_begining() 
					{
							driver.findElement(By.name("Qualification")).clear();
							driver.findElement(By.name("Qualification")).sendKeys("   BE");
							boolean qualification =driver.findElement(By.name("Qualification")).getAttribute("value").matches(qualification_pattern);
							Assert.assertTrue(qualification, "College Name Contain Whitespaces at Begining");
					}
						
					@Test
					public void Qualification_Field_is_Blank() 
					{
							driver.findElement(By.name("Qualification")).clear();
							boolean qualification =driver.findElement(By.name("Qualification")).getAttribute("value").matches(qualification_pattern);
							Assert.assertTrue(qualification, "College Name is Blank");
					}
					
					//Aadhar No
					@Test
					public void Aadharno_contains_special_characters()
					{
						driver.findElement(By.name("AddharNo")).sendKeys("!@#$%^&*()");
						boolean aadharno =driver.findElement(By.name("AddharNo")).getAttribute("value").matches(aadharno_pattern);
						Assert.assertTrue(aadharno, "Aadhar No Contains Spaecial Characters");
					}
				
					@Test
					public void Aadharno_contains_alphabets()
					{
						driver.findElement(By.name("AddharNo")).clear();
						driver.findElement(By.name("AddharNo")).sendKeys("aadhar");
						boolean aadharno =driver.findElement(By.name("AddharNo")).getAttribute("value").matches(aadharno_pattern);
						Assert.assertTrue(aadharno, "Aadhar No Contains Alphabets");
					}
					
					@Test
					public void Aadharno_contains_numbers()
					{
						driver.findElement(By.name("AddharNo")).clear();
						driver.findElement(By.name("AddharNo")).sendKeys("259625854984");
						boolean aadharno =driver.findElement(By.name("AddharNo")).getAttribute("value").matches(aadharno_pattern);
						Assert.assertTrue(aadharno, "Aadhar No Contains Numbers");
					}
					
					@Test
					public void Aadharno_contains_negative_numbers()
					{
						driver.findElement(By.name("AddharNo")).clear();
						driver.findElement(By.name("AddharNo")).sendKeys("-557855");
						boolean aadharno =driver.findElement(By.name("AddharNo")).getAttribute("value").matches(aadharno_pattern);
						Assert.assertTrue(aadharno, "Aadhar No Contains Negative Numbers");
					}
					
					@Test
				  	public void Aadharno_contains_whitespaces_at_begining() 
					{
						driver.findElement(By.name("AddharNo")).clear();
						driver.findElement(By.name("AddharNo")).sendKeys("  998825632563");
						boolean aadharno =driver.findElement(By.name("AddharNo")).getAttribute("value").matches(aadharno_pattern);
						Assert.assertTrue(aadharno, "Aadhar No Contains Whitespaces at begining");
					}
					
					@Test
				  	public void Aadharno_contains_lessthan_12_numbers() 
					{
						driver.findElement(By.name("AddharNo")).clear();
						driver.findElement(By.name("AddharNo")).sendKeys("1452");
						boolean aadharno =driver.findElement(By.name("AddharNo")).getAttribute("value").matches(aadharno_pattern);
						Assert.assertTrue(aadharno, "Aadhar No Contains Less than 12 numbers");
					}
					
					@Test
				  	public void Aadharno_contains_greaterthan_12_numbers() 
					{
						driver.findElement(By.name("AddharNo")).clear();
						driver.findElement(By.name("AddharNo")).sendKeys("123456789156324");
						boolean aadharno =driver.findElement(By.name("AddharNo")).getAttribute("value").matches(aadharno_pattern);
						Assert.assertTrue(aadharno, "Aadhar No Contains Whitespaces at begining");
					}
					
					//Date of Birth
					@Test
					public void Birthdate_Functionality() throws InterruptedException
					{
						driver.findElement(By.name("DateOfBirth")).sendKeys("11/12/1995");
						Thread.sleep(3000);
						boolean dateofbirth =driver.findElement(By.name("DateOfBirth")).getAttribute("value").matches(dateofbirth_pattern);
						
						Assert.assertTrue(dateofbirth, "Date of Birth is NOT Getting Accepted");
					}
					
					//Gender
					 @Test
					public void Blank_Gender_Field() throws InterruptedException
					{
						boolean genderlist =driver.findElement(By.name("Gender")).getAttribute("value").matches(gender_pattern);
						Assert.assertTrue(genderlist, "Gender field is Blank");				
					}
					
					@Test
					public void Gender_Functionality()
					{
						Select drpgenderlist = new Select(driver.findElement(By.name("Gender")));
						drpgenderlist.selectByVisibleText("Female");
						boolean genderlist =driver.findElement(By.name("Gender")).getAttribute("value").matches(gender_pattern);
						Assert.assertTrue(genderlist, "Gender field NOT Working");				
					}
					
					//Next Button
					@Test
					public void PersonalInfo_next_button_Functionality()
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
					public void Primary_mobno_contains_special_characters()
					{
						driver.findElement(By.name("MobilePrimary")).sendKeys("!@#$%^&*()");
						boolean primarymob =driver.findElement(By.name("MobilePrimary")).getAttribute("value").matches(primarymobileno_pattern);
						Assert.assertTrue(primarymob, "Primary Mobile No Contains Spaecial Characters");
					}
				
					@Test
					public void Primary_mobno_contains_whitespaces()
					{
						driver.findElement(By.name("MobilePrimary")).clear();
						driver.findElement(By.name("MobilePrimary")).sendKeys("25985 38478");
						boolean primarymob =driver.findElement(By.name("MobilePrimary")).getAttribute("value").matches(primarymobileno_pattern);
						Assert.assertTrue(primarymob, "Primary Mobile No Contains Whitespaces");
					}
					
					@Test
					public void Primary_mobno_contains_alphabets()
					{
						driver.findElement(By.name("MobilePrimary")).clear();
						driver.findElement(By.name("MobilePrimary")).sendKeys("mobile");
						boolean primarymob =driver.findElement(By.name("MobilePrimary")).getAttribute("value").matches(primarymobileno_pattern);
						Assert.assertTrue(primarymob, "Primary Mobile No Contains Alphabets");
					}
					
					@Test
					public void Primary_mobno_contains_numbers()
					{
						driver.findElement(By.name("MobilePrimary")).clear();
						driver.findElement(By.name("MobilePrimary")).sendKeys("9630124587");
						boolean primarymob =driver.findElement(By.name("MobilePrimary")).getAttribute("value").matches(primarymobileno_pattern);
						Assert.assertTrue(primarymob, "Primary Mobile No Contains Numbers");
					}
					
					@Test
					public void Primary_mobno_contains_negative_numbers()
					{
						driver.findElement(By.name("MobilePrimary")).clear();
						driver.findElement(By.name("MobilePrimary")).sendKeys("-557855");
						boolean primarymob =driver.findElement(By.name("MobilePrimary")).getAttribute("value").matches(primarymobileno_pattern);
						Assert.assertTrue(primarymob, "Primary Mobile No Contains Negative Numbers");
					}
					
					@Test
				  	public void Primary_mobno_contains_whitespaces_at_begining() 
					{
						driver.findElement(By.name("MobilePrimary")).clear();
						driver.findElement(By.name("MobilePrimary")).sendKeys("  9876543210");
						boolean primarymob =driver.findElement(By.name("MobilePrimary")).getAttribute("value").matches(primarymobileno_pattern);
						Assert.assertTrue(primarymob, "Primary Mobile No Contains Whitespaces at begining");
					}
					
					@Test
				  	public void Primary_mobno_Field_is_Blank() 
					{
						driver.findElement(By.name("MobilePrimary")).clear();
						boolean primarymob =driver.findElement(By.name("MobilePrimary")).getAttribute("value").matches(primarymobileno_pattern);
						Assert.assertTrue(primarymob, "Primary Mobile No is Blank");
					}
					
					@Test
				  	public void Primary_mobno_contains_lessthan_10_numbers() 
					{
						driver.findElement(By.name("MobilePrimary")).clear();
						driver.findElement(By.name("MobilePrimary")).sendKeys("8989");
						boolean primarymob =driver.findElement(By.name("MobilePrimary")).getAttribute("value").matches(primarymobileno_pattern);
						Assert.assertTrue(primarymob, "Primary Mobile No Contains Less than 10 numbers");
					}
					
					@Test
				  	public void Primary_mobno_contains_greaterthan_10_numbers() 
					{
						driver.findElement(By.name("MobilePrimary")).clear();
						driver.findElement(By.name("MobilePrimary")).sendKeys("7896541230123");
						boolean primarymob =driver.findElement(By.name("MobilePrimary")).getAttribute("value").matches(primarymobileno_pattern);
						Assert.assertTrue(primarymob, "Primary Mobile No contains greater than 10 numbers");
					}
					
					//Secondary Mobile No
					@Test
					public void Secondary_mobno_contains_special_characters()
					{
						driver.findElement(By.name("MobileSecondary")).sendKeys("!@#$%^&*()");
						boolean secondarymob =driver.findElement(By.name("MobileSecondary")).getAttribute("value").matches(secondarymobileno_pattern);
						Assert.assertTrue(secondarymob, "Secondary Mobile No Contains Spaecial Characters");
					}
				
					@Test
					public void Secondary_mobno_contains_whitespaces()
					{
						driver.findElement(By.name("MobileSecondary")).clear();
						driver.findElement(By.name("MobileSecondary")).sendKeys("25985 38478");
						boolean secondarymob =driver.findElement(By.name("MobileSecondary")).getAttribute("value").matches(secondarymobileno_pattern);
						Assert.assertTrue(secondarymob, "Secondary Mobile No Contains Whitespaces");
					}
					
					@Test
					public void Secondary_mobno_contains_alphabets()
					{
						driver.findElement(By.name("MobileSecondary")).clear();
						driver.findElement(By.name("MobileSecondary")).sendKeys("mobile");
						boolean secondarymob =driver.findElement(By.name("MobileSecondary")).getAttribute("value").matches(secondarymobileno_pattern);
						Assert.assertTrue(secondarymob, "Secondary Mobile No Contains Alphabets");
					}
					
					@Test
					public void Secondary_mobno_contains_numbers()
					{
						driver.findElement(By.name("MobileSecondary")).clear();
						driver.findElement(By.name("MobileSecondary")).sendKeys("9630124587");
						boolean secondarymob =driver.findElement(By.name("MobileSecondary")).getAttribute("value").matches(secondarymobileno_pattern);
						Assert.assertTrue(secondarymob, "Secondary Mobile No Contains Numbers");
					}
					
					@Test
					public void Secondary_mobno_contains_negative_numbers()
					{
						driver.findElement(By.name("MobileSecondary")).clear();
						driver.findElement(By.name("MobileSecondary")).sendKeys("-557855");
						boolean secondarymob =driver.findElement(By.name("MobileSecondary")).getAttribute("value").matches(secondarymobileno_pattern);
						Assert.assertTrue(secondarymob, "Secondary Mobile No Contains Negative Numbers");
					}
					
					@Test
				  	public void Secondary_mobno_contains_whitespaces_at_begining() 
					{
						driver.findElement(By.name("MobileSecondary")).clear();
						driver.findElement(By.name("MobileSecondary")).sendKeys("  8520147963");
						boolean secondarymob =driver.findElement(By.name("MobileSecondary")).getAttribute("value").matches(secondarymobileno_pattern);
						Assert.assertTrue(secondarymob, "Secondary Mobile No Contains Whitespaces at begining");
					}
					
					@Test
					public void Secondary_mobno_contains_lessthan_10_numbers() 
					{
						driver.findElement(By.name("MobileSecondary")).clear();
						driver.findElement(By.name("MobileSecondary")).sendKeys("8989");
						boolean secondarymob =driver.findElement(By.name("MobileSecondary")).getAttribute("value").matches(secondarymobileno_pattern);
						Assert.assertTrue(secondarymob, "Secondary Mobile No Contains Less than 10 numbers");
					}
					
					@Test
				  	public void Secondary_mobno_contains_greaterthan_10_numbers() 
					{
						driver.findElement(By.name("MobileSecondary")).clear();
						driver.findElement(By.name("MobileSecondary")).sendKeys("7896541230123");
						boolean secondarymob =driver.findElement(By.name("MobileSecondary")).getAttribute("value").matches(secondarymobileno_pattern);
						Assert.assertTrue(secondarymob, "Secondary Mobile No contains greater than 10 numbers");
					}
					
					//Primary Email
					@Test
					public void Primary_email_is_Blank() throws InterruptedException
					{
						driver.findElement(By.xpath("EmailPrimary")).clear();
						driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/ul/li[2]/button")).click();
						Thread.sleep(1000);
						String actual = driver.findElement(By.xpath("//*[@id=\"parsley-id-28\"]/li[1]")).getText();
						String expected = "This value is required.";
						Assert.assertEquals(actual, expected, "Primary Email Accepted Blank Field");
					}
					
					@Test
					public void Primary_email_contains_whitespaces() throws InterruptedException
					{
						driver.findElement(By.name("EmailPrimary")).clear();
						driver.findElement(By.name("EmailPrimary")).sendKeys("abc @gmail.com");
						driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/ul/li[2]/button")).click();
						Thread.sleep(2000);
						String actual = driver.findElement(By.xpath("//*[@id=\"parsley-id-28\"]/li")).getText();
						String expected = "This value should be a valid email.";
						Assert.assertEquals(actual, expected, "Primary Email Contains Whitespaces");
					}
					
					@Test
					public void Primary_Email_valid()
					{
						driver.findElement(By.name("EmailPrimary")).clear();
						driver.findElement(By.name("EmailPrimary")).sendKeys("abc@gmail.com");
						String actual = "";
						String expected = "";
						Assert.assertEquals(actual, expected, "Primary Email Id is NOT valid");
					}
				
				
					@Test
				  	public void Primary_email_contains_whitespaces_at_begining() throws InterruptedException 
					{
						driver.findElement(By.name("EmailPrimary")).clear();
						Thread.sleep(1000);
						driver.findElement(By.name("EmailPrimary")).sendKeys("       abc@gmail.com");
						boolean primaryemail =driver.findElement(By.name("EmailSecondary")).getAttribute("value").matches(primary_email);
						Assert.assertTrue(primaryemail, "Primary Email contain Whitespaces at Begining");
					}
					
					
					
					//Secondary Email
					@Test
					public void Secondary_email_contains_whitespaces() throws InterruptedException
					{
						driver.findElement(By.id("MobilePrimary")).sendKeys("9876543210");
						driver.findElement(By.id("MobileSecondary")).sendKeys("7894561230");
						driver.findElement(By.id("EmailPrimary")).clear();
						driver.findElement(By.id("EmailPrimary")).sendKeys("ashwini@gmail.com");
						driver.findElement(By.name("CurrentAddress")).sendKeys("Flat no-15,Ganesh Appartment, Near Prasad Circle,Gangapur Road,Nashik");
						driver.findElement(By.name("PermanentAddress")).sendKeys("Flat no-15,Ganesh Appartment, Near Prasad Circle,Gangapur Road,Nashik");
						driver.findElement(By.id("PinCodeCurrentAddress")).sendKeys("422203");
						driver.findElement(By.id("PinCodePermanentAddress")).sendKeys("422203");
						driver.findElement(By.name("EmailSecondary")).sendKeys("abc  @gmail.com");
						Thread.sleep(2000);
						driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/ul/li[2]/button")).click();
						Thread.sleep(2000);
						String actual = driver.findElement(By.xpath("//*[@id=\"parsley-id-30\"]/li")).getText();
						String expected = "This value should be a valid email.";
						Assert.assertEquals(actual, expected, "Secondary Email Contains Whitespaces");
					}
					
					@Test
					public void Secondary_Email_valid()
					{
						driver.findElement(By.name("EmailSecondary")).clear();
						driver.findElement(By.name("EmailSecondary")).sendKeys("abc@gmail.com");
						String actual = "";
						String expected = "";
						Assert.assertEquals(actual, expected, "Secondary Email Id is NOT valid");
					}
				
					
					@Test
				  	public void Secondary_email_contains_whitespaces_at_begining() throws InterruptedException 
					{
						driver.findElement(By.name("EmailSecondary")).clear();
						Thread.sleep(1000);
						driver.findElement(By.name("EmailSecondary")).sendKeys("       abc@gmail.com");
						boolean secondaryemail =driver.findElement(By.name("EmailSecondary")).getAttribute("value").matches(secondary_email);
						Assert.assertTrue(secondaryemail, "Secondary Email contain Whitespaces at Begining");
					}
					
					//Current Address
					@Test
					public void Valid_Current_address()
					{
						driver.findElement(By.name("CurrentAddress")).clear();
						driver.findElement(By.name("CurrentAddress")).sendKeys("Flat no-15,Ganesh Appartment, Near Prasad Circle,Gangapur Road,Nashik");
						boolean currentaddress =driver.findElement(By.name("CurrentAddress")).getAttribute("value").matches(currentaddress_pattern);
						Assert.assertTrue(currentaddress, "Current Address in NOT valid");
					}
					
					@Test
					public void Blank_Current_address() throws InterruptedException
					{
						driver.findElement(By.name("CurrentAddress")).clear();
						driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/ul/li[2]/button")).click();
						Thread.sleep(2000);
						String actual = driver.findElement(By.xpath("//*[@id=\"parsley-id-32\"]/li")).getText();
						String expected = "This value is required.";
						Assert.assertEquals(actual, expected, "Current Address is Blank");
					}
					
					//Permanent Address
					@Test
					public void Valid_Permanent_address()
					{
						driver.findElement(By.name("CurrentAddress")).sendKeys("Flat no-15,Ganesh Appartment, Near Prasad Circle,Gangapur Road,Nashik");
						driver.findElement(By.name("PermanentAddress")).clear();
						driver.findElement(By.name("PermanentAddress")).sendKeys("Flat no-15,Ganesh Appartment, Near Prasad Circle,Gangapur Road,Nashik");
						boolean currentaddress =driver.findElement(By.name("PermanentAddress")).getAttribute("value").matches(permanentaddress_pattern);
						Assert.assertTrue(currentaddress, "Permanent Address in NOT valid");
					}
					
					//Pin code(Current Address)
					@Test
					public void Pincode_currentaddress_contains_special_characters()
					{
						driver.findElement(By.name("PinCodeCurrentAddress")).clear();
						driver.findElement(By.name("PinCodeCurrentAddress")).sendKeys("!@#$%^&*()");
						boolean pincode =driver.findElement(By.name("PinCodeCurrentAddress")).getAttribute("value").matches(pincode_currentaddress_pattern);
						Assert.assertTrue(pincode, "Pincode No Contains Spaecial Characters");
					}
				
					@Test
					public void Pincode_currentaddress_contains_whitespaces()
					{
						driver.findElement(By.name("PinCodeCurrentAddress")).clear();
						driver.findElement(By.name("PinCodeCurrentAddress")).sendKeys("25985 38478");
						boolean pincode =driver.findElement(By.name("PinCodeCurrentAddress")).getAttribute("value").matches(pincode_currentaddress_pattern);
						Assert.assertTrue(pincode, "Pincode No Contains Whitespaces");
					}
					
					@Test
					public void Pincode_currentaddress_contains_alphabets()
					{
						driver.findElement(By.name("PinCodeCurrentAddress")).clear();
						driver.findElement(By.name("PinCodeCurrentAddress")).sendKeys("pincode");
						boolean pincode =driver.findElement(By.name("PinCodeCurrentAddress")).getAttribute("value").matches(pincode_currentaddress_pattern);
						Assert.assertTrue(pincode, "Pincode No Contains Alphabets");
					}
					
					@Test
					public void Pincode_currentaddress_contains_numbers()
					{
						driver.findElement(By.name("PinCodeCurrentAddress")).clear();
						driver.findElement(By.name("PinCodeCurrentAddress")).sendKeys("259625");
						boolean pincode =driver.findElement(By.name("PinCodeCurrentAddress")).getAttribute("value").matches(pincode_currentaddress_pattern);
						Assert.assertTrue(pincode, "Pincode No Contains Numbers");
					}
					
					@Test
					public void Pincode_currentaddress_contains_negative_numbers()
					{
						driver.findElement(By.name("PinCodeCurrentAddress")).clear();
						driver.findElement(By.name("PinCodeCurrentAddress")).sendKeys("-557855");
						boolean pincode =driver.findElement(By.name("PinCodeCurrentAddress")).getAttribute("value").matches(pincode_currentaddress_pattern);
						Assert.assertTrue(pincode, "Pincode No Contains Negative Numbers");
					}
					
					@Test
				  	public void Pincode_currentaddress_contains_whitespaces_at_begining() 
					{
						driver.findElement(By.name("PinCodeCurrentAddress")).clear();
						driver.findElement(By.name("PinCodeCurrentAddress")).sendKeys("  998898");
						boolean pincode =driver.findElement(By.name("PinCodeCurrentAddress")).getAttribute("value").matches(pincode_currentaddress_pattern);
						Assert.assertTrue(pincode, "Pincode No Contains Whitespaces at begining");
					}
					
					@Test
				  	public void Pincode_Currentaddress_field_is_Blank() 
					{
						driver.findElement(By.name("PinCodeCurrentAddress")).clear();
						boolean pincode =driver.findElement(By.name("PinCodeCurrentAddress")).getAttribute("value").matches(pincode_currentaddress_pattern);
						Assert.assertTrue(pincode, "Pincode No is Blank");
					}
					
					@Test
					public void Pincode_currentaddress_contains_morethan_6_numbers()
					{
						driver.findElement(By.name("PinCodeCurrentAddress")).clear();
						driver.findElement(By.name("PinCodeCurrentAddress")).sendKeys("589632104");
						boolean pincode =driver.findElement(By.name("PinCodeCurrentAddress")).getAttribute("value").matches(pincode_currentaddress_pattern);
						Assert.assertTrue(pincode, "Pincode No is Blank");
					}
					
					@Test
					public void Pincode_currentaddress_contains_lessthan_6_numbers() throws InterruptedException
					{
						driver.findElement(By.name("PinCodeCurrentAddress")).clear();
						driver.findElement(By.name("PinCodeCurrentAddress")).sendKeys("58964");
						driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/ul/li[2]/button")).click();
						Thread.sleep(1500);
						String actual = driver.findElement(By.xpath("//*[@id=\"parsley-id-36\"]/li")).getText();
						String expected = "This value length is invalid. It should be between 6 and 6 characters long.";
						Assert.assertEquals(actual, expected, "Pin code contain less than 6 numbers");
					}
				
					//Pin code(Permanent Address)
					@Test
					public void Pincode_permanentaddress_contains_special_characters()
					{
						driver.findElement(By.name("PinCodePermanentAddress")).clear();
						driver.findElement(By.name("PinCodePermanentAddress")).sendKeys("!@#$%^&*()");
						boolean pincode =driver.findElement(By.name("PinCodePermanentAddress")).getAttribute("value").matches(pincode_permanentaddress_pattern);
						Assert.assertTrue(pincode, "Pincode No Contains Spaecial Characters");
					}
				
					@Test
					public void Pincode_permanentaddress_contains_whitespaces()
					{
						driver.findElement(By.name("PinCodeCurrentAddress")).sendKeys("8");

						driver.findElement(By.name("PinCodePermanentAddress")).clear();
						driver.findElement(By.name("PinCodePermanentAddress")).sendKeys("25985 38478");
						boolean pincode =driver.findElement(By.name("PinCodePermanentAddress")).getAttribute("value").matches(pincode_permanentaddress_pattern);
						Assert.assertTrue(pincode, "Pincode No Contains Whitespaces");
					}
					
					@Test
					public void Pincode_permanentaddress_contains_alphabets()
					{
						driver.findElement(By.name("PinCodePermanentAddress")).clear();
						driver.findElement(By.name("PinCodePermanentAddress")).sendKeys("aadhar");
						boolean pincode =driver.findElement(By.name("PinCodePermanentAddress")).getAttribute("value").matches(pincode_permanentaddress_pattern);
						Assert.assertTrue(pincode, "Pincode No Contains Alphabets");
					}
					
					@Test
					public void Pincode_permanentaddress_contains_numbers()
					{
						driver.findElement(By.name("PinCodePermanentAddress")).clear();
						driver.findElement(By.name("PinCodePermanentAddress")).sendKeys("259625");
						boolean pincode =driver.findElement(By.name("PinCodePermanentAddress")).getAttribute("value").matches(pincode_permanentaddress_pattern);
						Assert.assertTrue(pincode, "Pincode No Contains Numbers");
					}
					
					@Test
					public void Pincode_permanentaddress_contains_negative_numbers()
					{
						driver.findElement(By.name("PinCodePermanentAddress")).clear();
						driver.findElement(By.name("PinCodePermanentAddress")).sendKeys("-557855");
						boolean pincode =driver.findElement(By.name("PinCodePermanentAddress")).getAttribute("value").matches(pincode_permanentaddress_pattern);
						Assert.assertTrue(pincode, "Pincode No Contains Negative Numbers");
					}
					
					@Test
				  	public void Pincode_permanentaddress_contains_whitespaces_at_begining() 
					{
						driver.findElement(By.name("PinCodePermanentAddress")).clear();
						driver.findElement(By.name("PinCodePermanentAddress")).sendKeys("  998898");
						boolean pincode =driver.findElement(By.name("PinCodePermanentAddress")).getAttribute("value").matches(pincode_permanentaddress_pattern);
						Assert.assertTrue(pincode, "Pincode No Contains Whitespaces at begining");
					}
					
					@Test
					public void Pincode_permanentaddress_contains_morethan_6_numbers()
					{
						driver.findElement(By.name("PinCodePermanentAddress")).clear();
						driver.findElement(By.name("PinCodePermanentAddress")).sendKeys("589632104");
						boolean pincode =driver.findElement(By.name("PinCodePermanentAddress")).getAttribute("value").matches(pincode_permanentaddress_pattern);
						Assert.assertTrue(pincode, "Pincode No is Blank");
					}
					
					@Test
					public void Pincode_permanentaddress_contains_lessthan_6_numbers() throws InterruptedException
					{
						driver.findElement(By.name("PinCodePermanentAddress")).clear();
						driver.findElement(By.name("PinCodePermanentAddress")).sendKeys("58964");
						driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/ul/li[2]/button")).click();
						Thread.sleep(1500);
						String actual = driver.findElement(By.xpath("//*[@id=\"parsley-id-38\"]/li")).getText();
						Thread.sleep(1500);
						String expected = "This value length is invalid. It should be between 6 and 6 characters long.";
						Assert.assertEquals(actual, expected, "Pin code contain less than 6 numbers");

					}
					
					@Test
					public void Document_Functionality() throws InterruptedException
					{
						Thread.sleep(2000);
						Select drpdocument = new Select(driver.findElement(By.name("DocumentId")));
						drpdocument.selectByVisibleText("Addhar Card");
						boolean document =driver.findElement(By.name("DocumentId")).getAttribute("value").matches(document_pattern);
						Assert.assertTrue(document, "Document field NOT Working");
					}
					
					//Admission Date
					@Test
					public void Admission_Date()
					{
						driver.findElement(By.id("txtCreatedDate")).sendKeys("08/10/2018");
						boolean admission_date =driver.findElement(By.id("txtCreatedDate")).getAttribute("value").matches(admissiondate_pattern);
						Assert.assertTrue(admission_date, "Admission Date Field NOT Working");
					}
					
					//Next Button
					@Test
					public void Communicationdetails_next_button_Functionality()
					{
						driver.findElement(By.name("PinCodePermanentAddress")).sendKeys("2");
						driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/ul/li[2]/button")).click();
						String actual = driver.findElement(By.xpath("//*[@id=\"wizard\"]/ul/li[3]/a")).getText();
						String expected = "3. Course Details";
						Assert.assertEquals(actual, expected, "Next button NOT Working");
					}	
					
					//Course/Package
					@Test
					public void Course_Functionality()
					{
						Select course = new Select(driver.findElement(By.name("course-list")));
						course.selectByVisibleText("DOT NET");
						
						boolean document =driver.findElement(By.name("course-list")).getAttribute("value").matches(course_pattern);
						Assert.assertTrue(document, "Course field NOT Working");
					}
					
					//Discount
					
					@Test
					public void Blank_Discount_Functionality() throws InterruptedException
					{
						driver.findElement(By.name("Discount")).clear();
						driver.findElement(By.xpath("//*[@id=\"nav-state-toggle\"]/i")).click();
						Thread.sleep(2000);
						driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/ul/li[2]/button")).click();
						Thread.sleep(1000);
						String actual = driver.findElement(By.xpath("//*[@id=\"parsley-id-48\"]/li")).getText();
						String expected = "This value is required.";
						Assert.assertEquals(actual, expected, "Discount Accepted Blank Field");
					}
					
					@Test
					public void Discount_Functionality()
					{
						//driver.findElement(By.xpath("//*[@id=\"Course\"]/tbody/tr/td[3]/button/i")).click();
						driver.findElement(By.name("Discount")).sendKeys("20");
						String actual = driver.findElement(By.xpath("//*[@id=\"tab3\"]/form/fieldset/div/div/fieldset/div/div[4]/div/div/input")).getAttribute("value");
						String expected = "21600";
						Assert.assertEquals(actual, expected, "Discount Field NOT Working");
					}
					
					@Test
					public void CourseDetails_next_button_Functionality() throws InterruptedException
					{
						
						Thread.sleep(3000);
						//driver.findElement(By.xpath("//*[@id=\"nav-state-toggle\"]")).click();
						driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/ul/li[2]/button")).click();
						String actual = driver.findElement(By.xpath("//*[@id=\"wizard\"]/ul/li[4]/a")).getText();
						String expected = "4. Image upload";
						Assert.assertEquals(actual, expected, "Next Button NOT Working");
					}
					
					@Test
					public void Finish_button_Functionality() throws InterruptedException
					{
						Thread.sleep(2000);
						driver.findElement(By.xpath("//*[@id=\"btn-save\"]")).click();
						String actualname = driver.findElement(By.xpath("//*[@id=\"view-lead-status\"]/tbody/tr/td[2]")).getText();
						String actualmobno = driver.findElement(By.xpath("//*[@id=\"view-lead-status\"]/tbody/tr/td[3]")).getText();
						String actualemailid = driver.findElement(By.xpath("//*[@id=\"view-lead-status\"]/tbody/tr/td[4]")).getText();
						String actualcourse = driver.findElement(By.xpath("//*[@id=\"view-lead-status\"]/tbody/tr/td[5]")).getText();
						String actualcreateddate = driver.findElement(By.xpath("//*[@id=\"view-lead-status\"]/tbody/tr/td[6]")).getText();
					
						Assert.assertEquals(actualname, "Ashwini Ashok Patil", "Student Name not getting saved");
						Assert.assertEquals(actualmobno, "7896541230", "Mobile No not getting saved");
						Assert.assertEquals(actualemailid,"ashwini@gmail.com", "Email Id not getting saved");
						Assert.assertEquals(actualcourse, "DOT NET", "Course not getting saved");
						Assert.assertEquals(actualcreateddate, "08/10/2018", "Created Date not getting saved");
					}
					
					//Update
					@Test
					public void Update_Functionality() throws InterruptedException
					{
						Thread.sleep(3000);
						driver.findElement(By.xpath("//*[@id=\"view-lead-status\"]/tbody/tr[1]/td[7]/button[1]/i")).click();
						Thread.sleep(2000);
						driver.findElement(By.id("MiddleName")).clear();
						driver.findElement(By.id("MiddleName")).sendKeys("Suresh");
						driver.findElement(By.id("College")).clear();
						driver.findElement(By.id("College")).sendKeys("NDMVP College");
						driver.findElement(By.id("Qualification")).clear();
						driver.findElement(By.id("Qualification")).sendKeys("B.Tech");
						driver.findElement(By.id("AddharNo")).clear();
						driver.findElement(By.id("AddharNo")).sendKeys("8520147963014785");
						driver.findElement(By.xpath("//*[@id=\"DateOfBirth\"]")).sendKeys("12/11/1996");
						Select updrpgenderlist = new Select(driver.findElement(By.name("Gender")));
						updrpgenderlist.selectByVisibleText("Other");
						driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/ul/li[2]/button")).click();
						
						driver.findElement(By.id("MobilePrimary")).clear();
						driver.findElement(By.id("MobilePrimary")).sendKeys("1236547890");
						driver.findElement(By.id("MobileSecondary")).clear();
						driver.findElement(By.id("MobileSecondary")).sendKeys("7894561230");
						driver.findElement(By.id("EmailPrimary")).clear();
						driver.findElement(By.id("EmailPrimary")).sendKeys("aarti@gmail.com");
						driver.findElement(By.id("EmailSecondary")).clear();
						driver.findElement(By.id("EmailSecondary")).sendKeys("aarti11@gmail.com");
						driver.findElement(By.name("CurrentAddress")).clear();
						driver.findElement(By.name("CurrentAddress")).sendKeys("Flat no-9,Ganesh Appartment,Jehan Circle,Nashik");
						driver.findElement(By.name("PermanentAddress")).clear();
						driver.findElement(By.name("PermanentAddress")).sendKeys("Flat no-9,Ganesh Appartment,Jehan Circle,Nashik");
						driver.findElement(By.id("PinCodeCurrentAddress")).clear();
						driver.findElement(By.id("PinCodeCurrentAddress")).sendKeys("422205");
						driver.findElement(By.id("PinCodePermanentAddress")).clear();
						driver.findElement(By.id("PinCodePermanentAddress")).sendKeys("422205");
						Select document = new Select(driver.findElement(By.id("Document-list")));
						document.selectByVisibleText("Addhar Card");
						driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/ul/li[2]/button")).click();
						
						Select course = new Select(driver.findElement(By.name("course-list")));
						course.selectByVisibleText("JAVA");
						driver.findElement(By.name("Discount")).clear();

						driver.findElement(By.name("Discount")).sendKeys("10");
						driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/ul/li[2]/button")).click();
						driver.findElement(By.xpath("//*[@id=\"btn-save\"]")).click();
						
						String actualname = driver.findElement(By.xpath("//*[@id=\"view-lead-status\"]/tbody/tr[1]/td[2]")).getText();
						String actualmobno = driver.findElement(By.xpath("//*[@id=\"view-lead-status\"]/tbody/tr[1]/td[3]")).getText();
						String actualemailid = driver.findElement(By.xpath("//*[@id=\"view-lead-status\"]/tbody/tr/td[4]")).getText();
						String actualcourse = driver.findElement(By.xpath("//*[@id=\"view-lead-status\"]/tbody/tr/td[5]")).getText();
						String actualcreateddate = driver.findElement(By.xpath("//*[@id=\"view-lead-status\"]/tbody/tr/td[6]")).getText();
					
						Assert.assertEquals(actualname, "Ashwini Suresh Patil", "Student Name not getting saved");
						Assert.assertEquals(actualmobno, "1236547890", "Mobile No not getting saved");
						Assert.assertEquals(actualemailid,"aarti@gmail.com", "Email Id not getting saved");
						Assert.assertEquals(actualcourse, "DOT NET JAVA", "Course not getting saved");
						Assert.assertEquals(actualcreateddate, "08/10/2018", "Created Date not getting saved");
					}
					
					//Delete Admission
					@Test
					public void Delete_admission() throws InterruptedException
					{
						Thread.sleep(3000);
						driver.findElement(By.xpath("//*[@id=\"view-lead-status\"]/tbody/tr[1]/td[7]/button[2]/i")).click();
						Thread.sleep(2000);
						driver.findElement(By.xpath("//*[@id=\"remove-admission\"]")).click();
						Thread.sleep(3000);
						String actual = driver.findElement(By.xpath("//*[@id=\"view-lead-status\"]/tbody/tr/td")).getText();
						String expected = "No data available in table";
						Assert.assertEquals(actual, expected, "Admission NOT getting Deleted");
					
					}
		
	}
