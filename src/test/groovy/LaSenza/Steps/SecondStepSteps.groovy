package LaSenza.Steps

import org.jbehave.core.annotations.Given
import net.thucydides.core.annotations.Steps
import LaSenza.steps.UserSteps

class SecondStepSteps {

    @Steps
    UserSteps user

    @Given("I am on second step of checkout process with valid information.")
    public void on_second_step_of_checkout(){
        user.open_second_step_of_checkout()
    }
}
