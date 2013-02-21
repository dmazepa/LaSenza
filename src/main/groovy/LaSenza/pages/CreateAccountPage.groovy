package LaSenza.pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class CreateAccountPage extends ForAllPage {

    CreateAccountPage(WebDriver driver) {
        super(driver)
    }

    @FindBy(id = "firstname")
    private WebElement inputFirstName;

    def assert_on_create_account_page() {
        element(inputFirstName).shouldBeVisible()
    }

    def fill_field_first_name() {
        element(inputFirstName).type("First Name")
    }

    def fill_field_last_name() {

    }
}
