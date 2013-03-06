package LaSenza.Steps

import LaSenza.steps.UserSteps
import net.thucydides.core.annotations.Steps
import org.jbehave.core.annotations.Given
import org.jbehave.core.annotations.Then
import org.jbehave.core.annotations.When

class AddMoreThanOneProductSteps {

    @Steps
    UserSteps user

    @Given("I am on QV with configurable product as User.")
    public void open_QV_configurable() {
        user.opens_CLP("sale")
        user.open_quick_view(2)
    }

    @Then("Select for attribute size is disable.")
    public void assert_select_size_disable() {
        user.assert_select_size_disable()
    }

    @Then('Qty field for "$fieldPosition" row pre-filled with value "$value".')
    public void assert_QTY_field_prefilled_QV(String fieldPosition, String value) {
        user.assert_QTY_field_prefilled_QV(fieldPosition, value)
    }

    @Then("Two rows of attributes appears by default.")
    public void assert_two_rows_of_additional_products_opened_QV() {
        user.assert_two_rows_of_additional_products_opened_QV()
    }

    @When("I select color in first row.")
    public void select_color_first_row() {
        user.select_color_first_row()
    }

    @Then("Select for attribute size enables.")
    public void assert_select_size_first_row_enabled_QV() {
        user.assert_select_size_first_row_enabled_QV()
    }

    @When("I add 2 additional product rows.")
    public void add_2_additional_product_rows() {
        user.add_row_additional_product_QV()
        user.add_row_additional_product_QV()
    }

    @When('Set QTY for row "$rowNumber" value "$qty".')
    public void set_QTY_additional_products_QV(String rowNumber, String qty) {
        user.set_QTY_additional_products_QV(rowNumber, qty)
    }

    @Then("Qty field for third row pre-filled with value 1.")
    public void assert_QTY_third_row_prefilled_QV() {
        user.assert_QTY_third_row_prefilled_QV()
    }

}
