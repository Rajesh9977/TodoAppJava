package com.app.Todoapp.Services;

import com.app.Todoapp.models.Task;
import com.app.Todoapp.repository.TaskRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }


    public void createTask(String title) {
        Task task = new Task();
        task.setTitle(title);
        task.setCompleted(false);
        taskRepository.save(task);
    }

    public void deleteTask(int id) {
        return taskRepository.deleteById(id);
    }

    public void toggleTask(int id) {
        return taskRepository.findAll(id);
    }
}
