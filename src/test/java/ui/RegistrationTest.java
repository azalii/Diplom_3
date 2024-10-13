package ui;

import api.client.User;
import io.qameta.allure.junit4.DisplayName;
import org.example.RegistrationPage;
import org.example.LoginPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class RegistrationTest extends BaseTest {
    private LoginPage loginPage;
    private RegistrationPage registrationPage;
    private final String name = "Bob";
    private final String email = "bob.m2@ya.com";
    private final String shortPassword = "123";
    private final String password = "123456";

    @Before
    public void startUp() {
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
    }

    @Test
    @DisplayName("Успешная регистрация")
    public void successfulRegistration() {
        driver.get(BASE_URL + "/register");

        registrationPage.setName(name);
        registrationPage.setEmail(email);
        registrationPage.clearPassword();
        registrationPage.setPassword(password);
        registrationPage.clickRegistrationButton();
        assertTrue(loginPage.isDisplayed());
    }

    @Test
    @DisplayName("Некорректный пароль")
    public void failedRegistration() {
        driver.get(BASE_URL + "/register");

        registrationPage.setName(name);
        registrationPage.setEmail(email);
        registrationPage.setPassword(shortPassword);
        registrationPage.clickRegistrationButton();
        assertTrue(registrationPage.incorrectPasswordErrorIsDisplayed());
    }

    @After
    public void tearDown() {
        User user = new User();
        user.login(email, password);
        user.delete();
        driver.quit();
    }
}
