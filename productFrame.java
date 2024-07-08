package javaProj;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;

@SuppressWarnings("serial")
public class productFrame extends JFrame{

    // components
    JLabel categoryLabel = new JLabel("Category Code: ");
    JLabel packageLabel = new JLabel("Package Code: ");
    JLabel variantLabel = new JLabel("Variant Code: ");
    JLabel productCodeLabel = new JLabel("Product Code: ");
    JLabel priceLabel = new JLabel("Price: ");
    JLabel categoryNameLabel = new JLabel("Category Name: ");
    JLabel packageNameLabel = new JLabel("Package Name: ");
    JLabel variantNameLabel = new JLabel("Variant Name: ");
    JLabel productNameLabel = new JLabel("Product Name: ");

    private static String[] categList;
    static JComboBox<String> categoryComboBox;
    static JComboBox<String> packageBox;
    static JComboBox<String> variantBox;

    private static ArrayList<String> categoryCodes = new ArrayList<>();
    private static ArrayList<String> categoryNames = new ArrayList<>();
    private static ArrayList<String> packageCodes = new ArrayList<>();
    private static ArrayList<String> packageNames = new ArrayList<>();
    private static ArrayList<String> variantCodes = new ArrayList<>();
    private static ArrayList<String> variantNames = new ArrayList<>();

    JTextField productCodeField = new JTextField(11);
    JTextField CategoryNameField = new JTextField(20);
    JTextField packageField = new JTextField(20);
    JTextField variantField = new JTextField(20);
    JTextField productNameField = new JTextField(20);
    JTextField priceField = new JTextField(17);

    JButton addBtn = new JButton("Add");
    JButton backBtn = new JButton("Back");

    static File categoryFile = new File("Category.txt");
    static File packageFile = new File("Package.txt");
    static File variantFile = new File("Variant.txt");

    static String infoWrite;
    static String categoryInfo, packageInfo, variantInfo, productCode, productName;
    static String productPrice;

    productFrame() {

        setTitle("Product Form");
        setSize(685, 335);
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

        categoryComboBox = new JComboBox<>();
        packageBox = new JComboBox<>();
        variantBox = new JComboBox<>();

        infoLoads();

        JLabel titleHead = new JLabel("Product Form");
        titleHead.setFont(new Font("Poppins", Font.BOLD, 25));
        titleHead.setBounds(247, 5, 180, 30);
        add(titleHead);

        categoryLabel.setFont(new Font("Poppins", Font.PLAIN, 13));
        categoryLabel.setForeground(Color.decode("#31C198"));
        categoryLabel.setBounds(25, 60, 120, 25);
        add(categoryLabel);

        packageLabel.setFont(new Font("Poppins", Font.PLAIN, 13));
        packageLabel.setForeground(Color.decode("#31C198"));
        packageLabel.setBounds(25, 95, 120, 25);
        add(packageLabel);

        variantLabel.setFont(new Font("Poppins", Font.PLAIN, 13));
        variantLabel.setForeground(Color.decode("#31C198"));
        variantLabel.setBounds(25, 130, 120, 25);
        add(variantLabel);

        productCodeLabel.setFont(new Font("Poppins", Font.PLAIN, 13));
        productCodeLabel.setForeground(Color.decode("#31C198"));
        productCodeLabel.setBounds(25, 165, 120, 25);
        add(productCodeLabel);

        comboActions infoBox = new comboActions();
        categoryComboBox.addActionListener(infoBox);
        packageBox.addActionListener(infoBox);
        variantBox.addActionListener(infoBox);

        categoryComboBox.setBounds(144, 60, 150, 25);
        add(categoryComboBox);

        packageBox.setBounds(144, 95, 150, 25);
        add(packageBox);

        variantBox.setBounds(144, 130, 150, 25);
        add(variantBox);

        productCodeField.setBounds(144, 165, 150, 25);
        add(productCodeField);

        categoryNameLabel.setFont(new Font("Poppins", Font.PLAIN, 13));
        categoryNameLabel.setForeground(Color.decode("#31C198"));
        categoryNameLabel.setBounds(318, 60, 120, 25);
        add(categoryNameLabel);

        packageNameLabel.setFont(new Font("Poppins", Font.PLAIN, 13));
        packageNameLabel.setForeground(Color.decode("#31C198"));
        packageNameLabel.setBounds(318, 95, 120, 25);
        add(packageNameLabel);

        variantNameLabel.setFont(new Font("Poppins", Font.PLAIN, 13));
        variantNameLabel.setForeground(Color.decode("#31C198"));
        variantNameLabel.setBounds(318, 130, 120, 25);
        add(variantNameLabel);

        productNameLabel.setFont(new Font("Poppins", Font.PLAIN, 13));
        productNameLabel.setForeground(Color.decode("#31C198"));
        productNameLabel.setBounds(318, 165, 120, 25);
        add(productNameLabel);

        CategoryNameField.setBounds(445, 60, 200, 25);
        CategoryNameField.setEditable(false);
        CategoryNameField.setEnabled(false);
        add(CategoryNameField);

        packageField.setBounds(445, 95, 200, 25);
        packageField.setEditable(false);
        packageField.setEnabled(false);
        add(packageField);

        variantField.setBounds(445, 130, 200, 25);
        variantField.setEditable(false);
        variantField.setEnabled(false);
        add(variantField);

        productNameField.setBounds(445, 165, 200, 25);
        add(productNameField);

        priceLabel.setFont(new Font("Poppins", Font.PLAIN, 13));
        priceLabel.setForeground(Color.decode("#31C198"));
        priceLabel.setBounds(233, 200, 50, 25);
        add(priceLabel);

        priceField.setBounds(293, 200, 150, 25);
        add(priceField);

        buttonActions btnFunction = new buttonActions();
        addBtn.addActionListener(btnFunction);
        backBtn.addActionListener(btnFunction);

        addBtn.setBounds(216, 249, 100, 30);
        addBtn.setBackground(Color.decode("#31C198"));
        addBtn.setForeground(Color.decode("#1E1E1F"));
        addBtn.setFont(new Font("Poppins", Font.BOLD, 12));
        add(addBtn);

        backBtn.setBounds(355, 249, 100, 30);
        backBtn.setBackground(Color.decode("#31C198"));
        backBtn.setForeground(Color.decode("#1E1E1F"));
        backBtn.setFont(new Font("Poppins", Font.PLAIN,12));
        add(backBtn);

        setResizable(false);
        setVisible(true);
    }

