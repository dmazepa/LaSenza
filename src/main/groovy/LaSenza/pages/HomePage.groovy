package LaSenza.pages

import net.thucydides.core.pages.PageObject
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class HomePage extends PageObject{

    HomePage(WebDriver driver){
        super(driver)
    }
    @FindBy(xpath = "//div[@id='slider_homepage']/div/ul/div/li[1]")
    private WebElement sliderImage1;

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

    def assert_first_image_active(){
        assert !element(sliderImage2).isCurrentlyVisible()
        assert element(sliderImage1).isCurrentlyVisible()
    }

    def assert_second_image_active(){
        System.out.println(element(sliderImage1).isCurrentlyVisible());
        System.out.println(element(sliderImage2).isCurrentlyVisible());
        System.out.println(element(sliderImage3).isCurrentlyVisible());
        System.out.println(element(sliderImage4).isCurrentlyVisible());
        assert !element(sliderImage1).isCurrentlyVisible()
        assert element(sliderImage2).isCurrentlyVisible()
    }

    def assert_third_image_active(){
        System.out.println(element(sliderImage1).isCurrentlyVisible());
        System.out.println(element(sliderImage2).isCurrentlyVisible());
        System.out.println(element(sliderImage3).isCurrentlyVisible());
        System.out.println(element(sliderImage4).isCurrentlyVisible());
        assert !element(sliderImage2).isCurrentlyVisible()
        assert element(sliderImage3).isCurrentlyVisible()
    }

    def click_on_first_image_of_slider() {
        element(buttonFirstImageSlider).click();
    }

    def click_on_second_image_of_slider() {
        element(sliderImage3).shouldBeCurrentlyVisible()
        element(buttonSecondImageSlider).click();
    }

    def assert_place_holder_on_slider() {
        element(buttonFirstImageSlider).shouldBePresent();
        element(buttonSecondImageSlider).shouldBePresent();
    }

    def waitForSecondImageActive() {
        element(sliderImage2).waitUntilVisible()
    }
}
