package es.um.asio.eventprocessor.service;

import es.um.asio.abstractions.domain.ManagementBusEvent;

/**
 * Service to handle message entity related operations
 */
public interface MessageService {
    /**
     * Process a message
     *
     * @param message
     *            The message
     */
    void process(ManagementBusEvent message);
}
