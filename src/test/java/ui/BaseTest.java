package ui;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
    public WebDriver driver;
    final String BASE_URL = "https://stellarburgers.nomoreparties.site";

    public BaseTest() {
        RestAssured.baseURI = BASE_URL;

        WebDriverManager.chromedriver().clearDriverCache().clearResolutionCache().setup();

        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new IllegalArgumentException("Файл config.properties не найден в папке resources");
            }

            Properties properties = new Properties();
            properties.load(input);

            if (Boolean.parseBoolean(properties.getProperty("use_yandex_browser"))) {
                ChromeOptions options = new ChromeOptions();
                options.setBinary(properties.getProperty("yandex_browser_path"));

                driver = new ChromeDriver(options);
            }

            driver =  new ChromeDriver();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}