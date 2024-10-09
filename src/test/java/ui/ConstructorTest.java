package ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import org.example.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class ConstructorTest extends BaseTest {
    public WebDriver driver;
    private MainPage mainPage;

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        driver.get("https://stellarburgers.nomoreparties.site");
    }

    @Test
    @DisplayName("Переход к разделу «Булки»")
    public void testBun() {
        mainPage.clickSauceButton();
        mainPage.clickBunButton();
        assertEquals(true, mainPage.isActiveBunButton());
    }

    @Test
    @DisplayName("Переход к разделу «Соусы»")
    public void testSauce() {
        mainPage.clickSauceButton();
        assertEquals(true, mainPage.isActiveSauceButton());
    }

    @Test
    @DisplayName("Переход к разделу «Начинки»")
    public void testFilling() {
        mainPage.clickFillingButton();
        assertEquals(true, mainPage.isActiveFillingButton());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
