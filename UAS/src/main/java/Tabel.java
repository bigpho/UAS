import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Tabel extends JPanel {
    static DefaultTableModel tblmodel;
    static JTable tbl;

    Tabel(){
        tblmodel = new DefaultTableModel();
        tbl = new JTable(tblmodel);
        JScrollPane scrollPane = new JScrollPane(tbl);
        tbl.setFillsViewportHeight(true);
        tbl.setEnabled(false);
        this.selectCerita();

        setLayout(new GridLayout(1,1));
        setBorder(new EmptyBorder(10,10,0,12));

        add(scrollPane);
    }
    static void selectCerita(){
        try{
            tblmodel = new DefaultTableModel();
            tblmodel.addColumn("ID Cerpen");
            tblmodel.addColumn("Judul");
            tblmodel.addColumn("Nama Penulis");
            tblmodel.addColumn("Genre");
            tblmodel.addColumn("Isi");

            PreparedStatement stmt = DriverManager.getConnection("jdbc:mysql://localhost:3306/kelas_java", "root","")
                    .prepareStatement("SELECT * FROM cerita ORDER BY ceritaID");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                tblmodel.addRow(
                        new Object[]{
                                rs.getString(1),
                                rs.getString(2),
                                rs.getString(3),
                                rs.getString(4),
                                rs.getString(5)

                        }
                );
            }

            tbl.setModel(tblmodel);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
