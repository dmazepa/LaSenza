package LaSenza.pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

import static org.hamcrest.Matchers.equalTo
import static org.hamcrest.MatcherAssert.assertThat
import net.thucydides.core.annotations.DefaultUrl

@DefaultUrl("http://localhost:9000/checkout/cart/")
class ShoppingCartPage extends ForAllPage{

    ShoppingCartPage(WebDriver driver){
        super(driver)
    }

    @FindBy(xpath = "//h1")
    private WebElement titleText

    @FindBy(xpath = "//tr[@class='first last odd']//span[@class='cart-price']/span")
    private WebElement priceForOnlyOneItemCart

    @FindBy(xpath = "//tr[@class='first last odd']//input[@class='input-text qty']")
    private WebElement qtyForOnlyOneItemCart

    def assert_on_shopping_cart_page() {
        assertThat(element(titleText).getText(), equalTo("SHOPPING CART"))
    }

    def assert_qty_and_price_added_to_shopping_cart(def qty, def price) {
        assertThat(element(priceForOnlyOneItemCart).getText(), equalTo(price))
        assertThat(element(qtyForOnlyOneItemCart).getValue(), equalTo(qty))
    }
}
