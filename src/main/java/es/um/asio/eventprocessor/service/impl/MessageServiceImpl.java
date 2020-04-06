package es.um.asio.eventprocessor.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import es.um.asio.eventprocessor.service.MessageService;

/**
 * Service implementation to handle message entity related operations
 *
 */
@Service
public class MessageServiceImpl implements MessageService {

    /**
     * Logger
     */
    private final Logger logger = LoggerFactory.getLogger(MessageServiceImpl.class);
    
    @Value("${app.microservices.storage-adapter.messages-endpoint}")
    private String messagesEndpoint;
    
    /**
     * Rest Template
     */
    @Autowired
    private RestTemplate restTemplate;

    /**
     * {@inheritDoc}
     */
    @Override
    public void process(final String message) {
        if (this.logger.isDebugEnabled()) {
            this.logger.debug("Insert new message: {}", message);
        }
        
        restTemplate.postForObject(messagesEndpoint, message, Void.class);

        if (this.logger.isDebugEnabled()) {
            this.logger.debug("Message sent to storage-adapter: {}", message);
        }
    }

}
