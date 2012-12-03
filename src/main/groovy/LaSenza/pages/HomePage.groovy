package LaSenza.pages

import net.thucydides.core.pages.PageObject
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.By

class HomePage extends PageObject{

    HomePage(WebDriver driver){
        super(driver)
    }
    @FindBy(xpath = "//div[@id='slider_homepage']/div/ul/div/li[1]")
    private WebElement sliderImage1;

    @FindBy(xpath = "//div[@class='global-header-banner']/img")
    private WebElement globalHeaderBanner;

    @FindBy(id = "popId-languageSelect")
    private WebElement popUpListLocations;

    @FindBy(xpath = "//div[@class='switch switcher-language']")
    private WebElement selectLocation;



    @FindBy(xpath = "//div[@id='slider_homepage']/ul/li[1]/a")
    private WebElement buttonFirstImageSlider;

    @FindBy(xpath = "//div[@id='slider_homepage']/ul/li[2]/a")
    private WebElement buttonSecondImageSlider;

    @FindBy(xpath = "//div[@id='slider_homepage']/ul/li[3]/a")
    private WebElement buttonThirdImageSlider;

    @FindBy(xpath = "//div[@id='slider_homepage']/div/ul/div/li[2]/img")
    private WebElement sliderImage2;

    @FindBy(xpath = "//div[@id='slider_homepage']/div/ul/div/li[3]/img")
    private WebElement sliderImage3;

    @FindBy(xpath = "//div[@id='slider_homepage']/div/ul/div/li[4]/img")
    private WebElement sliderImage4;

    def assert_second_image_active(){
        /*System.out.println(element(sliderImage1).isCurrentlyVisible());
        System.out.println(element(sliderImage2).isCurrentlyVisible());
        System.out.println(element(sliderImage3).isCurrentlyVisible());
        System.out.println(element(sliderImage4).isCurrentlyVisible());*/
        assert !element(sliderImage1).isCurrentlyVisible()
        assert element(sliderImage2).isCurrentlyVisible()
    }

    def click_on_first_image_of_slider() {
        element(buttonFirstImageSlider).click();

    }

    def click_on_second_image_of_slider_and_assert_changes() {
        element(buttonSecondImageSlider).click();
        assert !element(sliderImage1).isCurrentlyVisible()
        assert element(sliderImage2).isCurrentlyVisible()
    }

    def assert_place_holder_on_slider() {
        element(buttonFirstImageSlider).shouldBePresent();
        element(buttonSecondImageSlider).shouldBePresent();
    }

    def open1() {
        getDriver().get(System.getProperty("webdriver.base.url"))
    }

    def assert_static_block_below_menu_panel() {
        element(globalHeaderBanner).shouldBeVisible()
    }

    def assert_location(String location) {
        assert getDriver().findElements(By.xpath("//strong[@class='current language-${location}']")) != []
        assert getDriver().getCurrentUrl().contains("?___store=${location}")
    }

    def click_on_select_location() {
        element(selectLocation).click()
    }

    def waitForPopUPLocation() {
        element(popUpListLocations).waitUntilVisible()
    }

    def click_on_location_in_list(String location) {
        getDriver().findElement(By.xpath("//li[@class='language-${location}']")).click()
    }
}
