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

    public ArrayList<Task> getTasks() {
        return tasks;
    }
}
