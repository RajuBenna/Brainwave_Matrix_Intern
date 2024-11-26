import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AppointmentPage {
    public void showAppointmentPage() {
        // Create JFrame for Appointment Page
        JFrame appointmentFrame = new JFrame("Appointment Page");
        appointmentFrame.setSize(500, 500);
        appointmentFrame.setResizable(false);
        appointmentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        appointmentFrame.setLayout(new BorderLayout(10, 10));

        // Title Label
        JLabel titleLabel = new JLabel("Schedule an Appointment", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        appointmentFrame.add(titleLabel, BorderLayout.NORTH);

        // Appointment Form Panel
        JPanel formPanel = new JPanel(new GridBagLayout());
        appointmentFrame.add(formPanel, BorderLayout.CENTER);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Name Label and Field
        JLabel nameLabel = new JLabel("Name:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        formPanel.add(nameLabel, gbc);

        JTextField nameField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        formPanel.add(nameField, gbc);

        // Doctor Label and Field
        JLabel doctorLabel = new JLabel("Doctor:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        formPanel.add(doctorLabel, gbc);

        JTextField doctorField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        formPanel.add(doctorField, gbc);

        // Appointment Date Label and Field
        JLabel dateLabel = new JLabel("Date (yyyy-mm-dd):");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        formPanel.add(dateLabel, gbc);

        JTextField dateField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        formPanel.add(dateField, gbc);

        // Appointment Time Label and Field
        JLabel timeLabel = new JLabel("Time (HH:mm):");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        formPanel.add(timeLabel, gbc);

        JTextField timeField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        formPanel.add(timeField, gbc);

        // Submit Button
        JButton submitButton = new JButton("Submit");
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(submitButton, gbc);

        // Back Button
        JButton backButton = new JButton("Back to Home");
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(backButton, gbc);

        // Action Listener for Back Button
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Close the Appointment Page
                appointmentFrame.dispose();

                // Create and show the Home Page again
                HomePage.Home(); // Assuming the HomePage method is static
            }
        });

        JLabel messageLabel = new JLabel("", SwingConstants.CENTER);
        appointmentFrame.add(messageLabel, BorderLayout.SOUTH);

        // Action Listener for Submit Button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String doctor = doctorField.getText();
                String date = dateField.getText();
                String time = timeField.getText();

                if (name.isEmpty() || doctor.isEmpty() || date.isEmpty() || time.isEmpty()) {
                    messageLabel.setText("Please fill all fields.");
                } else {
                    try {
                        // Database connection
                        Connection connection = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/hospital", // Replace with your database URL
                                "root", // Replace with your database username
                                "MySqlPass8"  // Replace with your database password
                        );

                        // Insert data into the table
                        String sql = "INSERT INTO appointment (Name, Doctor, Date, Time) VALUES (?, ?, ?, ?)";
                        PreparedStatement preparedStatement = connection.prepareStatement(sql);
                        preparedStatement.setString(1, name);
                        preparedStatement.setString(2, doctor);
                        preparedStatement.setString(3, date);
                        preparedStatement.setString(4, time);

                        int rowsInserted = preparedStatement.executeUpdate();
                        if (rowsInserted > 0) {
                            messageLabel.setText("Appointment scheduled successfully!");
                        } else {
                            messageLabel.setText("Failed to schedule appointment.");
                        }

                        // Close the connection
                        preparedStatement.close();
                        connection.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        messageLabel.setText("Error: Could not schedule appointment.");
                    }
                }
            }
        });

        appointmentFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new AppointmentPage().showAppointmentPage();
    }
}
