package newEraCap.cover;

import helpers.CoverPageHelper;
import newEraCap.BaseTest;
import org.testng.annotations.Test;

public class QuickTest extends BaseTest {

    @Test
    public void QuickTest() {
        CoverPageHelper coverPageHelper = new CoverPageHelper();
        coverPageHelper.openPage();
        coverPageHelper.isOnPage();
    }
}
