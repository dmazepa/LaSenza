package LaSenza.pages

import net.thucydides.core.annotations.DefaultUrl
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.Matchers.equalTo

@DefaultUrl("http://localhost:9000/develop/checkout/onepage/")
class CheckoutPage extends ForAllPage{

    CheckoutPage(WebDriver driver){
        super(driver)
    }

    @FindBy(id = "contact:email")
    private WebElement fieldEmail

    @FindBy(id = "billing:firstname")
    private WebElement fieldFirstName

    @FindBy(id = "shipping:firstname")
    private WebElement fieldFirstNameShipping

    @FindBy(id = "billing:lastname")
    private WebElement fieldLastName

    @FindBy(id = "shipping:lastname")
    private WebElement fieldLastNameShipping

    @FindBy(id = "billing:street1")
    private WebElement fieldAddress1

    @FindBy(id = "shipping:street1")
    private WebElement fieldAddress1Shipping

    @FindBy(id = "billing:street2")
    private WebElement fieldAddress2

    @FindBy(id = "billing:city")
    private WebElement fieldCity

    @FindBy(id = "shipping:city")
    private WebElement fieldCityShipping

    @FindBy(id = "billing:region_id")
    private WebElement selectState

    @FindBy(id = "shipping:region_id")
    private WebElement selectStateShipping

    @FindBy(id = "billing:postcode")
    private WebElement fieldPostalCode

    @FindBy(id = "shipping:postcode")
    private WebElement fieldPostalCodeShipping

    @FindBy(id = "billing:telephone")
    private WebElement fieldTelephone

    @FindBy(id = "shipping:telephone")
    private WebElement fieldTelephoneShipping

    @FindBy(id = "shipping:save_in_address_book")
    private WebElement checkboxSaveShippingAddress

    @FindBy(id = "shipping-address-select")
    private WebElement selectShippingAddress

    @FindBy(id = "moneriscc_cc_number")
    private WebElement fieldCartNumber

    @FindBy(id = "moneriscc_expiration")
    private WebElement selectMonth

    @FindBy(id = "moneriscc_expiration_yr")
    private WebElement selectYear

    @FindBy(id = "moneriscc_cc_owner")
    private WebElement fieldCartName

    @FindBy(id = "moneriscc_cc_cid")
    private WebElement fieldVerificationNumber

    @FindBy(name = "shipping_method")
    private WebElement shipment

    @FindBy(xpath = "//input[@value='VI']")
    private WebElement inputCreditCart

    @FindBy(xpath = "//button[@class='button btn-checkout']")
    private WebElement buttonConfirmAndPay

    @FindBy(xpath = "//button[@class='confirm button btn-checkout-submit']")
    private WebElement buttonSubmit

    @FindBy(xpath = "//button[@class='popup-trigger']")
    private WebElement linkAlreadyRegister

    @FindBy(id = "login-email")
    private WebElement fieldEmailPopUp

    @FindBy(id = "login-password")
    private WebElement fieldPasswordPopUp

    @FindBy(xpath = "//form[@id='login-form']//button[@class='button']")
    private WebElement buttonLoginPopUp

    @FindBy(xpath = "//input[@id='billing:use_for_shipping']")
    private WebElement checkboxUseBillingForShipping

    @FindBy(xpath = "//img[@class='v-middle']")
    private WebElement loader

    @FindBy(xpath = "//a[@class='cvv-what-is-this']")
    private WebElement linkWhatIsThis

    @FindBy(id = "payment-tool-tip-close")
    private WebElement linkCloseWhatIsThis

    def fill_email_field() {
        element(fieldEmail).type("test1@speroteck.com");
    }

    def fill_first_name_field() {
        element(fieldFirstName).type("TestFirstName");
    }

    def fill_last_name_field() {
        element(fieldLastName).type("TestLastName");
    }

    def fill_address1_field() {
        element(fieldAddress1).type("Test Address1")
    }

    def fill_address2_field() {
        element(fieldAddress2).type("Test Address2")
    }

    def fill_city_field() {
        element(fieldCity).type("Test City");
    }

