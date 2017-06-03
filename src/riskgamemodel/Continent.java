
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
     */
    public Continent(){
        Name = null;
        Owner = null;
        Army = 0;
        Territories = null;
    }
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
     * This method sets the value of the name of the Continet
     * @param value 
     */
    public void setName(String value){
        this.Name = value;
    }
    
    /**
     * This method gets the value of the name of the Continet
     * @return The name of the continent 
     */
    public String getName(){
        return Name;
    }
    
    /**
     * This method gets the value of the territoriy of the Continet
     * @return The array territory of the continent 
     */
    public Territory[] getTerritory(){
        return Territories;
    }
    
    /**
     * This method sets the value of the owner of the Continet
     * @param value 
     */
    public void setOwner(String value){
        this.Owner = value;
    }
    
    /**
     * This method gets the value of the owner of the Continet
     * @return The owner of the continent
     */
    public String getOwner(){
        return Owner;
    }
    
    /**
     * This method sets the value of the army of the Continet
     * @param value 
     */
    public void setArmy(int value){
        this.Army = value;
    }
    
    /**
     * This method gets the value of the army of the Continet
     * @return the army of the continent
     */
    public int getArmy(){
        return Army;
    }
        
        
}
