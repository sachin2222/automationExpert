package SwagLabs.Runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/failed.txt",
        glue ="SwagLabs/Steps",
        plugin = {"pretty", "html:target/cucumberfailedexecution-report.html",
                "rerun:target/failed.txt"}


)
public class FailedRunner {
}
