package LaSenza.Steps

import LaSenza.steps.UserSteps
import net.thucydides.core.annotations.Steps
import org.jbehave.core.annotations.Then
import org.jbehave.core.annotations.When

class DifferentCheckoutSteps {

    @Steps
    UserSteps user

    @When("I pass checkout with <nameCart>, that has number <numberCart>, cart type <value> security code <securityCode>.")
    public void pass_checkout_with_different_carts(String nameCart, String numberCart, String securityCode, String value) {
        user.enter_valid_data_on_checkout_page("testemail@mail.com", securityCode, nameCart, numberCart, value, "Test City", "11111", "United States", "California")
        user.click_button_confirm_and_pay()
        user.click_submit_button()
    }

    @Then("I get Thank You Page.")
    public void assert_on_thank_you_page() {
        user.assert_thank_you_page()
    }

    @When("I pass checkout with via PayPal.")
    public void pass_checkout_via_pay_pal() {
        user.login_to_pay_pal()
        user.go_to_checkout()
        user.enter_valid_billing_data("test1@speroteck.com", "Sacramento", "94203", "United States", "California")
        user.check_pay_pal_method()
        user.check_shipment()
        user.click_button_confirm_and_pay()
        user.click_submit_button()
        user.pass_pay_pall_process()
    }

}
