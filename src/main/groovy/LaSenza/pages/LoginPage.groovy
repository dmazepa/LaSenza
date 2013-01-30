package LaSenza.pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class LoginPage extends ForAllPage{

    LoginPage(WebDriver driver){
        super(driver)
    }

    @FindBy(id = "email")
    private WebElement fieldEmail;

    @FindBy(id = "pass")
    private WebElement fieldPassword;

    @FindBy(xpath = "//input[@title='Remember Me']")
    private WebElement checkboxWithCookie;

    @FindBy(id = "send2")
    private WebElement buttonLogin;

    @FindBy(xpath = "//div[@class='buttons-set']/button")
    private WebElement buttonRegister

    def log_in(String email, String pass, Boolean withCookie) {
        element(fieldEmail).type(email)
        element(fieldPassword).type(pass)
        if(!withCookie){
          element(checkboxWithCookie).click()
        }
        element(buttonLogin).click()
    }

    def assert_on_login_page() {
        element(buttonLogin).shouldBePresent()
    }

    def click_on_button_register() {
        element(buttonRegister).click()
    }
}
