package gmailLogin.GmailTesting;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.Given;

import cucumber.api.java.en.Then;

public class stepDefinition {

    public static WebDriver obj=null;

    @Given("^url opened$")

   public void url_opened() {

    	System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		 obj = new ChromeDriver();

      obj.manage().window().maximize();

      obj.get("http://admin360.in/");

   }



   @Then("^click Login$")

   public void click_Login() throws InterruptedException {

      obj.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div[1]/ul/li[1]/a")).click();
      Thread.sleep(2000);

   }

   @Then("^enter user id and click continue$")

   public void enter_user_id_and_click_continue() throws InterruptedException {

      obj.findElement(By.id("username")).sendKeys("vaishali");

      obj.findElement(By.id("btn-login")).click();

      Thread.sleep(2000);

   }

   
   @Then("^enter password$")

   public void enter_password() {

      obj.findElement(By.id("password")).sendKeys("vaishali@1");

   }



   @Then("^click login$")

   public void click_login() throws InterruptedException {

	  obj.findElement(By.id("btn-login")).click();

      Thread.sleep(6000);

   }



   @Then("^Close browser$")

   public void close_browser() {

     // obj.quit();

   }

}