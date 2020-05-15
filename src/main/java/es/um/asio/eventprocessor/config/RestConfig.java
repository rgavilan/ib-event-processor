package es.um.asio.eventprocessor.config;

import java.time.Duration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Rest configuration
 */
@Configuration
public class RestConfig {
    /**
     * Rest Template.
     * 
     * @param builder
     *            Rest template builder.
     * @return {@link RestTemplate}.
     */
    @Bean
    public RestTemplate restTemplate(final RestTemplateBuilder builder) {
        // Do any additional configuration here
        return builder
        		.setConnectTimeout(Duration.ofMillis(30000)) // 30 seconds
                .setReadTimeout(Duration.ofMillis(30000)) // 30 seconds
        		.build();
    }
}
