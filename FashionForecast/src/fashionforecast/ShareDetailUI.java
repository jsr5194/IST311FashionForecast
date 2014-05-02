/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fashionforecast;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author unkn0wn
 */
public class ShareDetailUI extends JFrame{
    int selectedOutfitIndex;
    
    ShareCntl theShareCntl;
    String platform;
    JPanel mainPanel;
    JPanel contentPanel;
    JPanel buttonsPanel;
    
    JLabel usernameLabel;
    JLabel passwordLabel;
    JLabel outfitLabel;
    JLabel messageLabel;
    
    JTextField usernameField;
    JTextField passwordField;
    JComboBox outfitDropdown;
    JTextField messageField;
    
    JButton sendButton;
    JButton cancelButton;
    
    public ShareDetailUI(ShareCntl passedShareCntl, String passedPlatform){
        theShareCntl = passedShareCntl;
        platform = passedPlatform;
        setTitle("Share With "+platform);
        setBounds(100, 100, 600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
    }
    public void initComponents(){
        mainPanel = new JPanel();
        contentPanel = new JPanel();
        buttonsPanel = new JPanel();
        
        usernameLabel = new JLabel("Enter Username: ");
        passwordLabel = new JLabel("Enter Password: ");
        outfitLabel = new JLabel("Choose an Outfit: ");
        messageLabel = new JLabel("Write a Message: ");
        
        usernameField = new JTextField();
        passwordField = new JTextField("Password Disabled For Demo");
        passwordField.setEditable(false);
        String[] outfitDropdownValues = theShareCntl.populateOutfitDropdownValues();
        outfitDropdown = new JComboBox(outfitDropdownValues);
        outfitDropdown.addActionListener(new OutfitComboBoxListener());
        messageField = new JTextField();
        
        
        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new CancelButtonListener());
        sendButton = new JButton("Send");
        sendButton.addActionListener(new SendButtonListener());
        
        BorderLayout mainLayout = new BorderLayout();
        GridLayout contentLayout = new GridLayout(0, 2);
        GridLayout buttonsLayout = new GridLayout(0, 2);
        
        contentPanel.setLayout(contentLayout);
        mainPanel.setLayout(mainLayout);
        buttonsPanel.setLayout(buttonsLayout);
        
        contentPanel.add(usernameLabel);
        contentPanel.add(usernameField);
        contentPanel.add(passwordLabel);
        contentPanel.add(passwordField);
        contentPanel.add(outfitLabel);
        contentPanel.add(outfitDropdown);
        contentPanel.add(messageLabel);
        contentPanel.add(messageField);
        mainPanel.add(contentPanel);
        buttonsPanel.add(cancelButton);
        buttonsPanel.add(sendButton);
        mainPanel.add(buttonsPanel, mainLayout.SOUTH);
        this.add(mainPanel);
        setVisible(true);
    }
    
    public class CancelButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            setVisible(false);
            theShareCntl.getShareUI();
        }
    }
    
    public class SendButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            JOptionPane.showMessageDialog(null, "Message posted to "+platform);
            setVisible(false);
            theShareCntl.getShareUI();
        }
    }
    
    public class OutfitComboBoxListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            selectedOutfitIndex = outfitDropdown.getSelectedIndex();
        }
    }
}


