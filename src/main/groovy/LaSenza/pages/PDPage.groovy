package LaSenza.pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.Matchers.equalTo

class PDPage extends ForAllPage{

    PDPage(WebDriver driver){
        super(driver)
    }

    def colors = []
    def sizes = []
    def prices = []
    def names = []

    @FindBy(xpath = "//div[@class='product-name']/h1/a")
    private WebElement productName;

    @FindBy(xpath = "//div[@class='product-options-block']//div[@class='option-wrapper'][1]//select")
    private WebElement selectColor

    @FindBy(xpath = "//div[@class='product-options-block']//div[@class='option-wrapper'][2]//select")
    private WebElement selectSize

    @FindBy(xpath = "//span[@class='regular-price']/span")
    private WebElement textPrice

    @FindBy(xpath = "//a[@class='change']")
    private WebElement arrowSelectWishList

    @FindBy(xpath = "//div[@class='popup-message']/div[@class='content']")
    private WebElement popUpText

    @FindBy(xpath = "//div[@class='product-view']//button[@class='button btn-cart']")
    private WebElement buttonAddToCart

    @FindBy(xpath = "//div[@class='preloader-bg']")
    private WebElement preloader

    @FindBy(id = "qty")
    private WebElement fieldQTY

    @FindBy(xpath = "//a[@class='add-more-items']")
    private WebElement linkAddMoreItems

    @FindBy(xpath = "//fieldset[@class='product-options']/div[2]//div[@class='option-wrapper'][1]//select")
    private WebElement selectColor2

    @FindBy(xpath = "//fieldset[@class='product-options']/div[2]//div[@class='option-wrapper'][2]//select")
    private WebElement selectSize2

    def assert_on_PDP() {
        element(productName).waitUntilVisible()
        element(productName).shouldBePresent()
    }

    def click_add_to_cart_button() {
        element(buttonAddToCart).waitUntilVisible()
        element(buttonAddToCart).click()
        element(preloader).waitUntilVisible()
        element(preloader).waitUntilNotVisible()
    }

    def click_add_to_cart_button_expect_error() {
        element(buttonAddToCart).waitUntilVisible()
        element(buttonAddToCart).click()
    }

    def fill_qty(String qty) {
        typeInto(fieldQTY, qty)
    }

    def choose_configurable_options(int index) {
        if(getDriver().findElements(By.xpath("//div[@class='product-options-block']//div[@class='option-wrapper']")).size() != 0){
            element(selectColor).selectByIndex(index)
            element(selectSize).selectByIndex(index)
        }
    }

    def store_configurable_options() {
        colors[1] = element(selectColor).getSelectedVisibleTextValue()
        sizes[1] = element(selectSize).getSelectedVisibleTextValue()
        prices[1] = element(textPrice).getText()
        names[1] = element(productName).getText()
    }

    def add_to_wishlist_from_pdp(String nameWishlist) {
        def r = getDriver().findElement(By.xpath("//a[@class='change']"))
        element(arrowSelectWishList).click()
        getDriver().findElement(By.xpath("//span[@title='${nameWishlist}']")).click()
    }

    def contain_configurable_options() {
        return driver.findElements(By.xpath("//div[@class='product-options-block']//dd[2]//select")).size() != 0
    }

    def assert_modal_window(String textAlert) {
        element(popUpText).waitUntilVisible()
        assertThat(element(popUpText).getText(), containsText(textAlert))
    }

    def assert_most_recently_added_items_in_mini_cart() {
        for (def i=1; i <= 3; i++){
            element(getDriver().findElement(By.xpath("//ol[@id='mini-cart']/li[${i}]//p/a"))).waitUntilVisible()
            assertThat(getDriver().findElement(By.xpath("//ol[@id='mini-cart']/li[${i}]//p/a")).getText(), equalTo(names[4-i]))
            assertThat(getDriver().findElement(By.xpath("//ol[@id='mini-cart']/li[${i}]//div[@class='options'][1]/dd")).getText(), equalTo(colors[4-i]))
            assertThat(getDriver().findElement(By.xpath("//ol[@id='mini-cart']/li[${i}]//div[@class='options'][2]/dd")).getText(), equalTo(sizes[4-i]))
            assertThat(getDriver().findElement(By.xpath("//ol[@id='mini-cart']/li[${i}]//span[@class='price']")).getText(), equalTo(prices[4-i]))
        }
    }

    def add_3_items_to_cart(int id1, int id2, int id3) {
        def list = [0, id1, id2, id3]
        for (def i=1; i <= 3; i++){
            getDriver().get("${System.getProperty("webdriver.base.url")}catalog/product/view/id/${list[i]}")
            element(selectColor).selectByIndex(1)
            element(selectSize).selectByIndex(1)
            element(buttonAddToCart).waitUntilVisible()
            colors[i] = element(selectColor).getSelectedVisibleTextValue()
            sizes[i] = element(selectSize).getSelectedVisibleTextValue()
            prices[i] = element(textPrice).getText()
            names[i] = element(productName).getText()
            element(buttonAddToCart).click()
            element(preloader).waitUntilVisible()
            element(preloader).waitUntilNotVisible()
        }
    }

    def assert_most_recently_added_appears_first() {
        assertThat(getDriver().findElement(By.xpath("//ol[@id='mini-cart']/li[1]//p/a")).getText(), equalTo(names[3]))
        assertThat(getDriver().findElement(By.xpath("//ol[@id='mini-cart']/li[1]//div[@class='options'][1]/dd")).getText(), equalTo(colors[3]))
        assertThat(getDriver().findElement(By.xpath("//ol[@id='mini-cart']/li[1]//div[@class='options'][2]/dd")).getText(), equalTo(sizes[3]))
        assertThat(getDriver().findElement(By.xpath("//ol[@id='mini-cart']/li[1]//span[@class='price']")).getText(), equalTo(prices[3]))
    }

    def assert_button_update_cart() {
        assertThat(element(buttonAddToCart).getText(), equalTo("UPDATE CART"))
    }

    def set__and_store_multiple_product_conﬁgurations(def productNumber, def colorNumber, def sizeNumber) {
        element(linkAddMoreItems).click()
        element(By.xpath("//fieldset[@class='product-options']//div[${productNumber}]//div[@class='option-wrapper'][1]//select")).selectByIndex(colorNumber)
        element(By.xpath("//fieldset[@class='product-options']//div[${productNumber}]//div[@class='option-wrapper'][2]//select")).selectByIndex(sizeNumber)
        colors[productNumber] = element(By.xpath("//fieldset[@class='product-options']//div[${productNumber}]//div[@class='option-wrapper'][1]//select")).getSelectedVisibleTextValue()
        sizes[productNumber] = element(By.xpath("//fieldset[@class='product-options']//div[${productNumber}]//div[@class='option-wrapper'][2]//select")).getSelectedVisibleTextValue()
        prices[productNumber] = element(textPrice).getText()
        names[productNumber] = element(productName).getText()
    }
}
