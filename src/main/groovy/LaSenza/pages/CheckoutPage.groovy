package LaSenza.pages

import net.thucydides.core.annotations.DefaultUrl
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

@DefaultUrl("http://localhost:9000/develop/checkout/onepage/")
class CheckoutPage extends ForAllPage{

    CheckoutPage(WebDriver driver){
        super(driver)
    }

    @FindBy(id = "contact:email")
    private WebElement fieldEmail

    @FindBy(id = "billing:firstname")
    private WebElement fieldFirstName

    @FindBy(id = "billing:lastname")
    private WebElement fieldLastName

    @FindBy(id = "billing:street1")
    private WebElement fieldAddress1

    @FindBy(id = "billing:street2")
    private WebElement fieldAddress2

    @FindBy(id = "billing:city")
    private WebElement fieldCity

    @FindBy(id = "billing:region_id")
    private WebElement selectState

    @FindBy(id = "billing:postcode")
    private WebElement fieldPostalCode

    @FindBy(id = "billing:telephone")
    private WebElement fieldTelephone

    @FindBy(id = "ccsave_cc_number")
    private WebElement fieldCartNumber

    @FindBy(id = "ccsave_expiration")
    private WebElement selectMonth

    @FindBy(id = "ccsave_expiration_yr")
    private WebElement selectYear

    @FindBy(id = "ccsave_cc_owner")
    private WebElement fieldCartName

    @FindBy(id = "ccsave_cc_cid")
    private WebElement fieldVerificationNumber

    @FindBy(name = "shipping_method")
    private WebElement shipment

    @FindBy(xpath = "//input[@value='VI']")
    private WebElement inputCreditCart

    @FindBy(xpath = "//button[@class='button btn-checkout']")
    private WebElement buttonConfirmAndPay

    @FindBy(xpath = "//button[@class='confirm button btn-checkout-submit']")
    private WebElement buttonSubmit

    @FindBy(xpath = "//img[@class='v-middle']")
    private WebElement loader

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
        element(loader).waitUntilNotVisible()
        element(buttonConfirmAndPay).click()
        waitForTextToAppear("Please review your information before submitting your order.")
    }

    def click_button_submit() {
        element(buttonSubmit).click()
    }
}
