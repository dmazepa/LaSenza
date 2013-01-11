package LaSenza.pages

import org.openqa.selenium.Alert
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class PDPage extends ForAllPage{

    PDPage(WebDriver driver){
        super(driver)
    }

    def color
    def size

    @FindBy(xpath = "//div[@class='product-name']/h1/a")
    private WebElement productName;

    @FindBy(xpath = "//div[@class='product-options-block']//dd[1]//select")
    private WebElement selectColor;

    @FindBy(xpath = "//div[@class='product-options-block']//dd[2]//select")
    private WebElement selectSize;

    @FindBy(xpath = "//button[@class='button btn-cart']")
    private WebElement buttonAddToCart;

    @FindBy(id = "qty")
    private WebElement fieldQTY;


    def assert_on_PDP() {
        element(productName).waitUntilVisible()
        element(productName).shouldBePresent()
    }

    def click_add_to_cart_button() {
        element(buttonAddToCart).click()
        Thread.sleep(3000)
        Alert alert = getDriver().switchTo().alert();
        alert.accept()
    }

    def fill_qty(String qty) {
        typeInto(fieldQTY, qty)
    }

    def choose_configurable_options() {
        element(selectColor).selectByIndex(1)
        element(selectSize).selectByIndex(1)
    }

    def store_configurable_options() {
        color = element(selectColor).getSelectedValue()
        size = element(selectSize).getSelectedValue()
    }

    def add_to_wishlist_from_pdp(String nameWishlist) {

    }
}
