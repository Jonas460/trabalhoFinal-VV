package taskManager;

import java.time.LocalDate;

public class Task {
    private String title;
    private String description;
    private LocalDate creationDate;
    private LocalDate deadline;
    private boolean completed;

    public Task(String title, String description, LocalDate deadline) {
        this.title = title;
        this.description = description;
        this.creationDate = LocalDate.now();
        this.deadline = deadline;
        this.completed = false;
    }

    // Getters and setters

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
