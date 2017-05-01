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
    private ArrayList<Territory> Territories;
    private ArrayList<Neighbour> Neighbours;

    public void setID(int value) {
        this.ID = value;
    }

    public int getID() {
        return ID;
    }
}
