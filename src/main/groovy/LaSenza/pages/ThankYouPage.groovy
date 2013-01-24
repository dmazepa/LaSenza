package LaSenza.pages

import net.thucydides.core.annotations.DefaultUrl
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.Matchers.equalTo

@DefaultUrl("http://localhost:9000/checkout/onepage/success/")
class ThankYouPage extends ForAllPage{

    private def orderNumber

    ThankYouPage(WebDriver driver){
        super(driver)
    }

    @FindBy (xpath = "//div[@class='order-date-block']//div[2]")
    private WebElement blockOrderNumber

    @FindBy (xpath = "//address")
    private WebElement billingAddress

    @FindBy (xpath = "//div[@class='buttons-set']/a")
    private WebElement linkReturnToShopping

    def assert_thank_you_page() {
        waitForTextToAppear("Thank you for your order")
        shouldContainText("Thank you for your order")
        shouldContainText("If you have questions about your order, we're happy to take your call.")
    }

    def setOrderNumber() {
        orderNumber = element(blockOrderNumber).getText()
    }

    def assert_correct_information_on_thank_you_page() {
        assert billingAddress.getText() == "Test Tester\n" +
                "Address\n" +
                "Sacramento, California, 94203\n" +
                "United States\n" +
                "T: 555-555-5555 "
        assertThat(billingAddress.getText(), equalTo("Test Tester\n" +
                "Address\n" +
                "Sacramento, California, 94203\n" +
                "United States\n" +
                "T: 555-555-5555 "))
    }

    def click_return_to_shopping() {
        element(linkReturnToShopping).click()
    }
}
