package LaSenza.pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.Alert

class PDPage extends ForAllPage{

    PDPage(WebDriver driver){
        super(driver)
    }

    @FindBy(xpath = "//div[@class='product-name']/h1/a")
    private WebElement productName;

    @FindBy(xpath = "//button[@class='button btn-cart']")
    private WebElement buttonAddToCart;


    def assert_on_PDP() {
        element(productName).waitUntilVisible()
        element(productName).shouldBePresent()
    }

    def click_add_to_cart_button() {
        element(buttonAddToCart).click()
        Thread.sleep(2000)
        Alert alert = getDriver().switchTo().alert();
        alert.accept()
    }
}
