import javax.swing.*;
import java.awt.*;

public class ButtonIsiCerita extends JPanel {
    JButton btnBack4 = new JButton("Kembali");

    public ButtonIsiCerita(){
        setLayout(new GridLayout(1,1));
        add(btnBack4);

        btnBack4.addActionListener(new IsiCerita.buttonBack4());
    }
}
