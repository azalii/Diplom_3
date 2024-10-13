package ui;

import api.client.User;
import io.qameta.allure.junit4.DisplayName;
import org.example.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PersonalAccountTest extends BaseTest {
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
    }

    @Test
    @DisplayName("Проверь переход по клику на «Личный кабинет»")
    public void testMoveFromMainPage() {
        mainPage.clickPersonalAccountButton();
        personalAccountPage.waitForLoad();
        assertTrue(personalAccountPage.isDisplayed());
    }

    @Test
    @DisplayName("Выход по кнопке «Выйти» в личном кабинете")
    public void testLogout() {
        mainPage.clickPersonalAccountButton();
        personalAccountPage.waitForLoad();
        assertTrue(personalAccountPage.isDisplayed());
        personalAccountPage.clickLogoutButton();
        loginPage.waitForLoad();
        assertTrue(loginPage.isDisplayed());
    }

    @After
    public void tearDown() {
        user.delete();
        driver.quit();
    }
}
