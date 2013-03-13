package LaSenza.pages

import org.openqa.selenium.support.FindBy
import org.openqa.selenium.*

class AdminPanelPage extends ForAllPage {

    def bannerID

    AdminPanelPage(WebDriver driver) {
        super(driver)
    }

    @FindBy(id = "username")
    private WebElement fieldUserName

    @FindBy(id = "login")
    private WebElement fieldPassword

    @FindBy(id = "banner_properties_name")
    private WebElement fieldBannerName

    @FindBy(xpath = "//thead//input[@class='checkbox']")
    private WebElement checkboxAll

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
    private WebElement blockSuccessMsg

    @FindBy(xpath = "//select[@name='in_products']")
    private WebElement selectShowProducts

    @FindBy(xpath = "//input[@name='entity_id']")
    private WebElement fieldID

    @FindBy(xpath = "//button[@title='Search']")
    private WebElement buttonSearch

    @FindBy(id = "product_info_tabs_inventory")
    private WebElement tabInventory

    @FindBy(id = "product_info_tabs_crosssell")
    private WebElement tabCrossSells

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

    @FindBy(id = "ustorelocator_general_search_radius_options")
    private WebElement inputuStoreLocatorRadius

    @FindBy(xpath = "//ul[@id='system_config_tabs']//li[1]//dd[2]/a")
    private WebElement tabWeb

    @FindBy(xpath = "//ul[@id='system_config_tabs']//li[1]//dd[7]/a")
    private WebElement tabStoreLocations

    @FindBy(xpath = "//ul[@id='nav']/li[8]/ul/li[5]/a")
    private WebElement subMenuBanner

    @FindBy(xpath = "//ul[@id='nav']/li[8]/ul/li[3]/a")
    private WebElement subMenuStaticBlocks

    @FindBy(xpath = "//ul[@id='nav']/li[12]/ul/li[20]/a")
    private WebElement subMenuConfiguration

    @FindBy(xpath = "//ul[@id='nav']/li[3]/ul/li[4]/ul/li[1]/a")
    private WebElement subMenuManageAttributes

    @FindBy(xpath = "//ul[@id='nav']/li[6]/ul/li[2]/a")
    private WebElement subMenuCatalogPriceRules

    @FindBy(xpath = "//ul[@id='nav']/li[3]/ul/li[6]/a")
    private WebElement subMenuRuleBasedProductRelations

    @FindBy(xpath = "//button[@title='Add New Rule']")
    private WebElement buttonAddNewRule

    @FindBy(xpath = "//button[@class='scalable add']")
    private WebElement buttonAddNewProductRule

    @FindBy(id = "rule_name")
    private WebElement fieldProductRuleName

    @FindBy(id = "rule_apply_to")
    private WebElement selectApplayTo

    @FindBy(id = "targetrule_tabs_enterprise_targetrule_edit_tab_conditions")
    private WebElement tabProductsToMatch

    @FindBy(id = "targetrule_tabs_enterprise_targetrule_edit_tab_actions")
    private WebElement tabProductsToDisplay

    @FindBy(xpath = "//span[@class='rule-param rule-param-new-child']/a")
    private WebElement crossAddParameter

    @FindBy(xpath = "//ul[@id='actions__1__children']/li/span/a")
    private WebElement crossAddParameterActions

    @FindBy(id = "conditions__1__new_child")
    private WebElement selectAddParameter

    @FindBy(xpath = "//select[@id='actions__1__new_child']")
    private WebElement selectAddParameterActions

    @FindBy(xpath = "//ul[@id='conditions__1__children']/li/span[2]/a[@class='label']")
    private WebElement threePoints

    @FindBy(xpath = "//ul[@id='actions__1__children']/li/span[3]/a[@class='label']")
    private WebElement threePointsactions

    @FindBy(xpath = "//ul[@id='actions__1__children']/li/span[2]/a[@class='label']")
    private WebElement linkMatchedProductSKU

    @FindBy(id = "actions__1--1__value_type")
    private WebElement selectValueMatched

    @FindBy(id = "conditions__1--1__value")
    private WebElement fieldCondition

    @FindBy(id = "actions__1--1__value")
    private WebElement fieldAction

    @FindBy(xpath = "//a[@class='rule-param-apply']")
    private WebElement ruleParamApplay

    @FindBy(xpath = "//ul[@id='actions__1__children']//span[3]/span/a[2]")
    private WebElement ruleParamApplayActions

    @FindBy(id = "rule_name")
    private WebElement fieldRuleName

    @FindBy(id = "rule_is_active")
    private WebElement selectStatus

    @FindBy(id = "rule_website_ids")
    private WebElement selectWebsite

    @FindBy(id = "rule_customer_group_ids")
    private WebElement selectCustomerGroups

    @FindBy(id = "rule_coupon_type")
    private WebElement selectCoupon

    @FindBy(id = "rule_coupon_code")
    private WebElement fieldCouponCode

    @FindBy(id = "rule_uses_per_coupon")
    private WebElement fieldUsesPerCoupon

    @FindBy(id = "rule_uses_per_customer")
    private WebElement fieldUsesPerCustomer

    @FindBy(id = "promo_catalog_edit_tabs_actions_section")
    private WebElement tabActions

    @FindBy(id = "rule_discount_amount")
    private WebElement fieldDiscountAmount

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

