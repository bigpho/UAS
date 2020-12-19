import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDelete extends JPanel {
    static JTextField txtID = new JTextField();
    static JTextField txtJudul2 = new JTextField();
    static JTextField txtPenulis2 = new JTextField();

    static String[] genre2 = {
            "Cerpen Anak",
            "Cerpen Horor",
            "Cerpen Romansa",
            "Cerpen Fantasi/Fiksi",
            "Cerpen Sejarah",
            "Cerpen Inspiratif",
            "Cerpen Religi",
            "Cerpen Komedi",
            "Cerpen Kehidupan Sehari-hari",
            "Cerpen Fabel",
            "Lainnya"
    };
    static JComboBox cmbGenre2 = new JComboBox(genre2);
    private static String test = "Halo.";
    static JTextArea txtIsi2 = new JTextArea(test,20,40);


    public UpdateDelete(){
        JScrollPane sp;
        setLayout(new GridLayout(5,2));

        add(new JLabel("ID"));
        add(txtID);

        add(new JLabel("Judul"));
        add(txtJudul2);

        add(new JLabel("Nama Penulis"));
        add(txtPenulis2);

        add(new JLabel("Genre"));
        add(cmbGenre2);

        add(new JLabel("Isi Cerita"));
        txtIsi2 = new JTextArea(15,10);
        txtIsi2.setFont(new Font("Arial", Font.PLAIN, 15));
        txtIsi2.setSize(200, 75);
        txtIsi2.setLocation(200, 300);
        txtIsi2.setLineWrap(true);
        txtIsi2.setWrapStyleWord(true);
        add(txtIsi2);


    }

    static class buttonUpdate implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                String sql = "UPDATE cerita SET judul = ?, penulis = ?, genre = ?, isi = ? WHERE ceritaID = ?";
                Connection db = DriverManager.getConnection("jdbc:mysql://localhost:3306/kelas_java", "root","");

                PreparedStatement stmt = db.prepareStatement(sql);
                stmt.setString(1, txtJudul2.getText());
                stmt.setString(2, txtPenulis2.getText());
                stmt.setString(3, String.valueOf(cmbGenre2.getSelectedItem()));
                stmt.setString(4, txtIsi2.getText());
                stmt.setInt(5, Integer.parseInt(txtID.getText()));
                stmt.executeUpdate();



                JOptionPane.showMessageDialog(null, "Berhasil Update Cerita!");

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            clearform();
            Tabel.selectCerita();
        }

        private void clearform(){
            txtID.setText("");
            txtJudul2.setText("");
            txtPenulis2.setText("");
            cmbGenre2.setSelectedItem("");
            txtIsi2.setText("");
        }
    }

    static class buttonDelete implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                String sql = "DELETE FROM cerita WHERE ceritaID = ?";
                Connection db = DriverManager.getConnection("jdbc:mysql://localhost:3306/kelas_java", "root","");

                PreparedStatement stmt = db.prepareStatement(sql);
                stmt.setInt(1, Integer.parseInt(txtID.getText()));
                stmt.executeUpdate();
                Tabel.selectCerita();


                JOptionPane.showMessageDialog(null, "Berhasil Update Cerita!");

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            clearform();
            Tabel.selectCerita();
        }

        private void clearform(){
            txtID.setText("");
        }
    }
}
