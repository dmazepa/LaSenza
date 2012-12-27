package LaSenza.pages

import net.thucydides.core.annotations.DefaultUrl
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

import static org.hamcrest.MatcherAssert.assertThat

@DefaultUrl("http://lasenza-dev.lcgosc.com/develop")
class HomePage extends ForAllPage{

    HomePage(WebDriver driver){
        super(driver)
    }

    @FindBy(xpath = "//div[@class='global-header-banner']/img")
    private WebElement globalHeaderBanner;

    @FindBy(xpath = "//div/div")
    private WebElement someElement;

    @FindBy(xpath = "//span[@class='welcome-msg']")
    private WebElement blockWelcomeMsg;

    @FindBy(xpath = "//a[@class='unset-cookie']")
    private WebElement linkNotUserNameUserLastName;

    @FindBy(xpath = "//a[@title='Login']")
    private WebElement linkLogIn;

    @FindBy(xpath = "//a[@title='register']")
    private WebElement linkRegister;

    @FindBy(xpath = "//a[@title='My Account']")
    private WebElement linkMyAccount;

    @FindBy(xpath = "//a[@title='My Wishlists']")
    private WebElement linkMyWishlist;

    @FindBy(xpath = "//a[@title='Log Out']")
    private WebElement linkLogOut;

    @FindBy(id = "popId-languageSelect")
    private WebElement popUpListLocations;

    @FindBy(id = "search")
    private WebElement fieldSearch;

    @FindBy(xpath = "//div[@class='switch switcher-language']")
    private WebElement selectLocation;

    @FindBy(xpath = "//div[@id='slider_homepage']/ul/li[1]/a")
    private WebElement buttonFirstImageSlider;

    @FindBy(xpath = "//div[@id='slider_homepage']/ul/li[2]/a")
    private WebElement buttonSecondImageSlider;

    @FindBy(xpath = "//div[@id='slider_homepage']/div/ul/div/li[1]/img")
    private WebElement sliderImage1;

    @FindBy(xpath = "//div[@id='slider_homepage']/div/ul/div/li[2]/img")
    private WebElement sliderImage2;

    @FindBy(xpath = "//div[@id='slider_homepage']/div/ul/div/li[3]/img")
    private WebElement sliderImage3;

    def click_on_first_image_of_slider() {
        element(sliderImage1).waitUntilNotVisible()
        System.out.println(element(sliderImage1).isCurrentlyVisible());
        System.out.println(element(sliderImage2).isCurrentlyVisible());
        System.out.println(element(sliderImage3).isCurrentlyVisible());
        element(buttonFirstImageSlider).click();
        element(sliderImage1).waitUntilVisible()
        //waitABit(2000)
        Thread.sleep(2000)
        System.out.println(element(sliderImage1).isCurrentlyVisible());
        System.out.println(element(sliderImage2).isCurrentlyVisible());
        System.out.println(element(sliderImage3).isCurrentlyVisible());
    }

    def assert_place_holder_on_slider() {
        element(buttonFirstImageSlider).shouldBePresent();
        element(buttonSecondImageSlider).shouldBePresent();
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

    def assert_image_active(int imageNumber) {
        System.out.println(element(sliderImage1).isCurrentlyVisible());
        System.out.println(element(sliderImage2).isCurrentlyVisible());
        System.out.println(element(sliderImage3).isCurrentlyVisible());
        if (imageNumber != 1) {
            assert !element(By.xpath("//div[@id='slider_homepage']/div/ul/div/li[${imageNumber-1}]/img")).isCurrentlyVisible()
        }
        assert element(By.xpath("//div[@id='slider_homepage']/div/ul/div/li[${imageNumber}]/img")).isCurrentlyVisible()
    }

    def assert_cont_images_in_slider(int i) {
        assert getDriver().findElements(By.xpath("//div[@id='slider_homepage']/ul/li")).size() == i
    }

    def click_outside_qw() {
        element(someElement).click()
    }

    def assert_welcome_msg(def welcomeMSG) {
        assertThat(blockWelcomeMsg.getText(), is(welcomeMSG))
    }

    def click_on_search_field() {
        element(fieldSearch).click()
    }

    def assert_default_text_in_search_field_removes() {

    }

    def open1() {
        getDriver().get(System.getProperty("webdriver.base.url"))
    }

    def assert_please_login_msg(String pleaseLoginNotTestTester) {
        assertThat(linkNotUserNameUserLastName.getText(), is(pleaseLoginNotTestTester))
    }

    def click_on_link_please_log_in() {
        element(linkNotUserNameUserLastName).click()
    }

    def assert_logged_out() {
       element(linkLogIn).shouldBeVisible()
    }

    def return_logged_out() {
       return element(linkLogIn).isVisible()
    }

    def assert_default_header() {
        element(linkRegister).shouldBeVisible()
    }

    def click_on_link_my_account() {
        element(linkMyAccount).click()
    }

    def click_on_link_my_wishlist() {
        element(linkMyWishlist).click()
    }

    def click_on_link_log_out() {
        element(linkLogOut).click()
    }
}
