package javaProj;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class systemClass extends JFrame {

    JLabel iTMS = new JLabel(new ImageIcon("C:\\Users\\Tamara\\Downloads\\finalProj-master\\finalProj-master\\media\\trans-logo.png"));
    JLabel sysHead = new JLabel("About the System.");
    JLabel sysSubHead = new JLabel("Identity");
    JLabel sysSubHead2 = new JLabel("Purpose");
    JLabel sysSubHead3 = new JLabel("Features");
    JPanel divider = new JPanel();
    JPanel divider2 = new JPanel();
    JPanel divider3 = new JPanel();
    JPanel divider4 = new JPanel();
    JPanel divider5 = new JPanel();
    JPanel divider6 = new JPanel();
    JPanel head = new JPanel();
    JPanel head2 = new JPanel();

    public systemClass() {

        setTitle("System Information");
        setSize(1000, 600);
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

        iTMS.setBounds(700, 210, 190, 190);
        add(iTMS);

        sysHead.setHorizontalAlignment(SwingConstants.RIGHT);
        sysHead.setBounds(400, 10, 520, 93);
        sysHead.setFont(new Font("Poppins", Font.BOLD, 55));
        sysHead.setForeground(Color.decode("#1E1E1F"));
        add(sysHead);

        sysSubHead.setBounds(60, 138, 215, 35);
        sysSubHead.setFont(new Font("Poppins Italic", Font.BOLD, 18));
        sysSubHead.setForeground(Color.decode("#1E1E1F"));
        add(sysSubHead);

        sysSubHead2.setBounds(58, 230, 215, 35);
        sysSubHead2.setFont(new Font("Poppins Italic", Font.BOLD, 18));
        sysSubHead2.setForeground(Color.decode("#1E1E1F"));
        add(sysSubHead2);

        sysSubHead3.setBounds(56, 405, 215, 35);
        sysSubHead3.setFont(new Font("Poppins Italic", Font.BOLD, 18));
        sysSubHead3.setForeground(Color.decode("#1E1E1F"));
        add(sysSubHead3);

        JLabel sysParagraph = new JLabel("<html>A Java-based Inventory and Transaction Management System (iTMS),<br>designed to streamline business operations </br></html>"); //// With the iTMS, one can effortlessly manage product categories, packages, and variants, all stored securely in dedicated text files. Streamline supplier interactions by maintaining detailed supplier information and tracking deliveries with ease. The intuitive interface allows for smooth order management, automatically calculating total order amounts and facilitating cash transactions. <br></br><br>Generate insightful reports on product details and sales to make informed business decisions. The system also includes an [About] section, offering transparency with information about the system and its developers. Elevate your business with the iTMS – where innovation meets simplicity.</br></html>");
        sysParagraph.setLabelFor(this);
        sysParagraph.setHorizontalAlignment(SwingConstants.RIGHT);
        sysParagraph.setFont(new Font("Poppins", Font.BOLD, 15));
        sysParagraph.setBounds(183, 130, 560, 50);
        add(sysParagraph);

        JLabel sysParagraph2 = new JLabel("<html>A comprehensive solution that seamlessly integrates product management, supplier coordination, and transaction processing, ensuring unparalleled efficiency and accuracy all in one application.</br></html>"); //With the iTMS, one can effortlessly manage product categories, packages, and variants, all stored securely in dedicated text files. Streamline supplier interactions by maintaining detailed supplier information and tracking deliveries with ease. The intuitive interface allows for smooth order management, automatically calculating total order amounts and facilitating cash transactions. <br></br><br>Generate insightful reports on product details and sales to make informed business decisions. The system also includes an [About] section, offering transparency with information about the system and its developers. Elevate your business with the iTMS – where innovation meets simplicity.</br></html>");
        sysParagraph2.setLabelFor(this);
        sysParagraph2.setHorizontalAlignment(SwingConstants.LEFT);
        sysParagraph2.setFont(new Font("Poppins", Font.PLAIN, 15));
        sysParagraph2.setBounds(190, 197, 430, 100);
        add(sysParagraph2);

        JLabel sysParagraph3 = new JLabel("<html> - effortlessly manage product categories, packages, and variants, all stored securely in dedicated text files<br>- streamline supplier interactions by maintaining detailed supplier information and tracking deliveries with ease</br><br>- intuitive interface allows for smooth order management, automatically calculating total order amounts and facilitating cash transactions</br><br>- generate insightful reports on product details and sales to make informed business decisions</br></html>"); //Elevate your business with the iTMS – where innovation meets simplicity.</br></html>");
        sysParagraph3.setLabelFor(this);
        sysParagraph3.setHorizontalAlignment(SwingConstants.LEFT);
        sysParagraph3.setFont(new Font("Poppins", Font.PLAIN, 15));
        sysParagraph3.setBounds(190, 320, 485, 200);
        add(sysParagraph3);

        divider.setBounds(54, 130, 86, 1);
        divider.setBackground(Color.WHITE);
        add(divider);

        divider2.setBounds(54, 175, 86, 1);
        divider2.setBackground(Color.WHITE);
        add(divider2);

        divider3.setBounds(54, 225, 86, 1);
        divider3.setBackground(Color.WHITE);
        add(divider3);

        divider4.setBounds(54, 270, 86, 1);
        divider4.setBackground(Color.WHITE);
        add(divider4);

        divider5.setBounds(54, 395, 86, 1);
        divider5.setBackground(Color.WHITE);
        add(divider5);

        divider6.setBounds(54, 445, 86, 1);
        divider6.setBackground(Color.WHITE);
        add(divider6);

        head.setBounds(40,0,115,1000);
        head.setBackground(Color.decode("#31C198"));
        head2.setBounds(0,20,1000,75);
        head2.setBackground(Color.decode("#31C198"));
        add(head); add(head2);

        setResizable(false);
        setVisible(true);
    }
}
