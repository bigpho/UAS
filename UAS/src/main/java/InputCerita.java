import javax.swing.*;
import java.awt.*;

public class InputCerita extends JFrame {
    public InputCerita(){
        setTitle("Input Cerita");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));



        add(new DataCerita());
        add(new JScrollPane(DataCerita.txtIsi));
        add(new ButtonCerita());

        setVisible(true);
    }
}
