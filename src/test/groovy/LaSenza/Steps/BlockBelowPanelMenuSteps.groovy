package LaSenza.Steps

import LaSenza.steps.UserSteps
import net.thucydides.core.annotations.Steps
import org.jbehave.core.annotations.Given
import org.jbehave.core.annotations.Then

class BlockBelowPanelMenuSteps {

    @Steps
    UserSteps user

    @Given("I am on home page.")
    public void openHomePage() {
        user.opens_home_page()
    }

    @Given("I am on CLP.")
    public void openCLP() {
        user.opens_CLP("bras")
    }

    @Given("I am on subCLP.")
    public void opensubCLP() {
        user.opens_subCLP("panties", "bikinis")
    }

    @Given("I am on CP.")
    public void openCP() {
        user.opens_CP("sexy-lingerie")
    }

    @Given("I am on CDP.")
    public void openCDP() {
        user.opens_CDP("sexy-lingerie", "the-show-off-trade")
    }

    @Then("I should see static block below menu panel.")
    public void should_see_static_block_below_menu_panel() {
        user.should_see_static_block_below_menu_panel()
    }

}
