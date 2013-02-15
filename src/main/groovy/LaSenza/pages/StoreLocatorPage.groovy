package LaSenza.pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import net.thucydides.core.annotations.DefaultUrl
import org.openqa.selenium.Alert

import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.Matchers.equalTo
import org.openqa.selenium.By

@DefaultUrl("http://localhost:9000/ustorelocator/location/map/")
class StoreLocatorPage extends ForAllPage{

    StoreLocatorPage(WebDriver driver){
        super(driver)
    }

    @FindBy(id = "address")
    private WebElement fieldAddress

    @FindBy(xpath = "//a[@class='sbToggle']")
    private WebElement selectRadius

    @FindBy(xpath = "//ul[@class='sbOptions']")
    private WebElement optionsRadius

    @FindBy(xpath = "//a[@href='#100']")
    private WebElement option100Miles

    @FindBy(xpath = "//div[@class='button-set']/button[1]")
    private WebElement buttonSearch

    @FindBy(id = "sidebar")
    private WebElement areaSearchResults

    @FindBy(xpath = "//div[@class='button-set']/button[2]")
    private WebElement buttonReset

    @FindBy(id = "marker-loc-3")
    private WebElement popUpEntryOnMap

    @FindBy(id = "locations-reset")
    private WebElement linkResetLocations

    @FindBy(xpath = "//a[@class='sbSelector']")
    private WebElement selectedValueRadius

    def assert_on_store_locator_page() {
        element(fieldAddress).shouldBeVisible()
    }

    def enter_text_to_search_field(String text) {
        element(fieldAddress).type(text)
    }

    def enter_radius_into_radius_field(String radius) {
        element(selectRadius).click()
        element(optionsRadius).waitUntilVisible()
        element(option100Miles).waitUntilVisible()
        element(option100Miles).click()
    }

    def click_button_search() {
        element(buttonSearch).click()
        Thread.sleep(2000)
    }

    def assert_pop_up_present() {
        Thread.sleep(2000)
        Alert alert = getDriver().switchTo().alert();
        assertThat(alert.getText(), equalTo("The address is not valid: "))
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

    def assert_search_results_contain_all_stores() {
        assertThat(getDriver().findElements(By.xpath("//div[@class='sidebar-entry-container']")).size(), equalTo(5))
    }

    def click_on_store_entry(def entryNumber) {
        getDriver().findElement(By.xpath("//div[@class='sidebar-entry-container'][${entryNumber}]//div")).click()
    }

    def click_on_direction() {
        getDriver().findElement(By.xpath("//a[contains(text(), 'Directions')]"))
    }

    def click_link_reset_store_locations() {
        element(linkResetLocations).click()
    }

    def assert_default_radius() {
        assertThat(element(selectedValueRadius).getText(), equalTo("25 Miles"))
    }
}
