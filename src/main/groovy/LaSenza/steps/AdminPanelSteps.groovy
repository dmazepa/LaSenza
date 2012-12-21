package LaSenza.steps

import LaSenza.pages.AdminPanelPage
import LaSenza.pages.HomePage
import net.thucydides.core.annotations.Step
import net.thucydides.core.pages.Pages

class AdminPanelSteps extends UserSteps{
    HomePage homePage
    AdminPanelPage adminPage

    AdminPanelSteps (Pages pages) {
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
    def set_cookie_time(int seconds) {
        adminPage.set_cookie_time("10")
    }
}
