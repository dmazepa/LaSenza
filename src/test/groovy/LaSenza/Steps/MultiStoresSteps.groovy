package LaSenza.Steps

import LaSenza.steps.UserSteps
import net.thucydides.core.annotations.Steps

class MultiStoresSteps {

    @Steps
    UserSteps user

   /* @When("I choose <siteVersion> version of site.")
    public void chooseSiteVersion(String siteVersion){
        user.click_on_select_location()
        user.waitForPopUP()
        user.selectLocation(siteVersion)
    }

    @Then('I sould see default location "$location"')
    public void assert_default_location(String location){
        user.assert_default_location(location)
    }

    @Then("I should see <siteVersion> version of site.")
    public void assert_chosen_location(String siteVersion){
        user.assert_location(siteVersion)
    }*/
}