
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
     * This method is the construct of Continent class
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
     * @param value 
     */
    public void setName(String value){
        this.Name = value;
    }
    
    /**
     * @return The name of the continent 
     */
    public String getName(){
        return Name;
    }
    
    /**
     * @return The array territory of the continent 
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
     * @return The owner of the continent
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
     * @return the army of the continent
     */
    public int getArmy(){
        return Army;
    }
        
        
}
