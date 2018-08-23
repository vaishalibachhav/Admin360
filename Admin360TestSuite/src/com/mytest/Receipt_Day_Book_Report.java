package com.mytest;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.Assert;

	public class Receipt_Day_Book_Report extends Login
	{
		
		@Test
		public void Add_Account_Head()
		{
			driver.findElement(By.xpath("//*[@id=\"nav-state-toggle\"]/i")).click();
		  	driver.findElement(By.xpath("//*[@id=\"2\"]/li[2]/a")).click();
		  	driver.findElement(By.xpath("//*[@id=\"btn-new-course\"]")).click();
			driver.findElement(By.name("AccountTitle")).sendKeys("Java Seminar");
			Select drpaccunttype = new Select(driver.findElement(By.id("ddlIsCredit")));
			drpaccunttype.selectByVisibleText("Credit");
			driver.findElement(By.id("btn-save-account-type")).click();
		}
		
		//Online Payment Mode
		@Test
		public void Cash_Payment_Mode() throws InterruptedException
		{
			Thread.sleep(1500);
			Actions action = new Actions(driver);
			WebElement we = driver.findElement(By.xpath("//*[@id=\"7\"]/li[1]/a"));
			action.moveToElement(we).moveToElement(driver.findElement(By.xpath("//*[@id=\"7\"]/li[1]/a"))).click().build().perform();
			Thread.sleep(1500);
			driver.findElement(By.name("Name")).sendKeys("Pooja");
			driver.findElement(By.name("MobileNumber")).sendKeys("8745120369");
			driver.findElement(By.name("EmailId")).sendKeys("pooja@gmail.com");
			driver.findElement(By.name("Amount")).sendKeys("500");
			Select paymentmode = new Select(driver.findElement(By.name("PaymentModeId")));
			paymentmode.selectByVisibleText("Cash");
			Select accounthead = new Select(driver.findElement(By.name("AccountType")));
			accounthead.selectByVisibleText("Java Seminar");
			driver.findElement(By.id("btn-payment-voucher")).click();
			
			Thread.sleep(1500);
			String voucherno = driver.findElement(By.xpath("//*[@id=\"view-payment-voucher\"]/tbody/tr[1]/td[1]")).getText();
			
			Thread.sleep(1000);
			Actions action2 = new Actions(driver);
			WebElement w2 = driver.findElement(By.xpath("//*[@id=\"9\"]/li[9]/a"));
			action2.moveToElement(w2).moveToElement(driver.findElement(By.xpath("//*[@id=\"9\"]/li[9]/a"))).click().build().perform();
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		 	String date = dateFormat.format(new Date());
		 	String actualtransactiondate = driver.findElement(By.xpath("//*[@id=\"view-account-transaction\"]/tbody/tr[1]/td[1]")).getText();
			String actualtransactiontype = driver.findElement(By.xpath("//*[@id=\"view-account-transaction\"]/tbody/tr[1]/td[2]")).getText();
			String actualtransactionfrom = driver.findElement(By.xpath("//*[@id=\"view-account-transaction\"]/tbody/tr[1]/td[3]")).getText();
			String actualtransactionnote = driver.findElement(By.xpath("//*[@id=\"view-account-transaction\"]/tbody/tr[1]/td[4]")).getText();
			String actualdaybookamount = driver.findElement(By.xpath("//*[@id=\"view-account-transaction\"]/tbody/tr[1]/td[5]")).getText();
			Assert.assertEquals(actualtransactiondate, date, "Transaction Date NOT Getting Saved");
			Assert.assertEquals(actualtransactiontype, "Credit", "Transaction Type NOT Getting Saved");
			Assert.assertEquals(actualtransactionfrom, "Receipt Voucher", "Transaction From NOT Getting Saved");
			Assert.assertEquals(actualtransactionnote, "Cash payment made against voucher no. "+voucherno, "Transaction Note NOT Getting Saved");
			Assert.assertEquals(actualdaybookamount, "500", "Transaction Amount NOT Getting Saved");
		}		
		
		//Cheque Payment Mode
		@Test
		public void Cheque_Payment_Mode() throws InterruptedException
		{
			Thread.sleep(1500);
			Actions action = new Actions(driver);
			WebElement we = driver.findElement(By.xpath("//*[@id=\"7\"]/li[1]/a"));
			action.moveToElement(we).moveToElement(driver.findElement(By.xpath("//*[@id=\"7\"]/li[1]/a"))).click().build().perform();
			Thread.sleep(1500);
			driver.findElement(By.name("Name")).sendKeys("Pooja");
			driver.findElement(By.name("MobileNumber")).sendKeys("8745120369");
			driver.findElement(By.name("EmailId")).sendKeys("pooja@gmail.com");
			driver.findElement(By.name("Amount")).sendKeys("500");
			Select paymentmode = new Select(driver.findElement(By.name("PaymentModeId")));
			paymentmode.selectByVisibleText("Cheque");
			Select bankname = new Select(driver.findElement(By.name("BankName")));
			bankname.selectByVisibleText("HDFC BANK LTD");
			driver.findElement(By.name("ChequeNo")).sendKeys("655963");
			driver.findElement(By.name("ChequeDate")).sendKeys("10/12/2018");
			driver.findElement(By.name("IfscCode")).sendKeys("HDFC000268898");
			Select accounthead = new Select(driver.findElement(By.name("AccountType")));
			accounthead.selectByVisibleText("Java Seminar");
			driver.findElement(By.id("btn-payment-voucher")).click();
			
			Thread.sleep(1000);
			String voucherno = driver.findElement(By.xpath("//*[@id=\"view-payment-voucher\"]/tbody/tr[1]/td[1]")).getText();
			System.out.println(voucherno);  
			
			Thread.sleep(2000);
			Actions action1 = new Actions(driver);
			WebElement w = driver.findElement(By.xpath("//*[@id=\"6\"]/li/a"));
			action1.moveToElement(w).moveToElement(driver.findElement(By.xpath("//*[@id=\"6\"]/li/a"))).click().build().perform();
			Thread.sleep(2000);
			String actualchequeno = driver.findElement(By.xpath("//*[@id=\"view-cheque-status\"]/tbody/tr/td[1]")).getText();
			String actualchequedate = driver.findElement(By.xpath("//*[@id=\"view-cheque-status\"]/tbody/tr/td[2]")).getText();
			String actualamount = driver.findElement(By.xpath("//*[@id=\"view-cheque-status\"]/tbody/tr/td[3]")).getText();
			String actualbank = driver.findElement(By.xpath("//*[@id=\"view-cheque-status\"]/tbody/tr/td[4]")).getText();
			String actualtype = driver.findElement(By.xpath("//*[@id=\"view-cheque-status\"]/tbody/tr/td[5]")).getText();
			String actualissuedfrom = driver.findElement(By.xpath("//*[@id=\"view-cheque-status\"]/tbody/tr/td[6]")).getText();
			Assert.assertEquals(actualchequeno, "655963", "Cheque No NOT Getting Saved");
			Assert.assertEquals(actualchequedate, "10/12/2018", "Cheque Date NOT Getting Saved");
			Assert.assertEquals(actualamount, "500", "Cheque Amount NOT Getting Saved");
			Assert.assertEquals(actualbank, "HDFC BANK LTD", "Bank NOT Getting Saved");
			Assert.assertEquals(actualtype, "Credit", "Cheque Type NOT Getting Saved");
			Assert.assertEquals(actualissuedfrom, "Voucher Module", "Issued From NOT Getting Saved");
			
			driver.findElement(By.xpath("//*[@id=\"view-cheque-status\"]/tbody/tr/td[7]/button/i")).click();
			Select chequestatus = new Select(driver.findElement(By.name("ChequeStatus")));
			chequestatus.selectByVisibleText("Clear");
			Actions action2 = new Actions(driver);
			WebElement w1 = driver.findElement(By.xpath("//*[@id=\"remove-course\"]"));
			action2.moveToElement(w1).moveToElement(driver.findElement(By.xpath("//*[@id=\"remove-course\"]"))).click().build().perform();
			driver.findElement(By.xpath("//*[@id=\"remove-course\"]")).click();
			
			Thread.sleep(1500);
			String actual = driver.findElement(By.xpath("//*[@id=\"view-cheque-status\"]/tbody/tr/td")).getText();
			Assert.assertEquals(actual, "No data available in table", "Cheque Status NOt Getting Deleted");
			
			Thread.sleep(1000);
			Actions action3 = new Actions(driver);
			WebElement w2 = driver.findElement(By.xpath("//*[@id=\"9\"]/li[9]/a"));
			action3.moveToElement(w2).moveToElement(driver.findElement(By.xpath("//*[@id=\"9\"]/li[9]/a"))).click().build().perform();
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		 	String date = dateFormat.format(new Date());
		 	String actualtransactiondate = driver.findElement(By.xpath("//*[@id=\"view-account-transaction\"]/tbody/tr[1]/td[1]")).getText();
			String actualtransactiontype = driver.findElement(By.xpath("//*[@id=\"view-account-transaction\"]/tbody/tr[1]/td[2]")).getText();
			String actualtransactionfrom = driver.findElement(By.xpath("//*[@id=\"view-account-transaction\"]/tbody/tr[1]/td[3]")).getText();
			String actualtransactionnote = driver.findElement(By.xpath("//*[@id=\"view-account-transaction\"]/tbody/tr[1]/td[4]")).getText();
			String actualdaybookamount = driver.findElement(By.xpath("//*[@id=\"view-account-transaction\"]/tbody/tr[1]/td[5]")).getText();
			Assert.assertEquals(actualtransactiondate, date, "Transaction Date NOT Getting Saved");
			Assert.assertEquals(actualtransactiontype, "Credit", "Transaction Type NOT Getting Saved");
			Assert.assertEquals(actualtransactionfrom, "Fee Module", "Transaction From NOT Getting Saved");
			Assert.assertEquals(actualtransactionnote, "Cheque cleared against receipt voucher no. "+voucherno, "Transaction Note NOT Getting Saved");
			Assert.assertEquals(actualdaybookamount, "500", "Transaction Amount NOT Getting Saved");
		
		}
			
		//Online Payment Mode
		@Test
		public void Online_Payment_Mode() throws InterruptedException
		{
			Thread.sleep(1500);
			Actions action = new Actions(driver);
			WebElement we = driver.findElement(By.xpath("//*[@id=\"7\"]/li[1]/a"));
			action.moveToElement(we).moveToElement(driver.findElement(By.xpath("//*[@id=\"7\"]/li[1]/a"))).click().build().perform();
			Thread.sleep(1500);
			driver.findElement(By.name("Name")).sendKeys("Pooja");
			driver.findElement(By.name("MobileNumber")).sendKeys("8745120369");
			driver.findElement(By.name("EmailId")).sendKeys("pooja@gmail.com");
			driver.findElement(By.name("Amount")).sendKeys("500");
			Select paymentmode = new Select(driver.findElement(By.name("PaymentModeId")));
			paymentmode.selectByVisibleText("Online transfer");
			Select bankname = new Select(driver.findElement(By.name("BankName")));
			bankname.selectByVisibleText("HDFC BANK LTD");		
			driver.findElement(By.name("TransactionNo")).sendKeys("268898");
			Select accounthead = new Select(driver.findElement(By.name("AccountType")));
			accounthead.selectByVisibleText("Java Seminar");
			driver.findElement(By.id("btn-payment-voucher")).click();
			
			Thread.sleep(1500);
			String voucherno = driver.findElement(By.xpath("//*[@id=\"view-payment-voucher\"]/tbody/tr[1]/td[1]")).getText();
			
			Thread.sleep(1000);
			Actions action2 = new Actions(driver);
			WebElement w2 = driver.findElement(By.xpath("//*[@id=\"9\"]/li[9]/a"));
			action2.moveToElement(w2).moveToElement(driver.findElement(By.xpath("//*[@id=\"9\"]/li[9]/a"))).click().build().perform();
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		 	String date = dateFormat.format(new Date());
		 	String actualtransactiondate = driver.findElement(By.xpath("//*[@id=\"view-account-transaction\"]/tbody/tr[1]/td[1]")).getText();
			String actualtransactiontype = driver.findElement(By.xpath("//*[@id=\"view-account-transaction\"]/tbody/tr[1]/td[2]")).getText();
			String actualtransactionfrom = driver.findElement(By.xpath("//*[@id=\"view-account-transaction\"]/tbody/tr[1]/td[3]")).getText();
			String actualtransactionnote = driver.findElement(By.xpath("//*[@id=\"view-account-transaction\"]/tbody/tr[1]/td[4]")).getText();
			String actualdaybookamount = driver.findElement(By.xpath("//*[@id=\"view-account-transaction\"]/tbody/tr[1]/td[5]")).getText();
			Assert.assertEquals(actualtransactiondate, date, "Transaction Date NOT Getting Saved");
			Assert.assertEquals(actualtransactiontype, "Credit", "Transaction Type NOT Getting Saved");
			Assert.assertEquals(actualtransactionfrom, "Receipt Voucher", "Transaction From NOT Getting Saved");
			Assert.assertEquals(actualtransactionnote, "Online trnx received against fee receipt no. "+voucherno, "Transaction Note NOT Getting Saved");
			Assert.assertEquals(actualdaybookamount, "500", "Transaction Amount NOT Getting Saved");
		}		
	}
