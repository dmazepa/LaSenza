package LaSenza.Steps

import org.jbehave.core.annotations.*

class HeaderIndependentStateSteps {

    @Given('I enter text "$text" to search field.')
    public void enter_text_to_the_search_field(@Named("text") int text){

    }

    @When("I click magnifying glass icon.")
    public void click_search_button(){
    }

    @Then("Search performs and navigates me to a Search Results page.")
    public void search_performs_and_navigates_to_search_results_page(){

    }
}
