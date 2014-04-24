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
            Outfit recommendedOutfit = theMainMenuCntl.getUserList().getOutfitTable(userIndex).get(0);
            Garment[] recommendationReturn = new Garment[4];
            recommendationReturn[0] = recommendedOutfit.getShirt();
            recommendationReturn[1] = recommendedOutfit.getPants();
            recommendationReturn[2] = recommendedOutfit.getCoat();
            recommendationReturn[3] = recommendedOutfit.getShoes();

            return recommendationReturn;
        }
        catch (IndexOutOfBoundsException ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
