package fashionforecast;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class RecommendationCntl {
    int userIndex; 
    MainMenuCntl theMainMenuCntl;
    public RecommendationCntl(MainMenuCntl passedMainMenuCntl){
        theMainMenuCntl = passedMainMenuCntl;
        userIndex = theMainMenuCntl.getUserList().getUserIndex();
        RecommendationUI theRecommendationUI = new RecommendationUI(this);
        
    }
    
    public void getMainMenuCntl(){
        new MainMenuCntl(theMainMenuCntl.getUserList());
    }
    
    
    public Garment[] getRecommendation(){
        try{
            Garment[] recommendationReturn = new Garment[4];
            String temp = getTemperature();
            String precip = getPrecipitation();
            
            recommendationReturn[0] = theMainMenuCntl.getUserList().getOutfitTable(userIndex).get(0).getShirt();
            recommendationReturn[1] = theMainMenuCntl.getUserList().getOutfitTable(userIndex).get(0).getPants();
            recommendationReturn[2] = theMainMenuCntl.getUserList().getOutfitTable(userIndex).get(0).getCoat();
            recommendationReturn[3] = theMainMenuCntl.getUserList().getOutfitTable(userIndex).get(0).getShoes();

            return recommendationReturn;
        }
        catch (IndexOutOfBoundsException ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    public String getTemperature(){
        String returnTemp;
        int temperature = 70;
        if (temperature < 65){
            returnTemp = "cold";
        }
        
        else if (temperature >= 65 && temperature < 80){
            returnTemp = "warm";
        }
        
        else{
            returnTemp = "hot";
        }
        return returnTemp;
    }
    
    public String getPrecipitation(){
        String precipitation = "none";
        return precipitation;
    }
}
