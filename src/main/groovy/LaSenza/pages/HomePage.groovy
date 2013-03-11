package LaSenza.pages

import net.thucydides.core.annotations.DefaultUrl
import org.openqa.selenium.internal.Locatable
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.*

import static org.hamcrest.CoreMatchers.equalTo
import static org.hamcrest.MatcherAssert.assertThat

@DefaultUrl("http://localhost:9000")
class HomePage extends ForAllPage {

    int qtyItemsInWishListHeader

    HomePage(WebDriver driver) {
        super(driver)
    }

    String qtyHeaderBefore
    String priceHeaderBefore


    @FindBy(xpath = "//div[@class='global-header-banner']/p/img")
    private WebElement globalHeaderBanner;

    @FindBy(xpath = "//span[@class='welcome-msg']")
    private WebElement blockWelcomeMsg;

    @FindBy(xpath = "//div[@class='block-title']")
    private WebElement iconBagHeader;

    @FindBy(xpath = "//a[@class='unset-cookie']")
    private WebElement linkNotUserNameUserLastName;

    @FindBy(xpath = "//a[contains(text(), 'Please login.')]")
    private WebElement linkPleaseLogin

    @FindBy(xpath = "//a[contains(text(), 'Not Test Tester')]")
    private WebElement linkNotFirstNameLastName

    @FindBy(xpath = "//a[@title='Login']")
    private WebElement linkLogIn;

    @FindBy(xpath = "//a[@title='register']")
    private WebElement linkRegister;

    @FindBy(xpath = "//a[contains(text(), 'Store Locator')]")
    private WebElement linkStoreLocator;

    @FindBy(xpath = "//a[@title='My Account']")
    private WebElement linkMyAccount;

    @FindBy(xpath = "//a[contains(text(), 'My Wishlists')]")
    private WebElement linkMyWishlist;

    @FindBy(xpath = "//strong//span[@class='price']")
    private WebElement totalPriceHeader

    @FindBy(xpath = "//ul[@class='links cart-link']")
    private WebElement textMyCartHeader

    @FindBy(xpath = "//a[@title='Log Out']")
    private WebElement linkLogOut;

    @FindBy(id = "popId-languageSelect")
    private WebElement popUpListLocations;

    @FindBy(id = "cartHeader")
    private WebElement qtyHeader;

    @FindBy(id = "search")
    private WebElement fieldSearch;

    @FindBy(xpath = "//button[@title='Go']")
    private WebElement buttonSearch;

    @FindBy(xpath = "//strong[@id='cartHeader']/span[1]")
    private WebElement textQtyHeader;

    @FindBy(xpath = "//strong[@id='cartHeader']//span[@class='price']")
    private WebElement textPriceHeader;

    @FindBy(xpath = "//div[@id='topCartContent']")
    private WebElement blockMiniCart;

    @FindBy(xpath = "//table[@class='mini-cart-price']//td[@class='qty']")
    private WebElement blockQtyMiniCart;

    @FindBy(xpath = "//table[@class='mini-cart-price']//span[@class='price']")
    private WebElement blockPriceMiniCart;

    @FindBy(xpath = "//div[@class='mini-cart-bottom']//span[@class='price']")
    private WebElement blockTotalMiniCart;

    @FindBy(xpath = "//div[@class='switch switcher-language']")
    private WebElement selectLocation;

    @FindBy(xpath = "//div[@class='widget widget-banner']/ul[2]/li[1]/a")
    private WebElement buttonFirstImageSlider;

    @FindBy(xpath = "//div[@class='widget widget-banner']/ul[2]/li[2]/a")
    private WebElement buttonSecondImageSlider;

    @FindBy(xpath = "//div[@class='widget widget-banner']/ul[1]/div/li[1]/img")
    private WebElement sliderImage1;

    @FindBy(xpath = "//div[@class='widget widget-banner']/ul[1]/div/li[2]/img")
    private WebElement sliderImage2;

    @FindBy(xpath = "//div[@class='widget widget-banner']/ul[1]/div/li[3]/img")
    private WebElement sliderImage3;

