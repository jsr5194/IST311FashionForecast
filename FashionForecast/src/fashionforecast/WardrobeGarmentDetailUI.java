
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
    JPanel precipitationPanel;
    JPanel temperaturePanel;
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
    JLabel precipitationLabel;
    JComboBox precipitationDropdown;
    JLabel temperatureLabel;
    JComboBox temperatureDropdown;
    ButtonGroup garmentButtonGroup;
    JTextArea description;
    JButton saveButton;
    JButton cancelButton;
    JButton deleteButton;
    
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
        precipitationPanel = new JPanel();
        temperaturePanel = new JPanel();
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
        
        precipitationLabel = new JLabel("Made For Precipitation: ");
        String[] precipitationOptions = {"Yes", "No"};
        precipitationDropdown = new JComboBox(precipitationOptions);
        boolean precipitationCheck = (boolean)theGarmentTableModel.getValueAt(currentGarmentIndex, 6);
        if (precipitationCheck == true){
            precipitationDropdown.setSelectedItem("Yes");
        }
        else{
            precipitationDropdown.setSelectedItem("No");
        }
        
        temperatureLabel = new JLabel("Suggested Temperature: ");
        String[] temperatureOptions = {"Hot", "Cold"};
        temperatureDropdown = new JComboBox(temperatureOptions);
        boolean temperatureCheck = (boolean)theGarmentTableModel.getValueAt(currentGarmentIndex, 7);
        if (temperatureCheck == true){
            temperatureDropdown.setSelectedItem("Cold");
        }
        else{
            temperatureDropdown.setSelectedItem("Hot");
        }
        
        description = new JTextArea(theGarmentTableModel.getValueAt(currentGarmentIndex, 4).toString());
        
        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new CancelButtonListener());
        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new DeleteButtonListener());
        saveButton = new JButton("Save");
        saveButton.addActionListener(new SaveButtonListener());
        
        BorderLayout mainLayout = new BorderLayout();
        GridLayout attributesLayout = new GridLayout(0, 1);
        GridLayout contentLayout = new GridLayout(0, 2);
        GridLayout buttonsLayout = new GridLayout(0, 3);
        
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
        precipitationPanel.add(precipitationLabel);
        precipitationPanel.add(precipitationDropdown);
        temperaturePanel.add(temperatureLabel);
        temperaturePanel.add(temperatureDropdown);
        attributesPanel.add(titlePanel);
        attributesPanel.add(typePanel);
        attributesPanel.add(garmentSizePanel);
        attributesPanel.add(garmentDirtyStatePanel);
        attributesPanel.add(precipitationPanel);
        attributesPanel.add(temperaturePanel);
        attributesPanel.add(description);
        contentPanel.add(garmentImageLabel);
        contentPanel.add(attributesPanel);
        buttonsPanel.add(cancelButton);
        buttonsPanel.add(deleteButton);
        buttonsPanel.add(saveButton);
        mainPanel.add(contentPanel, mainLayout.CENTER);
        mainPanel.add(buttonsPanel, mainLayout.SOUTH);
        this.add(mainPanel);
        setVisible(true);
        
        
        
    }
    
    
    public class CancelButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            setVisible(false);
            theWardrobeCntl.getWardrobeUI(true);
        }
    }
    
    public class DeleteButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int deleteChoice = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete this garment?", "Delete Garment", JOptionPane.YES_NO_OPTION);
            if (deleteChoice == JOptionPane.YES_OPTION){
                if (currentGarmentIndex != 0){
                    setVisible(false);
                    theGarmentTableModel.removeValueAt(currentGarmentIndex);
                    theWardrobeCntl.getWardrobeUI(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "You cannot delete this outfit.");
                }
            }
        }
    }
    
    public class SaveButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            setVisible(false);
            boolean savedDirtyState = true;
            if (garmentIsClean.isSelected() == true){
                savedDirtyState = false;
            }
            
            boolean precipitation;
            if (precipitationDropdown.getSelectedItem() == "Yes"){
                precipitation = true;
            }
            else{
                precipitation = false;
            }
            
            boolean temperature;
            if (temperatureDropdown.getSelectedItem() == "Cold"){
                temperature = true;
            }
            else{
                temperature = false;
            }
            
            theGarmentTableModel.saveEditedGarment(currentGarmentIndex, titleField.getText(), garmentImage, garmentSizeField.getText(), savedDirtyState, description.getText(), typeField.getText(), precipitation, temperature);
            theWardrobeCntl.getWardrobeUI(true);
        }
    }
    
    
}
