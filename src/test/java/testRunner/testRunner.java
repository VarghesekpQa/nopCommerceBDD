package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="D://Software Testing//CucumberForTesters//NopCommerceBdd//features",
		glue="stepDefenition",
		dryRun=false,
		monochrome=true,
		plugin= {"pretty","html:test-output"}
		
		)
public class testRunner {
}
