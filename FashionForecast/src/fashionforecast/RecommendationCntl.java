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
            ArrayList<Garment> pantsOptions = new ArrayList<Garment>();
            ArrayList<Garment> coatOptions = new ArrayList<Garment>();
            ArrayList<Garment> shoesOptions = new ArrayList<Garment>();
            temp = theMainMenuCntl.returnWeatherCntl().getTemperature();
            precip = theMainMenuCntl.returnWeatherCntl().getPrecipitation();
            int length = theMainMenuCntl.getUserList().getGarmentTable(userIndex).size();
            System.out.println("length; " + length);
            for (int i = 0; i<length; i++){
                //shirt
                if (theMainMenuCntl.getUserList().getGarmentTable(userIndex).get(i).getGarmentType().equals("Shirt")){
                   // if (theMainMenuCntl.getUserList().getGarmentTable(userIndex).get(i).getGarmentPrecipitation() == precip){
                        if (theMainMenuCntl.getUserList().getGarmentTable(userIndex).get(i).getGarmentTemperature() == temp){
                            //recommendationReturn[0] = theMainMenuCntl.getUserList().getGarmentTable(userIndex).get(i);
                            shirtOptions.add(theMainMenuCntl.getUserList().getGarmentTable(userIndex).get(i));
                        }
                   // }
                }
                

                //pants
                if (theMainMenuCntl.getUserList().getGarmentTable(userIndex).get(i).getGarmentType().equals("Pants")){
                   // if (theMainMenuCntl.getUserList().getGarmentTable(userIndex).get(i).getGarmentPrecipitation() == precip){
                        if (theMainMenuCntl.getUserList().getGarmentTable(userIndex).get(i).getGarmentTemperature() == temp){
                            //recommendationReturn[1] = theMainMenuCntl.getUserList().getGarmentTable(userIndex).get(i);
                            pantsOptions.add(theMainMenuCntl.getUserList().getGarmentTable(userIndex).get(i));
                        }
                   // }
                }
                

                //coat
                if (theMainMenuCntl.getUserList().getGarmentTable(userIndex).get(i).getGarmentType().equals("Coat")){
                    if (theMainMenuCntl.getUserList().getGarmentTable(userIndex).get(i).getGarmentPrecipitation() == precip){
                        if (theMainMenuCntl.getUserList().getGarmentTable(userIndex).get(i).getGarmentTemperature() == temp){
                            //recommendationReturn[2] = theMainMenuCntl.getUserList().getGarmentTable(userIndex).get(i);
                            coatOptions.add(theMainMenuCntl.getUserList().getGarmentTable(userIndex).get(i));
                        }
                        
                    }
                }

                //shoes
                if (theMainMenuCntl.getUserList().getGarmentTable(userIndex).get(i).getGarmentType().equals("Shoes")){
                    if (theMainMenuCntl.getUserList().getGarmentTable(userIndex).get(i).getGarmentPrecipitation() == precip){
                        if (theMainMenuCntl.getUserList().getGarmentTable(userIndex).get(i).getGarmentTemperature() == temp){
                            //recommendationReturn[3] = theMainMenuCntl.getUserList().getGarmentTable(userIndex).get(i);
                            shoesOptions.add(theMainMenuCntl.getUserList().getGarmentTable(userIndex).get(i));
                        }
                    }
                }
                

            }
            
            if (shirtOptions.isEmpty()){
                recommendationReturn[0] = theMainMenuCntl.getUserList().getGarmentTable(userIndex).get(0);
                System.out.println("shirt default recommended");
            }
            else{
                int index = (int)(Math.random()*shirtOptions.size());
                
                System.out.println(index);
                recommendationReturn[0] = shirtOptions.get(index);
            }
            if (pantsOptions.isEmpty()){
                recommendationReturn[1] = theMainMenuCntl.getUserList().getGarmentTable(userIndex).get(2);
                System.out.println("pants default recommended");
            }
            else{
                int index = (int)(Math.random()*pantsOptions.size());
                
                System.out.println(index);
                recommendationReturn[1] = pantsOptions.get(index);
            }
            if (coatOptions.isEmpty()){
                recommendationReturn[2] = theMainMenuCntl.getUserList().getGarmentTable(userIndex).get(4);
                System.out.println("coat default recommended");
            }
            else{
                int index = (int)(Math.random()*coatOptions.size());
                
                System.out.println(index);
                recommendationReturn[2] = coatOptions.get(index);
            }
            if (shoesOptions.isEmpty()){
                recommendationReturn[3] = theMainMenuCntl.getUserList().getGarmentTable(userIndex).get(7);
                System.out.println("shoes default recommended");
            }
            else{
                int index = (int)(Math.random()*shoesOptions.size());
                
                System.out.println(index);
                recommendationReturn[3] = shoesOptions.get(index);
            }
                
            return recommendationReturn;
        }
        catch (IndexOutOfBoundsException ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
}
