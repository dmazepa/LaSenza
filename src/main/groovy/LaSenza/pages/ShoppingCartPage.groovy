package LaSenza.pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

import static org.hamcrest.Matchers.equalTo
import static org.hamcrest.MatcherAssert.assertThat
import net.thucydides.core.annotations.DefaultUrl
import org.openqa.selenium.By

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

    def assert_multiple_product_added_to_shopping_cart(ArrayList sizes, ArrayList colors, ArrayList names, ArrayList prices) {
        for (def i=1; i <= 3; i++){
            element(getDriver().findElement(By.xpath("//table[@id='shopping-cart-table']//tbody/tr[${i}]"))).waitUntilVisible()
            assertThat(getDriver().findElement(By.xpath("//table[@id='shopping-cart-table']//tbody/tr[${i}]//h2")).getText(), equalTo(names[4-i]))
            assertThat(getDriver().findElement(By.xpath("//table[@id='shopping-cart-table']//tbody/tr[${i}]//dd[1]")).getText(), equalTo(colors[4-i]))
            assertThat(getDriver().findElement(By.xpath("//table[@id='shopping-cart-table']//tbody/tr[${i}]//dd[2]")).getText(), equalTo(sizes[4-i]))
            assertThat(getDriver().findElement(By.xpath("//table[@id='shopping-cart-table']//tbody/tr[${i}]//span[@class='price']")).getText(), equalTo(prices[4-i]))
        }
    }
}
