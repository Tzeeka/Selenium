package ilmTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ProductTest extends baseTest {

    @Test
    public void productStyleTest() throws InterruptedException {
        driver.get("https://ilovemum.ru/");
        driver.findElement(By.cssSelector("a.nav_link")).click();
        driver.findElement(By.cssSelector("div#bx_1806089334_101208.catalog__block.bx_item_container.inited")).click();
        Thread.sleep(3000);
    }
}
