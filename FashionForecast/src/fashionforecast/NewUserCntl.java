
package fashionforecast;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author jared
 */
public class NewUserCntl {
    LoginCntl theLoginCntl;
    Garment defaultShirt;
    Garment defaultPants;
    Garment defaultCoat;
    Garment defaultShoes;
    
    public NewUserCntl(LoginCntl passedLoginCntl){
        theLoginCntl = passedLoginCntl;
        NewUserUI theNewUserUI = new NewUserUI(this);
    }
    
    public void getLoginCntl(){
        theLoginCntl.getLoginUI();
    }
    
    public void addUser(String username, String password){
        ArrayList<Garment> newGarmentTable = setFirstGarmentTable();
        ArrayList<Outfit> newOutfitTable = setFirstOutfitTable();
        theLoginCntl.getUserList().addUser(username, password, newGarmentTable, newOutfitTable);
    }
    
    private ArrayList<Garment> setFirstGarmentTable(){   
        setInitialGarments();
        ArrayList<Garment> firstGarmentTable = new ArrayList<Garment>();
        firstGarmentTable.add(defaultShirt);
        firstGarmentTable.add(defaultPants);
        firstGarmentTable.add(defaultCoat);
        firstGarmentTable.add(defaultShoes);
        return firstGarmentTable;
    }
    private void setInitialGarments(){
        String pathRoot = "/Users/unkn0wn/NetBeansProjects/FashionForecast/src/fashionforecast/";
        
        try{
            BufferedImage shirtBuffImage = ImageIO.read(new File(pathRoot+"shirt.jpg"));
            ImageIcon shirtImage =new ImageIcon(shirtBuffImage);        
            defaultShirt = new Garment("shirt", shirtImage, "Large", false, "Test description", "Shirt", "any", "warm");

            BufferedImage pantsBuffImage = ImageIO.read(new File(pathRoot+"pants.jpg"));
            ImageIcon pantsImage =new ImageIcon(pantsBuffImage);        
            defaultPants = new Garment("pants", pantsImage, "Large", false, "Test description", "Pants", "any", "cold");

            BufferedImage coatBuffImage = ImageIO.read(new File(pathRoot+"coat.jpg"));
            ImageIcon coatImage =new ImageIcon(coatBuffImage);        
            defaultCoat = new Garment("coat", coatImage, "Large", false, "Test description", "Coat", "any", "cold");

            BufferedImage shoesBuffImage = ImageIO.read(new File(pathRoot+"shoes.jpg"));
            ImageIcon shoesImage =new ImageIcon(shoesBuffImage);        
            defaultShoes = new Garment("shoes", shoesImage, "Large", false, "Test description", "Shoes", "any", "any");
            
        }
        catch (IOException ex){
            System.out.println("ioerror in user");
            System.exit(0);
        }
    }
    
    
    private ArrayList<Outfit> setFirstOutfitTable(){
        Garment shirtGarment = getDefaultShirt();
        Garment pantsGarment = getDefaultPants();
        Garment coatGarment = getDefaultCoat();
        Garment shoesGarment = getDefaultShoes();
        
        Outfit firstOutfit = new Outfit("Default", shirtGarment, pantsGarment, coatGarment, shoesGarment, "casual");

        ArrayList<Outfit> firstOutfitTable = new ArrayList<Outfit>();
        
        firstOutfitTable.add(firstOutfit);
        
        return firstOutfitTable;
    }
    
        
    public Garment getDefaultShirt(){
        return defaultShirt;
    }
    
    public Garment getDefaultPants(){
        return defaultPants;
    }
    
    public Garment getDefaultCoat(){
        return defaultCoat;
    }
    
    public Garment getDefaultShoes(){
        return defaultShoes;
    }
}
