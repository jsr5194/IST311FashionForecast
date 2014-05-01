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
    LoginCntl theLoginCntl;
    UserList theUserList;
    MainMenuUI theMainMenuUI;
    WeatherCntl theWeatherCntl;
    WardrobeCntl theWardrobeCntl;
    
    public MainMenuCntl(LoginCntl passedLoginCntl){
        theLoginCntl = passedLoginCntl;
        theUserList = theLoginCntl.getUserList();
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
    
    public void getWardrobeCntl(boolean uiIsShown){
        theWardrobeCntl = new WardrobeCntl(this, uiIsShown);
    }
    
    public WardrobeCntl returnWardrobeCntl(){
        if (theWardrobeCntl == null){
            getWardrobeCntl(false);
        }
        return theWardrobeCntl;
    }
    
    public void getWeatherCntl(boolean uiIsShown){
        theWeatherCntl = new WeatherCntl(this, uiIsShown);
    }
    
    public WeatherCntl returnWeatherCntl(){
        if (theWeatherCntl == null){
            getWeatherCntl(false);
        }
        return theWeatherCntl;
    }
    
    public void getShareCntl(){
        ShareCntl theShareCntl = new ShareCntl(this);
    }
    
    
}
