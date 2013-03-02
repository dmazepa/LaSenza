package LaSenza.pages

import net.thucydides.core.annotations.DefaultUrl
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.Matchers.equalTo

@DefaultUrl("http://localhost:9000/checkout/cart/")
class ShoppingCartPage extends ForAllPage {

    def colors
    def sizes
    def prices
    def names

    ShoppingCartPage(WebDriver driver) {
        super(driver)
    }

    @FindBy(xpath = "//div[@class='product-options-block']//div[@class='option-wrapper'][1]//select")
    private WebElement selectColor

    @FindBy(xpath = "//a[@class='edit']")
    private WebElement linkEdit

    @FindBy(xpath = "//div[@class='product-options-block']//div[@class='option-wrapper'][2]//select")
    private WebElement selectSize

    @FindBy(xpath = "//div[@class='quickview-wrapper']//span[@class='price']")
    private WebElement textPriceQV

    @FindBy(xpath = "//div[@class='quickview-wrapper']//h1/a")
    private WebElement textProductNameQV

    @FindBy(xpath = "//h1")
    private WebElement titleText

    @FindBy(xpath = "//tr[@class='first last odd']//span[@class='cart-price']/span")
    private WebElement priceForOnlyOneItemCart

    @FindBy(xpath = "//tr[@class='first last odd']//input[@class='input-text qty']")
    private WebElement qtyForOnlyOneItemCart

    @FindBy(id = "empty_cart_button")
    private WebElement buttonClearShoppingCart

    @FindBy(xpath = "//div[@class='cart-empty']//a")
    private WebElement linkContinueShoppingEmptyCart

    @FindBy(xpath = "//div[@class='crosssell']//div[@class='product-name']/a")
    private WebElement productNameCrossSell

    @FindBy(xpath = "//div[@class='product-image']/a/img")
    private WebElement productImageCrossSell

    def assert_on_shopping_cart_page() {
        assertThat(element(titleText).getText(), equalTo("SHOPPING CART"))
    }

    def assert_qty_and_price_added_to_shopping_cart(def qty, def price) {
        assertThat(element(priceForOnlyOneItemCart).getText(), equalTo(price))
        assertThat(element(qtyForOnlyOneItemCart).getValue(), equalTo(qty))
    }

    def assert_multiple_product_added_to_shopping_cart(ArrayList sizes, ArrayList colors, ArrayList names, ArrayList prices) {
        for (def i = 1; i <= 3; i++) {
            element(getDriver().findElement(By.xpath("//table[@id='shopping-cart-table']//tbody/tr[${i}]"))).waitUntilVisible()
            assertThat(getDriver().findElement(By.xpath("//table[@id='shopping-cart-table']//tbody/tr[${i}]//h2")).getText(), equalTo(names[i]))
            assertThat(getDriver().findElement(By.xpath("//table[@id='shopping-cart-table']//tbody/tr[${i}]//dd[1]")).getText(), equalTo(colors[i]))
            assertThat(getDriver().findElement(By.xpath("//table[@id='shopping-cart-table']//tbody/tr[${i}]//dd[2]")).getText(), equalTo(sizes[i]))
            assertThat(getDriver().findElement(By.xpath("//table[@id='shopping-cart-table']//tbody/tr[${i}]//span[@class='price']")).getText(), equalTo(prices[i]))
        }
    }

    def clear_shopping_cart() {
        if (getDriver().findElements(By.id("empty_cart_button")) != []) {
            element(buttonClearShoppingCart).click()
            element(linkContinueShoppingEmptyCart).waitUntilVisible()
        }
    }

    def assert_cross_sell(String nameCrossSell) {
        def actualNames = driver.findElements(By.xpath("//div[@class='crosssell']//div[@class='product-name']/a")).collect {WebElement el ->
            el.text
        }
        assert actualNames.contains(nameCrossSell)
    }

    def click_on_image_cross_sell() {
        element(productImageCrossSell).waitUntilVisible()
        element(productImageCrossSell).click()
    }

    def click_on_name_cross_sell() {
        element(productNameCrossSell).click()
    }

    def choose_configurable_options(int i) {
        if (getDriver().findElements(By.xpath("//div[@class='product-options-block']//div[@class='option-wrapper']")).size() != 0) {
            Thread.sleep(1000)
            element(selectColor).selectByIndex(i)
            element(selectSize).selectByIndex(i)
        }
    }

    def store_configurable_options() {
        colors = element(selectColor).getSelectedVisibleTextValue()
        sizes = element(selectSize).getSelectedVisibleTextValue()
        prices = element(textPriceQV).getText()
        names = element(textProductNameQV).getText()
    }

    def assert_item_added_to_cart() {
        def actualNames = driver.findElements(By.xpath("//h2[@class='product-name']/a")).collect {WebElement el ->
            el.text
        }
        def actualSizes = driver.findElements(By.xpath("//dl/dd[2]")).collect {WebElement el ->
            el.text
        }
        def actualColors = driver.findElements(By.xpath("//dl/dd[1]")).collect {WebElement el ->
            el.text
        }
        def actualPrices = driver.findElements(By.xpath("//span[@class='cart-price']/span")).collect {WebElement el ->
            el.text
        }
        assert actualColors.contains(colors)
        assert actualNames.contains(names)
        assert actualPrices.contains(prices)
        assert actualSizes.contains(sizes)
    }

    def assert_link_edit_on_shopping_cart_absent() {
        element(linkEdit).shouldNotBePresent()
    }
}
