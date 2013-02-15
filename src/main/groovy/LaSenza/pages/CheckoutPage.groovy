package LaSenza.pages

import net.thucydides.core.annotations.DefaultUrl
import org.openqa.selenium.HasInputDevices
import org.openqa.selenium.Mouse
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.internal.Locatable
import org.openqa.selenium.support.FindBy

import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.Matchers.equalTo
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.By

@DefaultUrl("http://localhost:9000/checkout/onepage/")
class CheckoutPage extends ForAllPage{

    CheckoutPage(WebDriver driver){
        super(driver)
    }

    @FindBy(id = "contact:email")
    private WebElement fieldEmail

    @FindBy(xpath = "//input[@id='p_method_paypal_express']")
    private WebElement inputPayPallMethod

    @FindBy(xpath = "//input[@id='login_email']")
    private WebElement fieldPayPallEmail

    @FindBy(xpath = "//input[@id='esignOpt']")
    private WebElement inputPayPallAgree

    @FindBy(xpath = "//input[@id='login_password']")
    private WebElement fieldPayPallPassword

    @FindBy(xpath = "//input[@id='submitLogin']")
    private WebElement buttonPayPallLogin

    @FindBy(xpath = "//input[@id='agree']")
    private WebElement buttonPayPallAgree

    @FindBy(xpath = "//input[@id='continue_abovefold']")
    private WebElement buttonPayPallContinue

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

    @FindBy(id= "p_method_moneriscc")
    private WebElement inputPaymentMethodCreditCart

    @FindBy(xpath = "//input[@class='checkbox create_an_account']")
    private WebElement checkboxCreateAccount

    @FindBy(xpath = "//input[@id='contact:customer_password']")
    private WebElement fieldPassword

    @FindBy(xpath = "//button[@class='button btn-checkout']")
    private WebElement buttonConfirmAndPay

    @FindBy(id = "coupon")
    private WebElement fieldCoupon

    @FindBy(xpath = "//button[@class='button apply gray coupon-btn']")
    private WebElement buttonApplyCoupon

    @FindBy(xpath = "//div[@class='footer-wrapper discount']")
    private WebElement blockDiscountCouponTotals

    @FindBy(xpath = "//button[@class='confirm button btn-checkout-submit']")
    private WebElement buttonSubmit

    @FindBy(xpath = "//input[@id='contact:confirm_password']")
    private WebElement fieldConfirmPassword

    @FindBy(id = "advice-validate-cpassword-contact:confirm_password")
    private WebElement errorMessageWrongPassword

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

    @FindBy(xpath = "//div[@id='checkout-step-shipping_method']//img")
    private WebElement loaderShipment

    @FindBy(xpath = "//div[@class='checkitout-checkout-loading']//img")
    private WebElement loaderSubmittingOrder

    @FindBy(xpath = "//div[@id='checkout-step-payment']//img[@title='Loading step data...']")
    private WebElement loaderPayment

    @FindBy(xpath = "//a[@class='cvv-what-is-this']")
    private WebElement linkWhatIsThis

    @FindBy(id = "payment-tool-tip-close")
    private WebElement linkCloseWhatIsThis

