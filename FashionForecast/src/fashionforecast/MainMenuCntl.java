/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fashionforecast;

import java.util.ArrayList;

/**
 *
 * @author jared
 */
public class MainMenuCntl {
    UserList theUserList;
    MainMenuUI theMainMenuUI;
    WeatherCntl theWeatherCntl;
    
    public MainMenuCntl(UserList passedUserList){
        theUserList = passedUserList;
        ArrayList<Garment> test;
        getMainMenuUI();
    }
    
    public void getMainMenuUI(){
        if (theMainMenuUI == null){
            theMainMenuUI = new MainMenuUI(this);
        }
        else{
            theMainMenuUI.setVisible(true);
        }
    }

    public UserList getUserList(){
        return theUserList;
    }
    
    public void getRecommendationCntl(){
        RecommendationCntl theRecommendationCntl = new RecommendationCntl(this);
    }
    
    public void getWardrobeCntl(){
        WardrobeCntl theWardrobeCntl = new WardrobeCntl(this);
    }
    
    public void getWeatherCntl(){
        theWeatherCntl = new WeatherCntl(this);
    }
    
    public WeatherCntl returnWeatherCntl(){
        return theWeatherCntl;
    }
    
    
}
