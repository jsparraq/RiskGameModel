package riskgamemodel;

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
    
    public void setName(String name_new){
        this.Name = name_new;
    }
    public String getName(){
        return Name;
    }
    public void setOwner(String owner_new){
        this.Owner = owner_new;
    }
    public String getOwner(){
        return Owner;
    }
    public void setArmy(int army_new){
        this.Army = army_new;
    }
    public int getArmy(){
        return Army;
    }
    
}
