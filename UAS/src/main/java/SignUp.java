import javax.swing.*;

public class SignUp extends JFrame {
    public SignUp(){
        setTitle("Sign Up");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        add(new User());
        add(new ButtonSignUp());


        setVisible(true);
    }
}
