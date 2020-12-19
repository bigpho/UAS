import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataCerita extends JPanel {
    static JTextField txtJudul = new JTextField();
    static JTextField txtPenulis = new JTextField();

    static String[] genre = {
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
    static JComboBox cmbGenre = new JComboBox(genre);
    private static String test = "Halo.";
    static JTextArea txtIsi = new JTextArea(test,20,40);


    public DataCerita(){
        JScrollPane sp;
        setLayout(new GridLayout(4,2));

        add(new JLabel("Judul"));
        add(txtJudul);

        add(new JLabel("Nama Penulis"));
        add(txtPenulis);

        add(new JLabel("Genre"));
        add(cmbGenre);

        add(new JLabel("Isi Cerita"));
        txtIsi = new JTextArea();
        txtIsi.setFont(new Font("Arial", Font.PLAIN, 15));
        txtIsi.setSize(200, 75);
        txtIsi.setLocation(200, 300);
        txtIsi.setLineWrap(true);
        txtIsi.setWrapStyleWord(true);
        add(txtIsi);


    }

    static class buttonSelanjutnya implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                String sql = "INSERT INTO cerita (judul, penulis, genre, isi) VALUES (?,?,?,?)";
                Connection db = DriverManager.getConnection("jdbc:mysql://localhost:3306/kelas_java", "root","");

                PreparedStatement stmt = db.prepareStatement(sql);
                stmt.setString(1, txtJudul.getText());
                stmt.setString(2, txtPenulis.getText());
                stmt.setString(3, String.valueOf(cmbGenre.getSelectedItem()));
                stmt.setString(4, txtIsi.getText());
                stmt.executeUpdate();


                JOptionPane.showMessageDialog(null, "Berhasil Menginput Cerita!");

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            clearform();
        }

        private void clearform(){
            txtJudul.setText("");
            txtPenulis.setText("");
            cmbGenre.setSelectedItem("");
            txtIsi.setText("");
        }
    }
}
