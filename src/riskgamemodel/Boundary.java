package riskgamemodel;


/**
 * @author UNC_RiskGameModel
 */
public class Boundary {

    private int ID;
    private Territory[] Territories;
    private Territory[] Neighbours;
    
    /**
     * This method is the constructor of Boundary class.
     * @param id
     * @param territories
     * @param Neighbours 
     */
    public Boundary(int id, Territory[] territories, Territory[] Neighbours){
        ID = id;
        Territories = territories;
        Neighbours = new Territory[Neighbours.length];
        for (int i = 0; i < Neighbours.length; i++) {
            this.Neighbours[i] = Neighbours[i];
        }
    }
    
    /**
     * @param value 
     */
    public void setID(int value) {
        this.ID = value;
    }

    /**
     * @return The ID of the boundary
     */
    public int getID() {
        return ID;
    }
    
    /**
     * @return The array territory 
     */
    public Territory[] getTerritories() {
        return this.Territories;
    }
    
    /**
     * @return The array getNeighbours
     */
    public  Territory[] getNeighbours() {
        return this.Neighbours;
    }
}
