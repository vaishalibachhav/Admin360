package com.mytest;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

	public class Master_Employee extends Login
	{
		String empname_pattern = "([a-zA-Z ]*[a-zA-Z ]*)+(\\s)*";
		String mobileno_pattern = "\\s*(\\d{10})*\\s*";
		String email_pattern = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
		String incentive_pattern = "\\s*\\d*";
		String gender_pattern = "[a-zA-Z]*";
		String address_pattern = "([a-zA-Z]*[a-zA-Z ]*[0-9]*[$&+,:;=?@#|'<>.^*()%!-]*)+(\\s)*";
		String username_pattern = "^(\\w+\\S+)$";
		String password_pattern = "^(\\w+\\S+)$";
		String role_pattern = "^(?!-1).*$";
		String confirmpassword_pattern = "\\b123";
		
	  @Test
	  public void Employeename_field_is_Blank() 
	  {
		  driver.findElement(By.xpath("//*[@id=\"nav-state-toggle\"]/i")).click();
		  driver.findElement(By.xpath("//*[@id=\"2\"]/li[5]/a")).click();
		  driver.findElement(By.xpath("//*[@id=\"btn-new-course\"]")).click();
		  driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/ul/li[2]/button")).click();
		  String actual = driver.findElement(By.xpath("//*[@id=\"parsley-id-6\"]/li")).getText();
		  String expected = "This value is required.";
		  Assert.assertEquals(actual, expected, "Employee Name accepted Blank Field");	
	  }
	  
	  @Test
	  public void Employeename_contain_special_characters() 
	  {
		  driver.findElement(By.name("EmployeeName")).sendKeys("!@#$%^&*");
		  boolean CourseName =driver.findElement(By.name("EmployeeName")).getAttribute("value").matches(empname_pattern);
		  Assert.assertTrue(CourseName, "Employee Name Contains Special Characters");
	  }
		
	  @Test
	  public void Employeename_contain_numbers()
	  {
		  driver.findElement(By.name("EmployeeName")).clear();
		  driver.findElement(By.name("EmployeeName")).sendKeys("025547");
		  boolean CourseName =driver.findElement(By.name("EmployeeName")).getAttribute("value").matches(empname_pattern);
		  Assert.assertTrue(CourseName, "Employee Name Contains Numbers");
	  }
		
	  @Test
	  public void Employeename_contain_alphabets() 
	  {
		  driver.findElement(By.name("EmployeeName")).clear();
		  driver.findElement(By.name("EmployeeName")).sendKeys("Prachi");
		  boolean CourseName =driver.findElement(By.name("EmployeeName")).getAttribute("value").matches(empname_pattern);
		  Assert.assertTrue(CourseName, "Employee Name Contain Alphabets");
	  }

	  //Mobile No
	  @Test
	  public void Mobile_No_contain_special_characters()
	  {
		  driver.findElement(By.name("MoblileNumber")).sendKeys("!@#$%^&&^*&**()");
		  boolean mobileno =driver.findElement(By.name("MoblileNumber")).getAttribute("value").matches(mobileno_pattern);
		  Assert.assertTrue(mobileno, " Mobile No Contains Spaecial Characters");
	  }		
		
	  @Test
	  public void Mobile_No_contain_whitespaces()
	  {
		  driver.findElement(By.name("MoblileNumber")).clear();
		  driver.findElement(By.name("MoblileNumber")).sendKeys("25985 38478");
		  boolean mobileno =driver.findElement(By.name("MoblileNumber")).getAttribute("value").matches(mobileno_pattern);
		  Assert.assertTrue(mobileno, " Mobile No Contains Whitespaces");
	  }
			
	  @Test
	  public void Mobile_No_contain_alphabets()
	  {
		  driver.findElement(By.name("MoblileNumber")).clear();
		  driver.findElement(By.name("MoblileNumber")).sendKeys("mobile");
		  boolean mobileno =driver.findElement(By.name("MoblileNumber")).getAttribute("value").matches(mobileno_pattern);
		  Assert.assertTrue(mobileno, " Mobile No Contains Alphabets");
	  }
		
	  @Test
	  public void Mobile_No_contain_numbers()
	  {
		  driver.findElement(By.name("MoblileNumber")).clear();
		  driver.findElement(By.name("MoblileNumber")).sendKeys("9630124587");
		  boolean mobileno =driver.findElement(By.name("MoblileNumber")).getAttribute("value").matches(mobileno_pattern);
		  Assert.assertTrue(mobileno, " Mobile No Contains Numbers");
	  }
				
	  @Test
	  public void Mobile_No_contain_negative_numbers()
	  {
		  driver.findElement(By.name("MoblileNumber")).clear();
		  driver.findElement(By.name("MoblileNumber")).sendKeys("-557855");
		  boolean mobileno =driver.findElement(By.name("MoblileNumber")).getAttribute("value").matches(mobileno_pattern);
		  Assert.assertTrue(mobileno, " Mobile No Contains Negative Numbers");
	  }
			
	  @Test
	  public void Mobile_No_contain_whitespaces_at_begining() 
	  {
		  driver.findElement(By.name("MoblileNumber")).clear();
		  driver.findElement(By.name("MoblileNumber")).sendKeys("  9874563210");
		  boolean mobileno =driver.findElement(By.name("MoblileNumber")).getAttribute("value").matches(mobileno_pattern);
		  Assert.assertTrue(mobileno, " Mobile No Contains Whitespaces at begining");
	  }
			
	  @Test
	  public void Mobile_No_field_is_Blank() 
	  {
		  driver.findElement(By.name("MoblileNumber")).clear();
		  boolean mobileno =driver.findElement(By.name("MoblileNumber")).getAttribute("value").matches(mobileno_pattern);
		  Assert.assertTrue(mobileno, " Mobile No is Blank");
	  }
			
	  @Test
	  public void Mobile_No_contain_lessthan_10_numbers() 
	  {
		  driver.findElement(By.name("MoblileNumber")).clear();
		  driver.findElement(By.name("MoblileNumber")).sendKeys("8989");
		  boolean mobileno =driver.findElement(By.name("MoblileNumber")).getAttribute("value").matches(mobileno_pattern);
		  Assert.assertTrue(mobileno, " Mobile No Contains Less than 10 numbers");
	  }
			
	  @Test
	  public void Mobile_No_contain_greaterthan_10_numbers() 
	  {
		  driver.findElement(By.name("MoblileNumber")).clear();
		  driver.findElement(By.name("MoblileNumber")).sendKeys("7896541230123");
		  boolean mobileno =driver.findElement(By.name("MoblileNumber")).getAttribute("value").matches(mobileno_pattern);
		  Assert.assertTrue(mobileno, " Mobile No contains greater than 10 numbers");
	  }
		
	  //Designation
	  @Test
	  public void Designation_contain_special_characters() 
	  {
		  driver.findElement(By.name("Designation")).sendKeys("!@#$%^&*");
		  boolean CourseName =driver.findElement(By.name("Designation")).getAttribute("value").matches(empname_pattern);
		  Assert.assertTrue(CourseName, "Employee Name Contains Special Characters");
	  }
			
	  @Test
	  public void Designation_contain_numbers()
	  {
		  driver.findElement(By.name("Designation")).clear();
		  driver.findElement(By.name("Designation")).sendKeys("025547");
		  boolean CourseName =driver.findElement(By.name("Designation")).getAttribute("value").matches(empname_pattern);
		  Assert.assertTrue(CourseName, "Employee Name Contains Numbers");
	  }
			
	  @Test
	  public void Designation_contain_alphabets() 
	  {
		  driver.findElement(By.name("Designation")).clear();
		  driver.findElement(By.name("Designation")).sendKeys("Admin");
		  boolean CourseName =driver.findElement(By.name("Designation")).getAttribute("value").matches(empname_pattern);
		  Assert.assertTrue(CourseName, "Employee Name Contain Alphabets");
	  } 
	  
	  //E-mail Id
	  @Test
	  public void Email_contains_whitespaces() throws InterruptedException
	  {
		  driver.findElement(By.name("EmailId")).clear();
		  driver.findElement(By.name("EmailId")).sendKeys("prachi @gmail.com");
		  driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/ul/li[2]/button")).click();
		  Thread.sleep(2000);
		  String actual = driver.findElement(By.xpath("//*[@id=\"parsley-id-12\"]/li")).getText();
		  String expected = "This value should be a valid email.";
		  Assert.assertEquals(actual, expected, " Email Contains Whitespaces");
	  }
		
	  @Test
	  public void Email_valid()
	  {
		  driver.findElement(By.name("EmailId")).clear();
		  driver.findElement(By.name("EmailId")).sendKeys("prachi@gmail.com");
		  String actual = "";
		  String expected = "";
		  Assert.assertEquals(actual, expected, " Email Id is NOT valid");
	  }
	
	
	  @Test
	  public void Email_contains_whitespaces_at_begining() throws InterruptedException 
	  {
		  driver.findElement(By.name("EmailId")).clear();
		  Thread.sleep(1000);
		  driver.findElement(By.name("EmailId")).sendKeys("       prachi@gmail.com");
		  boolean email =driver.findElement(By.name("EmailId")).getAttribute("value").matches(email_pattern);
		  Assert.assertTrue(email, " Email contain Whitespaces at Begining");
	  }
		
	  //Incentive
		@Test
		public void Incentive_contain_special_characters()
		{
			driver.findElement(By.name("Incentive")).sendKeys("!@#$%^&*()");
			boolean incentive =driver.findElement(By.name("Incentive")).getAttribute("value").matches(incentive_pattern);
			Assert.assertTrue(incentive, "Incentive Contains Spaecial Characters");
		}
	
		@Test
		public void Incentive_contain_whitespaces()
		{
			driver.findElement(By.name("Incentive")).clear();
			driver.findElement(By.name("Incentive")).sendKeys("200 00");
			boolean incentive =driver.findElement(By.name("Incentive")).getAttribute("value").matches(incentive_pattern);
			Assert.assertTrue(incentive, "Incentive Contains Whitespaces");
		}
		
		@Test
		public void Incentive_contain_alphabets()
		{
			driver.findElement(By.name("Incentive")).clear();
			driver.findElement(By.name("Incentive")).sendKeys("Twenty Thousand");
			boolean incentive =driver.findElement(By.name("Incentive")).getAttribute("value").matches(incentive_pattern);
			Assert.assertTrue(incentive, "Incentive Contains Alphabets");
		}
		
		@Test
		public void Incentive_contain_numbers()
		{
			driver.findElement(By.name("Incentive")).clear();
			driver.findElement(By.name("Incentive")).sendKeys("25000");
			boolean incentive =driver.findElement(By.name("Incentive")).getAttribute("value").matches(incentive_pattern);
			Assert.assertTrue(incentive, "Incentive Contains Numbers");
		}
		
		@Test
		public void Incentive_contain_negative_numbers()
		{
			driver.findElement(By.name("Incentive")).clear();
			driver.findElement(By.name("Incentive")).sendKeys("-21000");
			boolean incentive =driver.findElement(By.name("Incentive")).getAttribute("value").matches(incentive_pattern);
			Assert.assertTrue(incentive, "Incentive Contains Negative Numbers");
		}
		
		@Test
	  	public void Incentive_contain_whitespaces_at_begining() 
		{
			driver.findElement(By.name("Incentive")).clear();
			driver.findElement(By.name("Incentive")).sendKeys("  20000");
			boolean incentive =driver.findElement(By.name("Incentive")).getAttribute("value").matches(incentive_pattern);
			Assert.assertTrue(incentive, "Incentive Contains Whitespaces at begining");
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
	  
		//Address
		@Test
		public void Valid_Address()
		{
			driver.findElement(By.name("Address")).sendKeys("Flat no-15,Ganesh Appartment, Near Prasad Circle,Gangapur Road,Nashik");
			boolean address =driver.findElement(By.name("Address")).getAttribute("value").matches(address_pattern);
			Assert.assertTrue(address, "Current Address in NOT valid");
		}

		//Next Button Functionality
		@Test
		public void PersonalInfo_Next_Button_Functionality() throws InterruptedException
		{
			driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/ul/li[2]/button")).click();
			Thread.sleep(1000);
			String actual = driver.findElement(By.xpath("//*[@id=\"wizard\"]/ul/li[2]/a")).getCssValue("background-color");
			String expected = "rgba(93, 143, 194, 1)";
			Assert.assertEquals(actual, expected, "Next Button Not Working");
		}
		
		//User Name
		@Test
		public void Blank_UserName()
		{
			driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/ul/li[2]/button")).click();
			String actual = driver.findElement(By.xpath("//*[@id=\"parsley-id-2\"]/li")).getText();
			String expected = "This value is required.";
			Assert.assertEquals(actual, expected, "User Name Accepted Blank Field");
		}
	
		@Test
		public void Existing_UserName() throws InterruptedException
		{
			driver.findElement(By.name("UserName")).clear();
			driver.findElement(By.name("UserName")).sendKeys("vaishali");
			driver.findElement(By.name("Password")).click();
			Thread.sleep(1000);
			String actual = driver.findElement(By.xpath("//*[@id=\"parsley-id-2\"]/li")).getText();
			String expected = "User Name Already Exist try another Name..";
			Assert.assertEquals(actual, expected, "Existing User Name Accepted");
		}
		
		@Test
		public void UserName()
		{
			driver.findElement(By.name("UserName")).clear();
			driver.findElement(By.name("UserName")).sendKeys("Rajashree1");
			boolean username =driver.findElement(By.name("UserName")).getAttribute("value").matches(username_pattern);
			Assert.assertTrue(username, "User Name in NOT valid");
		}
		
		//Employee Role
		@Test
		public void Blank_Employee_Role()
		{
			boolean role =driver.findElement(By.name("EmpRoleId")).getAttribute("value").matches(role_pattern);
			Assert.assertTrue(role, "Employee Role is Blank");
		}
		
		@Test
		public void Employee_Role() throws InterruptedException
		{
			Select drprole = new Select(driver.findElement(By.name("EmpRoleId")));
			drprole.selectByVisibleText("admin");
			Thread.sleep(1500);
			boolean role =driver.findElement(By.name("EmpRoleId")).getAttribute("value").matches(role_pattern);
			Assert.assertTrue(role, "Employee Role is Invalid");
		}
		
		//Password
		@Test
		public void Blank_Password()
		{
			String actual = driver.findElement(By.xpath("//*[@id=\"parsley-id-22\"]/li")).getText();
			String expected = "This value is required.";
			Assert.assertEquals(actual, expected, "Password Accepted Blank Field");
		}
		
		@Test
		public void Password()
		{
			driver.findElement(By.name("Password")).sendKeys("123");
			boolean password =driver.findElement(By.name("Password")).getAttribute("value").matches(password_pattern);
			Assert.assertTrue(password,"Passwoord in NOT valid");
		}
		
		//Confirm Password
		@Test
		public void Blank_Confirm_Password()
		{
			String actual = driver.findElement(By.xpath("//*[@id=\"parsley-id-26\"]/li")).getText();
			String expected = "This value is required.";
			Assert.assertEquals(actual, expected, "Confirm Password Accepted Blank Field");
		}
		
		@Test
		public void Different_Confirm_Password()
		{
			driver.findElement(By.name("ConfirmPassword")).sendKeys("111");
			String actual = driver.findElement(By.xpath("//*[@id=\"parsley-id-26\"]/li")).getText();
			String expected = "This value should be the same.";
			Assert.assertEquals(actual, expected, "Confirm Password Accepted Different Password");
		}
		
		@Test
		public void Confirm_Password()
		{
			driver.findElement(By.name("ConfirmPassword")).clear();
			driver.findElement(By.name("ConfirmPassword")).sendKeys("123");
			boolean confirmpassword =driver.findElement(By.name("ConfirmPassword")).getAttribute("value").matches(confirmpassword_pattern);
			Assert.assertTrue(confirmpassword, "Confirm Password Invalid");
		}
		
		//Next Button Functionality
		@Test
		public void EmployeeRole_Next_Button_Functionality() throws InterruptedException
		{
			driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/ul/li[2]/button")).click();
			Thread.sleep(1000);
			String actual = driver.findElement(By.xpath("//*[@id=\"wizard\"]/ul/li[3]/a")).getCssValue("background-color");
			String expected = "rgba(93, 143, 194, 1)";
			Assert.assertEquals(actual, expected, "Next Button Not Working");
		}		
		
		//Finish Button
		@Test
		public void Finish_Button_Functionality() throws InterruptedException
		{
			driver.findElement(By.xpath("//*[@id=\"btn-save\"]")).click();
			Thread.sleep(1000);
			String actualempname = driver.findElement(By.xpath("//*[@id=\"view-emplyee\"]/tbody/tr[1]/td[2]")).getText();
			String actualrole = driver.findElement(By.xpath("//*[@id=\"view-emplyee\"]/tbody/tr[1]/td[3]")).getText();
			String actualmobno = driver.findElement(By.xpath("//*[@id=\"view-emplyee\"]/tbody/tr[1]/td[4]")).getText();
			String actualemail = driver.findElement(By.xpath("//*[@id=\"view-emplyee\"]/tbody/tr[1]/td[5]")).getText();
			String actualincentive = driver.findElement(By.xpath("//*[@id=\"view-emplyee\"]/tbody/tr[1]/td[6]")).getText();
			String actualdate = driver.findElement(By.xpath("//*[@id=\"view-emplyee\"]/tbody/tr[1]/td[7]")).getText();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			String date = dateFormat.format(new Date());
			Assert.assertEquals(actualempname, "Prachi", "Employee Name Not Getting Saved");
			Assert.assertEquals(actualrole, "admin", "Role Not Getting Saved");
			Assert.assertEquals(actualmobno,"7896541230","Mobile No Not Getting Saved");
			Assert.assertEquals(actualemail, "prachi@gmail.com", "Email Id Not Getting Saved");
			Assert.assertEquals(actualincentive, "20000", "Incentive Not Getting Saved");
			Assert.assertEquals(actualdate, date, "Date Not Getting Saved");
		}
		
		//Update
		@Test
		public void Update_Button_Functionality() throws InterruptedException
		{
			driver.findElement(By.xpath("//*[@id=\"nav-state-toggle\"]/i")).click();
			Thread.sleep(1500);
			driver.findElement(By.xpath("//*[@id=\"view-emplyee\"]/tbody/tr[1]/td[8]/button[1]/i")).click();
			Thread.sleep(2000);
			driver.findElement(By.name("EmployeeName")).clear();
			driver.findElement(By.name("EmployeeName")).sendKeys("Priyanka");
			driver.findElement(By.name("MoblileNumber")).clear();
			driver.findElement(By.name("MoblileNumber")).sendKeys("8520147963");
			driver.findElement(By.name("Designation")).clear();
			driver.findElement(By.name("Designation")).sendKeys("Trainer");
			driver.findElement(By.name("EmailId")).clear();
			driver.findElement(By.name("EmailId")).sendKeys("priyanka@gmail.com");
			driver.findElement(By.name("Incentive")).clear();
			driver.findElement(By.name("Incentive")).sendKeys("20000");
			Select drpgenderlist = new Select(driver.findElement(By.name("Gender")));
			drpgenderlist.selectByVisibleText("Female");
			driver.findElement(By.name("Address")).sendKeys("Flat no-15,Ganesh Appartment, Near Prasad Circle,Gangapur Road,Nashik");
			driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/ul/li[2]/button")).click();
			Thread.sleep(1000);
			driver.findElement(By.name("Username")).clear();
			driver.findElement(By.name("Username")).sendKeys("Priyanka");
			Select drprole = new Select(driver.findElement(By.name("EmpRoleId")));
			drprole.selectByVisibleText("admin");
			driver.findElement(By.name("Password")).clear();
			driver.findElement(By.name("Password")).sendKeys("123");
			driver.findElement(By.name("ConfirmPassword")).clear();
			driver.findElement(By.name("ConfirmPassword")).sendKeys("123");
			driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/ul/li[2]/button")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"btn-save\"]")).click();	  
			
			String actualname = driver.findElement(By.xpath("//*[@id=\"view-emplyee\"]/tbody/tr[1]/td[2]")).getText();
			String actualrole = driver.findElement(By.xpath("//*[@id=\"view-emplyee\"]/tbody/tr[1]/td[3]")).getText();
			String actualmobno = driver.findElement(By.xpath("//*[@id=\"view-emplyee\"]/tbody/tr[1]/td[4]")).getText();
			String actualemail = driver.findElement(By.xpath("//*[@id=\"view-emplyee\"]/tbody/tr[1]/td[5]")).getText();
			String actualincentive = driver.findElement(By.xpath("//*[@id=\"view-emplyee\"]/tbody/tr[1]/td[6]")).getText();
			String actualdate = driver.findElement(By.xpath("//*[@id=\"view-emplyee\"]/tbody/tr[1]/td[7]")).getText();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		 	String date = dateFormat.format(new Date());
			Assert.assertEquals(actualname, "Priyanka", "Employee Name NOT Getting Updated");
			Assert.assertEquals(actualrole, "admin", "Employee Role NOT Getting Updated");
			Assert.assertEquals(actualmobno, "8520147963", "Employee Mobile No NOT Getting Updated");
			Assert.assertEquals(actualemail, "priyanka@gmail.com", "Employee Email NOT Getting Updated");
			Assert.assertEquals(actualincentive, "20000", "Incentive NOT Getting Updated");
			Assert.assertEquals(actualdate, date, "Date NOT Getting Updated");
		}
		
		//Delete
		@Test
		public void Delete_Cancel_Button_Functionality() throws InterruptedException
		{
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"view-emplyee\"]/tbody/tr[1]/td[8]/button[2]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"remove-modal\"]/div/div/div[2]/button[1]")).click();
			String actualname = driver.findElement(By.xpath("//*[@id=\"view-emplyee\"]/tbody/tr[1]/td[2]")).getText();
			String actualrole = driver.findElement(By.xpath("//*[@id=\"view-emplyee\"]/tbody/tr[1]/td[3]")).getText();
			String actualmobno = driver.findElement(By.xpath("//*[@id=\"view-emplyee\"]/tbody/tr[1]/td[4]")).getText();
			String actualemail = driver.findElement(By.xpath("//*[@id=\"view-emplyee\"]/tbody/tr[1]/td[5]")).getText();
			String actualincentive = driver.findElement(By.xpath("//*[@id=\"view-emplyee\"]/tbody/tr[1]/td[6]")).getText();
			String actualdate = driver.findElement(By.xpath("//*[@id=\"view-emplyee\"]/tbody/tr[1]/td[7]")).getText();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		 	String date = dateFormat.format(new Date());
			Assert.assertEquals(actualname, "Priyanka", "Employee Name NOT Getting Updated");
			Assert.assertEquals(actualrole, "admin", "Employee Role NOT Getting Updated");
			Assert.assertEquals(actualmobno, "8520147963", "Employee Mobile No NOT Getting Updated");
			Assert.assertEquals(actualemail, "priyanka@gmail.com", "Employee Email NOT Getting Updated");
			Assert.assertEquals(actualincentive, "20000", "Incentive NOT Getting Updated");
			Assert.assertEquals(actualdate, date, "Date NOT Getting Updated");
		}
		
		@Test
		public void Delete_Button_Functionality() throws InterruptedException
		{
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"view-emplyee\"]/tbody/tr[1]/td[8]/button[2]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"remove-receipt\"]")).click();
			String actualname = driver.findElement(By.xpath("//*[@id=\"view-emplyee\"]/tbody/tr[1]/td[2]")).getText();
			String actualrole = driver.findElement(By.xpath("//*[@id=\"view-emplyee\"]/tbody/tr[1]/td[3]")).getText();
			String actualmobno = driver.findElement(By.xpath("//*[@id=\"view-emplyee\"]/tbody/tr[1]/td[4]")).getText();
			String actualemail = driver.findElement(By.xpath("//*[@id=\"view-emplyee\"]/tbody/tr[1]/td[5]")).getText();
			String actualincentive = driver.findElement(By.xpath("//*[@id=\"view-emplyee\"]/tbody/tr[1]/td[6]")).getText();
			String actualdate = driver.findElement(By.xpath("//*[@id=\"view-emplyee\"]/tbody/tr[1]/td[7]")).getText();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		 	String date = dateFormat.format(new Date());
			Assert.assertEquals(actualname, "vaishali", "Employee Name NOT Getting Updated");
			Assert.assertEquals(actualrole, "admin", "Employee Role NOT Getting Updated");
			Assert.assertEquals(actualmobno, "9874563210", "Employee Mobile No NOT Getting Updated");
			Assert.assertEquals(actualemail, "v@gmail.com", "Employee Email NOT Getting Updated");
			Assert.assertEquals(actualincentive, "0", "Incentive NOT Getting Updated");
			Assert.assertEquals(actualdate, date, "Date NOT Getting Updated");
		}
		
	}
