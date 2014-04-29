package fashionforecast;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

public class RecommendationCntl {
    int userIndex; 
    String returnTemp;
    boolean temp;
    boolean precip;
    MainMenuCntl theMainMenuCntl;
    public RecommendationCntl(MainMenuCntl passedMainMenuCntl){
        theMainMenuCntl = passedMainMenuCntl;
        userIndex = theMainMenuCntl.getUserList().getUserIndex();
        RecommendationUI theRecommendationUI = new RecommendationUI(this);
        
    }
    
    public void getMainMenuCntl(){
        theMainMenuCntl.getMainMenuUI();
    }
    
    public MainMenuCntl returnMainMenuCntl(){
        return theMainMenuCntl;
    }
    
    public boolean getCurrentTemp(){
        return temp;
    }
    
    public boolean getCurrentPrecip(){
        return precip;
    }
    
    public Garment[] getRecommendation(){
        try{
            Garment[] recommendationReturn = new Garment[4];
            ArrayList<Garment> shirtOptions = new ArrayList<Garment>();
            temp = theMainMenuCntl.returnWeatherCntl().getTemperature();
            precip = theMainMenuCntl.returnWeatherCntl().getPrecipitation();
            boolean shirtSentinal = true;
            boolean pantsSentinal = true;
            boolean coatSentinal = true;
            boolean shoesSentinal = true;
            int length = theMainMenuCntl.getUserList().getGarmentTable(userIndex).size();
            for (int i = 0; i<length; i++){
                //shirt
                if (shirtSentinal == true){
                    if (theMainMenuCntl.getUserList().getGarmentTable(userIndex).get(i).getGarmentType().equals("Shirt")){
                        System.out.println(theMainMenuCntl.getUserList().getGarmentTable(userIndex).get(i).getGarmentName());
                       // if (theMainMenuCntl.getUserList().getGarmentTable(userIndex).get(i).getGarmentPrecipitation() == precip){
                            if (theMainMenuCntl.getUserList().getGarmentTable(userIndex).get(i).getGarmentTemperature() == temp){
                                //recommendationReturn[0] = theMainMenuCntl.getUserList().getGarmentTable(userIndex).get(i);
                                shirtOptions.add(theMainMenuCntl.getUserList().getGarmentTable(userIndex).get(i));
                                shirtSentinal = false;
                            }
                       // }
                    }
                }

                //pants
                if (pantsSentinal == true){
                    if (theMainMenuCntl.getUserList().getGarmentTable(userIndex).get(i).getGarmentType().equals("Pants")){
                       // if (theMainMenuCntl.getUserList().getGarmentTable(userIndex).get(i).getGarmentPrecipitation() == precip){
                            if (theMainMenuCntl.getUserList().getGarmentTable(userIndex).get(i).getGarmentTemperature() == temp){
                                recommendationReturn[1] = theMainMenuCntl.getUserList().getGarmentTable(userIndex).get(i);
                                pantsSentinal = false;
                            }
                       // }
                    }
                }

                //coat
                if (coatSentinal == true){
                    if (theMainMenuCntl.getUserList().getGarmentTable(userIndex).get(i).getGarmentType().equals("Coat")){
                        if (theMainMenuCntl.getUserList().getGarmentTable(userIndex).get(i).getGarmentPrecipitation() == precip){
                            if (theMainMenuCntl.getUserList().getGarmentTable(userIndex).get(i).getGarmentTemperature() == temp){
                                recommendationReturn[2] = theMainMenuCntl.getUserList().getGarmentTable(userIndex).get(i);
                                coatSentinal = false;
                            }
                        }
                    }
                }

                //shoes
                if (shoesSentinal == true){
                    if (theMainMenuCntl.getUserList().getGarmentTable(userIndex).get(i).getGarmentType().equals("Shoes")){
                        if (theMainMenuCntl.getUserList().getGarmentTable(userIndex).get(i).getGarmentPrecipitation() == precip){
                            if (theMainMenuCntl.getUserList().getGarmentTable(userIndex).get(i).getGarmentTemperature() == temp){
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
            else{
                System.out.println(shirtOptions.size());
                int index = (int)(Math.random()*shirtOptions.size());
                recommendationReturn[0] = shirtOptions.get(index);
            }
            if (pantsSentinal == true){
                recommendationReturn[1] = theMainMenuCntl.getUserList().getGarmentTable(userIndex).get(2);
                System.out.println("pants default recommended");
            }
            if (coatSentinal == true){
                recommendationReturn[2] = theMainMenuCntl.getUserList().getGarmentTable(userIndex).get(4);
                System.out.println("coat default recommended");
            }
            if (shoesSentinal == true){
                recommendationReturn[3] = theMainMenuCntl.getUserList().getGarmentTable(userIndex).get(7);
                System.out.println("shoes default recommended");
            }
                
            return recommendationReturn;
        }
        catch (IndexOutOfBoundsException ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
}
