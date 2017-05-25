/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import riskgamemodel.Attack;
import riskgamemodel.Session;

/**
 *
 * @author user
 */
public class ConquersNeighbourManager {
    
    public static String Map(Session sessionstart){
        return "/images/" + sessionstart.getMap().getName() + ".png";
    } 
    
    public static String[] armies(Attack attack){
        return new String[]{};
    }
}
