/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package riskgamemodel;

import java.util.ArrayList;

/**
 *
 * @author Sebastian
 */
public class Session {
    private static Session session;
    private int ID;
    private String State;
    private Player[] players;
    private Map map;
    
    private Session(){}
    
    public Session(int id, String state,Player[] Players, Map map1){
        ID = id;
        State = state;
        players = Players;
        map = map1;
    }
    
    
    public void setID(int value){
        this.ID = value;
    }
    
    public int getID(){
        return ID;
    }
    
    public void setStete(String value){
        this.State = value;
    }
    public String getState(){
        return State;
    }
    
    public Player[] getPlayers(){
        return players;
    }
    
    public Map getMap(){
        return this.map;
    }
}
