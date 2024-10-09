package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    private final WebDriver driver;
    private final By nameInput = By.xpath("/html/body/div/div/main/div/form/fieldset[1]/div/div/input");
    private final By emailInput = By.xpath("/html/body/div/div/main/div/form/fieldset[2]/div/div/input");
    private final By passwordInput = By.xpath("/html/body/div/div/main/div/form/fieldset[3]/div/div/input");
    private final By registrationButton = By.xpath("/html/body/div/div/main/div/form/button");
    private final By loginLink = By.xpath("/html/body/div/div/main/div/div/p/a");
    private final By incorrectPasswordError = By.xpath("/html/body/div/div/main/div/form/fieldset[3]/div/p");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setName(String name) {
        driver.findElement(nameInput).sendKeys(name);
    }

    public void setEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void setPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clearPassword() {
        driver.findElement(passwordInput).clear();
    }

    public Boolean incorrectPasswordErrorIsDisplayed() {
        return driver.findElement(incorrectPasswordError).isDisplayed();
    }

    public void clickRegistrationButton() {
        driver.findElement(registrationButton).click();
    }

    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }
}
