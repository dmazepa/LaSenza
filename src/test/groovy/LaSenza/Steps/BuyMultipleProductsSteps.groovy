package LaSenza.Steps

import LaSenza.steps.UserSteps
import net.thucydides.core.annotations.Steps
import org.jbehave.core.annotations.*

class BuyMultipleProductsSteps {

    @Steps
    UserSteps user

    @Given("I am on PDP with configurable product as User.")
    public void on_pdp_configurable_user(){
        user.open_pdp(1574)
    }

    @When("I select color in second row.")
    public void select_color_second_row(){
        user.select_color_second_row_QV()
    }
}
