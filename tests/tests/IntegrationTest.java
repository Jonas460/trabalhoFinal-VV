package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import taskManager.Task;
import taskManager.TaskManager;

import java.time.LocalDate;
import java.util.List;

public class IntegrationTest {
    private TaskManager taskManager;
    private Task task1;
    private Task task2;

    @BeforeEach
    public void setup() {
        taskManager = new TaskManager();

        String title1 = "Task 1";
        String description1 = "Description for Task 1";
        LocalDate deadline1 = LocalDate.of(2023, 7, 31);
        task1 = new Task(title1, description1, deadline1);

        String title2 = "Task 2";
        String description2 = "Description for Task 2";
        LocalDate deadline2 = LocalDate.of(2023, 8, 15);
        task2 = new Task(title2, description2, deadline2);

        taskManager.addTask(task1);
        taskManager.addTask(task2);
    }

    @Test
    public void testAddTask() {
        List<Task> tasks = taskManager.getAllTasks();
        Assertions.assertEquals(2, tasks.size());
        Assertions.assertTrue(tasks.contains(task1));
        Assertions.assertTrue(tasks.contains(task2));
    }

    @Test
    public void testRemoveTask() {
        taskManager.removeTask(task1);

        List<Task> tasks = taskManager.getAllTasks();
        Assertions.assertEquals(1, tasks.size());
        Assertions.assertFalse(tasks.contains(task1));
        Assertions.assertTrue(tasks.contains(task2));
    }

    @Test
    public void testUpdateTask() {
        String newTitle = "Updated Task";
        String newDescription = "Updated description";
        LocalDate newDeadline = LocalDate.of(2023, 9, 30);

        taskManager.updateTask(task1, newTitle, newDescription, newDeadline);

        Assertions.assertEquals(newTitle, task1.getTitle());
        Assertions.assertEquals(newDescription, task1.getDescription());
        Assertions.assertEquals(newDeadline, task1.getDeadline());
    }
}

