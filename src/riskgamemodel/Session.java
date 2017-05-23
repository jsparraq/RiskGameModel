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
            Player player1 = new Player(false,"non-capture","RED",1,2,0);
            Player player2 = new Player(true,"non-capture","BLUE",4,2,0);
            Player player3 = new Player(false,"non-capture","GREEN",1,1,0);
            Player player4 = new Player(false,"non-capture","PURPLE",1,0,0);
            Player[] players = new Player[]{player1,player2,player3,player4};
            Territory territory1 = new Territory("A","BLUE",3,new Attack[]{});
            Territory territory2 = new Territory("B","RED",3,new Attack[]{});
            Territory territory3 = new Territory("C","RED",3,new Attack[]{});
            Territory territory4 = new Territory("D","RED",3,new Attack[]{});
            Territory territory5 = new Territory("E","RED",3,new Attack[]{});
            Territory territory6 = new Territory("F","GREEN",3,new Attack[]{});
            Territory territory7 = new Territory("G","PURPLE",3,new Attack[]{});
            Continent continent1 = new Continent("ContinentA","WHITE",3,new Territory[]{territory1,territory2,territory3});
            Continent continent2 = new Continent("ContinentB","WHITE",2,new Territory[]{territory3,territory4});
            Continent continent3 = new Continent("ContinentC","WHITE",2,new Territory[]{territory5,territory5});
            Card card1 = new Card("STANDARD",1,"BLUE","Infantry",territory1);
            Card card2 = new Card("STANDARD",2,"BLUE","Cavalry",territory2);
            Card card3 = new Card("STANDARD",3,"RED","Artillery",territory3);
            Card card4 = new Card("STANDARD",4,"RED","Infantry",territory4);
            Card card5 = new Card("STANDARD",5,"GREEN","Cavalry",territory5);
            Card card6 = new Card("STANDARD",6,"WHITE","Artillery",territory6);
            Card card7 = new Card("STANDARD",7,"WHITE","Infantry",territory7);
            Boundary boundary = new Boundary(1,new Territory[]{territory1,territory2,territory3,territory4,territory5,territory6,territory7},new Territory[]{territory2,territory3,territory4,territory5,territory6,territory7,territory1});
            session = new Session(1,"Run",players,new Map("ameroki_pic2",new Continent[]{continent1,continent2,continent3},new Card[]{card1,card2,card3,card4,card5,card6,card7},boundary));
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
