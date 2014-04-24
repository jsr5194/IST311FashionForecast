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
    
    public MainMenuCntl(UserList passedUserList){
        theUserList = passedUserList;
        ArrayList<Garment> test;
        MainMenuUI theMainMenuUI = new MainMenuUI(this);
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
        WeatherCntl theWeatherCntl = new WeatherCntl(this);
    }
    
    
}
