package fashionforecast;

import java.io.*;
import java.util.*;

public class UserList implements Serializable{
    private int userIndex;
    private ArrayList<User> listOfUsers = new ArrayList<User>();
    private String listOfUsersFileName = "ListOfUsers.ser";
    public UserList(){
        readListFile();
    }
    
    public ArrayList<User> readListFile(){
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try{
            fis = new FileInputStream(listOfUsersFileName);
            in = new ObjectInputStream(fis);
            listOfUsers = (ArrayList<User>)in.readObject();
            in.close();
        }
        catch(FileNotFoundException ex){
            this.writeInitialListFile();
        }
        catch(IOException ex){
            this.writeInitialListFile();
            System.out.println("Error in UserList.readUserList");
            ex.printStackTrace();
        }
        catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }
        return listOfUsers;
    }
    
    public void updateUserList(User passedUser){
        for(User currentUser : listOfUsers){
            if (currentUser.equals(passedUser)){
                currentUser = passedUser;
            }
        }
    }
    
    public void writeUserList(){
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try{
            fos= new FileOutputStream(listOfUsersFileName);
            out = new ObjectOutputStream(fos);
            out.writeObject(listOfUsers);
            out.close();
        }
        catch (IOException ex){
            System.out.println("Error in Userlist.writeUserList");
        }
    }
    
    public void addUser(String newUsername, String newPassword, ArrayList<Garment> newGarmentTable, ArrayList<Outfit> newOutfitTable){
        FileInputStream fis = null;
        ObjectInputStream in = null;
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try{
            fis = new FileInputStream(listOfUsersFileName);
            in = new ObjectInputStream(fis);
            listOfUsers = (ArrayList<User>)in.readObject();
            User newUser = new User(newUsername, newPassword, newGarmentTable, newOutfitTable);
            listOfUsers.add(newUser);
            in.close();
            
            fos= new FileOutputStream(listOfUsersFileName);
            out = new ObjectOutputStream(fos);
            out.writeObject(listOfUsers);
            out.close();
        }
        catch(FileNotFoundException ex){
            this.writeInitialListFile();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }
    
    public void setUserIndex(int i){
        userIndex = i;
    }
    
    public int getUserIndex(){
        return userIndex;
    }
    
    public User getUser(int i){
        return listOfUsers.get(i);
    }
    
    public String getUsername(int i){
        return listOfUsers.get(i).getUserName();
    }
    
    public String getPassword(int i){
        return listOfUsers.get(i).getPassword();
    }
    
    public ArrayList<Garment> getGarmentTable(int i){
        return listOfUsers.get(i).getGarmentTable();
    }
    
    public ArrayList<Outfit> getOutfitTable(int i){
        return listOfUsers.get(i).getOutfitTable();
    }
    
    public int getListOfUsersSize(){
        ArrayList<User> userListToReturn = readListFile();
        return userListToReturn.size();
    }
    
    public void writeInitialListFile(){
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try{
            fos = new FileOutputStream(listOfUsersFileName);
            out = new ObjectOutputStream(fos);
            out.writeObject(listOfUsers);
            out.close();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }
    
    
}
