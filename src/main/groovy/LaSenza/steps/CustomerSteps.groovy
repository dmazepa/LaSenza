package LaSenza.steps

import LaSenza.pages.CLPage
import LaSenza.pages.MyAccountPage
import net.thucydides.core.annotations.Step
import net.thucydides.core.pages.Pages

class CustomerSteps extends UserSteps {
    CLPage cLPage
    MyAccountPage myAccountPage

    CustomerSteps(Pages pages) {
        super(pages)
        cLPage = pages[CLPage]
        myAccountPage = pages[MyAccountPage]
    }

    @Step
    def click_add_to_wishlist() {
        cLPage.click_on_add_to_wish_list()
    }

    @Step
    def assert_product_added_to_wishlist() {
        cLPage.QV_should_be_absent()
        myAccountPage.assert_product_added_to_wishlist(cLPage.get_product_name())
        delete_items_from_wish_list()
    }

    @Step
    def  delete_items_from_wish_list(){
        myAccountPage.delete_items_from_wish_list()

    }

    @Step
    def assert_welcome_msg(String welcomeMSG) {
        homePage.assert_welcome_msg(welcomeMSG)
    }

    @Step
    def assert_please_login_msg(String pleaseLoginNotTestTester) {
        homePage.assert_please_login_msg(pleaseLoginNotTestTester)
    }

    @Step
    def click_on_link_log_out() {
        homePage.click_on_link_log_out()
    }

    @Step
    def assert_on_my_account_dashboard_page() {
        myAccountPage.assert_on_my_account_dashboard_page()
    }

    @Step
    def assert_on_my_wishlist_page() {
        myAccountPage.assert_on_my_wishlist_page()
    }

    @Step
    def add_product_to_multi_wishlists() {
        set_items_qty_in_wish_list_header()
        open_pdp(1574)
        add_to_wishlist_from_pdp("Wishlist1")
        assert_item_added_to_wishlist_header()
        open_pdp(1574)
        add_to_wishlist_from_pdp("Wishlist2")
        assert_item_added_to_wishlist_header()
    }

    @Step
    Object set_items_qty_in_wish_list_header() {
        homePage.set_items_qty_in_wish_list_header()
    }

    @Step
    Object assert_item_added_to_wishlist_header() {
        homePage.assert_item_added_to_wishlist_header()
    }

    @Step
    def add_to_wishlist_from_pdp(String nameWishlist) {
        pDPage.add_to_wishlist_from_pdp(nameWishlist)
    }

    @Step
    def assert_logged_in() {
        homePage.assert_logged_in()
    }

    @Step
    def enter_new_shipping_address() {
        checkoutPage.uncheck_checkbox_use_billing_for_shipping()
        select_add_new_address()
        fill_first_name_shipping_field()
        fill_last_name_shipping_field()
        fill_address1_shipping_field()
        fill_city_shipping_field()
        fill_postal_code_shipping_field()
        fill_telephone_shipping_field()
    }

    @Step
    def select_add_new_address() {
        checkoutPage.select_add_new_address()
    }

    @Step
    def fill_telephone_shipping_field() {
        checkoutPage.fill_telephone_shipping_field()
    }

    @Step
    def fill_postal_code_shipping_field() {
        checkoutPage.fill_postal_code_shipping_field()
    }

    @Step
    def fill_city_shipping_field() {
        checkoutPage.fill_city_shipping_field()
    }

    @Step
    def fill_address1_shipping_field() {
        checkoutPage.fill_address1_shipping_field()
    }

    @Step
    def fill_last_name_shipping_field() {
        checkoutPage.fill_last_name_shipping_field()
    }

    @Step
    def fill_first_name_shipping_field() {
        checkoutPage.fill_first_name_shipping_field()
    }

    @Step
    def check_checkbox_save_address() {
        checkoutPage.check_checkbox_save_address()
    }

    @Step
    def pass_checkout() {
        enter_payment_information()
        checkoutPage.click_button_confirm_and_pay()
        checkoutPage.click_button_submit()
        thankYouPage.assert_thank_you_page()
        thankYouPage.setOrderNumber()
    }

    @Step
    def enter_payment_information() {
        checkoutPage.click_input_credit_cart("VI")
        checkoutPage.fill_cart_name("Visa")
        checkoutPage.fill_cart_number_field("4111111111111111")
        checkoutPage.select_month()
        checkoutPage.select_year()
        checkoutPage.fill_verification_number_field("111")
        checkoutPage.check_shipment()
    }

    @Step
    def open_my_account_address_book() {
        myAccountPage.go_to("customer/account/index/")
        myAccountPage.click_on_tab("Address Book")
    }

    @Step
    def assert_address_added() {
        myAccountPage.assert_address_added()
        myAccountPage.delete_additional_shipping_address()
    }

    @Step
    def open_quick_view_configurable() {
        cLPage.set_product_name(3)
        mouse_over_on_product_image(3)
        click_on_button_quick_view(3)
        Thread.sleep(1000)
    }

    @Step
    def delete_additional_shipping_address() {
        myAccountPage.delete_additional_shipping_address()
    }

    @Step
    def wait_for_thank_you_page() {
        thankYouPage.waitForThankYouPage()
    }

    @Step
    def assert_total_count_of_items_in_wishlists() {
        homePage.assert_total_count_of_items_in_wishlists()
    }

    @Step
    def clear_all_wish_lists() {
        set_items_qty_in_wish_list_header()
        if(homePage.get_qty_items_in_wishlist() != 0){
            open_my_account_wishlists()
            open_wish_list("Wishlist1")
            delete_items_from_wish_list()
            open_wish_list("Wishlist2")
            delete_items_from_wish_list()
        }
    }

    @Step
    def open_wish_list(String s) {
        myAccountPage.open_wish_list(s)
    }

    @Step
    def open_my_account_wishlists() {
        myAccountPage.go_to("customer/account/index/")
        myAccountPage.click_on_tab("My Wishlists")
    }
}
