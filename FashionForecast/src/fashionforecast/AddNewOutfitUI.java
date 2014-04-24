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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author unkn0wn
 */
public class AddNewOutfitUI extends JFrame{
    WardrobeCntl theWardrobeCntl;
    OutfitTableModel theOutfitTableModel;
    
    JPanel contentPanel;
    JPanel mainPanel;
    JPanel buttonsPanel;
            
    JLabel titleLabel;
    JTextField titleField;
    JLabel formalityLabel;
    JTextField formalityField;
    JLabel shirtLabel;
    JComboBox shirtDropdown; 
    JLabel pantsLabel;
    JComboBox pantsDropdown; 
    JLabel coatLabel;
    JComboBox coatDropdown; 
    JLabel shoesLabel;
    JComboBox shoesDropdown; 
    JButton saveButton;
    JButton cancelButton;
    
    public AddNewOutfitUI(WardrobeCntl passedWardrobeCntl, OutfitTableModel passedOutfitTableModel){
        theWardrobeCntl = passedWardrobeCntl;
        theOutfitTableModel = passedOutfitTableModel;
        setTitle("New Outfit");
        setBounds(100, 100, 600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
    }
    
    public void initComponents(){
      contentPanel = new JPanel();
        buttonsPanel = new JPanel();
        mainPanel = new JPanel();
        
        titleLabel = new JLabel("Outfit Title: ");
        titleField = new JTextField();
        formalityLabel = new JLabel("Formality: ");
        formalityField = new JTextField();
        shirtLabel = new JLabel("Shirt: ");
        String[] shirtDropdownValues = theWardrobeCntl.populateShirtDropdownValues();
        shirtDropdown = new JComboBox(shirtDropdownValues);
        shirtDropdown.addActionListener(new ShirtComboBoxListener());
        pantsLabel = new JLabel("Pants: ");
        String[] pantsDropdownValues = theWardrobeCntl.populatePantsDropdownValues();
        pantsDropdown = new JComboBox(pantsDropdownValues);
        coatLabel = new JLabel("Coat: ");
        String[] coatDropdownValues = theWardrobeCntl.populateCoatDropdownValues();
        coatDropdown = new JComboBox(coatDropdownValues);
        shoesLabel = new JLabel("Shoes: ");
        String[] shoesDropdownValues = theWardrobeCntl.populateShoesDropdownValues();
        shoesDropdown = new JComboBox(shoesDropdownValues);
        
        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new CancelButtonListener());
        saveButton = new JButton("Save");
        saveButton.addActionListener(new SaveButtonListener());
        
        BorderLayout mainLayout = new BorderLayout();
        GridLayout contentLayout = new GridLayout(0, 2);
        GridLayout buttonsLayout = new GridLayout(0, 2);
        
        mainPanel.setLayout(mainLayout);
        contentPanel.setLayout(contentLayout);
        buttonsPanel.setLayout(buttonsLayout);
        
        contentPanel.add(titleLabel);
        contentPanel.add(titleField);
        contentPanel.add(formalityLabel);
        contentPanel.add(formalityField);
        contentPanel.add(shirtLabel);
        contentPanel.add(shirtDropdown);
        contentPanel.add(pantsLabel);
        contentPanel.add(pantsDropdown);
        contentPanel.add(coatLabel);
        contentPanel.add(coatDropdown);
        contentPanel.add(shoesLabel);
        contentPanel.add(shoesDropdown);
        buttonsPanel.add(cancelButton);
        buttonsPanel.add(saveButton);
        mainPanel.add(contentPanel, mainLayout.CENTER);
        mainPanel.add(buttonsPanel, mainLayout.SOUTH);
        this.add(mainPanel);
        setVisible(true);
        
        
        
    }
    
    
    public class CancelButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            setVisible(false);
            theWardrobeCntl.getWardrobeUI();
        }
    }
    
    public class SaveButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            setVisible(false);
            
            
            //theOutfitTableModel.addOutfit(titleField.getText(), garmentImage, garmentSizeField.getText(), savedDirtyState, description.getText(), typeField.getText());
            theWardrobeCntl.getWardrobeUI();
        }
    }
    
    public class ShirtComboBoxListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int selectedIndex = shirtDropdown.getSelectedIndex();
            System.out.println(selectedIndex);
        }
    }
    
    public class PantsComboBoxListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int selectedIndex = pantsDropdown.getSelectedIndex();
        }
    }
    
    public class CoatComboBoxListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int selectedIndex = coatDropdown.getSelectedIndex();
        }
    }
    
    public class ShoesComboBoxListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int selectedIndex = shoesDropdown.getSelectedIndex();
        }
    }
    
    
}

