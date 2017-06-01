
package riskgamemodel;

/**
 * @author UNC_RiskGameModel
 */
public class Continent {
    private String Name;
    private String Owner;
    private int Army;
    private Territory[] Territories;
    
    /**
     * 
     * @param name
     * @param owner
     * @param army
     * @param terr 
     */
    public Continent(String name, String owner, int army, Territory[] terr){
        Name = name;
        Owner = owner;
        Army = army;
        Territories = terr;
    }
    
    /**
     * 
     * @param value 
     */
    public void setName(String value){
        this.Name = value;
    }
    
    /**
     * 
     * @return 
     */
    public String getName(){
        return Name;
    }
    
    /**
     * 
     * @return 
     */
    public Territory[] getTerritory(){
        return Territories;
    }
    
    /**
     * 
     * @param value 
     */
    public void setOwner(String value){
        this.Owner = value;
    }
    
    /**
     * 
     * @return 
     */
    public String getOwner(){
        return Owner;
    }
    
    /**
     * 
     * @param value 
     */
    public void setArmy(int value){
        this.Army = value;
    }
    
    /**
     * 
     * @return 
     */
    public int getArmy(){
        return Army;
    }
        
        
}
