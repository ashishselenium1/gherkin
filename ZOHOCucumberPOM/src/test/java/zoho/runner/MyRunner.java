package zoho.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        //features = "@rerun/failed_scenarios.txt",
		 features = "src/test/resources/zoho",
         glue = {"zoho.teststeps"},
         plugin = { "html:target/cucumber-reports.html","rerun:rerun/failed_scenarios.txt"},
         tags = "@CreateLead",
         monochrome = false,
         dryRun = false
)
public class MyRunner extends AbstractTestNGCucumberTests {

}
