package LaSenza.steps

import net.thucydides.core.annotations.Pending
import net.thucydides.core.annotations.Step
import net.thucydides.core.pages.Pages
import net.thucydides.core.steps.ScenarioSteps
import org.openqa.selenium.Alert
import LaSenza.pages.*

import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.Matchers.equalTo

class UserSteps extends ScenarioSteps {

    HomePage homePage
    PDPage pDPage
    LoginPage loginPage
    CreateAccountPage createAccountPage
    StoreLocatorPage storeLocatorPage
    SearchPage searchPage
    CLPage cLPage
    CheckoutPage checkoutPage
    ThankYouPage thankYouPage
    ShoppingCartPage shoppingCartPage
    def textShipping
    def textTax
    def textShippingTotals
    def textGrandTotal

    UserSteps(Pages pages) {
        super(pages)
        homePage = pages[HomePage]
        homePage = pages[HomePage]
        pDPage = pages[PDPage]
        loginPage = pages[LoginPage]
        createAccountPage = pages[CreateAccountPage]
        storeLocatorPage = pages[StoreLocatorPage]
        searchPage = pages[SearchPage]
        cLPage = pages[CLPage]
        checkoutPage = pages[CheckoutPage]
        thankYouPage = pages[ThankYouPage]
        shoppingCartPage = pages[ShoppingCartPage]
    }

    @Step
    def opens_home_page() {
        homePage.open()
    }

    @Step
    def should_see_title(String title) {
        assertThat(homePage.getTitle(), is(title))
    }

    @Step
    def assert_carousel() {
        click_on_first_image_of_slider()
        timeout(8000)
        homePage.assert_image_active(2)
        timeout(5000)
        homePage.assert_image_active(3)
    }

    @Step
    def open_pdp(def id) {
        getDriver().get("${System.getProperty("webdriver.base.url")}/catalog/product/view/id/${id}")
    }

    @Step
    def timeout(int mSec) {
        Thread.sleep(mSec)
    }

    @Step
    def click_on_first_image_of_slider() {
        homePage.click_on_first_image_of_slider()
    }

    @Step
    def click_on_first_image_of_slider_and_assert_changes() {
        homePage.click_on_first_image_of_slider()
        homePage.assert_image_active(1)
    }

    @Step
    def assert_place_holder_on_slider() {
        homePage.assert_place_holder_on_slider()
    }

    @Step
    def opens_home_page_thucydides() {
        homePage.open1()
    }

    @Step
    def should_see_static_block_below_menu_panel() {
        homePage.assert_static_block_below_menu_panel()
    }

    @Step
    def opens_CLP(String categoryName) {
        getDriver().get("${System.getProperty("webdriver.base.url")}${categoryName}.html")
    }

    @Step
    def opens_subCLP(String categoryName, String subCategoryName) {
        getDriver().get("${System.getProperty("webdriver.base.url")}${categoryName}/${subCategoryName}.html")
    }

    @Step
    def opens_CDP(String categoryName, String collectionName) {
        getDriver().get("${System.getProperty("webdriver.base.url")}${categoryName}/collections/${collectionName}.html")
    }

    @Step
    def assert_default_location(String location) {
        homePage.assert_location(location)
    }

    @Step
    def click_on_select_location() {
        homePage.click_on_select_location()
    }

    @Step
    def selectLocation(String location) {
        homePage.click_on_location_in_list(location)
    }

    @Step
    def assert_location(String location) {
        homePage.assert_location(location)
    }

    @Step
    def assert_count_images_in_slider(int i) {
        homePage.assert_cont_images_in_slider(i)
    }

    @Step
    def send_esc_key() {
        cLPage.send_esc_key()
    }

    @Step
    def assert_QV_absent() {
        cLPage.QV_should_be_absent()
    }

    @Step
    def click_outside_QV() {
        cLPage.click_outside_QV()
    }

    def click_close_button() {
        cLPage.click_close_button()
    }

    @Step
    def assert_no_thumbnail_images_QV() {
        cLPage.QV_should_not_have_thumbnail_images()
    }

    @Step
    def click_on_QV_element(String element) {
        cLPage.click_on_QV_element(element)
    }

    @Step
    def assert_on_PDP() {
        pDPage.assert_on_PDP()
    }

    @Step
    def log_in(Boolean withCookie) {
        homePage.open()
        homePage.log_out_if_logged_in()
        homePage.click_on_link_login()
        loginPage.log_in("test1@speroteck.com", "testthis", withCookie)
    }

    @Step
    def refresh_page() {
        getDriver().navigate().refresh()
    }

    @Step
    def click_on_link_please_log_in() {
        homePage.click_on_link_please_log_in()
    }

    @Step
    def assert_on_login_page() {
        loginPage.assert_on_login_page()
    }

    @Step
    def assert_logged_out() {
        homePage.assert_logged_out()
    }

    @Step
    def assert_default_header() {
        homePage.assert_default_header()
    }

