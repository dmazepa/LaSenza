package LaSenza.pages

import net.thucydides.core.annotations.DefaultUrl
import org.openqa.selenium.Alert
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.Matchers.equalTo

@DefaultUrl("http://localhost:9000/customer/account/")
class MyAccountPage extends ForAllPage {

    MyAccountPage(WebDriver driver) {
        super(driver)
    }

    @FindBy(id = "wishlist-create-button")
    private WebElement buttonCreateWishlist;

    @FindBy(xpath = "//a[contains(text(), 'Delete Address')]")
    private WebElement linkDeleteAddress;

    @FindBy(xpath = "//li[@class='success-msg']")
    private WebElement blockSuccessMSG;

    @FindBy(xpath = "//h1")
    private WebElement titleText

    @FindBy(xpath = "//a[@title='Remove Item']")
    private WebElement buttonRemoveItemFromWishList;

    @FindBy(xpath = "//div[@id='wishlists-select']/a")
    private WebElement selectWishList

    def assert_product_added_to_wishlist(def productName) {
        shouldContainText(productName)
    }

    def delete_items_from_wish_list() {
        while (getDriver().findElements(By.xpath("//a[@title='Remove Item']")) != []) {
            element(buttonRemoveItemFromWishList).click()
            Alert alert = getDriver().switchTo().alert();
            alert.accept()
        }
    }

    def assert_on_my_account_dashboard_page() {
        element(titleText).shouldContainText("MY DASHBOARD")
    }

    def assert_on_my_wishlist_page() {
        element(buttonCreateWishlist).shouldBeVisible()
    }

    def click_on_tab(String nameTab) {
        if (titleText.getText() != nameTab) {
            driver.findElement(By.xpath("//a[contains(text(), '${nameTab}')]")).click()
            assert titleText.getText() == nameTab.toUpperCase()
        }

    }

    def assert_address_added() {
        assertThat(driver.findElements(By.xpath("//li[@class='item']")).size(), equalTo(1))
        shouldContainText("First Name Shipping Last Name Shipping")
        shouldContainText("Address Shipping")
        shouldContainText("City Shipping, British Columbia, 14000")
        shouldContainText("T: 555-555-5555")
    }

    def delete_additional_shipping_address() {
        while (driver.findElements(By.xpath("//a[contains(text(), 'Delete Address')]")).size() != 0) {
            element(linkDeleteAddress).click()
            Alert alert = getDriver().switchTo().alert();
            alert.accept()
            element(blockSuccessMSG).waitUntilVisible()
        }
    }

    def open_wish_list(String s) {
        element(selectWishList).click()
        element(By.xpath("//a[@title='${s}']")).waitUntilVisible()
        element(By.xpath("//a[@title='${s}']")).click()
    }
}
