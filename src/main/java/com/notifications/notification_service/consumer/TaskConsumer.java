package com.notifications.notification_service.consumer;

import com.notifications.notification_service.config.RabbitMQConfig;
import com.notifications.notification_service.model.TaskMessage;
import com.notifications.notification_service.service.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TaskConsumer {

    private static final Logger logger = LoggerFactory.getLogger(TaskConsumer.class);
    private final NotificationService notificationService;

    public TaskConsumer(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void receiveMessage(TaskMessage task) {
        logger.info("Message received from queue: {}", task.getTitle());
        notificationService.processTaskCreated(task);
    }
}