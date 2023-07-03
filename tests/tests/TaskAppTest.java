package tests;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import taskManager.TaskApp;

public class TaskAppTest {

    TaskApp taskApp = new TaskApp();
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setup() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void testAddTask() {
        String input = "1\nTask 1\nDescription for Task 1\n2023-07-31\n5\n";
        provideInput(input);

        TaskApp.main(new String[0]);

        String output = outputStream.toString();
        taskApp.exit(0);

        Assertions.assertTrue(output.contains("Task added successfully!"));

    }

    @Test
    public void testRemoveTask() {
        String input = "1\nTask 1\nDescription for Task 1\n2023-07-31\n2\nTask 1\n5\n";
        provideInput(input);

        TaskApp.main(new String[0]);

        String output = outputStream.toString();

        Assertions.assertTrue(output.contains("Task removed successfully!"));
        taskApp.exit(0);
    }

    @Test
    public void testUpdateTask() {
        String input = "1\nTask 1\nDescription for Task 1\n2023-07-31\n3\nTask 1\nUpdated Task\nUpdated description\n2023-09-30\n5\n";
        provideInput(input);

        TaskApp.main(new String[0]);

        String output = outputStream.toString();

        Assertions.assertTrue(output.contains("Task updated successfully!"));
        taskApp.exit(0);
    }

    private void provideInput(String data) {
        InputStream inputStream = new ByteArrayInputStream(data.getBytes());
        System.setIn(inputStream);
    }
}
