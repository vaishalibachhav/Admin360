package com.mytest;


import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

	public class FeesManager extends Login
	{
		String nowreceving_pattern = "\\s*\\d*";
		String paymodemode_pattern = "[1-3]";
		String nextduedate_pattern = "([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))";
		String notes_pattern = "([a-zA-Z]*[a-zA-Z ]*[0-9]*[$&+,:;=?@#|'<>.^*()%!-]*)+(\\s)*";
		String paymentclear_pattern = "\\b(true|false)\\b";
		String feerefund_pattern = "\\s*\\d*";

	  @Test
	  public void Add_Admission() throws InterruptedException
	  {
		  //Course
		  driver.findElement(By.xpath("//*[@id=\"nav-state-toggle\"]/i")).click();
		  driver.findElement(By.xpath("//*[@id=\"2\"]/li[1]/a")).click();
		  driver.findElement(By.xpath("//*[@id=\"btn-new-course\"]")).click();
		  driver.findElement(By.name("CourseName")).sendKeys("DOT NET");
		  driver.findElement(By.id("txtcourseamount")).sendKeys("20000");
		  driver.findElement(By.xpath("//*[@id=\"btn-save-course\"]")).click();
		 
		 //Admission
		  Thread.sleep(1500);
		  driver.findElement(By.xpath("//*[@id=\"sidebar\"]/div/div[1]/ul[1]/li[2]/a")).click();
		  Thread.sleep(1500);
		  driver.findElement(By.xpath("//*[@id=\"4\"]/li[1]/a")).click();
	
		  driver.findElement(By.name("FirstName")).sendKeys("Akash");
		  driver.findElement(By.name("MiddleName")).sendKeys("Ashok");
		  driver.findElement(By.name("LastName")).sendKeys("Ahire");
		  driver.findElement(By.id("College")).sendKeys("KTHM");
		  driver.findElement(By.id("Qualification")).sendKeys("MCS");
		  driver.findElement(By.id("AddharNo")).sendKeys("8520147963012458");
		  driver.findElement(By.id("DateOfBirth")).sendKeys("01/09/1992");
		  Select drpgenderlistad = new Select(driver.findElement(By.name("Gender")));
		  drpgenderlistad.selectByVisibleText("Male");
		  driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/ul/li[2]/button")).click();
		  
		  driver.findElement(By.id("MobilePrimary")).sendKeys("8520147963");
		  driver.findElement(By.id("MobileSecondary")).sendKeys("9999999999");
		  driver.findElement(By.id("EmailPrimary")).sendKeys("akash@gmail.com");
		  driver.findElement(By.id("EmailSecondary")).sendKeys("akash11@gmail.com");
		  driver.findElement(By.name("CurrentAddress")).sendKeys("Flat no-03,Ganesh Appartment, Near Prasad Circle,Gangapur Road,Nashik");
		  driver.findElement(By.name("PermanentAddress")).sendKeys("Flat no-03,Ganesh Appartment, Near Prasad Circle,Gangapur Road,Nashik");
		  driver.findElement(By.id("PinCodeCurrentAddress")).sendKeys("422222");
		  driver.findElement(By.id("PinCodePermanentAddress")).sendKeys("422222");
		  Select documentnwadd = new Select(driver.findElement(By.id("Document-list")));
		  documentnwadd.selectByVisibleText("Addhar Card");
		  driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/ul/li[2]/button")).click();
		  
		  Select course = new Select(driver.findElement(By.name("course-list")));
		  course.selectByVisibleText("DOT NET");
		  driver.findElement(By.name("Discount")).sendKeys("10");
		  driver.findElement(By.xpath("//*[@id=\"nav-state-toggle\"]/i")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/ul/li[2]/button")).click();
		  driver.findElement(By.id("btn-save")).click();
		  
		  
	  }
		
	  //Now Receiving
	  @Test
	  public void Blank_Now_Receiving_Field() throws InterruptedException
	  {
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//*[@id=\"nav-state-toggle\"]/i")).click();
		  Actions action = new Actions(driver);
		  WebElement we = driver.findElement(By.xpath("//*[@id=\"5\"]/li/a"));
		  action.moveToElement(we).moveToElement(driver.findElement(By.xpath("//*[@id=\"5\"]/li/a"))).click().build().perform();
	
		  driver.findElement(By.xpath("//*[@id=\"view-fee-status\"]/tbody/tr/td[8]/button[1]/i")).click();
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//*[@id=\"btn-save-receipt\"]")).click();
		  String actual = driver.findElement(By.xpath("//*[@id=\"parsley-id-8\"]/li")).getText();
		  String expected = "This value is required.";
		  Assert.assertEquals(actual, expected, "Now Receiving Accepted Blank Field");
	  }
	  
	  @Test
	  public void Now_Receiving_contains_aplhabets() throws InterruptedException
	  {
		  driver.findElement(By.name("AmountPaid")).sendKeys("amount");
		  boolean nowreceving =driver.findElement(By.name("AmountPaid")).getAttribute("value").matches(nowreceving_pattern);
		  Assert.assertTrue(nowreceving, "Now Receiving field contain alphabets");
	  }
	  
	  @Test
	  public void Now_Receiving_contains_special_characters() throws InterruptedException
	  {
		  driver.findElement(By.name("AmountPaid")).clear();
		  driver.findElement(By.name("AmountPaid")).sendKeys("#@$^%&^&*&*");
		  boolean nowreceving =driver.findElement(By.name("AmountPaid")).getAttribute("value").matches(nowreceving_pattern);
		  Assert.assertTrue(nowreceving, "Now Receiving field contain alphabets");
	  }
	  
	  @Test
	  public void Now_Receiving_contains_whitespaces() throws InterruptedException
	  {
		  driver.findElement(By.name("AmountPaid")).clear();
		  driver.findElement(By.name("AmountPaid")).sendKeys("5666 56565");
		  boolean nowreceving =driver.findElement(By.name("AmountPaid")).getAttribute("value").matches(nowreceving_pattern);
		  Assert.assertTrue(nowreceving, "Now Receiving field contain alphabets");
	  }
	  
	  @Test
	  public void Now_Receiving_contains_whitespaces_at_begining() throws InterruptedException
	  {
		  driver.findElement(By.name("AmountPaid")).clear();
		  driver.findElement(By.name("AmountPaid")).sendKeys("  566565");
		  boolean nowreceving =driver.findElement(By.name("AmountPaid")).getAttribute("value").matches(nowreceving_pattern);
		  Assert.assertTrue(nowreceving, "Now Receiving field contain alphabets");
	  }
	  
	  @Test
	  public void Now_Receiving_contains_numbers() throws InterruptedException
	  {
		  driver.findElement(By.name("AmountPaid")).clear();
		  driver.findElement(By.name("AmountPaid")).sendKeys("2000");
		  boolean nowreceving =driver.findElement(By.name("AmountPaid")).getAttribute("value").matches(nowreceving_pattern);
		  Assert.assertTrue(nowreceving, "Now Receiving field contain alphabets");
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
	  
	  //Next due Date
	  @Test
		public void Blank_NextdueDate_functionality() throws InterruptedException
		{
		  String actual = driver.findElement(By.xpath("//*[@id=\"parsley-id-26\"]/li")).getText();
		  String expected = "This value is required.";
		  Assert.assertEquals(actual, expected, "Next due Date Accepted Blank Field");
		}
	  
	  @Test
		public void NextdueDate_functionality() throws InterruptedException
		{
			driver.findElement(By.name("NextDueDate")).sendKeys("10/10/2018");
			Thread.sleep(3000);
			boolean dateofbirth =driver.findElement(By.name("NextDueDate")).getAttribute("value").matches(nextduedate_pattern);
			Assert.assertTrue(dateofbirth, "Next due Date is NOT Getting Accepted");
		}
	  
	  //Notes
	  @Test
		public void Notes()
		{
			driver.findElement(By.name("Note")).sendKeys("2000 Paid");
			boolean notes =driver.findElement(By.name("Note")).getAttribute("value").matches(notes_pattern);
			Assert.assertTrue(notes, "Notes Field NOT Working");
		}
	  
	  //Payment Clear
	  @Test
	   public void Payment_Clear()
	   {
		  Select paymentclear = new Select(driver.findElement(By.name("PaymentClear")));
		  paymentclear.selectByVisibleText("No");
		  boolean drppaymentclear =driver.findElement(By.name("PaymentClear")).getAttribute("value").matches(paymentclear_pattern);
		  Assert.assertTrue(drppaymentclear, "Payment Clear Field NOT Working");
	   }
	  
	  //Save Changes
	  @Test
	  public void Save_Changes_button_functionality() throws InterruptedException
	  {
		  driver.findElement(By.name("save-receipt")).click();
		  Thread.sleep(2000);
		  String actual = driver.getCurrentUrl();
		  String expected = "https://app.admin360.in/01-02-view-fee-status.html?m=s&n=Akash%20Ashok%20Ahire";
		  Assert.assertEquals(actual, expected, "Save Changes button NOT Working");
	  }
	  
	//Fee Status
	  @Test
	  public void Fee_Payment_Fee_Status_functionality()
	  {
		  String actualstudentname = driver.findElement(By.xpath("//*[@id=\"view-fee-status\"]/tbody/tr/td[2]")).getText();
		  String actualtotalfees = driver.findElement(By.xpath("//*[@id=\"view-fee-status\"]/tbody/tr/td[3]")).getText();
		  String actualfeesdue = driver.findElement(By.xpath("//*[@id=\"view-fee-status\"]/tbody/tr/td[4]")).getText();
		  String actualtotalpaid = driver.findElement(By.xpath("//*[@id=\"view-fee-status\"]/tbody/tr/td[5]")).getText();
		  String actualduedate = driver.findElement(By.xpath("//*[@id=\"view-fee-status\"]/tbody/tr/td[6]")).getText();
		  String actualfeesrefund = driver.findElement(By.xpath("//*[@id=\"view-fee-status\"]/tbody/tr/td[7]")).getText();
		  Assert.assertEquals(actualstudentname, "Akash Ashok Ahire", "Student Name NOT Getting Saved");
		  Assert.assertEquals(actualtotalfees, "18000", "Total Fees NOT Getting Saved");
		  Assert.assertEquals(actualfeesdue, "16000", "Fees Due NOT Getting Saved");
		  Assert.assertEquals(actualtotalpaid, "2000", "Total Paid NOT Getting Saved");
		  Assert.assertEquals(actualduedate, "10/10/2018", "Due Date NOT Getting Saved");
		  Assert.assertEquals(actualfeesrefund, "NA", "Fees Refund NOT Getting Saved");
	  }
	  
	  //View Receipts
	  @Test
	  public void View_Receipts_functionality()
	  {
		  driver.findElement(By.xpath("//*[@id=\"view-fee-status\"]/tbody/tr/td[8]/button[2]/i")).click();
		  String actualamount = driver.findElement(By.xpath("//*[@id=\"view-fee-status\"]/tbody/tr/td[2]")).getText();
		  String actualdate = driver.findElement(By.xpath("//*[@id=\"view-fee-status\"]/tbody/tr/td[3]")).getText();
		  String actualreceipttype = driver.findElement(By.xpath("//*[@id=\"view-fee-status\"]/tbody/tr/td[4]")).getText();
		  Assert.assertEquals(actualamount, "2000", "Amount NOT getting saved");
		  SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		  String date = dateFormat.format(new Date());
		  Assert.assertEquals(actualdate, date, "Date NOT getting saved");
		  Assert.assertEquals(actualreceipttype, "Fee Payment Receipt", "Receipt Type NOT getting saved");
	  }
	  
	  
	  
	  //Update Fee Receipt
	  @Test
	  public void Update_Fee_Receipt() throws InterruptedException
	  {
		  driver.findElement(By.xpath("//*[@id=\"view-fee-status\"]/tbody/tr/td[5]/button[1]/i")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.id("txtNowPaying")).clear();
		  driver.findElement(By.id("txtNowPaying")).sendKeys("1000");
		  //driver.findElement(By.name("NextDueDate")).clear();
		  driver.findElement(By.name("NextDueDate")).sendKeys("10/13/2018");
		  driver.findElement(By.name("Note")).clear();
		  driver.findElement(By.name("Note")).sendKeys("1000 Paid");
		  Select paymentclear = new Select(driver.findElement(By.name("PaymentClear")));
		  paymentclear.selectByVisibleText("Yes");
		  driver.findElement(By.xpath("//*[@id=\"btn-update-receipt\"]")).click();
		  
		  Thread.sleep(2000);
		  String actualamount = driver.findElement(By.xpath("//*[@id=\"view-fee-status\"]/tbody/tr/td[2]")).getText();
		  String actualdate = driver.findElement(By.xpath("//*[@id=\"view-fee-status\"]/tbody/tr/td[3]")).getText();
		  String actualreceipttype = driver.findElement(By.xpath("//*[@id=\"view-fee-status\"]/tbody/tr/td[4]")).getText();
		  Assert.assertEquals(actualamount, "1000", "Amount NOT getting saved");
		  SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		  String date = dateFormat.format(new Date());
		  Assert.assertEquals(actualdate, date, "Date NOT getting saved");
		  Assert.assertEquals(actualreceipttype, "Fee Payment Receipt", "Receipt Type NOT getting saved");
	  }
	  
	/*  //Payment Mode (Cheque)
	  @Test
	  public void Cheque_Payment_Mode()
	  {
		  Actions action = new Actions(driver);
		  WebElement we = driver.findElement(By.xpath("//*[@id=\"5\"]/li/a"));
		  action.moveToElement(we).moveToElement(driver.findElement(By.xpath("//*[@id=\"5\"]/li/a"))).click().build().perform();
		  driver.findElement(By.xpath("//*[@id=\"view-fee-status\"]/tbody/tr/td[8]/button[1]/i")).click();
		  driver.findElement(By.name("AmountPaid")).sendKeys("2000");
		  driver.findElement(By.name("NextDueDate")).sendKeys("10/10/2018");
		  Select paymentmode = new Select(driver.findElement(By.name("PaymentModeId")));
		  paymentmode.selectByVisibleText("Cheque");
		  boolean drppaymentmode =driver.findElement(By.name("PaymentModeId")).getAttribute("value").matches(paymodemode_pattern);
		  Assert.assertTrue(drppaymentmode, "Payment Mode Field NOT Working");
		  driver.findElement(By.name("save-receipt")).click();
	  }*/
	  
	  //Fee Refund
	  @Test
	  public void Blank_Fee_Refund() throws InterruptedException
	  {
		  Actions action = new Actions(driver);
		  WebElement we = driver.findElement(By.xpath("//*[@id=\"5\"]/li/a"));
		  action.moveToElement(we).moveToElement(driver.findElement(By.xpath("//*[@id=\"5\"]/li/a"))).click().build().perform();
		  driver.findElement(By.xpath("//*[@id=\"view-fee-status\"]/tbody/tr/td[8]/button[3]/i")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//*[@id=\"btn-save-refund\"]")).click();
		  driver.findElement(By.xpath("//*[@id=\"btn-save-refund\"]")).click();
		  String actual = driver.findElement(By.xpath("//*[@id=\"parsley-id-2\"]/li")).getText();
		  String expected = "This value is required.";
		  Assert.assertEquals(actual, expected, "Fee Refund Accepted Blank Field");
	  }
	  
	  @Test
	  public void Fee_Refund_contains_aplhabets() throws InterruptedException
	  {
		  driver.findElement(By.name("AmountPaid")).sendKeys("amount");
		  boolean nowreceving =driver.findElement(By.name("AmountPaid")).getAttribute("value").matches(feerefund_pattern);
		  Assert.assertTrue(nowreceving, "Fee Refund field contain alphabets");
	  }
	  
	  @Test
	  public void Fee_Refund_contains_special_characters() throws InterruptedException
	  {
		  driver.findElement(By.name("AmountPaid")).clear();
		  driver.findElement(By.name("AmountPaid")).sendKeys("#@$^%&^&*&*");
		  boolean nowreceving =driver.findElement(By.name("AmountPaid")).getAttribute("value").matches(feerefund_pattern);
		  Assert.assertTrue(nowreceving, "Fee Refund field contain alphabets");
	  }
	  
	  @Test
	  public void Fee_Refund_contains_whitespaces() throws InterruptedException
	  {
		  driver.findElement(By.name("AmountPaid")).clear();
		  driver.findElement(By.name("AmountPaid")).sendKeys("5666 56565");
		  boolean nowreceving =driver.findElement(By.name("AmountPaid")).getAttribute("value").matches(feerefund_pattern);
		  Assert.assertTrue(nowreceving, "Fee Refund field contain alphabets");
	  }
	  
	  @Test
	  public void Fee_Refund_contains_whitespaces_at_begining() throws InterruptedException
	  {
		  driver.findElement(By.name("AmountPaid")).clear();
		  driver.findElement(By.name("AmountPaid")).sendKeys("  566565");
		  boolean nowreceving =driver.findElement(By.name("AmountPaid")).getAttribute("value").matches(feerefund_pattern);
		  Assert.assertTrue(nowreceving, "Fee Refund field contain alphabets");
	  }
	  
	  @Test
	  public void Fee_Refund_lessthan_Paid_Fees() throws InterruptedException
	  {
		  driver.findElement(By.name("AmountPaid")).clear();
		  driver.findElement(By.name("AmountPaid")).sendKeys("2000");
		  driver.findElement(By.xpath("//*[@id=\"btn-save-refund\"]")).click();
		  Thread.sleep(1000);
		  String actual = driver.findElement(By.xpath("//*[@id=\"parsley-id-2\"]/li[1]")).getText();
		  String expected = "Refund Amount should be less than or equal to paid fees";
		  Assert.assertEquals(actual, expected, "Refund Amount Accepted amount greater than paid fees");
	  }
	  
	  @Test
	  public void Fee_Refund_contains_numbers() throws InterruptedException
	  {
		  driver.findElement(By.name("AmountPaid")).clear();
		  driver.findElement(By.name("AmountPaid")).sendKeys("200");
		  boolean nowreceving =driver.findElement(By.name("AmountPaid")).getAttribute("value").matches(feerefund_pattern);
		  Assert.assertTrue(nowreceving, "Fee Refund field contain alphabets");
	  }
	  

	  //Payment Mode
	  @Test
	  public void Fee_Refund_Payment_Mode_Functionality()
	  {
		  Select paymentmode = new Select(driver.findElement(By.name("PaymentModeId")));
		  paymentmode.selectByVisibleText("Cash");
		  boolean drppaymentmode =driver.findElement(By.name("PaymentModeId")).getAttribute("value").matches(paymodemode_pattern);
		  Assert.assertTrue(drppaymentmode, "Payment Mode Field NOT Working");
		  
	  }
	  
	  //Notes
	  @Test
		public void Fee_Refund_Notes()
		{
			driver.findElement(By.name("Note")).sendKeys("2000 Refund");
			boolean notes =driver.findElement(By.name("Note")).getAttribute("value").matches(notes_pattern);
			Assert.assertTrue(notes, "Notes Field NOT Working");
		}
	  
	  //Payment Clear
	  @Test
	   public void Fee_Refund_Payment_Clear()
	   {
		  Select paymentclear = new Select(driver.findElement(By.name("PaymentClear")));
		  paymentclear.selectByVisibleText("No");
		  boolean drppaymentclear =driver.findElement(By.name("PaymentClear")).getAttribute("value").matches(paymentclear_pattern);
		  Assert.assertTrue(drppaymentclear, "Payment Clear Field NOT Working");
	   }
	  
	  //Save Changes
	  @Test
	  public void Fee_Refund_Save_Changes_button_functionality() throws InterruptedException
	  {
		  driver.findElement(By.xpath("//*[@id=\"btn-save-refund\"]")).click();
		  Thread.sleep(2000);
		  String actual = driver.getCurrentUrl();
		  String expected = "https://app.admin360.in/01-02-view-fee-status.html?m=s&n=Akash%20Ashok%20Ahire";
		  Assert.assertEquals(actual, expected, "Save Changes button NOT Working");
	  }
	  
	//Fee Status
	  @Test
	  public void Fee_Refund_Fee_Status_functionality()
	  {
		  String actualstudentname = driver.findElement(By.xpath("//*[@id=\"view-fee-status\"]/tbody/tr/td[2]")).getText();
		  String actualtotalfees = driver.findElement(By.xpath("//*[@id=\"view-fee-status\"]/tbody/tr/td[3]")).getText();
		  String actualfeesdue = driver.findElement(By.xpath("//*[@id=\"view-fee-status\"]/tbody/tr/td[4]")).getText();
		  String actualtotalpaid = driver.findElement(By.xpath("//*[@id=\"view-fee-status\"]/tbody/tr/td[5]")).getText();
		  String actualduedate = driver.findElement(By.xpath("//*[@id=\"view-fee-status\"]/tbody/tr/td[6]")).getText();
		  String actualfeesrefund = driver.findElement(By.xpath("//*[@id=\"view-fee-status\"]/tbody/tr/td[7]")).getText();
		  Assert.assertEquals(actualstudentname, "Akash Ashok Ahire", "Student Name NOT Getting Saved");
		  Assert.assertEquals(actualtotalfees, "18000", "Total Fees NOT Getting Saved");
		  Assert.assertEquals(actualfeesdue, "17000", "Fees Due NOT Getting Saved");
		  Assert.assertEquals(actualtotalpaid, "1000", "Total Paid NOT Getting Saved");
		  Assert.assertEquals(actualduedate, "10/10/2018", "Due Date NOT Getting Saved");
		  Assert.assertEquals(actualfeesrefund, "200", "Fees Refund NOT Getting Saved");
	  }
	  
	  
	  //View Receipts
	  @Test
	  public void Fee_Refund_View_Receipts()
	  {
		  driver.findElement(By.xpath("//*[@id=\"view-fee-status\"]/tbody/tr/td[8]/button[2]/i")).click();
		  String actualamount = driver.findElement(By.xpath("//*[@id=\"view-fee-status\"]/tbody/tr[2]/td[2]")).getText();
		  String actualdate = driver.findElement(By.xpath("//*[@id=\"view-fee-status\"]/tbody/tr[2]/td[3]")).getText();
		  String actualreceipttype = driver.findElement(By.xpath("//*[@id=\"view-fee-status\"]/tbody/tr[2]/td[4]/label")).getText();
		  Assert.assertEquals(actualamount, "200", "Amount NOT getting saved");
		  SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		  String date = dateFormat.format(new Date());
		  Assert.assertEquals(actualdate, date, "Date NOT getting saved");
		  Assert.assertEquals(actualreceipttype, "Refund Receipt", "Receipt Type NOT getting saved");
	  }
	  
	//Update Fee Receipt
	  @Test
	  public void Fee_Refund_Update_Fee_Receipt() throws InterruptedException
	  {
		  driver.findElement(By.xpath("//*[@id=\"view-fee-status\"]/tbody/tr[2]/td[5]/button[1]/i")).click();
		  Thread.sleep(3000);
		  driver.findElement(By.id("txtNowPaying")).clear();
		  driver.findElement(By.id("txtNowPaying")).sendKeys("300");
		  driver.findElement(By.name("Note")).clear();
		  driver.findElement(By.name("Note")).sendKeys("300 Refund");
		  Select paymentclear = new Select(driver.findElement(By.name("PaymentClear")));
		  paymentclear.selectByVisibleText("Yes");
		  driver.findElement(By.xpath("//*[@id=\"btn-update-receipt\"]")).click();
		  
		  Thread.sleep(2000);
		  String actualamount = driver.findElement(By.xpath("//*[@id=\"view-fee-status\"]/tbody/tr[2]/td[2]")).getText();
		  String actualdate = driver.findElement(By.xpath("//*[@id=\"view-fee-status\"]/tbody/tr/td[3]")).getText();
		  Assert.assertEquals(actualamount, "300", "Amount NOT getting saved");
		  SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		  String date = dateFormat.format(new Date());
		  Assert.assertEquals(actualdate, date, "Date NOT getting saved");
	  }
	  
	   //Delete
	  @Test
	  public void Delete_Fee_Receipt() throws InterruptedException
	  {
		  driver.findElement(By.xpath("//*[@id=\"view-fee-status\"]/tbody/tr[1]/td[5]/button[2]/i")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//*[@id=\"remove-receipt\"]")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//*[@id=\"view-fee-status\"]/tbody/tr[1]/td[5]/button[2]/i")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//*[@id=\"remove-receipt\"]")).click();
		  Thread.sleep(2000);
		  String actual = driver.findElement(By.xpath("//*[@id=\"view-fee-status\"]/tbody/tr/td")).getText();
		  String expected = "No data available in table";
		  Assert.assertEquals(actual, expected, "Fee Receipt NOT Getting Deleted");
	  }
	  
	  @Test 
	  public void Fee_Manager_Online()
	  {
		  
	  }
	  
	}
