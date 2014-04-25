
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
public class GarmentTableModel extends AbstractTableModel implements Serializable{
    
    private String[] columnNames = {"Name", "Image"};
    WardrobeCntl theWardrobeCntl;
    GarmentTable theGarmentTable;
    private ArrayList<Garment> garmentTableData = new ArrayList<Garment>();

    public GarmentTableModel(WardrobeCntl passedWardrobeCntl){
        theWardrobeCntl = passedWardrobeCntl;
        theGarmentTable  = new GarmentTable(theWardrobeCntl);
        this.garmentTableData = this.theGarmentTable.readGarmentTableData();
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return garmentTableData.size();
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }
    
    public Object getValueAt(int row, int col) {
        Object objectToReturn = new Object();
        
        switch(col){
            case 0:
                objectToReturn = this.garmentTableData.get(row).getGarmentName();
                break;
            case 1:
                objectToReturn = this.garmentTableData.get(row).getGarmentImage();
                break;
            case 2:
                objectToReturn = this.garmentTableData.get(row).getGarmentSize();
                break;
            case 3:
                objectToReturn = this.garmentTableData.get(row).getGarmentDirtyState();
                break;
            case 4:
                objectToReturn = this.garmentTableData.get(row).getGarmentDescription();
                break;
            case 5:
                objectToReturn = this.garmentTableData.get(row).getGarmentType();
                break;
            case 6:
                objectToReturn = this.garmentTableData.get(row).getGarmentPrecipitation();
                break;
            case 7:
                objectToReturn = this.garmentTableData.get(row).getGarmentTemperature();
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
    
    
    
    public void removeValueAt(int garmentId){
        garmentTableData.remove(garmentId); 
        this.theGarmentTable.writeGarmentTableData(garmentTableData);
        fireTableDataChanged();
    }
    
    public void addGarment(String passedName, ImageIcon passedImage, String passedSize, boolean passedIsDirty, String passedDescription, String passedType, String passedPrecipitation, String passedTemperature){
        Garment newGarment = new Garment(passedName, passedImage, passedSize, passedIsDirty, passedDescription, passedType, passedPrecipitation, passedTemperature);
        garmentTableData.add(newGarment);
        this.theGarmentTable.writeGarmentTableData(garmentTableData);
        fireTableDataChanged();
    }
    
    public String[] getContentsAt(int garmentId){
        String[] arrayToReturn = new String[3];
        arrayToReturn[0] = (this.getValueAt(garmentId, 1).toString());
        arrayToReturn[1] = (this.getValueAt(garmentId, 2).toString());
        arrayToReturn[2] = (this.getValueAt(garmentId, 3).toString());
        return arrayToReturn;
    }
    
    public void saveEditedGarment(int passedId, String passedName, ImageIcon passedImage, String passedSize, boolean passedIsDirty, String passedDescription, String passedType, String passedPrecipitation, String passedTemperature){
        Garment newGarment = new Garment(passedName, passedImage, passedSize, passedIsDirty, passedDescription, passedType, passedPrecipitation, passedTemperature);
        garmentTableData.set(passedId, newGarment);
        this.theGarmentTable.writeGarmentTableData(garmentTableData);
        fireTableDataChanged();
    }
}
