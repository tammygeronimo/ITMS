package javaProj;
import java.awt.*;
import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class variantForm extends JFrame {

    // components
    JLabel vCodeLabel = new JLabel("Variant Code:");
    JLabel vNameLabel = new JLabel("Variant Name:");

    JTextField vCodeField = new JTextField();
    JTextField vNameField = new JTextField();

    JButton addButton = new JButton("Add");
    JButton backButton = new JButton("Back");

    public variantForm() {
        setTitle("Product Information : Variant");
        setSize(295, 190);
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

        vCodeLabel.setBounds(10, 20, 100, 25);
        vCodeLabel.setFont(new Font("Poppins", Font.PLAIN, 13));
        vCodeLabel.setForeground(Color.decode("#31C198"));
        vCodeField.setBounds(120, 20, 150, 25);
        add(vCodeLabel); add(vCodeField);

        vNameLabel.setBounds(10, 60, 100, 25);
        vNameLabel.setFont(new Font("Poppins", Font.PLAIN, 13));
        vNameLabel.setForeground(Color.decode("#31C198"));
        vNameField.setBounds(120, 60, 150, 25);
        add(vNameLabel); add(vNameField);

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
                String variantCode = vCodeField.getText();
                String variantName = vNameField.getText();
                addVariantToFile(variantCode, variantName);
                JOptionPane.showMessageDialog(null,  "Variant successfully added.", "Recorded!",
                        JOptionPane.INFORMATION_MESSAGE);
                vCodeField.setText("");
                vNameField.setText("");
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

    // Writing to "Variant.txt"
    private void addVariantToFile(String variantCode, String variantName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Variant.txt", true))) {
            writer.write(variantCode + "\t" + variantName);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}