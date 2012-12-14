package LaSenza.Steps

import LaSenza.steps.CustomerSteps
import LaSenza.steps.UserSteps
import net.thucydides.core.annotations.Steps
import org.jbehave.core.annotations.Given
import org.jbehave.core.annotations.Then
import org.jbehave.core.annotations.When

class AddToWishListSteps {

    @Steps
    UserSteps user

    @Steps
    CustomerSteps customer

    @Given("I am on QW with configurable product as customer.")
    public void on_qw_as_customer(){
        user.log_in()
        customer.opens_CLP("beauty")
        customer.open_quick_view_configurable()
    }

    @When("I click Add to Wishlist button.")
    public void click_add_to_wishlist(){
        customer.click_add_to_wishlist()
    }

    @Then("Quickview module closes and adds the product to her wishlist.")
    public void assert_product_added_to_wishlist(){
        customer.assert_product_added_to_wishlist()
    }
}
