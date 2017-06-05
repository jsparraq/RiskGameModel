package riskgamemodel;

import java.util.ArrayList;

/**
 *
 * @author UNC Risk Game Model
 */
public class Territory {
    
    private String Name;
    private String Owner;
    private int Army;
    private boolean Capital;
    
    /**
     * This method is the constructor of territory class
     */
    public Territory(){
        Name = null;
        Owner = null;
        Army = 0;
    }
    
    /**
     * This method creates an object of Territory
     * @param name
     * @param owner
     * @param army 
     */
    public Territory(String name, String owner, int army,boolean capital){
        Name = name;
        Owner = owner;
        Army = army;
        Capital = capital;
    }
    
    /**
     * This method sets the value of the territoy
     * @param value 
     */
    public void setName(String value) {
        this.Name = value;
    }
    
    /**
     * This method gets the value of the territoy
     * @return the name's territory 
     */
    public String getName() {
        return Name;
    }
    
    /**
     * This method sets the owner of the territoy
     * @param value 
     */
    public void setOwner(String value) {
        this.Owner = value;
    }
    
    /**
     * This method gets the owner of the territoy
     * @return The owner's territory
     */
    public String getOwner() {
        return Owner;
    }
    
    /**
     * This method sets the army of the territoy
     * @param value 
     */
    public void setArmy(int value) {
        this.Army = value;
    }
    
    
    /**
     * This method gets the army of the territoy
     * @return The army's territory
     */
    public int getArmy() {
        return Army;
    }
    
    
    public boolean getCapital(){
        return Capital;
    }
    
    public void setCapital(boolean value){
        Capital = value;
    }
    /**
     * @return The name and army of the territory. If the territory does not have owner then add without owner in the string return  
     */
    public String getString() {
        if(Owner.equals("WHITE")){
            return Name + " - " + Integer.toString(Army) + " without owner";
        }
        return Name + " - " + Integer.toString(Army);
    }
    
    /**
     * This method lets move an army from one territory to other.
     * @param TerritoryA
     * @param TerritoryB 
     */
    public static void Moves(Territory TerritoryA, Territory TerritoryB) {
        TerritoryA.setArmy(TerritoryA.getArmy() - 1);
        TerritoryB.setArmy(TerritoryB.getArmy() + 1);
    }
    
    public static void Selects(Territory territory){
        territory.setCapital(true);
    }
    
    /**
     * 
     * @param attack
     * @param army
     * @param sessionstart 
     * @param playerstart 
     */
    public static void conquers(Attack attack,String army ,Session sessionstart,Player playerstart){
        String colorenemy = attack.getDefender().getOwner();
        attack.getDefender().setOwner(playerstart.getColor());        
        attack.getDefender().setArmy(attack.getDefender().getArmy() + Integer.parseInt(army));
        attack.getAttacker().setArmy(attack.getAttacker().getArmy() - Integer.parseInt(army));
        
        Territory name_conquered = attack.getDefender();
        Continent name_continent = new Continent();
        for (Continent continent : sessionstart.getMap().getContinents()) {
            for (Territory territory : continent.getTerritory()) {
                if (name_conquered == territory) {
                    name_continent = continent;
                }
            }
        }
        int territory_amount = name_continent.getTerritory().length;
        int counter = 0;
        for (Continent continent : sessionstart.getMap().getContinents()) {
            if (continent == name_continent) {
                for (Territory territory : continent.getTerritory()) {
                    if (territory.getOwner().equals(playerstart.getColor())) {
                        counter++;
                    }
                }
            }
        }
        if (counter == territory_amount){
            if(name_continent.getOwner().equals("WHITE")){
                name_continent.setOwner(playerstart.getColor());
                playerstart.setContinentAmount(playerstart.getContinentAmount() + 1);
            }else{
                Player[] players = sessionstart.getPlayers();
                for (Player player : players) {
                    if (player.getColor().equals(name_continent.getOwner())) {
                        player.setContinentAmount(player.getContinentAmount() - 1);
                    }
                }
                name_continent.setOwner(playerstart.getColor());
                playerstart.setContinentAmount(playerstart.getContinentAmount() + 1);
            }
        }
        Player[] players = sessionstart.getPlayers();
        Player playerenemy = new Player();
        for (Player player : players) {
            if (player.getColor().equals(colorenemy)) {
                playerenemy = player;
            }
        }
        if (playerenemy.getTerritoryAmount() == 0) {
            playerenemy.setplaying(false);
        }
        playerstart.setCaptureState("CAPTURE");
        if(playerstart.getContinentAmount() == sessionstart.getMap().getContinents().length && (sessionstart.getType().equals("World domination risk") || sessionstart.getType().equals("RISK_FOR_TWO_PLAYERS"))){
            System.out.println(playerstart.getContinentAmount()+ "  " + sessionstart.getMap().getContinents().length);
            System.out.println("Ganador");
        }else{
            if(attack.getDefender().getCapital()){
                ArrayList<Territory> capitals = new ArrayList();
                Continent[] continents = sessionstart.getMap().getContinents();
                for (Continent continent : continents) {
                    for (Territory territory : continent.getTerritory()) {
                        if (territory.getCapital()) {
                            capitals.add(territory);
                        }
                    }
                }
                counter = 0;
                for (int i = 0; i < capitals.size(); i++) {
                    if(capitals.get(i).getOwner().equals(playerstart.getColor())){
                        counter++;
                    }
                }
                if(counter == capitals.size()){
                    System.out.println("ganador");
                }
            }
        }
                   
    }
    
}
