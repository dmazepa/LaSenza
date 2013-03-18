package LaSenza.Steps

import LaSenza.steps.CustomerSteps
import LaSenza.steps.UserSteps
import net.thucydides.core.annotations.Steps
import org.jbehave.core.annotations.Given
import org.jbehave.core.annotations.Then
import org.jbehave.core.annotations.UsingEmbedder
import org.jbehave.core.annotations.When
import org.jbehave.core.embedder.Embedder

@UsingEmbedder(embedder = Embedder.class, generateViewAfterStories = true, ignoreFailureInStories = true, ignoreFailureInView = true, verboseFailures = true,
storyTimeoutInSecs = 600L, threads = 2, metaFilters = "-skip")

class SecondStepSteps {

    @Steps
    UserSteps user

    @Steps
    CustomerSteps customer

    @Given("I am on second step of checkout process with valid information.")
    public void on_second_step_of_checkout() {
        user.open_second_step_of_checkout()
    }

    @Given("I am on second step of checkout process with invalid information.")
    public void on_second_step_of_checkout_with_wrong_inf() {
        user.log_out_if_logged_in()
        user.open_second_step_of_checkout_with_invalid_data()
    }

    @Given("I am on second step of checkout process with information, that I want to change.")
    public void on_second_step_of_checkout_with_wrong_inf_change() {
        user.open_second_step_of_checkout()
    }

    @When("I click <element> link <counter> Edit.")
    public void click_on_edit_link(String element, String counter) {
        user.click_on_edit_link(element, counter)
    }

    @Then("I redirects to the first step of checkout.")
    public void assert_on_checkout_page() {
        user.assert_on_checkout_page()
    }

    @When("I click Submit button.")
    public void click_submit_button() {
        user.click_submit_button()
    }

    @Then("I get order confirmation page.")
    public void assert_thank_you_page() {
        user.assert_thank_you_page()
    }

    @Then("Returns appropriate message.")
    public void assert_error_message() {
        user.assert_error_message_wrong_payment()
    }

}
