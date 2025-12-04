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
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Create list model (empty for now—no logic yet)
        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);

        // Create buttons (still no actions wired yet)
        JButton addButton = new JButton("Add Task");
        JButton editButton = new JButton("Edit Task");
        JButton deleteButton = new JButton("Delete Task");
        JButton completeButton = new JButton("Mark Completed");
        JButton viewCompletedButton = new JButton("View Completed");

        // Right-panel layout
        JPanel panel = new JPanel(new GridLayout(5, 1));
        panel.add(addButton);
        panel.add(editButton);
        panel.add(deleteButton);
        panel.add(completeButton);
        panel.add(viewCompletedButton);

        // Add components
        add(new JScrollPane(taskList), BorderLayout.CENTER);
        add(panel, BorderLayout.EAST);

        setVisible(true);
    }
}
