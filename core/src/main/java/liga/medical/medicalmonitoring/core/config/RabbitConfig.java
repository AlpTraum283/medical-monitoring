package liga.medical.medicalmonitoring.core.config;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Logger;

@Configuration
public class RabbitConfig {

    @Value("${spring.rabbitmq.host}")
    private String LOCALHOST;

    @Value("${spring.rabbitmq.username}")
    private String username;

    @Value("${spring.rabbitmq.password}")
    private String password;

    @Value("${spring.rabbitmq.daily_queue}")
    private String DAILY_QUEUE;

    @Value("${spring.rabbitmq.alert_queue}")
    private String ALERT_QUEUE;

    @Value("${spring.rabbitmq.error_queue}")
    private String ERROR_QUEUE;

    Logger logger = Logger.getLogger(String.valueOf(RabbitConfig.class));

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory(LOCALHOST);
        cachingConnectionFactory.setUsername(username);
        cachingConnectionFactory.setPassword(password);
        return cachingConnectionFactory;
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
