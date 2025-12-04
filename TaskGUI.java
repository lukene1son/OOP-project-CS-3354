package todo;

import javax.swing.*;
import java.awt.*;

public class TaskGUI extends JFrame {

    private JButton addButton;
    private JButton editButton;
    private JButton deleteButton;
    private JButton completeButton;
    private JButton viewCompletedButton;

    public TaskGUI() {
        setTitle("To-Do List");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Create buttons (but no logic yet)
        addButton = new JButton("Add Task");
        editButton = new JButton("Edit Task");
        deleteButton = new JButton("Delete Task");
        completeButton = new JButton("Mark Completed");
        viewCompletedButton = new JButton("View Completed Tasks");

        // Layout panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));

        panel.add(addButton);
        panel.add(editButton);
        panel.add(deleteButton);
        panel.add(completeButton);
        panel.add(viewCompletedButton);

        add(panel, BorderLayout.EAST);

        // Placeholder center area
        add(new JLabel("Task List will go here"), BorderLayout.CENTER);

        setVisible(true);
    }
}
