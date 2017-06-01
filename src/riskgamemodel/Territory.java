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
     * 
     */
    public Territory(){
        Name = null;
        Owner = null;
        Army = 0;
    }
    
    /**
     * 
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
     * 
     * @param value 
     */
    public void setName(String value) {
        this.Name = value;
    }
    
    /**
     * 
     * @return the name's territory 
     */
    public String getName() {
        return Name;
    }
    
    /**
     * 
     * @param value 
     */
    public void setOwner(String value) {
        this.Owner = value;
    }
    
    /**
     * @return The owner's territory
     */
    public String getOwner() {
        return Owner;
    }
    
    /**
     * 
     * @param value 
     */
    public void setArmy(int value) {
        this.Army = value;
    }
    
    
    /**
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
     * 
     * @param TerritoryA
     * @param TerritoryB 
     */
    public static void Moves(Territory TerritoryA, Territory TerritoryB) {
        TerritoryA.setArmy(TerritoryA.getArmy() - 1);
        TerritoryB.setArmy(TerritoryB.getArmy() + 1);
    }
    
}
