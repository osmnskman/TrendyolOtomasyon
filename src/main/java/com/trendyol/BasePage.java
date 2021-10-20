package com.trendyol;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public WebElement findElement(By by) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
    public void click(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        findElement(locator).click();
    }
    public List<WebElement>findAll(By locator){
        return (List<WebElement>) driver.findElement(locator);
    }

}
