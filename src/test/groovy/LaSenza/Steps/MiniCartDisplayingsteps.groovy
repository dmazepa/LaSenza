package LaSenza.Steps

import LaSenza.steps.UserSteps
import net.thucydides.core.annotations.Steps
import org.jbehave.core.annotations.Given
import org.jbehave.core.annotations.Then
import org.jbehave.core.annotations.When

class MiniCartDisplayingSteps {

    @Steps
    UserSteps user

    @Given("I am on home page with products in cart.")
    public void on_home_page_with_products_in_cart() {
        user.add_item_to_cart(11835)
    }

    @When("I slide down mini cart.")
    public void open_mini_cart() {
        user.opens_home_page()
        user.refresh_page()
        user.click_on_element_in_shopping_cart_area("Icon Bag")
    }

    @Then("Mini cart displays for five seconds before sliding up.")
    public void assert_mini_cart_displaying_5_seconds() {
        user.assert_mini_cart_displaying_5_seconds()
    }

    @When("I add to cart 3 different items.")
    public void add_to_cart_3_items() {
        user.add_3_items_to_cart(4187, 4190, 4210)
    }

    @Then("Mini cart displays only the three most recently added items.")
    public void assert_most_recently_added_items_in_mini_cart() {
        user.assert_most_recently_added_items_in_mini_cart()
    }

    @Then("The most recently added item appears first.")
    public void assert_most_recently_appears_first() {
        user.assert_most_recently_added_appears_first()
    }
}
