package fashionforecast;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class WeatherUI extends JFrame{
    WeatherCntl theWeatherCntl;
    JPanel mainPanel;
    JButton homeButton;
    public WeatherUI(WeatherCntl parentWeatherCntl){
        theWeatherCntl = parentWeatherCntl;
        setTitle("Weather");
        setBounds(100, 100, 600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
    }
    
    public void initComponents(){
        mainPanel = new JPanel();
        homeButton = new JButton("Home");
        homeButton.addActionListener(new HomeButtonListener());
        
        mainPanel.add(homeButton);
        this.add(mainPanel);
        setVisible(true);
    }
    
    public class HomeButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            setVisible(false);
            theWeatherCntl.getMainMenuCntl();
        }
    }
}
