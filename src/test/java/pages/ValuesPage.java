package pages;

import org.apache.commons.validator.routines.BigDecimalValidator;
import org.apache.commons.validator.routines.CurrencyValidator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utils.DriverFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ValuesPage {
//
    @FindBy(how = How.XPATH, using = "//input[contains(@id, 'text_val')]")
    private WebElement rightSideValues;

    @FindBy(how = How.XPATH, using = "//input[contains(@id, 'text_total_val')]")
    private WebElement totalsum;


    public WebDriver driver = null;

    public ValuesPage(){
        driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void verifyValuesOnPage(){
        List<String> values = new ArrayList<>();
        for(WebElement val : driver.findElements(By.xpath("//input[contains(@id, 'text_val')]"))){

            Assert.assertTrue("Right Side Values are not present on the page", val.isDisplayed());

        }
        Assert.assertTrue("total count is not present on the page", totalsum.isDisplayed());
    }

    public List<String> addValuesOnPage(){
        List<String> values = new ArrayList<>();
        for(WebElement val : driver.findElements(By.xpath("//input[contains(@id, 'text_val')]"))){

            values.add(val.getText().replaceAll("[$,]", "").trim());

        }
        return values;
    }



    public void verifyvaluesGreaterThan0(int expval){
        for(String val : addValuesOnPage()){
            Assert.assertTrue("value is not greater than 0", Double.parseDouble(val)>expval);
        }
    }

    public void verifyTotalbalance(){
        double sum = 0;
        for(String val : addValuesOnPage()){
            sum = sum + Double.parseDouble(val);
        }
        Assert.assertTrue("total balance is not matching", sum==Double.parseDouble(totalsum.getText().replaceAll("[$,]", "").trim()));
    }

    public void validateCurrency(){
        BigDecimalValidator validator = CurrencyValidator.getInstance();
        for(String val : addValuesOnPage()){
            BigDecimal amount = validator.validate(val, Locale.US);
            if(amount==null){
                System.out.println("Invalid currency");
            }else{
                System.out.println("Valid currency");
            }
        }

    }


}
