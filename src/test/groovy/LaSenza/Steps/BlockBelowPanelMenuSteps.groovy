package LaSenza.Steps

import LaSenza.steps.UserSteps
import net.thucydides.core.annotations.Steps
import org.jbehave.core.annotations.*

class BlockBelowPanelMenuSteps {

    @Steps
    UserSteps user

    @Given("I am on home page.")
    public void openHomePage(){
        user.opens_home_page_thucydides()
    }

    @Given("I am on CLP.")
    public void openCLP(){
        user.opens_CLP("bras")
    }

    @Given("I am on subCLP.")
    public void opensubCLP(){
        user.opens_subCLP("panties","bikinis")
    }

    @Given("I am on CP.")
    public void openCP(){
        user.opens_CP("sexy-lingerie","the-show-off-trade")
    }

    @Given("I am on CDP.")
    @Pending
    public void openCDP(){
    }

    @Then("I should see static block below menu panel.")
    public void should_see_static_block_below_menu_panel(){
        user.should_see_static_block_below_menu_panel()
    }

}
