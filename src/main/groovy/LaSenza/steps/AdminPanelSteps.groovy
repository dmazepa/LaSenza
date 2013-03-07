package LaSenza.steps

import LaSenza.pages.AdminPanelPage
import LaSenza.pages.HomePage
import net.thucydides.core.annotations.Step
import net.thucydides.core.pages.Pages

class AdminPanelSteps extends UserSteps {
    HomePage homePage
    AdminPanelPage adminPage

    AdminPanelSteps(Pages pages) {
        super(pages)
        homePage = pages[HomePage]
        adminPage = pages[AdminPanelPage]
    }

    @Step
    def open_admin_panel() {
        adminPage.open_and_login()
    }

    @Step
    def create_new_banner() {
        open_form_for_new_banner()
        fill_banner_properties()
        go_to_content_tab_banner()
        fill_banner_content()
        save_banner()

    }

    @Step
    def save_banner() {
        adminPage.save_banner()
    }

    @Step
    def fill_banner_content() {
        adminPage.fill_banner_content()
    }

    @Step
    def go_to_content_tab_banner() {
        adminPage.go_to_content_tab_banner()
    }

    @Step
    def fill_banner_properties() {
        adminPage.fill_banner_properties()
    }

    @Step
    def open_form_for_new_banner() {
        adminPage.open_banner_manager()
        adminPage.click_add_banner()
    }

    @Step
    def edit_banners_in_slider(def add) {
        adminPage.open_static_blocks_manager()
        adminPage.open_CMS_block("slider-homepage-hero-image")
        adminPage.edit_CMS_block(add)
    }

    @Step
    def delete_banner() {
        adminPage.open_banner_manager()
        adminPage.find_and_delete_banner()
    }

    @Step
    def clean_cache() {
        adminPage.clean_cache()
    }

    @Step
    def set_cookie_time(def i) {
        adminPage.set_cookie_time(i)
    }

    @Step
    def restore_default_state() {
        open_admin_panel()
        set_cookie_time("3600")
    }

    @Step
    def open_product(def id) {
        adminPage.open_product(id)
    }

    @Step
    def set_product_qty(String qty) {
        adminPage.set_product_qty(qty)
    }

    @Step
    def set_product_visibility(String visibility) {
        adminPage.set_product_visibility(visibility)
    }

    @Step
    def set_brand_name_category(String brandName, def id) {
        adminPage.open_attribute_manager()
        adminPage.open_attribute_from_attribute_manager("Brand name")
        adminPage.set_attribute_value("Brand Name1")
        open_product(id)
        adminPage.set_product_brand_category(brandName)
    }

    @Step
    def create_coupon_code_if_not_exist() {
        open_admin_panel()
        open_catalog_price_rules()
        if (coupon_absent()) {
            create_coupon()
        }
    }

    @Step
    def create_coupon() {
        adminPage.create_coupon()
    }

    @Step
    boolean coupon_absent() {
        return adminPage.coupon_absent()
    }

    @Step
    def open_catalog_price_rules() {
        adminPage.open_catalog_price_rules()
    }

    @Step
    def set_cross_sells_for_product(int id) {
        search_product_cross_sells(id)
    }

    @Step
    def search_product_cross_sells(int id) {
        adminPage.search_product_cross_sells(id)
    }

    @Step
    def create_new_product_rule(String skuProductInCart, String skuCrossSellProduct) {
        adminPage.create_new_product_rule(skuProductInCart, skuCrossSellProduct)
    }

    @Step
    def open_menu_configuration() {
        adminPage.open_menu_configuration()
    }

    @Step
    def click_tab_store_locations() {
        adminPage.click_tab_store_locations()
    }

    @Step
    def set_search_radius_options(String radius) {
        adminPage.set_search_radius_options(radius)
    }
}
