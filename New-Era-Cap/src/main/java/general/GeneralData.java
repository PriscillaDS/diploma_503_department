package general;

import org.assertj.core.api.SoftAssertions;

import static org.apache.commons.lang3.RandomStringUtils.*;

public class GeneralData {
    public final static SoftAssertions softAssertions = new SoftAssertions();

    public final static String VALID_SHORT_PASSWORD = randomAscii(6);
    public final static String VALID_SHORT_FIRST_NAME = randomAscii(6);
    public final static String VALID_SHORT_LAST_NAME = randomAscii(6);
    public final static String VALID_LONG_FIRST_NAME = randomAscii(253);
    public final static String VALID_LONG_LAST_NAME = randomAscii(1);
    public final static String INVALID_LONG_PASSWORD = randomAscii(255);
    public final static String EXISTING_EMAIL = "xelasid367@ettke.com";
    public final static String EXISTING_PASSWORD = "testtest";


    public static String getValidEmail() {
        return  random(10, true, true) + "@" + randomAlphabetic(4) + "." + randomAlphabetic(2);
    }
}
