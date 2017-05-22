/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package riskgamemodel;

/**
 *
 * @author Sebastian
 */
public class Player {

    private boolean Turn;
    private String CaptureState;
    private String Color;
    private int TerritoryAmount;
    private int CardAmount;
    private int Army;

    public void setTurn(boolean value) {
        this.Turn = value;
    }

    public boolean getTurn() {
        return this.Turn;
    }

    public void setCaptureState(String value) {
        this.CaptureState = value;
    }

    public String getCaptureState() {
        return this.CaptureState;
    }

    public void setColor(String value) {
        this.Color = value;
    }

    public String getColor() {
        return this.Color;
    }

    public void setTerritoryAmount(int value) {
        this.TerritoryAmount = value;
    }

    public int getTerritoryAmount() {
        return this.TerritoryAmount;
    }

    public void setCardAmount(int value) {
        this.CardAmount = value;
    }

    public int getCardAmount() {
        return this.CardAmount;
    }

    public void setArmy(int value) {
        this.Army = value;
    }

    public int getArmy() {
        return this.Army;
    }

    public static void accepts(Player player) {
        player.Army = player.TerritoryAmount / 3;
        Session session = Session.getSession();
        Map map = session.getMap();
        Continent[] Continents = map.getContinents();
        for (Continent Continent : Continents) {
            if (Continent.getOwner().equals(player.Color)) {
                player.Army = player.Army + Continent.getArmy();
            }
        }
    }

    public static void Passes(Boolean conquered) {
    }

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
