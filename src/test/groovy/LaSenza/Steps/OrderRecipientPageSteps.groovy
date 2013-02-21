package LaSenza.Steps

import LaSenza.steps.UserSteps
import net.thucydides.core.annotations.Steps
import org.jbehave.core.annotations.Given
import org.jbehave.core.annotations.Then

class OrderRecipientPageSteps {

    @Steps
    UserSteps user

    @Given("I am on Order Recipient page.")
    public void open_thank_you_page() {
        user.open_second_step_of_checkout()
        user.click_button_confirm_and_pay_via_javascript()
        user.click_submit_button()
    }

    @Then("I can see appropriate information about order.")
    public void assert_correct_information_on_thank_you_page() {
        user.assert_correct_information_on_thank_you_page()
    }

    @Then("I can return to Home page.")
    public void assert_return_to_home_page() {
        user.assert_return_to_home_page()
    }

}
