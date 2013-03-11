package LaSenza.Steps

import LaSenza.steps.AdminPanelSteps
import LaSenza.steps.UserSteps
import net.thucydides.core.annotations.Steps
import org.jbehave.core.annotations.Given
import org.jbehave.core.annotations.Pending
import org.jbehave.core.annotations.Then
import org.jbehave.core.annotations.When

class UseDiscountCheckoutSteps {

    @Steps
    AdminPanelSteps admin

    @Steps
    UserSteps user



    @When("Enter a Prestige Card number into the field.")
    public void enter_valid_prestige_cart() {
        user.enter_prestige_cart()
    }

    @When("Click Apply.")
    public void click_apply() {
        user.click_apply_prestige_card()
    }

    @Then("The discount will be reflected in the Order Summary box.")
    public void discount_reflect_to_order_summary() {
        user.assert_discount_prestige_cart()
    }

    @When("I Enter a valid coupon code.")
    public void enter_valid_coupon() {
        admin.create_coupon_code_if_not_exist()
        user.open_first_step_of_checkout(1472)
        user.enter_coupon("12345")
    }

    @When("Click the Apply Coupon button.")
    public void click_apply_coupon() {
        user.click_apply_coupon()
    }

    @Then("The coupon discount appears as a new line in the order summary and the grand total is updated.")
    public void coupon_discount_appears_in_grand_total() {
        user.coupon_discount_appears_in_grand_total()
    }

    @Then("Message appears AutoTestCoupon (12345) has been applied to your order.")
    public void message_appears_promo_code_applied() {
        user.message_appears_promo_code_applied()
    }

    @When("I Enter a invalid coupon code.")
    @Pending
    public void enter_invalid_coupon_code() {}

    @Then("message appears: “<promo code name> is invalid or qualifications have not been met”.")
    @Pending
    public void assert_error_message() {}

    @When("I enter a valid gift card code.")
    @Pending
    public void enter_valid_gift_card() {}

    @When("Click the Add Gift Card button.")
    @Pending
    public void click_add_gift_cart() {}

    @Then("The gift card discount appears as a new line in the order summary and the grand total is updated.")
    @Pending
    public void discount_gift_cart_appears_in_grand_total() {}

    @When("Click the Check Gift Card Status & Balance.")
    @Pending
    public void click_check_gift_cart() {}

    @Then("The Gift Card Status & Balance appears.")
    @Pending
    public void assert_gift_cart_status_and_balance() {}

    @When("I click on X remove link.")
    @Pending
    public void click_on_x_remove_link() {}

    @Then("The Gift Card Status & Balance disappears.")
    @Pending
    public void assert_gift_cart_status_and_balance_disappears() {}

    @When("I enter a invalid gift card code.")
    @Pending
    public void enter_invalid_gift_card() {}

    @Then("Message appears that the gift card is invalid")
    @Pending
    public void assert_message_gift_cart_invalid() {}

    @When("I enter a invalid gift card code, that has balance more than cart Total.")
    @Pending
    public void enter_invalid_gift_cart_balance_bigger_than_total() {}

    @Then("The Payment Method section is disabled")
    @Pending
    public void assert_payment_section_disable() {}

    @Given("I am on checkout as User with gift cart product in cart.")
    @Pending
    public void on_checkout_with_gift_cart_product_in_cart() {}

    @Then("I can't apply gift cart to cart.")
    @Pending
    public void assert_i_can_not_apply_gift_cart() {}

    @When("I go to home page and return to checkout page.")
    @Pending
    public void go_to_home_page_and_return() {}

    @Then("I can't see previous applied gift cards.")
    @Pending
    public void assert_no_applied_gift_cards_to_the_order() {}
}