    @FindBy(xpath = "//div[@class='tab-content ']")
    private WebElement blockDropDownMenu

    @FindBy(xpath = "//a[@title='Edit']")
    private WebElement linkEditItemMiniCart

    @FindBy(xpath = "//a[@title='Remove item']")
    private WebElement linkRemoveItemMiniCart

    @FindBy(xpath = "//div[@class='actions']/a")
    private WebElement linkGoToShoppingCart

    @FindBy(xpath = "//div[@class='actions']/button")
    private WebElement buttonCheckout

    def click_on_first_image_of_slider() {
        element(sliderImage1).waitUntilNotVisible()
       /* println element(sliderImage1).isCurrentlyVisible()
        println element(sliderImage2).isCurrentlyVisible()
        println element(sliderImage3).isCurrentlyVisible()*/
        element(buttonFirstImageSlider).click();
        element(sliderImage1).waitUntilVisible()
        //Thread.sleep(2000)
        /*println element(sliderImage1).isCurrentlyVisible()
        println element(sliderImage2).isCurrentlyVisible()
        println element(sliderImage3).isCurrentlyVisible()*/
    }

    def assert_place_holder_on_slider() {
        element(buttonFirstImageSlider).shouldBePresent();
        element(buttonSecondImageSlider).shouldBePresent();
    }

    def assert_static_block_below_menu_panel() {
        element(globalHeaderBanner).shouldBeVisible()
    }

    def assert_location(String location) {
        assert getDriver().findElements(By.xpath("//strong[@class='current language-${location}']")) != []
        assert getDriver().getCurrentUrl().contains("ca")
    }

    def click_on_select_location() {
        element(selectLocation).click()
    }

    def click_on_location_in_list(String location) {
        element(popUpListLocations).waitUntilVisible()
        getDriver().findElement(By.xpath("//li[@class='language-${location}']")).click()
    }

    def assert_image_active(int imageNumber) {
        /*println element(sliderImage1).isCurrentlyVisible()
        println element(sliderImage2).isCurrentlyVisible()
        println element(sliderImage3).isCurrentlyVisible()*/
        if (imageNumber != 1) {
            assert !element(By.xpath("//div[@class='widget widget-banner']/ul[1]/div/li[${imageNumber - 1}]/img")).isCurrentlyVisible()
        }
        assert element(By.xpath("//div[@class='widget widget-banner']/ul[1]/div/li[${imageNumber}]/img")).isCurrentlyVisible()
    }

    def assert_cont_images_in_slider(int i) {
        assert getDriver().findElements(By.xpath("//div[@class='widget widget-banner']/ul[2]/li")).size() == i
    }

    def assert_welcome_msg(def welcomeMSG) {
        assertThat(blockWelcomeMsg.getText(), equalTo(welcomeMSG))
    }

    def open1() {
        getDriver().get(System.getProperty("webdriver.base.url"))
    }

    def assert_please_login_msg(String pleaseLoginNotTestTester) {
        assert linkNotUserNameUserLastName.getText() == pleaseLoginNotTestTester
    }

    def click_on_link_please_log_in() {
        element(linkPleaseLogin).click()
    }

    def assert_logged_out() {
        element(linkLogIn).shouldBeVisible()
    }

    def assert_default_header() {
        element(linkRegister).shouldBeVisible()
    }

    def click_on_link_my_account() {
        element(linkMyAccount).click()
    }

    def click_on_link_my_wishlist() {
        element(linkMyWishlist).click()
    }

    def click_on_link_log_out() {
        element(linkLogOut).click()
    }

    def click_on_link_login() {
        element(linkLogIn).click()
    }

    def click_on_link_register() {
        element(linkRegister).click()
    }

    def click_on_link_store_locator() {
        element(linkStoreLocator).click()
    }

    def enter_text_to_the_search_field(String text) {
        typeInto(fieldSearch, text)
    }

    def click_on_search_button() {
        element(buttonSearch).click()
    }

    def assert_mini_cart_appears() {
        element(blockMiniCart).waitUntilVisible()
        element(blockMiniCart).shouldBeVisible()
    }

