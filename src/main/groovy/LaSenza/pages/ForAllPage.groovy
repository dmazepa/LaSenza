package LaSenza.pages

import net.thucydides.core.pages.PageObject
import org.openqa.selenium.WebDriver

class ForAllPage extends PageObject {
    ForAllPage(WebDriver driver) {
        super(driver)
    }

    def go_to(additionalUrl) {
        getDriver().get("${System.getProperty("webdriver.base.url")}/${additionalUrl}")
    }

}
