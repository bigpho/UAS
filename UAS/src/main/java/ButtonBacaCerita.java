import javax.swing.*;
import java.awt.*;

public class ButtonBacaCerita extends JPanel {
    JButton btnPilih = new JButton("Pilih");
    JButton btnBack2 = new JButton("Kembali");

    public ButtonBacaCerita(){
        setLayout(new GridLayout(1,2));
        add(btnBack2);
        add(btnPilih);

        btnPilih.addActionListener(new bacaID.buttonPilih());
        btnBack2.addActionListener(new BacaCerita.buttonBack2());
    }
}
