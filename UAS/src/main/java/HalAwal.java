import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class HalAwal extends JFrame {
    private JLabel label;
    private JPanel panelImg;
    public HalAwal(){
        setTitle("Halaman Awal");
        setSize(700,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);


        label = new JLabel("Selamat Datang di Hipen!");
        add(label);
        label.setBounds(120,20,500,55);
        label.setForeground(Color. black);
        label.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));

        ImageIcon image = new ImageIcon("C:/Users/Ferbian/Desktop/UAS OBP/UAS/src/images/newlogo.jpg");
        JLabel imageLabel = new JLabel(image);

        imageLabel.setBounds(0,0,700,500);
        imageLabel.setVisible(true);

        JButton btnA = new JButton("LOGIN");
        btnA.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnA.setBounds(270,200,150,50);

        JButton btnZ = new JButton("Tips Menulis Cerpen Dan Manual");
        btnZ.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnZ.setBounds(220, 270, 250, 50);


        btnA.addActionListener(new ButtonAListener());
        btnZ.addActionListener(new ButtonZListener());
        add(btnA);
        add(btnZ);
        add(imageLabel);

        setVisible(true);
    }

    //inner class
    class ButtonAListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                new Login();
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            dispose();
        }
    }

    class ButtonZListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                new Tips();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            dispose();
        }
    }
}
