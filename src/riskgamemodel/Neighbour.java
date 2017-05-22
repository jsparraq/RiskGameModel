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
    
    public static void Conquers(Player conqueror, Neighbour conquered,Attack att,Continent[] continents){
        conquered.setOwner(conqueror.getColor());
        
        
         int pass_army =0;
        while(pass_army<att.getarmy()){
            // se tiene que hacer un listener para esto
            // mirar que pasa cuando el atacante queda con menos de los que puede pasar
        System.out.println("Escriba con cuantos va a colocar");
        conquered.setArmy(pass_army);
        }
        String name_of_contient;
        for(int i=0;i<continents.length;i++){
            for(int j=0;j<continents[i].getTerritory().length;j++){
                
            }
        }
        
    }

    public Neighbour(String name, String owner, int army, Attack[] att) {
        super(name, owner, army, att);
    }


}
