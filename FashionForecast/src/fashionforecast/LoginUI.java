package fashionforecast;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author jared
 */
public class LoginUI extends JFrame{
    LoginCntl theLoginCntl;
    
    JPanel mainPanel;
    JLabel usernameLabel;
    JTextField usernameField;
    JLabel passwordLabel;
    JPasswordField passwordField;
    JButton submitButton;
    JButton newUserButton;
            
    public LoginUI(LoginCntl parentLoginCntl){
        theLoginCntl = parentLoginCntl;
        setBounds(100, 100, 300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
    }
    public void initComponents(){
        mainPanel = new JPanel();
        usernameLabel = new JLabel("Username: ");
        usernameField = new JTextField("", 20);
        passwordLabel = new JLabel("Password: ");
        passwordField = new JPasswordField("", 20);
        submitButton = new JButton("Submit");
        submitButton.addActionListener(new SubmitButtonListener());
        newUserButton = new JButton("New User");
        newUserButton.addActionListener(new NewUserButtonListener());
        
        
        mainPanel.add(usernameLabel);
        mainPanel.add(usernameField);
        mainPanel.add(passwordLabel);
        mainPanel.add(passwordField);
        mainPanel.add(newUserButton);
        mainPanel.add(submitButton);
        this.add(mainPanel);
        setVisible(true);
    }
    public class SubmitButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Boolean authValue = theLoginCntl.authenticate(usernameField.getText(), passwordField.getPassword());
            if (authValue == true){
                theLoginCntl.getMainMenuCntl();
                setVisible(false);
            }
            else{
                JOptionPane.showMessageDialog(null, "Authentication Failed. Try Again");
                reset();
            }
        }
    }
    
    public class NewUserButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            theLoginCntl.getNewUserCntl();
            reset();
            setVisible(false);
        }
    }
    
    public void reset(){
        usernameField.setText("");
        passwordField.setText("");
    }
}
