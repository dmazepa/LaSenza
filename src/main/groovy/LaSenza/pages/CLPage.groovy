package LaSenza.pages

import org.openqa.selenium.internal.Locatable
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.*
import org.openqa.selenium.interactions.Actions

import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.Matchers.equalTo

class CLPage extends ForAllPage{

    private def productName

    CLPage(WebDriver driver){
        super(driver)
    }

    @FindBy(xpath = "//h1/a")
    private WebElement linkQWProductName;

    @FindBy(xpath = "//a[@class='popup-close']")
    private WebElement buttonQWClose

    @FindBy(xpath = "//div[@class='more-views']/ul/li")
    private WebElement thumbnailImageQW

    @FindBy(xpath = "//div[@class='brand-name']/a")
    private WebElement linkBrandName

    @FindBy(xpath = "//h1/a")
    private WebElement linkProductName

    @FindBy(xpath = "//div[@class='category-products']//li/div/a[2]")
    private WebElement buttonQuickView

    @FindBy(xpath = "//a[contains(text(), 'View Full Details')]")
    private WebElement linkViewFullDetails

    @FindBy(xpath = "//span[contains(text(), 'Add to Wishlist')]")
    private WebElement linkAddToWishList

    @FindBy(xpath = "//h1")
    private WebElement titleCLP

    @FindBy(xpath = "//div/div")
    private WebElement elementOutsideQW

    @FindBy(xpath = "//div[@class='option-wrapper'][2]//select")
    private WebElement selectSizeFirstQV

    @FindBy(xpath = "//a[@class='add-more-items']")
    private WebElement linkAddMoreItemsQV

    @FindBy(xpath = "//div//select")
    private WebElement selectColorFirstQV

    def open_quick_w(def i) {
        Locatable hoverItem = (Locatable) getDriver().findElement(By.xpath("//div[@class='category-products']//li[${i}]/div/a[1]"))
        Mouse mouse = ((HasInputDevices) driver).getMouse()
        mouse.mouseMove(hoverItem.getCoordinates())
        element(By.xpath("//div[@class='category-products']//li[${i}]/div/a[2]")).waitUntilVisible()
                .click()
        element(buttonQWClose).waitUntilVisible()
    }

    def set_product_name(def i) {
        this.productName = element(By.xpath("//div[@class='category-products']//li[${i}]/h2/a")).getText()
    }

    final def get_product_name() {
        return this.productName
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
        //element(thumbnailImageQW).shouldBeVisible()
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
        element(linkAddToWishList).waitUntilVisible()
        element(linkAddToWishList).click()
    }

    def assert_on_CLP(String nameCLP) {
        assert element(titleCLP).getText().contains(nameCLP.toUpperCase())
    }


    def click_outside_qw() {
        Actions clicker = new Actions(driver);
        clicker.moveToElement(buttonQWClose).moveByOffset(-10, 300).click().perform();
        element(elementOutsideQW).click()
    }

    def assert_select_size_disable_QV() {
        element(selectSizeFirstQV).shouldNotBeEnabled()
    }

    def assert_QTY_field_prefilled_QV(def fieldPosition, String value) {
        assertThat(getDriver().findElement(By.xpath("//fieldset/div[${fieldPosition}]//input")).getAttribute("value"), equalTo(value))
    }

    def assert_two_rows_of_additional_products_opened_QV() {
        assertThat(getDriver().findElements(By.xpath("//fieldset/div")).size(), equalTo(2))
    }

    def assert_QTY_third_row_prefilled_QV() {
        assertThat(getDriver().findElement(By.xpath("//fieldset/div[3]//input")).getAttribute("value"), equalTo("1"))
    }

    def add_row_additional_product_QV() {
        def additionalProductsQuantity = getDriver().findElements(By.xpath("//fieldset/div")).size()
        element(linkAddMoreItemsQV).click()
        element(By.xpath("//fieldset/div[${additionalProductsQuantity+1}]")).waitUntilVisible()
    }

    def set_QTY_additional_products_QV(String rowNumber, String value) {
        element(By.xpath("//fieldset/div[${rowNumber}]//input")).type(value)
    }

    def select_color_first_row_QV() {
        element(selectColorFirstQV).selectByIndex(1)
    }

    def assert_select_size_first_row_enabled_QV() {
        element(selectSizeFirstQV).shouldBeEnabled()
    }
}
