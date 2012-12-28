package LaSenza.pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class StoreLocatorPage extends ForAllPage{

    StoreLocatorPage(WebDriver driver){
        super(driver)
    }

    @FindBy(id = "address")
    private WebElement inputAddress;

    def assert_on_store_locator_page() {
        element(inputAddress).shouldBeVisible()
    }
}
