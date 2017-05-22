/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package riskgamemodel;

import java.util.ArrayList;

/**
 *
 * @author Sebastian
 */
public class Boundary {

    private int ID;
    private Territory[] Territories;
    private Neighbour[] Neighbours;
    
    public Boundary(int id, Territory[] territories, Territory[] territories1){
        ID = id;
        Territories = territories;
        Neighbours = new Neighbour[territories1.length];
        for (int i = 0; i < territories1.length; i++) {
            Neighbours[i] = new Neighbour(territories1[i].getName(),territories1[i].getOwner(),territories1[i].getArmy(),territories1[i].getAttacks());
        }
    }
    public void setID(int value) {
        this.ID = value;
    }

    public int getID() {
        return ID;
    }
}
