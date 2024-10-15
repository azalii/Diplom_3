package org.example;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecoveryPasswordPage {
    private final WebDriver driver;
    private final By loginLink = By.xpath(".//a[@href='/login']");

    public RecoveryPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажатие на кнопку перехода на страницу авторизации")
    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }
}
