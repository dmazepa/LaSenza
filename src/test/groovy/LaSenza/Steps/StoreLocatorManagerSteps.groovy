package LaSenza.Steps

import net.thucydides.core.annotations.Steps
import LaSenza.steps.AdminPanelSteps
import LaSenza.steps.UserSteps
import org.jbehave.core.annotations.*

class StoreLocatorManagerSteps {

    @Steps
    AdminPanelSteps admin

    @Steps
    UserSteps user

    @When("I specify a search radius.")
    public void specify_search_radius(){
        admin.open_menu_configuration()
        admin.click_tab_store_locations()
        admin.set_search_radius_options("30,80,500")
    }

    @Then("I can see edited values on Store Locator page.")
    public void assert_new_radius(){
        user.open_store_locator_page()
        user.assert_new_search_radius("3080500")
        admin.open_admin_panel()
        admin.open_menu_configuration()
        admin.click_tab_store_locations()
        admin.set_search_radius_options("25,100,200")
    }
}
