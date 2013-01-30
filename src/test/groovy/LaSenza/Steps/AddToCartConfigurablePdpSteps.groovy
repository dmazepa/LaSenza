package LaSenza.Steps

import org.jbehave.core.annotations.*
import net.thucydides.core.annotations.Steps
import LaSenza.steps.UserSteps

class AddToCartConfigurablePdpSteps {

    @Steps
    UserSteps user

    @Given("I am on PDP with configurable product.")
    public void open_pdp_configurable(){
        user.open_pdp(1574)
    }

    @When("Set multiple product conﬁgurations.")
    @Pending
    public void set_multiple_product_conﬁgurations(){
    }

    @Then('The quantity "$qty" and order total "$price" are updated to reﬂect the addition.')
    public void assert_item_in_header(String qty, String price){
        user.assert_qty_and_price_added_in_header(qty, price)
    }

    @Then('Then Added ites qty "1" and price "$22.50" appears ﬁrst in the Shopping cart.')
    @Pending
    public void assert_item_in_shopping_cart(String qty, String price){
        //user.assert_qty_and_price_added_to_shopping_cart(qty, price)
    }

    @When("I click Add to Cart button configurable.")
    public void click_add_to_cart_button(){
        user.choose_and_store_configurable_options()
        user.click_add_to_cart_button_pdp()
    }
}
