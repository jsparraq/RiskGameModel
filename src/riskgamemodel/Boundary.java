package riskgamemodel;


/**
 * @author UNC_RiskGameModel
 */
public class Boundary {

    private int ID;
    private final Territory[] Territories = new Territory[]{};
    private final Territory[] Neighbours = new Territory[]{};
    
    /**
     * This method is the constructor of Boundary class.
     * @param id
     */
    public Boundary(int id){
        ID = id;
    }
    
    /**
     * This method sets the value of id of the boundary
     * @param value 
     */
    public void setID(int value) {
        this.ID = value;
    }

    /**
     * This method gets the value of ID of the boundary
     * @return The ID of the boundary
     */
    public int getID() {
        return ID;
    }
    
    /**
     * This method gets the territories of the boundary
     * @return The array territory 
     */
    public Territory[] getTerritories() {
        return this.Territories;
    }
    
    /**
     * This method gets the neighbours of the boundary
     * @return The array getNeighbours
     */
    public  Territory[] getNeighbours() {
        return this.Neighbours;
    }
}
