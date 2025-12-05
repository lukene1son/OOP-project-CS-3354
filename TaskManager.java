package todo;

import java.io.*;
import java.util.ArrayList;

public class TaskManager {

    private ArrayList<Task> tasks;
    private final String FILE_NAME = "tasks.txt";

    public TaskManager() {
        tasks = new ArrayList<>();
        loadFromFile();
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
        saveToFile();
    }

    public void updateTask(int index, String title, String description) {
        Task t = tasks.get(index);
        t.setTitle(title);
        t.setDescription(description);
        saveToFile();
    }

    public void deleteTask(int index) {
        tasks.remove(index);
        saveToFile();
    }

    public void markCompleted(int index) {
        Task t = tasks.get(index);
        t.setCompleted(true);
        saveToFile();
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

    private void saveToFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Task t : tasks) {
                pw.println(t.toData());
            }
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }

    private void loadFromFile() {
        File f = new File(FILE_NAME);
        if (!f.exists()) {
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                Task t = Task.fromData(line);
                if (t != null) {
                    tasks.add(t);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading tasks: " + e.getMessage());
        }
    }
}
