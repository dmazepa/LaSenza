package LaSenza.Steps

import LaSenza.steps.UserSteps
import net.thucydides.core.annotations.Steps
import org.jbehave.core.annotations.*

class MainElementsSteps {

    @Steps
    UserSteps user

    @Given("I am on QW.")
    public void openQWSimple(){
        user.opens_CLP("/sale")
        user.open_quick_view()
    }

    @Given("I am on QW with one image.")
    public void openQWWithOneImage(){
        user.opens_CLP("/sale")
        user.open_quick_view()
    }

    @Given("I shouldn't see thumbnail images.")
    public void shouldNotSeeThumbnailImages(){
        user.assert_no_thumbnail_images_qw()
    }

    @When("I send Escape key.")
    public void sendESCKey(){
        user.send_esc_key()
    }

    @When("I click Close Button.")
    public void click_close_button(){
        user.click_close_button()
    }

    @When("I Clicking on <Element>.")
    public void click_on_element(String Element){
        user.click_on_qw_element(Element)
    }

    @When("I clicking outside of the Quickview window.")
    public void click_outside_qw(){
        user.click_outside_qw()
    }

    @Then("QW module should close.")
    public void quickViewShouldBeClosed(){
        user.assert_qw_absent()
    }

    @Then("QW module should close and customer navigates to the PDP.")
    public void quickViewClosedSendsToPDP(){
        user.assert_on_PDP()
    }
}
