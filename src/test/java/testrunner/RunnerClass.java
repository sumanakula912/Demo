package testrunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
         glue = {"stepdefinitions"},
        plugin = {"pretty", "html:target/cucumber-parallel/cucumber-html-reports.html"},
        tags = "@Test123",
        monochrome = true)

public class RunnerClass {

    @BeforeClass
    public static void setProperties(){
        System.setProperty("Browser", "Chrome");


    }
}
