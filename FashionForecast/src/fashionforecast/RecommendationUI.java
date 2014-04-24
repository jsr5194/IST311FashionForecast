package fashionforecast;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class RecommendationUI extends JFrame{
    RecommendationCntl theRecommendationCntl;
    
    Garment shirt;
    Garment pants;
    Garment coat;
    Garment shoes;
    
    JPanel mainPanel;
    JPanel bodyPanel;
    JPanel zipPanel;
    JButton zipSubmitButton;
    JPanel weatherPanel;
    JPanel recommendationPanel;
    JPanel garmentPanel;
    
    JTextArea descriptionTextArea;
    JLabel zipLabel;
    JTextField zipField;
    JLabel shirtLabel;
    JLabel shirtImageLabel;
    ImageIcon shirtImage;
    JLabel pantsLabel;
    JLabel pantsImageLabel;
    ImageIcon pantsImage;
    JLabel coatLabel;
    JLabel coatImageLabel;
    ImageIcon coatImage;
    JLabel shoesLabel;
    JLabel shoesImageLabel;
    ImageIcon shoesImage;
    JLabel weatherLabel;
    JTextArea tempTextArea;
    JTextArea precipTextArea;
    JButton homeButton;
    
    Garment[] recommendation;
    
    public RecommendationUI(RecommendationCntl parentRecommendationCntl){
        theRecommendationCntl = parentRecommendationCntl;
        setTitle("Recommendation");
        setBounds(100, 100, 600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
    }
    
    public void initComponents(){
        mainPanel = new JPanel();
        bodyPanel = new JPanel();
        descriptionTextArea = new JTextArea();
        descriptionTextArea.setEditable(false);
        descriptionTextArea.setText("\n"
                + "\t\tThis is a description of how to \n"
                + "\t\tuse this function\n");
        zipPanel = new JPanel();
        recommendationPanel = new JPanel();
        garmentPanel = new JPanel();
        weatherPanel = new JPanel();
        
        BorderLayout theMainLayout = new BorderLayout();
        BorderLayout theBodyLayout = new BorderLayout();
        BorderLayout theRecommendationLayout = new BorderLayout();
        GridLayout theGarmentLayout = new GridLayout(0, 2);
        GridLayout theWeatherLayout = new GridLayout(0, 3);
        
        zipLabel = new JLabel("Zip Code: ");
        zipField = new JTextField();
        zipField.setPreferredSize(new Dimension(100, 20));
        zipSubmitButton = new JButton("Get Recommendation");
        zipSubmitButton.addActionListener(new ZipSubmitButtonListener());
        
        recommendation = new Garment[4]; //set at 4 for shirts, pants, coats,and shoes
        shirtLabel = new JLabel();
        pantsLabel = new JLabel();
        coatLabel = new JLabel();
        shoesLabel = new JLabel();
        shirtImageLabel = new JLabel();
        pantsImageLabel = new JLabel();
        coatImageLabel = new JLabel();
        shoesImageLabel = new JLabel();
        weatherLabel = new JLabel();
        tempTextArea = new JTextArea();
        precipTextArea = new JTextArea();
        
        homeButton = new JButton("Home");
        homeButton.addActionListener(new HomeButtonListener());
        
        
        mainPanel.setLayout(theMainLayout);
        bodyPanel.setLayout(theBodyLayout);
        recommendationPanel.setLayout(theRecommendationLayout);
        garmentPanel.setLayout(theGarmentLayout);
        weatherPanel.setLayout(theWeatherLayout);
        
        bodyPanel.add(descriptionTextArea, theBodyLayout.NORTH);
        zipPanel.add(zipLabel);
        zipPanel.add(zipField);
        zipPanel.add(zipSubmitButton);
        weatherPanel.add(weatherLabel);
        weatherPanel.add(tempTextArea);
        weatherPanel.add(precipTextArea);
        recommendationPanel.add(zipPanel, theRecommendationLayout.NORTH);
        recommendationPanel.add(garmentPanel, theRecommendationLayout.CENTER);
        garmentPanel.add(shirtLabel);
        garmentPanel.add(shirtImageLabel);
        garmentPanel.add(pantsLabel);
        garmentPanel.add(pantsImageLabel);
        garmentPanel.add(coatLabel);
        garmentPanel.add(coatImageLabel);
        garmentPanel.add(shoesLabel);
        garmentPanel.add(shoesImageLabel);
        recommendationPanel.add(weatherPanel, theRecommendationLayout.SOUTH);
        bodyPanel.add(recommendationPanel);
        mainPanel.add(bodyPanel, theMainLayout.CENTER);
        mainPanel.add(homeButton, theMainLayout.SOUTH);
        this.add(mainPanel);
        setVisible(true);
    }
    
    //method to display the recommendation on the screen
    //FIXME: currently requires a zip code for state college area. needs to be expanded for final product
    public void showRecommendation(String zip){
            if (zip.length() == 5){ 
                
                recommendation = theRecommendationCntl.getRecommendation();
                shirt = recommendation[0];
                pants = recommendation[1];
                coat = recommendation[2];
                shoes = recommendation[3];
                
                shirtLabel.setText(shirt.getGarmentName());
                pantsLabel.setText(pants.getGarmentName());
                coatLabel.setText(coat.getGarmentName());
                shoesLabel.setText(shoes.getGarmentName());
                
                
                shirtImageLabel.setIcon(shirt.getGarmentImage());
                pantsImageLabel.setIcon(pants.getGarmentImage());
                coatImageLabel.setIcon(coat.getGarmentImage());
                shoesImageLabel.setIcon(shoes.getGarmentImage());
                
                    
                /*
                try{   
                    BufferedImage buffShirtImage = ImageIO.read(new File(recommendation[0]));
                    shirtImage =new ImageIcon(buffShirtImage);
                    shirtImageLabel.setIcon(shirtImage);
                }
                catch (IOException ex){
                    setGenericImage("shirt");
                }
                        
                try{ 
                    BufferedImage buffPantsImage = ImageIO.read(new File(recommendation[1]));
                    pantsImage =new ImageIcon(buffPantsImage);
                    pantsImageLabel.setIcon(pantsImage);
                }
                catch (IOException ex){
                    setGenericImage("pants");
                }
                try{ 
                    BufferedImage buffCoatImage = ImageIO.read(new File(recommendation[2]));
                    coatImage =new ImageIcon(buffCoatImage);
                    coatImageLabel.setIcon(coatImage);
                }
                catch (IOException ex){
                    setGenericImage("coat");
                }
                try{ 
                    BufferedImage buffShoesImage = ImageIO.read(new File(recommendation[3]));
                    shoesImage =new ImageIcon(buffShoesImage);
                    shoesImageLabel.setIcon(shoesImage);
                }
                catch (IOException ex){
                    setGenericImage("shoes");
                }
                        */

                weatherLabel.setText("Weather Report");
                tempTextArea.setEditable(false);
                tempTextArea.setText("\t70");
                precipTextArea.setEditable(false);
                precipTextArea.setText("\tRain");
            }
            else{
                
                
            }
        }
    
    
    public class ZipSubmitButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String zip = zipField.getText();
            if (zip != null){
                showRecommendation(zip);
            }
            else{
                zipField.setText("");
            }
        }
    }
    
    public class HomeButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            setVisible(false);
            theRecommendationCntl.getMainMenuCntl();
        }
    }
    
    public void setGenericImage(String garmentType){
        String pathBase = "/Users/unkn0wn/NetBeansProjects/FashionForecast/src/fashionforecast/";
        String garmentPath = pathBase+garmentType;
        try{
            switch (garmentType){
                case "shirt":
                    BufferedImage buffShirtImage = ImageIO.read(new File(garmentPath));
                    shirtImage =new ImageIcon(buffShirtImage);
                    shirtImageLabel.setIcon(shirtImage);
                    break;
                case "pants":
                    BufferedImage buffPantsImage = ImageIO.read(new File(garmentPath));
                    pantsImage =new ImageIcon(buffPantsImage);
                    pantsImageLabel.setIcon(pantsImage);
                    break;
                case "coat":
                    BufferedImage buffCoatImage = ImageIO.read(new File(garmentPath));
                    coatImage =new ImageIcon(buffCoatImage);
                    coatImageLabel.setIcon(coatImage);
                    break;
                case "shoes":
                    BufferedImage buffShoesImage = ImageIO.read(new File(garmentPath));
                    shoesImage =new ImageIcon(buffShoesImage);
                    shoesImageLabel.setIcon(shoesImage);
                    break;
            }
        }
        catch (IOException ex){
            System.out.println("Error: "+ex);
        }
        
    }
    
}
