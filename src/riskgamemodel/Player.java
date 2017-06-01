/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    
    /**
     * 
     */
    public Player(){
        
    }
    
    /**
     * 
     * @param turn
     * @param capture
     * @param color
     * @param territoryamount
     * @param cardamount
     * @param army 
     */
    public Player(boolean turn, String capture, String color,int territoryamount, int cardamount, int army){
        Turn = turn;
        CaptureState = capture;
        Color = color;
        TerritoryAmount = territoryamount;
        CardAmount = cardamount;
        Army = army;
    }
    
    /**
     * 
     * @param value 
     */
    public void setTurn(boolean value) {
        this.Turn = value;
    }

    /**
     * 
     * @return 
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
     * 
     * @return 
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
     * 
     * @return 
     */
    public String getColor() {
        return this.Color;
    }

    /**
     * 
     * @param value 
     */
    public void setTerritoryAmount(int value) {
        this.TerritoryAmount = value;
    }

    /**
     * 
     * @return 
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
     * 
     * @return 
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
     * @return 
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

}
