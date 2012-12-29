package LaSenza.Steps

import LaSenza.steps.CustomerSteps
import LaSenza.steps.UserSteps
import net.thucydides.core.annotations.Steps
import org.jbehave.core.annotations.Given
import org.jbehave.core.annotations.Then

class DevelopingSteps {


    @Steps
    CustomerSteps customer

    @Steps
    UserSteps user


    @Given("I am on home page as customer.")
    public void open_home_page_as_customer_with_cookie(){
        user.log_in(true)
    }

    @Then("I should redirects to the My Account Dashboard page.")
    public void assert_on_my_account_dashboard_page(){
        customer.assert_on_my_account_dashboard_page()
    }


}
