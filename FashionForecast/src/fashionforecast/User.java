package fashionforecast;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class User implements Serializable{
    private String userName;
    private String password;
    private ArrayList<Garment> theGarmentTable;
    private ArrayList<Outfit> theOutfitTable;
    
    public User(String theUserName, String thePassword, ArrayList<Garment> passedGarmentTable, ArrayList<Outfit> passedOutfitTable){
        userName = theUserName;
        password = thePassword;
        theGarmentTable = passedGarmentTable;
        theOutfitTable = passedOutfitTable;
        
    }
    
    
    public void setUserName(String theUserName){
        userName = theUserName;
    }
    
    public void setPassword(String thePassword){
        password = thePassword;
    }
    
    public void setGarmentTable(ArrayList<Garment> passedGarmentTable){
        theGarmentTable = passedGarmentTable;
    }
    
    public void setOutfitTable(ArrayList<Outfit> passedOutfitTable){
        theOutfitTable = passedOutfitTable;
    }
    
    public String getUserName(){
        return userName;
    }
    
    public String getPassword(){
        return password;
    }
    
    public ArrayList<Garment> getGarmentTable(){
        return theGarmentTable;
    }
    
    public ArrayList<Outfit> getOutfitTable(){
        return theOutfitTable;
    }

}
