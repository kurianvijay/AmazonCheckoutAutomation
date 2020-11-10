import com.cucumber.listener.Reporter;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import functionLibrary.CommonFunctions;
import org.junit.AfterClass;
import org.junit.Test;

public class Hooks extends CommonFunctions {

    CommonFunctions commonObject = new CommonFunctions();

    @Before
    public void beforeTest() {
        commonObject.openBrowser();
    }

//    @Test
//    public void takeScreenshotOnFailure() throws Exception {
//
//    }


    @After
    public void afterTest() {
        commonObject.closeBrowser();
    }

    @AfterClass
    public static void generateTestSummaryReport()
    {
        Reporter.loadXMLConfig("/Users/vijaykurian/IdeaProjects/AmazonCheckoutAutomation/src/main/resources/config/extent-config.xml");
    }
}
