
package fashionforecast;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import javax.swing.event.*;


public class WardrobeGarmentDetailUI extends JFrame{
    WardrobeCntl theWardrobeCntl;
    GarmentTableModel theGarmentTableModel;
    int currentGarmentIndex;
    
    JPanel contentPanel;
    JPanel attributesPanel;
    JPanel titlePanel;
    JPanel typePanel;
    JPanel garmentSizePanel;
    JPanel garmentDirtyStatePanel;
    JPanel mainPanel;
    JPanel buttonsPanel;
    
    JLabel titleLabel;
    JTextField titleField;
    JLabel typeLabel;
    JTextField typeField;
    ImageIcon garmentImage;
    JLabel garmentImageLabel;
    JLabel garmentSizeLabel;
    JTextField garmentSizeField;
    JRadioButton garmentIsDirty;
    JRadioButton garmentIsClean;
    ButtonGroup garmentButtonGroup;
    JTextArea description;
    JButton saveButton;
    JButton cancelButton;
    
    public WardrobeGarmentDetailUI(WardrobeCntl passedWardrobeCntl, GarmentTableModel passedGarmentTableModel, int passedGarmentIndex){
        theWardrobeCntl = passedWardrobeCntl;
        theGarmentTableModel = passedGarmentTableModel;
        currentGarmentIndex = passedGarmentIndex;
        setTitle("Wardrobe : Garment Detail");
        setBounds(100, 100, 600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
    }
    
    public void initComponents(){
        contentPanel = new JPanel();
        attributesPanel = new JPanel();
        titlePanel = new JPanel();
        typePanel = new JPanel();
        garmentSizePanel = new JPanel();
        garmentDirtyStatePanel = new JPanel();
        buttonsPanel = new JPanel();
        mainPanel = new JPanel();
        
        titleLabel = new JLabel("Title: ");
        titleField = new JTextField(theGarmentTableModel.getValueAt(currentGarmentIndex,0).toString());
        typeLabel = new JLabel("Type: ");
        typeField = new JTextField(theGarmentTableModel.getValueAt(currentGarmentIndex, 5).toString());
        garmentImage = (ImageIcon)theGarmentTableModel.getValueAt(currentGarmentIndex, 1);
        garmentImageLabel = new JLabel(garmentImage);
        garmentSizeLabel = new JLabel("Size: ");
        garmentSizeField = new JTextField(theGarmentTableModel.getValueAt(currentGarmentIndex,2).toString());
        garmentButtonGroup = new ButtonGroup();
        garmentIsDirty = new JRadioButton();
        garmentIsClean = new JRadioButton();
        boolean isDirtyState = (boolean)theGarmentTableModel.getValueAt(currentGarmentIndex,3);
        if (isDirtyState == false){
            garmentIsDirty.setText("Dirty");
            garmentIsClean.setText("Clean");
            garmentIsClean.setSelected(true);
        }
        else{
            garmentIsDirty.setText("Dirty");
            garmentIsClean.setText("Clean");
            garmentIsDirty.setSelected(true);
        }
        
        garmentButtonGroup.add(garmentIsDirty);
        garmentButtonGroup.add(garmentIsClean);
        
        description = new JTextArea(theGarmentTableModel.getValueAt(currentGarmentIndex, 4).toString());
        
        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new CancelButtonListener());
        saveButton = new JButton("Save");
        saveButton.addActionListener(new SaveButtonListener());
        
        BorderLayout mainLayout = new BorderLayout();
        GridLayout attributesLayout = new GridLayout(0, 1);
        GridLayout contentLayout = new GridLayout(0, 2);
        GridLayout buttonsLayout = new GridLayout(0, 2);
        
        mainPanel.setLayout(mainLayout);
        attributesPanel.setLayout(attributesLayout);
        contentPanel.setLayout(contentLayout);
        buttonsPanel.setLayout(buttonsLayout);
        
        titlePanel.add(titleLabel);
        titlePanel.add(titleField);
        typePanel.add(typeLabel);
        typePanel.add(typeField);
        garmentSizePanel.add(garmentSizeLabel);
        garmentSizePanel.add(garmentSizeField);
        garmentDirtyStatePanel.add(garmentIsDirty);
        garmentDirtyStatePanel.add(garmentIsClean);
        attributesPanel.add(titlePanel);
        attributesPanel.add(typePanel);
        attributesPanel.add(garmentSizePanel);
        attributesPanel.add(garmentDirtyStatePanel);
        attributesPanel.add(description);
        contentPanel.add(garmentImageLabel);
        contentPanel.add(attributesPanel);
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
            
            theGarmentTableModel.saveEditedGarment(currentGarmentIndex, titleField.getText(), garmentImage, garmentSizeField.getText(), savedDirtyState, description.getText(), typeField.getText());
            theWardrobeCntl.getWardrobeUI();
        }
    }
    
    
}
