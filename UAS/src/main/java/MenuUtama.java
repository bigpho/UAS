import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class MenuUtama extends JFrame {
    public MenuUtama(){
        setTitle("Menu Utama");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);


        JButton btninput = new JButton("Buat Cerita");
        btninput.setBounds(30,50,200,40);

        JButton btnlihat = new JButton("Lihat & Ubah Daftar Cerita");
        btnlihat.setBounds(30,150,200,40);

        JButton btnBaca = new JButton("Baca Cerita");
        btnBaca.setBounds(30,250,200,40);

        JButton btnsignout = new JButton("Sign Out");
        btnsignout.setBounds(30,350,200,40);

//        JTextArea cerita = new JTextArea();
//        cerita.setBounds(250,30,400,400);
//        cerita.setLineWrap(true);
//        cerita.setWrapStyleWord(true);
//        add(new JScrollPane(cerita));

        add(btninput);
        add(btnlihat);
        add(btnBaca);
        add(btnsignout);
//        add(cerita);
        ImageIcon image = new ImageIcon("C:/Users/Ferbian/Desktop/UAS OBP/UAS/src/images/menuutama.jpg");
        JLabel imageLabel = new JLabel(image);
        add(imageLabel);
        imageLabel.setBounds(0, 0, 680, 460);
        imageLabel.setVisible(true);

        btninput.addActionListener(new ButtoninputListener());
        btnlihat.addActionListener(new ButtonlihatListener());
        btnBaca.addActionListener(new ButtonbacaListener());
        btnsignout.addActionListener(new ButtonsignoutListener());

        setVisible(true);
    }

    class ButtonbacaListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                new BacaCerita();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    class ButtoninputListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            new InputCerita();
            dispose();
        }
    }

    class ButtonlihatListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            new LihatTabel();
            dispose();
        }
    }

    class ButtonsignoutListener implements ActionListener{

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
}
