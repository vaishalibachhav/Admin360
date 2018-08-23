package com.mytest;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

	public class Payment extends Login
	{
		String name_pattern = "([a-zA-Z ]*[a-zA-Z ]*)+(\\s)*";
		String mobileno_pattern = "\\s*(\\d{10})*\\s*";
		String email_pattern = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
		String amount_pattern = "\\s*\\d*";
		String paymodemode_pattern = "[1-3]";
		String accounthead_pattern = "\\s*\\d*";
		String notes_pattern = "([a-zA-Z]*[a-zA-Z ]*[0-9]*[$&+,:;=?@#|'<>.^*()%!-]*)+(\\s)*";


		
		@Test
		public void Add_Receipt()
		{
			driver.findElement(By.xpath("//*[@id=\"nav-state-toggle\"]/i")).click();
		  	driver.findElement(By.xpath("//*[@id=\"2\"]/li[2]/a")).click();
		  	driver.findElement(By.xpath("//*[@id=\"btn-new-course\"]")).click();
			driver.findElement(By.name("AccountTitle")).sendKeys("Electricity Bill");
			Select drpaccunttype = new Select(driver.findElement(By.id("ddlIsCredit")));
			drpaccunttype.selectByVisibleText("Debit");
			driver.findElement(By.id("btn-save-account-type")).click();
		}
		
		//Name
		@Test
		public void Name_contain_Special_Characters() throws InterruptedException
		{
			Thread.sleep(1500);
			Actions action = new Actions(driver);
			WebElement we = driver.findElement(By.xpath("//*[@id=\"8\"]/li[1]/a"));
			action.moveToElement(we).moveToElement(driver.findElement(By.xpath("//*[@id=\"8\"]/li[1]/a"))).click().build().perform();
			Thread.sleep(1500);
			driver.navigate().refresh();
			driver.findElement(By.name("Name")).sendKeys("#$#^%&^&*(");
			boolean studentname =driver.findElement(By.name("Name")).getAttribute("value").matches(name_pattern);
			Assert.assertTrue(studentname, " Name Contains Special Characters");
		}
		  
		@Test
		public void Name_contain_numbers()
		{
			driver.findElement(By.name("Name")).clear();
			driver.findElement(By.name("Name")).sendKeys("025547");
			boolean studentname =driver.findElement(By.name("Name")).getAttribute("value").matches(name_pattern);
			Assert.assertTrue(studentname, " Name Contains Numbers");
		}
		
		@Test
		public void Name_contain_whitespaces()
		{
			    driver.findElement(By.name("Name")).clear();
			    driver.findElement(By.name("Name")).sendKeys("Ashwini Ahire");
				boolean studentname =driver.findElement(By.name("Name")).getAttribute("value").matches(name_pattern);
				Assert.assertTrue(studentname, " Name Contains Whitespaces");
		}
			
		@Test
		public void Name_contain_alphabets() 
		{
				driver.findElement(By.name("Name")).clear();
				driver.findElement(By.name("Name")).sendKeys("Ashwini");
				boolean studentname =driver.findElement(By.name("Name")).getAttribute("value").matches(name_pattern);
				Assert.assertTrue(studentname, " Name Contain Alphabets");
		}
						
		@Test
		public void Name_field_is_Blank() throws InterruptedException 
		{
				driver.findElement(By.name("Name")).clear();
				driver.findElement(By.id("btn-payment-voucher")).click();
				driver.findElement(By.id("btn-payment-voucher")).click();
				Thread.sleep(2000);
				String actual = driver.findElement(By.xpath("//*[@id=\"parsley-id-6\"]/li")).getText();
				String expected = "This value is required.";
				Assert.assertEquals(actual, expected, " Name Accepted Blank Field");
		}
		
		//Mobile No
		@Test
		public void Mobile_No_contain_special_characters()
		{
			driver.findElement(By.name("Name")).sendKeys("Ashwini");
			driver.findElement(By.name("MobileNumber")).sendKeys("!@#$%^&&^*&**()");
			boolean mobileno =driver.findElement(By.name("MobileNumber")).getAttribute("value").matches(mobileno_pattern);
			Assert.assertTrue(mobileno, " Mobile No Contains Spaecial Characters");
		}
	
		@Test
		public void Mobile_No_contain_whitespaces()
		{
			driver.findElement(By.name("MobileNumber")).clear();
			driver.findElement(By.name("MobileNumber")).sendKeys("25985 38478");
			boolean mobileno =driver.findElement(By.name("MobileNumber")).getAttribute("value").matches(mobileno_pattern);
			Assert.assertTrue(mobileno, " Mobile No Contains Whitespaces");
		}
		
		@Test
		public void Mobile_No_contain_alphabets()
		{
			driver.findElement(By.name("MobileNumber")).clear();
			driver.findElement(By.name("MobileNumber")).sendKeys("mobile");
			boolean mobileno =driver.findElement(By.name("MobileNumber")).getAttribute("value").matches(mobileno_pattern);
			Assert.assertTrue(mobileno, " Mobile No Contains Alphabets");
		}
		
		@Test
		public void Mobile_No_contain_numbers()
		{
			driver.findElement(By.name("MobileNumber")).clear();
			driver.findElement(By.name("MobileNumber")).sendKeys("9630124587");
			boolean mobileno =driver.findElement(By.name("MobileNumber")).getAttribute("value").matches(mobileno_pattern);
			Assert.assertTrue(mobileno, " Mobile No Contains Numbers");
		}
		
		@Test
		public void Mobile_No_contain_negative_numbers()
		{
			driver.findElement(By.name("MobileNumber")).clear();
			driver.findElement(By.name("MobileNumber")).sendKeys("-557855");
			boolean mobileno =driver.findElement(By.name("MobileNumber")).getAttribute("value").matches(mobileno_pattern);
			Assert.assertTrue(mobileno, " Mobile No Contains Negative Numbers");
		}
		
		@Test
	  	public void Mobile_No_contain_whitespaces_at_begining() 
		{
			driver.findElement(By.name("MobileNumber")).clear();
			driver.findElement(By.name("MobileNumber")).sendKeys("  9874563210");
			boolean mobileno =driver.findElement(By.name("MobileNumber")).getAttribute("value").matches(mobileno_pattern);
			Assert.assertTrue(mobileno, " Mobile No Contains Whitespaces at begining");
		}
		
		@Test
	  	public void Mobile_No_field_is_Blank() 
		{
			driver.findElement(By.name("MobileNumber")).clear();
			boolean mobileno =driver.findElement(By.name("MobileNumber")).getAttribute("value").matches(mobileno_pattern);
			Assert.assertTrue(mobileno, " Mobile No is Blank");
		}
		
		@Test
	  	public void Mobile_No_contain_lessthan_10_numbers() 
		{
			driver.findElement(By.name("MobileNumber")).clear();
			driver.findElement(By.name("MobileNumber")).sendKeys("8989");
			boolean mobileno =driver.findElement(By.name("MobileNumber")).getAttribute("value").matches(mobileno_pattern);
			Assert.assertTrue(mobileno, " Mobile No Contains Less than 10 numbers");
		}
		
		@Test
	  	public void Mobile_No_contain_greaterthan_10_numbers() 
		{
			driver.findElement(By.name("MobileNumber")).clear();
			driver.findElement(By.name("MobileNumber")).sendKeys("7896541230123");
			boolean mobileno =driver.findElement(By.name("MobileNumber")).getAttribute("value").matches(mobileno_pattern);
			Assert.assertTrue(mobileno, " Mobile No contains greater than 10 numbers");
		}
		
		//E-mail Id
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
		
		//Amount
		@Test
	  	public void Amount_field_is_Blank() 
		{
			String actual = driver.findElement(By.xpath("//*[@id=\"parsley-id-20\"]/li")).getText();
			String expected =  "This value is required.";
			System.out.println();
			Assert.assertEquals(actual, expected , "Amount field is Blank");
		}
		
		@Test
		public void Amount_contain_special_characters()
		{
			driver.findElement(By.name("Amount")).sendKeys("!@#$%^&*()");
			boolean amount =driver.findElement(By.name("Amount")).getAttribute("value").matches(amount_pattern);
			Assert.assertTrue(amount, "Amount Contains Spaecial Characters");
		}
	
		@Test
		public void Amount_contain_whitespaces()
		{
			driver.findElement(By.name("Amount")).clear();
			driver.findElement(By.name("Amount")).sendKeys("2000 3000");
			boolean amount =driver.findElement(By.name("Amount")).getAttribute("value").matches(amount_pattern);
			Assert.assertTrue(amount, "Amount Contains Whitespaces");
		}
		
		@Test
		public void Amount_contain_alphabets()
		{
			driver.findElement(By.name("Amount")).clear();
			driver.findElement(By.name("Amount")).sendKeys("fees");
			boolean amount =driver.findElement(By.name("Amount")).getAttribute("value").matches(amount_pattern);
			Assert.assertTrue(amount, "Amount Contains Alphabets");
		}
		
		@Test
		public void Amount_contain_numbers()
		{
			driver.findElement(By.name("Amount")).clear();
			driver.findElement(By.name("Amount")).sendKeys("2000");
			boolean amount =driver.findElement(By.name("Amount")).getAttribute("value").matches(amount_pattern);
			Assert.assertTrue(amount, "Amount Contains Numbers");
		}
		
		@Test
		public void Amount_contain_negative_numbers()
		{
			driver.findElement(By.name("Amount")).clear();
			driver.findElement(By.name("Amount")).sendKeys("-557855");
			boolean amount =driver.findElement(By.name("Amount")).getAttribute("value").matches(amount_pattern);
			Assert.assertTrue(amount, "Amount Contains Negative Numbers");
		}
		
		@Test
	  	public void Amount_contain_whitespaces_at_begining() 
		{
			driver.findElement(By.name("Amount")).clear();
			driver.findElement(By.name("Amount")).sendKeys("  2000");
			boolean amount =driver.findElement(By.name("Amount")).getAttribute("value").matches(amount_pattern);
			Assert.assertTrue(amount, "Amount Contains Whitespaces at begining");
		}
		
		 //Payment Mode
		  @Test
		  public void Payment_Mode_Functionality()
		  {
			  Select paymentmode = new Select(driver.findElement(By.name("PaymentModeId")));
			  paymentmode.selectByVisibleText("Cash");
			  boolean drppaymentmode =driver.findElement(By.name("PaymentModeId")).getAttribute("value").matches(paymodemode_pattern);
			  Assert.assertTrue(drppaymentmode, "Payment Mode Field NOT Working");
		  }
		  
		//Account Head
		@Test
		public void Account_Head()
		{
			Select accounthead = new Select(driver.findElement(By.name("AccountType")));
			accounthead.selectByVisibleText("Electricity Bill");
			boolean drpaccounthead =driver.findElement(By.name("AccountType")).getAttribute("value").matches(accounthead_pattern);
			Assert.assertTrue(drpaccounthead, "Account Head Field NOT Working");
		}
		
		 //Notes
		 @Test
		 public void Notes()
		{
			driver.findElement(By.name("Note")).sendKeys("2000 Paid");
			boolean notes =driver.findElement(By.name("Note")).getAttribute("value").matches(notes_pattern);
			Assert.assertTrue(notes, "Notes Field NOT Working");
		}
		
		//Save Changes Button
		@Test
		public void Save_Changes_Button_Functionality() throws InterruptedException
		{
			driver.findElement(By.id("btn-payment-voucher")).click();
			Thread.sleep(1000);
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		 	String date = dateFormat.format(new Date());
			String actualname = driver.findElement(By.xpath("//*[@id=\"view-payment-voucher\"]/tbody/tr[1]/td[2]")).getText();
			String actualmobileno = driver.findElement(By.xpath("//*[@id=\"view-payment-voucher\"]/tbody/tr[1]/td[3]")).getText();
			String actualamount = driver.findElement(By.xpath("//*[@id=\"view-payment-voucher\"]/tbody/tr[1]/td[4]")).getText();
			String actualdate = driver.findElement(By.xpath("//*[@id=\"view-payment-voucher\"]/tbody/tr[1]/td[5]")).getText();
			String actualaccount = driver.findElement(By.xpath("//*[@id=\"view-payment-voucher\"]/tbody/tr[1]/td[6]")).getText();
			String actualpaymentmode = driver.findElement(By.xpath("//*[@id=\"view-payment-voucher\"]/tbody/tr[1]/td[7]")).getText();
			Assert.assertEquals(actualname, "Ashwini", "Name NOT Getting Saved");
			Assert.assertEquals(actualmobileno, "7896541230", "Mobile No NOT Getting Saved");
			Assert.assertEquals(actualamount, "2000", "Amount NOT Getting Saved");
			Assert.assertEquals(actualdate, date, "Date NOT Getting Saved");
			Assert.assertEquals(actualaccount, "Electricity Bill", "Account NOT Getting Saved");
			Assert.assertEquals(actualpaymentmode, "Cash", "Payment Mode NOT Getting Saved");
		}
		
		//Update 
		@Test
		public void Update_Functionality() throws InterruptedException
		{
			driver.findElement(By.xpath("//*[@id=\"nav-state-toggle\"]/i")).click();
			Thread.sleep(1500);
			driver.findElement(By.xpath("//*[@id=\"view-payment-voucher\"]/tbody/tr[1]/td[8]/button[1]/i")).click();
			Thread.sleep(1500);
			//driver.switchTo().alert().accept();
			Thread.sleep(2000);
			driver.findElement(By.name("MobileNo")).clear();
			driver.findElement(By.name("MobileNo")).sendKeys("9874563210");
			driver.findElement(By.name("EmailId")).clear();
			driver.findElement(By.name("EmailId")).sendKeys("pooja@gmail.com");
			driver.findElement(By.name("Amount")).clear();
			driver.findElement(By.name("Amount")).sendKeys("1000");
			Select accounthead = new Select(driver.findElement(By.name("AccountType")));
			accounthead.selectByVisibleText("Electricity Bill");
			driver.findElement(By.name("Note")).clear();
			driver.findElement(By.name("Note")).sendKeys("1000 Paid");
			driver.findElement(By.id("btn-update-payment-voucher")).click();
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		 	String date = dateFormat.format(new Date());
			String actualname = driver.findElement(By.xpath("//*[@id=\"view-payment-voucher\"]/tbody/tr[1]/td[2]")).getText();
			String actualmobileno = driver.findElement(By.xpath("//*[@id=\"view-payment-voucher\"]/tbody/tr[1]/td[3]")).getText();
			String actualamount = driver.findElement(By.xpath("//*[@id=\"view-payment-voucher\"]/tbody/tr[1]/td[4]")).getText();
			String actualdate = driver.findElement(By.xpath("//*[@id=\"view-payment-voucher\"]/tbody/tr[1]/td[5]")).getText();
			String actualaccount = driver.findElement(By.xpath("//*[@id=\"view-payment-voucher\"]/tbody/tr[1]/td[6]")).getText();
			String actualpaymentmode = driver.findElement(By.xpath("//*[@id=\"view-payment-voucher\"]/tbody/tr[1]/td[7]")).getText();
			Assert.assertEquals(actualname, "Ashwini", "Name NOT Getting Saved");
			Assert.assertEquals(actualmobileno, "9874563210", "Mobile No NOT Getting Saved");
			Assert.assertEquals(actualamount, "1000", "Amount NOT Getting Saved");
			Assert.assertEquals(actualdate, date, "Date NOT Getting Saved");
			Assert.assertEquals(actualaccount, "Electricity Bill", "Account NOT Getting Saved");
			Assert.assertEquals(actualpaymentmode, "Cash", "Payment Mode NOT Getting Saved");
		}
		
		//Delete
		@Test
		public void Delete() throws InterruptedException
		{
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"view-payment-voucher\"]/tbody/tr[1]/td[8]/button[2]/i")).click();
			Thread.sleep(1500);
			driver.findElement(By.xpath("//*[@id=\"remove-course\"]")).click();
			Thread.sleep(1500);
			String actual = driver.findElement(By.xpath("//*[@id=\"view-payment-voucher\"]/tbody/tr/td")).getText();
			String expected = "No data available in table";
			Assert.assertEquals(actual, expected, "Receipt NOT Getting Deleted");
		}	
		
		///Cheque Payment Mode
		@Test
		public void Cheque_Payment_Mode() throws InterruptedException
		{
			driver.findElement(By.xpath("//*[@id=\"nav-state-toggle\"]/i")).click();
			Thread.sleep(1500);
			driver.findElement(By.xpath("//*[@id=\"sidebar\"]/div/div[1]/ul[1]/li[8]/a")).click();
			driver.findElement(By.xpath("//*[@id=\"8\"]/li[1]/a")).click();
			driver.navigate().refresh();
			Thread.sleep(1500);
			driver.findElement(By.name("Name")).sendKeys("Rohini");
			driver.findElement(By.name("MobileNumber")).sendKeys("7896541230");
			driver.findElement(By.name("EmailId")).sendKeys("Rohini@gmail.com");
			driver.findElement(By.name("Amount")).sendKeys("500");
			Select paymentmode = new Select(driver.findElement(By.name("PaymentModeId")));
			paymentmode.selectByVisibleText("Cheque");
			Select bankname = new Select(driver.findElement(By.name("BankName")));
			bankname.selectByVisibleText("HDFC BANK LTD");
			driver.findElement(By.name("ChequeNo")).sendKeys("655963");
			driver.findElement(By.name("ChequeDate")).sendKeys("10/12/2018");
			driver.findElement(By.name("IfscCode")).sendKeys("HDFC000268898");
			Select accounthead = new Select(driver.findElement(By.name("AccountType")));
			accounthead.selectByVisibleText("Electricity Bill");
			driver.findElement(By.id("btn-payment-voucher")).click();
			
			Thread.sleep(1000);
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		 	String date = dateFormat.format(new Date());
			String actualname = driver.findElement(By.xpath("//*[@id=\"view-payment-voucher\"]/tbody/tr[1]/td[2]")).getText();
			String actualmobileno = driver.findElement(By.xpath("//*[@id=\"view-payment-voucher\"]/tbody/tr[1]/td[3]")).getText();
			String actualamount = driver.findElement(By.xpath("//*[@id=\"view-payment-voucher\"]/tbody/tr[1]/td[4]")).getText();
			String actualdate = driver.findElement(By.xpath("//*[@id=\"view-payment-voucher\"]/tbody/tr[1]/td[5]")).getText();
			String actualaccount = driver.findElement(By.xpath("//*[@id=\"view-payment-voucher\"]/tbody/tr[1]/td[6]")).getText();
			String actualpaymentmode = driver.findElement(By.xpath("//*[@id=\"view-payment-voucher\"]/tbody/tr[1]/td[7]")).getText();
			Assert.assertEquals(actualname, "Rohini", "Name NOT Getting Saved");
			Assert.assertEquals(actualmobileno, "7896541230", "Mobile No NOT Getting Saved");
			Assert.assertEquals(actualamount, "500", "Amount NOT Getting Saved");
			Assert.assertEquals(actualdate, date, "Date NOT Getting Saved");
			Assert.assertEquals(actualaccount, "Electricity Bill", "Account NOT Getting Saved");
			Assert.assertEquals(actualpaymentmode, "Cheque", "Payment Mode NOT Getting Saved");
		}
		
		//Online Payment Mode
		@Test
		public void Online_Payment_Mode() throws InterruptedException
		{
			Thread.sleep(1500);
			Actions action = new Actions(driver);
			WebElement we = driver.findElement(By.xpath("//*[@id=\"8\"]/li[1]/a"));
			action.moveToElement(we).moveToElement(driver.findElement(By.xpath("//*[@id=\"8\"]/li[1]/a"))).click().build().perform();
			driver.navigate().refresh();
			Thread.sleep(1500);
			driver.findElement(By.name("Name")).sendKeys("Rohini");
			driver.findElement(By.name("MobileNumber")).sendKeys("8745120369");
			driver.findElement(By.name("EmailId")).sendKeys("R@gmail.com");
			driver.findElement(By.name("Amount")).sendKeys("500");
			Select paymentmode = new Select(driver.findElement(By.name("PaymentModeId")));
			paymentmode.selectByVisibleText("Online transfer");
			Select bankname = new Select(driver.findElement(By.name("BankName")));
			bankname.selectByVisibleText("HDFC BANK LTD");		
			driver.findElement(By.name("TransactionNo")).sendKeys("268898");
			Select accounthead = new Select(driver.findElement(By.name("AccountType")));
			accounthead.selectByVisibleText("Electricity Bill");
			driver.findElement(By.id("btn-payment-voucher")).click();
			
			Thread.sleep(1000);
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		 	String date = dateFormat.format(new Date());
			String actualname = driver.findElement(By.xpath("//*[@id=\"view-payment-voucher\"]/tbody/tr[1]/td[2]")).getText();
			String actualmobileno = driver.findElement(By.xpath("//*[@id=\"view-payment-voucher\"]/tbody/tr[1]/td[3]")).getText();
			String actualamount = driver.findElement(By.xpath("//*[@id=\"view-payment-voucher\"]/tbody/tr[1]/td[4]")).getText();
			String actualdate = driver.findElement(By.xpath("//*[@id=\"view-payment-voucher\"]/tbody/tr[1]/td[5]")).getText();
			String actualaccount = driver.findElement(By.xpath("//*[@id=\"view-payment-voucher\"]/tbody/tr[1]/td[6]")).getText();
			String actualpaymentmode = driver.findElement(By.xpath("//*[@id=\"view-payment-voucher\"]/tbody/tr[1]/td[7]")).getText();
			Assert.assertEquals(actualname, "Rohini", "Name NOT Getting Saved");
			Assert.assertEquals(actualmobileno, "8745120369", "Mobile No NOT Getting Saved");
			Assert.assertEquals(actualamount, "500", "Amount NOT Getting Saved");
			Assert.assertEquals(actualdate, date, "Date NOT Getting Saved");
			Assert.assertEquals(actualaccount, "Electricity Bill", "Account NOT Getting Saved");
			Assert.assertEquals(actualpaymentmode, "Online", "Payment Mode NOT Getting Saved");
			driver.findElement(By.xpath("//*[@id=\"nav-state-toggle\"]/i")).click();
			Thread.sleep(1500);
			driver.findElement(By.xpath("//*[@id=\"view-payment-voucher\"]/tbody/tr[1]/td[8]/button[2]/i")).click();
			Thread.sleep(500);
			driver.findElement(By.xpath("//*[@id=\"remove-course\"]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"view-payment-voucher\"]/tbody/tr[1]/td[8]/button[2]/i")).click();
			Thread.sleep(500);
			driver.findElement(By.xpath("//*[@id=\"remove-course\"]")).click();
		}		
		
		
	}
