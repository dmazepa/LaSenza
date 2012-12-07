package LaSenza.pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.Keys

class CLPage extends HomePage{

    CLPage(WebDriver driver){
        super(driver)
    }

    @FindBy(xpath = "//h1/a")
    private WebElement linkQWProductName;

    @FindBy(xpath = "//a[@class='popup-close']")
    private WebElement buttonQWClose

    @FindBy(xpath = "//div[@class='more-views']/ul/li")
    private WebElement thumbnailImageQW

    @FindBy(xpath = "//a/a/a")
    private WebElement linkBrandName

    @FindBy(xpath = "//a[contains(text(), 'Test Simple Product')]")
    private WebElement linkProductName

    @FindBy(xpath = "//a[contains(text(), 'View Full Details')]")
    private WebElement linkViewFullDetails

    @FindBy(xpath = "//div[@class='product-view']//a[@class='link-wishlist']")
    private WebElement linkAddToWishList

    def open_quick_w(def i) {
        getDriver().findElement(By.xpath("//div[@class='category-products']//li[${i}]/a[2]")).click()
    }

    def send_esc_key() {
        element(linkQWProductName).waitUntilVisible()
        linkQWProductName.sendKeys(Keys.ESCAPE)
    }

    def qw_should_be_absent() {
        element(linkQWProductName).shouldNotBeVisible()
    }

    def click_close_button() {
        element(buttonQWClose).click()
    }

    def qw_should_not_have_thumbnail_images() {
        element(thumbnailImageQW).shouldNotBeVisible()
    }

    def click_on_qw_element(String el) {
        if (el == "Brand Name"){
           element(linkBrandName).click()
        }else {
            if( el == "Product Name"){
                element(linkProductName).waitUntilVisible()
                element(linkProductName).click()
            }else {
                element(linkViewFullDetails).click()
            }
        }
    }

    def click_on_add_to_wish_list() {
        element(linkAddToWishList).click()
    }
}
