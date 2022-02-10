package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features", glue = "stepDefinition", dryRun = false,monochrome = true,
//plugin = {"rerun:target/failed_scenario.txt","pretty"}
plugin= {"io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm","rerun:target/failed_scenario.txt","html:target/cucumber-report.html","pretty",
		"json:target/cucumber-json-report.json","junit:target/cucumber-xml-report.xml",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},publish = true

//Use pretty when you want to know what steps which are  executed, give monochrome as true to get human readable format
//Use "Usage" to know the time taken to execute the steps
//give "publish = true" under cucumber options to get default report from cucumber
)
public class RunnerClass {

}
