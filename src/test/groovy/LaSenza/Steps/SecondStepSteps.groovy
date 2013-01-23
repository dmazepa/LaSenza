package LaSenza.Steps

import org.jbehave.core.annotations.*
import net.thucydides.core.annotations.Steps
import LaSenza.steps.UserSteps

class SecondStepSteps {

    @Steps
    UserSteps user

    @Given("I am on second step of checkout process with valid information.")
    public void on_second_step_of_checkout(){
        user.open_second_step_of_checkout()
    }

    @Given("I am on second step of checkout process with invalid information.")
    public void on_second_step_of_checkout_with_wrong_inf(){
        user.open_second_step_of_checkout_with_invalid_data()
    }

    @Given("I am on second step of checkout process with information, that I want to change.")
    public void on_second_step_of_checkout_with_wrong_inf_change(){
        user.go_to_checkout()
        user.enter_payment_inf("111")
        user.click_button_confirm_and_pay_via_javascript()
    }

    @When("I click <element> link <counter> Edit.")
    public void click_on_edit_link(String element, String counter){
        user.click_on_edit_link(element, counter)
    }

    @Then("I redirects to the first step of checkout.")
    public void assert_on_checkout_page(){
        user.assert_on_checkout_page()
    }

    @When("I click Submit button.")
    public void click_submit_button(){
        user.click_submit_button()
    }

    @Then("I get order confirmation page.")
    public void assert_thank_you_page(){
        user.assert_thank_you_page()
    }

    @Then("Returns appropriate message.")
    public void assert_error_message(){
        user.assert_error_message_wrong_payment()
    }

}
