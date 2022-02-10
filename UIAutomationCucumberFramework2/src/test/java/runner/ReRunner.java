package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "@target/failed_scenario.txt",glue = "stepDefinition",dryRun = false,monochrome = true)
public class ReRunner {

}
