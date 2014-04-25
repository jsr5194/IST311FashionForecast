
package fashionforecast;

import java.util.ArrayList;


public class WardrobeCntl {
    private MainMenuCntl theMainMenuCntl;
    private GarmentCntl theGarmentCntl;
    private OutfitCntl theOutfitCntl;
    private GarmentTableModel theGarmentTableModel;
    private OutfitTableModel theOutfitTableModel;
    private OutfitTableSimpleModel theOutfitTableSimpleModel;
    
    public ArrayList<Integer> shirtGarmentIndices = new ArrayList<Integer>();
    public ArrayList<Integer> pantsGarmentIndices = new ArrayList<Integer>();
    public ArrayList<Integer> coatGarmentIndices = new ArrayList<Integer>();
    public ArrayList<Integer> shoesGarmentIndices = new ArrayList<Integer>();
    
    public WardrobeCntl(MainMenuCntl passedMainMenuCntl){
        theMainMenuCntl = passedMainMenuCntl;
        theGarmentTableModel = new GarmentTableModel(this);
        theOutfitTableModel = new OutfitTableModel(this, theGarmentTableModel);
        theOutfitTableSimpleModel = new OutfitTableSimpleModel(this, theGarmentTableModel);
        theOutfitCntl = new OutfitCntl(this);
        theGarmentCntl = new GarmentCntl(this);
        WardrobeUI theWardrobeUI = new WardrobeUI(this);
    }
    
    public void getWardrobeUI(){
        WardrobeUI theWardrobeUI = new WardrobeUI(this);
    }
    
    public void getWardrobeGarmentDetailUI(int passedRow){
        WardrobeGarmentDetailUI theWardrobeGarmentDetailUI = new WardrobeGarmentDetailUI(this, theGarmentTableModel, passedRow);
    }
    
    public void getWardrobeOutfitDetailUI(int passedRow){
        WardrobeOutfitDetailUI theWardrobeOutfitDetailUI = new WardrobeOutfitDetailUI(this, theOutfitTableModel, passedRow);
    }
    
    public void getAddNewGarmentUI(){
        AddNewGarmentUI theAddNewGarmentUI = new AddNewGarmentUI(this, theGarmentTableModel);
    }
    
    public void getAddNewOutfitUI(){
        AddNewOutfitUI theAddNewOutfitUI = new AddNewOutfitUI(this, theOutfitTableModel);
    }
            
    public void goHome(){
        MainMenuCntl newMainMenuCntl = new MainMenuCntl(theMainMenuCntl.getUserList());
    }
    
    public MainMenuCntl getMainMenuCntl(){
        return theMainMenuCntl;
    }
    
    public GarmentCntl getGarmentCntl(){
        return theGarmentCntl;
    }
    
    public OutfitCntl getOutfitCntl(){
        return theOutfitCntl;
    }
    
    public GarmentTableModel getTheGarmentTableModel(){
        return theGarmentTableModel;
    }
    
    public OutfitTableModel getTheOutfitTableModel(){
        return theOutfitTableModel;
    }
    
    public OutfitTableSimpleModel getTheOutfitTableSimpleModel(){
        return theOutfitTableSimpleModel;
    }
    
    public String[] populateShirtDropdownValues(){
        int length = theMainMenuCntl.getUserList().getGarmentTable(theMainMenuCntl.getUserList().getUserIndex()).size();
        ArrayList<String> namesList = new ArrayList<String>();
        for (int i = 0; i<length; i++){
            String currentType = (String)getTheGarmentTableModel().getValueAt(i, 5);
            if (currentType.equals("Shirt") || currentType.equals("shirt")){
                String currentName = (String)getTheGarmentTableModel().getValueAt(i, 0);
                shirtGarmentIndices.add(i);
                namesList.add(currentName);
            }
        }
        
        
        String[] returnValue = new String[namesList.size()];
        for (int j = 0; j < namesList.size(); j++){
            returnValue[j] = namesList.get(j);
        }
        return returnValue;
    }
    
    public String[] populatePantsDropdownValues(){  //you still need to filter by type
        int length = theMainMenuCntl.getUserList().getGarmentTable(theMainMenuCntl.getUserList().getUserIndex()).size();
        ArrayList<String> namesList = new ArrayList<String>();
        for (int i = 0; i<length; i++){
            String currentType = (String)getTheGarmentTableModel().getValueAt(i, 5);
            if (currentType.equals("Pants") || currentType.equals("pants")){
                String currentName = (String)getTheGarmentTableModel().getValueAt(i, 0);
                pantsGarmentIndices.add(i);
                namesList.add(currentName);
            }
        }
        
        
        String[] returnValue = new String[namesList.size()];
        for (int j = 0; j < namesList.size(); j++){
            returnValue[j] = namesList.get(j);
        }
        return returnValue;
    }
    
    public String[] populateCoatDropdownValues(){
        int length = theMainMenuCntl.getUserList().getGarmentTable(theMainMenuCntl.getUserList().getUserIndex()).size();
        ArrayList<String> namesList = new ArrayList<String>();
        for (int i = 0; i<length; i++){
            String currentType = (String)getTheGarmentTableModel().getValueAt(i, 5);
            if (currentType.equals("Coat") || currentType.equals("coat")){
                String currentName = (String)getTheGarmentTableModel().getValueAt(i, 0);
                coatGarmentIndices.add(i);
                namesList.add(currentName);
            }
        }
        
        String[] returnValue = new String[namesList.size()];
        for (int j = 0; j < namesList.size(); j++){
            returnValue[j] = namesList.get(j);
        }
        return returnValue;
    }
    
    public String[] populateShoesDropdownValues(){
        int length = theMainMenuCntl.getUserList().getGarmentTable(theMainMenuCntl.getUserList().getUserIndex()).size();
        ArrayList<String> namesList = new ArrayList<String>();
        for (int i = 0; i<length; i++){
            String currentType = (String)getTheGarmentTableModel().getValueAt(i, 5);
            if (currentType.equals("Shoes") || currentType.equals("shoes") ){
                String currentName = (String)getTheGarmentTableModel().getValueAt(i, 0);
                shoesGarmentIndices.add(i);
                namesList.add(currentName);
            }
        }
        
        String[] returnValue = new String[namesList.size()];
        for (int j = 0; j < namesList.size(); j++){
            returnValue[j] = namesList.get(j);
        }
        return returnValue;
    }
    
    public ArrayList<Integer> getShirtGarmentIndices(){
        return shirtGarmentIndices;
    }
    
    public ArrayList<Integer> getPantsGarmentIndices(){
        return pantsGarmentIndices;
    }
    
    public ArrayList<Integer> getCoatGarmentIndices(){
        return coatGarmentIndices;
    }
    
    public ArrayList<Integer> getShoesGarmentIndices(){
        return shoesGarmentIndices;
    }
    
}
