/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsd.controller.risk;

import dsd.view.risk.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFrame;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import dsd.model.risk.*;

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
        MainManager.finishturn(sessionstart);
        System.exit(0);
    }
    
    /**
     * 
     * @param sessionstart
     * @return 
     */
    public static String Map(Session sessionstart){
        return "/dsd/view/images/" + sessionstart.getMap().getName() + ".png";
    } 
    
    /**
     * 
     * @param sessionstart
     * @return 
     */
    public static boolean stateSession(Session sessionstart){
        return !"START PLACE ARMY".equals(sessionstart.getState());
    }
    
    public static void finishturn(Session sessionstart){
        
        JSONObject json = new JSONObject();
        json.put("ID",String.valueOf(sessionstart.getID()));
        json.put("type",sessionstart.getType());
        json.put("state",sessionstart.getState());
        Player[] players = sessionstart.getPlayers();
        //Add the players 
        JSONArray ply = new JSONArray();
        JSONObject aux = new JSONObject();
        for (int i = 0; i < players.length; i++) {
            JSONObject pla = new JSONObject();
            pla.put("turn",String.valueOf(players[i].getTurn()));
            pla.put("playing",String.valueOf(players[i].getplaying()));
            pla.put("color",players[i].getColor());
            pla.put("capturestate",players[i].getCaptureState());
            pla.put("territoryamount",String.valueOf(players[i].getTerritoryAmount()));
            pla.put("continentamount",String.valueOf(players[i].getContinentAmount()));
            pla.put("cardamount",String.valueOf(players[i].getCardAmount()));
            pla.put("trades",String.valueOf(players[i].gettrades()));
            pla.put("army",String.valueOf(players[i].getArmy()));
            aux.put("Player"+(i+1),pla);
        }
        ply.add(aux);

        json.put("players",ply);

        JSONObject map = new JSONObject();
        //Create the map
        map.put("name", sessionstart.getMap().getName());
        JSONArray ab = new JSONArray();
        JSONObject cards = new JSONObject();
        //Add the cards
        for(int i = 0; i < sessionstart.getMap().getCards().length; i++){
            JSONObject card = new JSONObject();
            card.put("desing",sessionstart.getMap().getCards()[i].getDesign());
            card.put("owner",sessionstart.getMap().getCards()[i].getOwner());
            card.put("type",sessionstart.getMap().getCards()[i].getType());
            card.put("territory",sessionstart.getMap().getCards()[i].getTerritory().getName());
            cards.put("Card"+(i+1),card);
        }
        ab.add(cards);
        map.put("cards",ab);
        JSONArray a = new JSONArray();
        JSONObject continent = new JSONObject();
        //Add the continents
        for(int i = 0; i < sessionstart.getMap().getContinents().length; i++){
            JSONObject con = new JSONObject();
            con.put("name",sessionstart.getMap().getContinents()[i].getName());
            con.put("army",String.valueOf(sessionstart.getMap().getContinents()[i].getArmy()));
            con.put("owner",sessionstart.getMap().getContinents()[i].getOwner());

            JSONArray aux2 = new JSONArray();
            JSONObject territory = new JSONObject();
            //Add the territories
            for(int j = 0; j < sessionstart.getMap().getContinents()[i].getTerritory().length; j++){
                JSONObject ter = new JSONObject();
                ter.put("name",sessionstart.getMap().getContinents()[i].getTerritory()[j].getName());
                ter.put("owner",sessionstart.getMap().getContinents()[i].getTerritory()[j].getOwner());
                ter.put("capital",String.valueOf(sessionstart.getMap().getContinents()[i].getTerritory()[j].getCapital()));
                ter.put("army",String.valueOf(sessionstart.getMap().getContinents()[i].getTerritory()[j].getArmy()));
                territory.put("Territory"+(j+1),ter);
            }
            aux2.add(territory);
            con.put("Territories", aux2);
            continent.put("Continent"+(i+1),con);
        }
        a.add(continent);

        map.put("continents", a);
        //Add the map
        json.put("map",map);
        JSONObject json2 = new JSONObject();
        //Create the session
        json2.put("session",json);
        System.out.println(json);
        try{
            PrintWriter writer = new PrintWriter("NewStateSession.json", "UTF-8");
            writer.println(json2);
            writer.close();
        } catch (IOException e) {
           // do something
        }
        
    }
}
