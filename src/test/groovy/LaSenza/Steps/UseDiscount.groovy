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

    @When("Click the Add Gift Card button shopping cart.")
    public void click_apply_gift_card() {
        user.click_apply_gift_card_shopping_cart()
    }

    @When("Click the Check Gift Card Status & Balance shopping cart.")
    public void click_check_gift_card() {
        user.click_check_gift_card_shopping_cart()
    }

    @Then("Appropriate error messaging Coupon code XXXXXXX is not valid. displays.")
    public void assert_error_message() {
        user.assert_error_message_shopping_cart()
    }

    @When("I enter data to shipping carriers.")
    public void enter_data_for_shipping() {
        user.enter_data_for_shipping_shopping_cart()
    }

    @When("Click on button Get a Quote.")
    public void click_button_get_quote() {
        user. click_button_get_quote()
    }

    @Then("Associated costs based upon the location information provided in the Estimate Shipping and Tax form.")
    public void assert_quotes_appeared() {
        user.assert_quotes_appeared()
    }

    @When("I select a shipping option and click the Update Total button.")
    public void select_shipping_and_update_total_shopping_cart() {
        user.select_shipping_and_update_total_shopping_cart()
    }

    @Then("Shipping and Sales Tax charges appear as separate lines in the order summary and the grand total is updated.")
    public void assert_total_updated_shopping_cart() {
        user.assert_total_updated_shopping_cart()
    }

    @When("I go to checkout page.")
    public void go_to_checkout_page() {
        user.go_to_checkout()
    }

    @Then("This information is remembered within the checkout form")
    public void assert_shipping_tax_quote_on_checkout() {
        user.assert_shipping_tax_quote_on_checkout()
    }
}
