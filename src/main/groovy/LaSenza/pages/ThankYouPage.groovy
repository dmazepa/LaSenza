package LaSenza.pages

import net.thucydides.core.annotations.DefaultUrl
import org.openqa.selenium.WebDriver

@DefaultUrl("http://localhost:9000//develop/checkout/onepage/success/")
class ThankYouPage extends ForAllPage{

    ThankYouPage(WebDriver driver){
        super(driver)
    }

    def assert_thank_you_page() {
        shouldContainText("Your order has been received.")
        shouldContainText("Thank you for your purchase!")
    }
}
