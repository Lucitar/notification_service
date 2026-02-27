package com.notifications.notification_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskMessage {
    private Long id;
    private String title;
    private String description;
    private String priority;
}