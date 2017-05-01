package riskgamemodel;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sebastian
 */
public class Territory {
    private String Name;
    private String Owner;
    private int Army;
    private ArrayList<Attack> Attacks;
    
    public void setName(String value){
        this.Name = value;
    }
    public String getName(){
        return Name;
    }
    public void setOwner(String value){
        this.Owner = value;
    }
    public String getOwner(){
        return Owner;
    }
    public void setArmy(int value){
        this.Army = value;
    }
    public int getArmy(){
        return Army;
    }
    
}
