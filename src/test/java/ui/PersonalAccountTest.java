package ui;

import api.client.User;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import org.example.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class PersonalAccountTest extends BaseTest {
    public WebDriver driver;
    private MainPage mainPage;
    private LoginPage loginPage;
    private PersonalAccountPage personalAccountPage;
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
        personalAccountPage = new PersonalAccountPage(driver);
        loginPage = new LoginPage(driver);

        driver.get("https://stellarburgers.nomoreparties.site");
        mainPage.clickLoginButton();
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        loginPage.clickLoginButton();
    }

    @Test
    @DisplayName("Проверь переход по клику на «Личный кабинет»")
    public void testMoveFromMainPage() {
        mainPage.clickPersonalAccountButton();
        personalAccountPage.waitForLoad();
        assertEquals(true, personalAccountPage.isDisplayed());
    }

    @Test
    @DisplayName("Выход по кнопке «Выйти» в личном кабинете")
    public void testLogout() {
        mainPage.clickPersonalAccountButton();
        personalAccountPage.waitForLoad();
        assertEquals(true, personalAccountPage.isDisplayed());
        personalAccountPage.clickLogoutButton();
        loginPage.waitForLoad();
        assertEquals(true, loginPage.isDisplayed());
    }

    @After
    public void tearDown() {
        user.delete();
        driver.quit();
    }
}
