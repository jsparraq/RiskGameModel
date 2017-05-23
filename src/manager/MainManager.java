/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import javax.swing.JFrame;
import riskgamemodel.*;

/**
 *
 * @author user
 */
public class MainManager {
    
    public static void Button_Pass(Session sessionstart,JFrame window){
        Player[] players = sessionstart.getPlayers();
        Player playerstart = new Player();
        for (Player player : players) {
            if (player.getTurn()) {
                playerstart = player;
                break;
            }
        }
        Player.Passes(playerstart, Session.getSession().getMap().getCards());
        window.setVisible(false);
        System.out.println("SE ACABO EL TURNO");
        
    }
}
