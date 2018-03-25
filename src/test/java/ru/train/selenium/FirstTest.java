package ru.train.selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;
import static org.testng.Assert.*;

public class FirstTest {
    private WebDriver driver;
    private WebDriverWait wait;
    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (InvalidSelectorException e){
            throw e;
        }catch (NoSuchElementException e){
            return false;
        }
    }
    public boolean areElemenstPresent(By locator){
        return driver.findElements(locator).size()>0;
    }


    @BeforeTest
    public void start() {

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);


    }

    @Test
    public void myFirstTest() throws InterruptedException {
        driver.get("http://www.google.com");
        driver.findElement(By.name("q")).sendKeys("WebDriver");
        Assert.assertFalse(isElementPresent(By.xpath("//div[")));
        Thread.sleep(1000);
        //driver.findElement(By.cssSelector("span.ds:nth-child(1) > span:nth-child(1) > input:nth-child(1)")).click();
       /* WebElement button = driver.findElement(By.cssSelector("#sbtc > div.gstl_0.sbdd_a > div:nth-child(2) > div.sbdd_b > div > ul > li:nth-child(11) > div > span:nth-child(1) > span > input"));
        button.click();
        wait.until(titleIs("WebDriver - Поиск в Google"));*/

    }




    @AfterTest
    public void stop() {
        driver.quit();
        driver = null;
    }
}
