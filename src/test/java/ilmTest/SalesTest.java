package ilmTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SalesTest extends baseTest {

    @Test //Проверяем наличие значка "Скидка" у всех товаров на странице
    public void testIlm() {

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://ilovemum.ru/catalog/special_filter/SPECIALOFFER/");
        List<WebElement> elements = driver.findElements(By.cssSelector("div.catalog__img"));
        for(WebElement el : elements){
         WebElement sale =  el.findElement(By.cssSelector("li.catalog__stock-item.catalog__stock-item--SPECIALOFFER"));
            Assert.assertEquals(sale.getText(), "Скидка");
        }
    }
}
