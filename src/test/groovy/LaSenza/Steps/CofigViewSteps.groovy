package LaSenza.Steps

import LaSenza.steps.UserSteps
import net.thucydides.core.annotations.Steps
import org.jbehave.core.annotations.*

class CofigViewSteps {

    @Steps
    UserSteps user

    @Given("I am on Category page as User.")
    public void on_category_page(){
        user.opens_CLP("sale")
    }

    @Given("I can see only right arrow in pagination.")
    public void assert_only_right_row_present(){
        user.assert_only_right_row_present()
    }

    @When("I click on second page.")
    public void click_on_link_second_page(){
        user.click_on_link_second_page()
    }

    @Then("Second page with products opens.")
    public void assert_on_second_page_CLP(){
        user.assert_on_second_page_CLP()
    }

    @Then("I can see left and right arrows in pagination.")
    public void assert_left_and_right_row_CLP(){
        user.assert_left_and_right_row_CLP()
    }

    @Then("I can see second page is selected.")
    public void assert_second_page_selected_CLP(){
        user.assert_second_page_selected_CLP()
    }

    @When("I click on last page in pagination.")
    public void click_on_last_page_CLP(){
        user.click_on_last_page_CLP()
    }

    @Then("I can see only left arrow in pagination.")
    public void asser_only_left_row_CLP(){
        user.asser_only_left_row_CLP()
    }

    @Given("I am on Collection landing page as User.")
    public void on_collection_landing_page(){
        user.opens_CLP("panties/collections/the-show-off-trade")
    }

    @When("I click on right arrow.")
    public void click_right_arrow(){
        user.click_right_arrow()
    }

    @Then("I get second page.")
    public void assert_second_page_CLP(){
        user.assert_on_second_page_CLP()
    }

    @When("I click on left arrow.")
    public void click_left_arrow_CLP(){
        user.click_left_arrow_CLP()
    }

    @Then("I get first page.")
    public void assert_first_page_CLP(){
        user.assert_on_first_page_CLP()
    }

    @Given("I am on SubCategory page as User.")
    public void on_subcategory_page(){
        user.opens_CLP("bras/push-up")
    }

    @Then('I can see "$qtyItems" items on page.')
    public void assert_qty_items_on_CLP(String qtyItems){
        user.assert_qty_items_on_CLP(qtyItems)
    }

    @When('I select to show "$qtyItems" items per page.')
    @Pending
    public void select_to_show_qty_items_CLP(String qtyItems){
        user.select_to_show_qty_items_CLP(qtyItems)
    }
}
