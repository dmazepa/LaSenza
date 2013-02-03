package LaSenza.pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.Alert

import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.Matchers.equalTo

class PDPage extends ForAllPage{

    PDPage(WebDriver driver){
        super(driver)
    }

    def color
    def size

    @FindBy(xpath = "//div[@class='product-name']/h1/a")
    private WebElement productName;

    @FindBy(xpath = "//div[@class='product-options-block']//div[@class='option-wrapper'][1]//select")
    private WebElement selectColor;

    @FindBy(xpath = "//div[@class='product-options-block']//div[@class='option-wrapper'][2]//select")
    private WebElement selectSize;

    @FindBy(xpath = "//button[@title='Add to Cart']")
    private WebElement buttonAddToCart;

    @FindBy(xpath = "//div[@class='preloader-bg']")
    private WebElement preloader

    @FindBy(id = "qty")
    private WebElement fieldQTY;


    def assert_on_PDP() {
        element(productName).waitUntilVisible()
        element(productName).shouldBePresent()
    }

    def click_add_to_cart_button() {
        element(buttonAddToCart).click()
        element(preloader).waitUntilVisible()
        element(preloader).waitUntilNotVisible()
    }

    def click_add_to_cart_button_expect_error() {
        element(buttonAddToCart).click()
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

    def contain_configurable_options() {
        return driver.findElements(By.xpath("//div[@class='product-options-block']//dd[2]//select")).size() != 0
    }

    def assert_modal_window(String textAlert) {
        Thread.sleep(2000)
        Alert alert = getDriver().switchTo().alert();
        assertThat(alert.getText(), equalTo(textAlert))
        alert.accept()
    }
}
