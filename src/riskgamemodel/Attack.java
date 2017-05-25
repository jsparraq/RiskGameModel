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
    private Die[] Attacks;
    private Die[] Defense;
    
    
    public Attack(int id, int Army, Die[] Dices2, Die[] Dices3){
        army = Army;
        Attacks = Dices2; 
        Defense = Dices3;
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
    public void setAttacks(Die[] dice){
        Attacks = dice;
    }
    
    public Die[] getAttacks(){
        return Attacks;
    }
    public void setDefense(Die[] dice){
        Defense = dice;
    }
    
    public Die[] getDefense(){
        return Defense;
    }
    
    
}
