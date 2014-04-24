
package fashionforecast;

import javax.swing.table.*;
import java.util.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;


/**
 *
 * @author jsr5194
 */
public class OutfitTableSimpleModel extends AbstractTableModel implements Serializable{
    
    private String[] columnNames = {"Name", "Shirt", "Pants","Coat", "Shoes", "Formality"};
    WardrobeCntl theWardrobeCntl;
    OutfitTable theOutfitTable;
    private ArrayList<Outfit> outfitTableData = new ArrayList<Outfit>();
    private GarmentTableModel theGarmentTableModel;

    public OutfitTableSimpleModel(WardrobeCntl passedWardrobeCntl, GarmentTableModel passedGarmentTableModel){
        theWardrobeCntl = passedWardrobeCntl;
        theOutfitTable = new OutfitTable(theWardrobeCntl);
        theGarmentTableModel = passedGarmentTableModel;
        //buildTestOutfitTable();
        this.outfitTableData = this.theOutfitTable.readOutfitTableData();
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return this.outfitTableData.size();
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        Object objectToReturn = new Object();
        
        switch(col){
            case 0:
                objectToReturn = this.outfitTableData.get(row).getOutfitName();
                break;
            case 1:
                objectToReturn = this.outfitTableData.get(row).getShirt().getGarmentImage();
                break;
            case 2:
                objectToReturn = this.outfitTableData.get(row).getPants().getGarmentImage();
                break;
            case 3:
                objectToReturn = this.outfitTableData.get(row).getCoat().getGarmentImage();
                break;
            case 4:
                objectToReturn = this.outfitTableData.get(row).getShoes().getGarmentImage();
                break;
            case 5:
                objectToReturn = this.outfitTableData.get(row).getFormality();
                break;
        }
        return objectToReturn;
        
    }

    public Class getColumnClass(int c){
        return getValueAt(0, c).getClass();
    }

    /*
     * Don't need to implement this method unless your table's
     * editable.
     */
    public boolean isCellEditable(int row, int col) {
        //Note that the data/cell address is constant,
        //no matter where the cell appears onscreen.
        if (col < 2) {
            return false;
        } else {
            return true;
        }
    }
    
    /*
     * Don't need to implement this method unless your table's
     * data can change.
     
    public void setValueAt(Object value, int row, int col) {
        data[row][col] = value;
        fireTableCellUpdated(row, col);
    }
    * */
    
    
    public void buildTestOutfitTable(){
        for(int i = 0; i < 10; i++){
            String formality = "casual";
            
            try{
                BufferedImage shirtBuffImg = ImageIO.read(new File("/Users/unkn0wn/NetBeansProjects/FashionForecast/src/fashionforecast/shirt.jpg"));
                ImageIcon shirtImg =new ImageIcon(shirtBuffImg);
                Garment shirt = new Garment("myshirt", shirtImg, "Large", false, "stuff here", "shirt");
                BufferedImage pantsBuffImg = ImageIO.read(new File("/Users/unkn0wn/NetBeansProjects/FashionForecast/src/fashionforecast/pants.jpg"));
                ImageIcon pantsImg =new ImageIcon(pantsBuffImg);
                Garment pants = new Garment("mypants", pantsImg, "Large", false, "stuff here", "pants");
                BufferedImage coatBuffImg = ImageIO.read(new File("/Users/unkn0wn/NetBeansProjects/FashionForecast/src/fashionforecast/coat.jpg"));
                ImageIcon coatImg =new ImageIcon(coatBuffImg);
                Garment coat = new Garment("mycoat", coatImg, "Large", false, "stuff here", "coat");
                BufferedImage shoesBuffImg = ImageIO.read(new File("/Users/unkn0wn/NetBeansProjects/FashionForecast/src/fashionforecast/shoes.jpg"));
                ImageIcon shoesImg =new ImageIcon(shoesBuffImg);
                Garment shoes = new Garment("myshoes", shoesImg, "Large", false, "stuff here", "shoes");

                Outfit newOutfit = new Outfit("test", shirt, pants, coat, shoes, formality);
                //do not uncomment the below line unless writing the test outfits
                //addOutfit(i,"test", shirt, pants, coat, shoes, formality);
                outfitTableData.add(newOutfit);
            
            }
            catch (IOException e){
                
            }
                    
        }
    }
    
    public void removeValueAt(int outfitId){
        outfitTableData.remove(outfitId); 
        this.theOutfitTable.writeOutfitTableData(outfitTableData);
        fireTableDataChanged();
    }
    
    public void addOutfit(int passedId, String passedName, Garment passedShirt, Garment passedPants, Garment passedCoat, Garment passedShoes, String passedFormality){
        Outfit newOutfit = new Outfit(passedName, passedShirt, passedPants, passedCoat, passedShoes, passedFormality);
        outfitTableData.add(newOutfit);
        this.theOutfitTable.writeOutfitTableData(outfitTableData);
        fireTableDataChanged();
    }
    
    public String[] getContentsAt(int outfitId){
        String[] arrayToReturn = new String[3];
        arrayToReturn[0] = (this.getValueAt(outfitId, 1).toString());
        arrayToReturn[1] = (this.getValueAt(outfitId, 2).toString());
        arrayToReturn[2] = (this.getValueAt(outfitId, 3).toString());
        return arrayToReturn;
    }
    
    public void saveEditedOutfit(int passedId, String passedName, Garment passedShirt, Garment passedPants, Garment passedCoat, Garment passedShoes, String passedFormality){
        Outfit newOutfit = new Outfit(passedName, passedShirt, passedPants, passedCoat, passedShoes, passedFormality);
        outfitTableData.set(passedId, newOutfit);
        this.theOutfitTable.writeOutfitTableData(outfitTableData);
        fireTableDataChanged();
    }
}
