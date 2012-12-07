package LaSenza.pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class PDPage extends HomePage{

    PDPage(WebDriver driver){
        super(driver)
    }

    @FindBy(xpath = "//div[@class='product-name']/h1/a")
    private WebElement productName;


    def assert_on_PDP() {
        element(productName).waitUntilVisible()
        element(productName).shouldBePresent()
    }
}
