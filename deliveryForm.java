package javaProj;
import java.awt.Font;
import java.awt.Color;
import java.awt.Image;
import java.util.List;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
class deliveryForm extends JFrame {

    // components
    JLabel delHead = new JLabel("Delivery Form");
    JLabel sCodeLabel = new JLabel("Supplier Code:");
    JLabel sNameLabel = new JLabel("Supplier Name:");
    JLabel pCodeLabel = new JLabel("Product Code:");
    JLabel pNameLabel = new JLabel("Product Name:");
    JLabel prodLabel = new JLabel("Product");
    JLabel descLabel = new JLabel("Description:");
    JLabel quantityLabel = new JLabel("Quantity");
    JLabel delLabel = new JLabel("Delivered:");
    JLabel disLabel = new JLabel("Display");

    JComboBox cmbSupplier = new JComboBox();
    JComboBox cmbProduct = new JComboBox();

    JTextField sNameField = new JTextField();
    JTextField pNameField = new JTextField();
    JTextArea prodDescField = new JTextArea();
    JTextField quantityField = new JTextField();
    JTextArea textArea = new JTextArea();
    JScrollPane textAreaScrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    JScrollPane prodDescScrollPane = new JScrollPane(prodDescField, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

    JButton newButton = new JButton("New");
    JButton addButton = new JButton("Add");
    JButton backButton = new JButton("Back");

    private List<String[]> supplierData;
    private List<String[]> productData;
    private List<String> deliveryData = new ArrayList<>();
    

    public deliveryForm() {

        supplierData = loadDataFromFile("C:\\Users\\Tamara\\Documents\\2324 - 2nd Semester\\E) Java - Eclipse Workspace\\javaProj\\Supplier.txt");
        productData = loadDataFromFile("C:\\Users\\Tamara\\Documents\\2324 - 2nd Semester\\E) Java - Eclipse Workspace\\javaProj\\Product.txt");

        setTitle("Delivery");
        setSize(565,420);
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

        delHead.setBounds(185, 20, 500, 25);
        delHead.setFont(new Font("Poppins", Font.BOLD, 25));
        add(delHead);

        sCodeLabel.setBounds(28, 70, 100, 25);
        sCodeLabel.setFont(new Font("Poppins", Font.PLAIN, 13));
        sCodeLabel.setForeground(Color.decode("#31C198"));
        cmbSupplier.setBounds(130, 70, 137, 25);
        add(sCodeLabel); add(cmbSupplier);

        sNameLabel.setBounds(280, 70, 100, 25);
        sNameLabel.setFont(new Font("Poppins", Font.PLAIN, 13));
        sNameLabel.setForeground(Color.decode("#31C198"));
        sNameField.setBounds(383, 70, 137, 25);
        sNameField.setEnabled(false);
        add(sNameLabel); add(sNameField);

        pCodeLabel.setBounds(28, 110, 100, 25);
        pCodeLabel.setFont(new Font("Poppins", Font.PLAIN, 13));
        pCodeLabel.setForeground(Color.decode("#31C198"));
        cmbProduct.setBounds(130, 110, 137, 25);
        add(pCodeLabel); add(cmbProduct);

        pNameLabel.setBounds(280, 110, 97, 25);
        pNameLabel.setFont(new Font("Poppins", Font.PLAIN, 13));
        pNameLabel.setForeground(Color.decode("#31C198"));
        pNameField.setBounds(383, 110, 137, 25);
        pNameField.setEnabled(false);
        add(pNameLabel); add(pNameField);

        prodLabel.setBounds(28, 150, 86, 25);
        prodLabel.setFont(new Font("Poppins", Font.PLAIN, 13));
        prodLabel.setForeground(Color.decode("#31C198"));
        descLabel.setBounds(28, 165, 87, 25);
        descLabel.setFont(new Font("Poppins", Font.PLAIN, 13));
        descLabel.setForeground(Color.decode("#31C198"));
        prodDescField.setBounds(130, 150, 137, 60);
        prodDescField.setEnabled(false);
        prodDescScrollPane.setBounds(130, 150, 137, 60);
        add(prodLabel); add(descLabel); add(prodDescScrollPane);

        quantityLabel.setBounds(280, 150, 97, 25);
        quantityLabel.setFont(new Font("Poppins", Font.PLAIN, 13));
        quantityLabel.setForeground(Color.decode("#31C198"));
        delLabel.setBounds(280,165,97,25);
        delLabel.setFont(new Font("Poppins", Font.PLAIN, 13));
        delLabel.setForeground(Color.decode("#31C198"));
        quantityField.setBounds(383, 150, 86, 25);
        add(quantityLabel); add(delLabel); add(quantityField);

        disLabel.setBounds(28,215,488,33);
        disLabel.setFont(new Font("Poppins", Font.PLAIN, 13));
        disLabel.setForeground(Color.decode("#31C198"));
        textArea.setBounds(28, 243, 488, 70);
        textArea.setEnabled(false);
        textAreaScrollPane.setBounds(28, 243, 488, 70);
        add(disLabel); add(textAreaScrollPane);
        
        newButton.setBounds(45, 335, 89, 25);
        newButton.setBackground(Color.decode("#31C198"));
        newButton.setForeground(Color.decode("#1E1E1F"));
        newButton.setFont(new Font("Poppins", Font.BOLD,12));
        addButton.setBounds(224, 335, 89, 25);
        addButton.setBackground(Color.decode("#31C198"));
        addButton.setForeground(Color.decode("#1E1E1F"));
        addButton.setFont(new Font("Poppins", Font.BOLD,12));
        backButton.setBounds(413, 335, 89, 25);
        backButton.setBackground(Color.decode("#31C198"));
        backButton.setForeground(Color.decode("#1E1E1F"));
        backButton.setFont(new Font("Poppins", Font.PLAIN,12));
        add(newButton); add(addButton); add(backButton);

        // ACTION LISTENERS
        newButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                enableNewSupplierSelection();
                populateProductComboBox();
            }
        });

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addProductToDelivery();
            }
        });

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        cmbSupplier.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateSupplierName();
            }
        });

        cmbProduct.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateProductName();
                updateProductDescription();
            }
        });

        setResizable(false);
        setVisible(true);
    }

    private void enableNewSupplierSelection() {
        cmbSupplier.setEnabled(true);
        cmbSupplier.removeAllItems();
        if (supplierData != null) {
            for (String[] entry : supplierData) {
                cmbSupplier.addItem(entry[0]);
            }
        }
        cmbProduct.removeAllItems();
    }

    private void updateSupplierName() {
        String selectedCode = (String) cmbSupplier.getSelectedItem();
        for (String[] entry : supplierData) {
            if (entry[0].equals(selectedCode)) {
                sNameField.setText(entry[1]);
                break;
            }
        }
    }

    private void updateProductName() {
        String selectedCode = (String) cmbProduct.getSelectedItem();
        for (String[] entry : productData) {
            if (entry[6].equals(selectedCode)) {
                pNameField.setText(entry[7]);
                break;
            }
        }
    }

    private void updateProductDescription() {
        String selectedCode = (String) cmbProduct.getSelectedItem();
        for (String[] entry : productData) {
            if (entry[6].equals(selectedCode)) {
                prodDescField.setText(entry[2] + "\t" + entry[3] + "\t" + entry[4] + "\t" + entry[5]);
                break;
            }
        }
    }

    private void populateProductComboBox() {
        cmbProduct.removeAllItems();
        if (productData != null) {
            for (String[] entry : productData) {
                cmbProduct.addItem(entry[6]);
            }
        }
    }

    private void addProductToDelivery() {
        String supplierCode = (String) cmbSupplier.getSelectedItem();
        String supplierName = sNameField.getText();
        String productCode = (String) cmbProduct.getSelectedItem();
        String productName = pNameField.getText();
        String productDescription = prodDescField.getText();
        String quantity = quantityField.getText();

        if (supplierCode.isEmpty() || productCode.isEmpty() || quantity.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String deliveryInfo = supplierCode + "\t" + supplierName + "\t" + productCode + "\t" + productName + "\t" + productDescription + "\t" + quantity;
        //String deliveryWrite = supplierCode + "\t" + supplierName + "\t" + productCode + "\t" + productName + "\t" + productDescription + "\t" + quantity;


        deliveryData.add(deliveryInfo);
        updateTextArea();
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Delivery.txt", true))) {
            writer.write(deliveryInfo);
            writer.newLine();
            JOptionPane.showMessageDialog(this, "Product added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            clearFields();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving product data.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

        cmbSupplier.setEnabled(false);
     
    }
        

    private void updateTextArea() {
        textArea.setText("");
        for (String entry : deliveryData) {
            textArea.append(entry + "\n");
        }
    }

    private void clearFields() {
        cmbProduct.setSelectedItem(null);
        pNameField.setText("");
        prodDescField.setText("");
        quantityField.setText("");
    }

    private  List<String[]> loadDataFromFile(String fileName) {
        List<String[]> data = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\t");

                if (parts.length >= 2) {
                    data.add(parts);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error loading data from " + fileName, "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return data;
    }

}
