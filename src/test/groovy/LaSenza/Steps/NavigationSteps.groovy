package LaSenza.Steps

import LaSenza.steps.UserSteps
import net.thucydides.core.annotations.Steps
import org.jbehave.core.annotations.Then
import org.jbehave.core.annotations.When

class NavigationSteps {

    @Steps
    UserSteps user

    @When('I click on SubCLP link in menu "$linkName".')
    public void click_on_subCLP_link_in_menu(String linkName) {
        user.click_on_link_in_menu(linkName)
    }

    @When('I click on Collection "$nameCollection" link in menu.')
    public void click_on_collection_link_in_menu(String nameCollection) {
        user.click_on_link_in_menu(nameCollection)
    }

    @When('I click on "$linkName" link in menu.')
    public void click_on_link_in_menu(String linkName) {
        user.click_on_link_in_menu(linkName)
    }

    @Then('I should go to SubCLP "$nameSubCLP".')
    public void assert_on_subCLP(String nameSubCLP) {
        user.assert_on_CLP(nameSubCLP)
    }

    @Then('I should go to "$nameCollection" Collection detail page.')
    public void assert_on_CP(String nameCollection) {
        user.assert_on_CLP(nameCollection)
    }

    @Then('I should go to "$nameCLP" CLP.')
    public void assert_on_CLP(String nameCLP) {
        user.assert_on_CLP(nameCLP)
    }

    @Then("I should go to chosen SubCLP with featured products.")
    public void assert_on_featured_products_page() {
        user.assert_on_CLP("Featured")
    }

    @When('I click on View All Offers link in menu "$categoryName".')
    public void click_view_all_offers(String categoryName) {
        user.move_mouse_on_menu(categoryName)
        user.click_on_link_in_menu("View all offers")
    }

    @Then("I should go to chosen SubCLP with single static block.")
    public void assert_on_subCLP_with_single_static_block() {
        user.assert_on_subCLP_with_single_static_block()
    }

    @Then("I should go to chosen SubCLP with static block and left navigation.")
    public void assert_on_subCLP_with_static_block_and_left_navigation() {
        user.assert_on_subCLP_with_left_navigation()
        user.assert_on_subCLP_with_single_static_block()
    }

    @When("I move mouse to the category with dropdown menu.")
    public void move_mouse_to_category() {
        user.move_mouse_on_menu("bras")
    }

    @Then("I should see dropdown menu.")
    public void assert_drop_down_menu_opened() {
        user.assert_drop_down_menu_opened()
    }
}
