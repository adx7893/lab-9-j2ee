package model;

import java.util.ArrayList;
import java.util.List;

public class TaskRepository {
	private List<Task> tasks = new ArrayList<>();
    private int taskIdCounter = 1;

    public void addTask(String description, String status) {
        Task newTask = new Task(taskIdCounter++, description, status);
        tasks.add(newTask);
    }

    public List<Task> getAllTasks() {
        return tasks;
    }

    public void deleteTask(int id) {
        tasks.removeIf(task -> task.getId().equals(id));
    }
}
