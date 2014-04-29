

package fashionforecast;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.Serializable;



public class Garment implements printable, exportable, Serializable{
    String garmentName;
    ImageIcon garmentImage;
    boolean garmentIsDirty;
    String garmentSize;
    String garmentDescription;
    String garmentType;
    boolean garmentPrecipitation; //true for precipitation, false for no precipitation
    boolean garmentTemperature; //true for cold, false for hot
    
    public Garment(String name, ImageIcon image, String size, boolean isDirty, String description, String type, boolean precipitation, boolean temperature){
        garmentName = name;
        garmentImage = image;
        garmentIsDirty = isDirty;
        garmentSize = size;
        garmentDescription = description;
        garmentType = type;
        garmentPrecipitation = precipitation;
        garmentTemperature = temperature;
    }
    
    public String getGarmentName(){
        return garmentName;
    }
    public ImageIcon getGarmentImage(){
        return garmentImage;
    }
    public String getGarmentSize(){
        return garmentSize;
    }
    public boolean getGarmentDirtyState(){
        return garmentIsDirty;
    }
    public String getGarmentDescription(){
        return garmentDescription;
    }
    public String getGarmentType(){
        return garmentType;
    }
    public boolean getGarmentPrecipitation(){
        return garmentPrecipitation;
    }
    public boolean getGarmentTemperature(){
        return garmentTemperature;
    }
    
    //content written for submission
    public void takeOff(){
        
    }
    
    //content written in class. Not being included in the submission
    private boolean isDirty = true;
    
    public void store(){
        
    }
    
    public void don(){
        
    }
    
    public void setIsDirty(boolean newDirtyState){
        this.isDirty = newDirtyState;
    
    }
    
    @Override
    public void previewPrint(){
        
    }
    
    @Override
    public void print(){
        
    }
    
    @Override
    public void setFileType(){
        
    }
    
    @Override
    public void export(){
        
    }
       
}
