package fashionforecast;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class WeatherCntl {
    MainMenuCntl theMainMenuCntl;
    WeatherUI theWeatherUI;
    boolean returnTemp;
    boolean precipitation;
    ImageIcon sun;
    ImageIcon rain;
    ImageIcon snow;
    ImageIcon hot;
    ImageIcon cold;
    
    public WeatherCntl(MainMenuCntl passedMainMenuCntl, boolean uiIsShown){
        theMainMenuCntl = passedMainMenuCntl;
        setWeatherImages();
        getWeatherUI(uiIsShown);
    }
    
    public void getWeatherUI(boolean showUI){
        if (theWeatherUI == null){
            theWeatherUI = new WeatherUI(this);
        }
        if (showUI == false){
            theWeatherUI.setVisible(false);
        }
        else{
            theWeatherUI.setVisible(true);
        }
    }
    
    public void getMainMenuCntl(){
        theMainMenuCntl.getMainMenuUI();
    }
    
    public boolean getTemperature(){
        setTemperature();
        return returnTemp;
    }
    
    public boolean getPrecipitation(){
        setPrecipitation();
        return precipitation;
    }
    
    public void setTemperature(){
        int temperature = (int)(Math.random()*70+40);
        if (temperature < 60){
            returnTemp = true;
        }
        
        else{
            returnTemp = false;
        }
    }
    
    public void setPrecipitation(){
        int precipitationValue = (int)(Math.random()*2);
        switch (precipitationValue){
            case 0:
                precipitation = true;
                break;
            case 1:
                precipitation = false;
                break;
        }
    }
    
    public void setWeatherImages(){
        //image credit to--> http://fc03.deviantart.net/fs20/f/2007/283/9/1/Pathfinder_Weather_icons_by_antonist.png
        
         String pathRoot = "src/fashionforecast/WeatherImages/";
        
        try{
            BufferedImage sunBuffImage = ImageIO.read(new File(pathRoot+"sun.png"));
            sun =new ImageIcon(sunBuffImage);   
            
            BufferedImage rainBuffImage = ImageIO.read(new File(pathRoot+"rain.png"));
            rain =new ImageIcon(rainBuffImage);        

            BufferedImage snowBuffImage = ImageIO.read(new File(pathRoot+"snow.png"));
            snow =new ImageIcon(snowBuffImage);        
            
            BufferedImage hotBuffImage = ImageIO.read(new File(pathRoot+"hot.png"));
            hot =new ImageIcon(hotBuffImage);        

            BufferedImage coldBuffImage = ImageIO.read(new File(pathRoot+"cold.png"));
            cold =new ImageIcon(coldBuffImage);            
        }
        catch (IOException ex){
            System.out.println("ioerror in weathercntl");
            System.exit(0);
        }
    }
    
    public ImageIcon getSunImage(){
        return sun;
    }
    public ImageIcon getRainImage(){
        return rain;
    }
    public ImageIcon getSnowImage(){
        return snow;
    }
    public ImageIcon getHotImage(){
        return hot;
    }
    public ImageIcon getColdImage(){
        return cold;
    }
}
