package com.notifications.notification_service.service;

import com.notifications.notification_service.model.TaskMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private static final Logger logger = LoggerFactory.getLogger(NotificationService.class);

    public void processTaskCreated(TaskMessage task) {
        logger.info("New task created — ID: {}, Title: {}, Priority: {}",
            task.getId(),
            task.getTitle(),
            task.getPriority()
        );
    }
}