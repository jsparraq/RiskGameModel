
package dsd.model.game;

import java.util.HashMap;
import java.util.Map;

public class Account {
    private  String playerID;
    private String playerName ;
    private String email;
    private String password;
    private static final Map<String, Account> USERS = new HashMap<String, Account>();

    public Account(){
        
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPlayerID() {
        return playerID;
    }

    public void setPlayerID(String playerID) {
        this.playerID = playerID;
    }

    public String getPlayerName() {
        if(playerName==null){
            playerName="demo";
        }
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    
    
    
}
