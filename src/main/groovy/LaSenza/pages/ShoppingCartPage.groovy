package LaSenza.pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class ShoppingCartPage extends ForAllPage{

    ShoppingCartPage(WebDriver driver){
        super(driver)
    }

    @FindBy(id = "firstname")
    private WebElement inputFirstName;

    def assert_on_create_account_page() {
        element(inputFirstName).shouldBeVisible()
    }
}
