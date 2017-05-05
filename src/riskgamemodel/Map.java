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
public class Map {
    private String Name;
    private Continent[] Continents;
    private Card[] Cards;
    private Boundary Boundary;
    
    public void setName(String value){
        Name = value;
    }
    
    public String getName(){
        return Name;
    }
    
}
