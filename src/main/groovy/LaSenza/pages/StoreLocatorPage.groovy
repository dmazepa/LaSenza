package LaSenza.pages

import net.thucydides.core.annotations.DefaultUrl
import org.openqa.selenium.Alert
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.Matchers.equalTo

@DefaultUrl("http://localhost:9000/ustorelocator/location/map/")
class StoreLocatorPage extends ForAllPage {

    StoreLocatorPage(WebDriver driver) {
        super(driver)
    }

    @FindBy(id = "address")
    private WebElement fieldAddress

    @FindBy(name = "radius")
    private WebElement selectRadius

    @FindBy(xpath = "//ul[@class='sbOptions']")
    private WebElement optionsRadius

    @FindBy(xpath = "//div[@class='button-set']/button[1]")
    private WebElement buttonSearch

    @FindBy(id = "sidebar")
    private WebElement areaSearchResults

    @FindBy(xpath = "//div[@class='button-set']/button[2]")
    private WebElement buttonReset

    @FindBy(id = "locations-reset")
    private WebElement linkResetLocations

    @FindBy(xpath = "//a[contains(text(), 'Directions')]")
    private WebElement linkDirections

    @FindBy(xpath = "//table[@class='adp-directions']")
    private WebElement tableDirrections

    def assert_on_store_locator_page() {
        element(fieldAddress).shouldBeVisible()
    }

    def enter_text_to_search_field(String text) {
        element(fieldAddress).type(text)
    }

    def enter_radius_into_radius_field(String radius) {
        element(selectRadius).selectByValue("200")
    }

    def click_button_search() {
        element(buttonSearch).click()
        Thread.sleep(2000)
    }

    def assert_pop_up_present() {
        Thread.sleep(2000)
        Alert alert = getDriver().switchTo().alert();
        assertThat(alert.getText(), equalTo("Search does not seem to be valid address."))
        alert.accept()
    }

    def assert_no_results_store_locator() {
        assertThat(element(areaSearchResults).getText(), equalTo("No results found."))
    }

    def click_button_reset() {
        element(buttonReset).click()
    }

    def assert_search_field_clear_store_locator() {
        assertThat(element(fieldAddress).getText(), equalTo(""))
    }

    def assert_search_results_contains_stores(def i) {
        assertThat(getDriver().findElements(By.xpath("//div[@class='sidebar-entry-container']")).size(), equalTo(i))
    }

    def click_on_store_entry(def entryNumber) {
        getDriver().findElement(By.xpath("//div[@class='sidebar-entry-container'][${entryNumber}]//div")).click()
    }

    def click_on_direction() {
        element(linkDirections).waitUntilVisible()
        element(linkDirections).click()
    }

    def click_link_reset_store_locations() {
        element(linkResetLocations).click()
        Thread.sleep(1000)
    }

    def assert_default_radius() {
        assertThat(element(selectRadius).getSelectedVisibleTextValue().replaceAll("([ \\n])", ""), equalTo("25Kilometers"))
    }

    def assert_new_search_radius(String newRadius) {
        assertThat(element(selectRadius).getText().replaceAll("\\D", ""), equalTo(newRadius))
    }

    def assert_search_results_contains(String text, qty) {
        assertThat(getDriver().findElements(By.xpath("//div[@class='sidebar-entry-container']")).size(), equalTo(qty))
        assert element(areaSearchResults).getText().contains(text)
    }

    def assert_directions_appeared() {
        element(tableDirrections).shouldBeVisible()
    }
}
