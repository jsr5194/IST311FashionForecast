
package fashionforecast;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import javax.swing.event.*;


public class WardrobeOutfitDetailUI extends JFrame{
    WardrobeCntl theWardrobeCntl;
    OutfitTableModel theOutfitTableModel;
    int currentOutfitIndex;
    
    JPanel mainPanel;
    JPanel contentPanel;
    JPanel topPanel;
    JPanel titlePanel;
    JPanel formalityPanel;
    JPanel shirtPanel;
    JPanel shirtAttributesPanel;
    JPanel pantsPanel;
    JPanel pantsAttributesPanel;
    JPanel coatPanel;
    JPanel coatAttributesPanel;
    JPanel shoesPanel;
    JPanel shoesAttributesPanel;
    JPanel buttonsPanel;
    
    Garment shirt;
    Garment pants;
    Garment coat;
    Garment shoes;
    
    String shirtType;
    String pantsType;
    String coatType;
    String shoesType;
    
    JLabel titleLabel;
    JTextField titleField;
    JLabel formalityLabel;
    JTextField formalityField;
    JLabel shirtImage;
    JLabel shirtNameLabel;
    JLabel shirtSizeLabel;
    JLabel shirtIsDirtyLabel;
    JLabel pantsImage;
    JLabel pantsNameLabel;
    JLabel pantsSizeLabel;
    JLabel pantsIsDirtyLabel;
    JLabel coatImage;
    JLabel coatNameLabel;
    JLabel coatSizeLabel;
    JLabel coatIsDirtyLabel;
    JLabel shoesImage;
    JLabel shoesNameLabel;
    JLabel shoesSizeLabel;
    JLabel shoesIsDirtyLabel;
    
    JButton saveButton;
    JButton cancelButton;
    
