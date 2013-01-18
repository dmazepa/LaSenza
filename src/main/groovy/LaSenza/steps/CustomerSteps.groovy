package LaSenza.steps

import LaSenza.pages.CLPage
import LaSenza.pages.MyAccountPage
import net.thucydides.core.annotations.Pending
import net.thucydides.core.annotations.Step
import net.thucydides.core.pages.Pages

class CustomerSteps extends UserSteps{
    CLPage cLPage
    MyAccountPage myAccountPage

    CustomerSteps (Pages pages) {
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
        cLPage.qw_should_be_absent()
        myAccountPage.assert_product_added_to_wishlist()
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
        open_pdp(3067)
        add_to_wishlist_from_pdp("Wishlist1")
        open_pdp(3067)
        add_to_wishlist_from_pdp("Wishlist2")
    }

    @Step
    @Pending
    def add_to_wishlist_from_pdp(String nameWishlist) {
        pDPage.add_to_wishlist_from_pdp(nameWishlist)
    }

    @Step
    def assert_logged_in() {
        homePage.assert_logged_in()
    }
}
