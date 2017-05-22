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
    
    private Session(int id, String state,Player[] Players, Map map1){
        ID = id;
        State = state;
        players = Players;
        map = map1;
    }
    
    public static Session getSession(){
        if(session == null){
            Player player1 = new Player(true,"non-capture","BLUE",2,3,0);
            Player player2 = new Player(false,"non-capture","RED",4,2,0);
            Player player3 = new Player(false,"non-capture","GREEN",1,3,0);
            Player player4 = new Player(false,"non-capture","PURPLE",1,3,0);
            Player[] players = new Player[]{player1,player2,player3,player4};
            session = new Session();
        }
        return session;
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
