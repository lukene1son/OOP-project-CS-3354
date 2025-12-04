package todo;

import java.util.ArrayList;

public class TaskManager {

    private ArrayList<Task> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void updateTask(int index, String title, String description) {
        Task t = tasks.get(index);
        t.setTitle(title);
        t.setDescription(description);
    }

    public void deleteTask(int index) {
        tasks.remove(index);
    }

    public void markCompleted(int index) {
        Task t = tasks.get(index);
        // Since Task class does not yet have setCompleted(), we will update it later.
        // For now, we directly access the field using reflection or a placeholder.
        // Temporarily, use a workaround:
        try {
            java.lang.reflect.Field field = Task.class.getDeclaredField("completed");
            field.setAccessible(true);
            field.setBoolean(t, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Task> getCompletedTasks() {
        ArrayList<Task> completed = new ArrayList<>();
        for (Task t : tasks) {
            if (t.isCompleted()) {
                completed.add(t);
            }
        }
        return completed;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }
}
