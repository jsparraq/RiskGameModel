package Controller;

import View.Accepts_Turn_Interface;
import View.Trade_Cards_Interface;
import javax.swing.JFrame;
import riskgamemodel.*;
/**
 * @author UNC Risk Game Model
 */
public class AcceptTurnManager {
    
    /**
     * 
     * @param sessionstart 
     */
    public AcceptTurnManager(Session sessionstart){
        new Accepts_Turn_Interface(sessionstart).setVisible(true);
    }
    
    /**
     * 
     * @param session
     * @param window 
     */
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
