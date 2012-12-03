package LaSenza.steps

import net.thucydides.core.pages.Pages
import net.thucydides.core.steps.ScenarioSteps
import LaSenza.pages.HomePage
import net.thucydides.core.annotations.Step


class UserSteps extends ScenarioSteps {

    HomePage homePage

    UserSteps(Pages pages){
        super(pages)
        homePage = pages[HomePage]
    }
    @Step
    def opens_home_page() {
        homePage.open1()
    }
    @Step
    def should_see_title(String title) {
        homePage.getTitle() == title
    }
    @Step
    def assert_carousel() {
        click_on_first_image_of_slider()
        timeout(4000)
        assert_second_image_active()
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
    def click_on_second_image_of_slider_and_assert_changes(){
        homePage.click_on_second_image_of_slider_and_assert_changes()
    }

    @Step
    def assert_place_holder_on_slider() {
        homePage.assert_place_holder_on_slider()
    }

    @Step
    def opens_home_page_thucydides() {
        homePage.open()
    }

    @Step
    def should_see_static_block_below_menu_panel() {
        homePage.assert_static_block_below_menu_panel()
    }

    @Step
    def opens_CLP(String categoryName) {
        getDriver().get("${System.getProperty("webdriver.base.url")}/${categoryName}.html")
    }

    def opens_subCLP(String categoryName, String subCategoryName) {
        getDriver().get("${System.getProperty("webdriver.base.url")}/${categoryName}/${subCategoryName}.html")
    }

    def opens_CP(String categoryName, String collectionName) {
        getDriver().get("${System.getProperty("webdriver.base.url")}/${categoryName}/collections/${collectionName}.html")
    }
}
