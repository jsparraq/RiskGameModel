/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.Accepts_Turn_Interface;
import View.Trade_Cards_Interface;
import javax.swing.JFrame;
import riskgamemodel.*;
/**
 * @author user
 */
public class AcceptTurnManager {
    
    public AcceptTurnManager(Session sessionstart){
        new Accepts_Turn_Interface(sessionstart).setVisible(true);
    }
    
    public static void Button_finish(Session session, JFrame window){
        Player[] players = session.getPlayers();
        Player playerstart = new Player();
        for (Player player : players) {
            if (player.getTurn()) {
                playerstart = player;
                break;
            }
        }
        Player.accepts(playerstart,session);
        window.setVisible(false);
        new Trade_Cards_Interface(session).setVisible(true);
    }
}
