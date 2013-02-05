package LaSenza.Steps

import LaSenza.steps.CustomerSteps
import LaSenza.steps.UserSteps
import net.thucydides.core.annotations.Steps
import org.jbehave.core.annotations.*

class AddToWishListSteps {

    @Steps
    UserSteps user

    @Steps
    CustomerSteps customer

    @Given("I am on QW with configurable product as customer.")
    public void on_qw_as_customer(){
        user.opens_home_page()
        user.log_in(true)
        customer.opens_CLP("bras")
        customer.open_quick_view_configurable()
    }

    @When("I click Add to Wishlist button.")
    public void click_add_to_wishlist(){
        customer.click_add_to_wishlist()
    }

    @When("I click Add to Wishlist button User.")
    public void click_add_to_wishlist_user(){
        user.click_add_to_wishlist_user()
    }

    @Then("Quickview module closes and adds the product to her wishlist.")
    public void assert_product_added_to_wishlist(){
        customer.assert_product_added_to_wishlist()
    }

    @Then("Quickview module closes and she is navigated to the Account Creation page.")
    public void assert_QV_closed_and_on_login_page(){
        user.assert_qw_absent()
        user.assert_on_login_page()
    }
}
