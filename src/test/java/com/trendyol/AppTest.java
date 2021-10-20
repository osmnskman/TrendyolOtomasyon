package com.trendyol;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class AppTest extends BasePage {

    @BeforeClass
    public static void asetUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(05));
        driver.get("https://www.trendyol.com/");
    }

    @Test
    public void bErkek() throws InterruptedException {
        findElement(webElements.erkekSecim).click();
        TimeUnit.SECONDS.sleep(3);
    }

    @Test
    public void cLogin() throws InterruptedException {

        findElement(By.xpath(".//div[@class=\"link account-user\"]")).click();
        WebElement element = driver.findElement(By.id("login-email"));
        element.sendKeys("osmnskman@gmail.com");
        WebElement element1 = driver.findElement(By.id("login-password-input"));
        element1.sendKeys("Os123,asd\n");
        TimeUnit.SECONDS.sleep(3);
        //By SearchBox = By.className("search-box");
        //click(SearchBox);
        // .//div[@class="p-card-wrppr"] bunu listeye at 10 seç
    }

    @Test
    public void dsearch() {
        WebElement kazak = driver.findElement(By.className("search-box"));
        kazak.sendKeys("Kazak\n");
    }


    By kazakSelect = By.xpath(".//div[@class=\"p-card-wrppr\"]");

    private List<WebElement> getAllProducts() {
        return findAll(kazakSelect);

    }

    /*
    @Test
    public void addFavorite() throws InterruptedException{

        dsearch();
        TimeUnit.SECONDS.sleep(5);
        List<WebElement> imageList = driver.findElements(By.className("fvrt-btn-wrppr"));
        TimeUnit.SECONDS.sleep(5);
        System.out.println(imageList.size());
        TimeUnit.SECONDS.sleep(5);
        WebElement item = imageList.get(1);
        item.click();
        TimeUnit.SECONDS.sleep(5);

    }

     */
    @Test
    public void eselectKazak() throws InterruptedException {
        List<WebElement> items = driver.findElements(webElements.items);
        TimeUnit.SECONDS.sleep(3);
        items.get(9).click();

    }

    @Test
    public void faddFavorite() throws InterruptedException {

        String currentWindows = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windows : windowHandles) {
            if (!currentWindows.equals(windows)) {
                driver.switchTo().window(windows);
            }
        }
        findElement(By.cssSelector(".fv>.i-heart")).click();
        TimeUnit.SECONDS.sleep(5);

    }

    @Test
    public void gaddToBasket(By by) {


    }

}
