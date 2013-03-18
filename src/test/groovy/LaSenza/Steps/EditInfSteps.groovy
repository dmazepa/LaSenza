package LaSenza.Steps

import LaSenza.steps.CustomerSteps
import LaSenza.steps.UserSteps
import net.thucydides.core.annotations.Steps
import org.jbehave.core.annotations.Given
import org.jbehave.core.annotations.Then
import org.jbehave.core.annotations.When
import org.jbehave.core.annotations.UsingEmbedder
import org.jbehave.core.embedder.Embedder

@UsingEmbedder(embedder = Embedder.class, generateViewAfterStories = true, ignoreFailureInStories = true, ignoreFailureInView = true, verboseFailures = true,
storyTimeoutInSecs = 600L, threads = 2, metaFilters = "-skip")

class EditInfSteps {

    @Steps
    UserSteps user

    @Steps
    CustomerSteps customer

    @Given("I am on checkout page as User.")
    public void on_checkout_page_as_user() {
        user.opens_home_page()
        user.log_out_if_logged_in()
        user.open_first_step_of_checkout(1472)
    }

    @Given("I am on checkout page as User and choose payment by Credit cart.")
    public void on_checkout_page_as_user_with_payment_visa() {
        user.open_first_step_of_checkout(1472)
    }

    @Given("I am on checkout page as Customer and process checkout with checked Save in Address Book checkbox.")
    public void on_checkout_page_as_customer_with_save_address_checked() {
        user.log_in(true)
        customer.open_my_account_address_book()
        customer.delete_additional_shipping_address()
        customer.open_first_step_of_checkout(1574)
        customer.enter_new_shipping_address()
        customer.check_checkbox_save_address()
        customer.pass_checkout()
    }

    @When("I click on link Already Registered")
    public void click_on_link_already_register() {
        user.click_on_link_already_register()
    }

    @When("I create account.")
    public void create_account() {
        Random random = new Random()
        user.enter_valid_data_on_checkout_page("account${random.nextInt(1000)}@sproteck.com", "111", "Visa", "4111111111111111", "VI", "Test City", "11111", "United States", "California")
        user.create_account_on_checkout_page("testthis", "testthis")
        user.click_button_confirm_and_pay_via_javascript()
        user.click_submit_button()
    }

    @When("I check check-box Ship to My Billing Address.")
    public void fill_fields_billing_and_uncheck_checkbox_use_billing_for_shipping() {
        user.enter_valid_billing_data("test1@speroteck.com", "Test City", "11111", "United States", "California")
        user.uncheck_checkbox_use_billing_for_shipping()
    }

    @When("I create account and enter wrong password.")
    public void create_account_with_wrong_password() {
        Random random = new Random()
        user.enter_valid_data_on_checkout_page("account${random.nextInt(1000)}@sproteck.com", "111", "Visa", "4111111111111111", "VI", "Test City", "11111", "United States", "California")
        user.create_account_on_checkout_page("testthis", "testthis1")
        user.click_button_confirm_and_pay_via_javascript()
    }

    @When("Enter valid data.")
    public void type_data_to_login() {
        user.type_data_to_login("test1@speroteck.com", "testthis")
    }

    @When("Click login button.")
    public void click_login_button_pop_up() {
        user.click_login_button_pop_up()
    }

    @Then("I become logged in without leaving the page.")
    public void assert_logged_in_and_on_checkout_page() {
        customer.assert_logged_in()
    }

    @Then("I can click on link What is this?")
    public void click_on_link_What_is_this() {
        user.click_input_credit_cart("VI")
        user.click_on_link_What_is_this()
    }

    @Then("I can see entered on checkout page address in address book")
    public void assert_address_added() {
        customer.open_my_account_address_book()
        customer.assert_address_added()
    }

    @Then("It is associated with a form field triggers a tab tip popup with a description or explanation of the form field.")
    public void assert_what_is_this() {
        user.assert_what_is_this()
    }

    @Then("I get account.")
    public void assert_on_my_account_page() {
        customer.wait_for_thank_you_page()
        customer.assert_logged_in()
    }

    @Then("I get error message.")
    public void assert_error_message() {
        user.assert_error_message()
    }

    @Then("It copies the data from the Billing Address form fields into the Shipping address form fields.")
    public void assert_data_copied() {
        user.assert_data_copied_from_billing_to_shipping()
    }

    @Then('I can see "$i" payment methods.')
    public void assert_payment_methods(String i) {
        user.assert_payment_methods(i)
    }

    @When("I enter Canadian billing address.")
    public void enter_canadian_billing() {
        user.enter_valid_billing_data("test1@speroteck.com", "Ottawa", "K1A 0G9", "Canada", "Ontario")
    }
}
