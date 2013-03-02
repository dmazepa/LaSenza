package LaSenza.Steps

import LaSenza.steps.UserSteps
import net.thucydides.core.annotations.Steps
import org.jbehave.core.annotations.*

class EditProductsSteps {

    @Steps
    UserSteps user

    @Given("I am on shopping cart as User with simple product in cart.")
    public void open_shopping_cart_as_user_with_simple_product(){
        user.open_pdp(1472)
        user.click_add_to_cart_button_pdp()
        user.open_shopping_cart()
    }

    @Given("Edit item link does not shows for simple products.")
    public void assert_link_edit_on_shopping_cart_absent(){
        user.assert_link_edit_on_shopping_cart_absent()
    }

    @Given("I am on shopping cart as User with configurable product in cart.")
    public void open_shopping_cart_as_user_with_configurable_product(){
        user.open_pdp(1574)
        user.choose_configurable_options(1)
        user.click_add_to_cart_button_pdp()
        user.open_shopping_cart()    }
}