    @Step
    def click_on_link_my_account() {
        homePage.click_on_link_my_account()
    }

    @Step
    def click_on_link_my_wishlist() {
        homePage.click_on_link_my_wishlist()
    }

    @Step
    @Pending
    def assert_on_wish_list_login_page() {

    }

    @Step
    def click_on_link_login() {
        homePage.click_on_link_login()
    }

    @Step
    def click_on_link_register() {
        homePage.click_on_link_register()
    }

    @Step
    def assert_on_create_account_page() {
        createAccountPage.assert_on_create_account_page()
    }

    @Step
    def click_on_link_store_locator() {
        homePage.click_on_link_store_locator()
    }

    @Step
    def assert_on_store_locator_page() {
        storeLocatorPage.assert_on_store_locator_page()
    }

    @Step
    def enter_text_to_the_search_field(String searchText) {
        homePage.enter_text_to_the_search_field(searchText)
    }

    @Step
    def click_on_search_button() {
        homePage.click_on_search_button()
    }

    @Step
    def assert_on_search_page() {
        searchPage.assert_on_search_page()
    }

    @Step
    def assert_no_results() {
        searchPage.assert_no_results()
    }

    @Step
    def click_add_to_cart_button_pdp() {
        pDPage.click_add_to_cart_button()
    }

    @Step
    def assert_qty_and_price_added_in_header(def qty, def price) {
        assert_total_qty_in_header(qty)
        assert_total_price_in_header(price)
    }

    @Step
    def assert_total_price_in_header(String price) {
        homePage.assert_total_price_in_header(price)
    }

    @Step
    def assert_total_qty_in_header(String qty) {
        homePage.assert_total_qty_in_header(qty)
    }

    @Step
    def assert_mini_cart_appears() {
        homePage.assert_mini_cart_appears()
    }

    @Step
    def assert_qty_and_price_added_to_mini_cart(String qty, String price) {
        homePage.assert_qty_and_price_added_to_mini_cart(qty, price)
    }

    @Step
    def fill_qty(String qty) {
        pDPage.fill_qty(qty)
    }

    @Step
    def assert_item_not_added(textPopUp) {
        assert_modal_window(textPopUp)
        assert_mini_cart_not_appears()
        assert_item_not_added_on_header()
    }

    @Step
    def assert_item_not_added_on_header() {
        homePage.assert_item_not_added()
    }

    @Step
    def assert_modal_window(String textInModalWindow) {
        pDPage.assert_modal_window(textInModalWindow)
    }

    @Step
    def store_state_of_total_price_and_qty() {
        homePage.store_state_of_total_price_and_qty()
    }

    @Step
    def choose_and_store_configurable_options() {
        choose_configurable_options(1)
        store_configurable_options()
    }

    @Step
    def store_configurable_options() {
        pDPage.store_configurable_options()
    }

    @Step
    def choose_configurable_options(int index) {
        pDPage.choose_configurable_options(index)
    }

    @Step
    def open_quick_view(def i) {
        mouse_over_on_product_image(i)
        click_on_button_quick_view(i)
    }

    @Step
    def open_second_step_of_checkout() {
        open_first_step_of_checkout(1472)
        enter_valid_data_on_checkout_page("test1@speroteck.com", "111", "Visa", "4111111111111111", "VI", "Test City", "11111","United States", "California")
        click_button_confirm_and_pay()
    }

    @Step
    def enter_valid_data_on_checkout_page(def email, def verificationNumber, def cartName, def cartNumber, def cartType, def city, def zipCode, def country, def state) {
        enter_valid_billing_data(email, city, zipCode, country, state)
        enter_payment_inf(verificationNumber, cartName, cartNumber, cartType)
        check_shipment();
    }

    @Step
    def enter_payment_inf(def verificationNumber, def cartName, def cartNumber, def cartType) {
        click_input_credit_cart(cartType);
        fill_cart_name(cartName);
        fill_cart_number_field(cartNumber);
        select_month();
        select_year();
        fill_verification_number_field(verificationNumber);
    }

    @Step
    def click_button_confirm_and_pay() {
        checkoutPage.click_button_confirm_and_pay()
    }

    @Step
    def check_shipment() {
        checkoutPage.check_shipment()
    }

    @Step
    def fill_verification_number_field(def verificationNumber) {
        checkoutPage.fill_verification_number_field(verificationNumber)
    }

    @Step
    def select_year() {
        checkoutPage.select_year()
    }

    @Step
    def select_month() {
        checkoutPage.select_month()
    }

    @Step
    def fill_cart_number_field(def cartNumber) {
        checkoutPage.fill_cart_number_field(cartNumber)
    }

    @Step
    def fill_cart_name(def cartName) {
        checkoutPage.fill_cart_name(cartName)
    }

    @Step
    def click_input_credit_cart(def cartType) {
        checkoutPage.click_input_credit_cart(cartType)
    }

