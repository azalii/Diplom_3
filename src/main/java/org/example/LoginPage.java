package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;
    private final By emailInput = By.xpath("/html/body/div/div/main/div/form/fieldset[1]/div/div/input");
    private final By passwordInput = By.xpath("/html/body/div/div/main/div/form/fieldset[2]/div/div/input");
    private final By loginButton = By.xpath("/html/body/div/div/main/div/form/button");
    private final By loginForm = By.xpath("/html/body/div/div/main/div");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(loginForm));
    }

    public Boolean isDisplayed() {
        return driver.findElement(loginForm).isDisplayed();
    }

    public void setEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void setPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
}
