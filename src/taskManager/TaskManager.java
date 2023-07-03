package taskManager;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks;

    public TaskManager() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }

    public void updateTask(Task task, String title, String description, LocalDate deadline) {
        task.setTitle(title);
        task.setDescription(description);
        task.setDeadline(deadline);
    }

    public List<Task> getAllTasks() {
        return tasks;
    }
}

