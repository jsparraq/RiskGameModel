package Controller;

import View.Main_Interface;
import java.util.ArrayList;
import javax.swing.JFrame;
import riskgamemodel.*;

/**
 *
 * @author UNC Risk Game Model 
 */
public class MoveArmyManager {
    
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
                if (territorie.getOwner().equals(playerstart.getColor()) && territorie.getArmy()>1) {
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
     * @param territory
     * @return 
     */
    public static String[] neighbours(Session sessionstart,String territory){
        Player[] players = sessionstart.getPlayers();
        Player playerstart = new Player();
        for (Player player : players) {
            if (player.getTurn()) {
                playerstart = player;
            }
        }
        Territory territoryA = new Territory();
        Continent[] continents = sessionstart.getMap().getContinents();
        for (Continent continent : continents) {
            Territory[] territories = continent.getTerritory();
            for (Territory territorie : territories) {
                if (territorie.getString().equals(territory)) {
                    territoryA = territorie;
                }
            }
        }
        Territory[] territories = sessionstart.getMap().getboundary().getTerritories();
        Territory[] neighbours = sessionstart.getMap().getboundary().getNeighbours();
        ArrayList<String> Neighbours = new ArrayList();
        for (int i = 0; i < territories.length; i++) {
            if (territories[i] == territoryA && neighbours[i].getOwner().equals(playerstart.getColor())){
                Neighbours.add(neighbours[i].getString());
            }
        }
        String[] NEIGHBOURS = new String[Neighbours.size()];
        for (int i = 0; i < Neighbours.size(); i++) {
            NEIGHBOURS[i] = Neighbours.get(i);
        }
        return NEIGHBOURS;
    }
    
    /**
     * 
     * @param window
     * @param territory
     * @param Neighbour
     * @param sessionstart 
     */
    public static void Button_Finish(JFrame window,String territory, String Neighbour,Session sessionstart){
        Territory territoryA = new Territory();
        Territory territoryB = new Territory();
        Continent[] continents = sessionstart.getMap().getContinents();
        for (Continent continent : continents) {
            Territory[] territories = continent.getTerritory();
            for (Territory territorie : territories) {
                if (territorie.getString().equals(territory)) {
                    territoryA = territorie;
                }else if(territorie.getString().equals(Neighbour)){
                    territoryB = territorie;
                }
            }
        }
        Territory.Moves(territoryA, territoryB);
        window.setVisible(false);
        new Main_Interface(sessionstart,"a").setVisible(true);
    }
}
