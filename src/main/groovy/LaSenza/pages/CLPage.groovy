package LaSenza.pages

import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.internal.Locatable
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.*

import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.Matchers.equalTo

class CLPage extends ForAllPage{

    private def productName
    def qtyPages

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

    @FindBy(xpath = "//a[contains(text(), 'View Full Details')]")
    private WebElement linkViewFullDetails

    @FindBy(xpath = "//span[contains(text(), 'Add to Wishlist')]")
    private WebElement linkAddToWishList

    @FindBy(xpath = "//a[contains(text(), 'Add to Wishlist')]")
    private WebElement linkAddToWishListUser

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

    @FindBy(xpath = "//a[@title='Next']")
    private WebElement arrowRightNext

    @FindBy(xpath = "//a[@title='Previous']")
    private WebElement arrowLeftPrevious

    @FindBy(xpath = "//div[@class='pages']//a[contains(text(), '2')]")
    private WebElement linkSecondPage

    @FindBy(xpath = "//div[@class='pages']//a[contains(text(), '4')]")
    private WebElement linkFoursPage

    @FindBy(xpath = "//div[@class='pages']//a[contains(text(), '1')]")
    private WebElement linkFirstPage

    @FindBy(xpath = "//li[@class='current']")
    private WebElement textNumberCurrentPage

    @FindBy(xpath = "//div[@class='pager']//a[@class='sbSelector']")
    private WebElement selectItemsPerPage

    @FindBy(xpath = "//div[@class='sorter']//a[@class='sbSelector']")
    private WebElement selectSortByCurrent

    @FindBy(xpath = "//div[@class='col-left sidebar']")
    private WebElement blockLeftNavigation

    @FindBy(xpath = "//div[@class='category-products']//li/div/a[2]")
    private WebElement buttonQuickView


    def click_on_button_quick_view(def i) {
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

    def click_on_add_to_wish_list_user() {
        element(linkAddToWishListUser).click()
    }

    def assert_only_right_row_present() {
        element(arrowRightNext).shouldBeVisible()
        element(arrowLeftPrevious).shouldNotBePresent()
    }

    def click_on_link_second_page() {
        element(linkSecondPage).click()
    }

    def assert_on_second_page_CLP() {
        element(linkSecondPage).shouldNotBePresent()
    }

    def assert_left_and_right_row_CLP() {
        element(arrowLeftPrevious).shouldBePresent()
        element(arrowRightNext).shouldBePresent()
    }

    def assert_second_page_selected_CLP() {
        element(linkSecondPage).shouldNotBePresent()
        assertThat(element(textNumberCurrentPage).getText(), equalTo("2"))
    }

    def click_on_last_page_CLP() {
        element(linkFoursPage).click()
    }

    def asser_only_left_row_CLP() {
        element(arrowLeftPrevious).shouldBePresent()
        element(arrowRightNext).shouldNotBePresent()
    }

    def click_right_arrow() {
        element(arrowRightNext).click()
    }

    def click_left_arrow_CLP() {
        element(arrowLeftPrevious).click()
    }

    def assert_on_first_page_CLP() {
        element(linkFirstPage).shouldNotBePresent()
        assertThat(element(textNumberCurrentPage).getText(), equalTo("1"))
    }

    def assert_qty_items_on_CLP(def qtyItems) {
        assertThat(getDriver().findElements(By.xpath("//h2[@class='product-name']")).size().toString(), equalTo(qtyItems))
    }

    def select_to_show_qty_items_CLP(String qtyItems) {
        qtyPages = getDriver().findElements(By.xpath("//div[@class='pages']//li")).size()
        element(selectItemsPerPage).click()
        element(By.xpath("//a[contains(text(), '${qtyItems}')]")).waitUntilVisible()
        getDriver().findElement(By.xpath("//a[contains(text(), '${qtyItems}')]")).click()
    }

    def assert_qty_of_pages_recalculated() {
        assert getDriver().findElements(By.xpath("//div[@class='pages']//li")).size() < qtyPages
    }

    def assert_sorted_by(def sortingValue) {
        assertThat(element(selectSortByCurrent).getText(), equalTo(sortingValue))
    }

    def assert_on_subCLP_with_single_static_block() {
        assertThat("Single static block present", equalTo("Single static block absent"))
    }

    def assert_on_subCLP_with_left_navigation() {
        element(blockLeftNavigation).shouldBePresent()
    }

    def mouse_over_on_product_image(def i) {
        Locatable hoverItem = (Locatable) getDriver().findElement(By.xpath("//div[@class='category-products']//li[${i}]/div/a[1]"))
        Mouse mouse = ((HasInputDevices) driver).getMouse()
        mouse.mouseMove(hoverItem.getCoordinates())
    }

    def assert_quick_view_button() {
        element(buttonQuickView).shouldBeVisible()
    }

    def assert_quick_view_module_opened() {
        element(buttonQWClose).shouldBeVisible()
    }

    def click_on_color_swatch(def i) {
        element(By.xpath("//div[@class='category-products']//ul[1]/li[1]//li[@class='color-swatches-swatch first last']/a[${i}]")).click()
    }

    def assert_image_replaced_CLP() {
        getDriver().findElement(By.xpath("//div[@class='category-products']//ul[1]/li[1]//a[@class='product-image']/img")).getAttribute("src").contains("base")
    }
}
