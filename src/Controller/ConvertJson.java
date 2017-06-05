/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import riskgamemodel.*;
import View.*;
import java.util.ArrayList;
import org.json.simple.parser.ParseException;

/**
 *
 * @author UNC Risk Game Model
 */

public class ConvertJson {
    
    
    public static void createSession(String json) {
        try
        {
            JSONParser parser = new JSONParser();
            String jsonToString = "[" + json + "]";
            Object object = parser.parse(jsonToString);
            JSONArray jsonArray = (JSONArray) object;   
            JSONObject jsonObject = (JSONObject) jsonArray.get(0);
            
            JSONObject session = (JSONObject)jsonObject.get("session");
            
            int id = Integer.parseInt((String) session.get("ID"));            
            String type_ = (String) session.get("type");            
            String state = (String) session.get("state"); 
            
            JSONArray players = (JSONArray) session.get("players");                             
            Player[] players1 = new Player[players.size()];         
            for (int i=0; i < players.size();i++) {  
                    JSONObject jugador = (JSONObject) players.get(i); 
                    String nombre = "Player"+(i+1);                    
                    JSONObject jugadorsito = (JSONObject)jugador.get(nombre);                                
                    boolean turn = Boolean.parseBoolean((String) jugadorsito.get("turn"));                    
                    boolean capital = Boolean.parseBoolean((String) jugadorsito.get("capital"));                    
                    String color = (String)jugadorsito.get("color");                    
                    String capturestate = (String)jugadorsito.get("capturestate");
                    int territory_amount = Integer.parseInt((String)jugadorsito.get("territory_amount"));                    
                    int continent_amount = Integer.parseInt((String)jugadorsito.get("continent_amount"));                    
                    int card_amount = Integer.parseInt((String)jugadorsito.get("card_amount"));                    
                    int trades = Integer.parseInt((String)jugadorsito.get("trades"));                    
                    int army = Integer.parseInt((String)jugadorsito.get("army"));                    
                    Player aux = new Player(turn,capital,capturestate,color,territory_amount,continent_amount,card_amount,army,trades);
                    players1[i] = aux;
            }
            
            JSONObject map = (JSONObject)session.get("map");
            
            String name_map = (String)map.get("name"); 
            System.out.println(name_map);
            
            ArrayList<Territory> TERRITORIES = new ArrayList();
            JSONArray continents = (JSONArray) map.get("continents");
            Continent[] continents1 = new Continent[continents.size()];
            for (int i=0; i < continents.size();i++) {                
                JSONObject continente = (JSONObject) continents.get(i);                
                String nombre_continente = "Continent"+(i+1);                
                JSONObject continentico = (JSONObject)continente.get(nombre_continente);
                String continent_name = (String)continentico.get("name");
                int continent_army = Integer.parseInt((String)continentico.get("army"));                
                String continent_owner = (String)continentico.get("owner");                
                
                JSONArray territories = (JSONArray) continentico.get("territories");
                
                Territory[] territories1 = new Territory[territories.size()];
                for (int j = 0;j < territories.size(); j++) {
                        JSONObject territorio = (JSONObject)territories.get(j);
                        String nombre_territorios = "Territory"+(j+1);
                        JSONObject mini_territorio = (JSONObject)territorio.get(nombre_territorios);
                        String territory_name = (String)mini_territorio.get("name");                        
                        String territory_owner = (String)mini_territorio.get("owner");                        
                        boolean territory_capital = Boolean.parseBoolean((String)mini_territorio.get("capital"));  
                        int territory_army = Integer.parseInt((String)mini_territorio.get("army"));
                        Territory aux = new Territory(territory_name,territory_owner,territory_army,territory_capital);
                        territories1[j] = aux;
                        TERRITORIES.add(aux);
                }   
                Continent aux = new Continent(continent_name,continent_owner,continent_army,territories1); 
                continents1[i] = aux;
            }       
            
            JSONArray cards = (JSONArray) map.get("cards");            
            Card[] cards1 = new Card[cards.size()];
            for (int j = 0; j< cards.size(); j++) {                
                JSONObject carta = (JSONObject) cards.get(j);                
                String nombre_carta = "Card"+(j+1);
                 
                JSONObject cartica = (JSONObject)carta.get(nombre_carta);
                String design = (String)cartica.get("design");
                String owner = (String)cartica.get("owner");
                String type = (String)cartica.get("type");                 
                String territory = (String)cartica.get("territory");
                Territory terr = new Territory();
                for (int i = 0; i < TERRITORIES.size(); i++) {
                    if(TERRITORIES.get(i).getName().equals(territory)){
                        terr = TERRITORIES.get(i);
                        break;
                    }
                }
                Card aux = new Card(type,owner,design,terr);
                cards1[j] = aux;
            }
            Map map1 = new Map(name_map,continents1,cards1,new Boundary(3));
            Session sessionstart = new Session(id,state,players1,map1,type_);
            AcceptTurnManager acceptTurnManager = new AcceptTurnManager(sessionstart);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }       
    }    
}
