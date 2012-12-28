package LaSenza.Steps

import LaSenza.steps.UserSteps
import net.thucydides.core.annotations.Steps
import org.jbehave.core.annotations.*

class HeaderIndependentStateSteps {

    @Steps
    UserSteps user

    @Given('I enter "$text" to search field.')
    public void enter_text_to_the_search_field(String text){
        user.enter_text_to_the_search_field(text)
    }

    @When("I click magnifying glass icon.")
    public void click_search_button(){
        user.click_on_search_button()
    }

    @When("I click on link Store Locator.")
    public void click_on_link_store_locator(){
        user.click_on_link_store_locator()
    }

    @Then("I should redirects to the Store Locator page.")
    public void assert_on_store_locator_page(){
        user.assert_on_store_locator_page()
    }

    @Then("Search performs and navigates me to a Search Results page.")
    public void search_performs_and_navigates_to_search_results_page(){
        user.assert_on_search_page()
        user.assert_no_results()
    }
}
