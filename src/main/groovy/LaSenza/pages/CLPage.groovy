package LaSenza.pages

import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.internal.Locatable
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.*

import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.Matchers.equalTo
import static org.hamcrest.Matchers.lessThan
import static org.hamcrest.Matchers.containsString

class CLPage extends ForAllPage {

    private def productName
    def qtyPagesBefore
    def countColors
    def colors = []
    def sizes = []
    def prices = []
    def names = []
    def countProductsCategory
    def countProductsAttributes
    def textFirstRefinement
    String colorToSelect

    CLPage(WebDriver driver) {
        super(driver)
    }

    @FindBy(xpath = "//h1/a")
    private WebElement linkQVProductName;

    @FindBy(xpath = "//div[@class='quickview-wrapper']//span[@class='price']")
    private WebElement textPriceQV

    @FindBy(xpath = "//div[@class='quickview-wrapper']//h1/a")
    private WebElement textProductNameQV

    @FindBy(xpath = "//a[@class='popup-close']")
    private WebElement buttonQVClose

    @FindBy(xpath = "//a[@class='view-all']")
    private WebElement linkViewAll

    @FindBy(xpath = "//div[@class='hidden-colors']")
    private WebElement popUpColosSwatches

    @FindBy(xpath = "//div[@class='hidden-colors']//a[2]")
    private WebElement colorPopUpColosSwatches

    @FindBy(xpath = "//div[@class='more-views']/ul/li")
    private WebElement thumbnailImageQV

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
    private WebElement elementOutsideQV

    @FindBy(xpath = "//div[@class='option-wrapper'][2]//select")
    private WebElement selectSizeFirstQV

    @FindBy(xpath = "//a[@class='add-more-items']")
    private WebElement linkAddMoreItemsQV

    @FindBy(xpath = "//div[@class='scroll']/div[1]//select")
    private WebElement selectColorFirstQV

    @FindBy(xpath = "//div[@class='scroll']/div[2]//select")
    private WebElement selectColorSecondQV

    @FindBy(xpath = "//dt/a")
    private WebElement arrowAttributeShowHide

    @FindBy(xpath = "//dd")
    private WebElement attributeRefinementFirst

    @FindBy(xpath = "//ol[@class='m-filter-item-list ']/li")
    private WebElement attributeCategories

    @FindBy(xpath = "//dt[@data-id='m_left_category_filter']")
    private WebElement attributeCategoriesTitle

    @FindBy(xpath = "//a[@class='btn-remove']")
    private WebElement iconRemove

    @FindBy(xpath = "//div[@class='currently']/ol/li")
    private WebElement attributeFilteredFirst

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

    @FindBy(xpath = "//ul[@class='sbOptions']")
    private WebElement dropDownSortBy

    @FindBy(xpath = "//div[@class='col-left sidebar']")
    private WebElement blockLeftNavigation

    @FindBy(xpath = "//div[@class='category-products']//li/div/a[2]")
    private WebElement buttonQuickView

    @FindBy(xpath = "//a[@class='add-more-items']")
    private WebElement linkAddMoreItems

    @FindBy(xpath = "//button[@title='Add to Cart']")
    private WebElement buttonAddToCartQV

    @FindBy(xpath = "//div[@class='product-options-block']//div[@class='option-wrapper'][1]//select")
    private WebElement selectColor

    @FindBy(xpath = "//div[@class='product-options-block']//div[@class='option-wrapper'][2]//select")
    private WebElement selectSize

    @FindBy(xpath = "//div[@class='preloader-wrapper']")
    private WebElement loaderAddToCart

    @FindBy(xpath = "//div[@class='scroll mCustomScrollbar _mCS_5']//li/a")
    private WebElement refinementSizeFirst

    @FindBy(xpath = "//div[@class='scroll mCustomScrollbar _mCS_2']//a/span")
    private WebElement refinementColorFirst

    @FindBy(xpath = "//div[@class='currently']//li/div")
    private WebElement selectedAttributeColor

    @FindBy(xpath = "//div[@class='currently']//li")
    private WebElement selectedAttributeFirst

    @FindBy(id = "left_price-from")
    private WebElement leftArrowPrice

    @FindBy(id = "left_price-to")
    private WebElement rightArrowPrice

    @FindBy(id = "left_price-applied")
    private WebElement textPriceFromTo

