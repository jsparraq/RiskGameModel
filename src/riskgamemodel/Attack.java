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
    
    public Attack(int id, int Army, Die[] Dices1){
        ID = id;
        army = Army;
        Dice = Dices1;        
    }
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
    
    public static boolean Declares(Territory TAtaque,Territory TDefensa,Player player,Boundary boundary){
        if(TAtaque.getOwner().equals(player.getColor())&&TAtaque.getArmy()>1&&!TDefensa.getOwner().equals(player.getColor())){
            Neighbour[] neighbours=boundary.getNeighbours();
            Territory[] territories=boundary.getTerritories();
            for(int i =0;i<neighbours.length;i++){
                if(neighbours[i].getName().equals(TDefensa.getName())&&territories[i].getName().equals(TAtaque.getName())){
                    return true; 
                }
            }
        }else{
            return false;
        }
        return false;
    }
    
    
}
