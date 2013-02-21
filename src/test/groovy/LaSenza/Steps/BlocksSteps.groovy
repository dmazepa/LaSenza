package LaSenza.Steps

import LaSenza.steps.UserSteps
import net.thucydides.core.annotations.Steps
import org.jbehave.core.annotations.Then
import org.jbehave.core.annotations.When

class BlocksSteps {

    @Steps
    UserSteps user

    @When('I move mouse on "$nameMenu" menu.')
    public void move_mouse_on_menu(String nameMenu) {
        user.move_mouse_on_menu(nameMenu)
    }

    @Then("I shouldn't see collections block.")
    public void assert_no_collections_block_in_menu() {
        user.assert_no_collections_block_in_menu()
    }

    @Then("I should see static block instead collections.")
    public void assert_static_block_instead_collections_in_menu() {
        user.assert_static_block_instead_collections_in_menu()
    }

    @Then("I should see block with main categories.")
    public void assert_main_categories_in_menu_sale() {
        user.assert_main_categories_in_menu_sale()
    }

    @Then("I should see 3 static blocks.")
    public void assert_3_static_blocks_in_menu_sale() {
        user.assert_3_static_blocks_in_menu_sale()
    }
}