    public class buttonActions extends Component implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            if(e.getSource() == addBtn){

                String catCode = (String) categoryComboBox.getSelectedItem();
                String pBox = (String) packageBox.getSelectedItem();
                String vBox = (String) variantBox.getSelectedItem();

                productName = productNameField.getText();
                productCode = productCodeField.getText();
                productPrice = priceField.getText();

                if (productName.isEmpty() || productCode.isEmpty() || productPrice.isEmpty() || catCode.isEmpty()
                        || pBox.isEmpty() || vBox.isEmpty()){
                    JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                infoWrite = categoryInfo + "\t" + packageInfo + "\t" + variantInfo + "\t" + productCode + "\t" + productName + "\t" + productPrice;
                //infoWrite = "\t" + productCode + "\t" + productName + "\t" + productPrice;

                System.out.println(infoWrite);

                JOptionPane.showMessageDialog(null,  "Product successfully added.", "Recorded!",
                        JOptionPane.INFORMATION_MESSAGE);

                try (BufferedWriter writer = new BufferedWriter(new FileWriter("Product.txt", true))) {
                    writer.write(infoWrite);
                    writer.newLine();

                } catch (IOException ae) {
                    ae.printStackTrace();
                }

                categoryComboBox.setSelectedIndex(0);
                CategoryNameField.setText("");
                packageBox.setSelectedIndex(0);
                packageField.setText("");
                variantBox.setSelectedIndex(0);
                variantField.setText("");
                productCodeField.setText("");
                productNameField.setText("");
                priceField.setText("");

            } else {
                dispose();

            }

        }
    }

    public class comboActions implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == categoryComboBox){
                int categoryIndex = categoryComboBox.getSelectedIndex();

                if(categoryIndex != -1){

                    String catCode = (String) categoryComboBox.getSelectedItem();
                    String catName = categoryNames.get(categoryIndex);
                    CategoryNameField.setText(catName);

                    categoryInfo = catCode + "\t" + catName;

                }

            } else if (e.getSource() == packageBox) {
                int packageIndex = packageBox.getSelectedIndex();

                if (packageIndex != -1) {

                    String packCode = (String) packageBox.getSelectedItem();
                    String packName = packageNames.get(packageIndex);
                    packageField.setText(packName);

                    packageInfo = packCode + "\t" + packName;
                }

            } else if (e.getSource() == variantBox) {
                int variantIndex = variantBox.getSelectedIndex();

                if(variantIndex != -1){

                    String varCode = (String) variantBox.getSelectedItem();
                    String varName = variantNames.get(variantIndex);
                    variantField.setText(varName);

                    variantInfo = varCode + "\t" + varName;
                }
            }

        }
    }

    public static void infoLoads() {
        try(BufferedReader br = new BufferedReader(new FileReader(categoryFile))){
            String line;
            while((line = br.readLine()) != null) {
                String[] categoryBox = line.split("\t");

                if (categoryBox.length >= 2) {
                    String CategoryCode = categoryBox[0];
                    String CategoryName = categoryBox[1];

                    categoryCodes.add(CategoryCode);
                    categoryNames.add(CategoryName);
                    categoryComboBox.addItem(CategoryCode);
                }
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }

        try(BufferedReader br = new BufferedReader((new FileReader(packageFile)))){
            String line;
            while ((line = br.readLine()) != null){
                String[] packBox = line.split("\t");

                if (packBox.length >= 2){
                    String packCode = packBox[0];
                    String packName = packBox[1];

                    packageCodes.add(packCode);
                    packageNames.add(packName);
                    packageBox.addItem(packCode);
                }
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }


        try(BufferedReader br = new BufferedReader(new FileReader(variantFile))){
            String line;
            while ((line = br.readLine()) != null){
                String[] varBox = line.split("\t");

                if (varBox.length >= 2){

                    String varCode = varBox[0];
                    String varName = varBox[1];

                    variantCodes.add(varCode);
                    variantNames.add(varName);
                    variantBox.addItem(varCode);
                }
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }
}