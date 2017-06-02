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
    public Boundary(int id, Territory[] territories, Territory[] Neighbours1){
        ID = id;
        Territories = territories;
        Neighbours = new Territory[Neighbours1.length];
        for (int i = 0; i < Neighbours.length; i++) {
            this.Neighbours[i] = Neighbours1[i];
        }
    }
    
    /**
     * this method sets the value of id
     * @param value 
     */
    public void setID(int value) {
        this.ID = value;
    }

    /**
     * this method gets the value of ID
     * @return The ID of the boundary
     */
    public int getID() {
        return ID;
    }
    
    /**
     * this method gets the territories
     * @return The array territory 
     */
    public Territory[] getTerritories() {
        return this.Territories;
    }
    
    /**
     * this method gets the neighbours
     * @return The array getNeighbours
     */
    public  Territory[] getNeighbours() {
        return this.Neighbours;
    }
}
