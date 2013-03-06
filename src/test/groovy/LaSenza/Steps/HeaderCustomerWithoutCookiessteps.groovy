package LaSenza.Steps

import LaSenza.steps.CustomerSteps
import LaSenza.steps.UserSteps
import net.thucydides.core.annotations.Steps
import org.jbehave.core.annotations.Given
import org.jbehave.core.annotations.Then
import org.jbehave.core.annotations.When

class HeaderCustomerWithoutCookiesSteps {

    @Steps
    CustomerSteps customer

    @Steps
    UserSteps user


    @Given("I am on home page as customer without coockie.")
    public void open_home_page_as_customer_with_cookie() {
        user.log_in(false)
    }

    @When("I click on link Log Out.")
    public void click_on_link_log_out() {
        customer.click_on_link_log_out()
    }

    @Then("I should redirects to the My Wishlist page.")
    public void assert_on_my_wishlist_page() {
        customer.assert_on_my_wishlist_page()
    }

    @Given("I am on Home page as customer and has multiple wishlists and items in Wish List.")
    public void on_home_with_multi_wishlist() {
        user.log_in(false)
        customer.clear_all_wish_lists()
        customer.add_product_to_multi_wishlists()
    }

    @Then("Total count of items in Wish list should displays and the same item from different wish lists is counted multiple times.")
    public void assert_total_count_of_items_in_wishlists() {
        customer.assert_total_count_of_items_in_wishlists()
    }

    @Then("I should redirects to the My Account Dashboard page.")
    public void assert_on_my_account_dashboard_page() {
        customer.assert_on_my_account_dashboard_page()
    }
}
