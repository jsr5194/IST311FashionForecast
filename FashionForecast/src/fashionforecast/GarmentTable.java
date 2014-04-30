/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fashionforecast;

import java.awt.image.BufferedImage;
import java.util.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
/**
 *
 * @author jsr5194
 */
public class GarmentTable implements Serializable{
    private WardrobeCntl theWardrobeCntl;
    private ArrayList<Garment> garmentData;
    
    public GarmentTable(WardrobeCntl passedWardrobeCntl){
        theWardrobeCntl = passedWardrobeCntl;
    }
    
    public ArrayList<Garment> readGarmentTableData(){
        int currentUserIndex = theWardrobeCntl.getMainMenuCntl().getUserList().getUserIndex();
        User currentUser = theWardrobeCntl.getMainMenuCntl().getUserList().getUser(currentUserIndex);
        this.garmentData = currentUser.getGarmentTable();
                
        return this.garmentData;
        
    }
    
    public void writeGarmentTableData(ArrayList<Garment> passedGarmentData){
        this.garmentData = passedGarmentData;
        int currentUserIndex = theWardrobeCntl.getMainMenuCntl().getUserList().getUserIndex();
        User currentUser = theWardrobeCntl.getMainMenuCntl().getUserList().getUser(currentUserIndex);
        currentUser.setGarmentTable(this.garmentData);
        theWardrobeCntl.getMainMenuCntl().getUserList().updateUserList(currentUser);
        theWardrobeCntl.getMainMenuCntl().getUserList().writeUserList();
    }
    
}
