package org.example;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private final WebDriver driver;
    private final By personalAccountButton = By.xpath("//*[contains(text(),'Личный Кабинет')]");
    private final By loginButton = By.xpath("//*[contains(text(),'Войти в аккаунт')]");
    private final By bunNotActiveButton = By.xpath("//div[@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Булки']");
    private final By bunActiveButton = By.xpath("//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Булки']");
    private final By sauceNotActiveButton = By.xpath("//div[@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Соусы']");
    private final By sauceActiveButton = By.xpath("//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Соусы']");
    private final By fillingNotActiveButton = By.xpath("//div[@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Начинки']");
    private final By fillingActiveButton = By.xpath("//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Начинки']");


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Ожидание загрузки страницы")
    public void waitForLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(personalAccountButton));
    }

    public Boolean isDisplayed() {
        return driver.findElement(personalAccountButton).isDisplayed();
    }

    @Step("Нажатие на кнопку перехода на страницу личного кабинета")
    public void clickPersonalAccountButton() {
        driver.findElement(personalAccountButton).click();
    }

    @Step("Нажатие на кнопку перехода на страницу авторизации")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("Нажатие на кнопку выбора секции Булки")
    public void clickBunButton() {
        driver.findElement(bunNotActiveButton).click();
    }

    public Boolean isActiveBunButton() {
        return driver.findElement(bunActiveButton).isDisplayed();
    }

    @Step("Нажатие на кнопку выбора секции Соусы")
    public void clickSauceButton() {
        driver.findElement(sauceNotActiveButton).click();
    }

    public Boolean isActiveSauceButton() {
        return driver.findElement(sauceActiveButton).isDisplayed();
    }

    @Step("Нажатие на кнопку выбора секции Начинки")
    public void clickFillingButton() {
        driver.findElement(fillingNotActiveButton).click();
    }

    public Boolean isActiveFillingButton() {
        return driver.findElement(fillingActiveButton).isDisplayed();
    }
}
