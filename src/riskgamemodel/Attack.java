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
public class Attack {
    private int ID;
    private ArrayList<Die> Dice;
    
    public void setID(int value){
        this.ID = value;
        System.out.println("asdas");
    }
      public int getID(){
        return ID;
    }
 
}
