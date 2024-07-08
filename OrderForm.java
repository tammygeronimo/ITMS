package javaProj;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SuppressWarnings("serial")
class OrderForm extends JFrame{

    // components
    JLabel orderHead = new JLabel("Order Form");
    JLabel nameLabel = new JLabel("Customer Name:");
    JLabel pNameLabel = new JLabel("Product Name:");
    JLabel qtyLabel = new JLabel("Available Quantity:");
    JLabel qtyOrderLabel = new JLabel("Quantity Order:");
    JLabel priceLabel = new JLabel("Price:");
    JLabel totalLabel = new JLabel("Total Amount:");
    JLabel cashLabel = new JLabel("Cash Tender:");
    JLabel disLabel = new JLabel("Display");

    JTextField nameField = new JTextField(10);
    JTextField qtyField = new JTextField(10);
    JTextField qtyOrderField = new JTextField(10);
    JTextField priceField = new JTextField(10);
    JTextField totalField = new JTextField(10);
    JTextField cashField = new JTextField(10);
    JTextField changeField = new JTextField(10);
    JTextArea textArea = new JTextArea();
    JScrollPane textAreaScrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

    JComboBox cmbProduct = new JComboBox();

    JButton changeButton = new JButton("Change:");
    JButton newButton = new JButton("New");
    JButton addButton = new JButton("Add");
    JButton computeButton = new JButton("Compute");
    JButton backButton = new JButton("Back");

    private List<String[]> deliveryData;
    private List<String[]> productData;
    private List<String> orderData = new ArrayList<>();

    private float change=0;
    private float total;

    LocalDateTime currentTime = LocalDateTime.now();
    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    String writeTime = currentTime.format(timeFormatter);

    Float availableQty;

