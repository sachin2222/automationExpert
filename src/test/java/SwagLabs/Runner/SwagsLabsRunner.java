package SwagLabs.Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C:\\Users\\sachi\\OneDrive\\Desktop\\AutomationProject\\SeleniumBDDFrameworkj\\src\\test\\java\\SwagLabs\\Feature\\bacground.feature",
        glue = "SwagLabs/Steps",
        plugin = {"pretty", "html:target/cucumber-report.html"
                ,"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        publish = true,
        dryRun = false,
        monochrome = true,
        stepNotifications = true
)
public class SwagsLabsRunner {
}
