package LaSenza.Steps

import LaSenza.steps.UserSteps
import net.thucydides.core.annotations.Steps
import org.jbehave.core.annotations.*

class DifferentCheckoutSteps {

    @Steps
    UserSteps user

    @When("I pass checkout with <nameCart>, that has number <numberCart>, cart type <value> security code <securityCode>.")
    public void pass_checkout_with_different_carts(String nameCart, String numberCart, String securityCode, String value){
        user.enter_valid_data_on_checkout_page("testemail@mail.com", securityCode, nameCart, numberCart, value)
        user.click_button_confirm_and_pay()
        user.click_submit_button()

    }

    @Then("I get Thank You Page.")
    public void assert_on_thank_you_page(){
        user.assert_thank_you_page()
    }
}
