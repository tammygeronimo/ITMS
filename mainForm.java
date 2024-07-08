package javaProj;
import java.awt.*;
import javax.swing.*;
import java.util.List;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;

@SuppressWarnings("serial")
public class mainForm extends JFrame {
    private List<String[]> deliveryData;
    private List<String[]> salesData;

    public mainForm() {

        setTitle("Home");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

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

        // Menu Bar
        JMenuBar bar = new JMenuBar();
        bar.setOpaque(true);
        bar.setBackground(Color.decode("#31C198"));
        bar.setFont(new Font("Poppins", Font.PLAIN, 13));

        // Menu/SubMenu
        JMenu fileMenu = createColoredMenu("File", Color.decode("#1E1E1F"));
        JMenu prodSubMenu = new JMenu("Product Information");
        JMenu transMenu = createColoredMenu("Transaction", Color.decode("#1E1E1F"));
        JMenu repMenu = createColoredMenu("Report", Color.decode("#1E1E1F"));
        JMenu aboutMenu = createColoredMenu("About", Color.decode("#1E1E1F"));

        // Menu Items
        JMenuItem catItem = new JMenuItem("Category");
        JMenuItem packItem = new JMenuItem("Packaging");
        JMenuItem varItem = new JMenuItem("Variant");
        JMenuItem prodItem = new JMenuItem("Product");
        JMenuItem suppItem = new JMenuItem("Supplier Information");
        JMenuItem exitItem = new JMenuItem("Exit");
        JMenuItem delItem = new JMenuItem("Delivery");
        JMenuItem orderItem = new JMenuItem("Order");
        JMenuItem repProdItem = new JMenuItem("Product");
        JMenuItem repSalesItem = new JMenuItem("Sales");
        JMenuItem sysItem = new JMenuItem("System");
        JMenuItem authorsItem = new JMenuItem("Authors");

        prodSubMenu.add(catItem);
        prodSubMenu.add(packItem);
        prodSubMenu.add(varItem);
        prodSubMenu.add(prodItem);

        fileMenu.add(prodSubMenu);
        fileMenu.add(suppItem);
        fileMenu.add(exitItem);

        transMenu.add(delItem);
        transMenu.add(orderItem);

        repMenu.add(repProdItem);
        repMenu.add(repSalesItem);

        aboutMenu.add(sysItem);
        aboutMenu.add(authorsItem);

        bar.add(fileMenu);
        bar.add(transMenu);
        bar.add(repMenu);
        bar.add(aboutMenu);
        setJMenuBar(bar);

        // JTextArea & JScrollPane
        JTextArea textArea = new JTextArea(28, 75);
        JLabel def_label = new JLabel("[ Display reports here via the Report Menu ]");
        def_label.setBounds(255, 220, 300, 15);
        def_label.setFont(new Font("Poppins", Font.ITALIC, 11));
        def_label.setForeground(Color.GRAY);
        textArea.add(def_label);
        textArea.setBackground(Color.decode("#323232"));
        textArea.setEnabled(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel outerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        outerPanel.setBorder(BorderFactory.createEmptyBorder(50, 20, 20, 20));
        outerPanel.add(centerPanel);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(outerPanel, BorderLayout.CENTER);

        // ACTION LISTENERS
        catItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new categoryForm();
            }
        });

        packItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new packagingForm();
            }
        });

        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show the confirmation dialog
                int result = JOptionPane.showConfirmDialog(
                        mainForm.this, "Do you want to exit the iTMS?", "Exit",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                if (result == JOptionPane.YES_OPTION) {
                    dispose();
                }
            }
        });

        prodItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new productFrame();
            }
        });

        delItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new deliveryForm();
            }
        });

        varItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new variantForm();
            }
        });

        orderItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new OrderForm();
            }
        });

        suppItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new supplierForm();
            }
        });

        sysItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new systemClass();
            }
        });

        authorsItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new authorClass();
            }
        });

        repSalesItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deliveryData = loadDataFromDelivery("C:\\Users\\Tamara\\Documents\\2324 - 2nd Semester\\E) Java - Eclipse Workspace\\javaProj\\Delivery.txt");
                salesData = loadDataFromDelivery("C:\\Users\\Tamara\\Documents\\2324 - 2nd Semester\\E) Java - Eclipse Workspace\\javaProj\\Sales.txt");
                StringBuilder salesInfo = new StringBuilder();
                Float totalSales = (float) 0;

                def_label.setText("");
                salesInfo.append("\tDate\t\t\tCustomer Name\t\tTotal Price\n");
                salesInfo.append("-------------------------------------------------------------------------------------------------------------------------------------------------------------\n");

                try(BufferedReader br = new BufferedReader(new FileReader("Sales.txt"))) {
                    String line;
                    while ((line = br.readLine()) != null) {

                        String[] salesRep = line.split("\t");

                        if (salesRep.length >= 2) {
                            String saleDate = salesRep[0];
                            String customerName = salesRep[1];
                            Float amount = Float.valueOf(salesRep[2]);

                            salesInfo.append("\t");
                            salesInfo.append(saleDate).append("\t\t");
                            salesInfo.append(customerName).append("\t\t\t");
                            salesInfo.append(amount).append("\n");
                            totalSales += amount;

                        }
                    }
                } catch (IOException ea){
                    ea.printStackTrace();
                }

                salesInfo.append("\n\n");
                salesInfo.append("Computed Accumulated Total Sales: ").append(totalSales);

                textArea.setText(salesInfo.toString());
                textArea.setEnabled(true);
                textArea.setEditable(false);
            }
        });

        repProdItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder productInfo = new StringBuilder();

                def_label.setText("");
                productInfo.append("Product Code\t\tProduct Name\t\tPackage Code & Name\tVariant Code & Name\tAvailable Quantity\n");
                productInfo.append("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");

                try(BufferedReader br = new BufferedReader(new FileReader("Delivery.txt")))
                {
                    String line;
                    while ((line = br.readLine()) != null){

                        String[] prodRep = line.split("\t");

                        if (prodRep.length >= 2){
                            String productCode = prodRep[2];
                            String productName = prodRep[3];
                            String packageCode = prodRep[4];
                            String packageName = prodRep[5];
                            String variantCode = prodRep[6];
                            String variantName = prodRep[7];
                            String availableQuantity = prodRep[8];

                            productInfo.append(productCode).append("\t\t");
                            productInfo.append(productName).append("\t\t");
                            productInfo.append(packageCode).append(", ");
                            productInfo.append(packageName).append("\t\t");
                            productInfo.append(variantCode).append(", ");
                            productInfo.append(variantName).append("\t\t");
                            productInfo.append(availableQuantity).append("\n");
                        }
                    }

                } catch (IOException ea){
                    ea.printStackTrace();
                }

                textArea.setText(productInfo.toString());
                textArea.setEnabled(true);
                textArea.setEditable(false);
            }
        });

        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        FlatMacDarkLaf.setup();

        SplashScreen splash = new SplashScreen();
        splash.setVisible(true);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        splash.dispose();

        SwingUtilities.invokeLater(() -> new mainForm());
    }

    private JMenu createColoredMenu(String title, Color bgColor) {
        JMenu menu = new JMenu(title);
        menu.setOpaque(true);
        menu.setBackground(bgColor);
        return menu;
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
}

@SuppressWarnings("serial")
class SplashScreen extends JWindow {
    public SplashScreen() {
    
        setSize(700, 700);

        setLocationRelativeTo(null);

        JPanel content = new JPanel(new BorderLayout());
        content.setBackground(Color.BLACK);

        // Load the image
        String imagePath = "C:\\Users\\Tamara\\Downloads\\finalProj-master\\finalProj-master\\media\\Loading-Cover.jpg";
        ImageIcon imageIcon = new ImageIcon(imagePath);
        JLabel imageLabel = new JLabel(imageIcon, SwingConstants.CENTER);

        content.add(imageLabel, BorderLayout.CENTER);

        add(content);
    }
}
