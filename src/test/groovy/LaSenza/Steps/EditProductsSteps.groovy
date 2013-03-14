package LaSenza.Steps

import LaSenza.steps.UserSteps
import net.thucydides.core.annotations.Steps
import org.jbehave.core.annotations.*

class EditProductsSteps {

    @Steps
    UserSteps user

    @Given("I am on shopping cart as User with simple product in cart.")
    public void open_shopping_cart_as_user_with_simple_product() {
        if(user.no_items_in_cart()){
            user.open_pdp(1472)
            user.click_add_to_cart_button_pdp()
        }
        user.open_shopping_cart()
    }

    @Given("Edit item link does not shows for simple products.")
    public void assert_link_edit_on_shopping_cart_absent() {
        user.assert_link_edit_on_shopping_cart_absent()
    }

    @Given("I am on shopping cart as User with configurable product in cart.")
    public void open_shopping_cart_as_user_with_configurable_product() {
        if(user.no_items_in_cart()){
            user.open_pdp(1574)
            user.choose_configurable_options(1)
            user.click_add_to_cart_button_pdp()
        }
        user.open_shopping_cart()
    }

    @When("I click on remove item icon.")
    public void click_on_remove() {
        user.click_on_remove_shopping_cart()
    }

    @Then("Item removes from the shopping cart.")
    public void assert_empty_cart() {
        user.assert_empty_cart()
    }

    @When("I click on Continue Shopping.")
    public void click_continue_shopping() {
        user.click_continue_shopping_shopping_cart()
    }

    @Then("It returns user to Home page.")
    public void assert_on_home_page() {
        user.assert_on_home_page()
    }

    @Given("I am on empty shopping cart as User.")
    public void on_empty_cart_page() {
        open_shopping_cart_as_user_with_configurable_product()
        user.delete_items_from_cart()
    }

    @When("I click on link Click here.")
    public void click_on_link_click_here() {
        user.click_on_link_click_here_shopping_cart()
    }

    @When("I click on Clear Shopping Cart.")
    public void click_clear_shopping_cart() {
        user.click_clear_shopping_cart()
    }

    @Then("It removes all items from the shopping cart.")
    public void assert_empty_shopping_cart() {
        user.assert_empty_cart()
    }

    @When("I click on <Element>.")
    public void assert_empty_shopping_cart(String Element) {
        user.click_on_element_in_shopping_cart(Element)
    }

    @Then("Quickview displays.")
    public void assert_QV_opened() {
        user.assert_quick_view_module_opened()
    }
}
