
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
public class OutfitTableModel extends AbstractTableModel implements Serializable{
    
    private String[] columnNames = {"Name", "Shirt", "Pants","Coat", "Shoes", "Formality"};
    WardrobeCntl theWardrobeCntl;
    OutfitTable theOutfitTable;
    private ArrayList<Outfit> outfitTableData = new ArrayList<Outfit>();
    private GarmentTableModel theGarmentTableModel;

    public OutfitTableModel(WardrobeCntl passedWardrobeCntl, GarmentTableModel passedGarmentTableModel){
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
                objectToReturn = this.outfitTableData.get(row).getShirt();
                break;
            case 2:
                objectToReturn = this.outfitTableData.get(row).getPants();
                break;
            case 3:
                objectToReturn = this.outfitTableData.get(row).getCoat();
                break;
            case 4:
                objectToReturn = this.outfitTableData.get(row).getShoes();
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
    
    
    public void removeValueAt(int outfitId){
        outfitTableData.remove(outfitId); 
        this.theOutfitTable.writeOutfitTableData(outfitTableData);
        fireTableDataChanged();
    }
    
    public void addOutfit(String passedName, Garment passedShirt, Garment passedPants, Garment passedCoat, Garment passedShoes, String passedFormality){
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
