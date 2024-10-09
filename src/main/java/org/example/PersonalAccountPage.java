package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PersonalAccountPage {
    private final WebDriver driver;
    private final By navDiv = By.xpath("/html/body/div/div/main/div/nav");
    private final By mainPageButton = By.xpath("/html/body/div/div/header/nav/ul/li[1]/a");
    private final By logo = By.xpath("/html/body/div/div/header/nav/div/a");
    private final By logoutButton = By.xpath("/html/body/div/div/main/div/nav/ul/li[3]/button");


    public PersonalAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(navDiv));
    }

    public Boolean isDisplayed() {
        return driver.findElement(navDiv).isDisplayed();
    }

    public void clickMainPageButton() {
        driver.findElement(mainPageButton).click();
    }

    public void clickLogo() {
        driver.findElement(logo).click();
    }

    public void clickLogoutButton() {
        driver.findElement(logoutButton).click();
    }
}