    def click_on_button_quick_view(def i) {
        element(By.xpath("//div[@class='category-products']//li[${i}]/div/a[2]")).waitUntilVisible()
                .click()
        element(buttonQVClose).waitUntilVisible()
    }

    def set_product_name(def i) {
        this.productName = element(By.xpath("//div[@class='category-products']//li[${i}]/h2/a")).getText()
    }

    final def get_product_name() {
        return this.productName
    }

    def send_esc_key() {
        element(linkQVProductName).waitUntilVisible()
        linkQVProductName.sendKeys(Keys.ESCAPE)
    }

    def QV_should_be_absent() {
        element(linkQVProductName).shouldNotBeVisible()
    }

    def click_close_button() {
        element(buttonQVClose).click()
    }

    def QV_should_not_have_thumbnail_images() {
        element(thumbnailImageQV).shouldNotBeVisible()
    }

    def click_on_QV_element(String el) {
        if (el == "Brand Name") {
            element(linkBrandName).waitUntilVisible()
            element(linkBrandName).click()
        } else {
            if (el == "Product Name") {
                element(linkProductName).waitUntilVisible()
                element(linkProductName).click()
            } else {
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


    def click_outside_QV() {
        Actions clicker = new Actions(driver);
        clicker.moveToElement(buttonQVClose).moveByOffset(-10, 300).click().perform();
        element(elementOutsideQV).click()
    }

    def assert_select_size_disable() {
        element(selectSizeFirstQV).shouldNotBeEnabled()
    }

    def assert_QTY_field_prefilled_QV(def fieldPosition, String value) {
        assertThat(getDriver().findElement(By.xpath("//fieldset/div[${fieldPosition}]//input")).getAttribute("value"), equalTo(value))
    }

    def assert_two_rows_of_additional_products_opened_QV() {
        assertThat(getDriver().findElements(By.xpath("//div[@class='options-container-big']/fieldset/div")).size(), equalTo(2))
    }

    def assert_QTY_third_row_prefilled_QV() {
        assertThat(getDriver().findElement(By.xpath("//fieldset//div[3]//input")).getAttribute("value"), equalTo("1"))
    }

    def add_row_additional_product_QV() {
        def additionalProductsQuantity = getDriver().findElements(By.xpath("//div[@class='options-container-big']//div[@class='scroll']/div")).size()
        element(linkAddMoreItemsQV).click()
        element(By.xpath("//div[@class='options-container-big']//div[@class='scroll']/div[${additionalProductsQuantity + 1}]")).waitUntilVisible()
    }

    def set_QTY_additional_products_QV(String rowNumber, String value) {
        element(By.xpath("//fieldset/div[${rowNumber}]//input")).type(value)
    }

    def select_color_first_row() {
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

    def set_qty_pages_before() {
        qtyPagesBefore = getDriver().findElements(By.xpath("//div[@class='pages']//li")).size()
    }

    def select_to_show_qty_items_CLP(String qtyItems) {
        set_qty_pages_before()
        element(selectItemsPerPage).click()
        element(By.xpath("//a[contains(text(), '${qtyItems}')]")).waitUntilVisible()
        getDriver().findElement(By.xpath("//a[contains(text(), '${qtyItems}')]")).click()
    }

    def assert_qty_of_pages_recalculated() {
        assert getDriver().findElements(By.xpath("//div[@class='pages']//li")).size() < qtyPagesBefore
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
        element(buttonQVClose).shouldBeVisible()
    }

    def click_on_color_swatch(def i) {
        element(By.xpath("//div[@class='category-products']//ul[1]/li[1]//li[@class='color-swatches-swatch first last']/a[${i}]")).click()
    }

    def assert_image_replaced_CLP() {
        getDriver().findElement(By.xpath("//div[@class='category-products']//ul[1]/li[1]//a[@class='product-image']/img")).getAttribute("src").contains("base")
    }

    def click_on_view_all_colors() {
        countColors = element(linkViewAll).getText().replaceAll("\\D", "").toInteger()
        element(linkViewAll).click()
    }

    def assert_pop_up_color_swatches() {
        element(popUpColosSwatches).shouldBeVisible()
        assertThat(getDriver().findElements(By.xpath("//div[@class='hidden-colors']//a")).size(), equalTo(12))
    }

    def select_color_in_pop_up_color_swatches() {
        element(colorPopUpColosSwatches).click()
    }

    def set__and_store_multiple_product_conﬁgurations_QV(def productNumber, def colorNumber, def sizeNumber) {
        element(linkAddMoreItems).click()
        element(By.xpath("//fieldset[@class='product-options']//div[${productNumber}]//div[@class='option-wrapper'][1]//select")).selectByIndex(colorNumber)
        element(By.xpath("//fieldset[@class='product-options']//div[${productNumber}]//div[@class='option-wrapper'][2]//select")).selectByIndex(sizeNumber)
        colors[productNumber] = element(By.xpath("//fieldset[@class='product-options']//div[${productNumber}]//div[@class='option-wrapper'][1]//select")).getSelectedVisibleTextValue()
        colors[productNumber] = element(By.xpath("//fieldset[@class='product-options']//div[${productNumber}]//div[@class='option-wrapper'][1]//select")).getSelectedVisibleTextValue()
        sizes[productNumber] = element(By.xpath("//fieldset[@class='product-options']//div[${productNumber}]//div[@class='option-wrapper'][2]//select")).getSelectedVisibleTextValue()
        prices[productNumber] = element(textPriceQV).getText()
        names[productNumber] = element(textProductNameQV).getText()
    }

    def click_add_to_cart_button_QV() {
        element(buttonAddToCartQV).click()
        element(loaderAddToCart).waitUntilNotVisible()
    }

    def assert_multiple_product_added_to_mini_cart_from_QV() {
        for (def i = 1; i <= 3; i++) {
            element(getDriver().findElement(By.xpath("//ol[@id='mini-cart']/li[${i}]//p/a"))).waitUntilVisible()
            assertThat(getDriver().findElement(By.xpath("//ol[@id='mini-cart']/li[${i}]//p/a")).getText(), equalTo(names[4 - i]))
            assertThat(getDriver().findElement(By.xpath("//ol[@id='mini-cart']/li[${i}]//div[@class='item-options']//dd[1]")).getText(), equalTo(colors[4 - i]))
            assertThat(getDriver().findElement(By.xpath("//ol[@id='mini-cart']/li[${i}]//div[@class='item-options']//dd[2]")).getText(), equalTo(sizes[4 - i]))
            assertThat(getDriver().findElement(By.xpath("//ol[@id='mini-cart']/li[${i}]//span[@class='price']")).getText(), equalTo(prices[4 - i]))
        }
    }

    def choose_configurable_options(int index) {
        if (getDriver().findElements(By.xpath("//div[@class='product-options-block']//div[@class='option-wrapper']")).size() != 0) {
            element(selectColor).selectByIndex(index)
            element(selectSize).selectByIndex(index)
        }
    }

    def store_configurable_options() {
        colors[1] = element(selectColor).getSelectedVisibleTextValue()
        sizes[1] = element(selectSize).getSelectedVisibleTextValue()
        prices[1] = element(textPriceQV).getText()
        names[1] = element(textProductNameQV).getText()
    }

    def select_color_second_row() {
        element(selectColorSecondQV).selectByIndex(1)
    }

    def assert_additional_rows_appeared() {
        assertThat(driver.findElements(By.xpath("//div[@class='options-container-big']//div[@class='scroll']/div")).size(), equalTo(3))
    }

    def click_arrow_attribute_title() {
        element(arrowAttributeShowHide).click()
    }

    def assert_attribute_refinement_expanded() {
        assertThat(attributeRefinementFirst.getAttribute("style"), equalTo("height: 0px;"))
    }

    def assert_attribute_refinement_collapsed() {
        assertThat(attributeRefinementFirst.getAttribute("style"), equalTo("height: auto;"))
    }

    def assert_category_refinements_CLP() {
        element(attributeCategories).shouldBePresent()
        def arrayCategories = driver.findElements(By.xpath("//ol[@class='m-filter-item-list ']/li")).collect() {WebElement el ->
            el.text.replaceAll("\\D", "").toInteger()
        }
        assert arrayCategories.each {el -> el.is(int)}
    }

    def click_on_category_refinements_CLP() {
        countProductsCategory = driver.findElement(By.xpath("//ol[@class='m-filter-item-list ']/li")).getText().replaceAll("\\D", "")
        countProductsAttributes = driver.findElements(By.xpath("//ol/li")).size()
        driver.findElement(By.xpath("//ol[@class='m-filter-item-list ']/li[1]/a")).click()
    }

    def assert_category_refinements_removed_CLP() {
        element(attributeCategories).shouldNotBePresent()
    }

    def assert_category_refinements_appears_in_shop_by_list_CLP(String s) {
        element(attributeFilteredFirst).shouldBeVisible()
        assert element(attributeFilteredFirst).getText().contains(s)
    }

    def assert_number_near_filtered_attribute() {
        assertThat(element(attributeFilteredFirst).getText().replaceAll("\\D", ""), equalTo(countProductsCategory))
    }

    def assert_CLP_and_left_navigation_updated() {
        assertThat(getDriver().findElements(By.xpath("//h2[@class='product-name']")).size().toString(), equalTo(countProductsCategory))
        assertThat(getDriver().findElements(By.xpath("//ol/li")).size(), lessThan(countProductsAttributes))
    }

    def assert_category_list_disappeared() {
        element(attributeCategoriesTitle).shouldNotBePresent()
    }

    Object click_remove_category_refinement() {
        element(iconRemove).click()
    }

    def assert_category_refinement_visible() {
        element(attributeCategoriesTitle).shouldBePresent()

    }

    def select_to_show_sorting_CLP(String sortingOrder) {
        element(selectSortByCurrent).click()
        element(dropDownSortBy).waitUntilVisible()
        element(By.xpath("//ul[@class='sbOptions']//a[contains(text(), '${sortingOrder}')]")).waitUntilVisible()
        element(By.xpath("//ul[@class='sbOptions']//a[contains(text(), '${sortingOrder}')]")).click()
    }

    def assertItemsSortedByAlphabeticalOrder(String sortingOrder2) {
        def actualNames = driver.findElements(By.xpath("//li[contains(@class,'item')]//h2[@class='product-name']/a")).collect {WebElement el ->
            el.text
        }
        if(sortingOrder2 == "Name [A to Z]"){
            def sortedNames = actualNames.sort(false) {a, b -> a.compareToIgnoreCase(b)}
            assert actualNames == sortedNames
        } else{
            def sortedNames = actualNames.sort(false) {a, b -> b.compareToIgnoreCase(a)}
            assert actualNames == sortedNames
        }
    }

    def assertItemsSortedByPriceValue(String sortingOrder1) {
        def actualPrices = driver.findElements(By.xpath("//li[contains(@class,'item')]//span/span")).collect {WebElement el ->
            el.text.replaceAll("\\D", "") as int
        }
        def sortedPrices
        if(sortingOrder1 == "Price [Low to High]"){
            sortedPrices = actualPrices.sort(false)
            assert actualPrices == sortedPrices
        } else {
            sortedPrices = actualPrices.sort(false).reverse(false)
            assert actualPrices == sortedPrices
        }
    }

    def assert_refinements_with_number_of_products() {
        for (def i : driver.findElements(By.xpath("//dl[@id='narrow-by-list-0']//ol/li"))) {
                assert i.getText().endsWith(")")
                assert i.getText().contains("(")
        }
    }

    def assert_refinements_colors_have_no_number_of_products() {
        for (def i : driver.findElements(By.xpath("//div[@class='m-filter-colors horizontal mf-1-1']/a/div"))) {
            assertThat(i.getText(), equalTo(""))
        }
    }

    def click_refinement_size() {
        element(refinementSizeFirst).click()
        textFirstRefinement = element(refinementSizeFirst).getText()
    }

    def refinement_size_checked_and_added_to_shopping_by() {
        assertThat(refinementSizeFirst.getAttribute("class"), equalTo("ga-size m-checkbox-checked"))
        def textAttribute =  textFirstRefinement.substring(0, textFirstRefinement.indexOf(" "))
        assertThat(element(selectedAttributeFirst).getText(), containsString(textAttribute))
    }

    def click_on_color_swatch_refinement() {
        colorToSelect = refinementColorFirst.getAttribute("title")
        set_qty_pages_before()
        element(refinementColorFirst).click()
    }

    def assert_selected_color_swatch_attribute() {
        assertThat(selectedAttributeColor.getAttribute("title"), equalTo(colorToSelect))
    }

    def select_price_boundaries() {
        set_qty_pages_before()
        Actions mouseAction = new Actions(driver);
        mouseAction.dragAndDropBy(leftArrowPrice, 44, 0).build().perform()
        mouseAction.dragAndDropBy(rightArrowPrice, -88, 0).build().perform()
    }

    def assert_selected_price() {
        assertThat(element(textPriceFromTo).getText(), equalTo("CA\$19 to CA\$25"))
        assertThat(element(selectedAttributeFirst).getText().replaceAll("\\D", ""), equalTo("1925"))
    }
}
