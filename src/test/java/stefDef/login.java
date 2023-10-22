package TestRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stefDef",
        plugin = {"html:target/HTML_report.html"},
        tags = "@LoginSauceDemo"
)

public class loginRunner {
}
