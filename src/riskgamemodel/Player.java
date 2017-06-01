package riskgamemodel;

/**
 * @author UNC Risk Game Model
 */
public class Player {

    private boolean Turn;
    private String CaptureState;
    private String Color;
    private int TerritoryAmount;
    private int CardAmount;
    private int Army;
    private int ContinentAmount;
    private int trades;
    
    /**
     * This method is the constructor of Player class
     */
    public Player(){
        CaptureState = null;
        Color = null;
        TerritoryAmount = 0;
        CardAmount = 0;
        Army = 0;
        
    }
    
    /**
     * This method is the constructor of player class
     * @param turn
     * @param capture
     * @param color
     * @param territoryamount
     * @param continentamount
     * @param cardamount
     * @param army 
     */
    public Player(boolean turn, String capture, String color,int territoryamount,int continentamount, int cardamount, int army){
        Turn = turn;
        CaptureState = capture;
        Color = color;
        TerritoryAmount = territoryamount;
        CardAmount = cardamount;
        Army = army;
        ContinentAmount = continentamount;
    }
    
    /**
     * 
     * @param value 
     */
    public void setTurn(boolean value) {
        this.Turn = value;
    }

    /**
     * @return The turn's player
     */
    public boolean getTurn() {
        return this.Turn;
    }

    /**
     * 
     * @param value 
     */
    public void setCaptureState(String value) {
        this.CaptureState = value;
    }

    /**
     * @return The capture state's player  
     */
    public String getCaptureState() {
        return this.CaptureState;
    }

    /**
     * 
     * @param value 
     */
    public void setColor(String value) {
        this.Color = value;
    }

    /**
     * @return The color's player
     */
    public String getColor() {
        return this.Color;
    }

    /**
     * @param value 
     */
    public void setTerritoryAmount(int value) {
        this.TerritoryAmount = value;
    }

    /**
     * @return The territory amount's player 
     */
    public int getTerritoryAmount() {
        return this.TerritoryAmount;
    }

    /**
     * 
     * @param value 
     */
    public void setCardAmount(int value) {
        this.CardAmount = value;
    }

    /**
     * @return The card amount's player 
     */
    public int getCardAmount() {
        return this.CardAmount;
    }

    /**
     * 
     * @param value 
     */
    public void setArmy(int value) {
        this.Army = value;
    }

    /**
     * 
     * @return  the army's player
     */
    public int getArmy() {
        return this.Army;
    }

    /**
     * 
     * @param player
     * @param session 
     */
    public static void accepts(Player player,Session session) {
        player.Army = player.TerritoryAmount / 3;
        Map map = session.getMap();
        Continent[] Continents = map.getContinents();
        for (Continent Continent : Continents) {
            if (Continent.getOwner().equals(player.Color)) {
                player.Army = player.Army + Continent.getArmy();
            }
        }
    }

    /**
     * 
     * @param player
     * @param Cards 
     */
    public static void Passes(Player player,Card[] Cards) {
        if("CAPTURE".equals(player.getCaptureState())){            
            for (Card Card : Cards) {
                if ("WHITE".equals(Card.getOwner())) {
                    Card.setOwner(player.getColor());
                    player.setCaptureState("NON-CAPTURE");
                    break;
                }
            }
            
        }
        
    }

    /**
     * 
     * @param player
     * @param Territorytoplace 
     */
    public static void Places(Player player, Territory Territorytoplace) {
        if (player.getArmy() > 0) {
            if (Territorytoplace.getArmy() == 0) {
                Territorytoplace.setOwner(player.getColor());
            }
            if (Territorytoplace.getOwner().equals(player.getColor())) {
                player.setArmy(player.getArmy() - 1);
                Territorytoplace.setArmy(Territorytoplace.getArmy() + 1);
            }
        }

    }
    
    public int gettrades(){
        return trades;
    }
    
    public void settrades(int value){
        trades = value;
    }

}
