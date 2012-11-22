package LaSenza.pages

import net.thucydides.core.annotations.DefaultUrl
import org.openqa.selenium.WebDriver
import net.thucydides.core.pages.PageObject

@DefaultUrl("http://localhost:9000/dev01")
class HomePage extends PageObject{

    HomePage(WebDriver driver){
        super(driver)
    }
}
