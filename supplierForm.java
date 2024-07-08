package javaProj;
import java.awt.*;
import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class supplierForm extends JFrame {

    // components
    JLabel sCodeLabel = new JLabel("Supplier Code:");
    JLabel sNameLabel = new JLabel("Supplier Name:");

    JTextField sCodeField = new JTextField();
    JTextField sNameField = new JTextField();

    JButton addButton = new JButton("Add");
    JButton backButton = new JButton("Back");

    public supplierForm() {
        setTitle("Supplier Information");
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

        sCodeLabel.setBounds(10, 20, 100, 25);
        sCodeLabel.setFont(new Font("Poppins", Font.PLAIN, 13));
        sCodeLabel.setForeground(Color.decode("#31C198"));
        sCodeField.setBounds(120, 20, 150, 25);
        add(sCodeLabel); add(sCodeField);

        sNameLabel.setBounds(10, 60, 100, 25);
        sNameLabel.setFont(new Font("Poppins", Font.PLAIN, 13));
        sNameLabel.setForeground(Color.decode("#31C198"));
        sNameField.setBounds(120, 60, 150, 25);
        add(sNameLabel); add(sNameField);

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
                String supplierCode = sCodeField.getText();
                String supplierName = sNameField.getText();
                addSupplierToFile(supplierCode, supplierName);
                JOptionPane.showMessageDialog(null,  "Supplier successfully added.", "Recorded!",
                        JOptionPane.INFORMATION_MESSAGE);
                sCodeField.setText("");
                sNameField.setText("");
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

    // Writing to "Supplier.txt"
    private void addSupplierToFile(String supplierCode, String supplierName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Supplier.txt", true))) {
            writer.write(supplierCode + "\t" + supplierName);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}