
package fashionforecast;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.Serializable;



public class Outfit implements printable, exportable, Serializable{
    String outfitName;
    Garment shirt;
    Garment pants;
    Garment coat;
    Garment shoes;
    String formality;
    
    public Outfit(String name, Garment passedShirt, Garment passedPants, Garment passedCoat, Garment passedShoes, String passedFormality){
        outfitName = name;
        shirt = passedShirt;
        pants = passedPants;
        coat = passedCoat;
        shoes = passedShoes;
        formality = passedFormality;                                   
    }
    
    public String getOutfitName(){
        return outfitName;
    }
    public Garment getShirt(){
        return shirt;
    }
    public Garment getPants(){
        return pants;
    }
    public Garment getCoat(){
        return coat;
    }
    public Garment getShoes(){
        return shoes;
    }
    public String getFormality(){
        return formality;
    }

    @Override
    public void print() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void previewPrint() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void export() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setFileType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
