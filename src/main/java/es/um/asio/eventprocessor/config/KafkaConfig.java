package es.um.asio.eventprocessor.config;

import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.ui.Model;

import es.um.asio.abstractions.domain.ManagementBusEvent;

/**
 * Kafka related configuration.
 */
@EnableKafka
@Configuration
public class KafkaConfig {
	
	/**
     * Kafka properties.
     */
    @Autowired
    private KafkaProperties kafkaProperties;

	
	 
    /**
     * Pojo consumer factory.
     *
     * @return the consumer factory
     */
    public ConsumerFactory<String, ManagementBusEvent<Model>> managementBusConsumerFactory() {
    	return new DefaultKafkaConsumerFactory<>(this.getKafkaConfiguration());
    }
    
    
    /**
     * Pojo kafka listener container factory.
     *
     * @return the concurrent kafka listener container factory
     */
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, ManagementBusEvent<Model>> managementBusKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, ManagementBusEvent<Model>> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(this.managementBusConsumerFactory());
        return factory;
    }
    
    /**
     * Gets the kafka configuration.
     *
     * @return the kafka configuration
     */
    private Map<String, Object> getKafkaConfiguration() {
    	Map<String, Object> customerConfigMap = this.kafkaProperties.getConsumer().buildProperties();
    	customerConfigMap.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
    	customerConfigMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
    	customerConfigMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
    	return customerConfigMap;
    }
}