    @Step
    def fill_telephone_field() {
        checkoutPage.fill_telephone_field()
    }

    @Step
    def fill_postal_code_field(def zipCode) {
        checkoutPage.fill_postal_code_field(zipCode)
    }

    @Step
    def select_state(def state) {
        checkoutPage.select_state(state)
    }

    @Step
    def fill_city_field(def city) {
        checkoutPage.fill_city_field(city)
    }

    @Step
    def fill_address2_field() {
        checkoutPage.fill_address2_field()
    }

    @Step
    def fill_address1_field() {
        checkoutPage.fill_address1_field()
    }

    @Step
    def fill_last_name_field() {
        checkoutPage.fill_last_name_field()
    }

    @Step
    def fill_first_name_field() {
        checkoutPage.fill_first_name_field()
    }

    @Step
    def fill_email_field(def email) {
        checkoutPage.fill_email_field(email)
    }

    @Step
    def open_first_step_of_checkout(def id) {
        opens_home_page()
        if (no_items_in_cart()) {
            open_pdp(id)
            if (pDPage.contain_configurable_options()) {
                choose_configurable_options(1)
            }
            click_add_to_cart_button_pdp()
        }
        go_to_checkout()
    }

    def no_items_in_cart() {
        return homePage.no_items_in_cart()
    }

    @Step
    def go_to_checkout() {
        checkoutPage.open()
    }

    @Step
    def add_items_to_cart() {
        open_pdp(1472)
        set_qty_on_pdp("2")
        click_add_to_cart_button_pdp()
        open_pdp(1574)
        choose_configurable_options(1)
        click_add_to_cart_button_pdp()
        refresh_page()
    }

    @Step
    def set_qty_on_pdp(String qty) {
        pDPage.fill_qty(qty)
    }

    @Step
    def click_on_element_in_shopping_cart_area(String element) {
        homePage.click_on_element_in_shopping_cart_area(element)
    }

    @Step
    def click_on_element_text_my_cart_header() {
        homePage.click_on_element_text_my_cart_header()
    }

    @Step
    def assert_mini_cart_not_appears() {
        homePage.assert_mini_cart_not_appears()
    }

    def assert_on_home_page() {
        homePage.assert_on_home_page()
    }

    @Step
    def move_mouse_on_menu(String nameMenu) {
        homePage.move_mouse_on_menu(nameMenu)
    }

    @Step
    def assert_no_collections_block_in_menu() {
        homePage.assert_no_collections_block_in_menu()
    }

    @Step
    def assert_static_block_instead_collections_in_menu() {
        homePage.assert_static_block_instead_collections_in_menu()
    }

    @Step
    def assert_main_categories_in_menu_sale() {
        homePage.assert_main_categories_in_menu_sale()
    }

    @Step
    def assert_3_static_blocks_in_menu_sale() {
        homePage.assert_3_static_blocks_in_menu_sale()
    }

    @Step
    def opens_CP(String categoryName) {
        getDriver().get("${System.getProperty("webdriver.base.url")}${categoryName}/collections.html")
    }

    @Step
    def click_on_link_in_menu(String linkName) {
        move_mouse_on_menu("bras")
        click_on_link_in_menu_after_appearing(linkName)
    }

    def click_on_link_in_menu_after_appearing(String linkName) {
        homePage.click_on_link_in_menu(linkName)
    }

    @Step
    def assert_on_CLP(String nameSubCLP) {
        cLPage.assert_on_CLP(nameSubCLP)
    }

    @Step
    def click_submit_button() {
        checkoutPage.click_button_submit()
    }

    @Step
    def assert_thank_you_page() {
        thankYouPage.assert_thank_you_page()
    }

    @Step
    def click_on_link_already_register() {
        checkoutPage.click_on_link_already_register()
    }

    @Step
    def type_data_to_login(String email, String pas) {
        checkoutPage.type_data_to_login(email, pas)
    }

    @Step
    def click_login_button_pop_up() {
        checkoutPage.click_login_button_pop_up()
    }

    @Step
    def uncheck_checkbox_use_billing_for_shipping() {
        checkoutPage.uncheck_checkbox_use_billing_for_shipping()
    }

    @Step
    def assert_data_copied_from_billing_to_shipping() {
        checkoutPage.assert_data_copied_from_billing_to_shipping()
    }

    @Step
    def click_on_link_What_is_this() {
        checkoutPage.click_on_link_What_is_this()
    }

    @Step
    def assert_what_is_this() {
        checkoutPage.assert_what_is_this()
    }

    @Step
    def assert_correct_information_on_thank_you_page() {
        thankYouPage.assert_correct_information_on_thank_you_page()
    }

    @Step
    def assert_return_to_home_page() {
        thankYouPage.click_return_to_shopping()
        homePage.assert_on_home_page()
    }

    @Step
    def log_out_if_logged_in() {
        homePage.log_out_if_logged_in()
    }

