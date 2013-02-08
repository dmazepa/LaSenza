package LaSenza.Steps

import LaSenza.steps.UserSteps
import net.thucydides.core.annotations.Steps
import org.jbehave.core.annotations.*

class MiniCartUserActionsSteps {

    @Steps
    UserSteps user

    @When("Click on Product <Element>")
    public void click_on_element(String Element){
        user.click_on_element_in_mini_cart(Element)
    }

    @Then("I redirects to appropriate PDP.")
    public void assert_on_pdp(){
        user.assert_on_PDP()
    }
}
