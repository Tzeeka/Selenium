package ilmTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ProductTest extends baseTest {


    @Test // Задача: Проверить, что открывается правильная страница товара
    public void productStyleTest() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://ilovemum.ru/");

        // Идём в каталог
        WebElement catalog =  driver.findElement(By.cssSelector("body > div.wrapper > div > header > div > div.header__nav > div > ul > li:nth-child(1) > a"));

        if(catalog.isDisplayed()) {
            catalog.click();
        }
        else {
            driver.findElement(By.cssSelector("a.sidebar__link.sidebar__link--burger")).click();
            driver.findElement(By.cssSelector("a.panel-burger__link")).click();
        }


        // Находим блок первого товара
        WebElement productCart = driver.findElement(By.cssSelector("div#bx_1806089334_101279.catalog__block.bx_item_container.inited"));

        // Ищем в нем цену
        String priceOuter = productCart.findElement(By.cssSelector("span.catalog__desc-value")).getText();

        // Проваливаемся в карточку товара, закрываем надоедливый pop-up и ищем цену внутри
        driver.findElement(By.cssSelector("div#bx_1806089334_101279.catalog__block.bx_item_container.inited")).click();
        driver.findElement(By.cssSelector("a.index-popup__close-link.panel__close-link")).click();
        String priceInner = driver.findElement(By.cssSelector("#bx_117848907_101279_price")).getText();

        // Сравниваем
        Assert.assertEquals(priceOuter, priceInner);
    }
}
