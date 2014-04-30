
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
    Garment defaultSweatshirt;
    Garment defaultPants;
    Garment defaultShorts;
    Garment defaultCoat;
    Garment defaultRaincoat;
    Garment defaultNocoat;
    Garment defaultShoes;
    Garment defaultBoots;
    
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
        firstGarmentTable.add(defaultSweatshirt);
        firstGarmentTable.add(defaultPants);
        firstGarmentTable.add(defaultShorts);
        firstGarmentTable.add(defaultCoat);
        firstGarmentTable.add(defaultRaincoat);
        firstGarmentTable.add(defaultNocoat);
        firstGarmentTable.add(defaultShoes);
        firstGarmentTable.add(defaultBoots);
        return firstGarmentTable;
    }
    private void setInitialGarments(){
        String pathRoot = "src/fashionforecast/InitialImages/";
        
        try{
            BufferedImage shirtBuffImage = ImageIO.read(new File(pathRoot+"shirt.jpg"));
            ImageIcon shirtImage =new ImageIcon(shirtBuffImage);        
            defaultShirt = new Garment("shirt", shirtImage, "Large", false, "Test description", "Shirt", false, false);
            
            BufferedImage sweatshirtBuffImage = ImageIO.read(new File(pathRoot+"sweatshirt.jpg"));
            ImageIcon sweatshirtImage =new ImageIcon(sweatshirtBuffImage);        
            defaultSweatshirt = new Garment("sweatshirt", sweatshirtImage, "Large", false, "Test description", "Shirt", false, true);

            BufferedImage shortsBuffImage = ImageIO.read(new File(pathRoot+"shorts.jpg"));
            ImageIcon shortsImage =new ImageIcon(shortsBuffImage);        
            defaultShorts = new Garment("shorts", shortsImage, "Large", false, "Test description", "Pants", false, false);
            
            BufferedImage pantsBuffImage = ImageIO.read(new File(pathRoot+"pants.jpg"));
            ImageIcon pantsImage =new ImageIcon(pantsBuffImage);        
            defaultPants = new Garment("pants", pantsImage, "Large", false, "Test description", "Pants", false, true);

            BufferedImage coatBuffImage = ImageIO.read(new File(pathRoot+"coat.jpg"));
            ImageIcon coatImage =new ImageIcon(coatBuffImage);        
            defaultCoat = new Garment("coat", coatImage, "Large", false, "Test description", "Coat", false, true);
            
            BufferedImage raincoatBuffImage = ImageIO.read(new File(pathRoot+"raincoat.jpg"));
            ImageIcon raincoatImage =new ImageIcon(raincoatBuffImage);        
            defaultRaincoat = new Garment("raincoat", raincoatImage, "Large", false, "Test description", "Coat", true, false);
            
            BufferedImage nocoatBuffImage = ImageIO.read(new File(pathRoot+"nocoat.jpg"));
            ImageIcon nocoatImage =new ImageIcon(nocoatBuffImage);        
            defaultNocoat = new Garment("nocoat", nocoatImage, "N/A", false, "N/A", "Coat", false, false);

            BufferedImage shoesBuffImage = ImageIO.read(new File(pathRoot+"shoes.jpg"));
            ImageIcon shoesImage =new ImageIcon(shoesBuffImage);        
            defaultShoes = new Garment("shoes", shoesImage, "Large", false, "Test description", "Shoes", false, false);
            
            BufferedImage bootsBuffImage = ImageIO.read(new File(pathRoot+"boots.jpg"));
            ImageIcon bootsImage =new ImageIcon(bootsBuffImage);        
            defaultBoots = new Garment("boots", bootsImage, "Large", false, "Test description", "Shoes", true, true);
            
            
            
        }
        catch (IOException ex){
            System.out.println("ioerror in newusercntl");
            ex.printStackTrace();
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
