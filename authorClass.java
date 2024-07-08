package javaProj;
import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class authorClass extends JFrame {

    JLabel autHead = new JLabel("Authors.");
    JLabel sysParagraph = new JLabel("<html><div style='text-align: justify;'>The development of the <b>iTMS</b> is spearheaded by a group of "
            + "dedicated undergraduate BSIT students with amateur experience in java programming and interface design. "
            + "This is in fulfillment of their final project in the course-- <i>Object Oriented Programming</i>.</div></html>");

    JLabel imgApdal = new JLabel(new ImageIcon("C:\\Users\\Tamara\\Downloads\\finalProj-master\\finalProj-master\\media\\apdal.png"));
    JLabel imgGeronimo = new JLabel(new ImageIcon("C:\\Users\\Tamara\\Downloads\\finalProj-master\\finalProj-master\\media\\geronimo2.png"));
    JLabel imgEmbuido = new JLabel(new ImageIcon("C:\\Users\\Tamara\\Downloads\\finalProj-master\\finalProj-master\\media\\embuido.png"));

    JLabel nameApdal = new JLabel("Justine Apdal");
    JLabel nameGeronimo = new JLabel("Tamara Geronimo");
    JLabel nameEmbuido = new JLabel("Rian Jake Embuido");
    JLabel contA = new JLabel("Contributions:");
    JLabel contG = new JLabel("Contributions:");
    JLabel contR = new JLabel("Contributions:");
    JLabel apdCont1 = new JLabel("• GUI Frame Layout(s)");
    JLabel apdCont2 = new JLabel("• Functionalities");
    JLabel apdCont3 = new JLabel("- Product Frame");
    JLabel apdCont4 = new JLabel("- Show Reports");
    JLabel apdCont5 = new JLabel("- Order/Delivery Form*");
    JLabel apdCont6 = new JLabel("- File Handling");
    JLabel gerCont1 = new JLabel("• GUI design");
    JLabel gerCont2 = new JLabel("- Frame Layout(s)");
    JLabel gerCont3 = new JLabel("- Themes, Colors, Fonts");
    JLabel gerCont4 = new JLabel("• Code Cleanup");
    JLabel gerCont5 = new JLabel("• Loading/Splash Screen");
    JLabel embCont1 = new JLabel("• GUI Frame Layout(s)");
    JLabel embCont2 = new JLabel("• Functionalities");
    JLabel embCont3 = new JLabel("- Show Reports (Product)");
    JLabel embCont4 = new JLabel("- Order/Delivery Form*");
    JLabel embCont5 = new JLabel("- Variant/Supplier Form");
    JLabel embCont6 = new JLabel("- File Handling");

    JPanel head = new JPanel();

    public authorClass() {

        setTitle("System Authors");
        setSize(1000, 610);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

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

        autHead.setHorizontalAlignment(SwingConstants.RIGHT);
        autHead.setBounds(50, 10, 250, 93);
        autHead.setFont(new Font("Poppins", Font.BOLD, 55));
        autHead.setForeground(Color.decode("#1E1E1F"));
        add(autHead);

        sysParagraph.setLabelFor(this);
        sysParagraph.setHorizontalAlignment(SwingConstants.RIGHT);
        sysParagraph.setFont(new Font("Poppins", Font.PLAIN, 15));
        sysParagraph.setBounds(100, 100, 800, 100);
        add(sysParagraph);

        head.setBounds(0, 20, 1000, 75);
        head.setBackground(Color.decode("#31C198"));
        add(head);

        // author images
        imgApdal.setBounds(125, 210, 190, 190);
        add(imgApdal);
        imgGeronimo.setBounds(406, 210, 190, 190);
        add(imgGeronimo);
        imgEmbuido.setBounds(678, 210, 190, 190);
        add(imgEmbuido);

        // author names
        nameApdal.setHorizontalAlignment(SwingConstants.CENTER);
        nameApdal.setFont(new Font("Poppins", Font.BOLD, 18));
        nameApdal.setBounds(125, 407, 190, 25);
        add(nameApdal);

        nameGeronimo.setHorizontalAlignment(SwingConstants.CENTER);
        nameGeronimo.setFont(new Font("Poppins", Font.BOLD, 18));
        nameGeronimo.setBounds(406, 407, 190, 25);
        add(nameGeronimo);

        nameEmbuido.setHorizontalAlignment(SwingConstants.CENTER);
        nameEmbuido.setFont(new Font("Poppins", Font.BOLD, 18));
        nameEmbuido.setBounds(678, 407, 190, 25);
        add(nameEmbuido);

        // author contributions
        contA.setFont(new Font("Poppins", Font.ITALIC, 14));
        contA.setBounds(125, 442, 114, 25);
        add(contA);
        apdCont1.setFont(new Font("Poppins", Font.PLAIN, 12));
        apdCont1.setBounds(147, 463, 168, 25);
        add(apdCont1);
        apdCont2.setFont(new Font("Poppins", Font.PLAIN, 12));
        apdCont2.setBounds(700, 481, 168, 25);
        add(apdCont2);
        apdCont3.setFont(new Font("Poppins", Font.PLAIN, 12));
        apdCont3.setBounds(157, 498, 158, 25);
        add(apdCont3);
        apdCont4.setFont(new Font("Poppins", Font.PLAIN, 12));
        apdCont4.setBounds(157, 512, 158, 25);
        add(apdCont4);
        apdCont5.setFont(new Font("Poppins", Font.PLAIN, 12));
        apdCont5.setBounds(157, 526, 158, 25);
        add(apdCont5);
        apdCont6.setFont(new Font("Poppins", Font.PLAIN, 12));
        apdCont6.setBounds(157, 540, 158, 25);
        add(apdCont6);


        contG.setFont(new Font("Poppins", Font.ITALIC, 14));
        contG.setBounds(406, 442, 114, 25);
        add(contG);
        gerCont1.setFont(new Font("Poppins", Font.PLAIN, 12));
        gerCont1.setBounds(428, 463, 168, 25);
        add(gerCont1);
        gerCont2.setFont(new Font("Poppins", Font.PLAIN, 12));
        gerCont2.setBounds(438, 481, 158, 25);
        add(gerCont2);
        gerCont3.setFont(new Font("Poppins", Font.PLAIN, 12));
        gerCont3.setBounds(438, 498, 158, 25);
        add(gerCont3);
        gerCont4.setFont(new Font("Poppins", Font.PLAIN, 12));
        gerCont4.setBounds(428, 516, 140, 25);
        add(gerCont4);
        gerCont5.setFont(new Font("Poppins", Font.PLAIN, 12));
        gerCont5.setBounds(428, 534, 148, 25);
        add(gerCont5);

        contR.setFont(new Font("Poppins", Font.ITALIC, 14));
        contR.setBounds(677, 442, 114, 25);
        add(contR);
        embCont1.setFont(new Font("Poppins", Font.PLAIN, 12));
        embCont1.setBounds(700, 463, 168, 25);
        add(embCont1);
        embCont2.setFont(new Font("Poppins", Font.PLAIN, 12));
        embCont2.setBounds(147, 481, 168, 25);
        add(embCont2);
        embCont3.setFont(new Font("Poppins", Font.PLAIN, 12));
        embCont3.setBounds(710, 498, 158, 25);
        add(embCont3);
        embCont4.setFont(new Font("Poppins", Font.PLAIN, 12));
        embCont4.setBounds(710, 512, 158, 25);
        add(embCont4);
        embCont5.setFont(new Font("Poppins", Font.PLAIN, 12));
        embCont5.setBounds(710, 526, 158, 25);
        add(embCont5);
        embCont6.setFont(new Font("Poppins", Font.PLAIN, 12));
        embCont6.setBounds(710, 540, 158, 25);
        add(embCont6);

        setResizable(false);
        setVisible(true);
    }
}
