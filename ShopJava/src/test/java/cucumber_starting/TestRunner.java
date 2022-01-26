/*
@author Admin
@Date Jan 16, 2022

*/
package cucumber_starting;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\resources\\Features",glue= {"StepDefinitions"},monochrome=true,
plugin = { "pretty", "junit:target/JunitReports/report.xml" }
)
public class TestRunner {
}
