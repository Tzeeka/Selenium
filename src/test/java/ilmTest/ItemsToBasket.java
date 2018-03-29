package ilmTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import java.util.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class ItemsToBasket extends baseTest {
    @Test
    public void basketTest() throws Exception {
        driver.get("https://ilovemum.ru/");

        // Хитро заходим в каталог, в зависимости от размера окна браузера
        WebElement catalog =  driver.findElement(By.cssSelector("body > div.wrapper > div > header > div > div.header__nav > div > ul > li:nth-child(1) > a"));

        if(catalog.isDisplayed()) {
            catalog.click();
        }
        else {
            driver.findElement(By.cssSelector("a.sidebar__link.sidebar__link--burger")).click();
            driver.findElement(By.cssSelector("a.panel-burger__link")).click();
        }

        //Ждем появления не менее четырех элементов каталога и кладем их в список как-то хитро
        List<WebElement> list1 = wait.until(numberOfElementsToBeMoreThan(By.cssSelector("div.img_wrapper"), 4));

        // Пытаемся каждый элемент в списке добавить в корзину, и естессно получаем болт, но не совсем понимаем почему? с первым то прокатило.
        for (WebElement e : list1) {

            // Кликаем на товар
            e.click();

            // Отлавливаем всплывающее окно и тычем на крестик
            WebElement popup = driver.findElement(By.cssSelector("#subscrip-modal > div.index-popup__right"));
            if(popup.isDisplayed()) {
                driver.findElement(By.cssSelector("#subscrip-modal > div.index-popup__right > div.index-popup__close > a")).click();

                //Не понимаю почему оно крашится без sleep'а
                wait.until(not(visibilityOf(popup)));
                Thread.sleep(4000);
            }

            //Была ошибка, что элемент некликабельный, просто на всякий воткнул wait тобы понять как работает, но слипа строчкой выше хватает... пусть wait пока остается для дальнейших ковыряний
            WebElement buttonBuy = driver.findElement(By.cssSelector("#bx_117848907_101664_buy_link > a.card__buy-link.bx_big.bx_bt_button.bx_cart.buy-btn.current.buy"));
            wait.until(elementToBeClickable(buttonBuy));
            buttonBuy.click();

            //Топаем обратно в каталог, чтобы по логике цикл выбрал второй элемент и мы могли по нему кликнуть из каталога.
            if(catalog.isDisplayed()) {
                catalog.click();
            }

            else {
                // Мой первый костыльный костыль!
                try {
                    Thread.sleep(2000);
                    driver.findElement(By.cssSelector("body > div.wrapper > div > header > div > div.sidebar.sidebar-left > ul > li > a")).click();
                    Thread.sleep(2000);
                    driver.findElement(By.cssSelector("body > div.wrapper > div > header > div > div.sidebar.sidebar-left.sidebar--panel-open > div > div > div.panel-burger__list-wrapp > div > div > ul:nth-child(1) > li > a")).click();
                }

                catch(org.openqa.selenium.StaleElementReferenceException ex) {
                    Thread.sleep(2000);
                    driver.findElement(By.cssSelector("a.sidebar__link.sidebar__link--burger")).click();
                    Thread.sleep(2000);
                    driver.findElement(By.cssSelector("a.panel-burger__link")).click();
                }
            }
            Thread.sleep(3000);

            //Ловим ошибку org.openqa.selenium.StaleElementReferenceException: stale element reference: element is not attached to the page document
            //Даже костыльный try catch не отрабатывает, хоть и указал прямые локаторы до бургера и кнопки каталог

        }
    }


}
