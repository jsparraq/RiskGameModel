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
        
        Territory territory1 = new Territory("OEKRAINË","WHITE",0,false);
        Territory territory2 = new Territory("IJSLAND","WHITE",0,false);
        Territory territory3 = new Territory("SCANDINAVIË","WHITE",0,false);
        Territory territory4 = new Territory("WEST-EUROPA","WHITE",0,false);
        Territory territory5 = new Territory("GROOT-BRITTANIË","WHITE",0,false);
        Territory territory6 = new Territory("ZUID-EUROPA","WHITE",0,false);
        Territory territory7 = new Territory("NOORD-EUROPA","WHITE",0,false);
        Continent continent1 = new Continent("UIROPA","WHITE",7,new Territory[]{territory1,territory2,territory3,territory4,territory5,territory6,territory7});
        
        Territory territory8 = new Territory("VARENIGDE-STATEM(OOST)","WHITE",0,false);
        Territory territory9 = new Territory("VARENIGDE-STATEM(WEST)","WHITE",0,false);
        Territory territory10 = new Territory("NORTHWEST-TERRITORIES","WHITE",0,false);
        Territory territory11 = new Territory("ALBERTA","WHITE",0,false);
        Territory territory12 = new Territory("MIDDEN-AMERIKA","WHITE",0,false);
        Territory territory13 = new Territory("ALASKA","WHITE",0,false);
        Territory territory14 = new Territory("ONTARIO","WHITE",0,false);
        Territory territory15 = new Territory("QUEBEC","WHITE",0,false);
        Territory territory16 = new Territory("GROENLAND","WHITE",0,false);
        Continent continent2 = new Continent("AMEROKI","WHITE",9,new Territory[]{territory8,territory9,territory10,territory11,territory12,territory13,territory14,territory15,territory16});
        
        Territory territory17 = new Territory("SIBERIË","WHITE",0,false);
        Territory territory18 = new Territory("IRKOETSK","WHITE",0,false);
        Territory territory19 = new Territory("INDIA","WHITE",0,false);
        Territory territory20 = new Territory("JAPON","WHITE",0,false);
        Territory territory21 = new Territory("JAKOETSK","WHITE",0,false);
        Territory territory22 = new Territory("MONGOLOË","WHITE",0,false);
        Territory territory23 = new Territory("CHINA","WHITE",0,false);
        Territory territory24 = new Territory("MIDDEN-OOSTEN","WHITE",0,false);
        Territory territory25 = new Territory("ZEIDOOST-AZIË","WHITE",0,false);
        Territory territory26 = new Territory("KAMTAJARKA","WHITE",0,false);
        Territory territory27 = new Territory("AFGHANISTAN","WHITE",0,false);
        Continent continent3 = new Continent("AZIO","WHITE",10,new Territory[]{territory17,territory18,territory19,territory20,territory21,territory22,territory23,territory24,territory25,territory26,territory27});
        
        Territory territory28 = new Territory("NIEUW-GUINEA","WHITE",0,false);
        Territory territory29 = new Territory("INDONESIË","WHITE",0,false);
        Territory territory30 = new Territory("WEST-AUSTRALIË","WHITE",0,false);
        Territory territory31 = new Territory("OOST-AUSTRALIË","WHITE",0,false);
        Continent continent4 = new Continent("UISTRALIA","WHITE",4,new Territory[]{territory28,territory29,territory30,territory31});
        
        Territory territory32 = new Territory("ZUID-AFRIKA","WHITE",0,false);
        Territory territory33 = new Territory("CENTRAAL-AFRIKA","WHITE",0,false);
        Territory territory34 = new Territory("OOST-AFRIKA","WHITE",0,false);
        Territory territory35 = new Territory("NOORD-AFRIKA","WHITE",0,false);
        Territory territory36 = new Territory("EGYPTE","WHITE",0,false);
        Territory territory37 = new Territory("MADAGASCAR","WHITE",0,false);
        Continent continent5 = new Continent("AFROKI","WHITE",2,new Territory[]{territory32,territory33,territory34,territory35,territory36,territory37});
        
        Territory territory38 = new Territory("BRASILIË","WHITE",0,false);
        Territory territory39 = new Territory("PERU","WHITE",0,false);
        Territory territory40 = new Territory("VENEZUELA","WHITE",0,false);
        Territory territory41 = new Territory("ARGENTINË","WHITE",0,false);
        Continent continent6 = new Continent("AMERPOLU","WHITE",2,new Territory[]{territory38,territory39,territory40,territory41});
       
        
        Card card1 = new Card("STANDARD","WHITE","Infantry",territory1);
        Card card2 = new Card("STANDARD","WHITE","Cavalry",territory2);
        Card card3 = new Card("STANDARD","WHITE","Artillery",territory3);
        Card card4 = new Card("STANDARD","WHITE","Infantry",territory4);
        Card card5 = new Card("STANDARD","WHITE","Cavalry",territory5);
        Card card6 = new Card("STANDARD","WHITE","Artillery",territory6);
        Card card7 = new Card("STANDARD","WHITE","Infantry",territory7);
        Card card8 = new Card("STANDARD","WHITE","Infantry",territory8);
        Card card9 = new Card("STANDARD","WHITE","Cavalry",territory9);
        Card card10 = new Card("STANDARD","WHITE","Artillery",territory10);
        Card card11 = new Card("STANDARD","WHITE","Infantry",territory11);
        Card card12 = new Card("STANDARD","WHITE","Cavalry",territory12);
        Card card13 = new Card("STANDARD","WHITE","Artillery",territory13);
        Card card14 = new Card("STANDARD","WHITE","Infantry",territory14);
        Card card15 = new Card("STANDARD","WHITE","Cavalry",territory15);
        Card card16 = new Card("STANDARD","WHITE","Artillery",territory16);
        Card card17 = new Card("STANDARD","WHITE","Infantry",territory17);
        Card card18 = new Card("STANDARD","WHITE","Cavalry",territory18);
        Card card19 = new Card("STANDARD","WHITE","Artillery",territory19);
        Card card20 = new Card("STANDARD","WHITE","Infantry",territory20);
        Card card21 = new Card("STANDARD","WHITE","Cavalry",territory21);
        Card card22 = new Card("STANDARD","WHITE","Artillery",territory22);
        Card card23 = new Card("STANDARD","WHITE","Infantry",territory23);
        Card card24 = new Card("STANDARD","WHITE","Cavalry",territory24);
        Card card25 = new Card("STANDARD","WHITE","Artillery",territory25);
        Card card26 = new Card("STANDARD","WHITE","Infantry",territory26);
        Card card27 = new Card("STANDARD","WHITE","Cavalry",territory27);
        Card card28 = new Card("STANDARD","WHITE","Artillery",territory28);
        Card card29 = new Card("STANDARD","WHITE","Infantry",territory29);
        Card card30 = new Card("STANDARD","WHITE","Cavalry",territory30);
        Card card31 = new Card("STANDARD","WHITE","Artillery",territory31);
        Card card32 = new Card("STANDARD","WHITE","Infantry",territory32);
        Card card33 = new Card("STANDARD","WHITE","Cavalry",territory33);
        Card card34 = new Card("STANDARD","WHITE","Artillery",territory34);
        Card card35 = new Card("STANDARD","WHITE","Infantry",territory35);
        Card card36 = new Card("STANDARD","WHITE","Cavalry",territory36);
        Card card37 = new Card("STANDARD","WHITE","Artillery",territory37);
        Card card38 = new Card("STANDARD","WHITE","Infantry",territory38);
        Card card39 = new Card("STANDARD","WHITE","Cavalry",territory39);
        Card card40 = new Card("STANDARD","WHITE","Artillery",territory40);
        Card card41 = new Card("STANDARD","WHITE","Infantry",territory41);
        Card card42 = new Card("STANDARD","WHITE","Cavalry",null);
        Card card43 = new Card("STANDARD","WHITE","Artillery",null);
        
        Card[] cards = new Card[]{card1,card2,card3,card4,card5,card6,card7,card8,card9,card10,card11,card12,card13,card14,card15,card16,card17,card18,card19,card20,card21,card22,card23,card24,card25,card26,card27,card28,card29,card30,card31,card32,card33,card34,card35,card36,card37,card37,card38,card39,card40,card41,card42,card43};
        
        Territory[] A = new Territory[]{territory1,territory2,territory2,territory3,territory3,territory4,territory4,territory5,territory5,territory6,territory6,territory7,territory7,territory1};
        Territory[] B = new Territory[]{territory2,territory1,territory3,territory2,territory4,territory3,territory5,territory4,territory6,territory5,territory7,territory6,territory1,territory7};
        Boundary boundary = new Boundary(1,A,B);
        Session session = new Session(1,"TWO PLACE ARMY",players,new Map("Classic",new Continent[]{continent1,continent2,continent3,continent4,continent5,continent6},new Card[]{card1,card2,card3,card4,card5,card6,card7},boundary),"RISK_FOR_TWO_PLAYERS");
        AcceptTurnManager acceptTurnManager = new AcceptTurnManager(session);
    }
    
}
