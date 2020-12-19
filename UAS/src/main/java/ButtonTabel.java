import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonTabel extends JPanel {
    JButton btnUpdate = new JButton("Update");
    JButton btnDelete = new JButton("Delete");
    JButton btnBack = new JButton("Kembali");

    public ButtonTabel(){
        setLayout(new GridLayout(1,3));
        add(btnUpdate);
        add(btnDelete);
        add(btnBack);

        btnUpdate.addActionListener(new UpdateDelete.buttonUpdate());
        btnDelete.addActionListener(new UpdateDelete.buttonDelete());
        btnBack.addActionListener(new LihatTabel.buttonBack());
    }
}
