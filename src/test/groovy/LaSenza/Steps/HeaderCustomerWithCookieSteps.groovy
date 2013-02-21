package LaSenza.Steps

import LaSenza.steps.AdminPanelSteps
import LaSenza.steps.CustomerSteps
import LaSenza.steps.UserSteps
import net.thucydides.core.annotations.Steps
import org.jbehave.core.annotations.Given
import org.jbehave.core.annotations.Then
import org.jbehave.core.annotations.When

class HeaderCustomerWithCookieSteps {

    @Steps
    UserSteps user

    @Steps
    CustomerSteps customer

    @Steps
    AdminPanelSteps admin

    @Given("I am on home page as customer with cookies.")
    public void open_home_page_as_customer_with_cookie() {
        admin.open_admin_panel()
        admin.set_cookie_time("10")
        admin.clean_cache()
        user.log_in(true)
    }

    @When("I did not have activity more than  set to cookie save.")
    public void no_activity_more_than_set_to_cookie() {
        user.timeout(12000)
        user.refresh_page()
    }

    @Then('I should see welcome msg "$welcomeMSG"')
    public void should_see_welcome_msg(String welcomeMSG) {
        customer.assert_welcome_msg(welcomeMSG)
    }

    @Then('I should see string "$pleaseLoginNotTestTester"')
    public void should_see_please_login_msg(String pleaseLoginNotTestTester) {
        customer.assert_please_login_msg(pleaseLoginNotTestTester)
    }

    @Given("I am on home page as customer with cookie enabled.")
    public void open_home_page_as_guest_with_cookie() {
        user.click_on_link_please_log_in_not()
        user.log_in(true)
        user.timeout(12000)
        user.refresh_page()
    }

    @When("I click on link Please Log In.")
    public void click_on_link_please_log_in() {
        user.click_on_link_please_log_in()
    }

    @When("I click on link Not Test Tester?.")
    public void click_on_link_not_first_name_last_name() {
        user.click_on_link_not_first_name_last_name()
    }

    @When("I click on link My Account.")
    public void click_on_link_my_account() {
        user.click_on_link_my_account()
    }

    @When("I click on link Wish List.")
    public void click_on_link_my_wishlist() {
        user.click_on_link_my_wishlist()
    }

    @Then("I should redirects to Login page.")
    public void assert_on_login_page() {
        user.assert_on_login_page()
    }

    @Then("It logs customer out.")
    public void assert_logged_out() {
        user.assert_logged_out()
    }

    @Then("Load default header state.")
    public void assert_default_header() {
        user.assert_default_header()
    }

    @Then("I should redirects to the My Wish List Login page.")
    public void assert_on_wish_list_login_page() {
        admin.restore_default_state()
        user.assert_on_wish_list_login_page()
    }

    @When('I click on link "Not Test Tester?".')
    public void click_on_link_not() {
        user.click_on_link_please_log_in()
    }
}
