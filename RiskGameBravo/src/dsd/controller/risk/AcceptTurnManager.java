package dsd.controller.risk;

import dsd.view.risk.*;
import java.util.ArrayList;
import javax.swing.JFrame;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import dsd.model.risk.*;
/**
 * @author UNC Risk Game Model
 */
public class AcceptTurnManager {
    
    /**
     * 
     * @param sessionstart 
     */
    public AcceptTurnManager(Session sessionstart){
        new Accepts_Turn_Interface(sessionstart).setVisible(true);
    }
    
    /**
     * 
     * @param session
     * @param window 
     */
    public static void Button_finish(Session session, JFrame window){
        Player[] players = session.getPlayers();
        Player playerstart = new Player();
        for (Player player : players) {
            if (player.getTurn()) {
                playerstart = player;
                break;
            }
        }
        window.setVisible(false);
        Player.accepts(playerstart,session);
        new Trade_Cards_Interface(session,playerstart).setVisible(true);
    }
    
    public static void createstateSession(String json) {
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
            JSONObject asd = (JSONObject)players.get(0);
            Player[] players1 = new Player[asd.size()];         
            for (int i=0; i < asd.size();i++) {  
                    String nombre = "Player"+(i+1);                    
                    JSONObject jugadorsito = (JSONObject)asd.get(nombre);
                    players1[i] = new Player();
                    boolean turn = Boolean.parseBoolean((String) jugadorsito.get("turn"));  
                    players1[i].setTurn(turn);
                    boolean capital = Boolean.parseBoolean((String) jugadorsito.get("playing"));
                    players1[i].setplaying(capital);
                    String color = (String)jugadorsito.get("color");   
                    players1[i].setColor(color);
                    String capturestate = (String)jugadorsito.get("capturestate");
                    players1[i].setCaptureState(capturestate);
                    int territory_amount = Integer.parseInt((String)jugadorsito.get("territoryamount"));
                    players1[i].setTerritoryAmount(territory_amount);
                    int continent_amount = Integer.parseInt((String)jugadorsito.get("continentamount"));
                    players1[i].setContinentAmount(continent_amount);
                    int card_amount = Integer.parseInt((String)jugadorsito.get("cardamount"));
                    players1[i].setCardAmount(card_amount);
                    int trades = Integer.parseInt((String)jugadorsito.get("trades"));
                    players1[i].settrades(trades);
                    int army = Integer.parseInt((String)jugadorsito.get("army"));
                    players1[i].setArmy(army);
                    
            }
            
            JSONObject map = (JSONObject)session.get("map");
            
            String name_map = (String)map.get("name"); 
            
            ArrayList<Territory> TERRITORIES = new ArrayList();
            JSONArray continents = (JSONArray) map.get("continents");
            JSONObject asd1 = (JSONObject)continents.get(0);
            Continent[] continents1 = new Continent[asd1.size()];
            for (int i=0; i < asd1.size();i++) {                                
                String nombre_continente = "Continent"+(i+1);                
                JSONObject continentico = (JSONObject)asd1.get(nombre_continente);
                String continent_name = (String)continentico.get("name");
                int continent_army = Integer.parseInt((String)continentico.get("army"));                
                String continent_owner = (String)continentico.get("owner");                
                
                JSONArray territories = (JSONArray) continentico.get("Territories");
                System.out.println(territories.size());
                JSONObject asd2 = (JSONObject)territories.get(0);
                Territory[] territories1 = new Territory[asd2.size()];
                for (int j = 0;j < asd2.size(); j++) {
                        JSONObject territorio = (JSONObject)asd2.get(j);
                        String nombre_territorios = "Territory"+(j+1);
                        JSONObject mini_territorio = (JSONObject)asd2.get(nombre_territorios);
                        String territory_name = (String)mini_territorio.get("name");                        
                        String territory_owner = (String)mini_territorio.get("owner");                        
                        boolean territory_capital = Boolean.parseBoolean((String)mini_territorio.get("capital"));  
                        int territory_army = Integer.parseInt((String)mini_territorio.get("army"));
                        territories1[j] = new Territory(territory_name,territory_owner,territory_army,territory_capital);
                        
                        TERRITORIES.add(territories1[j]);
                }   
                continents1[i] = new Continent(continent_name,continent_owner,continent_army,territories1);
            }       
            
            JSONArray cards = (JSONArray) map.get("cards");
            JSONObject asd3 = (JSONObject)cards.get(0);
            Card[] cards1 = new Card[asd3.size()];
            for (int j = 0; j< asd3.size(); j++) {                
                JSONObject carta = (JSONObject) asd3.get(j);                
                String nombre_carta = "Card"+(j+1);
                 
                JSONObject cartica = (JSONObject)asd3.get(nombre_carta);
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
                cards1[j] = new Card(type,owner,design,terr);
            }
            Map map1 = new Map(name_map,continents1,cards1,new Boundary(3,TERRITORIES));
            Session sessionstart = new Session(id,state,players1,map1,type_);
            AcceptTurnManager acceptTurnManager = new AcceptTurnManager(sessionstart);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }       
    }
}
