package todo;

import javax.swing.*;
import java.awt.*;

public class TaskGUI extends JFrame {
    private TaskManager manager;
    private JList<Task> taskList;
    private DefaultListModel<Task> listModel;

    public TaskGUI(TaskManager m) {
        this.manager = m;

        setTitle("To-Do List");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);
        refreshList();

        JButton addBtn = new JButton("Add Task");
        JButton editBtn = new JButton("Edit Task");
        JButton completeBtn = new JButton("Mark Completed");
        JButton deleteBtn = new JButton("Delete Task");
        JButton showCompletedBtn = new JButton("Show Completed");

        addBtn.addActionListener(e -> addTask());
        editBtn.addActionListener(e -> editTask());
        completeBtn.addActionListener(e -> completeTask());
        deleteBtn.addActionListener(e -> deleteTask());
        showCompletedBtn.addActionListener(e -> showCompleted());

        JPanel panel = new JPanel(new GridLayout(5, 1));
        panel.add(addBtn);
        panel.add(editBtn);
        panel.add(completeBtn);
        panel.add(deleteBtn);
        panel.add(showCompletedBtn);

        add(new JScrollPane(taskList), BorderLayout.CENTER);
        add(panel, BorderLayout.EAST);
        setVisible(true);
    }

    private void refreshList() {
        listModel.clear();
        for (Task t : manager.getTasks()) {
            listModel.addElement(t);
        }
    }

    private void addTask() {
        String title = JOptionPane.showInputDialog(this, "Title:");
        if (title == null || title.isBlank()) return;

        String desc = JOptionPane.showInputDialog(this, "Description:");
        if (desc == null) return;

        manager.addTask(new Task(title, desc));
        refreshList();
    }

    private void editTask() {
        int i = taskList.getSelectedIndex();
        if (i < 0) return;

        Task t = manager.getTasks().get(i);

        String title = JOptionPane.showInputDialog(this, "New title:", t.getTitle());
        if (title == null || title.isBlank()) return;

        String desc = JOptionPane.showInputDialog(this, "New description:", t.getDescription());
        if (desc == null) return;

        manager.updateTask(i, title, desc);
        refreshList();
    }

    private void completeTask() {
        int i = taskList.getSelectedIndex();
        if (i < 0) return;

        manager.markCompleted(i);
        refreshList();
    }

    private void deleteTask() {
        int i = taskList.getSelectedIndex();
        if (i < 0) return;

        manager.deleteTask(i);
        refreshList();
    }

    private void showCompleted() {
        java.util.ArrayList<Task> done = manager.getCompletedTasks();
        if (done.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No completed tasks yet.");
            return;
        }

        StringBuilder sb = new StringBuilder("Completed Tasks:\n\n");
        for (Task t : done) {
            sb.append(t.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(this, sb.toString());
    }
}
