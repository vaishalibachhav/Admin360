package com.test;

import java.util.concurrent.TimeUnit;

import javax.swing.Action;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
	
	private WebDriver driver;
	private String baseUrl;
	
	
	@Before
	  public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
	    driver = new ChromeDriver();
	    baseUrl = "http://admin360.in/";
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	  }

	@Test
	  public void testA() throws Exception
	{
		  //Login
		  driver.get(baseUrl);
		  WebDriverWait wait=new WebDriverWait(driver, 20);
		  //driver.findElement(By.linkText("Login")).click();
		  driver.navigate().to("http://admin360.in/login.html");
		  driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("techbona@gmail.com");
		  driver.findElement(By.xpath("//*[@id=\"btn-login\"]")).click();
		  Select drpbranchlist = new Select(driver.findElement(By.id("branch-list")));
		  drpbranchlist.selectByVisibleText("tech");
		  driver.findElement(By.id("password")).sendKeys("1234");
		  driver.findElement(By.id("btn-login")).click();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.findElement(By.xpath("//*[@id=\"nav-state-toggle\"]/i")).click();
		  
		  //Add Course
		  driver.findElement(By.xpath("//*[@id=\"sidebar\"]/div/div[1]/ul[1]/li[5]/a/i")).click();
		  driver.findElement(By.xpath("//*[@id=\"2\"]/li[1]/a")).click();
		  driver.findElement(By.name("CourseName")).sendKeys("DOT NET");
		  driver.findElement(By.name("CourseAmount")).sendKeys("25000");
		  WebElement element = driver.findElement(By.xpath("//*[@id=\"btn-save-course\"]"));
		  Actions actions = new Actions(driver);
		  actions.moveToElement(element).click().perform();
	  		  
		  //Update Course
		  driver.findElement(By.xpath("//*[@id=\"view-courses\"]/tbody/tr/td[3]/button[1]/i")).click();
		  driver.findElement(By.id("txtcoursename")).clear();
		  driver.findElement(By.id("txtcoursename")).sendKeys("JAVA COURSE");
		  driver.findElement(By.id("txtcourseamount")).clear();
		  driver.findElement(By.id("txtcourseamount")).sendKeys("27000");
		  driver.findElement(By.id("btn-update-course")).click();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  //Delete Course
		  driver.findElement(By.xpath("//*[@id=\"view-courses\"]/tbody/tr/td[3]/button[2]/i")).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"myModal18\"]/div/div/div[2]/button[1]"))).click();
		  
		  //Enquiry
		  //driver.findElement(By.xpath("//*[@id=\"3\"]/li[1]/a")).click();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  WebElement eqnew = driver.findElement(By.xpath("//*[@id=\"sidebar\"]/div/div[1]/ul[1]/li[3]/a/i"));
		  Actions act = new Actions(driver);
		  act.moveToElement(eqnew).click().perform();
		  WebElement eqnew1 = driver.findElement(By.xpath("//*[@id=\"3\"]/li[1]"));
		  Actions act1 = new Actions(driver);
		  act1.moveToElement(eqnew1).click().perform();
		  
		  driver.findElement(By.xpath("//*[@id=\"3\"]/li[1]")).click();
		  driver.findElement(By.name("FirstName")).sendKeys("Ashwini");
		  driver.findElement(By.id("MiddleName")).sendKeys("Ashok");
		  driver.findElement(By.name("LastName")).sendKeys("Patil");
		  driver.findElement(By.id("College")).sendKeys("K.K.Wagh");
		  driver.findElement(By.id("Qualification")).sendKeys("B.E");
		  driver.findElement(By.id("AddharNo")).sendKeys("789654123012");
		  driver.findElement(By.id("DateOfBirth")).sendKeys("12/11/1995");
		  Select drpgenderlist = new Select(driver.findElement(By.name("Gender")));
		  drpgenderlist.selectByVisibleText("Female");
		  WebElement eqnxt = driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/ul/li[2]/button"));
		  Actions actnxt = new Actions(driver);
		  actnxt.moveToElement(eqnxt).click().perform();
		  
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
		  Select drpdemolect = new Select(driver.findElement(By.id("ddlDemoLecture")));
		  drpdemolect.selectByVisibleText("Yes");
		  Select drpintlevel = new Select(driver.findElement(By.id("ddlInterestLevel")));
		  drpintlevel.selectByVisibleText("WARM");
		  driver.findElement(By.id("NextFollowUp")).sendKeys("12/11/2018");
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.findElement(By.name("FollowUpNote")).sendKeys("Interested for Testing Course");
		  driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/ul/li[2]/button")).click();
		  
		  Select drpleadsourse = new Select(driver.findElement(By.id("LeadSourceId")));
		  drpleadsourse.selectByVisibleText("Phone");
		  driver.findElement(By.id("ReferenceName")).sendKeys("Mr.Nitin");
		  driver.findElement(By.id("btn-save")).click();
		  
		  //Update Enquiry
		  driver.findElement(By.xpath("//*[@id=\"view-lead-status\"]/tbody/tr/td[7]/button[1]/i")).click();
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
		  driver.findElement(By.id("ReferenceName")).clear();
		  driver.findElement(By.id("ReferenceName")).sendKeys("Nikhil");
		  driver.findElement(By.id("btn-save")).click();
		  
		  //Follow Up
		  WebElement followup = driver.findElement(By.xpath("//*[@id=\"view-lead-status\"]/tbody/tr/td[7]/button[2]/i"));
		  Actions actfollow = new Actions(driver);
		  actfollow.moveToElement(followup).click().perform();
		  
		  driver.findElement(By.xpath("//*[@id=\"txtchequedate\"]")).sendKeys("05/10/2018");
		  Select followupmode = new Select(driver.findElement(By.name("FollowUpModeId")));
		  followupmode.selectByVisibleText("Email");
		  driver.findElement(By.id("elastic-textarea")).sendKeys("Testing");
		  driver.findElement(By.id("btn-save")).click();
		  
		  //New Admission(+)
		  driver.findElement(By.xpath("//*[@id=\"view-lead-status\"]/tbody/tr/td[7]/button[4]/i")).click();
		  driver.findElement(By.xpath("//*[@id=\"nav-state-toggle\"]/i")).click();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"wizard\"]/div[2]/ul/li[2]/button"))).click();
		  
		  //driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/ul/li[2]/button")).click();
	      
		  Select document = new Select(driver.findElement(By.id("Document-list")));
		  document.selectByVisibleText("Addhar Card");
		  driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/ul/li[2]/button")).click();
		
		  Select course = new Select(driver.findElement(By.id("course-list")));
		  course.selectByVisibleText("JAVA COURSE");
		  driver.findElement(By.name("Discount")).sendKeys("10");
		  driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/ul/li[2]/button")).click();
		  driver.findElement(By.xpath("//*[@id=\"btn-save\"]")).click();
		  
		  //New Admission
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"nav-state-toggle\"]"))).click();
		  driver.findElement(By.xpath("//*[@id=\"4\"]/li[1]/a")).click();
		  
		  driver.findElement(By.name("FirstName")).sendKeys("Akash");
		  driver.findElement(By.name("MiddleName")).sendKeys("Ashok");
		  driver.findElement(By.name("LastName")).sendKeys("Ahire");
		  driver.findElement(By.id("College")).sendKeys("KTHM");
		  driver.findElement(By.id("Qualification")).sendKeys("MCS");
		  driver.findElement(By.id("AddharNo")).sendKeys("8520147963012458");
		  driver.findElement(By.id("DateOfBirth")).sendKeys("01/21/1992");
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
		  
		  
		  
	}
}
