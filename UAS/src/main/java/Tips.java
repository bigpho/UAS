import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Tips extends JFrame {
    private JPanel panelImg2;
    public Tips(){
        setTitle("Tips Menulis Cerpen");
        setSize(700,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        JButton btnBack = new JButton("Kembali");
        btnBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnBack.setBounds(10,10,85,30);
        btnBack.addActionListener(new ButtonBackListener());

        add(btnBack);
        ImageIcon image = new ImageIcon("C:/Users/Ferbian/Desktop/UAS OBP/UAS/src/images/tips.jpg");
        JLabel imageLabel = new JLabel(image);
        add(imageLabel);
        imageLabel.setBounds(0, 0, 680, 460);
        imageLabel.setVisible(true);

        setVisible(true);
    }

    class ButtonBackListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            new HalAwal();
            dispose();
        }
    }
}
