package com.app.Todoapp.Controller;

import com.app.Todoapp.Services.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.app.Todoapp.models.Task;

import java.util.List;

@Controller
//@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskservice;


    public TaskController(TaskService taskservice) {
        this.taskservice = taskservice;
    }

    @GetMapping
    public String getTasks(Model model){
        List<Task> tasks = taskservice.getAllTasks();
        model.addAttribute("tasks",tasks);

        return "tasks"; //now it is going to lookout for tasks.html
    }

    @PostMapping
    public String getTasks(@RequestParam String title){
        taskservice.createTask(title);
        return "redirect:/"; //now it is going to lookout for tasks.html
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable int id){
        taskservice.deleteTask(id);
        return "redirect:/";
    }

    @GetMapping("/toggle/{id}")
    public String toggleTask(@PathVariable int id){
        taskservice.toggleTask(id);
        return "redirect:/";
    }
}
