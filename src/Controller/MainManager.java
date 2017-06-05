/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.Declare_attack_Interface;
import View.Move_Army_Interface;
import javax.swing.JFrame;
import riskgamemodel.*;

/**
 *
 * @author UNC Risk Game Model
 */
public class MainManager {
    
    /**
     * 
     * @param sessionstart
     * @param window 
     * @param playerstart 
     */
    public static void Button_Attack(Session sessionstart,JFrame window,Player playerstart){
        window.setVisible(false);
        new Declare_attack_Interface(sessionstart,playerstart).setVisible(true);
    }
    
    /**
     * 
     * @param sessionstart
     * @param window 
     */
    public static void Button_Moves(Session sessionstart,JFrame window){
        window.setVisible(false);
        new Move_Army_Interface(sessionstart).setVisible(true);
    }
    
    /**
     * 
     * @param sessionstart
     * @param window 
     */
    public static void Button_Pass(Session sessionstart,JFrame window){
        Player[] players = sessionstart.getPlayers();
        Player playerstart = new Player();
        for (Player player : players) {
            if (player.getTurn()) {
                playerstart = player;
                break;
            }
        }
        Player.Passes(playerstart, sessionstart.getMap().getCards(), sessionstart);
        window.setVisible(false);
        System.out.println("SE ACABO EL TURNO");
        AcceptTurnManager acceptTurnManager = new AcceptTurnManager(sessionstart);
    }
    
    /**
     * 
     * @param sessionstart
     * @return 
     */
    public static String Map(Session sessionstart){
        return "/images/" + sessionstart.getMap().getName() + ".png";
    } 
    
    /**
     * 
     * @param sessionstart
     * @return 
     */
    public static boolean stateSession(Session sessionstart){
        return !"START PLACE ARMY".equals(sessionstart.getState());
    }
}
