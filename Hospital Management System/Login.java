import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login{
    public static void main(String[] args) {
        // Create JFrame
        JFrame frame = new JFrame("Login Page");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        // Set BorderLayout for the frame
        frame.setLayout(new BorderLayout(10, 10));

        // Add a title to the NORTH region
        JLabel titleLabel = new JLabel("Welcome to Login Page", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(titleLabel, BorderLayout.NORTH);

        // Create JPanel for CENTER region
        JPanel centerPanel = new JPanel(new GridBagLayout());
        frame.add(centerPanel, BorderLayout.CENTER);

        // Configure Layout for center panel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // User ID Label
        JLabel userLabel = new JLabel("User ID:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        centerPanel.add(userLabel, gbc);

        // User ID Text Field
        JTextField userText = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        centerPanel.add(userText, gbc);

        // Password Label
        JLabel passwordLabel = new JLabel("Password:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        centerPanel.add(passwordLabel, gbc);

        // Password Field
        JPasswordField passwordText = new JPasswordField(15);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        centerPanel.add(passwordText, gbc);

        // Login Button
        JButton loginButton = new JButton("Login");
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        centerPanel.add(loginButton, gbc);

        // Message Label
        JLabel messageLabel = new JLabel("", SwingConstants.CENTER);
        frame.add(messageLabel, BorderLayout.SOUTH);

        // Add Action Listener to Login Button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userID = userText.getText();
                String password = new String(passwordText.getPassword());

                // Hardcoded credentials for demonstration
                if (userID.equals("admin") && password.equals("password")) {
                    frame.dispose(); // Close login page
                    HomePage(); // Open appointment page
                } else {
                    messageLabel.setText("Invalid credentials. Try again.");
                }
            }

        });

        // Make the frame visible
        frame.setVisible(true);
    }
    public static void HomePage() {
        // Create an instance of AppointmentPage class and open the appointment page
        HomePage home = new HomePage();
        home.Home();
    }
}
