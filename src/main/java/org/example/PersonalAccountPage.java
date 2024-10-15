package org.example;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PersonalAccountPage {
    private final WebDriver driver;
    private final By mainPageButton = By.xpath(".//*[contains(text(),'Конструктор')]");
    private final By logo = By.xpath("//*[@id=\"root\"]/div/header/nav/div/a");
    private final By logoutButton = By.xpath("//*[@id=\"root\"]/div/main/div/nav/ul/li[3]/button");

    public PersonalAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Ожидание загрузки страницы")
    public void waitForLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(logoutButton));
    }

    public Boolean isDisplayed() {
        return driver.findElement(logo).isDisplayed();
    }

    @Step("Нажатие на кнопку перехода на главную страницу")
    public void clickMainPageButton() {
        driver.findElement(mainPageButton).click();
    }

    @Step("Нажатие на логотип")
    public void clickLogo() {
        driver.findElement(logo).click();
    }

    @Step("Нажатие на кнопку выхода")
    public void clickLogoutButton() {
        driver.findElement(logoutButton).click();
    }
}
