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
        homePage.open()
    }

    @Step
    def should_see_title(String title) {
        homePage.getTitle() == title
    }
}
