import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(features = ".", dryRun = false, strict = true,
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/tsr/report.html"})

public class Runner {

}
