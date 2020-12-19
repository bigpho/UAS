import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonCerita extends JPanel {
    JButton btnKembali = new JButton("Kembali");
    JButton btnSelanjutnya = new JButton("POST!!!");

    public ButtonCerita(){
        setLayout(new GridLayout(1,2));

        add(btnKembali);

        add(btnSelanjutnya);
        btnSelanjutnya.addActionListener(new DataCerita.buttonSelanjutnya());
        btnKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuUtama();
            }
        });
    }
}
