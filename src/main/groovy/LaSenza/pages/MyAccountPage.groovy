package LaSenza.pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.By
import org.openqa.selenium.Alert

class MyAccountPage extends ForAllPage{

    MyAccountPage(WebDriver driver){
        super(driver)
    }

    @FindBy(id = "send2")
    private WebElement buttonLogin;

    @FindBy(xpath = "//a[@title='Remove Item']")
    private WebElement buttonRemoveItemFromWishList;

    def assert_product_added_to_wishlist() {
        shouldContainText("Test Configurable Product")
    }

    def delete_items_from_wish_list() {
        while(getDriver().findElements(By.xpath("//tbody/tr")) !=[] ){
            element(buttonRemoveItemFromWishList).click()
            Alert alert = getDriver().switchTo().alert();
            alert.accept()
        }
    }
}
