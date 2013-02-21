package LaSenza.Steps

import LaSenza.steps.UserSteps
import net.thucydides.core.annotations.Steps
import org.jbehave.core.annotations.Then
import org.jbehave.core.annotations.When

class HeaderGuestWithoutCookiesSteps {

    @Steps
    UserSteps user

    @When("I click on link Log In.")
    public void click_on_link_login() {
        user.click_on_link_login()
    }

    @When("I click on link Register in header.")
    public void click_on_link_register() {
        user.click_on_link_register()
    }

    @Then("I should redirects to the Account Creation page.")
    public void assert_on_create_account_page() {
        user.assert_on_create_account_page()
    }

    @Then("I should redirects to the Login page.")
    public void assert_on_login_page() {
        user.assert_on_login_page()
    }

}
