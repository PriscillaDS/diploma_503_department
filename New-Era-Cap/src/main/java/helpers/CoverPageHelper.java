package helpers;

import generic.BaseHelper;
import lombok.extern.log4j.Log4j;
import pages.CoverPage;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j
public class CoverPageHelper extends BaseHelper<CoverPage> {
    private final static String ALL_HEADWEAR_TEXT = "All Headwear";
    private final static String SHOP_YOUR_TEAM_TEXT = "SHOP YOUR TEAM";
    private final static String LIFESTYLE_TEXT = "LIFESTYLE";
    private final static String ENTERTAINMENT_TEXT = "Entertainment";
    private final static String APPAREL_TEXT = "Apparel";
    public CoverPageHelper() {
        super(new CoverPage());
        log.info("New Cover Page Helper object was initialised");
    }

    public CoverPageHelper checkMenuIsShoving() {
        assertThat(getPage().getAllHeadwearLink().getText()).isEqualTo(ALL_HEADWEAR_TEXT);
        assertThat(getPage().getShopYourTeamSub().getText()).isEqualTo(SHOP_YOUR_TEAM_TEXT);
        assertThat(getPage().getEntertainmentSub().getText()).isEqualTo(ENTERTAINMENT_TEXT);
        assertThat(getPage().getLifestyleSub().getText()).isEqualTo(LIFESTYLE_TEXT);
        assertThat(getPage().getApparelSub().getText()).isEqualTo(APPAREL_TEXT);
        return this;
    }

}
