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
        theMainMenuCntl.getMainMenuUI();
    }
    
    
    public Garment[] getRecommendation(){
        try{
            Garment[] recommendationReturn = new Garment[4];
            String temp = getTemperature();
            String precip = getPrecipitation();
            boolean shirtSentinal = true;
            boolean pantsSentinal = true;
            boolean coatSentinal = true;
            boolean shoesSentinal = true;
            int length = theMainMenuCntl.getUserList().getGarmentTable(userIndex).size();
            for (int i = 0; i<length; i++){
                //shirt
                if (shirtSentinal == true){
                    if (theMainMenuCntl.getUserList().getGarmentTable(userIndex).get(i).getGarmentType().equals("shirt")){
                        if (theMainMenuCntl.getUserList().getGarmentTable(userIndex).get(i).getGarmentPrecipitation().equals(precip)){
                            if (theMainMenuCntl.getUserList().getGarmentTable(userIndex).get(i).getGarmentTemperature().equals(temp)){
                                recommendationReturn[0] = theMainMenuCntl.getUserList().getGarmentTable(userIndex).get(i);
                                shirtSentinal = false;
                            }
                        }
                    }
                }

                //pants
                if (pantsSentinal == true){
                    if (theMainMenuCntl.getUserList().getGarmentTable(userIndex).get(i).getGarmentType().equals("pants")){
                        if (theMainMenuCntl.getUserList().getGarmentTable(userIndex).get(i).getGarmentPrecipitation().equals(precip)){
                            if (theMainMenuCntl.getUserList().getGarmentTable(userIndex).get(i).getGarmentTemperature().equals(temp)){
                                recommendationReturn[1] = theMainMenuCntl.getUserList().getGarmentTable(userIndex).get(i);
                                pantsSentinal = false;
                            }
                        }
                    }
                }

                //coat
                if (coatSentinal == true){
                    if (theMainMenuCntl.getUserList().getGarmentTable(userIndex).get(i).getGarmentType().equals("coat")){
                        if (theMainMenuCntl.getUserList().getGarmentTable(userIndex).get(i).getGarmentPrecipitation().equals(precip)){
                            if (theMainMenuCntl.getUserList().getGarmentTable(userIndex).get(i).getGarmentTemperature().equals(temp)){
                                recommendationReturn[2] = theMainMenuCntl.getUserList().getGarmentTable(userIndex).get(i);
                                coatSentinal = false;
                            }
                        }
                    }
                }

                //shoes
                if (shoesSentinal == true){
                    if (theMainMenuCntl.getUserList().getGarmentTable(userIndex).get(i).getGarmentType().equals("shoes")){
                        if (theMainMenuCntl.getUserList().getGarmentTable(userIndex).get(i).getGarmentPrecipitation().equals(precip)){
                            if (theMainMenuCntl.getUserList().getGarmentTable(userIndex).get(i).getGarmentTemperature().equals(temp)){
                                recommendationReturn[3] = theMainMenuCntl.getUserList().getGarmentTable(userIndex).get(i);
                                shoesSentinal = false;
                            }
                        }
                    }
                }

            }
            
            if (shirtSentinal == true){
                recommendationReturn[0] = theMainMenuCntl.getUserList().getGarmentTable(userIndex).get(0);
                System.out.println("shirt default recommended");
            }
            if (pantsSentinal == true){
                recommendationReturn[1] = theMainMenuCntl.getUserList().getGarmentTable(userIndex).get(1);
                System.out.println("pants default recommended");
            }
            if (coatSentinal == true){
                recommendationReturn[2] = theMainMenuCntl.getUserList().getGarmentTable(userIndex).get(2);
                System.out.println("coat default recommended");
            }
            if (shoesSentinal == true){
                recommendationReturn[3] = theMainMenuCntl.getUserList().getGarmentTable(userIndex).get(3);
                System.out.println("shoes default recommended");
            }
                
            return recommendationReturn;
        }
        catch (IndexOutOfBoundsException ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    public String getTemperature(){
        String returnTemp;
        int temperature = (int)(Math.random()*70+50);
        System.out.println(temperature);
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
        int precipitationValue = (int)(Math.random()*3);
        String precipitation = "none";
        switch (precipitationValue){
            case 0:
                precipitation = "none";
                break;
            case 1:
                precipitation = "rain";
                break;
            case 2:
                precipitation = "snow";
                break;
        }
        return precipitation;
    }
}
