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
}
