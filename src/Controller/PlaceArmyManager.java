package Controller;

import View.Main_Interface;
import View.Place_army_Interface;
import View.Selects_capital_Interface;
import java.util.ArrayList;
import javax.swing.JFrame;
import riskgamemodel.*;
/**
 *
 * @author UNC Risk Game Model
 */
public class PlaceArmyManager {
    
    /**
     * 
     * @param sessionstart
     * @return 
     */
    public static String armies(Session sessionstart){
        Player[] players = sessionstart.getPlayers();
        Player playerstart = new Player();
        for (Player player : players) {
            if (player.getTurn()) {
                playerstart = player;
            }
        }
        
        if(playerstart.getArmy() == 0){
            return "You don´t have army";
        }
        return "Your army are " + playerstart.getArmy();
    }
    
    /**
     * 
     * @param sessionstart
     * @return 
     */
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
    
    
    /**
     * 
     * @param sessionstart
     * @return 
     */
    public static String[] Territoriesneutral(Session sessionstart){
        ArrayList<Territory> territoryplayer = new ArrayList();
        Continent[] continents = sessionstart.getMap().getContinents();
        for (Continent continent : continents) {
            Territory[] territories = continent.getTerritory();
            for (Territory territorie : territories) {
                if (territorie.getOwner().equals("GREEN") || territorie.getArmy() == 0) {
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
     * @param window
     * @param name_territory 
     * @param playerstart 
     */
    public static void Button_Finish(Session sessionstart, JFrame window, String name_territory, Player playerstart){
        Continent[] continents = sessionstart.getMap().getContinents();
        Territory territory = new Territory();
        for (Continent continent : continents) {
            Territory[] territories = continent.getTerritory();
            for (Territory territorie : territories) {
                if(name_territory.equals(territorie.getString())){
                    territory = territorie;
                    break;
                }
            }
        }
        if(sessionstart.getState().equals("TWO PLACE ARMY") && ((Place_army_Interface)window).Control()){
            Player.Places(playerstart, territory);
            ((Place_army_Interface)window).getlabel().setText("SELECTS OTHER TERRITORY");
            ((Place_army_Interface)window).getTerritories().setModel((new javax.swing.DefaultComboBoxModel(Territories(sessionstart))));
            ((Place_army_Interface)window).getarmies().setText((armies(sessionstart)));
            ((Place_army_Interface)window).change();
        }else{
            Player.Places(playerstart, territory);
            window.setVisible(false);
            if(playerstart.getArmy() > 0 && sessionstart.getState().equals("RUN")){
                new Place_army_Interface(sessionstart,playerstart).setVisible(true);
            }else if(sessionstart.getState().equals("SELECT CAPITAL")){
                new Selects_capital_Interface(sessionstart,playerstart).setVisible(true);
            }else if(sessionstart.getState().equals("TWO PLACE ARMY")){
                new Main_Interface(sessionstart,"").setVisible(true);
            }else{
                new Main_Interface(sessionstart,playerstart).setVisible(true);
            }
        }
    }
    
    
    /**
     * 
     * @param sessionstart
     * @param window
     * @param name_territory 
     * @param playerstart 
     */
    public static void Button_aux(Session sessionstart, JFrame window, String name_territory, Player playerstart){
        Continent[] continents = sessionstart.getMap().getContinents();
        Territory territory = new Territory();
        for (Continent continent : continents) {
            Territory[] territories = continent.getTerritory();
            for (Territory territorie : territories) {
                if(name_territory.equals(territorie.getString())){
                    territory = territorie;
                    break;
                }
            }
        }
        Player.Places(playerstart, territory);
        new Place_army_Interface(sessionstart,playerstart,"NO").setVisible(true);
    }
}
