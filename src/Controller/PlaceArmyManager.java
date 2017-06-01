package Controller;

import View.Main_Interface;
import View.Place_army_Interface;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.JFrame;
import riskgamemodel.*;
/**
 *
 * @author UNC Risk Game Model
 */
public class PlaceArmyManager {
    
    /**
     * 
     * @param sessionstart
     * @return 
     */
    public static int armies(Session sessionstart){
        Player[] players = sessionstart.getPlayers();
        Player playerstart = new Player();
        for (Player player : players) {
            if (player.getTurn()) {
                playerstart = player;
            }
        }
        return playerstart.getArmy();
    }
    
    /**
     * 
     * @param sessionstart
     * @return 
     */
    public static String[] Territories(Session sessionstart){
        Player[] players = sessionstart.getPlayers();
        Player playerstart = new Player();
        for (Player player : players) {
            if (player.getTurn()) {
                playerstart = player;
            }
        }
        ArrayList<Territory> territoryplayer = new ArrayList();
        Continent[] continents = sessionstart.getMap().getContinents();
        for (Continent continent : continents) {
            Territory[] territories = continent.getTerritory();
            for (Territory territorie : territories) {
                if (territorie.getOwner().equals(playerstart.getColor()) || territorie.getArmy() == 0) {
                    territoryplayer.add(territorie);
                }
            }
        }
        String[] territoriesplayer = new String[territoryplayer.size()];
        for (int i = 0; i < territoryplayer.size(); i++) {
            territoriesplayer[i] = territoryplayer.get(i).getString();
        }
        return territoriesplayer;
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
     * @param window
     * @param name_territory 
     */
    public static void Button_Finish(Session sessionstart, JFrame window, String name_territory){
        Player[] players = sessionstart.getPlayers();
        Player playerstart = new Player();
        for (Player player : players) {
            if (player.getTurn()) {
                playerstart = player;
                break;
            }
        }
        
        ArrayList<Territory> territoryplayer = new ArrayList();
        Continent[] continents = sessionstart.getMap().getContinents();
        for (Continent continent : continents) {
            Territory[] territories = continent.getTerritory();
            for (Territory territorie : territories) {
                if (territorie.getOwner().equals(playerstart.getColor()) || territorie.getArmy() == 0) {
                    territoryplayer.add(territorie);
                }
            }
        }
        Territory territory = new Territory();
        for (int i = 0; i < territoryplayer.size(); i++) {
            if(name_territory.equals(territoryplayer.get(i).getString())){
                territory = territoryplayer.get(i);
                break;
            }
        }

        Player.Places(playerstart, territory);
        window.setVisible(false);
        if(playerstart.getArmy() > 0 && sessionstart.getState().equals("RUN")){
            new Place_army_Interface(sessionstart).setVisible(true);
        }else{
            new Main_Interface(sessionstart).setVisible(true);
        }  
    }
}
