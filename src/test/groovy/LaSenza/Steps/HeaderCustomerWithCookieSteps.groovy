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
        admin.set_cookie_time(10)
        user.log_in()
    }

    @Then("I should string Welcome First Name")
    public void should_see_welcome_msg(){
       customer.assert_welcome_msg()
    }
}
