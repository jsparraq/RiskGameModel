/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package riskgamemodel;


/**
 * @author UNC_RiskGameModel
 */
public class Boundary {

    private int ID;
    private Territory[] Territories;
    private Territory[] Neighbours;
    /**
     * 
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
     * 
     * @param value 
     */
    public void setID(int value) {
        this.ID = value;
    }

    /**
     * 
     * @return 
     */
    public int getID() {
        return ID;
    }
    
    /**
     * 
     * @return 
     */
    public Territory[] getTerritories() {
        return this.Territories;
    }
    /**
     * 
     * @return 
     */
    public  Territory[] getNeighbours() {
        return this.Neighbours;
    }
}
