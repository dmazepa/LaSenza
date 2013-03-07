package LaSenza.Steps

import LaSenza.steps.AdminPanelSteps
import LaSenza.steps.UserSteps
import net.thucydides.core.annotations.Steps
import org.jbehave.core.annotations.Given
import org.jbehave.core.annotations.Then
import org.jbehave.core.annotations.When

class SliderAsManagerSteps {

    @Steps
    AdminPanelSteps admin

    @Steps
    UserSteps user

    @Given("I am in admin panel")
    public void openAdminPanel() {
        admin.open_admin_panel()
    }

    @When("I create new banner")
    public void createNewBanner() {
        admin.create_new_banner()
    }

    @Then("I have added him to slider")
    public void addBannerToSlider() {
        admin.edit_banners_in_slider(true)
        admin.clean_cache()
    }

    @Then("I should see one more image for rotating carousel on home page")
    public void checkAddedImageOnFrontEnd() {
        user.opens_home_page_thucydides()
        user.assert_count_images_in_slider(5)
        admin.open_admin_panel()
        admin.edit_banners_in_slider(false)
        admin.clean_cache()
    }

    /*@AfterStories
    public void deleteBanner(){
        admin.open_admin_panel()
        admin.edit_banners_in_slider(false)
        //admin.delete_banner()       not work for chrome
        admin.clean_cache()
    }*/
}
