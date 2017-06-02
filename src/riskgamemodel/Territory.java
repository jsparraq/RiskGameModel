package riskgamemodel;

/**
 *
 * @author Sebastian
 */
public class Territory {
    
    private String Name;
    private String Owner;
    private int Army;
    
    /**
     * This method creates a territory
     */
    public Territory(){
        Name = null;
        Owner = null;
        Army = 0;
    }
    
    /**
     * This method creates an object of Territory
     * @param name
     * @param owner
     * @param army 
     */
    public Territory(String name, String owner, int army){
        Name = name;
        Owner = owner;
        Army = army;
    }
    
    /**
     * This method sets the value of the territoy
     * @param value 
     */
    public void setName(String value) {
        this.Name = value;
    }
    
    /**
     * This method gets the value of the territoy
     * @return the name's territory 
     */
    public String getName() {
        return Name;
    }
    
    /**
     * This method sets the owner of the territoy
     * @param value 
     */
    public void setOwner(String value) {
        this.Owner = value;
    }
    
    /**
     * This method gets the owner of the territoy
     * @return The owner's territory
     */
    public String getOwner() {
        return Owner;
    }
    
    /**
     * This method sets the army of the territoy
     * @param value 
     */
    public void setArmy(int value) {
        this.Army = value;
    }
    
    
    /**
     * This method gets the army of the territoy
     * @return The army's territory
     */
    public int getArmy() {
        return Army;
    }
    
    /**
     * @return The name and army of the territory. If the territory does not have owner then add without owner in the string return  
     */
    public String getString() {
        if(Owner.equals("WHITE")){
            return Name + " - " + Integer.toString(Army) + " without owner";
        }
        return Name + " - " + Integer.toString(Army);
    }
    
    /**
     * This method lets move an army from one territory to other.
     * @param TerritoryA
     * @param TerritoryB 
     */
    public static void Moves(Territory TerritoryA, Territory TerritoryB) {
        TerritoryA.setArmy(TerritoryA.getArmy() - 1);
        TerritoryB.setArmy(TerritoryB.getArmy() + 1);
    }
    
}
