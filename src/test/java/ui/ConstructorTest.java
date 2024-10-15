package ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import org.example.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ConstructorTest extends BaseTest {

    private MainPage mainPage;

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        mainPage = new MainPage(driver);
        driver.get(BASE_URL);
    }

    @Test
    @DisplayName("Переход к разделу «Булки»")
    public void testBun() {
        mainPage.clickSauceButton();
        mainPage.clickBunButton();
        assertTrue(mainPage.isActiveBunButton());
    }

    @Test
    @DisplayName("Переход к разделу «Соусы»")
    public void testSauce() {
        mainPage.clickSauceButton();
        assertTrue(mainPage.isActiveSauceButton());
    }

    @Test
    @DisplayName("Переход к разделу «Начинки»")
    public void testFilling() {
        mainPage.clickFillingButton();
        assertTrue(mainPage.isActiveFillingButton());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
