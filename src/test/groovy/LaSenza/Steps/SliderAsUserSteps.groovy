package LaSenza.Steps

import LaSenza.steps.UserSteps
import net.thucydides.core.annotations.Steps
import org.jbehave.core.annotations.Given
import org.jbehave.core.annotations.Then
import org.jbehave.core.annotations.When

class SliderAsUserSteps {

    @Steps
    UserSteps user;

    @Given("I am on home page")
    public void givenIAmOnTheHomePage() {
        user.opens_home_page()
    }

    @When("I should see carousel cycles automatically through a series of hero images at 5 second intervals with a smooth (fade in / fade out) transition between carousel changes")
    public void assertCarousel() {
        user.assert_carousel()
    }

    @Then("A placeholder appears in the bottom of the carousel to indicate position within the carousel")
    public void assert_place_holder() {
        user.assert_place_holder_on_slider()
    }

    @When("I click controls in the bottom of the carousel")
    public void click_controls_of_slider() {
        user.click_on_second_image_of_slider()
    }

    @Then("Images vary from one to another")
    public void assert_changes_of_images(){
        user.assert_second_image_active()
    }
}