    def select_state() {
        element(selectState).selectByVisibleText("California")
    }

    def fill_postal_code_field() {
        element(fieldPostalCode).type("11111");
    }

    def fill_telephone_field() {
        element(fieldTelephone).type("1234567890")
    }

    def click_input_credit_cart() {
        element(inputCreditCart).click();
    }

    def fill_cart_name() {
        element(fieldCartName).type("Visa")
    }

    def fill_cart_number_field() {
        element(fieldCartNumber).type("4111111111111111")
    }

    def select_month() {
        element(selectMonth).selectByValue("3")
    }

    def select_year() {
        element(selectYear).selectByValue("2022");
    }

    def fill_verification_number_field() {
        element(fieldVerificationNumber).type("111")
    }

    def check_shipment() {
        element(shipment).waitUntilVisible();
        element(shipment).click();
    }

    def click_button_confirm_and_pay() {
        //element(loader).waitUntilVisible()
        element(loader).waitUntilNotVisible()
        element(buttonConfirmAndPay).click()
        waitForTextToAppear("Please review your information before submitting your order.")
    }

    def click_button_submit() {
        element(buttonSubmit).waitUntilVisible()
        element(buttonSubmit).click()
    }

    def click_on_link_already_register() {
        element(linkAlreadyRegister).click()
        element(fieldEmailPopUp).waitUntilVisible()
    }

    def type_data_to_login(String email, String pas) {
        element(fieldEmailPopUp).type(email)
        element(fieldPasswordPopUp).type(pas)
    }

    def click_login_button_pop_up() {
        element(buttonLoginPopUp).click()
    }

    def uncheck_checkbox_use_billing_for_shipping() {
        def f = checkboxUseBillingForShipping.getAttribute("checked")
        if(checkboxUseBillingForShipping.getAttribute("checked") != "checked" & checkboxUseBillingForShipping.getAttribute("checked") != null){
            element(checkboxUseBillingForShipping).click()
        }
    }

    def assert_data_copied_from_billing_to_shipping() {
        assert element(fieldFirstName).getText() == element(fieldFirstNameShipping).getText()
        assert element(fieldLastName).getText() == element(fieldLastNameShipping).getText()
        assertThat(element(fieldAddress1).getText(), equalTo(element(fieldAddress1Shipping).getText()))
        assertThat(element(fieldCity).getText(), equalTo(element(fieldCityShipping).getText()))
        assertThat(element(fieldPostalCode).getText(), equalTo(element(fieldPostalCodeShipping).getText()))
        assertThat(element(selectState).getSelectedVisibleTextValue(), equalTo(element(selectStateShipping).getSelectedVisibleTextValue()))
    }

    def click_on_link_What_is_this() {
        element(linkWhatIsThis).click()
        element(linkCloseWhatIsThis).waitUntilVisible()
    }

    def assert_what_is_this() {
        element(linkCloseWhatIsThis).shouldBeVisible()
        element(linkCloseWhatIsThis).click()
        element(linkCloseWhatIsThis).shouldNotBeVisible()
    }

    def fill_first_name_shipping_field() {
        element(fieldFirstNameShipping).type("First Name Shipping")
    }

    def fill_last_name_shipping_field() {
        element(fieldLastNameShipping).type("Last Name Shipping")
    }

    def fill_address1_shipping_field() {
        element(fieldAddress1Shipping).type("Address Shipping")
    }

    def fill_city_shipping_field() {
        element(fieldCityShipping).type("City Shipping")
    }

    def fill_postal_code_shipping_field() {
        element(fieldPostalCodeShipping).type("14000")
    }

    def fill_telephone_shipping_field() {
        element(fieldTelephoneShipping).type("555-555-5555")
    }

    def check_checkbox_save_address() {
        def r = checkboxSaveShippingAddress.getAttribute("checked")
        if(checkboxSaveShippingAddress.getAttribute("checked") == null){
            element(checkboxSaveShippingAddress).click()
        }
    }

    def select_add_new_address() {
        element(selectShippingAddress).waitUntilVisible()
        element(selectShippingAddress).selectByVisibleText("New Address")
    }
}
