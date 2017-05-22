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
public class Neighbour extends Territory{
    
    private Attack[] Attacks;
    
    public static void Conquers(Player conqueror, Neighbour conquered){
        
    }

    public Neighbour(String name, String owner, int army, Attack[] att) {
        super(name, owner, army, att);
    }


}
