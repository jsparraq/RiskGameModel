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
     * @return 
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
     * 
     * @return 
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
     * 
     * @return 
     */
    public int getArmy() {
        return Army;
    }
    
    /**
     * 
     * @return 
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
