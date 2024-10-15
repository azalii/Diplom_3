package ui;

import api.client.User;
import io.qameta.allure.junit4.DisplayName;
import org.example.LoginPage;
import org.example.MainPage;
import org.example.PersonalAccountPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MainTest extends BaseTest {
    private MainPage mainPage;
    private LoginPage loginPage;
    private PersonalAccountPage personalAccountPage;
    private final String name = "Bob";
    private final String email = "bob.m2@ya.com";
    private final String password = "123456";
    private User user;

    @Before
    public void startUp() {
        user = new User();
        user.register(email, password, name);
        mainPage = new MainPage(driver);
        personalAccountPage = new PersonalAccountPage(driver);
        loginPage = new LoginPage(driver);

        driver.get(BASE_URL);
        mainPage.clickLoginButton();
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        loginPage.clickLoginButton();
        mainPage.waitForLoad();
        mainPage.clickPersonalAccountButton();
        personalAccountPage.waitForLoad();
    }

    @Test
    @DisplayName("Переход по клику на «Конструктор»")
    public void testConstructorButton() {
        personalAccountPage.clickMainPageButton();
        mainPage.waitForLoad();
        assertTrue(mainPage.isDisplayed());
    }

    @Test
    @DisplayName("Переход по клику на логотип Stellar Burgers")
    public void testLogo() {
        personalAccountPage.clickLogo();
        mainPage.waitForLoad();
        assertTrue(mainPage.isDisplayed());
    }

    @After
    public void tearDown() {
        user.delete();
        driver.quit();
    }
}
