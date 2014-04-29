package fashionforecast;

public class WeatherCntl {
    MainMenuCntl theMainMenuCntl;
    WeatherUI theWeatherUI;
    boolean returnTemp;
    boolean precipitation;
    
    public WeatherCntl(MainMenuCntl passedMainMenuCntl, boolean uiIsShown){
        theMainMenuCntl = passedMainMenuCntl;
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
        int temperature = (int)(Math.random()*70+50);
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
}
