package LaSenza.pages

import org.openqa.selenium.Alert
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.By

class MyAccountPage extends ForAllPage{

    MyAccountPage(WebDriver driver){
        super(driver)
    }

    @FindBy(id = "send2")
    private WebElement buttonLogin;

    @FindBy(id = "wishlist-create-button")
    private WebElement buttonCreateWishlist;

    @FindBy(xpath = "//a[@title='Remove Item']")
    private WebElement buttonRemoveItemFromWishList;

    def assert_product_added_to_wishlist() {
        shouldContainText("Strapless Convertible Bra")
    }

    def delete_items_from_wish_list() {
        while(getDriver().findElements(By.xpath("//a[@title='Remove Item']")) != [] ){
            element(buttonRemoveItemFromWishList).click()
            Alert alert = getDriver().switchTo().alert();
            alert.accept()
        }
    }

    def assert_on_my_account_dashboard_page() {
        shouldContainText("My Dashboard")
    }

    def assert_on_my_wishlist_page() {
        element(buttonCreateWishlist).shouldBeVisible()
    }
}
