package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private final WebDriver driver;
    private final By personalAccountButton = By.xpath("/html/body/div/div/header/nav/a");
    private final By loginButton = By.xpath("/html/body/div/div/main/section[2]/div/button");
    private final By title = By.xpath("/html/body/div/div/main/section[1]/h1");
    private final By bunNotActiveButton = By.xpath("//div[@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Булки']");
    private final By bunActiveButton = By.xpath("//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Булки']");
    private final By sauceNotActiveButton = By.xpath("//div[@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Соусы']");
    private final By sauceActiveButton = By.xpath("//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Соусы']");
    private final By fillingNotActiveButton = By.xpath("//div[@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Начинки']");
    private final By fillingActiveButton = By.xpath("//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Начинки']");


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(title));
    }

    public Boolean isDisplayed() {
        return driver.findElement(title).isDisplayed();
    }

    public void clickPersonalAccountButton() {
        driver.findElement(personalAccountButton).click();
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void clickBunButton() {
        driver.findElement(bunNotActiveButton).click();
    }

    public Boolean isActiveBunButton() {
        return driver.findElement(bunActiveButton).isDisplayed();
    }

    public void clickSauceButton() {
        driver.findElement(sauceNotActiveButton).click();
    }

    public Boolean isActiveSauceButton() {
        return driver.findElement(sauceActiveButton).isDisplayed();
    }

    public void clickFillingButton() {
        driver.findElement(fillingNotActiveButton).click();
    }

    public Boolean isActiveFillingButton() {
        return driver.findElement(fillingActiveButton).isDisplayed();
    }
}
