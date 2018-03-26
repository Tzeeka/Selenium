package ilmTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTest extends baseTest {

    @Test
    public void productStyleTest() throws InterruptedException {
        driver.get("https://ilovemum.ru/");
        // Идём в каталог
        driver.findElement(By.cssSelector("body > div.wrapper > div > header > div > div.header__nav > div > ul > li:nth-child(1) > a")).click();
        // Находим блок первого товара
        WebElement productCart = driver.findElement(By.cssSelector("div#bx_1806089334_101208.catalog__block.bx_item_container.inited"));
        // Ищем в нем цену
        String priceOuter = productCart.findElement(By.cssSelector("span.catalog__desc-value")).getText();
        // Проваливаемся в карточку товара, закрываем надоедливый pop-up и ищем цену внутри
        driver.findElement(By.cssSelector("div#bx_1806089334_101208.catalog__block.bx_item_container.inited")).click();
        driver.findElement(By.cssSelector("a.index-popup__close-link.panel__close-link")).click();
        String priceInner = driver.findElement(By.cssSelector("#bx_117848907_101208_price")).getText();
        // Сравниваем
        Assert.assertEquals(priceInner, priceOuter);
    }
}
