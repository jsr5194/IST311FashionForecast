package fashionforecast;

public class WeatherCntl {
    MainMenuCntl theMainMenuCntl;
    Precipitation thePrecipitationCntl;
    Location theLocationCntl;
    Temperature theTemperatureCntl;
    
    public WeatherCntl(MainMenuCntl passedMainMenuCntl){
        theMainMenuCntl = passedMainMenuCntl;
        thePrecipitationCntl = new Precipitation(this);
        theLocationCntl = new Location(this);
        theTemperatureCntl = new Temperature(this);
        WeatherUI theWeatherUI = new WeatherUI(this);
    }
    
    public void getMainMenuCntl(){
        new MainMenuCntl(theMainMenuCntl.getUserList());
    }
    
    public Precipitation getPrecipitationCntl(){
        return thePrecipitationCntl;
    }
    
    public Location getLocationCntl(){
        return theLocationCntl;
    }
    
    public Temperature getTermperatureCntl(){
        return theTemperatureCntl;
    }
}
