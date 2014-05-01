package fashionforecast;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class WeatherUI extends JFrame{
    WeatherCntl theWeatherCntl;
    JPanel mainPanel;
    JPanel contentPanel;
    JPanel tempPanel;
    JLabel tempImageLabel;
    JPanel precipPanel;
    JLabel precipImageLabel;
    ImageIcon tempImage;
    ImageIcon precipImage;
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
        tempImageLabel = new JLabel();
        precipPanel = new JPanel();
        precipImageLabel = new JLabel();
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
            tempImage = theWeatherCntl.getColdImage();
        }
        else{
            tempDisplay = "Hot";
            tempImage = theWeatherCntl.getHotImage();
        }
        tempArea.setEditable(false);
        tempArea.setText(tempDisplay);
        String precipDisplay;
        boolean precipValue = theWeatherCntl.getPrecipitation();
        if (precipValue == true && tempValue == true){
            precipDisplay = "Snow";
            precipImage = theWeatherCntl.getSnowImage();
        }
        else if (precipValue == true){
            precipDisplay = "Rain";
            precipImage = theWeatherCntl.getRainImage();
        }
        else{
            precipDisplay = "None";
            precipImage = theWeatherCntl.getSunImage();
        }
        precipArea.setEditable(false);
        precipArea.setText(precipDisplay);
        
        tempImageLabel.setIcon(tempImage);
        precipImageLabel.setIcon(precipImage);
        
        BorderLayout mainLayout = new BorderLayout();
        GridLayout contentLayout = new GridLayout(0, 2);
        BorderLayout tempLayout = new BorderLayout();
        BorderLayout precipLayout = new BorderLayout();
        
        tempPanel.setLayout(tempLayout);
        precipPanel.setLayout(precipLayout);
        contentPanel.setLayout(contentLayout);
        mainPanel.setLayout(mainLayout);
        
        tempPanel.add(tempImageLabel, tempLayout.CENTER);
        tempPanel.add(tempLabel, tempLayout.SOUTH);
        tempPanel.add(tempArea, tempLayout.SOUTH);
        precipPanel.add(precipImageLabel, precipLayout.CENTER);
        precipPanel.add(precipLabel, precipLayout.SOUTH);
        precipPanel.add(precipArea, precipLayout.SOUTH);
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
