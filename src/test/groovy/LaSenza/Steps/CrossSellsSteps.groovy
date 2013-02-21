package LaSenza.Steps

import LaSenza.steps.AdminPanelSteps
import LaSenza.steps.UserSteps
import net.thucydides.core.annotations.Steps
import org.jbehave.core.annotations.Then
import org.jbehave.core.annotations.When

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

    @Then("Configured products shows on Shopping cart page.")
    public void assert_configured_product_as_cross_sell(){
        user.add_item_to_cart(4189)
        user.open_shopping_cart()
        user.assert_cross_sell("So Free Balconnet la")
    }
}
