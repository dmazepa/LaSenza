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

    @When("I click Submit button.")
    public void click_submit_button(){
        user.click_submit_button()
    }

    @Then("I get order confirmation page.")
    public void assert_thank_you_page(){
        user.assert_thank_you_page()
    }
}
