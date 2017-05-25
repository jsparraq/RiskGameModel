/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import View.Main_Interface;
import View.Roll_Dice_Interface;
import java.util.ArrayList;
import javax.swing.JFrame;
import riskgamemodel.*;

/**
 *
 * @author user
 */
public class AttackManager {

    public static String[] Territories(Session sessionstart) {
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
                if (territorie.getOwner().equals(playerstart.getColor()) && territorie.getArmy() > 1) {
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

    public static String[] neighbours(Session sessionstart, String territory) {
        Player[] players = sessionstart.getPlayers();
        Player playerstart = new Player();
        for (Player player : players) {
            if (player.getTurn()) {
                playerstart = player;
                break;
            }
        }
        Territory territoryA = new Territory();
        Continent[] continents = sessionstart.getMap().getContinents();
        for (Continent continent : continents) {
            Territory[] territories = continent.getTerritory();
            for (Territory territorie : territories) {
                if (territorie.getString().equals(territory)) {
                    territoryA = territorie;
                    break;
                }
            }
        }
        
        Territory[] territories = sessionstart.getMap().getboundary().getTerritories();
        Territory[] neighbours = sessionstart.getMap().getboundary().getNeighbours();
        ArrayList<String> Neighbours1 = new ArrayList();
        for (int i = 0; i < territories.length; i++) {
            if (territories[i] == territoryA && !neighbours[i].getOwner().equals(playerstart.getColor())) {
                Neighbours1.add(neighbours[i].getString());
            }
        }
        
        String[] NEIGHBOURS = new String[Neighbours1.size()];
        for (int i = 0; i < Neighbours1.size(); i++) {
            NEIGHBOURS[i] = Neighbours1.get(i);
        }
        return NEIGHBOURS;
    }

    public static String Map(Session sessionstart) {
        return "/images/" + sessionstart.getMap().getName() + ".png";
    }

    public static void button_Finish(JFrame window, Session sessionstart) {
        window.setVisible(false);
        new Main_Interface(sessionstart).setVisible(true);
    }

    public static void button_RollDie(JFrame window, Session sessionstart, String TerrAtt, String TerrDef) {

        Continent[] continents = sessionstart.getMap().getContinents();
        Territory territoryattack = new Territory();
        Territory territorydefend = new Territory();
        for (Continent continent : continents) {
            Territory[] territories = continent.getTerritory();
            for (Territory territorie : territories) {
                if (TerrAtt.equals(territorie.getString())) {
                    territoryattack = territorie;
                } else if (TerrDef.equals(territorie.getString())) {
                    territorydefend = territorie;
                }
            }
        }    
        
        Attack attack = Attack.Declares(territoryattack, territorydefend);
        window.setVisible(false);
        new Roll_Dice_Interface(sessionstart,attack).setVisible(true);
    }
}
