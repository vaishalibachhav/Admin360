package com.runnerclass;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


/*@RunWith(Cucumber.class)*/

@CucumberOptions(

      features="src/test/java/com/feature/login.feature",

      format={"pretty","html:target/Reports"},
      
      glue={"com.stepdefs"}

      )

public class RunnerClass extends AbstractTestNGCucumberTests
{

}