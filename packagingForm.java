package javaProj;
import java.awt.*;
import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class packagingForm extends JFrame {

    // components
    JLabel pCodeLabel = new JLabel("Package Code:");
    JLabel pNameLabel = new JLabel("Package Name:");

    JTextField pCodeField = new JTextField();
    JTextField pNameField = new JTextField();

    JButton addButton = new JButton("Add");
    JButton backButton = new JButton("Back");

    public packagingForm() {

        setTitle("Product Information : Packaging");
        setSize(305, 190);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Window Icon
        String imagePath = "C:\\Users\\Tamara\\Downloads\\finalProj-master\\finalProj-master\\media\\Logo-Final.png";
        try {
            ImageIcon logoIcon = new ImageIcon(imagePath);
            Image logoImage = logoIcon.getImage();
            setIconImage(logoImage);
        } catch (Exception e) {
            System.err.println("Error loading image: " + e.getMessage());
            e.printStackTrace();
        }

        pCodeLabel.setBounds(10, 20, 100, 25);
        pCodeLabel.setFont(new Font("Poppins", Font.PLAIN, 13));
        pCodeLabel.setForeground(Color.decode("#31C198"));
        pCodeField.setBounds(120, 20, 150, 25);
        add(pCodeLabel); add(pCodeField);

        pNameLabel.setBounds(10, 60, 105, 25);
        pNameLabel.setFont(new Font("Poppins", Font.PLAIN, 13));
        pNameLabel.setForeground(Color.decode("#31C198"));
        pNameField.setBounds(120, 60, 150, 25);
        add(pNameLabel); add(pNameField);

        addButton.setBounds(30, 110, 100, 25);
        addButton.setBackground(Color.decode("#31C198"));
        addButton.setForeground(Color.decode("#1E1E1F"));
        addButton.setFont(new Font("Poppins", Font.BOLD,12));
        backButton.setBounds(150, 110, 100, 25);
        backButton.setBackground(Color.decode("#31C198"));
        backButton.setForeground(Color.decode("#1E1E1F"));
        backButton.setFont(new Font("Poppins", Font.PLAIN,12));
        add(addButton); add(backButton);

        // ACTION LISTENERS
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String packageCode = pCodeField.getText();
                String packageName = pNameField.getText();
                addPackageToFile(packageCode, packageName);
                JOptionPane.showMessageDialog(null,  "Package successfully added.", "Recorded!",
                        JOptionPane.INFORMATION_MESSAGE);
                pCodeField.setText("");
                pNameField.setText("");
            }
        });

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setResizable(false);
        setVisible(true);
    }

    // Writing to "Package.txt"
    private void addPackageToFile(String packageCode, String packageName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Package.txt", true))) {
            writer.write(packageCode + "\t" + packageName);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}