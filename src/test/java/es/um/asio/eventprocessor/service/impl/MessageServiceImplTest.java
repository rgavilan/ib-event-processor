package es.um.asio.eventprocessor.service.impl;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import es.um.asio.abstractions.domain.ManagementBusEvent;
import es.um.asio.abstractions.domain.Operation;
import es.um.asio.eventprocessor.service.MessageService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { MessageServiceImplTest.MessageServiceConfiguration.class })
@ActiveProfiles("unit-test")
public class MessageServiceImplTest {

	@Autowired
	public RestTemplate restTemplate;

	@Autowired
	private MessageService messageService;

	private MockRestServiceServer mockServer;

	@TestConfiguration
	static class MessageServiceConfiguration {
		@Bean
		public MessageService messageService() {
			return new MessageServiceImpl();
		}
	}

	@Before
	public void setUp() {	
		ReflectionTestUtils.setField(messageService, "messagesEndpoint", "http://localhost:9324/message");
		mockServer = MockRestServiceServer.createServer(restTemplate);
	}

	@Test
	public void process() {
		
		mockServer.expect(ExpectedCount.once(), requestTo(
				"http://localhost:9324/message"))
				.andExpect(method(HttpMethod.POST))
				.andRespond(withSuccess());
				;

		ManagementBusEvent message = new ManagementBusEvent();
		message.setClassName("proyecto");
		message.setIdModel("http://hercules.org/um/es-ES/rec/Proyecto/1");
		message.setModel("<rdf:RDF xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\" xmlns:Proyecto=\"http://hercules.org/um/es-ES/rec/Proyecto/\"> <rdf:Description rdf:about=\"http://hercules.org/um/es-ES/rec/Proyecto/1\"> <rdf:type rdf:resource=\"http://hercules.org/um/es-ES/rec/Proyecto/\"/> <Proyecto:grupoInvestigacion rdf:resource=\"http://hercules.org/um/es-ES/rec/GrupoInvestigacion/1\"/> <Proyecto:nombre xml:lang=\"es\">PROJECT ONE</Proyecto:nombre> <Proyecto:id xml:lang=\"es\">1</Proyecto:id> </rdf:Description> </rdf:RDF>");
		message.setOperation(Operation.INSERT);
		
		messageService.process(message);

		mockServer.verify();
		
	}
}
