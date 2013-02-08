package LaSenza.pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

import static org.hamcrest.Matchers.equalTo
import static org.hamcrest.MatcherAssert.assertThat

class ShoppingCartPage extends ForAllPage{

    ShoppingCartPage(WebDriver driver){
        super(driver)
    }

    @FindBy(xpath = "//h1")
    private WebElement titleText

    def assert_on_shopping_cart_page() {
        assertThat(element(titleText).getText(), equalTo("SHOPPING CART"))
    }
}
