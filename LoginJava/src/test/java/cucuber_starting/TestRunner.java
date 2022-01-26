/*
@author Admin
@Date Jan 8, 2022

*/
package cucuber_starting;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\resources\\Features\\",glue= {"StepDefinitions"},monochrome=true,
plugin = { "pretty", "junit:target/JunitReports/report.xml" }
)
public class TestRunner {

}
