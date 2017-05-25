/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import View.Main_Interface;
import javax.swing.JFrame;
import riskgamemodel.*;

/**
 *
 * @author user
 */
public class ConquersNeighbourManager {
    
    public static String Map(Session sessionstart){
        return "/images/" + sessionstart.getMap().getName() + ".png";
    } 
    
    public static String[] armies(Attack attack){
        int inicial = attack.getarmy();
        int Final = attack.getAttacker().getArmy();
        String[] armies = new String[Final - inicial];
        int j = 0;
        for (int i = inicial; i < Final; i++) {
            armies[j]= Integer.toString(i);
            j++;
        }
        return armies;
    }
    
    public static void Button_Finish(Attack attack,JFrame window,String army,Session sessionstart){
        Player[] players = sessionstart.getPlayers();
        Player playerstart = new Player();
        for (Player player : players) {
            if (player.getTurn()) {
                playerstart = player;
            }
        }
        attack.getAttacker().setArmy(attack.getAttacker().getArmy() - Integer.parseInt(army));
        attack.getDefender().setArmy(attack.getDefender().getArmy() + Integer.parseInt(army));
        attack.getDefender().setOwner(playerstart.getColor());
        playerstart.setCaptureState("CAPTURE");
        window.setVisible(false);
        new Main_Interface(sessionstart).setVisible(true);
    }
}
