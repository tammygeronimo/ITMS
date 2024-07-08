package javaProj;
import java.awt.*;
import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class categoryForm extends JFrame {

    // components
    JLabel cCodeLabel = new JLabel("Category Code:");
    JLabel cNameLabel = new JLabel("Category Name:");

    JTextField cCodeField = new JTextField();
    JTextField cNameField = new JTextField();

    JButton addButton = new JButton("Add");
    JButton backButton = new JButton("Back");

    public categoryForm() {

        setTitle("Product Information : Category");
        setSize(300, 190);
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

        cCodeLabel.setBounds(10, 20, 115, 25);
        cCodeLabel.setFont(new Font("Poppins", Font.PLAIN, 13));
        cCodeLabel.setForeground(Color.decode("#31C198"));
        cCodeField.setBounds(120, 20, 150, 25);
        add(cCodeLabel); add(cCodeField);

        cNameLabel.setBounds(10, 60, 115, 25);
        cNameLabel.setFont(new Font("Poppins", Font.PLAIN, 13));
        cNameLabel.setForeground(Color.decode("#31C198"));
        cNameField.setBounds(120, 60, 150, 25);
        add(cNameLabel); add(cNameField);

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
                String categoryCode = cCodeField.getText();
                String categoryName = cNameField.getText();
                addCategoryToFile(categoryCode, categoryName);
                JOptionPane.showMessageDialog(null,  "Category successfully added.", "Recorded!",
                        JOptionPane.INFORMATION_MESSAGE);
                cCodeField.setText("");
                cNameField.setText("");
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

    // Writing to "Category.txt"
    private void addCategoryToFile(String categoryCode, String categoryName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Category.txt", true))) {
            writer.write(categoryCode + "\t" + categoryName);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}