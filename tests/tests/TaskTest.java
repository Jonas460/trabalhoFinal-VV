package tests;
import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import taskManager.Task;


public class TaskTest {
    @Test
    public void testTaskCreation() {
        String title = "Task 1";
        String description = "Description for Task 1";
        LocalDate deadline = LocalDate.of(2023, 7, 31);

        Task task = new Task(title, description, deadline);

        Assertions.assertEquals(title, task.getTitle());
        Assertions.assertEquals(description, task.getDescription());
        Assertions.assertEquals(LocalDate.now(), task.getCreationDate());
        Assertions.assertEquals(deadline, task.getDeadline());
        Assertions.assertFalse(task.isCompleted());
    }

    @Test
    public void testTaskCompletion() {
        String title = "Task 1";
        String description = "Description for Task 1";
        LocalDate deadline = LocalDate.of(2023, 7, 31);

        Task task = new Task(title, description, deadline);
        task.setCompleted(true);

        Assertions.assertTrue(task.isCompleted());
    }
}