    def fill_email_field(String email) {
        element(fieldEmail).type(email);
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

    def fill_city_field(def city) {
        element(fieldCity).type(city);
    }

    def select_state() {
        element(selectState).selectByVisibleText("California")
    }

    def fill_postal_code_field(def zipCode) {
        element(fieldPostalCode).type(zipCode);
    }

    def fill_telephone_field() {
        element(fieldTelephone).type("1234567890")
    }

    def click_input_credit_cart(def cartType) {
        element(loaderPayment).waitUntilNotVisible()
        element(inputPaymentMethodCreditCart).click()
        element(loaderPayment).waitUntilNotVisible()
        element(By.xpath("//input[@value='${cartType}']")).click()
    }

    def fill_cart_name(def cartName) {
        element(loaderPayment).waitUntilVisible()
        element(loaderPayment).waitUntilNotVisible()
        element(fieldCartName).type(cartName)
    }

    def fill_cart_number_field(def cartNumber) {
        element(loaderPayment).waitUntilNotVisible()
        element(fieldCartNumber).type(cartNumber)
    }

    def select_month() {
        element(loaderPayment).waitUntilNotVisible()
        element(selectMonth).selectByValue("3")
    }

    def select_year() {
        element(loaderPayment).waitUntilNotVisible()
        element(selectYear).selectByValue("2022");
    }

    def fill_verification_number_field(def verificationNumber) {
        element(loaderPayment).waitUntilNotVisible()
        element(fieldVerificationNumber).type(verificationNumber)
    }

    def check_shipment() {
        element(shipment).waitUntilVisible()
        element(loaderShipment).waitUntilNotVisible()
        Thread.sleep(3000)
        element(shipment).click();
    }

    def click_button_confirm_and_pay() {
        Thread.sleep(3000)
        Mouse mouse = ((HasInputDevices) driver).getMouse()
        Locatable hoverItem = (Locatable) buttonConfirmAndPay
        mouse.click(hoverItem.getCoordinates())
        waitForTextToAppear("Please review your information before submitting your order.")
    }

    def click_button_submit() {
        element(loaderSubmittingOrder).waitUntilNotVisible()
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
        element(linkWhatIsThis).waitUntilVisible()
        element(loader).waitUntilNotVisible()
        Thread.sleep(2000)
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
        if(checkboxSaveShippingAddress.getAttribute("checked") == null){
            element(checkboxSaveShippingAddress).click()
        }
    }

    def select_add_new_address() {
        element(selectShippingAddress).waitUntilVisible()
        element(selectShippingAddress).selectByVisibleText("New Address")
    }

    def create_account(def pass, def confirmPass) {
        element(checkboxCreateAccount).click()
        element(fieldPassword).waitUntilVisible()
        element(fieldPassword).type(pass)
        element(fieldConfirmPassword).type(confirmPass)
    }

    def click_button_confirm_and_pay_via_javascript() {
        Thread.sleep(4000)
        ((JavascriptExecutor) driver).executeScript('review.save()')
    }

    def assert_error_message_wrong_password() {
        element(errorMessageWrongPassword).shouldBeVisible()
    }

    def click_on_edit_link(def element1, def counter) {
        getDriver().findElement(By.xpath("//div[@class='review-block-left']/div[${counter}]//button")).click()
    }

    def assert_on_checkout_page() {
        element(buttonConfirmAndPay).shouldBeVisible()
    }

    def enter_coupon(String couponCode) {
        element(fieldCoupon).type(couponCode)
    }

    def click_apply_coupon() {
        element(buttonApplyCoupon).click()
    }

    def coupon_discount_appears_in_grand_total() {
        element(blockDiscountCouponTotals).shouldBeVisible()
        shouldContainText("AutoTestCoupon (12345)")
    }

    def message_appears_promo_code_applied() {
        shouldContainText("AutoTestCoupon (12345) has been applied to your order.")
    }

    def assert_logged_in() {
        element(fieldEmail).shouldNotBeVisible()
    }

    def check_pay_pal_method() {
        element(loaderShipment).waitUntilNotVisible()
        element(inputPayPallMethod).click()
    }

    def pass_pay_pall_process() {
        element(fieldPayPallEmail).waitUntilVisible()
        element(fieldPayPallEmail).type("vovik_1324330788_per@speroteck.com")
        element(fieldPayPallPassword).type("359728798")
        element(buttonPayPallLogin).click()
        element(inputPayPallAgree).waitUntilVisible()
        element(inputPayPallAgree).click()
        element(buttonPayPallAgree).click()
        element(buttonPayPallContinue).waitUntilVisible()
        element(buttonPayPallContinue).click()
    }
}
