package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecoveryPasswordPage {
    private final WebDriver driver;
    private final By loginLink = By.xpath("/html/body/div/div/main/div/div/p/a");

    public RecoveryPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }
}
