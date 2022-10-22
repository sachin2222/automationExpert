package SwagLabs.Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C:\\Users\\sachi\\OneDrive\\Desktop\\AutomationProject\\SeleniumBDDFrameworkj\\src\\test\\java\\SwagLabs\\Feature\\swagLabs.feature",
        glue = "SwagLabs/Steps",
        plugin = {"progress", "html:target/cucumber-report.html"},
        dryRun = false,
        monochrome = true,
        tags = "@Login or @Cart"


)
public class SwagsLabsRunner {
}
