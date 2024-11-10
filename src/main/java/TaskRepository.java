import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TaskRepository {
    private static final List<Task> tasks = new ArrayList<>();
    private static int currentId = 1;

    public static void addTask(String description, String status) {
        tasks.add(new Task(currentId++, description, status));
    }

    public static void updateTask(int id, String description, String status) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setDescription(description);
                task.setStatus(status);
                break;
            }
        }
    }

    public static void deleteTask(int id) {
        tasks.removeIf(task -> task.getId() == id);
    }

    public static Optional<Task> getTaskById(int id) {
        return tasks.stream().filter(task -> task.getId() == id).findFirst();
    }

    public static List<Task> getAllTasks() {
        return tasks;
    }
}
