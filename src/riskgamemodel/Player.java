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
    
    public void setTurn(boolean new_Turn){
        this.Turn = new_Turn;
    }
    
    public boolean getTurn(){
        return this.Turn;
    }
    
    public void setCaptureState(String new_State){
        this.CaptureState = new_State;
    }
    
    public String getCaptureState(){
        return this.CaptureState;
    }
    
    public void setColor(String new_Color){
        this.Color = new_Color;
    }
    
    public String getColor(){
        return this.Color;
    }
    
    public void setTerritoryAmount(int new_Amount){
        this.TerritoryAmount = new_Amount;
    }
    
    public int getTerritoryAmount(){
        return this.TerritoryAmount;
    }
    
    public void setCardAmount(int new_Amount){
        this.CardAmount = new_Amount;
    }
    
    public int getCardAmount(){
        return this.CardAmount;
    }
    
    public void setArmy(int new_Army){
        this.Army = new_Army;
    }
    
    public int getArmy(){
        return this.Army;
    }
}
