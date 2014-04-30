package fashionforecast;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class WeatherUI extends JFrame{
    WeatherCntl theWeatherCntl;
    JPanel mainPanel;
    JPanel contentPanel;
    JPanel tempPanel;
    JPanel precipPanel;
    JLabel tempLabel;
    JTextArea tempArea;
    JLabel precipLabel;
    JTextArea precipArea;
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
        contentPanel = new JPanel();
        tempPanel = new JPanel();
        precipPanel = new JPanel();
        tempLabel = new JLabel("Current Temperature: ");
        tempArea = new JTextArea();
        precipLabel = new JLabel("Current Precipitation: ");
        precipArea = new JTextArea();
        homeButton = new JButton("Home");
        homeButton.addActionListener(new HomeButtonListener());
        
        boolean tempValue = theWeatherCntl.getTemperature();
        String tempDisplay;
        if (tempValue == true){
            tempDisplay = "Cold";
        }
        else{
            tempDisplay = "Hot";
        }
        tempArea.setEditable(false);
        tempArea.setText(tempDisplay);
        String precipDisplay;
        boolean precipValue = theWeatherCntl.getPrecipitation();
        if (precipValue == true && tempValue == true){
            precipDisplay = "Snow";
        }
        else if (precipValue == true){
            precipDisplay = "Rain";
        }
        else{
            precipDisplay = "None";
        }
        precipArea.setEditable(false);
        precipArea.setText(precipDisplay);
        
        
        BorderLayout mainLayout = new BorderLayout();
        GridLayout contentLayout = new GridLayout(0, 2);
        GridLayout tempLayout = new GridLayout(0, 2);
        GridLayout precipLayout = new GridLayout(0, 2);
        
        //tempPanel.setLayout(tempLayout);
        //precipPanel.setLayout(precipLayout);
        contentPanel.setLayout(contentLayout);
        mainPanel.setLayout(mainLayout);
        
        tempPanel.add(tempLabel);
        tempPanel.add(tempArea);
        precipPanel.add(precipLabel);
        precipPanel.add(precipArea);
        contentPanel.add(tempPanel);
        contentPanel.add(precipPanel);
        mainPanel.add(contentPanel);
        mainPanel.add(homeButton, mainLayout.SOUTH);
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
