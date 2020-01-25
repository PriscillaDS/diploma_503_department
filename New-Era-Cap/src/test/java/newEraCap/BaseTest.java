package newEraCap;

import generic.webdriver.WebDriverRunner;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        WebDriverRunner.setDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        WebDriverRunner.close();
    }
}
