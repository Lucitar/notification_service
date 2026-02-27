# Notification Service

A microservice that listens for task creation events and processes notifications.
Built with Java and Spring Boot, communicating via RabbitMQ.

## Tech Stack

- Java 17
- Spring Boot 4.0.3
- Spring AMQP (RabbitMQ)
- Lombok
- Maven

## Architecture

This service is part of a microservices system alongside [task_service](https://github.com/Lucitar/task_manager_api).
```
task-service → RabbitMQ → notification-service
```

When a task is created in task-service, a message is published to the
`task.exchange` exchange with routing key `task.created`.
This service listens to the `task.notifications` queue and logs the notification.

## Running

This service is meant to be run with Docker Compose from the task-service repository:
```bash
git clone https://github.com/Lucitar/task_manager_api
cd task_manager_api
docker-compose up --build
```

## Project Structure
```
src/main/java/com/notifications/notification_service/
├── NotificationApplication.java
├── config/
│   └── RabbitMQConfig.java      # Queue, exchange and binding setup
├── model/
│   └── TaskMessage.java         # Message model
├── consumer/
│   └── TaskConsumer.java        # RabbitMQ listener
└── service/
    └── NotificationService.java # Notification processing
```