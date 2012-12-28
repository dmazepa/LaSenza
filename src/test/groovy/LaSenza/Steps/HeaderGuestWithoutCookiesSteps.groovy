package LaSenza.Steps

import net.thucydides.core.annotations.Steps
import LaSenza.steps.UserSteps
import org.jbehave.core.annotations.*

class HeaderGuestWithoutCookiesSteps {

    @Steps
    UserSteps user

    @Then('I should see string "WELCOME!"')
    public void assert_welcome_msg_guest(String welcomeMSG){
        user.should_see_welcomeMSG(welcomeMSG)
    }

    @When("I click on link Log In.")
    public void click_on_link_login(){
        user.click_on_link_login()
    }

    @When("I click on link Register in header.")
    public void click_on_link_register(){
        user.click_on_link_register()
    }

    @Then("I should redirects to the Account Creation page.")
    public void assert_on_create_account_page(){
        user.assert_on_create_account_page()
    }

    @Then("I should redirects to the Login page.")
    public void assert_on_login_page(){
        user.assert_on_login_page()
    }

}
