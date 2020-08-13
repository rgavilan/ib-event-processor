package es.um.asio.eventprocessor.runners.stepdefs;

import java.net.URLEncoder;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import es.um.asio.eventprocessor.service.MessageService;
import es.um.asio.eventprocessor.service.impl.MessageServiceImpl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.spring.CucumberContextConfiguration;

// @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@CucumberContextConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = { MessageStepDefinitions.MessageServiceConfiguration.class })
public class MessageStepDefinitions {
	
	@LocalServerPort
	private int port;
	private RestTemplate restTemplate = new RestTemplate();
	private String postUrl = "";
	
	
	// @Scope(SCOPE_CUCUMBER_GLUE)
	@TestConfiguration
	static class MessageServiceConfiguration {
		@Bean
		public MessageService messageService() {
			return new MessageServiceImpl();
		}
	}
	
	@Given("^a new message in managementdata queue$")
	public void a_new_message_in_management_data_queue() {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("Yess");
	}

	@Then("^the Event-processor sends the new message against Triple-Store-Adapter$")
	public void the_event_processor_sends_the_new_message_against_triple_store_adapter() {
	    String url = postUrl + ":" + port + "/dummy";
	    // restTemplate.postForLocation(URLEncoder.encode(url) , null);
	}	
}
