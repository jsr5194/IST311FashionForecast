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
public class OutfitTable implements Serializable{
   
    private WardrobeCntl theWardrobeCntl;
    private ArrayList<Outfit> outfitData = new ArrayList<Outfit>();
    
    public OutfitTable(WardrobeCntl passedWardrobeCntl){
        theWardrobeCntl = passedWardrobeCntl;
    }
    
    public ArrayList<Outfit> readOutfitTableData(){
        int currentUserIndex = theWardrobeCntl.getMainMenuCntl().getUserList().getUserIndex();
        User currentUser = theWardrobeCntl.getMainMenuCntl().getUserList().getUser(currentUserIndex);
        this.outfitData = currentUser.getOutfitTable();
        if (!(currentUser.getOutfitTable().equals(new ArrayList<Outfit>()))){
            this.outfitData = currentUser.getOutfitTable();
        }
        else{
            System.out.println("outfittable: test");
        }
                
        return this.outfitData;
        
        
    }
    
    public void writeOutfitTableData(ArrayList<Outfit> passedOutfitData){
        this.outfitData = passedOutfitData;
        int currentUserIndex = theWardrobeCntl.getMainMenuCntl().getUserList().getUserIndex();
        User currentUser = theWardrobeCntl.getMainMenuCntl().getUserList().getUser(currentUserIndex);
        currentUser.setOutfitTable(this.outfitData);
        theWardrobeCntl.getMainMenuCntl().getUserList().updateUserList(currentUser);
        theWardrobeCntl.getMainMenuCntl().getUserList().writeUserList();
        currentUser.setOutfitTable(readOutfitTableData());
    }
    
}
