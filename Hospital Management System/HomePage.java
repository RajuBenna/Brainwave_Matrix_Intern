import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage {
    public static void Home() {
        // Create the main frame
        JFrame frame = new JFrame("Main Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(500, 500);
        frame.setLayout(new GridLayout(4, 1, 10, 10)); // Arrange buttons vertically with spacing

        // Create buttons
        JButton appointmentButton = new JButton("Appointment Page");
        appointmentButton.setBounds(100, 50, 200, 40); // x, y, width, height

        JButton inventoryButton = new JButton("Inventory Page");
        inventoryButton.setBounds(100, 100, 200, 40);

        JButton billingButton = new JButton("Billing Page");
        billingButton.setBounds(100, 150, 200, 40);

        JButton patientButton = new JButton("Patient Page");
        patientButton.setBounds(100, 200, 200, 40);
        // Add action listeners to buttons
        appointmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Close the current frame
                frame.dispose();

                // Create and show the AppointmentPage
                AppointmentPage appointmentPage = new AppointmentPage();
                appointmentPage.showAppointmentPage();
            }
        });


        inventoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Navigating to Inventory...");
                // Replace with code to open Inventory
                // new Inventory().setVisible(true);
            }
        });

        billingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Navigating to Billing...");
                // Replace with code to open Billing
                // new Billing().setVisible(true);
            }
        });

        patientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Navigating to Patient...");
                // Replace with code to open Patient
                // new Patient().setVisible(true);
            }
        });

        // Add buttons to the frame
        frame.add(appointmentButton);
        frame.add(inventoryButton);
        frame.add(billingButton);
        frame.add(patientButton);

        // Set frame visibility
        frame.setVisible(true);
    }
}
