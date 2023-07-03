package taskManager;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class TaskApp {
    private TaskManager taskManager;
    private Scanner scanner;
    private static boolean exit = true;

    public TaskApp() {
        this.taskManager = new TaskManager();
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("Task Manager");
        System.out.println("1. Add Task");
        System.out.println("2. Remove Task");
        System.out.println("3. Update Task");
        System.out.println("4. View All Tasks");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    public void addTask() {
        System.out.print("Enter task title: ");
        String title = scanner.nextLine();

        System.out.print("Enter task description: ");
        String description = scanner.nextLine();

        System.out.print("Enter task deadline (YYYY-MM-DD): ");
        String deadlineStr = scanner.nextLine();
        LocalDate deadline = LocalDate.parse(deadlineStr);

        Task task = new Task(title, description, deadline);
        taskManager.addTask(task);

        System.out.println("Task added successfully!");
    }

    public void removeTask() {
        System.out.print("Enter task title: ");
        String title = scanner.nextLine();

        List<Task> tasks = taskManager.getAllTasks();
        for (Task task : tasks) {
            if (task.getTitle().equalsIgnoreCase(title)) {
                taskManager.removeTask(task);
                System.out.println("Task removed successfully!");
                return;
            }
        }

        System.out.println("Task not found!");
    }

    public void updateTask() {
        System.out.print("Enter task title: ");
        String title = scanner.nextLine();

        List<Task> tasks = taskManager.getAllTasks();
        for (Task task : tasks) {
            if (task.getTitle().equalsIgnoreCase(title)) {
                System.out.print("Enter new task title: ");
                String newTitle = scanner.nextLine();

                System.out.print("Enter new task description: ");
                String newDescription = scanner.nextLine();

                System.out.print("Enter new task deadline (YYYY-MM-DD): ");
                String newDeadlineStr = scanner.nextLine();
                LocalDate newDeadline = LocalDate.parse(newDeadlineStr);

                taskManager.updateTask(task, newTitle, newDescription, newDeadline);
                System.out.println("Task updated successfully!");
                return;
            }
        }

        System.out.println("Task not found!");
    }

    public void viewAllTasks() {
        List<Task> tasks = taskManager.getAllTasks();
        if (tasks.isEmpty()) {
            System.out.println("No tasks found!");
        } else {
            System.out.println("All Tasks:");
            for (Task task : tasks) {
                System.out.println(task.getTitle());
                System.out.println("Description: " + task.getDescription());
                System.out.println("Deadline: " + task.getDeadline());
                System.out.println("Completed: " + (task.isCompleted() ? "Yes" : "No"));
                System.out.println();
            }
        }
    }

    public void exit(int status) {
        if (status == 1) {
            exit = false;
        } else {
            exit = true;
        }
    }

    public static void main(String[] args) {
        TaskApp taskApp = new TaskApp();

        while (exit) {
            taskApp.displayMenu();
            int choice = Integer.parseInt(taskApp.scanner.nextLine());

            switch (choice) {
                case 1:
                    taskApp.addTask();
                    break;
                case 2:
                    taskApp.removeTask();
                    break;
                case 3:
                    taskApp.updateTask();
                    break;
                case 4:
                    taskApp.viewAllTasks();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    taskApp.exit(1);
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
