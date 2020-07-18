import cucumber.api.java.After;
import cucumber.api.java.Before;
import functionLibrary.CommonFunctions;

public class Hooks extends CommonFunctions {

    CommonFunctions commonObject = new CommonFunctions();

    @Before
    public void beforeTest() {
        commonObject.openBrowser();
    }

    @After
    public void afterTest() {
        commonObject.closeBrowser();
    }
}
