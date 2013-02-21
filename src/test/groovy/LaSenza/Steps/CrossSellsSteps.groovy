package LaSenza.Steps

import LaSenza.steps.AdminPanelSteps
import LaSenza.steps.UserSteps
import net.thucydides.core.annotations.Steps
import org.jbehave.core.annotations.*

class CrossSellsSteps {

    @Steps
    AdminPanelSteps admin

    @Steps
    UserSteps user

    @When("I configure cross-sells products manually.")
    public void configure_cross_sells_manually(){
        admin.open_product(4189)
        admin.set_cross_sells_for_product(11501)
    }

    @Then('Configured products "$productName" id "$id" shows on Shopping cart page.')
    public void assert_configured_product_as_cross_sell(String productName, String id){
        user.add_item_to_cart(id)
        user.open_shopping_cart()
        user.assert_cross_sell(productName)
    }

    @When("I configure cross-sells products based on rules.")
    public void configure_cross_sells_by_rule(){
        admin.create_new_product_rule("111101-001", "111002-031")
    }

    @Given("I am on Shopping cart with Cross-Sells products.")
    public void open_shopping_cart(){
        user.open_shopping_cart()
    }

    @When("Clicking on the product image or the product name.")
    public void click_on_image_or_name_cross_sell(){
        user.click_on_image_or_name_cross_sell()
    }

    @When("I add to cart product.")
    public void add_to_cart_from_qv_shopping_cart(){
    }

    @Then("Item adds to cart without leaving the page.")
    public void assert_item_added_to_cart_adn_i_am_on_shopping_cart(){
    }
}
