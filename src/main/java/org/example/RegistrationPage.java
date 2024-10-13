package org.example;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    private final WebDriver driver;
    private final By nameInput = By.xpath(".//input[@name='name']");
    private final By emailInput = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input");
    private final By passwordInput = By.xpath(".//input[@type='password']");
    private final By registrationButton = By.xpath(".//h2[contains(text(),'Регистрация')]");
    private final By loginLink = By.xpath(".//a[@href='/login']");
    private final By incorrectPasswordError = By.xpath(".//*[contains(text(),'Некорректный пароль')]");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Заполнение поля name")
    public void setName(String name) {
        driver.findElement(nameInput).sendKeys(name);
    }

    @Step("Заполнение поля email")
    public void setEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    @Step("Заполнение поля passport")
    public void setPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    @Step("Очистка поля password")
    public void clearPassword() {
        driver.findElement(passwordInput).clear();
    }

    public Boolean incorrectPasswordErrorIsDisplayed() {
        return driver.findElement(incorrectPasswordError).isDisplayed();
    }

    @Step("Нажатие на кнопку регистрации")
    public void clickRegistrationButton() {
        driver.findElement(registrationButton).click();
    }

    @Step("Нажатие на кнопку перехода на страницу авторизации")
    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }
}
