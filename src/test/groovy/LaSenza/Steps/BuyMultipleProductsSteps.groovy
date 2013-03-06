package LaSenza.Steps

import LaSenza.steps.UserSteps
import net.thucydides.core.annotations.Steps
import org.jbehave.core.annotations.Given
import org.jbehave.core.annotations.Then
import org.jbehave.core.annotations.When

class BuyMultipleProductsSteps {

    @Steps
    UserSteps user

    @Given("I am on PDP with configurable product as User.")
    public void on_pdp_configurable_user() {
        user.open_pdp(1574)
    }

    @Then("I can select color in second row.")
    public void select_color_second_row() {
        user.add_row_additional_product_QV()
        user.select_color_second_row()
    }

    @When("I click on the plus sign or the Add More Items link.")
    public void click_add_more_items() {
        user.add_row_additional_product_QV()
        user.add_row_additional_product_QV()
    }

    @Then("Additional row adds to the Product Selections area.")
    public void assert_additional_rows_appeared() {
        user.assert_additional_rows_appeared()
    }
}
