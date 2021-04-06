package stepdefinitions;

import io.cucumber.java.Scenario;
import org.junit.After;
import org.junit.Before;
import utils.DriverFactory;

public class HookDef {


    @After
    public void afterhook(Scenario scenario){
        DriverFactory.getDriver().quit();

    }

    @Before
    public void beforehook(Scenario scenario){
        System.out.println("Scenario name: " + scenario.getName());
    }

}
