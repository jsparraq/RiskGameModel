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
        int NAME_CONTINENT=-1;
        int TERRITORY_AMOUNT=-1;
        
        Territory[] territorios_continet=null;
        for(int i=0;i<continents.length;i++){
            Territory[] territorios =continents[i].getTerritory();
            for(int j=0;j<territorios.length;j++){
                if(territorios[j].getName()==conquered.getName()){
                    NAME_CONTINENT = i;
                    TERRITORY_AMOUNT = territorios.length;
                    territorios_continet= territorios;
                    break;
                }
            }
            if(NAME_CONTINENT!=-1){
                break;
            }
        }
        int counter=0;
        for(int i=0;i<TERRITORY_AMOUNT;i++){
            if(territorios_continet[i].getName()==conquered.getName()){
                counter++;
            }
        }
        if(counter==TERRITORY_AMOUNT){
           continents[NAME_CONTINENT].setName(conquered.getName());
        }
        
        
        
    }

    public Neighbour(String name, String owner, int army) {
        super(name, owner, army);
    }


}
