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
public class AddNewGarmentUI extends JFrame{
    WardrobeCntl theWardrobeCntl;
    GarmentTableModel theGarmentTableModel;
    
    JPanel contentPanel;
    JPanel garmentDirtyStatePanel;
    JPanel mainPanel;
    JPanel buttonsPanel;
    
    ImageIcon garmentImage;
            
    JLabel titleLabel;
    JTextField titleField;
    JLabel typeLabel;
    JTextField typeField;
    JLabel garmentImageLabel;
    JTextField garmentImageField;
    JLabel garmentSizeLabel;
    JTextField garmentSizeField;
    JLabel garmentDirtyStateLabel;
    JRadioButton garmentIsDirty;
    JRadioButton garmentIsClean;
    ButtonGroup garmentButtonGroup;
    JLabel descriptionLabel;
    JTextArea description;
    JButton saveButton;
    JButton cancelButton;
    
    public AddNewGarmentUI(WardrobeCntl passedWardrobeCntl, GarmentTableModel passedGarmentTableModel){
        theWardrobeCntl = passedWardrobeCntl;
        theGarmentTableModel = passedGarmentTableModel;
        setTitle("New Garment");
        setBounds(100, 100, 600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
    }
    
    public void initComponents(){
      contentPanel = new JPanel();
        garmentDirtyStatePanel = new JPanel();
        buttonsPanel = new JPanel();
        mainPanel = new JPanel();
        
        titleLabel = new JLabel("Garment Title: ");
        titleField = new JTextField();
        typeLabel = new JLabel("Garment Type (shirt, pants, coat, shoes): ");
        typeField = new JTextField();
        garmentImageLabel = new JLabel("Garment Image path: ");
        garmentImageField = new JTextField();
        garmentSizeLabel = new JLabel("Garment Size: ");
        garmentSizeField = new JTextField();
        garmentDirtyStateLabel = new JLabel("Garment Dirty State: ");
        garmentButtonGroup = new ButtonGroup();
        garmentIsDirty = new JRadioButton();
        garmentIsClean = new JRadioButton();
        garmentIsDirty.setText("Dirty");
        garmentIsClean.setText("Clean");
        
        garmentButtonGroup.add(garmentIsDirty);
        garmentButtonGroup.add(garmentIsClean);
        
        descriptionLabel = new JLabel("Description: ");
        description = new JTextArea();
        
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
        contentPanel.add(garmentImageLabel);
        contentPanel.add(garmentImageField);
        contentPanel.add(typeLabel);
        contentPanel.add(typeField);
        contentPanel.add(garmentSizeLabel);
        contentPanel.add(garmentSizeField);
        contentPanel.add(garmentDirtyStateLabel);
        garmentDirtyStatePanel.add(garmentIsClean);
        garmentDirtyStatePanel.add(garmentIsDirty);
        contentPanel.add(garmentDirtyStatePanel);
        contentPanel.add(descriptionLabel);
        contentPanel.add(description);
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
            boolean savedDirtyState = true;
            if (garmentIsClean.isSelected() == true){
                savedDirtyState = false;
            }
            
            try{
                BufferedImage garmentBuffImage = ImageIO.read(new File(garmentImageField.getText()));
                garmentImage =new ImageIcon(garmentBuffImage);        
            }
            catch (IOException ex){
                System.out.println("error in addnewgarmentui");
            }
            
            theGarmentTableModel.addGarment(titleField.getText(), garmentImage, garmentSizeField.getText(), savedDirtyState, description.getText(), typeField.getText());
            theWardrobeCntl.getWardrobeUI();
        }
    }
    
    
}
