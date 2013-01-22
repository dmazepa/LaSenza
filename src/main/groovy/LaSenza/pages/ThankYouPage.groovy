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
        waitForTextToAppear("Thank you for your order")
        shouldContainText("Thank you for your order")
        shouldContainText("If you have questions about your order, we're happy to take your call.")
    }

    def setOrderNumber() {
        orderNumber = element(blockOrderNumber).getText()
    }
}
