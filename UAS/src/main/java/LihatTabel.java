import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LihatTabel extends JFrame {
    public LihatTabel(){
        setTitle("Tabel Daftar Cerpen");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        add(new Tabel());
        add(new UpdateDelete());
        add(new JScrollPane(UpdateDelete.txtIsi2));
        add(new ButtonTabel());


        setVisible(true);

    }

    static class buttonBack implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            new MenuUtama();
        }
    }

}
