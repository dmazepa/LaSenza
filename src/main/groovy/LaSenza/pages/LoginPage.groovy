package LaSenza.pages

import org.openqa.selenium.By
import org.openqa.selenium.HasInputDevices
import org.openqa.selenium.Mouse
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.internal.Locatable
import org.openqa.selenium.support.FindBy

class LoginPage extends ForAllPage {

    LoginPage(WebDriver driver) {
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

    @FindBy(xpath = "//li[@class='note']/a")
    private WebElement linkForgot

    @FindBy(xpath = "//*[@id='email_address']")
    private WebElement inputEmail

    @FindBy(xpath = "//div[@class='buttons-set form-buttons']/button")
    private WebElement buttonSubmit

    @FindBy(xpath = "//*[@id='password']")
    private WebElement newPassword

    @FindBy(xpath = "//*[@id='confirmation']")
    private WebElement confirmNewPassword

    @FindBy(xpath = "//div[@class='buttons-set form-buttons']/button")
    private WebElement resetPasswordButton

    def log_in(String email, String pass, Boolean withCookie) {
        element(fieldEmail).type(email)
        element(fieldPassword).type(pass)
        if (!withCookie) {
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

    def click_on_link_forgot_password() {
        element(linkForgot).click()
    }

    def input_email_and_click_submit(email) {
        element(inputEmail).type(email)
        element(buttonSubmit).click()
    }

    def go_to_email_page(email, password) {
        getDriver().get("http://www.google.com.ua/")
        element(By.xpath("//*[@id='gb_70']/span")).click()
        element(By.xpath("//*[@id='Email']")).type(email)
        element(By.xpath("//*[@id='Passwd']")).type(password)
        element(By.xpath("//*[@id='signIn']")).click()
        element(By.xpath("//*[@id='gb_23']/span[2]")).click()
        element(By.xpath("//span[@name='CustomerSupport']")).click()
        def s=element(By.xpath("//p/a[@target='_blank']")).getText()
        //element(By.xpath("//div[@class='asa']/div[@class='ar9 T-I-J3 J-J5-Ji']")).click()
        Locatable hoverItem = (Locatable) getDriver().findElement(By.xpath("//div[@data-tooltip='Delete']"))
        Mouse mouse = ((HasInputDevices) driver).getMouse()
        mouse.mouseMove(hoverItem.getCoordinates())
        mouse.click(hoverItem.getCoordinates())
        getDriver().get(s)
    }

    def input_new_password(newpassword) {
        element(newPassword).type(newpassword)
        element(confirmNewPassword).type(newpassword)
        element(resetPasswordButton).click()
    }
}
