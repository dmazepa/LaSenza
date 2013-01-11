package LaSenza.pages

import org.openqa.selenium.internal.Locatable
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.*

import static org.hamcrest.MatcherAssert.assertThat

class CLPage extends ForAllPage{

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

    @FindBy(xpath = "//h1/a")
    private WebElement linkProductName

    @FindBy(xpath = "//div[@class='category-products']//li/div/a[2]")
    private WebElement buttonQuickView

    @FindBy(xpath = "//a[contains(text(), 'View Full Details')]")
    private WebElement linkViewFullDetails

    @FindBy(xpath = "//div[@class='product-view']//a[@class='link-wishlist']")
    private WebElement linkAddToWishList

    @FindBy(xpath = "//h1")
    private WebElement titleCLP

    def open_quick_w(def i) {
        Locatable hoverItem = (Locatable) getDriver().findElement(By.xpath("//div[@class='category-products']//li[${i}]/div/a[1]"))
        Mouse mouse = ((HasInputDevices) driver).getMouse()
        mouse.mouseMove(hoverItem.getCoordinates())
        element(By.xpath("//div[@class='category-products']//li[${i}]/div/a[2]")).waitUntilVisible()
                .click()
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
        element(thumbnailImageQW).shouldBeVisible()
        element(thumbnailImageQW).shouldNotBeVisible()
    }

    def click_on_qw_element(String el) {
        if (el == "Brand Name"){
            element(linkBrandName).waitUntilVisible()
            element(linkBrandName).click()
        }else {
            if( el == "Product Name"){
                element(linkProductName).waitUntilVisible()
                element(linkProductName).click()
            }else {
                element(linkViewFullDetails).waitUntilVisible()
                element(linkViewFullDetails).click()
            }
        }
    }

    def click_on_add_to_wish_list() {
        element(linkAddToWishList).click()
    }

    def assert_on_CLP(String nameCLP) {
        assertThat(element(titleCLP).getText(), containsText(nameCLP.toUpperCase()))
    }
}
