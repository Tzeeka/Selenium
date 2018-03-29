package ilmTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import java.util.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class ItemsToBasket2 extends baseTest {
    @Test
    public void basketTest() throws Exception {
        driver.get("https://ilovemum.ru/");

        // Хитро заходим в каталог, в зависимости от размера окна браузера
        WebElement catalog = driver.findElement(By.cssSelector("body > div.wrapper > div > header > div > div.header__nav > div > ul > li:nth-child(1) > a"));

        if (catalog.isDisplayed()) {
            catalog.click();
        } else {
            driver.findElement(By.cssSelector("a.sidebar__link.sidebar__link--burger")).click();
            driver.findElement(By.cssSelector("a.panel-burger__link")).click();
        }

        //Ждем появления не менее четырех элементов каталога
        wait.until(numberOfElementsToBeMoreThan(By.cssSelector("div.img_wrapper"), 4));

        //Добавляем в корзину три товара




    }
}
