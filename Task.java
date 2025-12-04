package todo;

public class Task {
    private String title;
    private String description;
    private boolean completed;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.completed = false;
    }

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

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return (completed ? "[✔] " : "[ ] ") + title;
    }

    // For saving to file
    public String toData() {
        return title + ";" + description + ";" + completed;
    }

    public static Task fromData(String line) {
        String[] parts = line.split(";");
        if (parts.length != 3) {
            return null;
        }
        Task t = new Task(parts[0], parts[1]);
        t.setCompleted(Boolean.parseBoolean(parts[2]));
        return t;
    }
}
