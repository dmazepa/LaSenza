package LaSenza.pages

import org.openqa.selenium.Alert
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.By
import net.thucydides.core.annotations.DefaultUrl

import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.Matchers.equalTo

@DefaultUrl("http://localhost:9000/develop/customer/account/")
class MyAccountPage extends ForAllPage{

    MyAccountPage(WebDriver driver){
        super(driver)
    }

    @FindBy(id = "send2")
    private WebElement buttonLogin;

    @FindBy(id = "wishlist-create-button")
    private WebElement buttonCreateWishlist;

    @FindBy(id = "//a[contains(text(), 'Delete Address')]")
    private WebElement linkDeleteAddress;

    @FindBy(id = "//li[@class='success-msg']")
    private WebElement blockSuccessMSG;

    @FindBy(xpath = "//a[@title='Remove Item']")
    private WebElement buttonRemoveItemFromWishList;

    def assert_product_added_to_wishlist() {
        shouldContainText("Cotton Plunge Push Up Bra with Contrast Trim")
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

    def click_on_tab(nameTab) {
        driver.findElement(By.xpath("//a[contains(text(), '${nameTab}')]"))
        element(linkDeleteAddress).waitUntilVisible()
    }

    def assert_address_added() {
        assertThat(driver.findElements(By.xpath("//li[@class='item']")).size(), equalTo(1))
        shouldContainText("First Name Shipping Last Name Shipping")
        shouldContainText("Address Shipping")
        shouldContainText("City Shipping,  California, 14000")
        shouldContainText("T: 555-555-5555")
        while (driver.findElements(By.xpath("//a[contains(text(), 'Delete Address')]")).size() != 0){
            element(linkDeleteAddress).click()
            Alert alert = getDriver().switchTo().alert();
            alert.accept()
            element(blockSuccessMSG).waitUntilVisible()
        }
    }
}