    @Step
    def enter_valid_billing_data(def email, def city, def zipCode, def country, def state) {
        fill_email_field(email);
        fill_first_name_field();
        fill_last_name_field();
        fill_address1_field();
        fill_address2_field();
        select_country(country);
        fill_city_field(city);
        select_state(state);
        fill_postal_code_field(zipCode);
        fill_telephone_field();
    }

    @Step
    def select_country(def country) {
        checkoutPage.select_country(country)
    }

    @Step
    def create_account_on_checkout_page(def pass, def confirmPass) {
        checkoutPage.create_account(pass, confirmPass)
    }

    @Step
    def click_button_confirm_and_pay_via_javascript() {
        checkoutPage.click_button_confirm_and_pay_via_javascript()
    }

    @Step
    def assert_error_message() {
        checkoutPage.assert_error_message_wrong_password()
    }

    @Step
    def click_on_edit_link(def element, def counter) {
        checkoutPage.click_on_edit_link(element, counter)
    }

    @Step
    def assert_on_checkout_page() {
        checkoutPage.assert_on_checkout_page()
    }

    @Step
    def open_second_step_of_checkout_with_invalid_data() {
        open_first_step_of_checkout(1472)
        enter_valid_data_on_checkout_page("test1@speroteck.com", "1111", "Visa", "4111111111111111", "VI", "Test City", "11111","United States", "California")
        click_button_confirm_and_pay()
    }

    @Step
    def assert_error_message_wrong_payment() {
        checkoutPage.assert_text_appears("Please enter a valid credit card verification number.")
    }

    @Step
    def enter_coupon(String couponCode) {
        checkoutPage.enter_coupon(couponCode)
    }

    @Step
    def click_apply_coupon() {
        checkoutPage.click_apply_coupon()
    }

    @Step
    def coupon_discount_appears_in_grand_total() {
        checkoutPage.coupon_discount_appears_in_grand_total()
    }

    @Step
    def message_appears_promo_code(String message) {
        checkoutPage.message_appears_promo_code(message)
    }

    @Step
    def open_store_locator_page() {
        storeLocatorPage.open()
    }

    @Step
    def enter_text_to_search_field(String text) {
        storeLocatorPage.enter_text_to_search_field(text)
    }

    @Step
    def specify_search_radius(String radius) {
        storeLocatorPage.enter_radius_into_radius_field(radius)
    }

    @Step
    def click_button_search_store_locator() {
        storeLocatorPage.click_button_search()
    }

    @Step
    def assert_pop_up_present() {
        storeLocatorPage.assert_pop_up_present()
    }

    @Step
    def assert_no_results_store_locator() {
        storeLocatorPage.assert_no_results_store_locator()
    }

    @Step
    def click_reset_button() {
        storeLocatorPage.click_button_reset()
    }

    @Step
    def assert_search_field_clear_store_locator() {
        storeLocatorPage.assert_search_field_clear_store_locator()
    }

    @Step
    def assert_search_results_contains_stores(def i) {
        storeLocatorPage.assert_search_results_contains_stores(i)
    }

    @Step
    def click_on_store_entry(def entryNumber) {
        storeLocatorPage.click_on_store_entry(entryNumber)
    }

    @Step
    @Pending
    def assert_location_on_map() {
        //storeLocatorPage.assert_location_on_map()
    }

    @Step
    def click_on_direction() {
        storeLocatorPage.click_on_direction()
    }

    @Step
    def click_link_reset_store_locations() {
        storeLocatorPage.click_link_reset_store_locations()
    }

    @Step
    def assert_default_radius() {
        storeLocatorPage.assert_default_radius()
    }

    @Step
    def open_login_page() {
        homePage.open()
        homePage.click_on_link_login()
    }

    @Step
    @Pending
    def create_account(def email, def pas) {
        fill_field_first_name()
        fill_field_last_name()
        /*fill_field_email()
        fill_field_password()
        fill_field_confirm_password()
        click_button_register()*/
    }

    @Step
    @Pending
    def fill_field_last_name() {
        createAccountPage.fill_field_last_name()
    }

    @Step
    def fill_field_first_name() {
        createAccountPage.fill_field_first_name()
    }

    @Step
    def click_add_to_cart_button_expect_error() {
        pDPage.click_add_to_cart_button_expect_error()
    }

    @Step
    def assert_select_size_disable() {
        cLPage.assert_select_size_disable()
    }

    @Step
    def assert_QTY_field_prefilled_QV(String fieldPosition, String value) {
        cLPage.assert_QTY_field_prefilled_QV(fieldPosition, value)
    }

    @Step
    def assert_two_rows_of_additional_products_opened_QV() {
        cLPage.assert_two_rows_of_additional_products_opened_QV()
    }

    @Step
    def assert_QTY_third_row_prefilled_QV() {
        cLPage.assert_QTY_third_row_prefilled_QV()
    }

    @Step
    def add_row_additional_product_QV() {
        cLPage.add_row_additional_product_QV()
    }

