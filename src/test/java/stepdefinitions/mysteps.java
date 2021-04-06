package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.Login;
import pages.ValuesPage;

import java.util.List;

public class mysteps {

    Login login = new Login();
    ValuesPage valuesPage = new ValuesPage();

    @Given("I visit a website as a guest user")
    public void i_visit_a_website_as_a_guest_user() {
        System.out.println("printing inside stepdef.............");
        login.launchApplication();
    }

    @Then("I verify the right count of values appear on the screen")
    public void i_verify_the_right_count_of_values_appear_on_the_screen() {
        valuesPage.verifyValuesOnPage();
    }
    @Then("I verify the values on the screen are greater than {int}")
    public void i_verify_the_values_on_the_screen_are_greater_than(Integer val) {
        valuesPage.verifyvaluesGreaterThan0(val);
    }
    @Then("I verify the total balance is correct based on the values listed on the screen")
    public void i_verify_the_total_balance_is_correct_based_on_the_values_listed_on_the_screen() {
        valuesPage.verifyTotalbalance();
    }
    @Then("I verify the values are formatted as currencies")
    public void i_verify_the_values_are_formatted_as_currencies() {
        valuesPage.validateCurrency();
    }
    @Then("I verify the total balance matches the sum of the values")
    public void i_verify_the_total_balance_matches_the_sum_of_the_values() {
        valuesPage.verifyTotalbalance();
    }

    @When("I navigate to {string} page")
    public void iNavigateToPage(String pageName) {
        login.clickPageLink(pageName);
    }
}
