package ilmTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class baseTest {
    WebDriver driver;
    WebDriverWait wait;
    ChromeOptions options = new ChromeOptions();

    @BeforeTest //пока не передаем никакие аргументы запуска хрому
    public void start() {
        options.addArguments("start-maximized");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);


    }

   /* @AfterTest
    public void stop() {
        driver.quit();
        driver = null;
    }*/
}
