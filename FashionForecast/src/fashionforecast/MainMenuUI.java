package fashionforecast;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MainMenuUI extends JFrame{
    MainMenuCntl theMainMenuCntl;
    
    JPanel mainPanel;
    JButton recommendationButton;
    JButton wardrobeButton;
    JButton weatherButton;
    JButton settingsButton;
    
    public MainMenuUI(MainMenuCntl parentMainMenuCntl){
        theMainMenuCntl = parentMainMenuCntl;
        setTitle("Main Menu");
        setBounds(100, 100, 600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
    }
    
    public void initComponents(){
        mainPanel = new JPanel();
        GridLayout theGridLayout = new GridLayout(0, 1);
        recommendationButton = new JButton("Recommendation");
        recommendationButton.addActionListener(new RecommendationButtonListener());
        wardrobeButton = new JButton("Wardrobe");
        wardrobeButton.addActionListener(new WardrobeButtonListener());
        weatherButton = new JButton("Weather");
        weatherButton.addActionListener(new WeatherButtonListener());
        settingsButton = new JButton("Settings");
       // settingsButton.addActionListener(new SettingsButtonListener());
        
        mainPanel.add(recommendationButton);
        mainPanel.add(wardrobeButton);
        mainPanel.add(weatherButton);
        mainPanel.add(settingsButton);
        mainPanel.setLayout(theGridLayout);
        this.add(mainPanel);
        setVisible(true);
    }
    
    public class RecommendationButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            setVisible(false);
            theMainMenuCntl.getRecommendationCntl();
        }
    }
    
    public class WardrobeButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            setVisible(false);
            theMainMenuCntl.getWardrobeCntl();
        }
    }
    
    public class WeatherButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            setVisible(false);
            theMainMenuCntl.getWeatherCntl();
        }
    }
    
    public class SettingsButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            setVisible(false);
            //theMainMenuCntl.getSettingsCntl();
        }
    }
    
}
