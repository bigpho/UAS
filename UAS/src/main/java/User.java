import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class User extends JPanel {
    static JTextField txtEmail = new JTextField();
    static JTextField txtPassword = new JTextField();

    public User(){
        setLayout(new GridLayout(5,2));

        add(new JLabel("Email"));
        add(txtEmail);

        add(new JLabel("Password"));
        add(txtPassword);

        Border etchedBorder = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);

        TitledBorder titledBorder = BorderFactory.createTitledBorder(etchedBorder,"Silakan Mengisi Data");
        titledBorder.setTitleFont(titledBorder.getTitleFont().deriveFont(Font.BOLD));

        setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10,10,10,10), titledBorder));
    }
    static class buttonsignup implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                String sql = "INSERT INTO login (email, password) VALUES (?,?)";
                Connection db = DriverManager.getConnection("jdbc:mysql://localhost:3306/kelas_java", "root","");

                PreparedStatement stmt = db.prepareStatement(sql);
                stmt.setString(1, txtEmail.getText());
                stmt.setString(2, txtPassword.getText());
                stmt.executeUpdate();

                JOptionPane.showMessageDialog(null, "Sign Up Berhasil!");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            clearform();
        }
        private void clearform(){
            txtEmail.setText("");
            txtPassword.setText("");
        }
    }


    public static class buttonback implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                new Login();
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }



    public static class loginButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                String sql = "INSERT INTO login (email, password) VALUES (?,?)";
                Connection db = DriverManager.getConnection("jdbc:mysql://localhost:3306/kelas_java", "root","");

                PreparedStatement stmt = db.prepareStatement(sql);
                stmt.setString(1, txtEmail.getText());
                stmt.setString(2, txtPassword.getText());
                stmt.executeUpdate();

                JOptionPane.showMessageDialog(null, "Sign Up Berhasil!");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            clearform();
        }
        private void clearform(){
            txtEmail.setText("");
            txtPassword.setText("");
        }
    }


}