    @Step
    def set_QTY_additional_products_QV(String rowNumber, String value) {
        cLPage.set_QTY_additional_products_QV(rowNumber, value)
    }

    @Step
    def select_color_first_row() {
        cLPage.select_color_first_row()
    }

    @Step
    def assert_select_size_first_row_enabled_QV() {
        cLPage.assert_select_size_first_row_enabled_QV()
    }

    @Step
    def click_add_to_wishlist_user() {
        cLPage.click_on_add_to_wish_list_user()
    }

    @Step
    def assert_only_right_row_present() {
        cLPage.assert_only_right_row_present()
    }

    @Step
    def click_on_link_second_page() {
        cLPage.click_on_link_second_page()
    }

    @Step
    def assert_on_second_page_CLP() {
        cLPage.assert_on_second_page_CLP()
    }

    @Step
    def assert_left_and_right_row_CLP() {
        cLPage.assert_left_and_right_row_CLP()
    }

    @Step
    def assert_second_page_selected_CLP() {
        cLPage.assert_second_page_selected_CLP()
    }

    @Step
    def click_on_last_page_CLP() {
        cLPage.click_on_last_page_CLP()
    }

    @Step
    def asser_only_left_row_CLP() {
        cLPage.asser_only_left_row_CLP()
    }

    @Step
    def click_right_arrow() {
        cLPage.click_right_arrow()
    }

    @Step
    def click_left_arrow_CLP() {
        cLPage.click_left_arrow_CLP()
    }

    @Step
    def assert_on_first_page_CLP() {
        cLPage.assert_on_first_page_CLP()
    }

    @Step
    def assert_qty_items_on_CLP(def qtyItems) {
        cLPage.assert_qty_items_on_CLP(qtyItems)
    }

    @Step
    def select_to_show_qty_items_CLP(String qtyItems) {
        cLPage.select_to_show_qty_items_CLP(qtyItems)
    }

    @Step
    def assert_qty_of_pages_recalculated() {
        cLPage.assert_qty_of_pages_recalculated()
    }

    @Step
    def assert_sorted_by(def sortingValue) {
        cLPage.assert_sorted_by(sortingValue)
    }

    @Step
    def click_on_link_not_first_name_last_name() {
        homePage.click_on_link_not_first_name_last_name()
    }

    @Step
    def click_on_link_please_log_in_not() {
        homePage.click_on_link_please_log_in_not()
    }

    @Step
    def assert_on_subCLP_with_single_static_block() {
        cLPage.assert_on_subCLP_with_single_static_block()
    }

    @Step
    def assert_on_subCLP_with_left_navigation() {
        cLPage.assert_on_subCLP_with_left_navigation()
    }

    @Step
    def assert_drop_down_menu_opened() {
        homePage.assert_drop_down_menu_opened()
    }

    @Step
    def add_item_to_cart(def id) {
        if (no_items_in_cart()) {
            store_state_of_total_price_and_qty()
            open_pdp(id)
            choose_and_store_configurable_options()
            click_add_to_cart_button_pdp()
        }

    }

    @Step
    def assert_mini_cart_displaying_5_seconds() {
        assert_mini_cart_appears()
        move_mouse_on_menu("bras")
        Thread.sleep(5000)
        assert_mini_cart_not_appears()
    }

    @Step
    def assert_most_recently_added_items_in_mini_cart() {
        refresh_page()
        click_on_element_in_shopping_cart_area("Icon Bag")
        pDPage.assert_most_recently_added_items_in_mini_cart()
    }

    @Step
    def add_3_items_to_cart(int id1, int id2, int id3) {
        pDPage.add_3_items_to_cart(id1, id2, id3)
    }

    @Step
    def assert_most_recently_added_appears_first() {
        pDPage.assert_most_recently_added_appears_first()
    }

    @Step
    def click_on_element_in_mini_cart(String element) {
        homePage.click_on_element_in_mini_cart(element)
    }

    @Step
    def click_on_link_edit_item() {
        homePage.click_on_link_edit_item()
    }

    @Step
    def assert_on_pdp_with_button_update_cart() {
        assert_on_PDP()
        pDPage.assert_button_update_cart()
    }

    @Step
    def assert_that_i_can_edit_item() {
        fill_qty("10")
        choose_configurable_options(2)
        store_configurable_options()
        click_add_to_cart_button_pdp()
        assert_product_updated(1)
    }

    @Step
    def assert_product_updated(def position) {
        pDPage.assert_product_in_mini_cart(position)
    }

    @Step
    def click_on_link_remove_item_mini_cart() {
        homePage.click_on_link_remove_item_mini_cart()
    }

    @Step
    def accept_confirmation_on_remove_item_mini_cart() {
        homePage.accept_confirmation_on_remove_item_mini_cart()
        refresh_page()
    }

    @Step
    def assert_product_deleted() {
        homePage.assert_product_deleted()
    }

