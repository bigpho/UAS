import javax.swing.*;
import java.awt.*;

public class ButtonSignUp extends JPanel {
    JButton btnSignup = new JButton("Sign Up");
    JButton btnBack = new JButton("Back");

    public ButtonSignUp(){
        setLayout(new GridLayout(1,2));
        add(btnSignup);
        add(btnBack);
        btnSignup.addActionListener(new User.buttonsignup());
        btnBack.addActionListener(new User.buttonback());
    }
}
