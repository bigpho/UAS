import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class IsiCerita extends JFrame {
    public IsiCerita() throws SQLException {
        setTitle("Cerita");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(new Teks());
        add(new ButtonIsiCerita());

        setVisible(true);
    }

    static class buttonBack4 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                new BacaCerita();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

}