    public OrderForm() {

        deliveryData = loadDataFromDelivery("C:\\Users\\Tamara\\Documents\\2324 - 2nd Semester\\E) Java - Eclipse Workspace\\javaProj\\Delivery.txt");
        productData = loadDataFromProduct("C:\\Users\\Tamara\\Documents\\2324 - 2nd Semester\\E) Java - Eclipse Workspace\\javaProj\\Product.txt");

        setTitle("Order");
        setSize(550, 480);
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

        orderHead.setBounds(190, 20, 500, 25);
        orderHead.setFont(new Font("Poppins", Font.BOLD, 25));
        add(orderHead);

        nameLabel.setBounds(35, 60, 110, 25);
        nameLabel.setFont(new Font("Poppins", Font.PLAIN, 13));
        nameLabel.setForeground(Color.decode("#31C198"));
        nameField.setBounds(150, 60, 345, 25);
        nameField.setEditable(false);
        add(nameLabel); add(nameField);

        pNameLabel.setBounds(35, 92, 100, 25);
        pNameLabel.setFont(new Font("Poppins", Font.PLAIN, 13));
        pNameLabel.setForeground(Color.decode("#31C198"));
        cmbProduct.setBounds(150, 92, 149, 25);
        add(pNameLabel); add(cmbProduct);

        qtyLabel.setBounds(307, 92, 130, 25);
        qtyLabel.setFont(new Font("Poppins", Font.PLAIN, 13));
        qtyLabel.setForeground(Color.decode("#31C198"));
        qtyField.setBounds(435, 92, 60, 25);
        qtyField.setEnabled(false);
        add(qtyLabel); add(qtyField);

        qtyOrderLabel.setBounds(35, 125, 100, 25);
        qtyOrderLabel.setFont(new Font("Poppins", Font.PLAIN, 13));
        qtyOrderLabel.setForeground(Color.decode("#31C198"));
        qtyOrderField.setBounds(150, 125, 149, 25);
        qtyOrderField.setEditable(false);
        add(qtyOrderLabel); add(qtyOrderField);

        priceLabel.setBounds(307, 125, 100, 25);
        priceLabel.setFont(new Font("Poppins", Font.PLAIN, 13));
        priceLabel.setForeground(Color.decode("#31C198"));
        priceField.setBounds(346, 125, 149, 25);
        priceField.setEnabled(false);
        add(priceLabel); add(priceField);

        totalLabel.setBounds(35, 158, 90, 25);
        totalLabel.setFont(new Font("Poppins", Font.PLAIN, 13));
        totalLabel.setForeground(Color.decode("#31C198"));
        totalField.setBounds(130, 158, 60, 25);
        totalField.setEnabled(false);
        add(totalLabel); add(totalField);

        cashLabel.setBounds(197, 158, 85, 25);
        cashLabel.setFont(new Font("Poppins", Font.PLAIN, 13));
        cashLabel.setForeground(Color.decode("#31C198"));
        cashField.setBounds(287, 158, 60, 25);
        cashField.setEditable(false);
        add(cashLabel); add(cashField);

        changeButton.setBounds(350, 158, 85, 25);
        changeButton.setBackground(Color.decode("#31C198"));
        changeButton.setForeground(Color.decode("#1E1E1F"));
        changeButton.setFont(new Font("Poppins", Font.BOLD,12));
        changeField.setBounds(437, 158, 55, 25);
        changeField.setEditable(false);
        add(changeButton); add(changeField);

        disLabel.setBounds(35,195,488,33);
        disLabel.setFont(new Font("Poppins", Font.PLAIN, 13));
        disLabel.setForeground(Color.decode("#31C198"));
        textArea.setBounds(35, 227, 458, 118);
        textArea.setEnabled(false);
        textAreaScrollPane.setBounds(35, 227, 458, 118);
        add(disLabel); add(textAreaScrollPane);

        newButton.setBounds(107, 363, 95, 25);
        newButton.setBackground(Color.decode("#31C198"));
        newButton.setForeground(Color.decode("#1E1E1F"));
        newButton.setFont(new Font("Poppins", Font.BOLD,12));
        addButton.setBounds(330, 363, 95, 25);
        addButton.setBackground(Color.decode("#31C198"));
        addButton.setForeground(Color.decode("#1E1E1F"));
        addButton.setFont(new Font("Poppins", Font.BOLD,12));
        computeButton.setBounds(107, 398, 95, 25);
        computeButton.setBackground(Color.decode("#31C198"));
        computeButton.setForeground(Color.decode("#1E1E1F"));
        computeButton.setFont(new Font("Poppins", Font.BOLD,12));
        backButton.setBounds(330, 398, 95, 25);
        backButton.setBackground(Color.decode("#31C198"));
        backButton.setForeground(Color.decode("#1E1E1F"));
        backButton.setFont(new Font("Poppins", Font.PLAIN,12));
        add(newButton); add(addButton); add(computeButton); add(backButton);

        // ACTION LISTENERS
        changeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                getChange();
            }
        });

        newButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                enableNewSupplierSelection();
                populateProductComboBox();
                enableFieldOnNew();

            }
        });

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addOrder();
                clearOnAdd();

            }
        });

        computeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                computeTotal();

            }
        });

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        cmbProduct.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateProductName();
            }
        });

        setResizable(false);
        setVisible(true);
    }

    private void enableNewSupplierSelection() {
        cmbProduct.setEnabled(true);
        cmbProduct.removeAllItems();
        if (deliveryData != null) {
            for (String[] entry : deliveryData) {
                cmbProduct.addItem(entry[0]);
            }
        }
        cmbProduct.removeAllItems();
    }

    private void updateProductName() {
        String selectedCode = (String) cmbProduct.getSelectedItem();
        for (String[] del : deliveryData) {
            if (del[3].equals(selectedCode)) {
                qtyField.setText(del[8]);
                availableQty = Float.parseFloat(qtyField.getText());

                for (String[] pro : productData) {
                    if (del[3].equals(pro[7])) {
                        priceField.setText(pro[8]);
                        break;
                    }
                }
                break;
            }
        }
    }

    private void getChange() {
        try {
            float cash = Float.parseFloat(cashField.getText());
            float total = Float.parseFloat(totalField.getText());
            if(total>cash) {
                JOptionPane.showMessageDialog(this, "Please Input the Exact Amount for Payment!", "Error", JOptionPane.ERROR_MESSAGE);
            }else {
                change = cash - total;
                changeField.setText(String.valueOf(change));
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "You need to Compute the Total amount & put the Cash Tendered first", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void computeTotal() {
        try {
            float qtyOrder = Float.parseFloat(qtyOrderField.getText());
            float availableQty = Float.parseFloat(qtyField.getText());
            float price = Float.parseFloat(priceField.getText());
            float cash = Float.parseFloat(cashField.getText());

            if (qtyOrder > availableQty) {
                JOptionPane.showMessageDialog(this, "Ordered quantity exceeds available quantity", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                float total = qtyOrder * price;

                if (cash >= total) {
                    totalField.setText(String.valueOf(total));
                    addToSalesFile(total);
                }
                else {
                    JOptionPane.showMessageDialog(this, "Please Input the Exact Amount for Payment!", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "You need to fill all the Fields", "Error", JOptionPane.ERROR_MESSAGE);
        }


        String selectedCode = (String) cmbProduct.getSelectedItem();

        Float updateQty;
        Float order = Float.parseFloat(qtyOrderField.getText());
        String lines;

        List<String> linesUpdate = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("Delivery.txt"))) {
            String line;

            while ((line = br.readLine()) != null){
                linesUpdate.add(line);
            }
        } catch (IOException e){
            e.printStackTrace();
        }


        for (int i = 0; i < linesUpdate.size(); i++){
            String line = linesUpdate.get(i);
            String[] parts = line.split("\t");

            if (parts[3].equals(selectedCode)){
                updateQty = availableQty - order;
                parts[8] = updateQty.toString();

                String updatedLine = String.join("\t", parts);
                linesUpdate.set(i, updatedLine);

                break;
            }
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Delivery.txt"))) {
            for (String line : linesUpdate) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        deliveryData = loadDataFromDelivery("C:\\Users\\Tamara\\Documents\\2324 - 2nd Semester\\E) Java - Eclipse Workspace\\javaProj\\Delivery.txt");
        productData = loadDataFromProduct("C:\\Users\\Tamara\\Documents\\2324 - 2nd Semester\\E) Java - Eclipse Workspace\\javaProj\\Product.txt"); 

    }

    private void populateProductComboBox() {
        cmbProduct.removeAllItems();
        if (deliveryData != null) {
            for (String[] entry : deliveryData) {
                cmbProduct.addItem(entry[3]);
            }
        }
    }

    private void addToSalesFile(float total) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Sales.txt", true))) {

            String customerName = nameField.getText();


            writer.write(writeTime + "\t" + customerName + "\t" + total);
            writer.newLine();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error writing to Sales.txt", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private List<String[]> loadDataFromDelivery(String fileName) {
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

    private void addOrder() {
        String productName = (String) cmbProduct.getSelectedItem();
        String price = priceField.getText();
        String quantityOrder = qtyOrderField.getText();

        if (productName != null && !price.isEmpty() && !quantityOrder.isEmpty()) {
            String orderInfo = "Product Name: " + productName + "\tPrice: " + price + "\tQuantity Order: " + quantityOrder;
            orderData.add(orderInfo);
            updateTextArea();
        } else {
            JOptionPane.showMessageDialog(this, "Please select a product and enter a valid quantity order", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateTextArea() {
        textArea.setText("");
        for (String order : orderData) {
            textArea.append(order + "\n");
        }
    }

    private List<String[]> loadDataFromProduct(String fileName) {
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

    private void clearOnAdd() {
        qtyOrderField.setText("");qtyOrderField.setEditable(false);
        totalField.setText("");
        cashField.setText("");cashField.setEditable(false);
        changeField.setText("");
        nameField.setText("");nameField.setEditable(false);
        cmbProduct.setSelectedItem(null);
        qtyField.setText("");
        priceField.setText("");
    }

    private void enableFieldOnNew() {
        qtyOrderField.setEditable(true);
        cashField.setEditable(true);
        nameField.setEditable(true);
    }

}