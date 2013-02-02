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
    CLPage clPage
    PDPage pDPage
    LoginPage loginPage
    CreateAccountPage createAccountPage
    StoreLocatorPage  storeLocatorPage
    SearchPage  searchPage
    CLPage  cLPage
    CheckoutPage  checkoutPage
    ThankYouPage  thankYouPage

    UserSteps(Pages pages){
        super(pages)
        homePage = pages[HomePage]
        homePage = pages[HomePage]
        clPage = pages[CLPage]
        pDPage = pages[PDPage]
        loginPage = pages[LoginPage]
        createAccountPage = pages[CreateAccountPage]
        storeLocatorPage = pages[StoreLocatorPage]
        searchPage = pages[SearchPage]
        cLPage = pages[CLPage]
        checkoutPage = pages[CheckoutPage]
        thankYouPage = pages[ThankYouPage]
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
        timeout(7000)
        homePage.assert_image_active(2)
        timeout(5000)
        homePage.assert_image_active(3)
    }

    @Step
    def open_pdp(def id) {
        getDriver().get("${System.getProperty("webdriver.base.url")}catalog/product/view/id/${id}")
    }

    @Step
    def timeout(int mSec) {
        Thread.sleep(mSec)
    }

    @Step
    def click_on_first_image_of_slider(){
        homePage.click_on_first_image_of_slider()
    }

    @Step
    def click_on_first_image_of_slider_and_assert_changes(){
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
        clPage.send_esc_key()
    }

    @Step
    def assert_qw_absent() {
        clPage.qw_should_be_absent()
    }

    @Step
    def click_outside_qw() {
        cLPage.click_outside_qw()
    }

    def click_close_button() {
        clPage.click_close_button()
    }

    @Step
    def assert_no_thumbnail_images_qw() {
        clPage.qw_should_not_have_thumbnail_images()
    }

    @Step
    def click_on_qw_element(String element) {
        clPage.click_on_qw_element(element)
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
    def click_on_search_field() {
        homePage.click_on_search_field()
    }

    @Step
    def assert_default_text_in_search_field_removes() {
        homePage.assert_default_text_in_search_field_removes()
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
    def should_see_welcomeMSG(String msg) {
        homePage.assert_welcome_msg(msg)
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
        homePage.assert_qty_and_price_added_to_mini_cart(qty,price)
    }

    @Step
    def fill_qty(String qty) {
        pDPage.fill_qty(qty)
    }

    @Step
    def assert_item_not_added() {
        pDPage.assert_modal_window("The maximum quantity allowed for purchase is 10000.")
        homePage.assert_mini_cart_not_appears()
        homePage.assert_item_not_added()
    }

    @Step
    def store_state_of_total_price_and_qty() {
        homePage.store_state_of_total_price_and_qty()
    }

    @Step
    def choose_and_store_configurable_options() {
        choose_configurable_options()
        store_configurable_options()
    }

    def store_configurable_options() {
        pDPage.store_configurable_options()
    }

    @Step
    def choose_configurable_options() {
        pDPage.choose_configurable_options()
    }


    @Step
    def open_quick_view() {
        cLPage.open_quick_w(2)
    }

    @Step
    def open_second_step_of_checkout() {
        open_first_step_of_checkout(1472)
        enter_valid_data_on_checkout_page("test1@speroteck.com", "111")
        click_button_confirm_and_pay()
    }

    @Step
    def enter_valid_data_on_checkout_page(def email, def verificationNumber) {
        enter_valid_billing_data(email)
        enter_payment_inf(verificationNumber)
        check_shipment();
    }

    @Step
    def enter_payment_inf(def verificationNumber) {
        click_input_credit_cart();
        fill_cart_name();
        fill_cart_number_field();
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
    def fill_cart_number_field() {
        checkoutPage.fill_cart_number_field()
    }

    @Step
    def fill_cart_name() {
        checkoutPage.fill_cart_name()
    }

    @Step
    def click_input_credit_cart() {
        checkoutPage.click_input_credit_cart()
    }

    @Step
    def fill_telephone_field() {
        checkoutPage.fill_telephone_field()
    }

    @Step
    def fill_postal_code_field() {
        checkoutPage.fill_postal_code_field()
    }

    @Step
    def select_state() {
        checkoutPage.select_state()
    }

    @Step
    def fill_city_field() {
        checkoutPage.fill_city_field()
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
        if(no_items_in_cart()){
            open_pdp(id)
            if(pDPage.contain_configurable_options()){
                choose_configurable_options()
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
        choose_configurable_options()
        click_add_to_cart_button_pdp()
        refresh_page()
    }

    @Step
    def set_qty_on_pdp(String qty) {
        pDPage.fill_qty(qty)
    }

    @Step
    def click_on_element_in_shopping_cart_area(String element) {
        homePage.click_on_click_on_element_in_shopping_cart_area(element)
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
        homePage.move_mouse_on_menu("bras")
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
    def enter_valid_billing_data(def email) {
        fill_email_field(email);
        fill_first_name_field();
        fill_last_name_field();
        fill_address1_field();
        fill_address2_field();
        fill_city_field();
        select_state();
        fill_postal_code_field();
        fill_telephone_field();
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
        enter_valid_data_on_checkout_page("test1@speroteck.com", "1111")
        click_button_confirm_and_pay()
    }

    @Step
    def assert_error_message_wrong_payment() {
        Thread.sleep(3000)
        Alert alert = getDriver().switchTo().alert();
        assertThat(alert.getText(), equalTo("Please enter a valid credit card verification number."))
        alert.accept()
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
    def message_appears_promo_code_applied() {
        checkoutPage.message_appears_promo_code_applied()
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
    def assert_search_results_contain_all_stores() {
        storeLocatorPage.assert_search_results_contain_all_stores()
    }

    @Step
    def click_on_store_entry(def entryNumber) {
        storeLocatorPage. click_on_store_entry(entryNumber)
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
    def open_create_account_page() {
        homePage.open()
        homePage.click_on_link_login()
        loginPage.click_on_button_register()
    }

    @Step
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
}