    def goTo(additionUrl) {
        getDriver().get("${System.getProperty("webdriver.base.url")}/${additionUrl}")
    }

    def open_and_login() {
        goTo("admin")
        if (getDriver().findElements(By.id("username")) != []) {
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
        if (addBanner) {
            element(areaCMSBlockContent).type("<p>{{widget type=\"enterprise_banner/widget_banner\" display_mode=\"fixed\" banner_ids=\"1,2,3,4,${bannerID}\" template=\"banner/widget/block.phtml\" unique_id=\"f80360d304e6c051023b51df668b10f9\"}}</p>")
        } else {
            element(areaCMSBlockContent).type("<p>{{widget type=\"enterprise_banner/widget_banner\" display_mode=\"fixed\" banner_ids=\"1,2,3,4\" template=\"banner/widget/block.phtml\" unique_id=\"f80360d304e6c051023b51df668b10f9\"}}</p>")
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
        if (tabWeb.getAttribute("class") != "active") {
            element(tabWeb).click()
        }
        if (sessionCookieManagement.getAttribute("class") != "open") {
            element(sessionCookieManagement).click()
        }
        element(inputCookieTime).waitUntilVisible()
        if (inputCookieTime.getAttribute("value") != timeSec) {
            element(inputCookieTime).clear()
            element(inputCookieTime).type(timeSec)
            element(buttonSaveConfig).click()
            element(blockSuccessMsg).waitUntilVisible()
        }
    }

    def click_tab_store_locations() {
        if (tabStoreLocations.getAttribute("class") != "active") {
            element(tabStoreLocations).click()
        }
    }

    def open_product(def id) {
        getDriver().get("${System.getProperty("webdriver.base.url")}/index.php/admin/catalog_product/edit/id/${id}")
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
        for (def i = 0; i <= 3; i++) {
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

    def open_catalog_price_rules() {
        getDriver().get(subMenuCatalogPriceRules.getAttribute("href"))
    }

    boolean coupon_absent() {
        return !containsText("AutoTestCoupon")
    }

    def create_coupon() {
        element(buttonAddNewRule).click()
        element(fieldRuleName).waitUntilVisible()
        element(selectStatus).selectByVisibleText("Active")
        element(selectWebsite).selectByValue("1")
        element(selectWebsite).selectByValue("2")
        element(selectCustomerGroups).selectByValue("0")
        element(selectCustomerGroups).selectByValue("1")
        element(selectCoupon).selectByValue("2")
        element(fieldUsesPerCoupon).type("1000")
        element(fieldUsesPerCustomer).type("1000")
        element(fieldCouponCode).type("12345")
        element(fieldRuleName).type("AutoTestCoupon")
        element(tabActions).click()
        element(fieldDiscountAmount).waitUntilVisible()
        element(fieldDiscountAmount).type("99")
        element(buttonSave).click()
        element(blockSuccessMsg).waitUntilVisible()
    }

    def search_product_cross_sells(int id) {
        element(tabCrossSells).click()
        element(selectShowProducts).waitUntilVisible()
        if (driver.findElements(By.xpath("//table[@id='cross_sell_product_grid_table']/tbody//input[@class='checkbox']")).size() == 0) {
            element(selectShowProducts).selectByVisibleText("Any")
            element(fieldID).type("11501")
            element(buttonSearch).click()
            waitForTextToAppear("So Free Balconnet la")
            element(checkboxAll).waitUntilEnabled()
            element(checkboxAll).click()
            element(buttonSave).click()
            element(blockSuccessMsg).waitUntilVisible()
        }
    }

    def create_new_product_rule(String skuProductInCart, String skuCrossSellProduct) {
        getDriver().get(subMenuRuleBasedProductRelations.getAttribute("href"))
        if (!getDriver().getPageSource().contains("TestProductRule")) {
            element(buttonAddNewProductRule).click()
            element(fieldProductRuleName).waitUntilVisible()
            element(fieldProductRuleName).type("TestProductRule")
            element(selectApplayTo).selectByVisibleText("Cross-sells")
            element(tabProductsToMatch).click()
            element(crossAddParameter).waitUntilVisible()
            element(crossAddParameter).click()
            element(selectAddParameter).waitUntilVisible()
            element(selectAddParameter).selectByVisibleText("SKU")
            element(threePoints).waitUntilVisible()
            element(threePoints).click()
            element(fieldCondition).waitUntilVisible()
            element(fieldCondition).type(skuProductInCart)
            element(ruleParamApplay).click()
            element(tabProductsToDisplay).click()
            element(crossAddParameterActions).waitUntilVisible()
            element(crossAddParameterActions).click()
            element(selectAddParameterActions).waitUntilVisible()
            element(selectAddParameterActions).selectByVisibleText("SKU")
            element(linkMatchedProductSKU).click()
            element(selectValueMatched).waitUntilVisible()
            element(selectValueMatched).selectByVisibleText("Constant Value")
            element(threePointsactions).waitUntilVisible()
            element(threePointsactions).click()
            element(fieldAction).waitUntilVisible()
            element(fieldAction).type(skuCrossSellProduct)
            element(ruleParamApplayActions).click()
            element(buttonSave).click()
            element(blockSuccessMsg).waitUntilVisible()
        }
    }

    def set_search_radius_options(String radius) {
        element(inputuStoreLocatorRadius).type(radius)
        element(buttonSave).click()
        element(blockSuccessMsg).waitUntilVisible()
    }
}
