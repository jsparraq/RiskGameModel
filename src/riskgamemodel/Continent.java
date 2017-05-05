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
public class Continent {
    private String Name;
    private String Owner;
    private int Army;
    private Territory[] Territories;
    
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
