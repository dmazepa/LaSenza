package LaSenza.Steps

import LaSenza.steps.UserSteps
import net.thucydides.core.annotations.Steps
import org.jbehave.core.annotations.Given
import org.jbehave.core.annotations.Then
import org.jbehave.core.annotations.When

class MiniCartUserActionsSteps {

    @Steps
    UserSteps user

    @When("Click on Product <Element>")
    public void click_on_element(String Element) {
        user.click_on_element_in_mini_cart(Element)
    }

    @Then("I redirects to appropriate PDP.")
    public void assert_on_pdp() {
        user.assert_on_PDP()
    }

    @When("Click on link Edit Item.")
    public void click_on_link_edit_item() {
        user.click_on_link_edit_item()
    }

    @Then("I redirects to appropriate PDP and Add to Cart button has been replaced with an Update Cart button.")
    public void assert_on_pdp_with_button_update_cart() {
        user.assert_on_pdp_with_button_update_cart()
    }

    @Then("I can edit item.")
    public void assert_that_i_can_edit_item() {
        user.assert_that_i_can_edit_item()
    }

    @When("Click on link Remove Item.")
    public void click_on_link_remove_item_mini_cart() {
        user.click_on_link_remove_item_mini_cart()
    }

    @When("Accept confirmation.")
    public void accept_confirmation_on_remove_item_mini_cart() {
        user.accept_confirmation_on_remove_item_mini_cart()
    }

    @Then("Product removes from shopping cart.")
    public void assert_product_deleted() {
        user.assert_product_deleted()
    }

    @Then("Mini cart updates and total count of products updated in header.")
    public void assert_product_deleted_from_mini_cart() {
        user.assert_product_deleted_from_mini_cart()
    }

    @When("Refuse confirmation.")
    public void refuse_confirmation_on_delete_item() {
        user.refuse_confirmation_on_delete_item()
    }

    @Then("Product do not removes from shopping cart.")
    public void assert_products_in_cart_not_removes() {
        user.assert_products_in_cart_not_removes()
    }

    @Then("The mini-cart remains open.")
    public void assert_mini_cart_remains_open() {
        user.assert_mini_cart_appears()
    }

    @When("Click on link Go to Shopping Cart.")
    public void click_on_link_go_to_shopping_cart() {
        user.click_on_link_go_to_shopping_cart()
    }

    @Then("The mini-cart closes.")
    public void assert_mini_cart_closed() {
        user.assert_mini_cart_not_appears()
    }

    @Then("I redirects to the Shopping cart page.")
    public void assert_on_shopping_cart_page() {
        user.assert_on_shopping_cart_page()
    }

    @When("Click on link Checkout.")
    public void click_on_button_checkout() {
        user.click_on_button_checkout()
    }

    @Then("I redirects to the first step of checkout process for guest.")
    public void assert_on_checkout_page() {
        user.assert_on_checkout_page()
    }

    @Given("I am on home page with products in cart as customer.")
    public void on_home_page_with_products_in_cart_customer() {
        user.log_in(true)
        user.add_item_to_cart(11835)
    }

    @Then("I redirects to the first step of checkout process for customer.")
    public void on_checkout_as_customer() {
        user.assert_on_checkout_page()
        user.assert_logget_in_on_checkout_page()
    }
}
