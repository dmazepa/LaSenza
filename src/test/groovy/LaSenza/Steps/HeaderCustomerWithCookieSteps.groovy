package LaSenza.Steps

import LaSenza.steps.AdminPanelSteps
import LaSenza.steps.CustomerSteps
import LaSenza.steps.UserSteps
import net.thucydides.core.annotations.*
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
    public void open_home_page_as_customer_with_cookie(){
        admin.open_admin_panel()
        admin.set_cookie_time(10)
        user.log_in()
    }

    @When("I did not have activity more than  set to cookie save.")
    public void no_activity_more_than_set_to_cookie(){
        user.timeout(10000)
        user.refresh_page()
    }

    @Then("I should string Welcome First Name")
    public void should_see_welcome_msg(){
       customer.assert_welcome_msg()
        admin.open_admin_panel()
        admin.set_cookie_time(3600)
    }
}
