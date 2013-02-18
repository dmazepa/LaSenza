package LaSenza.Steps

import LaSenza.steps.UserSteps
import net.thucydides.core.annotations.Steps
import org.jbehave.core.annotations.*

class AddToCartConfigurableQwSteps {

    @Steps
    UserSteps user

    @When("Set multiple product conﬁgurations QV.")
    public void set_multiple_product_conﬁgurations_QV(){
        user.set_and_store_multiple_product_conﬁgurations_qv(2, 1, 2)
        user.set_and_store_multiple_product_conﬁgurations(3, 2, 1)
    }
}
