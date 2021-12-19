package cucumber.run;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/java/features/IncidentManagement.feature"},
					glue = {"steps","cucumber.run"})
public class RunCucumber extends AbstractTestNGCucumberTests{

}
