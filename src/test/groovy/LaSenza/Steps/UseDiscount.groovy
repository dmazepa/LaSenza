package LaSenza.Steps

import LaSenza.steps.AdminPanelSteps
import LaSenza.steps.UserSteps
import net.thucydides.core.annotations.Steps
import org.jbehave.core.annotations.*

class UseDiscount {

    @Steps
    AdminPanelSteps admin

    @Steps
    UserSteps user

    @When("Click the Sign Up link.")
    public void click_sign_up_link_shopping_cart() {
        user.click_sign_up_link_shopping_cart()
    }

    @Then("It sends users to the Prestige Registration page.")
    public void assert_on_prestige_registration_page() {
        user.assert_on_prestige_registration_page()
    }

    @When("I Enter a valid coupon code shopping cart.")
    public void enter_valid_couponshopping_cart() {
        admin.create_coupon_code_if_not_exist()
        user.open_shopping_cart()
        user.enter_coupon_shopping_cart("12345")
    }

    @When("I Enter a invalid coupon code shopping_cart.")
    public void enter_invalid_couponshopping_cart() {
        user.open_shopping_cart()
        user.enter_coupon_shopping_cart("123456")
    }

    @When("Click the Apply Coupon button shopping cart.")
    public void click_apply_coupon() {
        user.click_apply_coupon_shooping_cart()
    }

    @Then("Appropriate error messaging Coupon code XXXXXXX is not valid. displays.")
    public void assert_error_message() {
        user.click_apply_coupon_shooping_cart()
    }
}
