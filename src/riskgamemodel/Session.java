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
    private ArrayList<Player> players;
    private Map Map;
    
    private Session(){}
    
    public static Session getSession(){
        if(session == null){
            session= new Session();
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
}
