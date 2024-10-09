package ui;

import api.client.User;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.LoginPage;
import org.example.MainPage;
import org.example.RecoveryPasswordPage;
import org.example.RegistrationPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.qameta.allure.junit4.DisplayName;

import static org.junit.Assert.assertEquals;

public class LoginTest extends BaseTest {
    public WebDriver driver;
    private LoginPage loginPage;
    private RegistrationPage registrationPage;
    private MainPage mainPage;
    private RecoveryPasswordPage recoveryPasswordPage;
    private final String name = "Bob";
    private final String email = "bob.m2@ya.com";
    private final String password = "123456";
    private User user;

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        user = new User();
        user.register(email, password, name);
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
        recoveryPasswordPage = new RecoveryPasswordPage(driver);
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    public void testViaLoginButton() {
        driver.get("https://stellarburgers.nomoreparties.site");

        mainPage.clickLoginButton();
        assertEquals(true, loginPage.isDisplayed());
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        loginPage.clickLoginButton();
        mainPage.waitForLoad();
        assertEquals(true, mainPage.isDisplayed());
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void testViaPersonAccountButton() {
        driver.get("https://stellarburgers.nomoreparties.site");

        mainPage.clickPersonalAccountButton();
        assertEquals(true, loginPage.isDisplayed());
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        loginPage.clickLoginButton();
        mainPage.waitForLoad();
        assertEquals(true, mainPage.isDisplayed());
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void testViaRegistrationPage() {
        driver.get("https://stellarburgers.nomoreparties.site/register");

        registrationPage.clickLoginLink();
        assertEquals(true, loginPage.isDisplayed());
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        loginPage.clickLoginButton();
        mainPage.waitForLoad();
        assertEquals(true, mainPage.isDisplayed());
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void testViaRecoveryPasswordPage() {
        driver.get("https://stellarburgers.nomoreparties.site/forgot-password");

        recoveryPasswordPage.clickLoginLink();
        assertEquals(true, loginPage.isDisplayed());
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        loginPage.clickLoginButton();
        mainPage.waitForLoad();
        assertEquals(true, mainPage.isDisplayed());
    }

    @After
    public void tearDown() {
        user.delete();
        driver.quit();
    }
}
