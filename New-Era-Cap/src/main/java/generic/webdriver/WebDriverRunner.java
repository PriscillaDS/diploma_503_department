package generic.webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@Log4j
public class WebDriverRunner {
    public static WebDriver webDriver;

    public static WebDriver getWebDriver() {
        return webDriver;
    }

    public static WebDriver setDriver() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        log.info("Driver was created");
        return webDriver;
    }

    public static void close() {
        if (webDriver != null) {
            webDriver.quit();
            log.info("Driver was closed");
        }
    }

}
