import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame {
    private Connection db;
    Statement stmt;

    public Login() throws ClassNotFoundException, SQLException {

        db = DriverManager.getConnection("jdbc:mysql://localhost:3306/kelas_java", "root", "");
        stmt = db.createStatement();

        setTitle("Login Page");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel loginLabel = new JLabel("LOGIN");
        loginLabel.setBounds(200, 10, 400, 100);
        loginLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 90));

        JLabel userLabel = new JLabel("EMAIL");
        userLabel.setBounds(150, 200, 100, 30);

        JLabel passwordLabel = new JLabel("PASSWORD");
        passwordLabel.setBounds(150, 270, 100, 30);

        JTextField userTextField = new JTextField();
        userTextField.setBounds(250, 200, 300, 30);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(250, 270, 300, 30);

        JButton loginButton = new JButton("LOGIN");
        loginButton.setBounds(150, 350, 100, 30);

        JButton signupButton = new JButton("SIGN UP");
        signupButton.setBounds(300, 350, 100, 30);

        JButton backButton = new JButton("BACK");
        backButton.setBounds(450, 350, 100, 30);

        add(loginLabel);
        add(userLabel);
        add(passwordLabel);
        add(userTextField);
        add(passwordField);
        loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(loginButton);
        signupButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(signupButton);
        backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(backButton);

        signupButton.addActionListener(new signupButtonListener());
        backButton.addActionListener(new backButtonListener());

        ImageIcon image = new ImageIcon("C:/Users/Ferbian/Desktop/UAS OBP/UAS/src/images/login.jpg");
        JLabel imageLabel = new JLabel(image);
        add(imageLabel);
        imageLabel.setBounds(0, 0, 680, 460);
        imageLabel.setVisible(true);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String sql = "SELECT * FROM login WHERE email='" + userTextField.getText() + "' AND " +
                            "password='" + passwordField.getText() + "'";
                    ResultSet rs = stmt.executeQuery(sql);
                    if (rs.next()) {
                        if (userTextField.getText().equals(rs.getString("email")) && passwordField.getText().equals(rs.getString("password"))) {
                            JOptionPane.showMessageDialog(null, "LOGIN BERHASIL!");
                            new MenuUtama();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Email atau Password Salah!");
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            }
        });

        setVisible(true);
    }
    //inner class


    class signupButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            new SignUp();
            dispose();
        }
    }

    class backButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            new HalAwal();
            dispose();
        }
    }

    public boolean isConnected() {
        return (db != null);
    }

}
