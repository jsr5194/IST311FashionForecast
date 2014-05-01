
package fashionforecast;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ShareUI extends JFrame{
    ShareCntl theShareCntl;
    JPanel mainPanel;
    JPanel contentPanel;
    JPanel facebookPanel;
    JPanel twitterPanel;
    JPanel instagramPanel;
    JPanel flickrPanel;
    
    JButton facebookButton;
    JButton twitterButton;
    JButton instagramButton;
    JButton flickrButton;
    
    JButton homeButton;
    
    public ShareUI(ShareCntl parentShareCntl){
        theShareCntl = parentShareCntl;
        setTitle("Share With Friends");
        setBounds(100, 100, 600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
    }
    
    public void initComponents(){
        mainPanel = new JPanel();
        contentPanel = new JPanel();
        facebookPanel = new JPanel();
        twitterPanel = new JPanel();
        instagramPanel = new JPanel();
        flickrPanel = new JPanel();
        
        facebookButton = new JButton(theShareCntl.getFacebookImage());
        facebookButton.addActionListener(new FacebookButtonListener());
        twitterButton = new JButton(theShareCntl.getTwitterImage());
        twitterButton.addActionListener(new TwitterButtonListener());
        instagramButton = new JButton(theShareCntl.getInstagramImage());
        instagramButton.addActionListener(new InstagramButtonListener());
        flickrButton = new JButton(theShareCntl.getFlickrImage());
        flickrButton.addActionListener(new FlickrButtonListener());
        
        homeButton = new JButton("Home");
        homeButton.addActionListener(new HomeButtonListener());
        
        
        
        BorderLayout mainLayout = new BorderLayout();
        GridLayout contentLayout = new GridLayout(0, 2);
        
        contentPanel.setLayout(contentLayout);
        mainPanel.setLayout(mainLayout);
        
        facebookPanel.add(facebookButton);
        twitterPanel.add(twitterButton);
        instagramPanel.add(instagramButton);
        flickrPanel.add(flickrButton);
        contentPanel.add(facebookPanel);
        contentPanel.add(twitterPanel);
        contentPanel.add(instagramPanel);
        contentPanel.add(flickrPanel);
        mainPanel.add(contentPanel);
        mainPanel.add(homeButton, mainLayout.SOUTH);
        this.add(mainPanel);
        setVisible(true);
    }
    
    public class HomeButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            setVisible(false);
            theShareCntl.getMainMenuCntl();
        }
    }
    
    public class FacebookButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            setVisible(true);
            theShareCntl.getShareDetailUI("Facebook");
        }
    }
    
    public class TwitterButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            setVisible(true);
            theShareCntl.getShareDetailUI("Twitter");
        }
    }
    
    public class InstagramButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            setVisible(true);
            theShareCntl.getShareDetailUI("Instagram");
        }
    }
    
    public class FlickrButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            setVisible(true);
            theShareCntl.getShareDetailUI("Flickr");
        }
    }
}

