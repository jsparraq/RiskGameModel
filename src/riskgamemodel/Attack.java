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
    private int army;
    private Die[] Dice;
    
    
    public Attack(int id, int Army, Die[] Dices1){
        army = Army;
        Dice = Dices1;        
    }
    
    public Attack(){
        
    }
    public void setarmy(int value){
        this.army = value;
    }
     
    public int getarmy(){
        return army;
    }
    
    public static Attack Declares(Territory TAtaque,Territory TDefensa){
        Attack attack = new Attack();
        return attack;
    }
    public void setDice(Die[] dice){
        Dice = dice;
    }
    
    public Die[] getDice(){
        return Dice;
    }
    
    
}
