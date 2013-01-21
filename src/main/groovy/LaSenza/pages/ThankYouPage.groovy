package LaSenza.pages

import net.thucydides.core.annotations.DefaultUrl
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

@DefaultUrl("http://localhost:9000//develop/checkout/onepage/success/")
class ThankYouPage extends ForAllPage{

    private def orderNumber

    ThankYouPage(WebDriver driver){
        super(driver)
    }

    @FindBy (xpath = "//div[@class='order-date-block']//div[2]")
    private WebElement blockOrderNumber

    def assert_thank_you_page() {
        waitForTextToAppear("Your order has been received.")
        shouldContainText("Your order has been received.")
        shouldContainText("Thank you for your purchase!")
    }

    def setOrderNumber() {
        orderNumber = element(blockOrderNumber).getText()
    }
}
