package es.um.asio.eventprocessor.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty", "html:target/cucumber", "summary"},
		features = {"src/test/features"},
		glue = {"es.um.asio.eventprocessor.runners.stepdefs"}		
		)
public class EventProcessorRunner {
}
