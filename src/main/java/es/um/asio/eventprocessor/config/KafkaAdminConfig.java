package es.um.asio.eventprocessor.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Kafka related configuration
 */
@ConditionalOnProperty(prefix = "app.kafka", name = "create-topics", havingValue = "true", matchIfMissing = false)
@Configuration
public class KafkaAdminConfig {
    
    /**
     * Management topic name.
     */
    @Value("${app.kafka.management-topic-name}")
    private String managementTopicName;
    
    /**
     * General topic.
     * @return
     */
    @Bean
    public NewTopic generalTopic() {
        return new NewTopic(this.managementTopicName, 1, (short) 1);
    }
}
