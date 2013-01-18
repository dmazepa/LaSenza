package LaSenza.Steps

import LaSenza.steps.CustomerSteps
import LaSenza.steps.UserSteps
import net.thucydides.core.annotations.Steps
import org.jbehave.core.annotations.*

class EditInfSteps {

    @Steps
    UserSteps user

    @Steps
    CustomerSteps customer

    @Given("I am on checkout page as User.")
    public void on_checkout_page_as_user(){
        user.open_first_step_of_checkout()
    }

    @When("I click on link Already Registered")
    public void click_on_link_already_register(){
        user.click_on_link_already_register()
    }

    @When("I check check-box Ship to My Billing Address.")
    public void fill_fields_billing_and_uncheck_checkbox_use_billing_for_shipping(){
        user.enter_valid_data_on_checkout_page()
        user.uncheck_checkbox_use_billing_for_shipping()
    }

    @When("Enter valid data.")
    public void type_data_to_login(){
        user.type_data_to_login("test1@speroteck.com", "testthis")
    }

    @When("Click login button.")
    public void click_login_button_pop_up(){
        user.click_login_button_pop_up()
    }

    @Then("I become logged in without leaving the page.")
    public void assert_logged_in_and_on_checkout_page(){
        customer.assert_logged_in()
    }

    @Then("It copies the data from the Billing Address form fields into the Shipping address form fields.")
    public void assert_data_copied(){
        user.assert_data_copied_from_billing_to_shipping()
    }
}
