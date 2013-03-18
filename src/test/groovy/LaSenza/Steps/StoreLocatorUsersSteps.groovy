package LaSenza.Steps

import LaSenza.steps.UserSteps
import net.thucydides.core.annotations.Steps
import org.jbehave.core.annotations.Given
import org.jbehave.core.annotations.Then
import org.jbehave.core.annotations.When

class StoreLocatorUsersSteps {

    @Steps
    UserSteps user

    @Given("I am on Store Locator page.")
    public void on_store_locator_page() {
        user.open_store_locator_page()
    }

    @When('I enter search term "$text" into Address field.')
    public void enter_search_term(String text) {
        user.enter_text_to_search_field(text)
    }

    @Then("Input field recognizes any search term that Google Maps understands.")
    public void assert_input_recognize_search_term() {
        user.click_button_search_store_locator()
        user.assert_search_field_clear_store_locator()
        user.assert_search_results_contains("SEVENOAKS MALL", 1)
    }

    @When('I specify a search radius "$radius".')
    public void specify_search_radius(String radius) {
        user.specify_search_radius(radius)
    }

    @When("Click button search.")
    public void click_button_search() {
        user.click_button_search_store_locator()
    }

    @Then("Only locations that fall within the selected radius will be returned in the search result.")
    public void assert_selected_locations_in_result() {
        user.assert_search_results_contains("WOODGROVE CENTRE", 15)
    }

    @Then("A popup displays to indicate that The address is not valid.")
    public void assert_pop_up_present() {
        user.assert_pop_up_present()
    }

    @Then("The area to the left of the map indicates No results found.")
    public void assert_no_results() {
        user.assert_no_results_store_locator()
    }

    @When("I click Reset button.")
    public void click_reset_button() {
        user.click_reset_button()
    }

    @Then("Address field clears.")
    public void assert_search_field_clear() {
        user.assert_search_field_clear_store_locator()
    }

    @Then("Search Results Sidebar displays all available stores.")
    public void assert_search_results_contain_all_stores() {
        user.assert_search_results_contains_stores(155)
    }

    @When('I click on store "$entryNumber" entry.')
    public void click_on_store_entry(String entryNumber) {
        user.click_on_store_entry(entryNumber)
    }

    @When("I click on direction.")
    public void click_on_direction() {
        user.enter_text_to_search_field("Kamloops Canada")
        user.click_button_search_store_locator()
        user.click_on_direction()
    }

    @Given("I am on Store Locator page with some previous actions.")
    public void on_store_locator_with_some_actions() {
        user.open_store_locator_page()
        user.enter_text_to_search_field("Abrakadabra")
        user.specify_search_radius("200")
        user.click_button_search_store_locator()
    }

    @When("I click link Reset Locations.")
    public void click_link_reset_store_locations() {
        user.click_link_reset_store_locations()
    }

    @Then("Restores the page to its initial load state where all available store locations are displayed in the sidebar.")
    public void assert_initial_load_state() {
        user.assert_search_results_contains_stores(155)
        user.assert_search_field_clear_store_locator()
        user.assert_default_radius()
    }

    @Then("Displays a list of turn by turn directions below the store location in the sidebar and updates the map with route line(s).")
    public void assert_dirrections_appeared(){
        user.assert_directions_appeared()

    }
}
