package LaSenza.pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

import static org.hamcrest.MatcherAssert.assertThat


class SearchPage extends ForAllPage{

    SearchPage(WebDriver driver){
        super(driver)
    }

    @FindBy(xpath = "//div[@class='breadcrumbs']/ul/li[2]")
    private WebElement breadcrumbsLevel2;

    @FindBy(xpath = "//p[@class='note-msg']")
    private WebElement blockMSGNoResults;

    @FindBy(xpath = "//div[@class='results-view']")
    private WebElement blockSearchResults;

    def assert_on_search_page() {
        getTitle().contains("Search results for")
        shouldContainText("Search results for")
        assertThat(element(breadcrumbsLevel2).getText(), containsText("Search results for:"))
    }

    def assert_no_results() {
        def p=element(blockMSGNoResults).getText()
        assertThat(element(blockMSGNoResults).getText(), containsText("Your search returns no results."))
        element(blockSearchResults).shouldNotBePresent()
    }
}
