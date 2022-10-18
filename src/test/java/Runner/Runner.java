package Runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C:\\Users\\sachi\\IdeaProjects\\SeleniumBDDFrameworkj\\src\\test\\java\\Feature\\AddEmployee.feature",
        glue = "Steps",
        plugin = {"progress", "html:target/cucumber-report.html"},
        dryRun = false,
        monochrome = true
)
public class Runner {
}
