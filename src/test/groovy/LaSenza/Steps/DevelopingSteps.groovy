package LaSenza.Steps

import LaSenza.steps.UserSteps
import net.thucydides.core.annotations.Steps
import org.jbehave.core.annotations.Given
import org.jbehave.core.annotations.Then
import org.jbehave.core.annotations.When

class DevelopingSteps {

    @Steps
    UserSteps user

    @Given('I enter text "text" to search field.')
    public void enter_text_to_the_search_field(text){
    }

    @When("I click magnifying glass icon.")
    public void click_search_button(){
    }

    @Then("Search performs and navigates me to a Search Results page.")
    public void search_performs_and_navigates_to_search_results_page(){

    }
}
