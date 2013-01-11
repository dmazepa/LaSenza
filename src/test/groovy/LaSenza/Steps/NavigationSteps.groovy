package LaSenza.Steps

import LaSenza.steps.UserSteps
import net.thucydides.core.annotations.Steps
import org.jbehave.core.annotations.*

class NavigationSteps {

    @Steps
    UserSteps user

    @When('I click on SubCLP link in menu "$linkName".')
    public void click_on_subCLP_link_in_menu(String linkName){
        user.click_on_link_in_menu(linkName)
    }

    @When('I click on Collection "$nameCollection" link in menu.')
    public void click_on_collection_link_in_menu(String nameCollection){
        user.click_on_link_in_menu(nameCollection)
    }

    @When('I click on "$linkName" link in menu.')
    public void click_on_link_in_menu(String linkName){
        user.click_on_link_in_menu(linkName)
    }

    @Then('I should go to SubCLP "$nameSubCLP".')
    public void assert_on_subCLP(String nameSubCLP){
        user.assert_on_CLP(nameSubCLP)
    }

    @Then('I should go to "$nameCollection" Collection detail page.')
    public void assert_on_CP(String nameCollection){
        user.assert_on_CLP(nameCollection)
    }

    @Then('I should go to "$nameCLP" CLP.')
    public void assert_on_CLP(String nameCLP){
        user.assert_on_CLP(nameCLP)
    }

    @Then("I should go to chosen SubCLP with featured products.")
    public void assert_on_featured_products_page(){
        user.assert_on_CLP("Featured")
    }
}
