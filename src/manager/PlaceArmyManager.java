/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import java.util.ArrayList;
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
}
