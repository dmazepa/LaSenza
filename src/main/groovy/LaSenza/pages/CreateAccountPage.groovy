package LaSenza.pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.WebElement

class CreateAccountPage extends ForAllPage{

    CreateAccountPage(WebDriver driver){
        super(driver)
    }

    @FindBy(id = "firstname")
    private WebElement inputFirstName;

    def assert_on_create_account_page() {
        element(inputFirstName).shouldBeVisible()
    }
}
