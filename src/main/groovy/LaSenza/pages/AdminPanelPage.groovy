package LaSenza.pages

import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.Alert
import org.openqa.selenium.By

class AdminPanelPage extends ForAllPage{

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

    @FindBy(id = "web_cookie-head")
    private WebElement sessionCookieManagement

    @FindBy(id = "web_cookie_cookie_lifetime")
    private WebElement inputCookieTime

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

    @FindBy(xpath = "//button[@title='Save Config']")
    private WebElement buttonSaveConfig

    @FindBy(xpath = "//button[@title='Save Block']")
    private WebElement buttonSaveBlock

    @FindBy(xpath = "//li[@class='success-msg']")
    private WebElement  blockSuccessMsg

    @FindBy(id = "product_info_tabs_inventory")
    private WebElement tabInventory

    @FindBy(id = "inventory_qty")
    private WebElement fieldQty

    @FindBy(id = "visibility")
    private WebElement selectVisibility

    @FindBy(id = "product_info_tabs_categories")
    private WebElement tabCategories

    @FindBy(id = "ext-gen23")
    private WebElement checkboxBras

    @FindBy(xpath = "//button[@class='scalable save']")
    private WebElement buttonSave

    @FindBy(xpath = "//ul[@id='system_config_tabs']//li[1]//dd[2]/a")
    private WebElement tabWeb

    @FindBy(xpath = "//ul[@id='nav']/li[8]/ul/li[5]/a")
    private WebElement subMenuBanner

    @FindBy(xpath = "//ul[@id='nav']/li[8]/ul/li[3]/a")
    private WebElement subMenuStaticBlocks

    @FindBy(xpath = "//ul[@id='nav']/li[12]/ul/li[20]/a")
    private WebElement subMenuConfiguration

    @FindBy(xpath = "//ul[@id='nav']/li[3]/ul/li[4]/ul/li[1]/a")
    private WebElement subMenuManageAttributes

    @FindBy(xpath = "//table[@id='attributeGrid_table']//tbody/tr")
    private WebElement rowFirstAttributeManager

    @FindBy(id = "product_attribute_tabs_labels")
    private WebElement tabManageLabelOptions

    @FindBy(id = "manufacturer")
    private WebElement selectBrandName

    @FindBy(id = "add_new_option_button")
    private WebElement buttonAddNewOption

    @FindBy(id = "attributeGrid_filter_frontend_label")
    private WebElement fieldSearchAttributeByLabel

    @FindBy(xpath = "//ul[@id='nav']/li[12]/ul/li[16]/a")
    private WebElement subMenuCleanCache

    @FindBy(xpath = "//button[@class='scalable add']")
    private WebElement buttonAddBanner

    @FindBy(xpath = "//button[@class='scalable delete']")
    private WebElement buttonFlushMagentoCache

    def goTo(additionUrl){
        getDriver().get("${System.getProperty("webdriver.base.url")}${additionUrl}")
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

    def open_menu_configuration() {
        getDriver().get(subMenuConfiguration.getAttribute("href"))
    }

    def open_CMS_block(String id) {
        element(fieldFindByIDCMSBlock).typeAndEnter(id)
        getDriver().get(stringTableToGetTitle.getAttribute("title"))
    }

    def edit_CMS_block(def addBanner) {
        element(buttonHideEditor).click()
        element(areaCMSBlockContent).waitUntilVisible().clear()
        if (addBanner){
            element(areaCMSBlockContent).type("<div id=\"slider_homepage\">{{widget type=\"enterprise_banner/widget_banner\" display_mode=\"fixed\" banner_ids=\"1,2,3,4,${bannerID}\" template=\"banner/widget/block.phtml\"}}</div>")
        } else {
            element(areaCMSBlockContent).type("<div id=\"slider_homepage\">{{widget type=\"enterprise_banner/widget_banner\" display_mode=\"fixed\" banner_ids=\"1,2,3,4\" template=\"banner/widget/block.phtml\"}}</div>")
        }
        element(buttonSaveBlock).click()
        element(blockSuccessMsg).waitUntilVisible()
    }

    def find_and_delete_banner() {
        element(fieldFindByNameBanner).typeAndEnter("TestBaner")
        element(blockLoading).waitUntilNotVisible()
        ((JavascriptExecutor) driver).executeScript('return bannerGrid_massactionJsObject.selectAll()')
        waitABit(2000)
        Thread.sleep(2000)
        element(selectAction).selectByValue("delete")
        //((JavascriptExecutor) driver).executeScript('bannerGrid_massactionJsObject.apply()')
        getDriver().findElement(By.xpath("//button[@title='Submit']")).click()
        Thread.sleep(2000)
        Alert alert = getDriver().switchTo().alert();
        alert.accept()
        element(blockSuccessMsg).waitUntilVisible()
    }

    def clean_cache() {
        getDriver().get(subMenuCleanCache.getAttribute("href"))
        element(buttonFlushMagentoCache).click()
        element(blockSuccessMsg).waitUntilVisible()
    }

    def set_cookie_time(def timeSec) {
        open_menu_configuration()
        if (tabWeb.getAttribute("class") != "active"){
            element(tabWeb).click()
        }
        if (sessionCookieManagement.getAttribute("class") != "open"){
            element(sessionCookieManagement).click()
        }
        element(inputCookieTime).waitUntilVisible()
        if (inputCookieTime.getAttribute("value") != timeSec){
            element(inputCookieTime).clear()
            element(inputCookieTime).type(timeSec)
            element(buttonSaveConfig).click()
            element(blockSuccessMsg).waitUntilVisible()
        }
    }

    def open_product(def id) {
        getDriver().get("${System.getProperty("webdriver.base.url")}index.php/admin/catalog_product/edit/id/${id}")
    }

    def set_product_qty(String qty) {
        element(tabInventory).click()
        element(fieldQty).waitUntilVisible()
        typeInto(fieldQty, qty)
        element(buttonSave).click()
        element(blockSuccessMsg).waitUntilVisible()
    }

    def set_product_visibility(String visibility) {
        element(selectVisibility).selectByVisibleText(visibility)
    }

    def open_attribute_manager() {
        getDriver().get(subMenuManageAttributes.getAttribute("href"))
    }

    def open_attribute_from_attribute_manager(String nameAttribute) {
        element(fieldSearchAttributeByLabel).typeAndEnter(nameAttribute)
        getDriver().get(rowFirstAttributeManager.getAttribute("title"))
    }

    def set_attribute_value(String value) {
        element(tabManageLabelOptions).click()
        element(buttonAddNewOption).waitUntilVisible()
        element(buttonAddNewOption).click()
        element(By.name("option[value][option_0][3]")).waitUntilVisible()
        for(def i=0; i <= 3; i++){
            element(By.name("option[value][option_0][${i}]")).type(value)
        }
        element(buttonSave).click()
        element(blockSuccessMsg).waitUntilVisible()
    }

    def set_product_brand_category(String brandName) {
        element(selectBrandName).selectByVisibleText(brandName)
        element(tabCategories).click()
        element(checkboxBras).waitUntilVisible()
        element(checkboxBras).click()
        element(buttonSave).click()
        element(blockSuccessMsg).waitUntilVisible()
    }
}
