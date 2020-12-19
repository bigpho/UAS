import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class bacaID extends JPanel {
    static private Connection db;
    static Statement stmt;
    static JTextField txtID2 = new JTextField();
    static JTextArea teks;

    public bacaID() throws SQLException {
        setLayout(new GridLayout(1,2));

        add(new JLabel("Cerita ID"));
        add(txtID2);
    }

    static class buttonPilih implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            try{
                String sql = "SELECT isi,judul FROM cerita WHERE ceritaID =?";
                Connection db = DriverManager.getConnection("jdbc:mysql://localhost:3306/kelas_java", "root","");

                PreparedStatement stmt = db.prepareStatement(sql);

                stmt.setInt(1, Integer.parseInt(txtID2.getText()));
                ResultSet rs = stmt.executeQuery();

                if(rs.next()){
                    String ISICERITA = rs.getString("isi");
                    String JUDULCERITA = rs.getString("judul");
                    Teks.teks.setText(JUDULCERITA+"\n\n"+ISICERITA);
                }else {
                    JOptionPane.showMessageDialog(null, "ID CERITA TIDAK TERSEDIA!");
                }



            } catch (Exception exception) {
                exception.printStackTrace();
            }



        }
    }
}
