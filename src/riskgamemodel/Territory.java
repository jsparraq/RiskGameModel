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
    
    public Territory(){
        
    }
    public Territory(String name, String owner, int army){
        Name = name;
        Owner = owner;
        Army = army;
    }
    
    public void setName(String value) {
        this.Name = value;
    }
    
    public String getName() {
        return Name;
    }
    
    public void setOwner(String value) {
        this.Owner = value;
    }
    
    public String getOwner() {
        return Owner;
    }
    
    public void setArmy(int value) {
        this.Army = value;
    }
    
    public int getArmy() {
        return Army;
    }
    
    public String getString() {
        if(Owner.equals("WHITE")){
            return Name + " - " + Integer.toString(Army) + " without owner";
        }
        return Name + " - " + Integer.toString(Army);
    }
    
    public static void Moves(Territory TerritoryA, Territory TerritoryB) {
        TerritoryA.setArmy(TerritoryA.getArmy() - 1);
        TerritoryB.setArmy(TerritoryB.getArmy() + 1);
    }
    
}
