/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fashionforecast;

/**
 *
 * @author jared
 */
public class LoginCntl {
    private UserList theUserList;
    private LoginUI theLoginUI;
    private boolean valueToReturn;
    private int userIndex;
    
    public LoginCntl(){
        theLoginUI = new LoginUI(this);
        getUserList();
    }
    
    public void getLoginUI(){
        theLoginUI.setVisible(true);
    }
    
    public User getUser(int userIndex){
        User currentUser = getUserList().getUser(userIndex);
        return currentUser;
    }
    
    public UserList getUserList(){
        if (theUserList == null){
            theUserList = new UserList();
            return theUserList;
        }
        else{
            return theUserList;
        }
    }
    
    public void getMainMenuCntl(){
        MainMenuCntl theMainMenuCntl = new MainMenuCntl(this);
    }
    
    public void getNewUserCntl(){
        NewUserCntl theNewUserCntl = new NewUserCntl(this);
    }
    
    public Boolean authenticate(String username, String password){
        UserList theUserList = new UserList();
        int userListSize = theUserList.getListOfUsersSize();
        for (int i = 0; i < userListSize; i++){
            if (username.equals(theUserList.getUsername(i)) && password.equals(theUserList.getPassword(i))){
                valueToReturn = true;
                userIndex = i;
                theUserList.setUserIndex(userIndex);
                break;
            }
            else{
                valueToReturn = false;
            }
        }
        return valueToReturn;
    }
    
    
}
