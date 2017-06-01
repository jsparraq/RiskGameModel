package riskgamemodel;


/**
 * @author UNC Risk Game Model
 */
public class Session {
    private static Session session;
    private int ID;
    private String State;
    private Player[] players;
    private Map map;
    
    private Session(){}
    /**
     * 
     * @param id
     * @param state
     * @param Players
     * @param map1 
     */
    public Session(int id, String state,Player[] Players, Map map1){
        ID = id;
        State = state;
        players = Players;
        map = map1;
    }
    
    
    /**
     * 
     * @param value 
     */
    public void setID(int value){
        this.ID = value;
    }
    
    /**
     * 
     * @return 
     */
    public int getID(){
        return ID;
    }
    
    /**
     * 
     * @param value 
     */
    public void setStete(String value){
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
     * 
     * @return 
     */
    public Player[] getPlayers(){
        return players;
    }
    
    /**
     * 
     * @return 
     */
    public Map getMap(){
        return this.map;
    }
}
