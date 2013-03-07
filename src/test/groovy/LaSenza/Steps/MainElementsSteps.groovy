package LaSenza.Steps

import LaSenza.steps.UserSteps
import net.thucydides.core.annotations.Steps
import org.jbehave.core.annotations.Given
import org.jbehave.core.annotations.Then
import org.jbehave.core.annotations.When

class MainElementsSteps {

    @Steps
    UserSteps user

    @Given("I am on QV.")
    public void openQVSimple() {
        user.opens_CLP("/sale")
        user.open_quick_view(3)
    }

    @Given("I am on QV with one image.")
    public void openQVWithOneImage() {
        user.opens_CLP("/sale")
        user.open_quick_view(1)
    }

    @Given("I shouldn't see thumbnail images.")
    public void shouldNotSeeThumbnailImages() {
        user.assert_no_thumbnail_images_QV()
    }

    @When("I send Escape key.")
    public void sendESCKey() {
        user.send_esc_key()
    }

    @When("I click Close Button.")
    public void click_close_button() {
        user.click_close_button()
    }

    @When("I Clicking on <Element>.")
    public void click_on_element(String Element) {
        user.click_on_QV_element(Element)
    }

    @When("I clicking outside of the Quickview window.")
    public void click_outside_QV() {
        user.click_outside_QV()
    }

    @Then("QV module should close.")
    public void quickViewShouldBeClosed() {
        user.assert_QV_absent()
    }

    @Then("QV module should close and customer navigates to the PDP.")
    public void quickViewClosedSendsToPDP() {
        user.assert_on_PDP()
    }
}
