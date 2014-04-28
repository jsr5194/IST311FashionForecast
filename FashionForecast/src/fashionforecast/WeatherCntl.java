package fashionforecast;

public class WeatherCntl {
    MainMenuCntl theMainMenuCntl;
    String returnTemp;
    String precipitation;
    
    public WeatherCntl(MainMenuCntl passedMainMenuCntl){
        theMainMenuCntl = passedMainMenuCntl;
        WeatherUI theWeatherUI = new WeatherUI(this);
    }
    
    public void getMainMenuCntl(){
        theMainMenuCntl.getMainMenuUI();
    }
    
    public String getTemperature(){
        setTemperature();
        return returnTemp;
    }
    
    public String getPrecipitation(){
        setPrecipitation();
        return precipitation;
    }
    
    public void setTemperature(){
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
    }
    
    public void setPrecipitation(){
        int precipitationValue = (int)(Math.random()*3);
        if (returnTemp.equals("hot") || returnTemp.equals("warm")){
            switch (precipitationValue){
            case 0:
                precipitation = "none";
                break;
            case 1:
                precipitation = "rain";
                break;
            }
        }
        else{
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
        }
    }
}
