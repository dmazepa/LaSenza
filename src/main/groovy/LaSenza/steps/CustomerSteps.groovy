package LaSenza.steps

import LaSenza.pages.CLPage
import net.thucydides.core.pages.Pages
import LaSenza.pages.MyAccountPage
import net.thucydides.core.annotations.Step

class CustomerSteps extends UserSteps{
    CLPage cLPage
    MyAccountPage myAccountPage

    CustomerSteps (Pages pages) {
        super(pages)
        cLPage = pages[CLPage]
        myAccountPage = pages[MyAccountPage]
    }

    @Step
    def open_quick_view_configurable() {
        cLPage.open_quick_w(3)
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
}
