package LaSenza.Steps

import LaSenza.steps.AdminPanelSteps
import LaSenza.steps.CustomerSteps
import LaSenza.steps.UserSteps
import net.thucydides.core.annotations.Steps
import org.jbehave.core.annotations.*

class HeaderCustomerWithCookieSteps {

    @Steps
    UserSteps user

    @Steps
    CustomerSteps customer

    @Steps
    AdminPanelSteps admin

    @Given("I am on home page as customer with cookies.")
    public void open_home_page_as_customer_with_cookie(){
        admin.open_admin_panel()
        admin.set_cookie_time("10")
        user.log_in()
    }

    @When("I did not have activity more than  set to cookie save.")
    public void no_activity_more_than_set_to_cookie(){
        user.timeout(12000)
        user.refresh_page()
    }

    @Then('I should see string "$welcomeMSG"')
    public void should_see_welcome_msg(String welcomeMSG){
       customer.assert_welcome_msg(welcomeMSG)
    }

    @Then('I should see string "$pleaseLoginNotTestTester"')
    public void should_see_please_login_msg(String pleaseLoginNotTestTester){
       customer.assert_please_login_msg(pleaseLoginNotTestTester)
    }

    @AfterStories
    public void set_default_cookie(){
        admin.restore_default_state()
    }

    @Given("I am on home page as guest with cookie enabled.")
    public void open_home_page_as_guest_with_cookie(){
        user.log_in()
        user.timeout(12000)
        user.refresh_page()
    }

    @When("I click on link Please Log In.")
    public void click_on_link_please_log_in(){
        user.click_on_link_please_log_in()
    }

    @Then("I should redirects to Login page.")
    public void assert_on_login_page(){
        user.assert_on_login_page()
    }
//    @Then("It logs me out.")
//    public void assert_logged_out(){
//        user.assert_logged_out()
//    }
     @Then("Load default header state.")
     public void assert_default_header(){
        user.assert_default_header()
     }

    @When('I click on link "Not Test Tester?".')
    public void click_on_link_not(){
        user.click_on_link_please_log_in()
    }
}
