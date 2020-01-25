package generic;

import generic.annotation.PagePath;
import generic.webdriver.WebDriverRunner;
import lombok.extern.log4j.Log4j;
import org.assertj.core.api.AbstractBooleanAssert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static general.GeneralData.softAssertions;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@Log4j
public abstract class BaseHelper<PAGE extends BasePage> {
    public static final String baseURL = "https://lb.aqa.us.nwer-hybr.projects.epam.com/";

    private PAGE page;
    private WebDriver webDriver;

    public PAGE getPage() {
        return page;
    }

    public BaseHelper(PAGE page) {
        webDriver = WebDriverRunner.getWebDriver();
        this.page = page;
    }

    public void isOnPage() {
        log.info("Wait page loading");
        this.page.waitLoadableElement(this.page.getLoadableElement());
        softAssertions.assertThat(WebDriverRunner.getWebDriver().getCurrentUrl())
                .as("Current URL is not equal base url + page url ")
                .isEqualTo(getPageUrl(this.page));
    }

    private String getPageUrl(BasePage page) {
        return BaseHelper.baseURL + page.getClass().getAnnotation(PagePath.class).value();
    }

    public void openPage() {
        String pageLink = getPageUrl(this.page);
        webDriver.get(pageLink);
        log.info(String.format("Page with link %s was opened", pageLink));
    }

    public BaseHelper filledField(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
        log.debug(String.format("Entered %s",text));
        assertThat(element.getAttribute("value"))
                .as("Entering text is not showing in field")
                .contains(text);
        return this;
    }

    public AbstractBooleanAssert<?> checkElementDisplay(WebElement element) {
        return softAssertions.assertThat(element.isDisplayed())
                .as("Cannot find first name input field")
                .isTrue();
    }
}