    def assert_qty_and_price_added_to_mini_cart(String qty, String price) {
        assertThat(element(blockQtyMiniCart).getText(), equalTo(qty))
        assertThat(element(blockPriceMiniCart).getText(), equalTo(price))
        assertThat(element(blockTotalMiniCart).getText(), equalTo(price))
    }

    def assert_total_qty_in_header(String qty) {
        assertThat(element(textQtyHeader).getText(), equalTo(qty))
    }

    def assert_total_price_in_header(String price) {
        assertThat(element(textPriceHeader).getText(), equalTo(price))
    }

    def assert_item_not_added() {
        if (getDriver().findElements(By.xpath("//strong[@id='cartHeader']/span[1]")).size() != 0) {
            assertThat(element(textQtyHeader).getText(), equalTo(qtyHeaderBefore))
            assertThat(element(textPriceHeader).getText(), equalTo(priceHeaderBefore))
        } else {
            assertThat(qtyHeaderBefore, equalTo("0"))
            assertThat(priceHeaderBefore, equalTo("0"))
        }
    }

    def store_state_of_total_price_and_qty() {
        if (getDriver().findElements(By.xpath("//strong[@id='cartHeader']/span[1]")).size() != 0) {
            qtyHeaderBefore = element(textQtyHeader).getText()
            priceHeaderBefore = element(textPriceHeader).getText()
        } else {
            qtyHeaderBefore = "0"
            priceHeaderBefore = "0"
        }

    }

    def click_on_element_in_shopping_cart_area(String el) {
        if (el == "Icon Bag") {
            element(iconBagHeader).waitUntilVisible()
            element(iconBagHeader).click()
        } else {
            if (el == "QTY") {
                element(qtyHeader).waitUntilVisible()
                element(qtyHeader).click()
            } else {
                element(totalPriceHeader).waitUntilVisible()
                element(totalPriceHeader).click()
            }
        }
    }

    def click_on_element_text_my_cart_header() {
        element(textMyCartHeader).click()
    }

    def assert_mini_cart_not_appears() {
        element(blockMiniCart).shouldNotBeVisible()

    }

    def assert_on_home_page() {
        assertThat(driver.getCurrentUrl(), equalTo(System.getProperty("webdriver.base.url")))
        element(buttonFirstImageSlider).shouldBePresent()
    }

    def move_mouse_on_menu(String nameMenu) {
        Locatable hoverItem = (Locatable) getDriver().findElement(By.cssSelector(".tab.$nameMenu"))
        Mouse mouse = ((HasInputDevices) driver).getMouse()
        mouse.mouseMove(hoverItem.getCoordinates())
    }

    def assert_no_collections_block_in_menu() {
        assert driver.findElements(By.xpath("//li[4]//div[@class='tab-content ']/div/div[2]/span")).size() == 0
    }

    def assert_static_block_instead_collections_in_menu() {
        element(By.xpath("//li[4]/div/div/div[2]")).shouldBeVisible()
    }

    def assert_main_categories_in_menu_sale() {
        def punktsSaleMenu = driver.findElements(By.xpath("//li[7]//li//span")).collect() {WebElement el ->
            el.text
        }
        def punktsMainMenu = driver.findElements(By.xpath("//ul[@class='tabs']/li/a")).collect() {WebElement el ->
            el.text
        }
        punktsMainMenu.remove(6)
        assert punktsMainMenu == punktsSaleMenu
    }

    def assert_3_static_blocks_in_menu_sale() {
        assert driver.findElements(By.xpath("//li[7]//div[@class='widget widget-static-block']")).size() == 3
    }

    def click_on_link_in_menu(String linkName) {
        element(By.xpath("//a/span[contains(text(), '$linkName')]")).click()
    }

    def assert_logged_in() {
        element(linkLogOut).shouldBePresent()
    }

    def log_out_if_logged_in() {
        if (logged_in()) {
            click_on_link_log_out()
        }
    }

    def logged_in() {
        return element(linkLogOut).isPresent()
    }

