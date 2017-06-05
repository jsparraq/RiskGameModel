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
import org.json.simple.parser.ParseException;

/**
 *
 * @author UNC Risk Game Model
 */

public class ConvertJson {
    
    
    public void createSession(String json) {
        try
        {
            JSONParser parser = new JSONParser();
            String jsonToString = "[" + json + "]";
            Object object = parser.parse(jsonToString);
            
            JSONObject jsonObject = (JSONObject)object;
            
            JSONObject session = (JSONObject)jsonObject.get("session");
            
            Integer id = Integer.parseInt((String) session.get("ID"));
            System.out.println(id);
            
            String type_ = (String) session.get("type");
            System.out.println(type_);
            
            String state = (String) session.get("state"); 
            System.out.println(state);
            
            JSONArray players = (JSONArray) session.get("players");
            
            
            
            String turn;
            String color;
            String capturestate;
            String territory_amount;
            String continent_amount;
            String card_amount;
            String trades;
            String army;
            boolean capital;
                             
                       
            for (int i=0; i < players.size();i++) {               
           
                    JSONObject jugador = (JSONObject) players.get(i);                                    
                                                          
                    String nombre = "Player"+(i+1);
                    System.out.println("el nombre es: " + nombre);
                    
                    JSONObject jugadorsito = (JSONObject)jugador.get(nombre);
                                
                    turn = (String) jugadorsito.get("turn");
                    System.out.println(turn);
                    
                    capital = Boolean.parseBoolean((String) jugadorsito.get("capital"));
                    System.out.println(capital);
                    
                    color = (String)jugadorsito.get("color");
                    System.out.println(color);
                    
                    capturestate = (String)jugadorsito.get("capturestate");
                    System.out.println(capturestate);
                    
                    territory_amount = (String)jugadorsito.get("territory_amount");
                    System.out.println(territory_amount);
                    
                    continent_amount = (String)jugadorsito.get("continent_amount");
                    System.out.println(continent_amount);
                    
                    card_amount = (String)jugadorsito.get("card_amount");
                    System.out.println(card_amount);
                    
                    trades = (String)jugadorsito.get("trades");
                    System.out.println(trades);
                    
                    army = (String)jugadorsito.get("army");
                    System.out.println(army);
                    
            }
            
            JSONObject map = (JSONObject)session.get("map");
            
            String name_map = (String)map.get("name"); 
            System.out.println(name_map);
            
            JSONArray cards = (JSONArray) map.get("cards");
            
            String design;
            String owner;
            String type;
            String territory;
            
            
            for (int j = 0; j< cards.size(); j++) {
                
                JSONObject carta = (JSONObject) cards.get(j);
                
                 String nombre_carta = "Card"+(j+1);
                 System.out.println("el nombre de la carta es : " + nombre_carta);
                 
                 JSONObject cartica = (JSONObject)carta.get(nombre_carta);
                 
                 design = (String)cartica.get("design");
                 System.out.println(design);
                 
                 owner = (String)cartica.get("owner");
                 System.out.println(owner);
                 
                 type = (String)cartica.get("type");
                 System.out.println(type);
                 
                 territory = (String)cartica.get("territory");
                 System.out.println(territory);                 
                 
            }
            
            JSONArray continents = (JSONArray) map.get("continents");
            
            String continent_name;
            String continent_army;
            String continent_owner;
            
            
            String territory_name;
            String territory_owner;
            String territory_capital;
            String territory_army;
            
            for (int i=0; i < continents.size();i++) {
                
                JSONObject continente = (JSONObject) continents.get(i);
                
                String nombre_continente = "Continent"+(i+1);
                System.out.println("el nombre del continente es : " + nombre_continente);
                
                JSONObject continentico = (JSONObject)continente.get(nombre_continente);
                
                continent_name = (String)continentico.get("name");
                System.out.println(continent_name);
                
                continent_army = (String)continentico.get("army");
                System.out.println(continent_army);
                
                continent_owner = (String)continentico.get("owner");
                System.out.println(continent_owner);
                
                
                JSONArray territories = (JSONArray) continentico.get("territories");
        
                for (int j = 0;j < territories.size(); j++) {
                        
                        JSONObject territorio = (JSONObject)territories.get(j);
                                            
                        String nombre_territorios = "Territory"+(j+1);
                        System.out.println("el nombre del territorio es : " + nombre_territorios);
                
                        JSONObject mini_territorio = (JSONObject)territorio.get(nombre_territorios);
                        
                        territory_name = (String)mini_territorio.get("name");
                        System.out.println(territory_name);
                        
                        territory_owner = (String)mini_territorio.get("owner");
                        System.out.println(territory_owner);
                        
                        territory_capital = (String)mini_territorio.get("capital");
                        System.out.println(territory_capital);
                        
                        territory_army = (String)mini_territorio.get("army");
                        System.out.println(territory_army); 
                        
                }      
            
            }       
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }       
    }    
}
