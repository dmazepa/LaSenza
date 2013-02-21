package LaSenza.Steps

import LaSenza.steps.UserSteps
import net.thucydides.core.annotations.Steps
import org.jbehave.core.annotations.Given
import org.jbehave.core.annotations.When

class RegisterLoginSteps {

    @Steps
    UserSteps user

    @Given("I am on Login page.")
    public void open_login_page() {
        user.open_create_account_page()
    }

    @When("I use process to create account.")
    public void create_account() {
        Random random = new Random()
        user.create_account("account${random.nextInt(1000)}@sproteck.com", "111")
    }

}
