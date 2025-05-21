import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TaskManagerApp {
    private static List<String> tasks = new ArrayList<>();
    private static List<String> reminders = new ArrayList<>();
    
    // Function to add a task
    public static void addTask(String task, String reminder) {
        tasks.add(task);
        reminders.add(reminder);
    }

    // Function to display tasks and reminders
    public static void displayTasks() {
        System.out.println("Tasks for today:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i) + " - Reminder: " + reminders.get(i));
        }
    }

    public static void main(String[] args) {
        // Create a basic Swing UI
        JFrame frame = new JFrame("Task Manager App");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container container = frame.getContentPane();
        container.setLayout(new FlowLayout());

        // UI components
        JLabel taskLabel = new JLabel("Enter task:");
        JTextField taskField = new JTextField(20);
        JLabel reminderLabel = new JLabel("Enter reminder (ringing, notification, SMS, email):");
        JTextField reminderField = new JTextField(20);
        JButton addButton = new JButton("Add Task");

        // Button click event
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String task = taskField.getText();
                String reminder = reminderField.getText();
                addTask(task, reminder);
                taskField.setText("");
                reminderField.setText("");
                JOptionPane.showMessageDialog(frame, "Task Added!");
            }
        });

        JButton showButton = new JButton("Show Tasks");

        // Show all tasks
        showButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayTasks();
            }
        });

        // Add components to the container
        container.add(taskLabel);
        container.add(taskField);
        container.add(reminderLabel);
        container.add(reminderField);
        container.add(addButton);
        container.add(showButton);
        
        // Set the frame visible
        frame.setVisible(true);
    }
}




import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TaskManagerGUI {
    private JFrame frame;
    private Container container;
    private JLabel taskLabel, reminderLabel;
    private JTextField taskField, reminderField;
    private JButton addButton, showButton;

    public TaskManagerGUI() {
        frame = new JFrame("Task Manager App");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container = frame.getContentPane();
        container.setLayout(new FlowLayout());

        taskLabel = new JLabel("Enter task:");
        taskField = new JTextField(20);
        reminderLabel = new JLabel("Enter reminder (ringing, notification, SMS, email):");
        reminderField = new JTextField(20);
        addButton = new JButton("Add Task");
        showButton = new JButton("Show Tasks");

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String task = taskField.getText();
                String reminder = reminderField.getText();
                TaskManagerApp.addTask(task, reminder);  // Use the backend method to add tasks
                taskField.setText("");
                reminderField.setText("");
                JOptionPane.showMessageDialog(frame, "Task Added!");
            }
        });

        showButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TaskManagerApp.displayTasks();  // Display the tasks
            }
        });

        // Add components to container
        container.add(taskLabel);
        container.add(taskField);
        container.add(reminderLabel);
        container.add(reminderField);
        container.add(addButton);
        container.add(showButton);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new TaskManagerGUI();
    }
}
