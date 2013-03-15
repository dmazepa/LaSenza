package LaSenza.pages

import net.thucydides.core.annotations.DefaultUrl
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.Matchers.equalTo
import static org.hamcrest.Matchers.greaterThan

@DefaultUrl("http://localhost:9000/checkout/cart/")
class ShoppingCartPage extends ForAllPage {

    def colors
    def sizes
    def prices
    def names
    String  firstQuote
    def firstQuotePrice

    ShoppingCartPage(WebDriver driver) {
        super(driver)
    }

    @FindBy(xpath = "//div[@class='product-options-block']//div[@class='option-wrapper'][1]//select")
    private WebElement selectColor

    @FindBy(xpath = "//a[@class='edit']")
    private WebElement linkEdit

    @FindBy(linkText = "Remove item")
    private WebElement linkRemove

    @FindBy(xpath = "//div[@class='cart-empty']//a")
    private WebElement linkClickHere

    @FindBy(xpath = "//div[@class='vip-program-static-block']/a")
    private WebElement linkSignUp

    @FindBy(id = "coupon_code")
    private WebElement fieldCouponCode

    @FindBy(xpath = "//button[@value='Apply Coupon']")
    private WebElement buttonApplyCouponCode

    @FindBy(xpath = "//form[@id='giftcard-form']//button")
    private WebElement buttonApplyGiftCard

    @FindBy(xpath = "//button[@value='Check gift card status and balance']")
    private WebElement linkCheckGiftCard

    @FindBy(xpath = "//button[@class='button btn-continue']")
    private WebElement linkContinueShopping

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

    @FindBy(xpath = "//li[@class='error-msg']//span")
    private WebElement textMessage

    @FindBy(id = "country")
    private WebElement selectCountry

    @FindBy(id = "region_id")
    private WebElement selectRegion

    @FindBy(id = "postcode")
    private WebElement fieldZIP

    @FindBy(xpath = "//div[@class='buttons-set']/button")
    private WebElement buttonGetQuote

    @FindBy(name = "estimate_method")
    private WebElement inputFirstQuote

    @FindBy(name = "do")
    private WebElement buttonUpdateTotal

    @FindBy(xpath = "//form[@id='co-shipping-method-form']//li[1]/label")
    private WebElement textFirstQuote

    @FindBy(xpath = "//form[@id='co-shipping-method-form']//li[1]/label/span")
    private WebElement textFirstQuotePrice

    @FindBy(xpath = "//div[@class='totals-wrapper']/div[2]")
    private WebElement textShippingTotals

    @FindBy(xpath = "//div[@class='totals-wrapper']/div[4]")
    private WebElement textTaxTotals

    @FindBy(xpath = "//div[@class='footer-wrapper grandtotal']//span")
    private WebElement priceGrandTotal

    @FindBy(xpath = "//div[@class='totals-wrapper']/div[1]//span")
    private WebElement priceSubTotal

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

    def click_on_checkout_button_in_area(String Element) {
        element(By.xpath("//div[@class='${Element}']//button")).click()
    }

    def click_on_remove() {
        element(linkRemove).click()
    }

    def assert_empty_cart() {
        element(linkClickHere).shouldBeVisible()
    }

    def click_continue_shopping() {
        element(linkContinueShopping).click()
    }

    def click_on_link_click_here() {
        element(linkClickHere).click()
    }

    def click_on_element(String Element) {
        if(Element == "product-image" || Element == "edit"){
            getDriver().findElement(By.xpath(".//*[@class='${Element}']")).click()
        } else {
            getDriver().findElement(By.xpath("//table[@id='shopping-cart-table']//*[@class='${Element}']/a")).click()
        }
        Thread.sleep(10000)
    }

    def click_sign_up_link() {
        element(linkSignUp).click()
    }

    def assert_on_prestige_registration_page() {
        assertThat(getDriver().getTitle(), equalTo("Prestige registration page"))
    }

    def enter_coupon(String code) {
        element(fieldCouponCode).type(code)
    }

    def click_apply_coupon() {
        element(buttonApplyCouponCode).click()
    }

    def assert_error_message() {
        assertThat(element(textMessage).getText(), equalTo("COUPON CODE \"123456\" IS NOT VALID."))
    }

    def click_apply_gift_card() {
        element(buttonApplyGiftCard).click()
    }

    def click_check_gift_card() {
        element(linkCheckGiftCard).click()
    }

    def enter_data_for_shipping_shopping_cart() {
        element(selectCountry).selectByVisibleText("United States")
        element(selectRegion).selectByVisibleText("California")
        element(fieldZIP).type("94302")
    }

    def click_button_get_quote() {
        element(buttonGetQuote).click()
        element(inputFirstQuote).waitUntilVisible()
    }

    def assert_quotes_appeared() {
        assertThat(getDriver().findElements(By.name("estimate_method")).size(), greaterThan(0))
    }

    def select_shipping_and_update_total_shopping_cart() {
        element(inputFirstQuote).click()
        firstQuote = element(textFirstQuote).getText().replaceAll("([-,() <>])","")
        firstQuotePrice = element(textFirstQuotePrice).getText().replaceAll("\\D", "")
        element(buttonUpdateTotal).click()
    }

    def assert_total_updated_shopping_cart() {
        assertThat(element(textShippingTotals).getText().replaceAll("([<>\\n() ])", ""), equalTo("Shipping"+firstQuote))
        assertThat(element(priceGrandTotal).getText().replaceAll("\\D", "").toInteger(),
                equalTo(priceSubTotal.getText().replaceAll("\\D","").toInteger() +
                textFirstQuotePrice.getText().replaceAll("\\D", "").toInteger()+
                textTaxTotals.getText().replaceAll("\\D", "").toInteger()))
    }

    def getTextShipping() {
        return firstQuote
    }

    def getTextTax() {
        return textTaxTotals.getText()
    }

    def getTextShippingTotals() {
        return textShippingTotals.getText()
    }

    def getTextGrandTotalPrice() {
        return priceGrandTotal.getText()
    }
}