    @Step
    def assert_product_deleted_from_mini_cart() {
        homePage.assert_product_deleted_from_mini_cart()
    }

    @Step
    def refuse_confirmation_on_delete_item() {
        homePage.refuse_confirmation_on_delete_item()
    }

    @Step
    def assert_products_in_cart_not_removes() {
        homePage.assert_products_in_cart_not_removes()
    }

    @Step
    def click_on_link_go_to_shopping_cart() {
        homePage.click_on_link_go_to_shopping_cart()
    }

    @Step
    def assert_on_shopping_cart_page() {
        shoppingCartPage.assert_on_shopping_cart_page()
    }

    @Step
    def click_on_button_checkout() {
        homePage.click_on_button_checkout()
    }

    @Step
    def assert_logget_in_on_checkout_page() {
        checkoutPage.assert_logged_in()
    }

    @Step
    def check_pay_pal_method() {
        checkoutPage.check_pay_pal_method()
    }

    @Step
    def pass_pay_pall_process() {
        checkoutPage.pass_pay_pall_process()
    }

    @Step
    def login_to_pay_pal() {
        checkoutPage.login_to_pay_pal()
    }

    @Step
    def mouse_over_on_product_image(def i) {
        cLPage.mouse_over_on_product_image(i)
    }

    @Step
    def assert_quick_view_button() {
        cLPage.assert_quick_view_button()
    }

    @Step
    def click_on_button_quick_view(int i) {
        cLPage.click_on_button_quick_view(i)
    }

    @Step
    def assert_quick_view_module_opened() {
        cLPage.assert_quick_view_module_opened()
    }

    @Step
    def click_on_color_swatch(def i) {
        cLPage.click_on_color_swatch(i)
    }

    @Step
    def assert_image_replaced_CLP() {
        cLPage.assert_image_replaced_CLP()
    }

    @Step
    def click_on_view_all_colors() {
        cLPage.click_on_view_all_colors()
    }

    @Step
    def assert_pop_up_color_swatches() {
        cLPage.assert_pop_up_color_swatches()
    }

    @Step
    def select_color_in_pop_up_color_swatches() {
        cLPage.select_color_in_pop_up_color_swatches()
    }

    @Step
    def assert_qty_and_price_added_to_shopping_cart(def qty, def price) {
        shoppingCartPage.assert_qty_and_price_added_to_shopping_cart(qty, price)
    }

    @Step
    def open_shopping_cart() {
        shoppingCartPage.open()
    }

    @Step
    def set_and_store_multiple_product_conﬁgurations(def productNumber, def colorNumber, def sizeNumber) {
        pDPage.set__and_store_multiple_product_conﬁgurations(productNumber, colorNumber, sizeNumber)
    }

    @Step
    def assert_multiple_product_added_to_mini_cart() {
        pDPage.assert_most_recently_added_items_in_mini_cart()
    }

    @Step
    def assert_multiple_product_added_to_shopping_cart() {
        shoppingCartPage.assert_multiple_product_added_to_shopping_cart(pDPage.sizes, pDPage.colors, pDPage.names, pDPage.prices)
    }

    @Step
    def delete_items_from_cart() {
        open_shopping_cart()
        shoppingCartPage.clear_shopping_cart()
    }

    @Step
    def set_and_store_multiple_product_conﬁgurations_QV(def productNumber, def colorNumber, def sizeNumber) {
        cLPage.set__and_store_multiple_product_conﬁgurations_QV(productNumber, colorNumber, sizeNumber)
    }

    @Step
    def click_add_to_cart_button_QV() {
        cLPage.click_add_to_cart_button_QV()
    }

    @Step
    def assert_multiple_product_added_to_mini_cart_from_QV() {
        cLPage.assert_multiple_product_added_to_mini_cart_from_QV()
    }

    @Step
    def choose_and_store_configurable_options_QV() {
        choose_configurable_options_QV(1)
        store_configurable_options_QV()
    }

    @Step
    def store_configurable_options_QV() {
        cLPage.store_configurable_options()
    }

    @Step
    def choose_configurable_options_QV(int i) {
        cLPage.choose_configurable_options(i)
    }

    @Step
    def click_add_to_cart_button_configurable_QV() {
        click_add_to_cart_button_QV()
    }

    @Step
    def assert_multiple_product_added_to_shopping_cart_from_QV() {
        shoppingCartPage.assert_multiple_product_added_to_shopping_cart(cLPage.sizes, cLPage.colors, cLPage.names, cLPage.prices)
    }

    @Step
    def assert_simple_added_to_cart() {
        assert_mini_cart_appears()
        assert_qty_and_price_added_to_mini_cart("1", "CA\$26.50")
    }

    @Step
    def select_color_second_row() {
        cLPage.select_color_second_row()
    }

    @Step
    def assert_additional_rows_appeared() {
        cLPage.assert_additional_rows_appeared()
    }

