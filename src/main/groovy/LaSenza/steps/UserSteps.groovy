package LaSenza.steps

import LaSenza.pages.CLPage
import LaSenza.pages.HomePage
import LaSenza.pages.LoginPage
import LaSenza.pages.PDPage
import net.thucydides.core.annotations.Pending
import net.thucydides.core.annotations.Step
import net.thucydides.core.pages.Pages
import net.thucydides.core.steps.ScenarioSteps

import static org.hamcrest.MatcherAssert.assertThat
import LaSenza.pages.CreateAccountPage
import LaSenza.pages.StoreLocatorPage
import LaSenza.pages.SearchPage

class UserSteps extends ScenarioSteps {

    HomePage homePage
    CLPage clPage
    PDPage pDPage
    LoginPage loginPage
    CreateAccountPage createAccountPage
    StoreLocatorPage  storeLocatorPage
    SearchPage  searchPage

    UserSteps(Pages pages){
        super(pages)
        homePage = pages[HomePage]
        homePage = pages[HomePage]
        clPage = pages[CLPage]
        pDPage = pages[PDPage]
        loginPage = pages[LoginPage]
        createAccountPage = pages[CreateAccountPage]
        storeLocatorPage = pages[StoreLocatorPage]
        searchPage = pages[SearchPage]
    }
    @Step
    def opens_home_page() {
        homePage.open()
    }
    @Step
    def should_see_title(String title) {
       assertThat(homePage.getTitle(), is(title))
    }
    @Step
    def assert_carousel() {
        click_on_first_image_of_slider()
        timeout(6000)
        homePage.assert_image_active(2)
        timeout(5000)
        homePage.assert_image_active(3)
    }

    @Step
    def timeout(int mSec) {
        //waitABit(mSec)
        Thread.sleep(mSec)
        //Thread.wait(mSec)
    }

    @Step
    def click_on_first_image_of_slider(){
        homePage.click_on_first_image_of_slider()
    }

    @Step
    def click_on_first_image_of_slider_and_assert_changes(){
        homePage.click_on_first_image_of_slider()
        homePage.assert_image_active(1)
    }

    @Step
    def assert_place_holder_on_slider() {
        homePage.assert_place_holder_on_slider()
    }

    @Step
    def opens_home_page_thucydides() {
        homePage.open1()
    }

    @Step
    def should_see_static_block_below_menu_panel() {
        homePage.assert_static_block_below_menu_panel()
    }

    @Step
    def opens_CLP(String categoryName) {
        getDriver().get("${System.getProperty("webdriver.base.url")}/${categoryName}.html")
    }

    @Step
    def opens_subCLP(String categoryName, String subCategoryName) {
        getDriver().get("${System.getProperty("webdriver.base.url")}/${categoryName}/${subCategoryName}.html")
    }

    @Step
    def opens_CP(String categoryName, String collectionName) {
        getDriver().get("${System.getProperty("webdriver.base.url")}/${categoryName}/collections/${collectionName}.html")
    }

    @Step
    def assert_default_location(String location) {
        homePage.assert_location(location)
    }

    @Step
    def click_on_select_location() {
        homePage.click_on_select_location()
    }

    @Step
    def waitForPopUP() {
        homePage.waitForPopUPLocation()
    }

    @Step
    def selectLocation(String location) {
        homePage.click_on_location_in_list(location)
    }

    @Step
    def assert_location(String location) {
        homePage.assert_location(location)
    }

    @Step
    def assert_count_images_in_slider(int i) {
        homePage.assert_cont_images_in_slider(i)
    }

    @Step
    def open_quick_view() {
        clPage.open_quick_w(1)
    }

    @Step
    def send_esc_key() {
        clPage.send_esc_key()
    }

    @Step
    def assert_qw_absent() {
        clPage.qw_should_be_absent()
    }

    @Step
    def click_outside_qw() {
        homePage.click_outside_qw()
    }

    def click_close_button() {
        clPage.click_close_button()
    }

    @Step
    def assert_no_thumbnail_images_qw() {
        clPage.qw_should_not_have_thumbnail_images()
    }

    @Step
    def click_on_element(String element) {
        clPage.click_on_qw_element(element)
    }

    @Step
    def assert_on_PDP() {
       pDPage.assert_on_PDP()
    }
    @Step
    def log_in() {
        loginPage.open1()
        if(homePage.return_logged_out()){
            loginPage.log_in("test1@speroteck.com", "testthis")
        }
    }

    @Step
    def click_on_search_field() {
        homePage.click_on_search_field()
    }

    @Step
    def assert_default_text_in_search_field_removes() {
        homePage.assert_default_text_in_search_field_removes()
    }

    @Step
    def refresh_page() {
        getDriver().navigate().refresh()
    }

    @Step
    def click_on_link_please_log_in() {
        homePage.click_on_link_please_log_in()
    }

    @Step
    def assert_on_login_page() {
        loginPage.assert_on_login_page()
    }

    @Step
    def assert_logged_out() {
        homePage.assert_logged_out()
    }

    @Step
    def assert_default_header() {
        homePage.assert_default_header()
    }

    @Step
    def click_on_link_my_account() {
        homePage.click_on_link_my_account()
    }

    @Step
    def click_on_link_my_wishlist() {
        homePage.click_on_link_my_wishlist()
    }

    @Step
    @Pending
    def assert_on_wish_list_login_page() {

    }

    @Step
    def should_see_welcomeMSG(String msg) {
        homePage.assert_welcome_msg(msg)
    }

    @Step
    def click_on_link_login() {
        homePage.click_on_link_login()
    }

    @Step
    def click_on_link_register() {
        homePage.click_on_link_register()
    }

    @Step
    def assert_on_create_account_page() {
        createAccountPage.assert_on_create_account_page()
    }

    @Step
    def click_on_link_store_locator() {
        homePage.click_on_link_store_locator()
    }

    @Step
    def assert_on_store_locator_page() {
        storeLocatorPage.assert_on_store_locator_page()
    }

    @Step
    def enter_text_to_the_search_field(String searchText) {
        homePage.enter_text_to_the_search_field(searchText)
    }

    @Step
    def click_on_search_button() {
        homePage.click_on_search_button()
    }

    @Step
    def assert_on_search_page() {
        searchPage.assert_on_search_page()
    }

    def assert_no_results() {
        searchPage.assert_no_results()
    }
}
