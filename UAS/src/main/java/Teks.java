import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Teks extends JPanel {
    static private Connection db;
    static Statement stmt;
    static JTextArea teks;
    static JTextArea txtID2 = new JTextArea();

    public Teks() throws SQLException {

        teks = new JTextArea(20,10);
        JScrollPane scrollPane = new JScrollPane(teks);
        teks.setLineWrap(true);
        teks.setWrapStyleWord(true);
//        this.isiCerita();

        setLayout(new GridLayout(1,2));
        setBorder(new EmptyBorder(10,10,0,12));

//        add(new JLabel("ID:"));
//        add(txtID2);

        add(scrollPane);
    }


//    static class buttonPilih implements ActionListener{
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//
//            try{
//                String sql = "SELECT isi,judul FROM cerita WHERE ceritaID =?";
//                Connection db = DriverManager.getConnection("jdbc:mysql://localhost:3306/kelas_java", "root","");
//
//                PreparedStatement stmt = db.prepareStatement(sql);
//
//                stmt.setInt(1, Integer.parseInt(txtID2.getText()));
//                ResultSet rs = stmt.executeQuery();
//
//                if(rs.next()){
//                String ISICERITA = rs.getString("isi");
//                String JUDULCERITA = rs.getString("judul");
//                    teks.setText(JUDULCERITA+"\n\n"+ISICERITA);
//                }
//
//
//
//            } catch (Exception exception) {
//                exception.printStackTrace();
//            }
//
//
//
//        }
//    }
}

