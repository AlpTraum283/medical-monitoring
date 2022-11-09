package liga.medical.medicalmonitoring.core.listenter;

import com.fasterxml.jackson.databind.JsonNode;
import liga.medical.common.dto.annotations.DbLog;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.logging.Logger;

@Component
public class MessageListener {
    Logger logger = Logger.getLogger(String.valueOf(MessageListener.class));

    @Autowired
    AmqpTemplate template;

    @RabbitListener(queues = "common_monitoring")
    @DbLog
    public void worker1(JsonNode body) {
        String messageType = String.valueOf(body.get("type")).replace('\"', ' ').strip() + "_queue";
        String message = String.valueOf(body.get("message")).replace('\"', ' ').strip();
        template.convertAndSend(messageType, message);
    }
}