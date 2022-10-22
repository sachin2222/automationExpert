package Runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C:\\Users\\sachi\\OneDrive\\Desktop\\AutomationProject\\SeleniumBDDFrameworkj\\src\\test\\java\\Feature\\hooks.feature",
        glue = "Hooks",
        plugin = {"progress", "html:target/cucumber-report.html"},
        dryRun = false,
        monochrome = true
)
public class Runner {
}
