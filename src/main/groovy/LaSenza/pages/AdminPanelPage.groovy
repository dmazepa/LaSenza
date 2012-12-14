package LaSenza.pages

import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.Alert
import org.openqa.selenium.By

class AdminPanelPage extends HomePage{

    def bannerID

    AdminPanelPage(WebDriver driver){
        super(driver)
    }

    @FindBy(id = "username")
    private WebElement fieldUserName

    @FindBy(id = "login")
    private WebElement fieldPassword

    @FindBy(id = "banner_properties_name")
    private WebElement fieldBannerName

    @FindBy(id = "banner_info_tabs_content_section")
    private WebElement tabContentBanner

    @FindBy(id = "banner_content_store_default_content")
    private WebElement areaContentBanner

    @FindBy(id = "cmsBlockGrid_filter_identifier")
    private WebElement fieldFindByIDCMSBlock

    @FindBy(id = "bannerGrid_banner_filter_banner_name")
    private WebElement fieldFindByNameBanner

    @FindBy(id = "bannerGrid_massaction-select")
    private WebElement selectAction

    @FindBy(id = "block_content")
    private WebElement areaCMSBlockContent

    @FindBy(id = "toggleblock_content")
    private WebElement buttonHideEditor

    @FindBy(id = "loading_mask_loader")
    private WebElement blockLoading

    @FindBy(xpath = "//input[@class='form-button']")
    private WebElement buttonLogin

    @FindBy(xpath = "//table[@id='cmsBlockGrid_table']/tbody/tr[1]")
    private WebElement stringTableToGetTitle

    @FindBy(xpath = "//table[@id='bannerGrid_table']/tbody/tr[1]/td[2]")
    private WebElement cellBannerID

    @FindBy(xpath = "//button[@title='Save Banner']")
    private WebElement buttonSaveBanner

    @FindBy(xpath = "//button[@title='Save Block']")
    private WebElement buttonSaveBlock

    @FindBy(xpath = "//li[@class='success-msg']")
    private WebElement blockSuccessMsg

    @FindBy(xpath = "//ul[@id='nav']/li[8]/ul/li[3]/a")
    private WebElement subMenuBanner

    @FindBy(xpath = "//ul[@id='nav']/li[8]/ul/li[2]/a")
    private WebElement subMenuStaticBlocks

    @FindBy(xpath = "//ul[@id='nav']/li[11]/ul/li[15]/a")
    private WebElement subMenuCleanCache

    @FindBy(xpath = "//button[@class='scalable add']")
    private WebElement buttonAddBanner

    @FindBy(xpath = "//button[@class='scalable delete']")
    private WebElement buttonFlushMagentoCache

    def goTo(additionUrl){
        getDriver().get("${System.getProperty("webdriver.base.url")}/${additionUrl}")
    }

    def open_and_login() {
        goTo("admin")
        if (getDriver().findElements(By.id("username")) != []){
            element(fieldUserName).type("admin")
            element(fieldPassword).type("qwer1234")
            element(buttonLogin).click()
        }
    }

    def fill_banner_properties() {
        element(fieldBannerName).type("TestBaner")
    }

    def go_to_content_tab_banner() {
        element(tabContentBanner).click()
    }

    def fill_banner_content() {
        element(areaContentBanner).type("<img src=\"{{media url=\"wysiwyg/slider-hero-image-01.jpg\"}}\" alt=\"\" />")
    }

    def save_banner() {
        element(buttonSaveBanner).click()
        element(blockSuccessMsg).shouldBeVisible()
        bannerID = element(cellBannerID).getText()
    }

    def open_banner_manager() {
        getDriver().get(subMenuBanner.getAttribute("href"))
    }

    def click_add_banner() {
        element(buttonAddBanner).waitUntilVisible().click()
    }

    def open_static_blocks_manager() {
        getDriver().get(subMenuStaticBlocks.getAttribute("href"))
    }

    def open_CMS_block(String id) {
        element(fieldFindByIDCMSBlock).typeAndEnter(id)
        getDriver().get(stringTableToGetTitle.getAttribute("title"))
    }

    def edit_CMS_block(def addBanner) {
        element(buttonHideEditor).click()
        element(areaCMSBlockContent).waitUntilVisible().clear()
        if (addBanner){
            element(areaCMSBlockContent).type("<div id=\"slider_homepage\">{{widget type=\"enterprise_banner/widget_banner\" display_mode=\"fixed\" banner_ids=\"3,4,5,6,${bannerID}\" template=\"banner/widget/block.phtml\"}}</div>")
        } else {
            element(areaCMSBlockContent).type("<div id=\"slider_homepage\">{{widget type=\"enterprise_banner/widget_banner\" display_mode=\"fixed\" banner_ids=\"3,4,5,6\" template=\"banner/widget/block.phtml\"}}</div>")
        }
        element(buttonSaveBlock).click()
        element(blockSuccessMsg).waitUntilVisible()
    }

    def find_and_delete_banner() {
        element(fieldFindByNameBanner).typeAndEnter("TestBaner")
        element(blockLoading).waitUntilNotVisible()
        ((JavascriptExecutor) driver).executeScript('return bannerGrid_massactionJsObject.selectAll()')
        element(selectAction).selectByValue("delete")
        //((JavascriptExecutor) driver).executeScript('bannerGrid_massactionJsObject.apply()')
        getDriver().findElement(By.xpath("//button[@title='Submit']")).click()
        Alert alert = getDriver().switchTo().alert();
        alert.accept()
        element(blockSuccessMsg).waitUntilVisible()
    }

    Object clean_cache() {
        getDriver().get(subMenuCleanCache.getAttribute("href"))
        element(buttonFlushMagentoCache).click()
        element(blockSuccessMsg).waitUntilVisible()
    }
}