    @Step
    def hover_on_color_swatch() {
        pDPage.hover_on_color_swatch()
    }

    @Step
    def assert_larger_image() {
        pDPage.assert_larger_image()
    }

    @Step
    def click_on_color_swatch_pdp() {
        pDPage.click_on_color_swatch_pdp()
    }

    @Step
    def assert_main_image_changed() {
        pDPage.assert_main_image_changed()
    }

    @Step
    def click_arrow_attribute_title() {
        cLPage.click_arrow_attribute_title()
    }

    @Step
    def assert_attribute_refinement_expanded() {
        cLPage.assert_attribute_refinement_expanded()
    }

    @Step
    def assert_attribute_refinement_collapsed() {
        cLPage.assert_attribute_refinement_collapsed()
    }

    @Step
    def assert_cross_sell(String nameCrossSell) {
        shoppingCartPage.assert_cross_sell(nameCrossSell)
    }

    @Step
    def click_on_image_or_name_cross_sell() {
        shoppingCartPage.click_on_image_cross_sell()
        assert_quick_view_module_opened()
        click_close_button()
        shoppingCartPage.click_on_name_cross_sell()
    }

    @Step
    def choose_and_store_configurable_options_shopping_cart() {
        shoppingCartPage.choose_configurable_options(1)
        shoppingCartPage.store_configurable_options()
    }

    @Step
    def assert_item_added_to_cart_shopping_cart() {
        assert_QV_absent()
        shoppingCartPage.assert_item_added_to_cart()
    }

    @Step
    def assert_category_refinements_CLP() {
        cLPage.assert_category_refinements_CLP()
    }

    @Step
    def click_on_category_refinements_CLP() {
        cLPage.click_on_category_refinements_CLP()
    }

    @Step
    def assert_category_refinements_removed_CLP() {
        cLPage.assert_category_refinements_removed_CLP()
    }

    @Step
    def assert_category_refinements_appears_in_shop_by_list_CLP(String s) {
        cLPage.assert_category_refinements_appears_in_shop_by_list_CLP(s)
    }

    @Step
    def assert_CLP_and_left_navigation_updated() {
        cLPage.assert_CLP_and_left_navigation_updated()
        cLPage.assert_number_near_filtered_attribute()
    }

    @Step
    def assert_category_list_disappeared() {
        cLPage.assert_category_list_disappeared()
    }

    @Step
    def click_remove_category_refinement() {
        cLPage.click_remove_category_refinement()
    }

    @Step
    def assert_category_refinement_visible() {
        cLPage.assert_category_refinement_visible()
    }

    @Step
    def assert_link_edit_on_shopping_cart_absent() {
        shoppingCartPage.assert_link_edit_on_shopping_cart_absent()
    }

    @Step
    def assert_new_search_radius(String newRadius) {
        storeLocatorPage.assert_new_search_radius(newRadius)
    }

    @Step
    def enter_prestige_cart(String code) {
        checkoutPage.enter_prestige_cart(code)
    }

    @Step
    def click_apply_prestige_card() {
        checkoutPage.click_apply_prestige_card()
    }

    @Step
    def assert_discount_prestige_cart() {
        checkoutPage.assert_discount_prestige_cart()
    }

    @Step
    def enter_gift_card_checkout(String number, String pin) {
        checkoutPage.enter_gift_card_checkout(number, pin)
    }

    @Step
    def click_add_gift_cart_checkout() {
        checkoutPage.click_add_gift_cart_checkout()
    }

    @Step
    def assert_discount_gift_cart_applied_checkout(String number) {
        checkoutPage.assert_discount_gift_cart_applied_checkout(number)
    }

    @Step
    def click_check_gift_cart_checkout() {
        checkoutPage.click_check_gift_cart()
    }

    @Step
    def assert_gift_cart_status_and_balance_appeared() {
        checkoutPage.assert_gift_cart_status_and_balance_appeared()
    }

    @Step
    def click_on_x_remove_gift_card_info_link() {
        checkoutPage.click_on_x_remove_gift_card_info_link()
    }

    @Step
    def assert_gift_cart_status_and_balance_disappears() {
        checkoutPage.assert_gift_cart_status_and_balance_disappears()
    }

    @Step
    def assert_message_gift_cart_invalid() {
        checkoutPage.assert_message_gift_cart_invalid()
    }

    @Step
    def assert_payment_section_disable() {
        checkoutPage.assert_payment_section_disable()
    }

    @Step
    def assert_payment_methods(String i) {
        checkoutPage.assert_payment_methods(i)
    }

    @Step
    @Pending
    def add_gift_card_to_cart_and_return() {}

    @Step
    def remove_discount() {
        checkoutPage.remove_discount()
    }

    @Step
    def assert_search_results_contains(def text, def qty) {
        storeLocatorPage.assert_search_results_contains(text, qty)
    }

    @Step
    def assert_directions_appeared() {
        storeLocatorPage.assert_directions_appeared()
    }

