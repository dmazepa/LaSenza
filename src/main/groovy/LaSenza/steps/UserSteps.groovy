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
        //timeout(5000)
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
    def click_on_second_image_of_slider(){
        homePage.click_on_second_image_of_slider()
    }

    @Step
    def assert_second_image_active(){
        homePage.assert_second_image_active()
    }

    @Step
    def assert_place_holder_on_slider() {
        homePage.assert_place_holder_on_slider()
    }
}
