package liga.medical.medicalmonitoring.core.config;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Value("${spring.rabbitmq.host}")
    private String localhost;

    @Value("${spring.rabbitmq.username}")
    private String username;

    @Value("${spring.rabbitmq.password}")
    private String password;

    @Value("${spring.rabbitmq.daily_queue}")
    private String dailyQueue;

    @Value("${spring.rabbitmq.alert_queue}")
    private String alertQueue;

    @Value("${spring.rabbitmq.error_queue}")
    private String errorQueue;

    @Value("${spring.rabbitmq.common_queue}")
    private String commonQueue;

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory(localhost);
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
        return new Queue(dailyQueue);
    }

    @Bean
    public Queue alertQueue() {
        return new Queue(alertQueue);
    }

    @Bean
    public Queue errorQueue() {
        return new Queue(errorQueue);
    }

    @Bean
    public Queue commonQueue() {
        return new Queue(commonQueue);
    }

}
