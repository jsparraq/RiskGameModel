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
    private int army;
    private Die[] Dice;
    
    public void setID(int value){
        this.ID = value;
    }
      public int getID(){
        return ID;
    }
      
     public void setarmy(int value){
        this.army = value;
    }
      public int getarmy(){
        return army;
    }
    
    public static void Declares(Territory TAtaque,Territory TDefensa){
    }
 
}
