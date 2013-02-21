package LaSenza.Steps

import LaSenza.steps.UserSteps
import net.thucydides.core.annotations.Steps
import org.jbehave.core.annotations.Given
import org.jbehave.core.annotations.Then

class TitlesSteps {

    @Steps
    UserSteps user;

    @Given("I want to see title \"Home Page\" on Home Page")
    public void givenIAmOnTheHomePage() {
        user.opens_home_page()
    }

    @Then("I should see title Home Page")
    public void thenShouldSeeTitleHomePage() {
        user.should_see_title("Home Page")
    }


}
