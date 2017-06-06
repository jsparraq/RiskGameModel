package Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.*;
import riskgamemodel.*;
import View.*;


public class Json {
    
     public static void main(String args[])
    {
        JSONParser parser = new JSONParser();
        try
        {
            Object object = parser.parse(new FileReader("asd.json"));
            
            JSONObject jsonObject = (JSONObject)object;
            
            JSONObject session = (JSONObject)jsonObject.get("session");
            
            Integer id = Integer.parseInt((String) session.get("ID"));
            System.out.println(id);
            
            String type_ = (String) session.get("type");
            System.out.println(type_);
            
            String state = (String) session.get("state"); 
            System.out.println(state);
            
            JSONArray players = (JSONArray) session.get("players");
                             
            Player[] players1 = new Player[players.size()];
            for (int i=0; i < players.size();i++) {               
                    
                    players1[i] = new Player();
                    JSONObject jugador = (JSONObject) players.get(i);                                    
                                                          
                    String nombre = "Player"+(i+1);
                    System.out.println("el nombre es: " + nombre);
                    
                    JSONObject jugadorsito = (JSONObject)jugador.get(nombre);
                                
                    players1[i].setTurn(Boolean.valueOf((String) jugadorsito.get("turn")));
                    
                    players1[i].setplaying(Boolean.parseBoolean((String) jugadorsito.get("playing")));
                    
                    players1[i].setColor((String)jugadorsito.get("color"));
                    
                    players1[i].setCaptureState((String)jugadorsito.get("capturestate"));
                    
                    players1[i].setTerritoryAmount(Integer.parseInt((String)jugadorsito.get("territory_amount")));

                    players1[i].setContinentAmount(Integer.parseInt((String)jugadorsito.get("continent_amount")));
                                        
                    players1[i].setCardAmount(Integer.parseInt((String)jugadorsito.get("card_amount")));
                    
                    players1[i].settrades(Integer.parseInt((String)jugadorsito.get("trades")));
                    
                    players1[i].setArmy(Integer.parseInt((String)jugadorsito.get("army")));  
                    
            }
            
                  
            JSONObject map = (JSONObject)session.get("map");
            Map map1 = new Map();
            map1.setName((String)map.get("name")); 
            ArrayList<Territory> terrs = new ArrayList<>();
            JSONArray continents = (JSONArray) map.get("continents");
            
            Continent[] continents1 = new Continent[continents.size()];
            
            for (int i=0; i < continents.size();i++) {
                continents1[i] = new Continent();
                JSONObject continente = (JSONObject) continents.get(i);
                
                String nombre_continente = "Continent"+(i+1);
                System.out.println("el nombre del continente es : " + nombre_continente);
                
                JSONObject continentico = (JSONObject)continente.get(nombre_continente);
                
                continents1[i].setName((String)continentico.get("name"));
                
                continents1[i].setArmy(Integer.parseInt((String)continentico.get("army")));
                
                continents1[i].setOwner((String)continentico.get("owner"));
                
                
                JSONArray territories = (JSONArray) continentico.get("territories");
                Territory[] territories1 = new Territory[territories.size()];
                for (int j = 0;j < territories.size(); j++) {
                        territories1[j] = new Territory();
                        JSONObject territorio = (JSONObject)territories.get(j);
                                            
                        String nombre_territorios = "Territory"+(j+1);
                        System.out.println("el nombre del territorio es : " + nombre_territorios);
                
                        JSONObject mini_territorio = (JSONObject)territorio.get(nombre_territorios);
                        
                        territories1[j].setName((String)mini_territorio.get("name"));
                        
                        territories1[j].setOwner((String)mini_territorio.get("owner"));
                        
                        territories1[j].setCapital(Boolean.valueOf((String)mini_territorio.get("capital")));
                        
                        territories1[j].setArmy(Integer.parseInt((String)mini_territorio.get("army")));
                        terrs.add(territories1[j]);
                        
                }
                
                continents1[i].setterritories(territories1);
            
            } 
            
            map1.setContinents(continents1);
            JSONArray cards = (JSONArray) map.get("cards");
            
            String territory;
            
            Card[] cards1 = new Card[cards.size()];
            for (int j = 0; j< cards.size(); j++) {
                cards1[j] = new Card();
                JSONObject carta = (JSONObject) cards.get(j);
                
                String nombre_carta = "Card"+(j+1);
                System.out.println("el nombre de la carta es : " + nombre_carta);
                 
                JSONObject cartica = (JSONObject)carta.get(nombre_carta);
                 
                cards1[j].setDesign((String)cartica.get("design"));
                 
                cards1[j].setOwner((String)cartica.get("owner"));
                 
                cards1[j].setType((String)cartica.get("type"));
                territory = (String)cartica.get("territory");
                
                for (int i = 0; i < terrs.size(); i++) {
                    if(terrs.get(i).getName().equals(territory)){
                        cards1[j].setTerritory(terrs.get(i));
                        break;
                    }
                }                
                 
            }
            map1.setCards(cards1);
            map1.setboundary(new Boundary(1,terrs));
            Session sessionstart = new Session(id,state,players1,map1,type_);
            new Accepts_Turn_Interface(sessionstart).setVisible(true);
        }
        catch(FileNotFoundException fe)
        {
            fe.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    
    public static void CreateSession(String Json){
        JSONParser parser = new JSONParser();
        try
        {
            Object object = parser.parse(new FileReader("entrada.json"));

            JSONObject jsonObject = (JSONObject)object;

            JSONObject session = (JSONObject)jsonObject.get("session");

            JSONArray players = (JSONArray) session.get("players");

            ArrayList <Player> Players = new ArrayList<Player>();
            Player player;
            
            for (int i=0; i < players.size();i++) {               
                    player = new Player();                
                    JSONObject jugador = (JSONObject) players.get(i); 
                    String nombre = "Player"+(i+1);
                    JSONObject jugadorsito = (JSONObject)jugador.get(nombre);
                    player.setTurn(Boolean.parseBoolean((String) jugadorsito.get("turn")));
                    player.setplaying(Boolean.parseBoolean((String) jugadorsito.get("playing")));
                    player.setColor((String)jugadorsito.get("color"));
                    player.setCaptureState((String)jugadorsito.get("capturestate"));
                    player.setTerritoryAmount((int)jugadorsito.get("territory_amount"));
                    player.setContinentAmount((int)jugadorsito.get("continent_amount"));
                    player.setCardAmount((int)jugadorsito.get("card_amount"));
                    player.settrades((int)jugadorsito.get("trades"));
                    player.setArmy((int)jugadorsito.get("army"));                  
                    Players.add(player);
            }
            
            
            
            JSONObject map = (JSONObject)session.get("map");           
            JSONArray cards = (JSONArray) map.get("cards");

            ArrayList<Card> Cards = new ArrayList<Card>();
            Card card;

            for (int j = 0; j< cards.size(); j++) {
                card = new Card();
                JSONObject carta = (JSONObject) cards.get(j);
                 String nombre_carta = "Card"+(j+1);
                 JSONObject cartica = (JSONObject)carta.get(nombre_carta);
                 card.setDesign((String)cartica.get("design"));
                 card.setOwner((String)cartica.get("owner"));
                 card.setType((String)cartica.get("type"));
                 //card.setTerritory((String)cartica.get("territory"));                
                 Cards.add(card);
            }
            

            JSONArray continents = (JSONArray) map.get("continents");
            String continent_name;
            String continent_army;
            String continent_owner;
            
            String territory_name;
            String territory_owner;
            String territory_capital;
            String territory_army;
            
            ArrayList<Continent> Continents = new ArrayList<Continent>();
            
            Continent continent;
            Territory territory;

            for (int i=0; i < continents.size();i++) {
                continent = new Continent();
                JSONObject continente = (JSONObject) continents.get(i);

                String nombre_continente = "Continent"+(i+1);
                JSONObject continentico = (JSONObject)continente.get(nombre_continente);

                continent.setName((String)continentico.get("name"));
                continent.setArmy((int)continentico.get("army"));
                continent.setOwner((String)continentico.get("owner"));
                
                ArrayList<Territory> Territories = new ArrayList<Territory>();
                JSONArray territories = (JSONArray) continentico.get("territories");

                for (int j = 0;j < territories.size(); j++) {
                        territory = new Territory();
                        JSONObject territorio = (JSONObject)territories.get(j);

                        String nombre_territorios = "Territory"+(j+1);
                        JSONObject mini_territorio = (JSONObject)territorio.get(nombre_territorios);
                        territory.setName((String)mini_territorio.get("name"));
                        territory.setOwner((String)mini_territorio.get("owner"));
                        territory.setCapital(Boolean.parseBoolean((String)mini_territorio.get("capital")));
                        territory.setArmy((int)mini_territorio.get("army"));
                        Territories.add(territory);
                }
                
                //continent.setTerritory(Territories);
                Continents.add(continent);
            }
            
            //Map mapobj = new Map((String)map.get("name"), Continents, cards);
           //Session sessionobj = new Session((int) session.get("ID"),(String)session.get("state"),Players,mapobj,(String)session.get("type"));


        }
        catch(FileNotFoundException fe)
        {
            fe.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        
    }







}


    
    