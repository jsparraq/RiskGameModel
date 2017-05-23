/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import View.Main_Interface;
import View.Place_army_Interface;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.JFrame;
import riskgamemodel.*;
/**
 *
 * @author user
 */
public class PlaceArmyManager {
    
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
    
    public static String Map(Session sessionstart){
        return "/images/" + sessionstart.getMap().getName() + ".png";
    } 
    
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
