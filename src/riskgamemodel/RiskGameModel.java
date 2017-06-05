/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package riskgamemodel;
import Controller.AcceptTurnManager;

/**
 *
 * @author Sebastian
 */
public class RiskGameModel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Player player1 = new Player(true,true,"non-capture","BLUE",0,0,0,2,0);
        Player player2 = new Player(false,true,"non-capture","RED",0,0,0,2,0);
        Player player3 = new Player(false,true,"non-capture","GREEN",0,0,0,2,0);
        Player[] players = new Player[]{player1,player2,player3};
        Territory territory1 = new Territory("A","WHITE",0,false);
        Territory territory2 = new Territory("B","WHITE",0,false);
        Territory territory3 = new Territory("C","WHITE",0,false);
        Territory territory4 = new Territory("D","WHITE",0,false);
        Territory territory5 = new Territory("E","WHITE",0,false);
        Territory territory6 = new Territory("F","WHITE",0,false);
        Territory territory7 = new Territory("G","WHITE",0,false);
        Continent continent1 = new Continent("ContinentA","WHITE",3,new Territory[]{territory1,territory2,territory3});
        Continent continent2 = new Continent("ContinentB","WHITE",2,new Territory[]{territory5,territory4});
        Continent continent3 = new Continent("ContinentC","WHITE",2,new Territory[]{territory6,territory7});
        Card card1 = new Card("STANDARD","WHITE","Infantry",territory1);
        Card card2 = new Card("STANDARD","WHITE","Cavalry",territory2);
        Card card3 = new Card("STANDARD","WHITE","Artillery",territory3);
        Card card4 = new Card("STANDARD","WHITE","Infantry",territory4);
        Card card5 = new Card("STANDARD","WHITE","Cavalry",territory5);
        Card card6 = new Card("STANDARD","WHITE","Artillery",territory6);
        Card card7 = new Card("STANDARD","WHITE","Infantry",territory7);
        Territory[] A = new Territory[]{territory1,territory2,territory2,territory3,territory3,territory4,territory4,territory5,territory5,territory6,territory6,territory7,territory7,territory1};
        Territory[] B = new Territory[]{territory2,territory1,territory3,territory2,territory4,territory3,territory5,territory4,territory6,territory5,territory7,territory6,territory1,territory7};
        Boundary boundary = new Boundary(1,A,B);
        Session session = new Session(1,"TWO PLACE ARMY",players,new Map("Classic",new Continent[]{continent1,continent2,continent3},new Card[]{card1,card2,card3,card4,card5,card6,card7},boundary),"RISK_FOR_TWO_PLAYERS");
        AcceptTurnManager acceptTurnManager = new AcceptTurnManager(session);
    }
    
}
