/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.Declare_attack_Interface;
import View.Move_Army_Interface;
import javax.swing.JFrame;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
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
        MainManager.finishturn(sessionstart);
        System.exit(0);
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
    
    public static void finishturn(Session sessionstart){
        
        JSONObject session = new JSONObject();                
        JSONObject innerObj = new JSONObject();
        innerObj.put("ID", String.valueOf(sessionstart.getID()));
        innerObj.put("type", sessionstart.getType());
        innerObj.put("state",sessionstart.getState());
        
        int tam = sessionstart.getPlayers().length;
        JSONArray players = new JSONArray(); 
        
        for (int i = 0; i < tam; i++) {
            JSONObject player1 = new JSONObject();
            player1.put("turn", String.valueOf(sessionstart.getPlayers()[i].getTurn()));
            player1.put("playing",String.valueOf(sessionstart.getPlayers()[i].getplaying()));
            player1.put("color",sessionstart.getPlayers()[i].getColor());
            player1.put("capturestate",sessionstart.getPlayers()[i].getCaptureState());
            player1.put("territory_amount", String.valueOf(sessionstart.getPlayers()[i].getTerritoryAmount()));
            player1.put("continent_amount",String.valueOf(sessionstart.getPlayers()[i].getContinentAmount()));
            player1.put("card_amount",String.valueOf(sessionstart.getPlayers()[i].getCardAmount()));
            player1.put("trades",String.valueOf(sessionstart.getPlayers()[i].gettrades()));
            player1.put("army",String.valueOf(sessionstart.getPlayers()[i].getArmy()));
            
            JSONObject jugadori = new JSONObject();
            jugadori.put("Player" + (i + 1), player1);
            
            players.add(jugadori);
        }
        JSONObject inner_map = new JSONObject();
        inner_map.put("name", sessionstart.getMap().getName());
        
        JSONArray cards = new JSONArray();
        JSONObject cartai = new JSONObject();
        for (int i = 0; i < sessionstart.getMap().getCards().length; i++) {
            JSONObject carta1 = new JSONObject();
        
            carta1.put("design",sessionstart.getMap().getCards()[i].getDesign());
            carta1.put("owner", sessionstart.getMap().getCards()[i].getOwner());
            carta1.put("type", sessionstart.getMap().getCards()[i].getType());
            carta1.put("territory",sessionstart.getMap().getCards()[i].getTerritory().getName());

            cartai.put("Card" + (i + 1), carta1);

            cards.add(cartai);
        }
        inner_map.put("cards", cards);
        
        
        JSONArray continents = new JSONArray();
        JSONObject continenti = new JSONObject();
       
        
        for (int i = 0; i < sessionstart.getMap().getContinents().length; i++) {
            
            JSONArray territories = new JSONArray();
            JSONObject territoriesi = new JSONObject();
            
            JSONObject continent1 = new JSONObject();
            continent1.put("name", sessionstart.getMap().getContinents()[i].getName());
            continent1.put("army", String.valueOf(sessionstart.getMap().getContinents()[i].getArmy()));
            continent1.put("owner", sessionstart.getMap().getContinents()[i].getOwner());
            
            for (int j = 0; j < sessionstart.getMap().getContinents()[i].getTerritory().length; j++) {
                JSONObject territory1 = new JSONObject();
                
                territory1.put("name", sessionstart.getMap().getContinents()[i].getTerritory()[j].getName());
                territory1.put("owner", sessionstart.getMap().getContinents()[i].getTerritory()[j].getOwner());
                territory1.put("capital", String.valueOf(sessionstart.getMap().getContinents()[i].getTerritory()[j].getCapital()));
                territory1.put("army", String.valueOf(sessionstart.getMap().getContinents()[i].getTerritory()[j].getArmy()));
                territoriesi.put("Territory"+(j+1),territory1);
                territories.add(territoriesi);
            }
            continent1.put("territories", territories);
            continents.add(continenti);
        }
        inner_map.put("continents",continents);
        
        innerObj.put("map", inner_map);
        innerObj.put("players", players);
        session.put("session", innerObj);
        
        System.out.println(session.toJSONString());
    }
}
