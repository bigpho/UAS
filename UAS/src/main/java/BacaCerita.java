import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class BacaCerita extends JFrame {
    public BacaCerita() throws SQLException {
        setTitle("Baca Cerita");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        add(new Tabel());
        add(new Teks());
        add(new bacaID());
        add(new ButtonBacaCerita());

        setVisible(true);
    }


    static class buttonBack2 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            new MenuUtama();
        }
    }
}