    @Step
    def select_to_show_sorting_CLP(String sortingOrder) {
        cLPage.select_to_show_sorting_CLP(sortingOrder)
    }

    @Step
    def assert_sorted_by_in_product_list_CLP(String sortingOrder){
        cLPage.assertItemsSortedByAlphabeticalOrder(sortingOrder)
    }

    @Step
    def assert_sorted_by_in_product_grid_CLP(String sortingOrder) {
        cLPage.assertItemsSortedByPriceValue(sortingOrder)
    }

    @Step
    def click_on_checkout_button_in_area(String element) {
        shoppingCartPage.click_on_checkout_button_in_area(element)
    }

    @Step
    def click_on_remove_shopping_cart() {
        shoppingCartPage.click_on_remove()
    }

    @Step
    def assert_empty_cart() {
        shoppingCartPage.assert_empty_cart()
    }

    @Step
    def click_continue_shopping_shopping_cart() {
        shoppingCartPage.click_continue_shopping()
    }

    @Step
    def click_on_link_click_here_shopping_cart() {
        shoppingCartPage.click_on_link_click_here()
    }

    @Step
    def click_clear_shopping_cart() {
        shoppingCartPage.clear_shopping_cart()
    }

    @Step
    def click_on_element_in_shopping_cart(String Element) {
        shoppingCartPage.click_on_element(Element)
    }

    @Step
    def click_sign_up_link_shopping_cart() {
        shoppingCartPage.click_sign_up_link()
    }

    @Step
    def assert_on_prestige_registration_page() {
        shoppingCartPage.assert_on_prestige_registration_page()
    }

    @Step
    def enter_coupon_shopping_cart(String code) {
        shoppingCartPage.enter_coupon(code)
    }

    @Step
    def click_apply_coupon_shooping_cart() {
        shoppingCartPage.click_apply_coupon()
    }

    @Step
    def assert_error_message_shopping_cart() {
        shoppingCartPage.assert_error_message()
    }

    @Step
    def click_apply_gift_card_shopping_cart() {
        shoppingCartPage.click_apply_gift_card()
    }

    @Step
    def click_check_gift_card_shopping_cart() {
        shoppingCartPage.click_check_gift_card()
    }

    @Step
    def delete_all_discounts_in_totals() {
        enter_prestige_cart("110222513333")
    }

    @Step
    def enter_data_for_shipping_shopping_cart() {
        shoppingCartPage.enter_data_for_shipping_shopping_cart()
    }

    @Step
    def click_button_get_quote() {
        shoppingCartPage.click_button_get_quote()
    }

    @Step
    def assert_quotes_appeared() {
        shoppingCartPage.assert_quotes_appeared()
    }

    @Step
    def select_shipping_and_update_total_shopping_cart() {
        shoppingCartPage.select_shipping_and_update_total_shopping_cart()
    }

    @Step
    def assert_total_updated_shopping_cart() {
        textGrandTotal = shoppingCartPage.getTextGrandTotalPrice()
        textShippingTotals = shoppingCartPage.getTextShippingTotals()
        textShipping = shoppingCartPage.getTextShipping()
        textTax = shoppingCartPage.getTextTax()
        shoppingCartPage.assert_total_updated_shopping_cart()
    }

    @Step
    def assert_shipping_tax_quote_on_checkout() {
        checkoutPage.assert_shipping_tax_quote_on_checkout(textShipping, textTax, textShippingTotals, textGrandTotal)
    }

    @Step
    def click_on_button_register() {
        loginPage.click_on_button_register()
    }

    @Step
    def click_on_link_forgot_password() {
        loginPage.click_on_link_forgot_password()
    }

    @Step
    def input_email_and_click_submit(String email) {
        loginPage.input_email_and_click_submit(email)
    }

    @Step
    def go_to_email_page(String email, String password) {
        loginPage.go_to_email_page(email, password)
    }

    @Step
    def input_new_password(String password) {
        loginPage.input_new_password(password)
    }

    @Step
    def assert_refinements_with_number_of_products() {
        cLPage.assert_refinements_with_number_of_products()
    }

    @Step
    def assert_refinements_colors_have_no_number_of_products() {
        cLPage.assert_refinements_colors_have_no_number_of_products()
    }

    @Step
    def click_refinement_size() {
        cLPage.click_refinement_size()
    }

    @Step
    def assert_refinement_size_checked_and_added_to_shopping_by() {
        cLPage.refinement_size_checked_and_added_to_shopping_by()
    }

    @Step
    def click_on_color_swatch_refinement() {
        cLPage.click_on_color_swatch_refinement()
    }

    @Step
    def assert_selected_color_swatch_attribute() {
        cLPage.assert_selected_color_swatch_attribute()
    }

    @Step
    def select_price_boundaries() {
        cLPage.select_price_boundaries()
    }

    @Step
    def assert_selected_price() {
        cLPage.assert_selected_price()
    }
}