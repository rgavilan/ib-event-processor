package es.um.asio.eventprocessor.activemq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import es.um.asio.abstractions.domain.ManagementBusEvent;

/**
 * The Class MessageConsumer.
 */
@Component
public class MessageConsumer {

	private final Logger logger = LoggerFactory.getLogger(MessageConsumer.class);

    /**
     * Listener.
     *
     * @param message the message
     */
    @JmsListener(destination = "${app.activemq.queue-name:default-queue-name}")
    public void listener(final ManagementBusEvent message){
        logger.info("Message received {} ", message);
    }
}