package fashionforecast;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import javax.swing.event.*;

public class WardrobeUI extends JFrame{
    WardrobeCntl theWardrobeCntl;
    GarmentTableModel theGarmentTableModel;
    OutfitTableSimpleModel theOutfitTableSimpleModel;
    JPanel titlePanel;
    JPanel mainPanel;
    JPanel bodyPanel;
    JPanel bottomPanel;
    JScrollPane scrollPane;
    JTable wardrobeTable;
    String[] columnNames = {"Name", "Image"};
    JButton homeButton;
    JButton addNewButton;
    JButton outfitButton;
    JButton garmentButton;
    boolean garmentIsShown;
    
    
    public WardrobeUI(WardrobeCntl parentWardrobeCntl){
        theWardrobeCntl = parentWardrobeCntl;
        theGarmentTableModel = theWardrobeCntl.getTheGarmentTableModel();
        theOutfitTableSimpleModel = theWardrobeCntl.getTheOutfitTableSimpleModel();
        setTitle("Wardrobe : Garment");
        setBounds(100, 100, 600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
    }
    
    public void initComponents(){
        theGarmentTableModel.addTableModelListener(new TableListener());
        titlePanel = new JPanel();
        mainPanel = new JPanel();
        bodyPanel = new JPanel();
        bottomPanel = new JPanel();
        wardrobeTable = new JTable(theGarmentTableModel);
        garmentIsShown = true;
        scrollPane = new JScrollPane(wardrobeTable);
        wardrobeTable.setFillsViewportHeight(true);
        wardrobeTable.setRowHeight(110);
        wardrobeTable.getColumnModel().getColumn(1).setCellRenderer(wardrobeTable.getDefaultRenderer(ImageIcon.class));
        wardrobeTable.addMouseListener(new TableMouseListener());
        
        homeButton = new JButton("Home");
        homeButton.addActionListener(new HomeButtonListener());
        addNewButton = new JButton("Add New Garment/Outfit");
        addNewButton.addActionListener(new AddNewButtonListener());
        
        outfitButton = new JButton("Outfits");
        outfitButton.setPreferredSize(new Dimension(100, 20));
        outfitButton.addActionListener(new OutfitButtonListener());
        garmentButton = new JButton("Garments");
        garmentButton.setPreferredSize(new Dimension(100, 20));
        garmentButton.addActionListener(new GarmentButtonListener());
        
        GridLayout theTitleLayout = new GridLayout(0, 2);
        BorderLayout theBodyLayout = new BorderLayout();
        BorderLayout theMainLayout = new BorderLayout();
        GridLayout theBottomLayout = new GridLayout(0, 2);
        
        titlePanel.setLayout(theTitleLayout);
        bodyPanel.setLayout(theBodyLayout);
        mainPanel.setLayout(theMainLayout);
        bottomPanel.setLayout(theBottomLayout);
                    
        titlePanel.add(outfitButton);
        titlePanel.add(garmentButton);
        bodyPanel.add(titlePanel, theBodyLayout.NORTH);
        bodyPanel.add(scrollPane, theBodyLayout.CENTER);
        bottomPanel.add(homeButton);
        bottomPanel.add(addNewButton);
        mainPanel.add(bodyPanel, theMainLayout.CENTER);
        mainPanel.add(bottomPanel, theMainLayout.SOUTH);
        this.add(mainPanel);
        setVisible(true);
    }
   
    public class HomeButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            setVisible(false);
            theWardrobeCntl.goHome();
        }
    }
    
    public class AddNewButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            setVisible(false);
            if (wardrobeTable.getModel() == theGarmentTableModel){
                theWardrobeCntl.getAddNewGarmentUI();
            }
            else if (wardrobeTable.getModel() == theOutfitTableSimpleModel){
                theWardrobeCntl.getAddNewOutfitUI();
            }
        }
    }
    
    public class OutfitButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if (garmentIsShown == true){
                wardrobeTable.setModel(theOutfitTableSimpleModel);
                setTitle("Wardrobe : Outfits");
                garmentIsShown = false;
            }
        }
    }
    
    public class GarmentButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if (garmentIsShown == false){
                wardrobeTable.setModel(theGarmentTableModel);
                setTitle("Wardrobe : Garments");
                garmentIsShown = true;
            }
        }
    }
    
    //listener for changed table content
    public class TableListener implements TableModelListener{
        public void tableChanged(TableModelEvent e){
            WardrobeUI.this.setVisible(false);
        }
    }
    
    public class TableMouseListener implements MouseListener{
        public void mousePressed(MouseEvent e) {
        }

        public void mouseReleased(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {
        }

        public void mouseExited(MouseEvent e) {
        }
        
        public void mouseClicked(java.awt.event.MouseEvent event) {
            if (wardrobeTable.getModel() == theGarmentTableModel){
                int row = wardrobeTable.rowAtPoint(event.getPoint());
                int col = wardrobeTable.columnAtPoint(event.getPoint());
                if (row != -1){
                    theWardrobeCntl.getWardrobeGarmentDetailUI(row);
                    setVisible(false);
                }
            }
            
            else if (wardrobeTable.getModel() == theOutfitTableSimpleModel){
                int row = wardrobeTable.rowAtPoint(event.getPoint());
                int col = wardrobeTable.columnAtPoint(event.getPoint());
                if (row != -1){
                    theWardrobeCntl.getWardrobeOutfitDetailUI(row);
                    setVisible(false);
                }
            }
        }
    }
}
