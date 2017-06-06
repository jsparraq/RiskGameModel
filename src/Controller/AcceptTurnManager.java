package Controller;

import View.Accepts_Turn_Interface;
import View.Trade_Cards_Interface;
import java.util.ArrayList;
import javax.swing.JFrame;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import riskgamemodel.*;
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
            Player[] players1 = new Player[players.size()];         
            for (int i=0; i < players.size();i++) {  
                    JSONObject jugador = (JSONObject) players.get(i); 
                    String nombre = "Player"+(i+1);                    
                    JSONObject jugadorsito = (JSONObject)jugador.get(nombre);                                
                    boolean turn = Boolean.parseBoolean((String) jugadorsito.get("turn"));                    
                    boolean capital = Boolean.parseBoolean((String) jugadorsito.get("playing"));                    
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
            Map map1 = new Map(name_map,continents1,cards1,new Boundary(3,TERRITORIES));
            Session sessionstart = new Session(id,state,players1,map1,type_);
            AcceptTurnManager acceptTurnManager = new AcceptTurnManager(sessionstart);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }       
    }
    
    public static void createSession(String json){
        try
        {
            JSONParser parser = new JSONParser();
            String jsonToString = "[" + json + "]";
            Object object = parser.parse(jsonToString);
            JSONArray jsonArray = (JSONArray) object;   
            JSONObject jsonObject = (JSONObject) jsonArray.get(0);
            JSONArray players = (JSONArray) jsonObject.get("players");
            int army = 0;
            if(players.size() == 3){
                army = 35;
            }else if(players.size() == 3){
                army = 35;
            }else if(players.size() == 4){
                army = 30;
            }else if(players.size() == 5){
                army = 25;
            }else if(players.size() == 6){
                army = 20;
            }else{
                army = 21;
            }
            Player[] players1;
            if(players.size() == 2){
                players1 = new Player[players.size() + 1];
            }else{
                players1 = new Player[players.size()];
            }            
            for (int i = 0; i < players.size(); i++) {
                JSONObject jugador = (JSONObject) players.get(i);
                String color = (String)jugador.get("color");
                String type = (String)jugador.get("type");
                Player player1;
                if("HOST".equals(type)){
                    player1 = new Player(true,true,"non-capture",color,0,0,0,army,0);
                }else{
                    player1 = new Player(false,true,"non-capture",color,0,0,0,army,0);
                }
                players1[i] = player1;
            }
            Territory territory1 = new Territory("OEKRAINË","WHITE",0,false);
            Territory territory2 = new Territory("IJSLAND","WHITE",0,false);
            Territory territory3 = new Territory("SCANDINAVIË","WHITE",0,false);
            Territory territory4 = new Territory("WEST-EUROPA","WHITE",0,false);
            Territory territory5 = new Territory("GROOT-BRITTANIË","WHITE",0,false);
            Territory territory6 = new Territory("ZUID-EUROPA","WHITE",0,false);
            Territory territory7 = new Territory("NOORD-EUROPA","WHITE",0,false);
            Continent continent1 = new Continent("UIROPA","WHITE",7,new Territory[]{territory1,territory2,territory3,territory4,territory5,territory6,territory7});

            Territory territory8 = new Territory("VARENIGDE-STATEM(OOST)","WHITE",0,false);
            Territory territory9 = new Territory("VARENIGDE-STATEM(WEST)","WHITE",0,false);
            Territory territory10 = new Territory("NORTHWEST-TERRITORIES","WHITE",0,false);
            Territory territory11 = new Territory("ALBERTA","WHITE",0,false);
            Territory territory12 = new Territory("MIDDEN-AMERIKA","WHITE",0,false);
            Territory territory13 = new Territory("ALASKA","WHITE",0,false);
            Territory territory14 = new Territory("ONTARIO","WHITE",0,false);
            Territory territory15 = new Territory("QUEBEC","WHITE",0,false);
            Territory territory16 = new Territory("GROENLAND","WHITE",0,false);
            Continent continent2 = new Continent("AMEROKI","WHITE",9,new Territory[]{territory8,territory9,territory10,territory11,territory12,territory13,territory14,territory15,territory16});

            Territory territory17 = new Territory("SIBERIË","WHITE",0,false);
            Territory territory18 = new Territory("IRKOETSK","WHITE",0,false);
            Territory territory19 = new Territory("INDIA","WHITE",0,false);
            Territory territory20 = new Territory("JAPON","WHITE",0,false);
            Territory territory21 = new Territory("JAKOETSK","WHITE",0,false);
            Territory territory22 = new Territory("MONGOLOË","WHITE",0,false);
            Territory territory23 = new Territory("CHINA","WHITE",0,false);
            Territory territory24 = new Territory("MIDDEN-OOSTEN","WHITE",0,false);
            Territory territory25 = new Territory("ZEIDOOST-AZIË","WHITE",0,false);
            Territory territory26 = new Territory("KAMTAJARKA","WHITE",0,false);
            Territory territory27 = new Territory("AFGHANISTAN","WHITE",0,false);
                    Territory territory42 = new Territory("OERAL","WHITE",0,false);
            Continent continent3 = new Continent("AZIO","WHITE",10,new Territory[]{territory17,territory18,territory19,territory20,territory21,territory22,territory23,territory24,territory25,territory26,territory27,territory42});

            Territory territory28 = new Territory("NIEUW-GUINEA","WHITE",0,false);
            Territory territory29 = new Territory("INDONESIË","WHITE",0,false);
            Territory territory30 = new Territory("WEST-AUSTRALIË","WHITE",0,false);
            Territory territory31 = new Territory("OOST-AUSTRALIË","WHITE",0,false);
            Continent continent4 = new Continent("UISTRALIA","WHITE",4,new Territory[]{territory28,territory29,territory30,territory31});

            Territory territory32 = new Territory("ZUID-AFRIKA","WHITE",0,false);
            Territory territory33 = new Territory("CENTRAAL-AFRIKA","WHITE",0,false);
            Territory territory34 = new Territory("OOST-AFRIKA","WHITE",0,false);
            Territory territory35 = new Territory("NOORD-AFRIKA","WHITE",0,false);
            Territory territory36 = new Territory("EGYPTE","WHITE",0,false);
            Territory territory37 = new Territory("MADAGASCAR","WHITE",0,false);
            Continent continent5 = new Continent("AFROKI","WHITE",2,new Territory[]{territory32,territory33,territory34,territory35,territory36,territory37});

            Territory territory38 = new Territory("BRASILIË","WHITE",0,false);
            Territory territory39 = new Territory("PERU","WHITE",0,false);
            Territory territory40 = new Territory("VENEZUELA","WHITE",0,false);
            Territory territory41 = new Territory("ARGENTINË","WHITE",0,false);
            Continent continent6 = new Continent("AMERPOLU","WHITE",2,new Territory[]{territory38,territory39,territory40,territory41});


            Card card1 = new Card("STANDARD","WHITE","Infantry",territory1);
            Card card2 = new Card("STANDARD","WHITE","Cavalry",territory2);
            Card card3 = new Card("STANDARD","WHITE","Artillery",territory3);
            Card card4 = new Card("STANDARD","WHITE","Infantry",territory4);
            Card card5 = new Card("STANDARD","WHITE","Cavalry",territory5);
            Card card6 = new Card("STANDARD","WHITE","Artillery",territory6);
            Card card7 = new Card("STANDARD","WHITE","Infantry",territory7);
            Card card8 = new Card("STANDARD","WHITE","Infantry",territory8);
            Card card9 = new Card("STANDARD","WHITE","Cavalry",territory9);
            Card card10 = new Card("STANDARD","WHITE","Artillery",territory10);
            Card card11 = new Card("STANDARD","WHITE","Infantry",territory11);
            Card card12 = new Card("STANDARD","WHITE","Cavalry",territory12);
            Card card13 = new Card("STANDARD","WHITE","Artillery",territory13);
            Card card14 = new Card("STANDARD","WHITE","Infantry",territory14);
            Card card15 = new Card("STANDARD","WHITE","Cavalry",territory15);
            Card card16 = new Card("STANDARD","WHITE","Artillery",territory16);
            Card card17 = new Card("STANDARD","WHITE","Infantry",territory17);
            Card card18 = new Card("STANDARD","WHITE","Cavalry",territory18);
            Card card19 = new Card("STANDARD","WHITE","Artillery",territory19);
            Card card20 = new Card("STANDARD","WHITE","Infantry",territory20);
            Card card21 = new Card("STANDARD","WHITE","Cavalry",territory21);
            Card card22 = new Card("STANDARD","WHITE","Artillery",territory22);
            Card card23 = new Card("STANDARD","WHITE","Infantry",territory23);
            Card card24 = new Card("STANDARD","WHITE","Cavalry",territory24);
            Card card25 = new Card("STANDARD","WHITE","Artillery",territory25);
            Card card26 = new Card("STANDARD","WHITE","Infantry",territory26);
            Card card27 = new Card("STANDARD","WHITE","Cavalry",territory27);
            Card card28 = new Card("STANDARD","WHITE","Artillery",territory28);
            Card card29 = new Card("STANDARD","WHITE","Infantry",territory29);
            Card card30 = new Card("STANDARD","WHITE","Cavalry",territory30);
            Card card31 = new Card("STANDARD","WHITE","Artillery",territory31);
            Card card32 = new Card("STANDARD","WHITE","Infantry",territory32);
            Card card33 = new Card("STANDARD","WHITE","Cavalry",territory33);
            Card card34 = new Card("STANDARD","WHITE","Artillery",territory34);
            Card card35 = new Card("STANDARD","WHITE","Infantry",territory35);
            Card card36 = new Card("STANDARD","WHITE","Cavalry",territory36);
            Card card37 = new Card("STANDARD","WHITE","Artillery",territory37);
            Card card38 = new Card("STANDARD","WHITE","Infantry",territory38);
            Card card39 = new Card("STANDARD","WHITE","Cavalry",territory39);
            Card card40 = new Card("STANDARD","WHITE","Artillery",territory40);
            Card card41 = new Card("STANDARD","WHITE","Infantry",territory41);
            Card card44 = new Card("STANDARD","WHITE","Infantry",territory42);
            Card card42 = new Card("WILD","WHITE","Cavalry",null);
            Card card43 = new Card("WILD","WHITE","Artillery",null);
        
            Card[] cards = new Card[]{card1, card2, card3, card4, card5, card6, card7, card8, card9, card10, card11, card12, card13, card14, card15,card16,card17,card18,card19,card20,card21,card22,card23,card24,card25,card26,card27,card28,card29,card30,card31,card32,card33,card34,card35,card36,card37,card37,card38,card39,card40,card41,card42,card43,card44};
        
            Territory[] terr = new Territory[]{territory1, territory1, territory1, territory1, 
								   territory2, territory2, 
								   territory3, territory3, territory3, territory3, territory3,
								   territory4, territory4, territory4, territory4, territory4,
								   territory5, territory5, territory5, territory5, territory5, territory5,
								   territory6, territory6, territory6,
								   territory7, territory7, territory7,
								   territory8, territory8, territory8, territory8, territory8, territory8,
								   territory9, territory9, territory9, territory9, territory9, territory9, territory9,
								   territory10, territory10,
								   territory11, territory11, territory11, territory11, territory11,
								   territory12, territory12, territory12, territory12, territory12,
								   territory13, territory13, territory13, territory13,
								   territory14, territory14, territory14, territory14,
								   territory15, territory15, territory15, territory15,
								   territory16, territory16,
								   territory17, territory17, territory17,
								   territory18, territory18, territory18, territory18,
								   territory19, territory19, territory19,
								   territory20, territory20,
								   territory21, territory21, territory21, territory21,
								   territory22, territory22, territory22, territory22,
								   territory23, territory23, territory23, territory23, territory23,
								   territory24, territory24, territory24, territory24,
								   territory25, territory25, territory25,
								   territory26, territory26, territory26, territory26, territory26,
								   territory27, territory27,
								   territory28, territory28,
								   territory29, territory29, territory29, territory29,
								   territory30, territory30, territory30,
								   territory31, territory31,
								   territory32, territory32, territory32,
								   territory33, territory33, territory33,
								   territory34, territory34, territory34,
								   territory35, territory35, territory35,
								   territory36, territory36, territory36,
								   territory37, territory37,
								   territory38, territory38, territory38,
								   territory39, territory39,
								   territory40, territory40, territory40,
								   territory41, territory41,
								   territory42, territory42
								   };
								   
                                     Territory[] neigh = new Territory[]{territory2, territory3, territory4, territory37,
									territory1, territory3, 
									territory1, territory2, territory4, territory5, territory9,
									territory1, territory3, territory5, territory6, territory7, 
									territory3, territory4, territory6, territory8, territory9, territory17,
									territory4, territory5, territory7,
									territory4, territory6, territory41,
									territory5, territory9, territory13, territory18, territory21, territory22,
									territory3, territory5, territory8, territory10, territory11, territory12, territory13,
									territory9, territory11,
									territory9, territory10, territory12, territory14, territory16,
									territory9, territory11, territory13, territory14, territory15,
									territory8, territory9, territory12, territory15,
									territory11, territory12, territory15, territory16,
									territory12, territory13, territory14, territory42,
									territory11, territory14,
									territory5, territory18, territory36,
									territory8, territory17, territory19, territory21,			
									territory18, territory20, territory26,
									territory19, territory32,
									territory8, territory18, territory22, territory24,
									territory8, territory21, territory23, territory24,
									territory22, territory24, territory25, territory26, territory42,
									territory21, territory22, territory23, territory25,
									territory23, territory26, territory27,
									territory19, territory23, territory24, territory25, territory27,
									territory25, territory26,
									territory29, territory30,
									territory28, territory30, territory31, territory32,
									territory28, territory29, territory31,
									territory29, territory30,
									territory20, territory29, territory33,
									territory32, territory34, territory35,
									territory33, territory35, territory37,
									territory33, territory34, territory36,
									territory17, territory35, territory38,
									territory1, territory34,
									territory36, territory39, territory40,
									territory38, territory40,
									territory38, territory39, territory41,
									territory40, territory7,
									territory23, territory15
									};
            Boundary boundary = new Boundary(1,terr,neigh);
            Long id = (Long)jsonObject.get("id");
            String type = (String)jsonObject.get("type");
            String map1 = (String)jsonObject.get("map");
            
            Map map = new Map(map1,new Continent[]{continent1,continent2,continent3,continent4,continent5,continent6},cards,boundary);
            String state;
            if(players.size() > 2){
                state = "START PLACE ARMY";
            }else{
                state = "TWO PLACE ARMY";
                Player player = new Player(false,true,"non-capture","GREEN",0,0,0,0,0);
                players1[2] = player;
            }
            
            Session sessionstart = new Session(id.intValue(),state,players1,map,type);
            AcceptTurnManager acceptTurnManager = new AcceptTurnManager(sessionstart);
            
            
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
