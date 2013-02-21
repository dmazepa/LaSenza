package LaSenza.Steps

import LaSenza.steps.UserSteps
import net.thucydides.core.annotations.Steps
import org.jbehave.core.annotations.Given
import org.jbehave.core.annotations.Then
import org.jbehave.core.annotations.When

class HeaderIndependentStateSteps {

    @Steps
    UserSteps user

    @Given('I enter "$text" to search field.')
    public void enter_text_to_the_search_field(String text) {
        user.enter_text_to_the_search_field(text)
    }

    @Given("I have not items in cart.")
    public void have_no_items_in_cart() {
    }

    @Given("I have items in cart, one of them has qty more than 2.")
    public void add_items_to_cart() {
        user.add_items_to_cart()
    }

    @When("I click magnifying glass icon.")
    public void click_search_button() {
        user.click_on_search_button()
    }

    @When("I click on My Cart link.")
    public void click_on_my_cart_link() {
        user.click_on_element_text_my_cart_header()
    }

    @When("I click on <Element> in Shopping cart area.")
    public void click_on_element_in_shopping_cart_area(String Element) {
        user.click_on_element_in_shopping_cart_area(Element)
    }

    @When("I click on link Store Locator.")
    public void click_on_link_store_locator() {
        user.click_on_link_store_locator()
    }

    @Then("I should redirects to the Store Locator page.")
    public void assert_on_store_locator_page() {
        user.assert_on_store_locator_page()
    }

    @Then("Search performs and navigates me to a Search Results page.")
    public void search_performs_and_navigates_to_search_results_page() {
        user.assert_on_search_page()
        user.assert_no_results()
    }

    @Then("I should see mini cart.")
    public void should_see_mini_cart() {
        user.assert_mini_cart_appears()
    }

    @Then("Total number of items in cart equal <sum> of all qtys for each items.")
    public void assert_qty_in_mini_cart(String sum) {
        user.assert_total_qty_in_header(sum)
    }

    @Then("I should not see mini cart.")
    public void assert_no_mini_cart() {
        user.assert_mini_cart_not_appears()
    }

    @Then("I should stay on Home page.")
    public void assert_on_home_page() {
        user.assert_on_home_page()
    }
}
