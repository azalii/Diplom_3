package ui;

import api.client.User;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import org.example.RegistrationPage;
import org.example.LoginPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class RegistrationTest extends BaseTest {
    public WebDriver driver;
    private LoginPage loginPage;
    private RegistrationPage registrationPage;
    private final String name = "Bob";
    private final String email = "bob.m2@ya.com";
    private final String shortPassword = "123";
    private final String password = "123456";

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
    }

    @Test
    @DisplayName("Успешная регистрация")
    public void successfulRegistration() {
        driver.get("https://stellarburgers.nomoreparties.site/register");

        registrationPage.setName(name);
        registrationPage.setEmail(email);
        registrationPage.clearPassword();
        registrationPage.setPassword(password);
        registrationPage.clickRegistrationButton();
        assertEquals(true, loginPage.isDisplayed());
    }

    @Test
    @DisplayName("Некорректный пароль")
    public void failedRegistration() {
        driver.get("https://stellarburgers.nomoreparties.site/register");

        registrationPage.setName(name);
        registrationPage.setEmail(email);
        registrationPage.setPassword(shortPassword);
        registrationPage.clickRegistrationButton();
        assertEquals(true, registrationPage.incorrectPasswordErrorIsDisplayed());
    }

    @After
    public void tearDown() {
        User user = new User();
        user.login(email, password);
        user.delete();
        driver.quit();
    }
}