    public WardrobeOutfitDetailUI(WardrobeCntl passedWardrobeCntl, OutfitTableModel passedOutfitTableModel, int passedOutfitIndex){
        theWardrobeCntl = passedWardrobeCntl;
        theOutfitTableModel = passedOutfitTableModel;
        currentOutfitIndex = passedOutfitIndex;
        setTitle("Wardrobe : Outfit Detail");
        setBounds(100, 100, 600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
    }
    
    public void initComponents(){
        shirt = (Garment)theOutfitTableModel.getValueAt(currentOutfitIndex, 1);
        pants = (Garment)theOutfitTableModel.getValueAt(currentOutfitIndex, 2);
        coat = (Garment)theOutfitTableModel.getValueAt(currentOutfitIndex, 3);
        shoes = (Garment)theOutfitTableModel.getValueAt(currentOutfitIndex, 4);
        
        String shirtDirtyState = "Dirty";
        if(shirt.getGarmentDirtyState() == false){
            shirtDirtyState = "Clean";
        }
        
        String pantsDirtyState = "Dirty";
        if(pants.getGarmentDirtyState() == false){
            pantsDirtyState = "Clean";
        }
        
        String coatDirtyState = "Dirty";
        if(coat.getGarmentDirtyState() == false){
            coatDirtyState = "Clean";
        }
        
        String shoesDirtyState = "Dirty";
        if(shoes.getGarmentDirtyState() == false){
            shoesDirtyState = "Clean";
        }
        
        titlePanel = new JPanel();
        formalityPanel = new JPanel();
        
        buttonsPanel = new JPanel();
        shirtPanel = new JPanel();
        shirtAttributesPanel = new JPanel();
        pantsPanel = new JPanel();
        pantsAttributesPanel = new JPanel();
        coatPanel = new JPanel();
        coatAttributesPanel = new JPanel();
        shoesPanel = new JPanel();
        shoesAttributesPanel = new JPanel();
        topPanel = new JPanel();
        contentPanel = new JPanel();
        mainPanel = new JPanel();
                
        titleLabel = new JLabel("Title: ");
        titleField = new JTextField(theOutfitTableModel.getValueAt(currentOutfitIndex, 0).toString());
        formalityLabel = new JLabel("Formality: ");
        formalityField = new JTextField(theOutfitTableModel.getValueAt(currentOutfitIndex, 5).toString());
        
        shirtImage = new JLabel(shirt.getGarmentImage());
        shirtNameLabel = new JLabel("Name: "+shirt.getGarmentName().toString());
        shirtSizeLabel = new JLabel("Size: "+shirt.getGarmentSize().toString());
        shirtIsDirtyLabel = new JLabel(shirtDirtyState);
        pantsImage = new JLabel(pants.getGarmentImage());
        pantsNameLabel = new JLabel("Name: "+pants.getGarmentName().toString());
        pantsSizeLabel = new JLabel("Size: "+pants.getGarmentSize().toString());
        pantsIsDirtyLabel = new JLabel(pantsDirtyState);
        coatImage = new JLabel(coat.getGarmentImage());
        coatNameLabel = new JLabel("Name: "+coat.getGarmentName().toString());
        coatSizeLabel = new JLabel("Size: "+coat.getGarmentSize().toString());
        coatIsDirtyLabel = new JLabel(coatDirtyState);
        shoesImage = new JLabel(shoes.getGarmentImage());
        shoesNameLabel = new JLabel("Name: "+shoes.getGarmentName().toString());
        shoesSizeLabel = new JLabel("Size: "+shoes.getGarmentSize().toString());
        shoesIsDirtyLabel = new JLabel(shoesDirtyState);
        
        
        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new CancelButtonListener());
        saveButton = new JButton("Save");
        saveButton.addActionListener(new SaveButtonListener());
        
        BorderLayout mainLayout = new BorderLayout();
        GridLayout contentLayout = new GridLayout(0,2);
        GridLayout topLayout = new GridLayout(0,2);
        GridLayout shirtLayout = new GridLayout(0,2);
        GridLayout shirtAttributesLayout = new GridLayout(0,1);
        GridLayout pantsLayout = new GridLayout(0,2);
        GridLayout pantsAttributesLayout = new GridLayout(0,1);
        GridLayout coatLayout = new GridLayout(0,2);
        GridLayout coatAttributesLayout = new GridLayout(0,1);
        GridLayout shoesLayout = new GridLayout(0,2);
        GridLayout shoesAttributesLayout = new GridLayout(0,1);
        
        mainPanel.setLayout(mainLayout);
        contentPanel.setLayout(contentLayout);
        topPanel.setLayout(topLayout);
        shirtPanel.setLayout(shirtLayout);
        shirtAttributesPanel.setLayout(shirtAttributesLayout);
        pantsPanel.setLayout(pantsLayout);
        pantsAttributesPanel.setLayout(pantsAttributesLayout);
        coatPanel.setLayout(coatLayout);
        coatAttributesPanel.setLayout(coatAttributesLayout);
        shoesPanel.setLayout(shoesLayout);
        shoesAttributesPanel.setLayout(shoesAttributesLayout);
        
        titlePanel.add(titleLabel);
        titlePanel.add(titleField);
        formalityPanel.add(formalityLabel);
        formalityPanel.add(formalityField);
        topPanel.add(titlePanel);
        topPanel.add(formalityPanel);
        
        shirtAttributesPanel.add(shirtNameLabel);
        shirtAttributesPanel.add(shirtSizeLabel);
        shirtAttributesPanel.add(shirtIsDirtyLabel);
        pantsAttributesPanel.add(pantsNameLabel);
        pantsAttributesPanel.add(pantsSizeLabel);
        pantsAttributesPanel.add(pantsIsDirtyLabel);
        coatAttributesPanel.add(coatNameLabel);
        coatAttributesPanel.add(coatSizeLabel);
        coatAttributesPanel.add(coatIsDirtyLabel);
        shoesAttributesPanel.add(shoesNameLabel);
        shoesAttributesPanel.add(shoesSizeLabel);
        shoesAttributesPanel.add(shoesIsDirtyLabel);

        shirtPanel.add(shirtImage);
        shirtPanel.add(shirtAttributesPanel);
        pantsPanel.add(pantsImage);
        pantsPanel.add(pantsAttributesPanel);
        coatPanel.add(coatImage);
        coatPanel.add(coatAttributesPanel);
        shoesPanel.add(shoesImage);
        shoesPanel.add(shoesAttributesPanel);
        
        contentPanel.add(shirtPanel);
        contentPanel.add(coatPanel);
        contentPanel.add(pantsPanel);
        contentPanel.add(shoesPanel);
        
        buttonsPanel.add(cancelButton);
        buttonsPanel.add(saveButton);
        
        mainPanel.add(topPanel, mainLayout.NORTH);
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
            
            //enter save info
            theOutfitTableModel.saveEditedOutfit(currentOutfitIndex, titleField.getText(), shirt, pants, coat, shoes, formalityField.getText());
            theWardrobeCntl.getWardrobeUI();
        }
    }
    
    
}
