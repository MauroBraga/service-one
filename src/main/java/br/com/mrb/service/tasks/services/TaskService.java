package br.com.mrb.service.tasks.services;

import br.com.mrb.service.tasks.NotificationRequest;
import br.com.mrb.service.tasks.clients.NotificationClient;
import br.com.mrb.service.tasks.entity.TasksEntity;
import br.com.mrb.service.tasks.repositorys.TasksRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {

    private final TasksRepository tasksRepository;

    private final NotificationClient notificationClient;

    public TaskService(TasksRepository tasksRepository, NotificationClient notificationClient) {
        this.tasksRepository = tasksRepository;
        this.notificationClient = notificationClient;
    }

    public void sendNotificationForDueTasks(){

        LocalDateTime deadline = LocalDateTime.now().plusDays(1); // Define o prazo como 24 horas a partir de agora

        List<TasksEntity> tasks = tasksRepository.findTasksDueWithinDeadline(deadline);
        for (TasksEntity task : tasks){
            NotificationRequest request = new NotificationRequest("Sua tarefa: " + task.getTitle() + "está prestes a vencer", task.getEmail());
            notificationClient.sendNotification(request);
            task.setNotified(true);
        }
    }

}
