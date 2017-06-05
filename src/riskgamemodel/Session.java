package riskgamemodel;


/**
 * @author UNC Risk Game Model
 */
public class Session {
    
    private int ID;
    private String State;
    private Player[] players;
    private Map map;
    private String Type;
    
    /**
     * 
     */
    private Session(){
        ID = 0;
        State = null;
        players = null;
        map = null;
        Type = null;
    }
    
    /**
     * This method create an object of Session
     * @param id
     * @param state
     * @param Players
     * @param map1 
     */
    public Session(int id, String state,Player[] Players, Map map1, String type){
        ID = id;
        State = state;
        players = Players;
        map = map1;
        Type = type;
    }
    
    
    /**
     * This method sets the value of the id of the session
     * @param value 
     */
    public void setID(int value){
        this.ID = value;
    }
    
    /**
     * This method gets the value of the id of the session
     * @return The ID of the session
     */
    public int getID(){
        return ID;
    }
    
    /**
     * This method sets the value of the state of the session
     * @param value 
     */
    public void setState(String value){
        this.State = value;
    }
    
    /**
     * This method gets the value of the state of the session
     * @return 
     */
    public String getState(){
        return State;
    }
    
    /**
     * This method gets the value of the players of the session
     * @return The players of the session
     */
    public Player[] getPlayers(){
        return players;
    }
    
    /**
     * This method gets the value of the map of the session
     * @return The map of the session
     */
    public Map getMap(){
        return this.map;
    }
    /**
     * This method sets the type value of the session
     * @param value 
     */
    public void setType(String value){
        Type = value;
    }
    
    /**
     *  This method gets the type value of the session
     * @return The type of the session
     */
    public String getType(){
        return Type;
    }
    
    
}