    def no_items_in_cart() {
        return getDriver().findElements(By.xpath("//strong[@id='cartHeader']/span[1]")).size() == 0
    }

    def click_on_link_not_first_name_last_name() {
        element(linkNotFirstNameLastName).click()
    }

    def click_on_link_please_log_in_not() {
        if (getDriver().findElements(By.xpath("//a[@class='unset-cookie']")).size() != 0) {
            element(linkNotUserNameUserLastName).click()
        }
    }

    def assert_item_added_to_wishlist_header() {
        assert qtyItemsInWishListHeader < getDriver().findElement(By.xpath("//a[contains(text(), 'Wishlists')]")).getText().replaceAll("\\D", "").toInteger()
    }

    def set_items_qty_in_wish_list_header() {
        if (getDriver().findElement(By.xpath("//a[contains(text(), 'Wishlists')]")).getText().replaceAll("\\D", "") != "") {
            qtyItemsInWishListHeader = getDriver().findElement(By.xpath("//a[contains(text(), 'Wishlists')]")).getText().replaceAll("\\D", "").toInteger()
        } else {
            qtyItemsInWishListHeader = 0
        }
    }

    def assert_drop_down_menu_opened() {
        element(blockDropDownMenu).shouldBeVisible()
    }

    def click_on_element_in_mini_cart(String Element) {
        if (Element == "product-image") {
            element(By.xpath("//ol[@id='mini-cart']//a[@class='${Element}']")).waitUntilVisible()
            getDriver().findElement(By.xpath("//ol[@id='mini-cart']//a[@class='${Element}']")).click()
        } else {
            if (Element == "product-name") {
                element(By.xpath("//ol[@id='mini-cart']//p[@class='${Element}']/a")).waitUntilVisible()
                getDriver().findElement(By.xpath("//ol[@id='mini-cart']//p[@class='${Element}']/a")).click()
            } else {
                element(By.xpath("//ol[@id='mini-cart']//div[@class='${Element}']/a")).waitUntilVisible()
                getDriver().findElement(By.xpath("//ol[@id='mini-cart']//div[@class='${Element}']/a")).click()
            }
        }
    }

    def click_on_link_edit_item() {
        element(linkEditItemMiniCart).click()
    }

    def click_on_link_remove_item_mini_cart() {
        element(linkRemoveItemMiniCart).click()
    }

    def accept_confirmation_on_remove_item_mini_cart() {
        Alert alert = getDriver().switchTo().alert()
        assertThat(alert.getText(), equalTo("Are you sure you would like to remove this item from the shopping cart?"))
        alert.accept()
    }

    def assert_product_deleted() {
        if (getDriver().findElements(By.xpath("//strong[@id='cartHeader']/span[1]")).size() != 0) {
            assertThat(element(textQtyHeader).getText().toInteger(), equalTo(qtyHeaderBefore.toInteger()))
        } else {
            assertThat(qtyHeaderBefore, equalTo("0"))
        }
    }

    def assert_product_deleted_from_mini_cart() {
        assertThat(getDriver().findElements(By.xpath("//strong[@id='cartHeader']/span[1]")).size(), equalTo(0))
    }

    def refuse_confirmation_on_delete_item() {
        Alert alert = getDriver().switchTo().alert()
        assertThat(alert.getText(), equalTo("Are you sure you would like to remove this item from the shopping cart?"))
        alert.dismiss()
    }

    def assert_products_in_cart_not_removes() {
        assertThat(element(textQtyHeader).getText().toInteger(), equalTo(qtyHeaderBefore.toInteger() + 1))
    }

    def click_on_link_go_to_shopping_cart() {
        element(linkGoToShoppingCart).click()
    }

    def click_on_button_checkout() {
        element(buttonCheckout).click()
    }

    def assert_total_count_of_items_in_wishlists() {
        assert qtyItemsInWishListHeader + 2 == getDriver().findElement(By.xpath("//a[contains(text(), 'Wishlists')]")).getText().replaceAll("\\D", "").toInteger()
    }

    def get_qty_items_in_wishlist() {
        return qtyItemsInWishListHeader
    }
}
