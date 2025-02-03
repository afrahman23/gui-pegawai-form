package org.employment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class MainFrame extends JFrame {
    private JTextField nameField;
    private JTextField departmentField;
    private JTextField salaryField;
    private JTextField hourlyRateField;
    private JTextArea displayArea;

    public MainFrame() {
        setTitle("Employment System");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField(20);

        JLabel departmentLabel = new JLabel("Department:");
        departmentField = new JTextField(20);

        JLabel salaryLabel = new JLabel("Salary (for Full-Time):");
        salaryField = new JTextField(20);

        JLabel hourlyRateLabel = new JLabel("Hourly Rate (for Part-Time):");
        hourlyRateField = new JTextField(20);

        JButton addButton = new JButton("Add Employee");
        JButton displayButton = new JButton("Display Employees");

        displayArea = new JTextArea(10, 30);
        displayArea.setEditable(false);

        add(nameLabel);
        add(nameField);
        add(departmentLabel);
        add(departmentField);
        add(salaryLabel);
        add(salaryField);
        add(hourlyRateLabel);
        add(hourlyRateField);
        add(addButton);
        add(displayButton);
        add(new JScrollPane(displayArea));

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEmployee();
            }
        });

        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayEmployees();
            }
        });
    }

    private void addEmployee() {
        String name = nameField.getText();
        String department = departmentField.getText();
        String salaryText = salaryField.getText();
        String hourlyRateText = hourlyRateField.getText();

        try {
            if (!salaryText.isEmpty()) {
                double salary = Double.parseDouble(salaryText);
                FullTimeEmployee fullTimeEmployee = new FullTimeEmployee(name, department, salary);
                DatabaseConnection.addEmployee(fullTimeEmployee);
                displayArea.append(fullTimeEmployee.getName() + " added as Full-Time Employee\n");
            } else if (!hourlyRateText.isEmpty()) {
                double hourlyRate = Double.parseDouble(hourlyRateText);
                PartTimeEmployee partTimeEmployee = new PartTimeEmployee(name, department, hourlyRate);
                DatabaseConnection.addEmployee(partTimeEmployee);
                displayArea.append(partTimeEmployee.getName() + " added as Part-Time Employee\n");
            } else {
                displayArea.append("Please enter either Salary or Hourly Rate\n");
            }
        } catch (SQLException ex) {
            displayArea.append("Error: " + ex.getMessage() + "\n");
        }
    }

    private void displayEmployees() {
        // In a real application, you would fetch and display the list of employees from the database
        displayArea.append("Displaying all employees...\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
}