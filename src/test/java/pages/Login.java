package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utils.DriverFactory;

import java.util.concurrent.TimeUnit;

public class Login {

    public WebDriver driver = null;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'values')]")
    private WebElement valuesPageLink;

    public Login(){
        driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void launchApplication(){
        driver.get("https://www.exercise1.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void clickPageLink(String pageName){
        if(pageName.equalsIgnoreCase("Values")) {
            valuesPageLink.click();
        }
    }

}
