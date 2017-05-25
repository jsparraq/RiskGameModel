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
    private Territory attacker;
    private Territory defender;
    
    
    public Attack(int id, int Army, Die[] Dices2, Die[] Dices3,Territory Attacker,Territory Defender){
        army = Army;
        Attacks = Dices2; 
        Defense = Dices3;
        attacker = Attacker;
        defender = Defender;
    }
    
    public Attack(Territory Attacker,Territory Defender){
        attacker = Attacker;
        defender = Defender;
    }
    public void setarmy(int value){
        this.army = value;
    }
     
    public int getarmy(){
        return army;
    }
    
    public static Attack Declares(Territory TAtaque,Territory TDefensa){
        Attack attack = new Attack(TAtaque,TDefensa);
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
    
    public Territory getAttacker(){
        return attacker;
    }
    
    public Territory getDefender(){
        return defender;
    }
}
