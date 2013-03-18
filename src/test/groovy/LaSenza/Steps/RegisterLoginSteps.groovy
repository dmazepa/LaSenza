package LaSenza.Steps

import LaSenza.steps.CustomerSteps
import LaSenza.steps.UserSteps
import net.thucydides.core.annotations.Steps
import org.jbehave.core.annotations.Given
import org.jbehave.core.annotations.Then
import org.jbehave.core.annotations.When


class RegisterLoginSteps {

    def newPass

    @Steps
    UserSteps user

    @Steps
    CustomerSteps customer

    @Given("I am on Login page.")
    public void open_login_page() {
        user.log_out_if_logged_in()
        user.open_login_page()
    }

    @When("Passing successful authentication.")
    public void entered_login() {
       user.loginPage.log_in("test2@speroteck.com", "testthis${newPass}", false)
    }

    @Then("I get My Account: Dashboard page with logged in status.")
    public void assert_account_page(){
        customer.assert_on_my_account_dashboard_page()
    }

    @When("I use process forgot my password.")
    public void login_with_forgot_password(){
        user.click_on_link_forgot_password()
        user.input_email_and_click_submit("test2@speroteck.com")
    }

    @Then("I get email with new password.")
    public void email_new_password(){
        user.go_to_email_page("test2@speroteck.com","testthis")
        Random random = new Random()
        newPass = random.nextInt(2)
        user.input_new_password("testthis${newPass}")

    }

    @Then("I can log in with new password.")
    public void entered_new_login(){
        user.loginPage.log_in("test2@speroteck.com", "testthis${newPass}", false)
        customer.assert_on_my_account_dashboard_page()
    }

    @When("I use process to create account.")
    public void create_account() {
        user.click_on_button_register()
        Random random = new Random()
        user.create_account("account${random.nextInt(1000)}@sproteck.com", "111")
    }

}
