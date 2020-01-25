package generic;

import generic.webdriver.WebDriverRunner;
import lombok.Getter;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

@Log4j
@Getter
public abstract class BasePage implements Page {
    private By loadableElement;
    public static WebDriver driver() {
        return WebDriverRunner.getWebDriver();
    }


    protected void setLoadableElement(By loadableElement) {
        this.loadableElement = loadableElement;
    }

    @Override
    public void waitLoadableElement(By element) {
        WebDriverWait wait = new WebDriverWait(driver(), 10);
        wait.until(visibilityOfElementLocated(element));
        log.debug("Element was found" + element.toString());
    }
}
