package pages;

import generic.BasePage;
import generic.annotation.PagePath;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

@PagePath("")
public class CoverPage extends BasePage {
    private final static int ALL_HEADWEAR_NUMBER = 1;
    private final static int SHOP_YOUR_TEAM_NUMBER = 1;
    private final static int LIFESTYLE_NUMBER = 1;
    private final static int ENTERTAINMENT_NUMBER = 1;
    private final static int APPAREL_NUMBER = 1;

    private By signInLink = By.className("nav__links nav__links--account");
    private By menu = By.cssSelector("[data-ga-type=clickTopNav]");
    private By contentLayerLinks = By.cssSelector("div > div > div.multi-layer__background");

    public List<WebElement> getMenu() {
        return driver().findElements(menu);
    }

    public WebElement getAllHeadwearLink() {
        return getMenu().get(ALL_HEADWEAR_NUMBER);
    }

    public WebElement getShopYourTeamSub() {
        return getMenu().get(SHOP_YOUR_TEAM_NUMBER);
    }

    public WebElement getLifestyleSub() {
        return getMenu().get(LIFESTYLE_NUMBER);
    }

    public WebElement getEntertainmentSub() {
        return getMenu().get(ENTERTAINMENT_NUMBER);
    }

    public WebElement getApparelSub() {
        return getMenu().get(APPAREL_NUMBER);
    }

    public List<WebElement> getContentLayerLinks() {
        return driver().findElements(contentLayerLinks);
    }

    public CoverPage() {
        waitLoadableElement(contentLayerLinks);
        setLoadableElement(contentLayerLinks);
    }
}
