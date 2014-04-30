
package fashionforecast;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author jared
 */
public class NewUserUI extends JFrame{
    NewUserCntl theNewUserCntl;
    JPanel mainPanel;
    JLabel usernameLabel;
    JLabel passwordLabel;
    JTextField usernameField;
    JPasswordField passwordField;
    JButton addUserButton;
    JButton cancelButton;
    
    public NewUserUI(NewUserCntl parentNewUserCntl){
        theNewUserCntl = parentNewUserCntl;
        this.initComponents();
        setBounds(100, 100, 300, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void initComponents(){
        mainPanel = new JPanel();
        usernameLabel = new JLabel("New Username: ");
        usernameField = new JTextField("", 20);
        passwordLabel = new JLabel("New Password: ");
        passwordField = new JPasswordField("", 20);
        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new CancelButtonListener());
        addUserButton = new JButton("Create User");
        addUserButton.addActionListener(new AddUserButtonListener());
        
        
        mainPanel.add(usernameLabel);
        mainPanel.add(usernameField);
        mainPanel.add(passwordLabel);
        mainPanel.add(passwordField);
        mainPanel.add(cancelButton);
        mainPanel.add(addUserButton);
        this.add(mainPanel);
        setVisible(true);
    }
    
    public class CancelButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            theNewUserCntl.getLoginCntl();
            setVisible(false);
        }
    }
    
    public class AddUserButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            theNewUserCntl.addUser(usernameField.getText(), passwordField.getPassword());
            JOptionPane.showMessageDialog(null, "New User Successfully Added");
            theNewUserCntl.getLoginCntl();
            setVisible(false);
        }
    }
}
