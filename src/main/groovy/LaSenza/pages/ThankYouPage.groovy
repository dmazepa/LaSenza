package LaSenza.pages

import net.thucydides.core.annotations.DefaultUrl
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.Matchers.equalTo

@DefaultUrl("http://localhost:9000/checkout/onepage/success/")
class ThankYouPage extends ForAllPage {

    private def orderNumber

    ThankYouPage(WebDriver driver) {
        super(driver)
    }

    @FindBy(xpath = "//div[@class='order-date-block']//div[2]")
    private WebElement blockOrderNumber

    @FindBy(xpath = "//address")
    private WebElement billingAddress

    @FindBy(xpath = "//div[@class='buttons-set back-link']/a")
    private WebElement linkReturnToShopping

    @FindBy(xpath = "//h1")
    private WebElement textTitle

    def assert_thank_you_page() {
        element(linkReturnToShopping).waitUntilVisible()
        assertThat(element(textTitle).getText(), equalTo("THANK YOU FOR YOUR ORDER"))
        shouldContainText("THANK YOU FOR YOUR ORDER")
        shouldContainText("If you have questions about your order, we're happy to take your call.")
    }

    def setOrderNumber() {
        orderNumber = element(blockOrderNumber).getText()
    }

    def assert_correct_information_on_thank_you_page() {
        /* assertThat(billingAddress.getText(), equalTo("Test Tester\n" +
      "Address\n" +
      "Sacramento, California, 94203\n" +
      "United States\n" +
      "T: 555-555-5555 "))*/
        assertThat(billingAddress.getText(), equalTo("TestFirstName TestLastName\n" +
                "Test Address1\n" +
                "Test Address2\n" +
                "Test City, California, 11111\n" +
                "United States\n" +
                "T: 1234567890"))
    }

    def click_return_to_shopping() {
        element(linkReturnToShopping).click()
    }

    def waitForThankYouPage() {
        element(linkReturnToShopping).waitUntilVisible()
    }
}
