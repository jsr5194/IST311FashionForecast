
package fashionforecast;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author unkn0wn
 */
public class ShareCntl {
    ShareUI theShareUI;
    MainMenuCntl theMainMenuCntl;
    ImageIcon facebook;
    ImageIcon twitter;
    ImageIcon instagram;
    ImageIcon flickr;
    
    public ArrayList<Integer> outfitIndices = new ArrayList<Integer>();
    
    public ShareCntl(MainMenuCntl passedMainMenuCntl){
        theMainMenuCntl = passedMainMenuCntl;
        setShareImages();
        getShareUI();
    }
    
    public void getMainMenuCntl(){
        theMainMenuCntl.getMainMenuUI();
    }
    
    public void getShareUI(){
        if (theShareUI == null){
            theShareUI = new ShareUI(this);
        }
        else{
            theShareUI.setVisible(true);
        }
    }
    
    public void getShareDetailUI(String platform){
        ShareDetailUI theShareDetailUI = new ShareDetailUI(this, platform);
    }
    
    public void setShareImages(){
        //image credit to the appropriate sites
        
         String pathRoot = "src/fashionforecast/ShareImages/";
        
        try{
            BufferedImage facebookBuffImage = ImageIO.read(new File(pathRoot+"facebook.jpg"));
            facebook =new ImageIcon(facebookBuffImage);   
            
            BufferedImage twitterBuffImage = ImageIO.read(new File(pathRoot+"twitter.jpg"));
            twitter =new ImageIcon(twitterBuffImage);        

            BufferedImage instagramBuffImage = ImageIO.read(new File(pathRoot+"instagram.jpg"));
            instagram =new ImageIcon(instagramBuffImage);        
            
            BufferedImage flickrBuffImage = ImageIO.read(new File(pathRoot+"flickr.jpg"));
            flickr =new ImageIcon(flickrBuffImage);            
        }
        catch (IOException ex){
            System.out.println("ioerror in sharecntl");
            System.exit(0);
        }
    }
    
    public ImageIcon getFacebookImage(){
        return facebook;
    }
    public ImageIcon getTwitterImage(){
        return twitter;
    }
    public ImageIcon getInstagramImage(){
        return instagram;
    }
    public ImageIcon getFlickrImage(){
        return flickr;
    }
    
    public String[] populateOutfitDropdownValues(){
        int length = theMainMenuCntl.getUserList().getOutfitTable(theMainMenuCntl.getUserList().getUserIndex()).size();
        ArrayList<String> namesList = new ArrayList<String>();
        for (int i = 0; i<length; i++){
            String currentName = (String)theMainMenuCntl.returnWardrobeCntl().getTheOutfitTableModel().getValueAt(i, 0);
            outfitIndices.add(i);
            namesList.add(currentName);
        }
        
        String[] returnValue = new String[namesList.size()];
        for (int j = 0; j < namesList.size(); j++){
            returnValue[j] = namesList.get(j);
        }
        return returnValue;
    }
    
}
