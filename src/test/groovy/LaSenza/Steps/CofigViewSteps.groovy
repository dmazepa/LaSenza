package LaSenza.Steps

import LaSenza.steps.UserSteps
import net.thucydides.core.annotations.Steps
import org.jbehave.core.annotations.Given

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
}
