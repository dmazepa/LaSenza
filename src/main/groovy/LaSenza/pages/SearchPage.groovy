package LaSenza.pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.Matchers.equalTo

class SearchPage extends ForAllPage {

    SearchPage(WebDriver driver) {
        super(driver)
    }

    @FindBy(xpath = "//div[@class='breadcrumbs']/ul/li[2]")
    private WebElement breadcrumbsLevel2;

    @FindBy(xpath = "//h1")
    private WebElement titlePage

    @FindBy(xpath = "//p[@class='note-msg']")
    private WebElement blockMSGNoResults;

    @FindBy(xpath = "//div[@class='results-view']")
    private WebElement blockSearchResults;

    def assert_on_search_page() {
        getTitle().equals("Search results for \'text1\'")
        assertThat(element(titlePage).getText(), equalTo("SEARCH RESULTS FOR \'TEXT1\'"))
        assertThat(element(breadcrumbsLevel2).getText(), equalTo("SEARCH RESULTS FOR \'TEXT1\'"))
    }

    def assert_no_results() {
        assertThat(element(blockMSGNoResults).getText(), containsText("Your search returned no results."))
        element(blockSearchResults).shouldNotBePresent()
    }
}
