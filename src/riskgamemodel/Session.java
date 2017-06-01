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
    
    private Session(){}
    
    /**
     * This method create a object of Session
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
     * 
     * @param value 
     */
    public void setID(int value){
        this.ID = value;
    }
    
    /**
     * @return The ID of the session
     */
    public int getID(){
        return ID;
    }
    
    /**
     * 
     * @param value 
     */
    public void setState(String value){
        this.State = value;
    }
    
    /**
     * 
     * @return 
     */
    public String getState(){
        return State;
    }
    
    /**
     * @return The players of the session
     */
    public Player[] getPlayers(){
        return players;
    }
    
    /**
     * 
     * @return The map of the session
     */
    public Map getMap(){
        return this.map;
    }
    /**
     * @param value 
     */
    public void setType(String value){
        Type = value;
    }
    
    /**
     * @return The type of the session
     */
    public String getType(){
        return Type;
    }
}
