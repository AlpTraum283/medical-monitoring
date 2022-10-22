package liga.medical.medicalmonitoring.core.config;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.logging.Logger;

@Configuration
public class RabbitConfig {
    private static final String LOCALHOST = "172.10.0.1";
    private static final String DAILY_QUEUE = "daily_queue";
    private static final String ALERT_QUEUE = "alert_queue";
    private static final String ERROR_QUEUE = "error_queue";

    Logger logger = Logger.getLogger(String.valueOf(RabbitConfig.class));

    @Bean
    public ConnectionFactory connectionFactory() {
        return new CachingConnectionFactory(LOCALHOST);
    }

    @Bean
    public AmqpAdmin amqpAdmin() {
        return new RabbitAdmin(connectionFactory());
    }

    @Bean
    public Queue dailyQueue() {
        return new Queue(DAILY_QUEUE);
    }

    @Bean
    public Queue alertQueue() {
        return new Queue(ALERT_QUEUE);
    }

    @Bean
    public Queue errorQueue() {
        return new Queue(ERROR_QUEUE);
    }

}
