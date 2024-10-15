package org.example;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;
    private final By emailInput = By.xpath(".//input[@type='text']");
    private final By passwordInput = By.xpath(".//input[@type='password']");
    private final By loginButton = By.xpath(".//*[contains(text(),'Войти')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Ожидание загрузки страницы")
    public void waitForLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(emailInput));
    }

    public Boolean isDisplayed() {
        return driver.findElement(emailInput).isDisplayed();
    }

    @Step("Заполнение поля email")
    public void setEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    @Step("Заполнение поля password")
    public void setPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    @Step("Нажатие на кнопку входа")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
}
